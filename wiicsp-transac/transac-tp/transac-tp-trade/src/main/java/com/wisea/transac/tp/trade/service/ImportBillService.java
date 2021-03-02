package com.wisea.transac.tp.trade.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.redisson.RedissLockUtil;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.constants.TIMNoticeConstants;
import com.wisea.transac.common.po.product.BatchUpdSearchPo;
import com.wisea.transac.common.po.trade.*;
import com.wisea.transac.common.vo.ImportBillPriceOperateVo;
import com.wisea.transac.common.vo.ReceAddressInfoVo;
import com.wisea.transac.common.vo.seller.BaseInfoVo;
import com.wisea.transac.tp.trade.constants.OrdOperateEnum;
import com.wisea.transac.tp.trade.mss.ProductMss;
import com.wisea.transac.common.dao.*;
import com.wisea.transac.common.entity.*;
import com.wisea.transac.common.utils.*;
import com.wisea.transac.common.vo.trade.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author yangtao
 * @version 1.0
 * @className ImportBillService
 * @date 2020/04/27 17:01:29
 * @Description
 */
@Service
public class ImportBillService extends BaseService {
    @Autowired
    private ImportBillMapper mapper;
    @Autowired
    private CommPubInfoMapper commPubInfoMapper;
    @Autowired
    private LevelSpecQuoteMapper levelSpecQuoteMapper;
    @Autowired
    private MeasUnitMageMapper measUnitMageMapper;
    @Autowired
    private CommPictureMapper commPictureMapper;
    @Autowired
    private InvoInfoMapper invoInfoMapper;
    @Autowired
    private StallsMageMapper stallsMageMapper;
    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Autowired
    private OrdCommRelaMapper ordCommRelaMapper;
    @Autowired
    private OrdInvoMapper ordInvoMapper;
    @Autowired
    private OrdOpreateInfoService ordOpreateInfoService;
    @Autowired
    private MerchantMembMageMapper merchantMembMageMapper;
    @Autowired
    private BaseInfoMapper baseInfoMapper;
    @Autowired
    private LocalityOrderInfoMapper localityOrderInfoMapper;
    @Autowired
    private LocalityOrdCommRelaMapper localityOrdCommRelaMapper;
    @Autowired
    private LocalityOrdInvoMapper localityOrdInvoMapper;
    @Autowired
    private PlaceOriginMageMapper placeOriginMageMapper;
    @Autowired
    private TimSendService timSendService;
    @Autowired
    private ProductMss productMss;
    @Autowired
    private ReceAddressMapper receAddressMapper;
    @Autowired
    private LocalityOrdOpreateInfoService localityOrdOpreateInfoService;

    /**
     * 商品加入进货单
     * @param
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<String> insertToImportBill(BuyerInsertToImportBillPo po) {
        ResultPoJo<String> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        Long membIdFromUser = MembUtils.getMembIdFromUser(SystemUtils.getUser());
        //根据商品发布的ID 查询商品的详情
        CommPubInfo commPubInfo = commPubInfoMapper.selectByPrimaryKey(po.getCommPubId());
        if(ConverterUtil.isEmpty(commPubInfo)) {
            resultPoJo.setCode(ConstantCodeMsg.ERR_386);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_386);
            return resultPoJo;
        }
        //判断  是否是  已下架状态   已上架0    未上架1    已下架2    已删除4    库存不足
        if(!commPubInfo.getCommStateType().equals(DictConstants.COMM_STATE_TYPE_0)) {
            resultPoJo.setCode(ConstantCodeMsg.ERR_390);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_390);
            return resultPoJo;
        }
        //判断是否是自己的商品
        if(commPubInfo.getMembId().equals(MembUtils.getMembIdFromUser(SystemUtils.getUser()))) {
            resultPoJo.setCode(ConstantCodeMsg.ERR_384);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_384);
            return resultPoJo;
        }
        String lockKey = ""+po.getLevelSpecQuoteId()+membIdFromUser;
        try {
            RedissLockUtil.lock(lockKey, 5);
            //校验数量
            LevelSpecQuote levelSpecQuote = levelSpecQuoteMapper.selectByPrimaryKey(po.getLevelSpecQuoteId());
            //校验起批量
            int firstConut = PriceOperateUtils.firstConut(levelSpecQuote.getPriceExpres());
            if (po.getCount() < firstConut) {

                resultPoJo.setCode(ConstantCodeMsg.ERR_384);
                resultPoJo.setMsg("购买数量小于起批量！");
                return resultPoJo;
            }
            //校验库存
            if (po.getCount() > levelSpecQuote.getAvaiSupplyCount()) {

                resultPoJo.setCode(ConstantCodeMsg.ERR_384);
                resultPoJo.setMsg("该规格商品库存不足！");
                return resultPoJo;
            }
            //进货单
            ImportBill importBill = new ImportBill();
            importBill.setCommPubId(po.getCommPubId());//商品发布ID
            importBill.setPrice(levelSpecQuote.getPriceExpres());
            importBill.setCommSpec(levelSpecQuote.getSpec());
            importBill.setMembId(MembUtils.getMembIdFromUser(SystemUtils.getUser()));//买家的ID
            importBill.setPurchaseStaffId(SystemUtils.getUser().getId());
            importBill.setLevelSpecQuoteId(po.getLevelSpecQuoteId());
            importBill.setLevelSpecQuoteVersionNum(levelSpecQuote.getVersionNum());
            importBill.setNetWeight(levelSpecQuote.getNetWeight());
            importBill.setCommVersionNum(commPubInfo.getVersionNum());
            importBill.setUpdateDate(OffsetDateTime.now());//设置商品的加入时间
            //记录是否是基地商品（后期可能会注释掉）
            if (commPubInfo.getBaseId() != null) {

                importBill.setTransType(DictConstants.TRANS_TYPE_1);
            }else {

                importBill.setTransType(DictConstants.TRANS_TYPE_0);
            }
            //获取计量单位
            String measUnitName = measUnitMageMapper.selectByPrimaryKey(levelSpecQuote.getMeasUnitId()).getMeasUnitName();
            importBill.setMeasUnit(measUnitName);
            //查询是否进货单已经存在
            ImportBill importvo = mapper.isHaveImportBillInfo(importBill);
            //判断是直接新增还是只是数量增加
            if(ConverterUtil.isNotEmpty(importvo)) {

                importBill.setId(importvo.getId());
                if(importvo.getCount()+ po.getCount() > levelSpecQuote.getAvaiSupplyCount()) {
                    //大于库存量，最多到库存
                    importBill.setCount(ConverterUtil.toInteger(levelSpecQuote.getAvaiSupplyCount()));
                }else {
                    //修改數量即可
                    importBill.setCount(importvo.getCount()+ po.getCount());
                }
                importBill.preUpdate();
                mapper.updateByPrimaryKeySelective(importBill);
            }else {
                importBill.setCount(po.getCount());
                importBill.setSellerId(commPubInfo.getMembId());//卖家的ID
                importBill.preInsert();
                //加入到进货单
                mapper.insertSelective(importBill);
            }
        } finally {
            //手动释放锁
            RedissLockUtil.unlock(lockKey);
        }
        return resultPoJo;
    }

    /**
     * 修改进货单中的商品数量
     */
    @Transactional(readOnly = false)
    public ResultPoJo<BuyerUpdateCountVo> updateCommPubInfoCount(BuyerUpdateCommPubInfoCountPo po) {
        ResultPoJo<BuyerUpdateCountVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        BuyerUpdateCountVo vo = new BuyerUpdateCountVo();
        //根据进货单ID 查询  进货单 信息
        ImportBill importBill = mapper.selectByPrimaryKey(po.getId());
        if(ConverterUtil.isNotEmpty(importBill)) {
            //根据商品发布ID 查询商品信息
            CommPubInfo commPubInfo = commPubInfoMapper.selectByPrimaryKey(importBill.getCommPubId());
            if(ConverterUtil.isNotEmpty(commPubInfo)) {
                //判断  是否是  已下架状态   已上架0    未上架1    已下架2    已删除4    库存不足
                if(!commPubInfo.getCommStateType().equals(DictConstants.COMM_STATE_TYPE_0)) {
                    resultPoJo.setCode(ConstantCodeMsg.ERR_390);
                    resultPoJo.setMsg(ConstantCodeMsg.MSG_390);
                    return resultPoJo;
                }
                //查询商品等级信息
                LevelSpecQuote levelInfo = levelSpecQuoteMapper.selectByPrimaryKey(importBill.getLevelSpecQuoteId());
                //校验起批量
                int firstConut = PriceOperateUtils.firstConut(levelInfo.getPriceExpres());
                if (po.getCount() < firstConut) {

                    resultPoJo.setCode(ConstantCodeMsg.ERR_384);
                    resultPoJo.setMsg("购买数量小于起批量！");
                    return resultPoJo;
                }
                //校验库存
                if (po.getCount() > levelInfo.getAvaiSupplyCount()) {

                    resultPoJo.setCode(ConstantCodeMsg.ERR_384);
                    resultPoJo.setMsg("该规格商品库存不足！");
                    return resultPoJo;
                }
                //获取当前重量的价格
                ImportBillPriceOperateVo calculationPrice = PriceOperateUtils.calculationPrice(importBill.getPrice(), po.getCount());
                //获取当前阶梯的最新价格
                ImportBillPriceOperateVo newPrice = PriceOperateUtils.calculationPrice(levelInfo.getPriceExpres(), po.getCount());
                vo.setVersionFlag("0");
                if (commPubInfo.getVersionNum().equals(importBill.getCommVersionNum())) {
                    //先判断是否失效
                    if (importBill.getLevelSpecQuoteVersionNum().equals(levelInfo.getVersionNum())) {
                        //然后判断价格是否变动
                        if (!calculationPrice.getPrice().equals(newPrice.getPrice())) {

                            vo.setVersionFlag("2");
                        }
                    }else {
                        vo.setVersionFlag("1");
                    }
                }else {
                    vo.setVersionFlag("1");
                }
                vo.setIsPrice(calculationPrice.getPrice());
                vo.setCommPrice(newPrice.getPrice());
                //计算每单位单价（单价/净重）
                vo.setPrePrice(ConverterUtil.div(vo.getIsPrice(), importBill.getNetWeight(), 2));
                vo.setMinCount(calculationPrice.getMinCount());
                vo.setMaxCount(calculationPrice.getMaxCount());
                vo.setStatCount(PriceOperateUtils.firstConut(importBill.getPrice()));
                //判断无误后   修改  商品数量    返回  价格
                importBill.setCount(po.getCount());
                importBill.preUpdate();
                mapper.updateByPrimaryKeySelective(importBill);
                resultPoJo.setResult(vo);
                resultPoJo.setMsg("修改成功");
            }
        }else {
            resultPoJo.setCode(ConstantCodeMsg.ERR_383);
            resultPoJo.setMsg("进货单没有该商品！");
            return resultPoJo;
        }
        return resultPoJo;
    }

    /**
     * 批量删除选中的商品
     * @param
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<String> deleteManyImportBill(BuyerDeleManyImportBillPo po) {
        ResultPoJo<String> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        String commpubIds = po.getImportBillIds();
        String[] commpubId = commpubIds.split(",");
        for (String commpubIdMsg : commpubId) {
            ImportBill importBill = mapper.selectByPrimaryKey(Long.valueOf(commpubIdMsg));
            importBill.setDelFlag("1");
            //必须是当前用户并且是属于当前主账户
            if (!(importBill.getMembId().equals(MembUtils.getMembIdFromUser(SystemUtils.getUser())) &&
                    importBill.getPurchaseStaffId().equals(SystemUtils.getUser().getId()))) {
                resultPoJo.setCode(ConstantCodeMsg.ERR_455);
                resultPoJo.setMsg(ConstantCodeMsg.MSG_455);
                return resultPoJo;
            }
            mapper.updateByPrimaryKeySelective(importBill);
        }
        resultPoJo.setMsg("删除成功!");
        return resultPoJo;
    }

    /**
     * 进货单 商品的列表
     * @param
     * @return
     */
    public ResultPoJo<List<ImportListVo>> commInfoListFromImpBill(ImportListPo po) {

        ResultPoJo<List<ImportListVo>> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        List<ImportListVo> voList = Lists.newArrayList();
        po.setMembId(MembUtils.getMembIdFromUser(SystemUtils.getUser()));
        po.setPurchaseStaffId(SystemUtils.getUser().getId());
        po.setTransType(po.getKeyStr());
        //查询当前采购员下进货单列表
        List<ImportStallsListVo> importList = Lists.newArrayList();
        if (DictConstants.TRANS_TYPE_1.equals(po.getTransType())) {

            importList = mapper.findLocalImportList(po);
        }else {

            po.setTransType(DictConstants.TRANS_TYPE_0);
            importList = mapper.findImportList(po);
        }
        //将列表按商家重新封装
        Map<Long, List<ImportStallsListVo>> sellMap = Maps.newHashMap();
        //循环每个档口数据
        for (ImportStallsListVo importStalls : importList) {
            //获取档口商品
            List<ImportCommListVo> importCommList = importStalls.getImportCommList();
            //判断商品是否失效
            for (ImportCommListVo t : importCommList) {
                t.setVersionFlag("0");
                //获取当前重量的价格
                ImportBillPriceOperateVo calculationPrice = PriceOperateUtils.calculationPrice(t.getPrice(), t.getCount());
                //获取当前阶梯的最新价格
                ImportBillPriceOperateVo newPrice = PriceOperateUtils.calculationPrice(t.getPriceExpres(), t.getCount());
                //判断商品是否下架
                if (!DictConstants.COMM_STATE_TYPE_0.equals(t.getCommStateType())) {

                    t.setVersionFlag("1");
                }else {
                    if (t.getCommVersion().equals(t.getCommVersionNum())) {
                        //先判断是否失效
                        if (t.getLevelSpecQuoteVersionNum().equals(t.getLevelVersion())) {
                            //然后判断价格是否变动
                            if (!calculationPrice.getPrice().equals(newPrice.getPrice())) {
                                t.setVersionFlag("2");
                            }
                            //判断是否是同个市场，不是同个市场的为3，失效优先
                            if (!importStalls.getWholeSaleMarketId().equals(po.getWholeSaleMarketId())) {
                                t.setVersionFlag("3");
                            }
                        }else {
                            t.setVersionFlag("1");
                        }
                    }else {
                        t.setVersionFlag("1");
                    }
                }
                t.setIsPrice(calculationPrice.getPrice());
                t.setCommPrice(newPrice.getPrice());
                //计算每单位单价（单价/净重）
                t.setPrePrice(ConverterUtil.div(t.getIsPrice(), t.getNetWeight(), 2));
                t.setMinCount(calculationPrice.getMinCount());
                t.setMaxCount(calculationPrice.getMaxCount());
                t.setStatCount(PriceOperateUtils.firstConut(t.getPrice()));
                //获取商品图片
                //根据商品的ID查询第一张图片信息
                CommPicture commPicture = commPictureMapper.selectMinPictureByCommId(t.getCommPubId());
                t.setCommUrl(commPicture.getUrl());
            }
            //先判断map中是否已有该商家
            if (sellMap.containsKey(importStalls.getSellerId())) {

                List<ImportStallsListVo> list = sellMap.get(importStalls.getSellerId());
                list.add(importStalls);
                sellMap.put(importStalls.getSellerId(), list);
            }else {
                //这个商家没在map里，则重新构造一个档口列表
                List<ImportStallsListVo> staList = Lists.newArrayList();
                staList.add(importStalls);
                sellMap.put(importStalls.getSellerId(), staList);
                //用于商家封装
                ImportListVo importListVo = new ImportListVo();
                importListVo.setSellerId(importStalls.getSellerId());
                //查询商家名称
                importListVo.setEntpName(MembUtils.getMembInfoByUserId(importStalls.getSellerId()).getAuthName());
                voList.add(importListVo);
            }
        }
        //为每个商家加上档口列表
        voList.forEach(e -> {

            e.setStallsList(sellMap.get(e.getSellerId()));
        });
        resultPoJo.setResult(voList);
        return resultPoJo;
    }

    /**
     * 进货单商品数量角标
     * @param
     * @return
     */
    public ResultPoJo<String> commInfoListNum() {
        ResultPoJo<String> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        ImportListPo po = new ImportListPo();
        po.setMembId(MembUtils.getMembIdFromUser(SystemUtils.getUser()));
        po.setPurchaseStaffId(SystemUtils.getUser().getId());
        //查询当前采购员下进货单列表
        String num = mapper.commInfoListNum(po);
        resultPoJo.setResult(num);
        return resultPoJo;
    }

    /**
     * 立即购买校验
     * @param po
     * @return
     */
    public ResultPoJo<Object> preOrderChack (BuyerPitchOnPo po) {

        ResultPoJo<Object> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        List<ImportStallsListVo> importList = Lists.newArrayList();
        ImportListPo importPo = new ImportListPo();
        importPo.setImportIds(po.getImportBillIds());
        //判断是从进货单进入还是立即购买
        if ("1".equals(po.getBuyType())) {
            //获取进货单数据
            importPo.setPurchaseStaffId(SystemUtils.getUserOnlyId().getId());
            importPo.setMembId(MembUtils.getMembIdFromUser(SystemUtils.getUser()));
            importList = mapper.findImportList(importPo);
            //校验是否已经删除
            if(po.getImportBillIds().split(",").length != importList.stream().mapToInt((x)->x.getImportCommList().size()).sum()) {

                resultPoJo.setCode(ConstantCodeMsg.ERR_412);
                resultPoJo.setMsg(ConstantCodeMsg.MSG_412);
                return resultPoJo;
            }
        }else {
            //获取商品信息
            importList = levelSpecQuoteMapper.findPreCommList(importPo);
            importList.get(0).getImportCommList().get(0).setCount(po.getCount());
            if (ConverterUtil.isEmpty(importList)) {

                resultPoJo.setCode(ConstantCodeMsg.ERR_412);
                resultPoJo.setMsg("存在已删除商品，请确认商品信息！");
                return resultPoJo;
            }
        }
        //校验商品信息
        for (ImportStallsListVo t : importList) {
            //获取档口下的商品
            List<ImportCommListVo> importCommList = t.getImportCommList();
            if (ConverterUtil.isEmpty(importCommList)) {

                resultPoJo.setCode(ConstantCodeMsg.ERR_412);
                resultPoJo.setMsg("存在已删除商品！");
                return resultPoJo;
            }
            //判断是否是自己的商品
            if(t.getSellerId().equals(MembUtils.getMembIdFromUser(SystemUtils.getUser()))) {
                resultPoJo.setCode(ConstantCodeMsg.ERR_384);
                resultPoJo.setMsg(ConstantCodeMsg.MSG_384);
                return resultPoJo;
            }
            //校验是否是同一个市场(进货单进入并且是同城)
            if ("1".equals(po.getBuyType()) && DictConstants.TRANS_TYPE_0.equals(po.getTransType())
                && !t.getWholeSaleMarketId().equals(importList.get(0).getWholeSaleMarketId())) {
                resultPoJo.setCode(ConstantCodeMsg.ERR_412);
                resultPoJo.setMsg("不是同个市场的不允许交易！");
                return resultPoJo;
            }
            //循环商品信息校验
            for (ImportCommListVo e : importCommList) {
                //判断商品是否已下架
                if (!DictConstants.COMM_STATE_TYPE_0.equals(e.getCommStateType())) {

                    resultPoJo.setCode(ConstantCodeMsg.ERR_413);
                    resultPoJo.setMsg("存在已下架商品！");
                    return resultPoJo;
                }
                //获取起批量
                int firstConut = PriceOperateUtils.firstConut(e.getPrice());
                if ("0".equals(po.getBuyType())) {

                    e.setCount(po.getCount());
                }
                //校验起批量
                if (e.getCount() < firstConut) {

                    resultPoJo.setCode(ConstantCodeMsg.ERR_383);
                    resultPoJo.setMsg("购买数量小于起批量！");
                    return resultPoJo;
                }
                //校验库存
                if (e.getCount() > e.getAvaiSupplyCount()) {

                    resultPoJo.setCode(ConstantCodeMsg.ERR_404);
                    resultPoJo.setMsg("该规格商品库存不足");
                    return resultPoJo;
                }
                if ("1".equals(po.getBuyType())) {
                    //校验是否当前登录用户
                    if (!(e.getMembId().equals(MembUtils.getMembIdFromUser(SystemUtils.getUser())) &&
                            e.getPurchaseStaffId().equals(SystemUtils.getUser().getId()))) {
                        resultPoJo.setCode(ConstantCodeMsg.ERR_455);
                        resultPoJo.setMsg(ConstantCodeMsg.MSG_455);
                        return resultPoJo;
                    }
                    //校验商品信息是否变动（进货单进入时校验）
                    if (!e.getCommVersionNum().equals(e.getCommVersion())) {

                        resultPoJo.setCode(ConstantCodeMsg.ERR_404);
                        resultPoJo.setMsg("该商品信息变动，请重新选择！");
                        return resultPoJo;
                    }
                    //校验规格是否变动
                    if (!e.getLevelSpecQuoteVersionNum().equals(e.getLevelVersion())) {

                        resultPoJo.setCode(ConstantCodeMsg.ERR_404);
                        resultPoJo.setMsg("该规格商品信息变动，请重新选择！");
                        return resultPoJo;
                    }
                    //校验价格是否变动（进货单进入时校验）
                    //获取当前重量的价格
                    ImportBillPriceOperateVo calculationPrice = PriceOperateUtils.calculationPrice(e.getPrice(), e.getCount());
                    //获取当前阶梯的最新价格
                    ImportBillPriceOperateVo newPrice = PriceOperateUtils.calculationPrice(e.getPriceExpres(), e.getCount());
                    if (!calculationPrice.getPrice().equals(newPrice.getPrice())) {

                        resultPoJo.setCode(ConstantCodeMsg.ERR_456);
                        resultPoJo.setMsg("该规格商品价格改变，请重新选择！");
                        return resultPoJo;
                    }
                }
            }
        }
        return resultPoJo;
    }

    /**
     * 更新进货单价格
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> gxImportPrice() {
        ResultPoJo<Object> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        //获取进货单列表
        ImportListPo po = new ImportListPo();
        po.setMembId(MembUtils.getMembIdFromUser(SystemUtils.getUser()));
        po.setPurchaseStaffId(SystemUtils.getUser().getId());
        //查询当前采购员下进货单列表
        List<ImportStallsListVo> importList1 = mapper.findImportList(po);
        List<ImportStallsListVo> importList2 = mapper.findLocalImportList(po);
        importList1.addAll(importList2);
        //构造批量修改价格列表
        List<ImportBill> list = Lists.newArrayList();
        //循环判断价格是否变动
        for (ImportStallsListVo importBill : importList1) {

            for (ImportCommListVo e : importBill.getImportCommList()) {
                //价格表达式变动
                if (!e.getPrice().equals(e.getPriceExpres())) {

                    ImportBill bill = new ImportBill();
                    bill.setPrice(e.getPriceExpres());
                    bill.setId(e.getId());
                    bill.preUpdate();
                    list.add(bill);
                }
            }
        }
        //入库修改价格
        if (list != null && list.size() > 0) {

            mapper.batchUpdate(list);
        }
        return resultPoJo;
    }

    /**
     * 去结算初始化页面
     * @param po
     * @return
     */
    public ResultPoJo<BuyerPreOrderCommInfoVo> commInfoListFromPreOrder (BuyerPitchOnPo po) {
        ResultPoJo<BuyerPreOrderCommInfoVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        List<ImportStallsListVo> importList = Lists.newArrayList();
        ImportListPo importPo = new ImportListPo();
        importPo.setImportIds(po.getImportBillIds());
        //判断是从进货单进入还是立即购买
        if ("1".equals(po.getBuyType())) {
            //获取进货单数据
            importPo.setPurchaseStaffId(SystemUtils.getUserOnlyId().getId());
            importPo.setMembId(MembUtils.getMembIdFromUser(SystemUtils.getUser()));
            if (DictConstants.TRANS_TYPE_1.equals(po.getTransType())) {

                importList = mapper.findLocalImportList(importPo);
            }else {

                importList = mapper.findImportList(importPo);
            }
            //校验是否已经删除
            if(po.getImportBillIds().split(",").length != importList.stream().mapToInt((x)->x.getImportCommList().size()).sum()) {

                resultPoJo.setCode(ConstantCodeMsg.ERR_412);
                resultPoJo.setMsg(ConstantCodeMsg.MSG_412);
                return resultPoJo;
            }
        }else {
            //获取商品信息
            importPo.setTransType(po.getTransType());
            importList = levelSpecQuoteMapper.findPreCommList(importPo);
            if (ConverterUtil.isEmpty(importList)) {

                resultPoJo.setCode(ConstantCodeMsg.ERR_412);
                resultPoJo.setMsg("存在已删除商品，请确认商品信息！");
                return resultPoJo;
            }
        }
        //循环添加总信息
        //总商品数
        Integer commCount = 0;
        //商品总金额
        Double totalMoney = 0D;
        //是否可以指定配送
        String receFlag = "0";
        //构造map，用于计算商家个数
        Map<Long, Long> map = Maps.newHashMap();
        for (ImportStallsListVo e : importList) {
            //将商家放入map
            if (!map.containsKey(e.getSellerId())) {

                map.put(e.getSellerId(), e.getSellerId());
            }
            //商家名称
            e.setEntpName(MembUtils.getMembInfoByUserId(e.getSellerId()).getAuthName());
            //金额小计
            Double commMoney = 0D;
            //循环每个商品
            for (ImportCommListVo t : e.getImportCommList()) {
                //立即购买数量从入参取
                if ("0".equals(po.getBuyType())) {

                    t.setCount(po.getCount());
                }
                //判断是否可以配送
                boolean flag = true;
                if (t.getSerTypeExpres() != null) {
                    String[] psSpelt = t.getSerTypeExpres().split(",");
                    flag = Arrays.asList(psSpelt).contains("1");
                }else {
                    receFlag = "1";
                }
                if ("0".equals(receFlag) && !flag) {
                    receFlag = "1";
                }
                //计算商品单价
                ImportBillPriceOperateVo calculationPrice = PriceOperateUtils.calculationPrice(t.getPrice(), t.getCount());
                t.setIsPrice(calculationPrice.getPrice());
                t.setStatCount(PriceOperateUtils.firstConut(t.getPrice()));
                //计算每单位单价（单价/净重）
                t.setPrePrice(ConverterUtil.div(t.getIsPrice(), t.getNetWeight(), 2));
                //计算商品总价
                double mul = ConverterUtil.mul(t.getIsPrice(), t.getCount());
                t.setTotalPrice(mul);
                //计算该档口商品小计
                commMoney = ConverterUtil.add(commMoney, mul);
                commCount = commCount + t.getCount();
                //获取商品图片
                //根据商品的ID查询第一张图片信息
                CommPicture commPicture = commPictureMapper.selectMinPictureByCommId(t.getCommPubId());
                t.setCommUrl(commPicture.getUrl());
            }
            e.setCommMoney(commMoney);
            totalMoney = ConverterUtil.add(totalMoney, commMoney);
        }
        //构造返回数据
        BuyerPreOrderCommInfoVo vo = new BuyerPreOrderCommInfoVo();
        vo.setImportStallsListVo(importList);
        vo.setDate(OffsetDateTime.now());
        vo.setAmountPayable(totalMoney);
        vo.setTotalCount(commCount);
        vo.setTotalSeller(map.size());
        vo.setTotalStall(importList.size());
        vo.setReceFlag(receFlag);
        if ("0".equals(receFlag)) {
            //收货地址信息
            ReceAddressInfoVo receAddressInfoVo = receAddressMapper.buyerFindDefault();
            vo.setReceAddressInfoVo(receAddressInfoVo);
        }
        //获取默认发票信息
        vo.setInvoInfoInfoVo(invoInfoMapper.selDefaultInvoByMembId(MembUtils.getMembIdFromUser(SystemUtils.getUser())));
        resultPoJo.setResult(vo);
        return resultPoJo;
    }

    /**
     * 提交订单
     * @param po
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<BuyerGeneratingOrderVo> generatingOrder (BuyerGeneratingOrderPo po) {
        ResultPoJo<BuyerGeneratingOrderVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        //获取每个档口的商品信息
        List<OrderApplPo> commpubListIds = po.getStallCommList();
        //获取当前用户信息
        //Long purchaseId = SystemUtils.getUserOnlyId().getId();
        Long buyerId = MembUtils.getMembIdFromUser(SystemUtils.getUser());
        //用于防止二次查询
        Map<Long, ImportCommListVo> leveMap = Maps.newHashMap();
        //判断是否是基地商品（0否，1是）
        String jdFlag = "0";
        //判断是否是同个市场
        Long scId = null;
        //循环处理每个档口，一个档口就是一个订单(校验)
        for (OrderApplPo orderApplPo : commpubListIds) {
            //取得档口商品
            List<BuyerToOrderPo> commpubList = orderApplPo.getImportCommList();
            //校验
            for (BuyerToOrderPo e : commpubList) {
                //获取每个商品信息，加锁，在事物之后解锁
                RedissLockUtil.lock(e.getLevelSpecQuoteId().toString(), 5);
                ImportCommListVo commLeveInfo = levelSpecQuoteMapper.selCommLeveInfo(e.getLevelSpecQuoteId());
                if (commLeveInfo.getBaseId() != null) {
                    jdFlag = "1";
                }
                //校验是否同个市场
                if (scId == null && commLeveInfo.getWholeSaleMarketId() != null) {
                    scId = commLeveInfo.getWholeSaleMarketId();
                }else if (scId != null && !scId.equals(commLeveInfo.getWholeSaleMarketId())) {

                    resultPoJo.setCode(ConstantCodeMsg.ERR_368);
                    resultPoJo.setMsg("该订单包含不同的市场！");
                    return resultPoJo;
                }
                //判断是否可以配送
                if (po.getReceAdressId() != null) {
                    if (commLeveInfo.getSerTypeExpres() != null) {
                        String[] psSpelt = commLeveInfo.getSerTypeExpres().split(",");
                        if (!Arrays.asList(psSpelt).contains("1")) {
                            resultPoJo.setCode(ConstantCodeMsg.ERR_368);
                            resultPoJo.setMsg("该订单有不支持配送的商品！");
                            return resultPoJo;
                        }
                    }
                }
                //校验数据是否一致
                if ((jdFlag == "0" && commLeveInfo.getBaseId() != null) || (jdFlag == "1" && commLeveInfo.getBaseId() == null)) {

                    resultPoJo.setCode(ConstantCodeMsg.ERR_368);
                    resultPoJo.setMsg("该订单包含不同的交易模式类型！");
                    return resultPoJo;
                }
                leveMap.put(e.getLevelSpecQuoteId(), commLeveInfo);
                //校验商品是否已删除
                if (ConverterUtil.isEmpty(commLeveInfo)) {

                    resultPoJo.setCode(ConstantCodeMsg.ERR_368);
                    resultPoJo.setMsg(ConstantCodeMsg.MSG_368);
                    return resultPoJo;
                }
                //校验是否是自己商品
                if (buyerId.equals(commLeveInfo.getSellerId())) {

                    resultPoJo.setCode(ConstantCodeMsg.ERR_412);
                    resultPoJo.setMsg(ConstantCodeMsg.MSG_412);
                    return resultPoJo;
                }
                //校验商品状态
                if(!commLeveInfo.getCommStateType().equals(DictConstants.COMM_STATE_TYPE_0)) {

                    resultPoJo.setCode(ConstantCodeMsg.ERR_369);
                    resultPoJo.setMsg(ConstantCodeMsg.MSG_369);
                    return resultPoJo;
                }
                //校验商品信息是否变动
                if (!commLeveInfo.getCommVersion().equals(e.getCommVersion())) {

                    resultPoJo.setCode(ConstantCodeMsg.ERR_404);
                    resultPoJo.setMsg("该商品信息变动，请重新选择！");
                    return resultPoJo;
                }
                //校验规格是否变动
                if (!commLeveInfo.getLevelVersion().equals(e.getLevelVersion())) {

                    resultPoJo.setCode(ConstantCodeMsg.ERR_404);
                    resultPoJo.setMsg("该规格商品信息变动，请重新选择！");
                    return resultPoJo;
                }
                //校验价格是否变化
                //获取当前重量的价格
                ImportBillPriceOperateVo calculationPrice = PriceOperateUtils.calculationPrice(commLeveInfo.getPrice(), e.getCount());
                if (!calculationPrice.getPrice().equals(e.getIsPrice())) {

                    resultPoJo.setCode(ConstantCodeMsg.ERR_456);
                    resultPoJo.setMsg("该规格商品价格变动，请重新选择！");
                    return resultPoJo;
                }
                //校验库存
                if (e.getCount() > commLeveInfo.getAvaiSupplyCount()) {
                    //发送库存消息
                    Map<String, Object> param = Maps.newHashMap();
                    param.put("timType", TIMNoticeConstants.TITLE_PRD_STOCK_ZERO);
                    param.put("id", commLeveInfo.getCommPubId());
                    param.put("commName", commLeveInfo.getCommTitle());
                    param.put("commSpec", commLeveInfo.getCommSpec());
                    param.put("staffId", commLeveInfo.getStallsMageId());
                    param.put("transType", jdFlag);
                    param.put("userId", commLeveInfo.getSellerId());
                    timSendService.sendTim(param);

                    resultPoJo.setCode(ConstantCodeMsg.ERR_384);
                    resultPoJo.setMsg("该规格商品库存不足！");
                    return resultPoJo;
                }
                //校验购买量是否到达起批量
                int firstConut = PriceOperateUtils.firstConut(commLeveInfo.getPrice());
                if (e.getCount() < firstConut) {

                    resultPoJo.setCode(ConstantCodeMsg.ERR_384);
                    resultPoJo.setMsg("购买数量小于起批量！");
                    return resultPoJo;
                }
            }
        }
        //TODO 订单开始位置定位
        if (jdFlag == "1") {

            return localOrderGen(po, leveMap);
        }else {

            return orderGen(po, leveMap);
        }
    }

    /**
     * 普通订单生成
     * @param po
     * @param leveMap
     */
    public ResultPoJo<BuyerGeneratingOrderVo> orderGen (BuyerGeneratingOrderPo po, Map<Long, ImportCommListVo> leveMap) {
        ResultPoJo<BuyerGeneratingOrderVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        //获取当前用户信息
        Long purchaseId = SystemUtils.getUserOnlyId().getId();
        Long buyerId = MembUtils.getMembIdFromUser(SystemUtils.getUser());
        //获取每个档口的商品信息
        List<OrderApplPo> commpubListIds = po.getStallCommList();
        //TODO 订单位置开始定位
        //总商品数
        Integer commCount = 0;
        //商品总金额
        Double totalMoney = 0D;
        //构造map，用于计算商家个数
        Map<Long, Long> map = Maps.newHashMap();
        //构造list，用于返回订单列表
        List<BuyerOrderInfoVo> ordNumList = Lists.newArrayList();
        //获取发票信息
        InvoInfo invoInfo = null;
        if (po.getInvoId() != null) {

            invoInfo = invoInfoMapper.selectByPrimaryKey(po.getInvoId());
        }
        //循环处理每个档口，一个档口就是一个订单（构造数据入库）
        for (OrderApplPo ordpo : commpubListIds) {
            //取得档口商品
            List<BuyerToOrderPo> commpubList = ordpo.getImportCommList();
            //构造订单信息
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.preInsert();
            //订单商品总件数
            Integer commTotalCount = 0;
            //订单商品总金额
            Double commTotalPrice = 0D;
            //平台服务费
            Double platfCost = 0D;
            //订单应付金额（商品金额+账期服务费，提单时不计算=商品总金额）
            //构造list，用于订单商品表批量插入
            List<OrdCommRela> ordCommRelaList = Lists.newArrayList();
            for (BuyerToOrderPo e : commpubList) {
                //从map获取每个商品信息
                ImportCommListVo leveInfo = leveMap.get(e.getLevelSpecQuoteId());
                //设置卖家ID
                orderInfo.setSellerId(leveInfo.getSellerId());
                //构造订单商品信息
                OrdCommRela ordCommRela = new OrdCommRela();
                ordCommRela.preInsert();
                ordCommRela.setOrdId(orderInfo.getId());
                //计算单价
                Double isPrice = PriceOperateUtils.calculationPrice(leveInfo.getPrice(), e.getCount()).getPrice();
                ordCommRela.setPrice(isPrice);
                ordCommRela.setCount(e.getCount());
                ordCommRela.setCommPubId(leveInfo.getCommPubId());
                ordCommRela.setLevelSpecQuoteId(leveInfo.getLevelSpecQuoteId());
                ordCommRela.setCommSpec(leveInfo.getCommSpec());
                ordCommRela.setMeasUnitName(leveInfo.getMeasUnit());
                ordCommRela.setDimensionsType(leveInfo.getDimensionsType());
                ordCommRela.setNetWeight(leveInfo.getNetWeight());
                ordCommRela.setCommName(leveInfo.getCommTitle());
                //计算单位重量单价
                ordCommRela.setUnitWeightPrice(ConverterUtil.div(ordCommRela.getPrice(), ordCommRela.getNetWeight(), 2));
                //该商品总重量
                ordCommRela.setCommTotalWeight(ConverterUtil.mul(leveInfo.getNetWeight(), e.getCount()));
                //根据商品的ID查询第一张图片信息
                CommPicture commPicture = commPictureMapper.selectMinPictureByCommId(leveInfo.getCommPubId());
                ordCommRela.setCommUrl(commPicture.getUrl());
                //计算商品总金额
                double mul = ConverterUtil.mul(ordCommRela.getCount(), ordCommRela.getPrice());
                //TODO 计算单个服务费
                double cost = OrdCommRelaUtil.commPlatfCost(ordCommRela, leveInfo.getSellerId(), buyerId).getPlatfCost();
                platfCost = ConverterUtil.add(platfCost, cost);
                commTotalPrice = ConverterUtil.add(commTotalPrice, mul);
                commTotalCount += ordCommRela.getCount();
                ordCommRelaList.add(ordCommRela);
                //修改商品库存，销量
                LevelSpecQuote levelSpecQuote = new LevelSpecQuote();
                levelSpecQuote.setId(e.getLevelSpecQuoteId());
                levelSpecQuote.setAvaiSupplyCount(leveInfo.getAvaiSupplyCount() - ordCommRela.getCount());
                levelSpecQuote.setSalesVolume(ConverterUtil.add(leveInfo.getSalesVolume(), ordCommRela.getCommTotalWeight()));
                levelSpecQuote.setTransactionAmount(ConverterUtil.add(leveInfo.getTransactionAmount(), mul));
                levelSpecQuote.preUpdate();
                levelSpecQuoteMapper.updateByPrimaryKeySelective(levelSpecQuote);
                //判断进货单是否有该商品
                ImportBill importBill = new ImportBill();
                importBill.setMembId(buyerId);
                importBill.setPurchaseStaffId(purchaseId);
                importBill.setLevelSpecQuoteId(e.getLevelSpecQuoteId());
                ImportBill haveImport = mapper.isHaveImportBillInfo(importBill);
                //删除进货单信息
                if (ConverterUtil.isNotEmpty(haveImport)) {

                    haveImport.setDelFlag("1");
                    haveImport.preUpdate();
                    mapper.updateByPrimaryKeySelective(haveImport);
                }
            }
            orderInfo.setOrdNum(CodeUtils.generateOrderCode());
            orderInfo.setBuyerId(buyerId);
            orderInfo.setPurchaseId(purchaseId);
            orderInfo.setStallsId(ordpo.getStallsMageId());
            //自提是0，送货是1
            orderInfo.setZtAddressType(po.getZtAddressType());
            orderInfo.setZtStartDate(ordpo.getZtStartDate());
            orderInfo.setZtEndDate(ordpo.getZtEndDate());
            //判断是自提还是配送
            orderInfo.setSendZtType(po.getZtAddressType());
            if ("1".equals(po.getZtAddressType()) && po.getReceAdressId() != null) {
                //获取配送信息
                ReceAddressInfoVo receVo = receAddressMapper.findInfo(po.getReceAdressId());
                orderInfo.setZtAddressProv(receVo.getAreaProv());
                orderInfo.setZtAddressCity(receVo.getAreaCity());
                orderInfo.setZtAddressCou(receVo.getAreaCou());
                orderInfo.setZtAddress(receVo.getAddress());
                orderInfo.setConsigneeName(receVo.getName());
                orderInfo.setConsigneeTel(receVo.getTel());
            }else {
                //提货人就是下单人
                orderInfo.setConsigneeName(MembUtils.getMembInfoByUserId(purchaseId).getContName());
                orderInfo.setConsigneeTel(po.getBuyerTel());
                //无论是档口地址还是自填都用这个地址
                orderInfo.setZtAddress(po.getZtAddress());
            }
            //获取档口信息
            StallsMage stallsMage = stallsMageMapper.selectByPrimaryKey(ordpo.getStallsMageId());
            //判断自提地址是指定还是档口地址
            orderInfo.setSelfMentionAddressName(stallsMage.getStallsName());

            String businessDate = ConverterUtil.isNotEmpty(stallsMage.getBusinessDate()) ? stallsMage.getBusinessDate() : "";
            String businessTime = ConverterUtil.isNotEmpty(stallsMage.getBusinessTime()) ? stallsMage.getBusinessTime() : "";
            orderInfo.setZtBusinessHours(businessDate.concat(businessTime));
            orderInfo.setStallsAddress(stallsMage.getAddress());
            orderInfo.setZtContactsName(stallsMage.getContacts());
            orderInfo.setZtTel(stallsMage.getContTel());
            orderInfo.setOrderStateType(DictConstants.ORDER_STATE_TYPE_0);
            orderInfo.setReferOrdDate(OffsetDateTime.now());
            orderInfo.setSellerConfirmClosingDate(OffsetDateTime.now().plusHours(DeadLineUtils.getLimitDaysByType(DictConstants.DEAD_LINE_TYPE_0)));
            orderInfo.setOrdRemarks(ordpo.getRemarks());
            orderInfo.setPurchaseStaffName(MembUtils.getMembInfoByUserId(purchaseId).getContName());
            //获取主体名称
            orderInfo.setAuthZtName(MembUtils.getMembInfoByUserId(purchaseId).getAuthName());
            orderInfo.setCommTotalCount(commTotalCount);
            orderInfo.setCommTotalPrice(commTotalPrice);
            orderInfo.setPlatfCost(platfCost);
            orderInfo.setPayableAmount(commTotalPrice);
            orderInfoMapper.insertSelective(orderInfo);
            ordCommRelaMapper.batchInsert(ordCommRelaList);
            //设置订单发票
            if (po.getInvoId() != null && invoInfo != null) {

                OrdInvo ordInvo = new OrdInvo();
                ConverterUtil.copyProperties(invoInfo, ordInvo);
                ordInvo.setOrdId(orderInfo.getId());
                ordInvo.setApplRemarks(po.getRemake());
                ordInvo.setReceName(po.getReceName());
                ordInvo.setConsigneeTel(po.getConsigneeTel());
                ordInvo.setAddressCity(po.getAddressCity());
                ordInvo.setAddressCou(po.getAddressCou());
                ordInvo.setAddressProv(po.getAddressProv());
                ordInvo.setAddressDetail(po.getAddressDetail());
                ordInvo.setApplDate(OffsetDateTime.now());
                ordInvo.setDrawAmount(orderInfo.getPayableAmount());
                ordInvo.setInvoState(DictConstants.INVO_STATE_0);
                ordInvo.setApplNum(CodeUtils.generateInvoApplCode());
                ordInvo.preInsert();
                ordInvoMapper.insertSelective(ordInvo);
            }
            //添加订单操作记录
            ordOpreateInfoService.saveOrdOperate(orderInfo.getId(), OrdOperateEnum.SUBMIT, orderInfo.getRemarks());
            //判断有没有添加到会员设置里
            List<MerchantMembMage> findByIds = merchantMembMageMapper.findListByIds(orderInfo.getSellerId(), orderInfo.getBuyerId());
            if (ConverterUtil.isEmpty(findByIds)) {

                MerchantMembMage mmm = new MerchantMembMage();
                mmm.setMerchantId(orderInfo.getSellerId());
                mmm.setMembId(orderInfo.getBuyerId());
                mmm.preInsert();
                merchantMembMageMapper.insertSelective(mmm);
            }
            //构造返回值参数
            //总商品数
            commCount += orderInfo.getCommTotalCount();
            //总金额
            totalMoney = ConverterUtil.add(totalMoney, orderInfo.getCommTotalPrice());
            //订单ID和num列表
            BuyerOrderInfoVo ordvo = new BuyerOrderInfoVo();
            ordvo.setId(orderInfo.getId());
            ordvo.setOrdNum(orderInfo.getOrdNum());
            ordvo.setSellerId(orderInfo.getSellerId());
            ordvo.setStallsMageId(orderInfo.getStallsId());
            ordNumList.add(ordvo);
        }
        //更新索引
        for (OrderApplPo ordpo : commpubListIds) {
            //取得档口商品
            List<BuyerToOrderPo> commpubList = ordpo.getImportCommList();
            for (BuyerToOrderPo e : commpubList) {
                //从map获取每个商品信息
                ImportCommListVo leveInfo = leveMap.get(e.getLevelSpecQuoteId());
                //构造商品IDlist用于更新索引
                List<Long> comIdList = Lists.newArrayList();
                //将商家放入map
                if (!map.containsKey(leveInfo.getSellerId())) {

                    map.put(leveInfo.getSellerId(), leveInfo.getSellerId());
                }
                //保证没有重复的商品ID
                if (!comIdList.contains(leveInfo.getCommPubId())) {

                    comIdList.add(leveInfo.getCommPubId());
                }
                //事物提交之后解锁
                TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
                    @Override
                    public void afterCommit() {
                        //事物提交之后执行解锁和修改索引操作
                        //解锁
                        RedissLockUtil.unlock(e.getLevelSpecQuoteId().toString());
                        logger.debug("更新索引并解锁：", e.getLevelSpecQuoteId().toString());
                        BatchUpdSearchPo msspo = new BatchUpdSearchPo();
                        msspo.setListIdPo(comIdList);
                        try {
                            productMss.updateBatchCommditySearch(msspo);
                        } catch (Exception e1) {
                            logger.debug("更新索引发生错误 ");
                        }
                        //库存小于10发送消息
                        if (e.getCount()+10 > leveInfo.getAvaiSupplyCount()) {
                            try {
                                Map<String, Object> pm = Maps.newHashMap();
                                pm.put("timType", TIMNoticeConstants.TPL_KEY_PRD_STOCK_WAR);
                                pm.put("id", leveInfo.getCommPubId());
                                pm.put("commName", leveInfo.getCommTitle());
                                pm.put("commSpec", leveInfo.getCommSpec());
                                pm.put("transType", DictConstants.TRANS_TYPE_0);
                                pm.put("staffId", leveInfo.getStallsMageId());
                                pm.put("userId", leveInfo.getSellerId());
                                timSendService.sendTim(pm);
                            } catch (Exception e1) {
                                logger.debug("发送库存预警消息失败 ");
                            }
                        }
                    }
                });
            }
        }
        for (BuyerOrderInfoVo orderInfo : ordNumList) {
            //事物提交之后发送消息
            Map<String, Object> pm2 = Maps.newHashMap();
            pm2.put("timType", TIMNoticeConstants.TPL_KEY_ORD_UN_COFM);
            pm2.put("id", orderInfo.getId());
            pm2.put("staffId", orderInfo.getStallsMageId());
            pm2.put("userId", orderInfo.getSellerId());
            pm2.put("ordNum", orderInfo.getOrdNum());
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
                @Override
                public void afterCommit() {
                    timSendService.sendTim(pm2);
                }
            });
        }
        //构造返回值
        BuyerGeneratingOrderVo vo = new BuyerGeneratingOrderVo();
        vo.setAmountPayable(totalMoney);
        vo.setOrdInfoList(ordNumList);
        vo.setTotalCount(commCount);
        vo.setTotalSeller(map.size());
        vo.setTotalStall(ordNumList.size());
        resultPoJo.setResult(vo);
        return resultPoJo;
    }

    /**
     * 基地订单生成
     * @param po
     * @param leveMap
     */
    public ResultPoJo<BuyerGeneratingOrderVo> localOrderGen (BuyerGeneratingOrderPo po, Map<Long, ImportCommListVo> leveMap) {
        ResultPoJo<BuyerGeneratingOrderVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        //获取当前用户信息
        Long purchaseId = SystemUtils.getUserOnlyId().getId();
        Long buyerId = MembUtils.getMembIdFromUser(SystemUtils.getUser());
        //获取每个档口的商品信息
        List<OrderApplPo> commpubListIds = po.getStallCommList();
        //TODO 订单位置开始定位
        //总商品数
        Integer commCount = 0;
        //商品总金额
        Double totalMoney = 0D;
        //构造map，用于计算商家个数
        Map<Long, Long> map = Maps.newHashMap();
        //构造list，用于返回订单列表
        List<BuyerOrderInfoVo> ordNumList = Lists.newArrayList();
        //获取发票信息
        InvoInfo invoInfo = null;
        if (po.getInvoId() != null) {

            invoInfo = invoInfoMapper.selectByPrimaryKey(po.getInvoId());
        }
        //循环处理每个档口，一个档口就是一个订单（构造数据入库）
        for (OrderApplPo ordpo : commpubListIds) {
            //取得档口商品
            List<BuyerToOrderPo> commpubList = ordpo.getImportCommList();
            //构造订单信息
            LocalityOrderInfo orderInfo = new LocalityOrderInfo();
            orderInfo.preInsert();
            //订单商品总件数
            Integer commTotalCount = 0;
            //订单商品总金额
            Double commTotalPrice = 0D;
            //平台服务费
            Double platfCost = 0D;
            //订单应付金额（商品金额+账期服务费，提单时不计算=商品总金额）
            //构造list，用于订单商品表批量插入
            List<LocalityOrdCommRela> ordCommRelaList = Lists.newArrayList();
            for (BuyerToOrderPo e : commpubList) {
                //从map获取每个商品信息
                ImportCommListVo leveInfo = leveMap.get(e.getLevelSpecQuoteId());
                //设置卖家ID
                orderInfo.setSellerId(leveInfo.getSellerId());
                //构造订单商品信息
                LocalityOrdCommRela ordCommRela = new LocalityOrdCommRela();
                ordCommRela.preInsert();
                ordCommRela.setOrdId(orderInfo.getId());
                //计算单价
                Double isPrice = PriceOperateUtils.calculationPrice(leveInfo.getPrice(), e.getCount()).getPrice();
                ordCommRela.setPrice(isPrice);
                ordCommRela.setCount(e.getCount());
                ordCommRela.setCommPubId(leveInfo.getCommPubId());
                ordCommRela.setLevelSpecQuoteId(leveInfo.getLevelSpecQuoteId());
                ordCommRela.setCommSpec(leveInfo.getCommSpec());
                ordCommRela.setMeasUnitName(leveInfo.getMeasUnit());
                ordCommRela.setDimensionsType(leveInfo.getDimensionsType());
                ordCommRela.setNetWeight(leveInfo.getNetWeight());
                ordCommRela.setCommName(leveInfo.getCommTitle());
                //计算单位重量单价
                ordCommRela.setUnitWeightPrice(ConverterUtil.div(ordCommRela.getPrice(), ordCommRela.getNetWeight(), 2));
                //该商品总重量
                ordCommRela.setCommTotalWeight(ConverterUtil.mul(leveInfo.getNetWeight(), e.getCount()));
                //根据商品的ID查询第一张图片信息
                CommPicture commPicture = commPictureMapper.selectMinPictureByCommId(leveInfo.getCommPubId());
                ordCommRela.setCommUrl(commPicture.getUrl());
                //计算商品总金额
                double mul = ConverterUtil.mul(ordCommRela.getCount(), ordCommRela.getPrice());
                //TODO 计算单个服务费
                OrdCommRela ptorderComm = new OrdCommRela();
                ConverterUtil.copyProperties(ordCommRela, ptorderComm);
                double cost = OrdCommRelaUtil.commPlatfCost(ptorderComm, leveInfo.getSellerId(), buyerId).getPlatfCost();
                platfCost = ConverterUtil.add(platfCost, cost);
                commTotalPrice = ConverterUtil.add(commTotalPrice, mul);
                commTotalCount += ordCommRela.getCount();
                ordCommRelaList.add(ordCommRela);
                //修改商品库存，销量
                LevelSpecQuote levelSpecQuote = new LevelSpecQuote();
                levelSpecQuote.setId(e.getLevelSpecQuoteId());
                levelSpecQuote.setAvaiSupplyCount(leveInfo.getAvaiSupplyCount() - ordCommRela.getCount());
                levelSpecQuote.setSalesVolume(ConverterUtil.add(leveInfo.getSalesVolume(), ordCommRela.getCommTotalWeight()));
                levelSpecQuote.setTransactionAmount(ConverterUtil.add(leveInfo.getTransactionAmount(), mul));
                levelSpecQuote.preUpdate();
                levelSpecQuoteMapper.updateByPrimaryKeySelective(levelSpecQuote);
                //判断进货单是否有该商品
                ImportBill importBill = new ImportBill();
                importBill.setMembId(buyerId);
                importBill.setPurchaseStaffId(purchaseId);
                importBill.setLevelSpecQuoteId(e.getLevelSpecQuoteId());
                ImportBill haveImport = mapper.isHaveImportBillInfo(importBill);
                //删除进货单信息
                if (ConverterUtil.isNotEmpty(haveImport)) {

                    haveImport.setDelFlag("1");
                    haveImport.preUpdate();
                    mapper.updateByPrimaryKeySelective(haveImport);
                }
                orderInfo.setBaseId(leveInfo.getBaseId());
            }
            orderInfo.setOrdNum(CodeUtils.generateOrderCode());
            orderInfo.setBuyerId(buyerId);
            orderInfo.setPurchaseId(purchaseId);
            //提货人就是下单人
            orderInfo.setConsigneeName(MembUtils.getMembInfoByUserId(purchaseId).getContName());
            orderInfo.setConsigneeTel(MembUtils.getMembInfoByUserId(purchaseId).getRegistTel());
            orderInfo.setZtStartDate(ordpo.getZtStartDate());
            orderInfo.setZtEndDate(ordpo.getZtEndDate());
            //获取基地信息
            //StallsMage stallsMage = stallsMageMapper.selectByPrimaryKey(ordpo.getStallsMageId());
            BaseInfoVo baseInfo = baseInfoMapper.baseInfoAndCont(ordpo.getStallsMageId());
            //判断自提地址是指定还是档口地址
            orderInfo.setSelfMentionAddressName(baseInfo.getBaseName());
            orderInfo.setZtAddressCity(baseInfo.getAreaCity());
            orderInfo.setZtAddressCou(baseInfo.getAreaCou());
            orderInfo.setZtAddressProv(baseInfo.getAreaProv());
            orderInfo.setZtAddressType(po.getZtAddressType());
            orderInfo.setZtContactsName(baseInfo.getConter());
            orderInfo.setZtTel(baseInfo.getContTel());
            //判断是否是国外地址
            if (baseInfo.getAbroadId() != null) {

                PlaceOriginMage abord = placeOriginMageMapper.selectByPrimaryKey(baseInfo.getAbroadId());
                orderInfo.setStallsAddress(abord.getPlaceOriginName());
            }else {

                orderInfo.setStallsAddress(baseInfo.getAddress());
            }
            //无论是基地地址还是自填都用这个地址
            orderInfo.setZtAddress(po.getZtAddress());
            orderInfo.setBaseOrderStateType(DictConstants.BASE_ORDER_STATE_TYPE_0);
            orderInfo.setReferOrdDate(OffsetDateTime.now());
            orderInfo.setSellerConfirmClosingDate(OffsetDateTime.now().plusHours(DeadLineUtils.getLimitDaysByType(DictConstants.DEAD_LINE_TYPE_0)));
            orderInfo.setOrdRemarks(ordpo.getRemarks());
            orderInfo.setPurchaseStaffName(MembUtils.getMembInfoByUserId(purchaseId).getContName());
            //获取主体名称
            orderInfo.setAuthZtName(MembUtils.getMembInfoByUserId(purchaseId).getAuthName());
            orderInfo.setCommTotalCount(commTotalCount);
            orderInfo.setCommTotalPrice(commTotalPrice);
            orderInfo.setPlatfCost(platfCost);
            orderInfo.setPayableAmount(commTotalPrice);
            localityOrderInfoMapper.insertSelective(orderInfo);
            localityOrdCommRelaMapper.batchInsert(ordCommRelaList);
            //设置订单发票
            if (po.getInvoId() != null && invoInfo != null) {

                LocalityOrdInvo ordInvo = new LocalityOrdInvo();
                ConverterUtil.copyProperties(invoInfo, ordInvo);
                ordInvo.setOrdId(orderInfo.getId());
                ordInvo.setApplRemarks(po.getRemake());
                ordInvo.setReceName(po.getReceName());
                ordInvo.setConsigneeTel(po.getConsigneeTel());
                ordInvo.setAddressCity(po.getAddressCity());
                ordInvo.setAddressCou(po.getAddressCou());
                ordInvo.setAddressProv(po.getAddressProv());
                ordInvo.setAddressDetail(po.getAddressDetail());
                ordInvo.setApplDate(OffsetDateTime.now());
                ordInvo.setDrawAmount(orderInfo.getPayableAmount());
                ordInvo.setInvoState(DictConstants.INVO_STATE_0);
                ordInvo.setApplNum(CodeUtils.generateInvoApplCode());
                ordInvo.preInsert();
                localityOrdInvoMapper.insertSelective(ordInvo);
            }
            //添加订单操作记录
            localityOrdOpreateInfoService.saveOrdOperate(orderInfo.getId(), OrdOperateEnum.SUBMIT, orderInfo.getRemarks());
            //判断有没有添加到会员设置里
            List<MerchantMembMage> findByIds = merchantMembMageMapper.findListByIds(orderInfo.getSellerId(), orderInfo.getBuyerId());
            if (ConverterUtil.isEmpty(findByIds)) {

                MerchantMembMage mmm = new MerchantMembMage();
                mmm.setMerchantId(orderInfo.getSellerId());
                mmm.setMembId(orderInfo.getBuyerId());
                mmm.preInsert();
                merchantMembMageMapper.insertSelective(mmm);
            }
            //构造返回值参数
            //总商品数
            commCount += orderInfo.getCommTotalCount();
            //总金额
            totalMoney = ConverterUtil.add(totalMoney, orderInfo.getCommTotalPrice());
            //订单ID和num列表
            BuyerOrderInfoVo ordvo = new BuyerOrderInfoVo();
            ordvo.setId(orderInfo.getId());
            ordvo.setOrdNum(orderInfo.getOrdNum());
            ordNumList.add(ordvo);
        }
        //更新索引
        for (OrderApplPo ordpo : commpubListIds) {
            //取得档口商品
            List<BuyerToOrderPo> commpubList = ordpo.getImportCommList();
            for (BuyerToOrderPo e : commpubList) {
                //从map获取每个商品信息
                ImportCommListVo leveInfo = leveMap.get(e.getLevelSpecQuoteId());
                //构造商品IDlist用于更新索引
                List<Long> comIdList = Lists.newArrayList();
                //将商家放入map
                if (!map.containsKey(leveInfo.getSellerId())) {

                    map.put(leveInfo.getSellerId(), leveInfo.getSellerId());
                }
                //保证没有重复的商品ID
                if (!comIdList.contains(leveInfo.getCommPubId())) {

                    comIdList.add(leveInfo.getCommPubId());
                }
                //事物提交之后解锁
                TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
                    @Override
                    public void afterCommit() {
                        //事物提交之后执行解锁和修改索引操作
                        //解锁
                        RedissLockUtil.unlock(e.getLevelSpecQuoteId().toString());
                        logger.debug("更新索引并解锁：", e.getLevelSpecQuoteId().toString());
                        BatchUpdSearchPo msspo = new BatchUpdSearchPo();
                        msspo.setListIdPo(comIdList);
                        try {
                            productMss.updateBatchCommditySearch(msspo);
                        } catch (Exception e1) {
                            logger.debug("更新索引发生错误 ");
                        }
                        //库存小于10发送消息
                        if (e.getCount()+10 > leveInfo.getAvaiSupplyCount()) {
                            Map<String, Object> pm = Maps.newHashMap();
                            pm.put("timType", TIMNoticeConstants.TPL_KEY_PRD_STOCK_WAR);
                            pm.put("id", leveInfo.getCommPubId());
                            pm.put("commName", leveInfo.getCommTitle());
                            pm.put("commSpec", leveInfo.getCommSpec());
                            pm.put("transType", DictConstants.TRANS_TYPE_1);
                            pm.put("staffId", leveInfo.getStallsMageId());
                            pm.put("userId", leveInfo.getSellerId());
                            timSendService.sendTim(pm);
                        }
                    }
                });
            }
        }
        for (BuyerOrderInfoVo orderInfo : ordNumList) {
            //事物提交之后发送消息
            Map<String, Object> param = Maps.newHashMap();
            param.put("timType", TIMNoticeConstants.TPL_KEY_ORD_UN_COFM);
            param.put("id", orderInfo.getId());
            param.put("staffId", orderInfo.getStallsMageId());
            param.put("userId", orderInfo.getSellerId());
            param.put("transType", DictConstants.TRANS_TYPE_1);
            param.put("ordNum", orderInfo.getOrdNum());
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
                @Override
                public void afterCommit() {
                    timSendService.sendTim(param);
                }
            });
        }
        //构造返回值
        BuyerGeneratingOrderVo vo = new BuyerGeneratingOrderVo();
        vo.setAmountPayable(totalMoney);
        vo.setOrdInfoList(ordNumList);
        vo.setTotalCount(commCount);
        vo.setTotalSeller(map.size());
        vo.setTotalStall(ordNumList.size());
        resultPoJo.setResult(vo);
        return resultPoJo;
    }
}
