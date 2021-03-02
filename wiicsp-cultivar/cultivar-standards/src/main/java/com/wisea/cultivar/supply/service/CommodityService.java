package com.wisea.cultivar.supply.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Queues;
import com.wisea.cloud.common.exception.VerifyException;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.constants.DictConstants;
import com.wisea.cultivar.common.dao.*;
import com.wisea.cultivar.common.entity.CommMage;
import com.wisea.cultivar.common.entity.LevelSpecQuote;
import com.wisea.cultivar.common.entity.MeasUnitMage;
import com.wisea.cultivar.common.entity.ZhfwCommAttri;
import com.wisea.cultivar.common.mss.RemoteCommMageMss;
import com.wisea.cultivar.common.po.CommMageSearchPo;
import com.wisea.cultivar.common.po.product.CommMageTreePo;
import com.wisea.cultivar.common.utils.tp.CodeUtils;
import com.wisea.cultivar.common.vo.CommCurrencyInfoInfoVo;
import com.wisea.cultivar.common.vo.EntpCommPubExamTypeVo;
import com.wisea.cultivar.common.vo.product.CommAttriMageListVo;
import com.wisea.cultivar.common.vo.product.ZhfwCommMageTreeVo;
import com.wisea.cultivar.constants.QdcyStandardsDict;
import com.wisea.cultivar.constants.QdcyStandardsError;
import com.wisea.cultivar.supply.entity.ZhfwCommPubInfo;
import com.wisea.cultivar.supply.enums.PubCommCheckEnum;
import com.wisea.cultivar.supply.mapper.ZhfwCommPubInfoMapper;
import com.wisea.cultivar.supply.po.*;
import com.wisea.cultivar.supply.util.CustomUtils;
import com.wisea.cultivar.supply.vo.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

/**
 * 商品service
 * @author chengq
 * @date 2020/8/13 14:08
 */
@Service
public class CommodityService {

    @Resource
    private ZhfwCommPubInfoMapper zhfwCommPubInfoMapper;

    @Resource
    private ZhfwCommPictureService zhfwCommPictureService;

    @Resource
    private ZhfwCommAttriService zhfwCommAttriService;

    @Resource(name = "NbLevelSpecQuoteMapper")
    private LevelSpecQuoteMapper levelSpecQuoteMapper;

    @Resource(name = "NbMeasUnitMageMapper")
    private MeasUnitMageMapper measUnitMageMapper;

    @Resource(name = "NbCommAttriSetMapper")
    private CommAttriSetMapper commAttriSetMapper;

    @Resource
    private CommCurrencyInfoMapper commCurrencyInfoMapper;

    @Resource
    private RemoteCommMageMss remoteCommMageMss;

    @Resource(name = "NbCommMageMapper")
    private CommMageMapper commMageMapper;

    /**
     * 人民币符号
     */
    private static final String RMB_SYMBOL = "¥";

    /**
     * 分隔符
     */
    private static final String DELIMITER = ",";

    /**
     * 保留小数位
     */
    public final static ThreadLocal<DecimalFormat> df = ThreadLocal.withInitial(() -> new DecimalFormat("##0.00"));

    /**
     * 产品列表
     * @return 产品列表
     */
    public ResultPoJo<Page<ShopCommodityVo>> findCommodityList(CommodityListPo commodityListPo) {
        //获取登录的用户
        User user = SystemUtils.getUserOnlyId();
        commodityListPo.setMembId(user.getId());
        //产品列表
        List<ShopCommodityVo> vo = zhfwCommPubInfoMapper.findCommodityList(commodityListPo);
        if (ConverterUtil.isEmpty(vo)) {
            return CustomUtils.result(commodityListPo.getPage());
        }
        //取区间价格
        vo.forEach(commodity -> {
            String priceAll = commodity.getPrice();
            String[] prices = priceAll.split(DELIMITER);
            commodity.setLowestPrice(prices[prices.length-1]);
            commodity.setHighestPrice(prices[0]);
            if (ConverterUtil.isNotEmpty(priceAll)) {
                //设置价格并保留两位小数
                commodity.setPrice(priceBreak(priceAll));
            }
        });
        //封装返回
        Page<ShopCommodityVo> page = commodityListPo.getPage();
        page.setList(vo);
        return CustomUtils.result(page);
    }

    /**
     * 保存商品信息
     */
    @Transactional
    public ResultPoJo<CommSaveVo> saveComm(CommoditySavePo commoditySavePo) {
        //检查商品名称
//        checkCommTitle(commoditySavePo);
        //价格检查
        checkCommPrice(commoditySavePo);
        //上架修改时不能修改的参数验证
        checkUpShelf(commoditySavePo);
        //设置用户信息
        User user = SystemUtils.getUserOnlyId();
        commoditySavePo.setMembId(user.getId());
        //设置发货详细地址
        commoditySavePo.initCommSendAddr();
        //保存商品表信息
        if (ConverterUtil.isEmpty(commoditySavePo.getId())) {
            insert(commoditySavePo);
        }else {
            update(commoditySavePo);
        }
        //设置图片
        zhfwCommPictureService.saveCommPicture(commoditySavePo);
        //设置属性
        zhfwCommAttriService.saveCommAttri(commoditySavePo);
        //设置价格
        saveLevelSpecQuote(commoditySavePo);
        //是否需要审核（仅新增时使用此值）
        String check = findIsCheck().equals(QdcyStandardsDict.COMM_STATE_TYPE_0) ? QdcyStandardsDict.ENTP_COMM_PUB_EXAM_TYPE_1 : QdcyStandardsDict.ENTP_COMM_PUB_EXAM_TYPE_0;
        //封装返回
        return CustomUtils.result(new CommSaveVo(commoditySavePo.getId().toString(), check));
    }

    /**
     * 上架参数检查
     * @param commoditySavePo 保存的参数
     */
    private void checkUpShelf(CommoditySavePo commoditySavePo) {
        //新增时不做校验
        Long id = commoditySavePo.getId();
        if (Objects.isNull(id)) {
            return;
        }
        //修改上架时验证品种分类id是否发生改变
        if (Objects.equals(commoditySavePo.getCommStateType(), "2")) {
            ZhfwCommPubInfo zhfwCommPubInfo = zhfwCommPubInfoMapper.selectByPrimaryKey(id);
            if (commoditySavePo.getCommId().longValue() != zhfwCommPubInfo.getCommId().longValue()) {
                throw new VerifyException(QdcyStandardsError.ERR_10016, QdcyStandardsError.MSG_10016);
            }
        }
    }

    /**
     * 价格检查
     */
    private void checkCommPrice(CommoditySavePo commoditySavePo) {
        //数量是否正序
        List<CommPricePo> commPricePo = commoditySavePo.getPriceUnit().getPrices();
        List<Integer> nums = commPricePo.stream().map(CommPricePo::getNum).collect(Collectors.toList());
        LinkedBlockingQueue<Integer> numQueue = Queues.newLinkedBlockingQueue(nums.stream().sorted().collect(Collectors.toList()));
        nums.forEach(num -> {
            if (num.compareTo(Objects.requireNonNull(numQueue.poll())) != 0) {
                throw new VerifyException(QdcyStandardsError.ERR_10014, QdcyStandardsError.MSG_10014);
            }
        });
        //检查价格是否倒叙
        List<Double> prices = commPricePo.stream().map(CommPricePo::getPrice).collect(Collectors.toList());
        LinkedBlockingQueue<Double> priceQueue = Queues.newLinkedBlockingQueue(prices.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
        prices.forEach(price -> {
            if (price.compareTo(Objects.requireNonNull(priceQueue.poll())) != 0) {
                throw new VerifyException(QdcyStandardsError.ERR_10015, QdcyStandardsError.MSG_10015);
            }
        });

    }

    /**
     * 保存等级规格报价
     * @param commoditySavePo 保存的信息
     */
    @Transactional
    public void saveLevelSpecQuote(CommoditySavePo commoditySavePo) {
        //删除原价格
        List<LevelSpecQuote> listByCommPubId = levelSpecQuoteMapper.findListByCommPubId(commoditySavePo.getId());
        listByCommPubId.forEach(level -> levelSpecQuoteMapper.deleteLogicByPrimaryKey(level.getId()));
        //新增价格
        LevelSpecQuote levelSpecQuote = new LevelSpecQuote();
        //发布的产品id
        levelSpecQuote.setCommPubId(commoditySavePo.getId());
        CommPriceUnitPo priceUnit = commoditySavePo.getPriceUnit();
        //计量单位
        levelSpecQuote.setMeasUnitId(priceUnit.getUnitId());
        //价格表达式按照300,200,100分隔
        DecimalFormat decimalFormat = df.get();
        List<CommPricePo> prices = priceUnit.getPrices();
        String priceExpres = prices.stream()
                .map(price -> decimalFormat.format(price.getPrice()))
                .collect(Collectors.joining(DELIMITER));
        levelSpecQuote.setPriceExpres(priceExpres);
        //起订区间表达式
        List<Integer> nums = prices.stream().map(CommPricePo::getNum).collect(Collectors.toList());
        levelSpecQuote.setStartOrdExpres(startOrdExpres(nums));
        //成交金额
        levelSpecQuote.setTransactionAmount(0D);
        //销量
        levelSpecQuote.setSalesVolume(0D);
        levelSpecQuote.preInsert();
        //保存
        levelSpecQuoteMapper.insert(levelSpecQuote);
    }

    /**
     * 拼接起订区间表达式
     * @param nums 数量
     * @return 起订区间表达式
     */
    private String startOrdExpres(List<Integer> nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.size(); i++) {
            Integer startNum = nums.get(i);
            String endNum = "";
            int y = i;
            if (++y < nums.size()) {
                endNum = "~" + (nums.get(y) - 1) + DELIMITER;
            }
            sb.append(startNum).append(endNum);
        }
        return sb.toString();
    }

    /**
     * 保存到商品表
     */
    @Transactional
    public void insert(CommoditySavePo commoditySavePo) {
        ZhfwCommPubInfo zhfwCommPubInfo = new ZhfwCommPubInfo();
        ConverterUtil.copyProperties(commoditySavePo, zhfwCommPubInfo);
        zhfwCommPubInfo.setSalesVolume(0D);
        zhfwCommPubInfo.setRejectReason("");
        zhfwCommPubInfo.setCommSendCity(commoditySavePo.getCommSendCityId());
        zhfwCommPubInfo.setCommSendProv(commoditySavePo.getCommSendProvId());
        zhfwCommPubInfo.setCommSendCou(commoditySavePo.getCommSendCouId());
        zhfwCommPubInfo.setCommNum(CodeUtils.generateCommPubInfoCode());
        zhfwCommPubInfo.setZhfwCommStateType(commoditySavePo.getCommStateType());
        //不是草稿时判断是否需要审核
        if (!Objects.equals(commoditySavePo.getCommStateType(), QdcyStandardsDict.COMM_STATE_TYPE_1)) {
            zhfwCommPubInfo.setZhfwCommStateType(findIsCheck());
        }
        zhfwCommPubInfo.preInsert();
        zhfwCommPubInfoMapper.insert(zhfwCommPubInfo);
        commoditySavePo.setId(zhfwCommPubInfo.getId());
    }

    /**
     * 修改商品
     */
    @Transactional
    public void update(CommoditySavePo commoditySavePo) {
        ZhfwCommPubInfo zhfwCommPubInfo = new ZhfwCommPubInfo();
        ZhfwCommPubInfo oldCommPubInfo = zhfwCommPubInfoMapper.selectByPrimaryKey(commoditySavePo.getId());
        if (Objects.isNull(oldCommPubInfo)) {
            throw new VerifyException(QdcyStandardsError.MSG_80002, QdcyStandardsError.MSG_80002);
        }
        //默认与原状态相同
        if(Objects.equals(commoditySavePo.getCommStateType(), "2")
                && !Objects.equals(oldCommPubInfo.getZhfwCommStateType(), QdcyStandardsDict.COMM_STATE_TYPE_0)) {//上架，销售中的状态不变
            zhfwCommPubInfo.setZhfwCommStateType(findIsCheck());
        }
        ConverterUtil.copyProperties(commoditySavePo, zhfwCommPubInfo, "commSendProv", "commSendCity", "commSendCou","commNum");
        //省市县字段名称不同
        zhfwCommPubInfo.setCommSendProv(commoditySavePo.getCommSendProvId());
        zhfwCommPubInfo.setCommSendCou(commoditySavePo.getCommSendCouId());
        zhfwCommPubInfo.setCommSendCity(commoditySavePo.getCommSendCityId());
        zhfwCommPubInfo.preUpdate();
        zhfwCommPubInfoMapper.updateByPrimaryKeySelective(zhfwCommPubInfo);
    }

//    /**
//     * 检查商品名称
//     * @param commoditySavePo 商品
//     */
//    private void checkCommTitle(CommoditySavePo commoditySavePo) {
//        //检测商品名称是否重复
//        ZhfwCommPubInfo zhfwCommPubInfo = zhfwCommPubInfoMapper.selectByCommTitle(commoditySavePo.getCommTitle());
//        if (Objects.nonNull(zhfwCommPubInfo)) {
//            if (Objects.isNull(commoditySavePo.getId()) || commoditySavePo.getId().longValue() != zhfwCommPubInfo.getId()) {
//                throw new VerifyException(QdcyStandardsError.ERR_10004, QdcyStandardsError.MSG_10004);
//            }
//        }
//    }

    /**
     * 删除商品
     * @param commodityDeletePo 商品id
     */
    @Transactional
    public ResultPoJo<Object> deleteCommodity(CommodityDeletePo commodityDeletePo) {
        zhfwCommPubInfoMapper.deleteLogicByPrimaryKey(commodityDeletePo.getId());
        return CustomUtils.result();
    }

    /**
     * 修改回显商品信息
     */
    public ResultPoJo<CommodityEchoVo> getCommodityEcho(CommodityGetPo commodityGetPo) {
        CommodityEchoVo commodityEchoVo = zhfwCommPubInfoMapper.getCommodityInfo(commodityGetPo);
        if (Objects.isNull(commodityEchoVo)) {
            throw new VerifyException(QdcyStandardsError.ERR_10006, QdcyStandardsError.MSG_10006);
        }
        Long commPubId = commodityGetPo.getId();
        //查询主图片
        commodityEchoVo.setMainPicture(zhfwCommPictureService.findByCommPubId(commodityGetPo.getId(), DictConstants.COMM_PICTURE_TYPE_0));
        //查询详情图片
        commodityEchoVo.setDetailsPicture(zhfwCommPictureService.findByCommPubId(commodityGetPo.getId(), DictConstants.COMM_PICTURE_TYPE_1));
        //设置属性、属性id
        commodityEchoVo.setCommAttri(zhfwCommAttriService.findCommAttri(commPubId));
        commodityEchoVo.setAttris(zhfwCommAttriService.findCommAttriPo(commPubId));
        //查询价格
        String priceBreak = priceBreak(commodityEchoVo.getPrice());
        commodityEchoVo.setPrice(priceBreak + "元");
        //设置价格详情
        commodityEchoVo.setPriceUnit(priceConversion(commPubId));
        return CustomUtils.result(commodityEchoVo);
    }

    /**
     * 通过商品id查询价格
     * @param commPubId 商品id
     */
    private CommPriceUnitPo priceConversion(Long commPubId) {
        //查询价格等级
        LevelSpecQuote levelSpecQuote = getLevelSpecQuote(commPubId);
        //设置价格
        List<CommPricePo> commPricePos = priceSplit(levelSpecQuote);
        //设置数量 10~49,50~99,100转换成[10,50,100]
        List<Integer> nums = Arrays.stream(levelSpecQuote.getStartOrdExpres().split(DELIMITER))
                .map(num -> Integer.valueOf(num.split("[~-]")[0])).collect(Collectors.toList());
        //合并
        for (int i = 0; i < commPricePos.size(); i++) {
            commPricePos.get(i).setNum(nums.get(i));
        }
        return new CommPriceUnitPo(levelSpecQuote.getMeasUnitId(), commPricePos);
    }

    /**
     * 拆分价格
     */
    private List<CommPricePo> priceSplit(LevelSpecQuote levelSpecQuote) {
        String priceExpres = levelSpecQuote.getPriceExpres();
        if (Objects.isNull(priceExpres)) {
            return Lists.newArrayList();
        }
        return Arrays.stream(priceExpres.split(DELIMITER))
                .map(price -> {
                    CommPricePo commPricePo = new CommPricePo();
                    commPricePo.setPrice(Double.valueOf(price));
                    return commPricePo;
                }).collect(Collectors.toList());
    }

    /**
     * 拼接价格最大和最小
     * @param priceAll 按照逗号分隔的价格
     */
    private String priceBreak(String priceAll) {
        if (ConverterUtil.isEmpty(priceAll)){
            return "";
        }
        String[] prices = priceAll.split(DELIMITER);
        String endPrice = prices[0];
        String price = RMB_SYMBOL + df.get().format(Double.valueOf(endPrice));
        if (prices.length > 1) {
            String startPrice = prices[prices.length - 1];
            price = RMB_SYMBOL + df.get().format(Double.valueOf(startPrice)) + "-" + price;
        }
        return price;
    }

    /**
     * 商品上/下架
     */
    public ResultPoJo<Object> updateStatus(CommodityStatusUpdatePo statusUpdate) {
        ZhfwCommPubInfo zhfwCommPubInfo = zhfwCommPubInfoMapper.selectByPrimaryKey(statusUpdate.getId());
        if (Objects.isNull(zhfwCommPubInfo)) {
            throw new VerifyException(QdcyStandardsError.ERR_10006, QdcyStandardsError.MSG_10006);
        }

        //判断状态是否符合规则，不能修改审核中、被驳回的商品
        if (Objects.equals(zhfwCommPubInfo.getZhfwCommStateType(), QdcyStandardsDict.COMM_STATE_TYPE_2)
                || Objects.equals(zhfwCommPubInfo.getZhfwCommStateType(), QdcyStandardsDict.COMM_STATE_TYPE_4)) {
            throw new VerifyException(QdcyStandardsError.ERR_10009, QdcyStandardsError.MSG_10009);
        }

        //状态是销售中的改为已下架
        if (Objects.equals(zhfwCommPubInfo.getZhfwCommStateType(), QdcyStandardsDict.COMM_STATE_TYPE_0)) {
            zhfwCommPubInfo.setZhfwCommStateType(QdcyStandardsDict.COMM_STATE_TYPE_3);
        }else {
            //修改状态，根据是否需要审核来修改状态
            zhfwCommPubInfo.setZhfwCommStateType(findIsCheck());
        }
        zhfwCommPubInfo.preUpdate();
        zhfwCommPubInfoMapper.updateByPrimaryKey(zhfwCommPubInfo);
        return CustomUtils.result();
    }

    /**
     * 查询要修改的价格列表
     * @param commodityGetPo 商品id
     * @return 价格列表
     */
    public ResultPoJo<List<PriceUpdateVo>> findPrice(CommodityGetPo commodityGetPo) {
        //查询价格等级
        LevelSpecQuote levelSpecQuote = getLevelSpecQuote(commodityGetPo.getId());
        //查询单位
        MeasUnitMage measUnitMage = measUnitMageMapper.selectByPrimaryKey(levelSpecQuote.getMeasUnitId());
        //拆分价格
        String[] prices = levelSpecQuote.getPriceExpres().split(DELIMITER);
        //价格转换
        List<PriceUpdateVo> vo = Arrays.stream(prices)
                .map(price -> new PriceUpdateVo(Double.valueOf(price), ConverterUtil.isNotEmpty(measUnitMage)? measUnitMage.getMeasUnitName() : ""))
                .collect(Collectors.toList());
        //设置数量区间
        String[] nums = levelSpecQuote.getStartOrdExpres().split(DELIMITER);
        for (int i = 0; i < nums.length; i++) {
            String num = nums[i].replace("~", "-");
            if (i == (nums.length -1)) {
                num = "≥" + num;
            }
            vo.get(i).setNum(num);
        }
        return CustomUtils.result(vo);
    }

    /**
     * 查询价格等级
     * @param commPubId 商品id
     */
    private LevelSpecQuote getLevelSpecQuote(Long commPubId) {
        List<LevelSpecQuote> levelSpecQuotes = levelSpecQuoteMapper.findListByCommPubId(commPubId);
        if (ConverterUtil.isEmpty(levelSpecQuotes)) {
            return new LevelSpecQuote();
        }
        return levelSpecQuotes.get(0);
    }

    /**
     * 保存商品价格
     * @param priceSavePo 价格
     */
    public ResultPoJo<Object> savePrice(CommodityPriceSavePo priceSavePo) {
        //查询价格等级
        LevelSpecQuote levelSpecQuote = getLevelSpecQuote(priceSavePo.getId());
        List<Double> prides = priceSavePo.getPrides();
        if (levelSpecQuote.getPriceExpres().split(DELIMITER).length != prides.size()) {
            throw new VerifyException(QdcyStandardsError.ERR_10010, QdcyStandardsError.MSG_10010);
        }
        levelSpecQuote.setPriceExpres(prides.stream().map(String::valueOf).collect(Collectors.joining(DELIMITER)));
        levelSpecQuote.preUpdate();
        levelSpecQuoteMapper.updateByPrimaryKey(levelSpecQuote);
        return CustomUtils.result();
    }

    /**
     * 商品详情
     */
    public ResultPoJo<CommodityDetailsVo> getCommodityDetails(CommodityGetPo commodityGetPo) {
        CommodityDetailsVo vo = zhfwCommPubInfoMapper.getCommodityDetails(commodityGetPo);
        //查询主图片
        vo.setMainPicture(zhfwCommPictureService.findByCommPubId(commodityGetPo.getId(), DictConstants.COMM_PICTURE_TYPE_0));
        //查询详情图片
        vo.setDetailsPicture(zhfwCommPictureService.findByCommPubId(commodityGetPo.getId(), DictConstants.COMM_PICTURE_TYPE_1));
        //商品属性
        vo.setAttris(zhfwCommAttriService.findCommAttriPo(commodityGetPo.getId()));
        //商品通用服务须知
        vo.setCurrentNotesToBuy(currInfo().getResult().getCommCurrencyContent());
        //价格
        List<PriceUpdateVo> result = findPrice(commodityGetPo).getResult();
        DecimalFormat decimalFormat = df.get();
        List<CommPriceVo> prices = result.stream().map(price -> {
            CommPriceVo commPriceVo = new CommPriceVo();
            commPriceVo.setNum(price.getNum() + vo.getUnit());
            commPriceVo.setPrice(RMB_SYMBOL + decimalFormat.format(price.getPrice()));
            return commPriceVo;
        }).collect(Collectors.toList());
        vo.setPrices(prices);
        //证书
        vo.setCerts(findCerts());
        return CustomUtils.result(vo);
    }

    /**
     * 查询证书
     */
    private List<CertVo> findCerts() {
        User user = SystemUtils.getUserOnlyId();
        return zhfwCommPubInfoMapper.findCerts(user.getId());
    }

    /**
     * 商品状态数量
     */
    public ResultPoJo<CommCountVo> commCount() {
        User user = SystemUtils.getUserOnlyId();
        CommCountVo commCountVo = new CommCountVo();
        commCountVo.setDraftCount(zhfwCommPubInfoMapper.selectCountByState(user.getId(), QdcyStandardsDict.COMM_STATE_TYPE_1));
        commCountVo.setPendingCount(zhfwCommPubInfoMapper.selectCountByState(user.getId(), QdcyStandardsDict.COMM_STATE_TYPE_2));
        commCountVo.setRejectedCount(zhfwCommPubInfoMapper.selectCountByState(user.getId(), QdcyStandardsDict.COMM_STATE_TYPE_4));
        commCountVo.setRemovedCount(zhfwCommPubInfoMapper.selectCountByState(user.getId(), QdcyStandardsDict.COMM_STATE_TYPE_3));
        commCountVo.setSaleCount(zhfwCommPubInfoMapper.selectCountByState(user.getId(), QdcyStandardsDict.COMM_STATE_TYPE_0));
        return CustomUtils.result(commCountVo);
    }

    /**
     * 查询父分类
     */
    public ResultPoJo<List<CommMage>> attriParent() {
        List<CommMage> parent = zhfwCommPubInfoMapper.selectAttriParent();
        return CustomUtils.result(parent);
    }

    /**
     * 查询子类
     */
    public ResultPoJo<List<CommMage>> attriChildren(Long pid) {
        List<CommMage> children = zhfwCommPubInfoMapper.selectAttriChildren(pid);
        return CustomUtils.result(children);
    }

    /**
     * 商品属性
     */
    public ResultPoJo<List<CommAttriMageListVo>> attSetList(AttSetGetPo attSetGetPo) {
        List<CommAttriMageListVo> vo = Lists.newArrayList();
        findAttriMage(attSetGetPo.getCommId(), vo);
        //去重
        List<CommAttriMageListVo> distinctVo = vo.stream().distinct().collect(Collectors.toList());
        distinctVo.forEach(mage -> {
            if (ConverterUtil.isNotEmpty(attSetGetPo.getPubId())){
                ZhfwCommAttri attri = zhfwCommAttriService.findByCommPubIdAndAttriId(attSetGetPo.getPubId(), mage.getAttriId());
                if (Objects.nonNull(attri)) {
                    mage.setDictVal(attri.getCommAttriVal());
                }
            }
        });
        return CustomUtils.result(distinctVo);
    }

    /**
     * 递归查询商品属性, 属性相加
     */
    private void findAttriMage(Long commId, List<CommAttriMageListVo> mages) {
        Map<String, Object> paramMap = Maps.newHashMap();
        paramMap.put("list", Lists.newArrayList(commId));
        List<CommAttriMageListVo> vo = commAttriSetMapper.findAttSetListByCommId(paramMap);
        if (ConverterUtil.isNotEmpty(vo)) {
            mages.addAll(vo);
        }
        CommMage commMage = zhfwCommPubInfoMapper.selectAttriById(commId);
        if (Objects.nonNull(commMage)) {
            findAttriMage(commMage.getPid(), mages);
        }
    }

    /**
     * 查询是否需要审核
     * @return 商品发布状态
     */
    public String findIsCheck() {
        EntpCommPubExamTypeVo detail = commCurrencyInfoMapper.findEntpCommPubExamType();
        return Optional.ofNullable(Optional.ofNullable(detail).orElse(new EntpCommPubExamTypeVo()).getEntpCommPubExamType())
                .map(cur -> PubCommCheckEnum.findByCheckState(cur).getPubState())
                .orElse(QdcyStandardsDict.COMM_STATE_TYPE_0);
    }

    /**
     * 查询商品分类树
     */
    public ResultPoJo<List<CommMageSearchVo>> searchMage(CommMageSearchPo commMageSearchPo) {
        //查询要过滤的分类树
        CommMageTreePo commMageTreePo = new CommMageTreePo();
        commMageTreePo.setPid(10);
        ResultPoJo<List<ZhfwCommMageTreeVo>> commMageTree = remoteCommMageMss.findCommMageTree(commMageTreePo);
        //把树中的id转成集合
        List<Long> filterMageIds = Lists.newArrayList();
        filterMageId(Optional.ofNullable(commMageTree.getResult()).orElse(Lists.newArrayList()), filterMageIds);
        filterMageIds.add(20L);
        commMageSearchPo.setFilterMageIds(filterMageIds);
        //模糊查询分类，并过滤id
        List<CommMage> commMages = commMageMapper.selectCommByName(commMageSearchPo);
        //拼接名称
        List<CommMageSearchVo> vo = commMages.stream()
                .map(mage -> {
                    String commCatgName = mage.getpCommCatgName();
                    commCatgName = ConverterUtil.isNotEmpty(commCatgName) ? commCatgName + "-" : "";
                    return new CommMageSearchVo(mage.getId(),  commCatgName + mage.getCommCatgName());
                })
                .collect(Collectors.toList());
        return CustomUtils.result(vo);
    }

    /**
     * 过滤分类的id
     */
    private void filterMageId(List<ZhfwCommMageTreeVo> mages, List<Long> filterMageIds) {
        mages.forEach(mage -> {
            filterMageIds.add(mage.getId());
            List<ZhfwCommMageTreeVo> children = mage.getChildren();
            if (ConverterUtil.isNotEmpty(children)) {
                filterMageId(children, filterMageIds);
            }
        });
    }

    /**
     * 查询通用商品须知
     */
    public ResultPoJo<CommCurrencyInfoInfoVo> currInfo() {
        return CustomUtils.result(Optional.ofNullable(commCurrencyInfoMapper.findDetail()).orElse(new CommCurrencyInfoInfoVo()));
    }

    /**
     * 查询发布状态
     */
    public ResultPoJo<String> releaseState() {
        return CustomUtils.result(findIsCheck());
    }
}
