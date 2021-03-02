package com.wisea.transac.tp.product.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.entity.AreaTree;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.service.SystemCacheService;
import com.wisea.cloud.common.sys.entity.Dict;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.po.CommPubInfoPo;
import com.wisea.transac.common.po.product.*;
import com.wisea.transac.common.utils.AssemblyPriceUtil;
import com.wisea.transac.common.utils.CodeUtils;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.utils.SellerMembUtils;
import com.wisea.transac.common.vo.AgentSerListInfoVo;
import com.wisea.transac.common.vo.CommPubInfoInfoVo;
import com.wisea.transac.common.vo.CommSaleSetInfoVo;
import com.wisea.transac.common.vo.system.EntpCommSerInfoVo;
import com.wisea.transac.tp.product.mss.TpSystemMss;
import com.wisea.transac.common.dao.*;
import com.wisea.transac.common.entity.*;
import com.wisea.transac.common.vo.product.*;
import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.javers.core.diff.Diff;
import org.javers.core.diff.changetype.ValueChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description: 商家商品service
 * @author: wangs
 * @date :2018/9/18
 */
@Service
@Transactional(readOnly = true)
public class SellerGoodsService extends BaseService {

    @Autowired
    CommPubInfoMapper commPubInfoMapper;
    @Autowired
    CommAttriMapper commAttriMapper;
    @Autowired
    CommPictureMapper commPictureMapper;
    @Autowired
    CommAttriService commAttriService;
    @Autowired
    JedisDao jedisDao;
    @Autowired
    SystemCacheService systemCacheService;
    @Autowired
    MeasUnitMageMapper measUnitMageMapper;
    @Autowired
    CheckCommAttriSetServie checkCommAttriSetServie;
    @Autowired
    LevelSpecQuoteMapper levelSpecQuoteMapper;
    @Autowired
    PlaceOriginMageMapper placeOriginMageMapper;
    @Autowired
    CommditySearchService commditySearchSercie;
    @Autowired
    AgentSerListMapper agentSerListMapper;
    @Autowired
    CommSaleSetMapper commSaleSetMapper;
    @Autowired
    NoticeService noticeService;
    @Autowired
    TpSystemMss tpSystemMss;
    @Autowired
    EntpCommSerMapper entpCommSerMapper;

    /**
     * 商家端列表查询
     *
     * @param commPubInfoPagePo
     * @return
     */
    public ResultPoJo<CommPubInfoResultVo<CommPubInfoListVo>> list(CommPubInfoPagePo commPubInfoPagePo) {

        ResultPoJo<CommPubInfoResultVo<CommPubInfoListVo>> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);

        Page<CommPubInfoListVo> page = commPubInfoPagePo.getPage();
        Map<String, Object> stateCount = Maps.newHashMap();
        Map<String, Object> stateCountMap = Maps.newHashMap();
        stateCount.put("0", 0);
        stateCount.put("1", 0);
        stateCount.put("2", 0);
        stateCount.put("3", 0);
        stateCount.put("4", 0);
        if (ConverterUtil.isEmpty(commPubInfoPagePo.getStallsMageIds())) {
            //设置当前登录用户所属档口
            User user = SystemUtils.getUser();
            commPubInfoPagePo.setStallsMageIds(SellerMembUtils.getStallsIds(user.getId()));
        }
        // 小程序中 查看店铺信息;
        if (ConverterUtil.isNotEmpty(commPubInfoPagePo.getMerchantId()) && commPubInfoPagePo.getStallsMageIds().size() == 0) {
            // 对应店铺中的商户id
            commPubInfoPagePo.setStallsMageIds(SellerMembUtils.getStallsIds(commPubInfoPagePo.getMerchantId()));
        }
        // 处理传销售分类的 进口水果信息
        if (ConverterUtil.isNotEmpty(commPubInfoPagePo.getCommSaleCatgId())) {
            List<Long> commSaleSetIds = Lists.newArrayList();
            LongIdPo longIdPo = new LongIdPo();
            longIdPo.setId(commPubInfoPagePo.getCommSaleCatgId());
            List<CommSaleSet> salesClassReleaseList = commSaleSetMapper.findSalesClassReleaseById(longIdPo);
            if (ConverterUtil.isNotEmpty(salesClassReleaseList)) {
                salesClassReleaseList.forEach(e -> {
                    commSaleSetIds.add(e.getId());
                });
            }
            commPubInfoPagePo.setCommSaleSetIds(commSaleSetIds);
        }
        commPubInfoPagePo.setPage(null);
        if (ConverterUtil.isNotEmpty(commPubInfoPagePo.getStallsMageIds()) && commPubInfoPagePo.getStallsMageIds().size() != 0) {
            Map<String, Integer> stateCountMap1 = commPubInfoMapper.getStateCountMap(commPubInfoPagePo);
            stateCountMap.put("result", stateCountMap1);
            stateCountMap.put("stateCount", stateCount);
            commPubInfoPagePo.setPage(page);
            List<CommPubInfoListVo> infoListVo = commPubInfoMapper.findCommPubList(commPubInfoPagePo);
            if (ConverterUtil.isNotEmpty(infoListVo)) {
                infoListVo.forEach(e -> {
                    AssembyPriceVo productPrice = AssemblyPriceUtil.getProductPrice(e.getId());
                    String priceRang = productPrice.getPriceRang();
                    String[] split = priceRang.split("~");
                    e.setPriceRang(priceRang);
                    e.setTransactionAmount(productPrice.getTransactionAmount());
                    e.setMinPrice(split[0]);
                });
            }
            if (ConverterUtil.isNotEmpty(commPubInfoPagePo.getPrice()) && ConverterUtil.isNotEmpty(commPubInfoPagePo.getOrderBy())) {
                if (commPubInfoPagePo.getOrderBy().equals(DictConstants.ASC)) {
                    Collections.sort(infoListVo, Comparator.comparing(CommPubInfoListVo::getCommStateType).thenComparing(CommPubInfoListVo::getMinPrice));
                } else {
                    Collections.sort(infoListVo, Comparator.comparing(CommPubInfoListVo::getCommStateType, Comparator.reverseOrder()).thenComparing(CommPubInfoListVo::getMinPrice, Comparator.reverseOrder()));
                }
            }
            if (ConverterUtil.isNotEmpty(commPubInfoPagePo.getTransactionAmount()) && ConverterUtil.isNotEmpty(commPubInfoPagePo.getOrderBy())) {
                if (commPubInfoPagePo.getOrderBy().equals(DictConstants.ASC)) {
                    Collections.sort(infoListVo, Comparator.comparing(CommPubInfoListVo::getCommStateType).thenComparing(CommPubInfoListVo::getTransactionAmount));
                } else {
                    Collections.sort(infoListVo, Comparator.comparing(CommPubInfoListVo::getCommStateType, Comparator.reverseOrder()).thenComparing(CommPubInfoListVo::getTransactionAmount, Comparator.reverseOrder()));
                }
            }
            page.setList(infoListVo);
        }
        CommPubInfoResultVo<CommPubInfoListVo> vo = new CommPubInfoResultVo();
        vo.setPage(page);
        vo.setStateCountMap(stateCountMap);
        result.setResult(vo);

        return result;

    }

    /**
     * 商家端列表查询
     *
     * @param commPubInfoPagePo
     * @return
     */
    public ResultPoJo<CommPubInfoResultVo<CommPubInfoListVo>> originlist(CommPubInfoPagePo commPubInfoPagePo) {

        ResultPoJo<CommPubInfoResultVo<CommPubInfoListVo>> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);

        if (ConverterUtil.isEmpty(commPubInfoPagePo.getBaseId())) {
            result.setCode(ConstantCodeMsg.ERR_348);
            result.setMsg(ConstantCodeMsg.MSG_348);
            return result;
        }
        Page<CommPubInfoListVo> page = commPubInfoPagePo.getPage();
        Map<String, Object> stateCount = Maps.newHashMap();
        Map<String, Object> stateCountMap = Maps.newHashMap();
        stateCount.put("0", 0);
        stateCount.put("1", 0);
        stateCount.put("2", 0);
        stateCount.put("3", 0);
        stateCount.put("4", 0);
        // 处理传销售分类的 进口水果信息
        if (ConverterUtil.isNotEmpty(commPubInfoPagePo.getCommSaleCatgId())) {
            List<Long> commSaleSetIds = Lists.newArrayList();
            LongIdPo longIdPo = new LongIdPo();
            longIdPo.setId(commPubInfoPagePo.getCommSaleCatgId());
            List<CommSaleSet> salesClassReleaseList = commSaleSetMapper.findSalesClassReleaseById(longIdPo);
            if (ConverterUtil.isNotEmpty(salesClassReleaseList)) {
                salesClassReleaseList.forEach(e -> {
                    commSaleSetIds.add(e.getId());
                });
            }
            commPubInfoPagePo.setCommSaleSetIds(commSaleSetIds);
        }
        commPubInfoPagePo.setPage(null);
        Map<String, Integer> stateCountMap1 = commPubInfoMapper.getStateCountMapOrigin(commPubInfoPagePo);
        stateCountMap.put("result", stateCountMap1);
        stateCountMap.put("stateCount", stateCount);
        commPubInfoPagePo.setPage(page);
        List<CommPubInfoListVo> infoListVo = commPubInfoMapper.findCommPubListOrigin(commPubInfoPagePo);
        if (ConverterUtil.isNotEmpty(infoListVo)) {
            infoListVo.forEach(e -> {
                AssembyPriceVo productPrice = AssemblyPriceUtil.getProductPrice(e.getId());
                if (ConverterUtil.isNotEmpty(productPrice)) {
                    String priceRang = productPrice.getPriceRang();
                    String[] split = priceRang.split("~");
                    e.setPriceRang(priceRang);
                    e.setTransactionAmount(productPrice.getTransactionAmount());
                    e.setMinPrice(split[0]);
                }
            });
        }
        if (ConverterUtil.isNotEmpty(commPubInfoPagePo.getPrice()) && ConverterUtil.isNotEmpty(commPubInfoPagePo.getOrderBy())) {
            if (commPubInfoPagePo.getOrderBy().equals(DictConstants.ASC)) {
                Collections.sort(infoListVo, Comparator.comparing(CommPubInfoListVo::getMinPrice));
            } else {
                Collections.sort(infoListVo, Comparator.comparing(CommPubInfoListVo::getMinPrice).reversed());
            }
        }
        if (ConverterUtil.isNotEmpty(commPubInfoPagePo.getTransactionAmount()) && ConverterUtil.isNotEmpty(commPubInfoPagePo.getOrderBy())) {
            if (commPubInfoPagePo.getOrderBy().equals(DictConstants.ASC)) {
                Collections.sort(infoListVo, Comparator.comparing(CommPubInfoListVo::getTransactionAmount));

            } else {
                Collections.sort(infoListVo, Comparator.comparing(CommPubInfoListVo::getTransactionAmount).reversed());
            }
        }
        page.setList(infoListVo);
        CommPubInfoResultVo<CommPubInfoListVo> vo = new CommPubInfoResultVo();
        vo.setPage(page);
        vo.setStateCountMap(stateCountMap);
        result.setResult(vo);

        return result;

    }

    /**
     * 商品发布,修改操作
     *
     * @param commPubInfoPo
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<String> saveOrUpdate(CommPubInfoPo commPubInfoPo) {

        ResultPoJo<String> result = new ResultPoJo(ConstantCodeMsg.NOMAL);

        if (commPubInfoPo.getLevelSpecQuoteMagePos().size() == 0) {
            result.setCode(ConstantCodeMsg.ERR_395);
            result.setMsg(ConstantCodeMsg.MSG_395);
            return result;
        }
        CommPubInfo commPubInfo = new CommPubInfo();
        ConverterUtil.copyProperties(commPubInfoPo, commPubInfo);
        User user = SystemUtils.getUser();
        if (ConverterUtil.isNotEmpty(user)) {
            MembBaseInfo membInfoUser = MembUtils.getMembInfoByUserId(user.getId());
            commPubInfo.setMembId(membInfoUser.getMembId());
            commPubInfo.setSaleStaffId(membInfoUser.getId());
        } else {
            result.setCode(ConstantCodeMsg.ERR_397);
            result.setMsg(ConstantCodeMsg.MSG_397);
            return result;
        }

        // 商品状态
        ResultPoJo<Dict> setting = tpSystemMss.getSetting();
        String dictValue = setting.getResult().getValue();
        if (dictValue.equals(DictConstants.ENTP_COMM_PUB_EXAM_TYPE_0)) {
            commPubInfo.setCommStateType(DictConstants.COMM_STATE_TYPE_2);
        } else if (dictValue.equals(DictConstants.ENTP_COMM_PUB_EXAM_TYPE_1)) {
            commPubInfo.setCommStateType(DictConstants.COMM_STATE_TYPE_0);
        }
        if (commPubInfoPo.getCommStateType().equals(DictConstants.COMM_STATE_TYPE_2) || commPubInfoPo.getCommStateType().equals(DictConstants.COMM_STATE_TYPE_3) ||
                commPubInfoPo.getCommStateType().equals(DictConstants.COMM_STATE_TYPE_1)) {
            commPubInfo.setCommStateType(commPubInfoPo.getCommStateType());
        }
        if (ConverterUtil.isNotEmpty(commPubInfoPo.getId())) {

            commPubInfo.preUpdate();
            commPictureMapper.delByCommPubInfoId(commPubInfo.getId());
            checkShoppingCartProduct(commPubInfo, commPubInfoPo);
            commAttriMapper.delByCommPubInfoId(commPubInfo.getId());
            if (ConverterUtil.isNotEmpty(commPubInfo.getBaseId())) {
                if (commPubInfo.getStorageType().equals(DictConstants.STORAGE_TYPE_0)) {
                    commPubInfo.setPlantationId(null);
                } else {
                    commPubInfo.setStorageId(null);
                }

            }
            commPubInfoMapper.updateByPrimaryKeySelective(commPubInfo);
            // 组装等级价格信息
            List<LevelSpecQuoteMagePo> levelSpecQuoteMagePos = commPubInfoPo.getLevelSpecQuoteMagePos();
            levelSpecQuoteMagePos.forEach(e -> {
                LevelSpecQuote levelSpecQuote = new LevelSpecQuote();
                levelSpecQuote.setAvaiSupplyCount(e.getAvaiSupplyCount());
                levelSpecQuote.setCommPubId(commPubInfo.getId());
                levelSpecQuote.setMeasUnitId(e.getMeasUnitId());
                levelSpecQuote.setDelFlag(e.getDelFalg());
                MeasUnitMage measUnitMage = measUnitMageMapper.selectByPrimaryKey(e.getMeasUnitId());
                if (!measUnitMage.getDimensionsType().equals(DictConstants.DIMENSIONS_TYPE_0)) {
                    levelSpecQuote.setNetWeight(e.getNetWeight());
                } else if (measUnitMage.getDimensionsType().equals(DictConstants.DIMENSIONS_TYPE_0)) {
                    levelSpecQuote.setNetWeight(measUnitMage.getTransXs());
                }
                levelSpecQuote.setSpec(e.getSpec());
                levelSpecQuote.setId(e.getCommLevelSpecId());
                if (ConverterUtil.isNotEmpty(e.getCommPricePo())) {
                    StringBuilder sb = getStartOrdExpres(e, levelSpecQuote, commPubInfo.getCommNum());
                    levelSpecQuote.setPriceExpres(sb.toString());
                    levelSpecQuote.preUpdate();
                }
                if (ConverterUtil.isNotEmpty(e.getCommLevelSpecId())) {
                    levelSpecQuote.setId(e.getCommLevelSpecId());
                    // 更新等级报价表
                    levelSpecQuoteMapper.updateByPrimaryKeySelective(levelSpecQuote);
                } else {
                    // 销量默认为 0
                    levelSpecQuote.setSalesVolume(0D);
                    levelSpecQuote.setTransactionAmount(0D);
                    levelSpecQuote.setVersionNum(ConverterUtil.getCheckCode(8));
                    levelSpecQuote.setDelFlag(DictConstants.DEL_FLAG_0);
                    levelSpecQuote.preInsert();
                    // 更新等级报价表
                    levelSpecQuoteMapper.insertSelective(levelSpecQuote);
                }
            });

        } else {
            commPubInfo.preInsert();
            commPubInfo.setCommNum(CodeUtils.generateCommPubInfoCode());
            commPubInfo.setVersionNum(ConverterUtil.getCheckCode(8));
            commPubInfoMapper.insertSelective(commPubInfo);

            // 组装等级价格信息
            List<LevelSpecQuoteMagePo> levelSpecQuoteMagePos = commPubInfoPo.getLevelSpecQuoteMagePos();
            List<LevelSpecQuote> commLevelPoList = Lists.newArrayList();
            levelSpecQuoteMagePos.forEach(e -> {
                LevelSpecQuote levelSpecQuote = new LevelSpecQuote();
                levelSpecQuote.setAvaiSupplyCount(e.getAvaiSupplyCount());
                levelSpecQuote.setCommPubId(commPubInfo.getId());
                levelSpecQuote.setMeasUnitId(e.getMeasUnitId());
                MeasUnitMage measUnitMage = measUnitMageMapper.selectByPrimaryKey(e.getMeasUnitId());
                if (!measUnitMage.getDimensionsType().equals(DictConstants.DIMENSIONS_TYPE_0)) {
                    levelSpecQuote.setNetWeight(e.getNetWeight());
                } else if (measUnitMage.getDimensionsType().equals(DictConstants.DIMENSIONS_TYPE_0)) {
                    levelSpecQuote.setNetWeight(measUnitMage.getTransXs());
                }
                levelSpecQuote.setSpec(e.getSpec());
                // 销量默认为 0
                levelSpecQuote.setSalesVolume(0D);
                levelSpecQuote.setTransactionAmount(0D);
                levelSpecQuote.setVersionNum(ConverterUtil.getCheckCode(8));
                if (ConverterUtil.isNotEmpty(e.getCommPricePo())) {
                    StringBuilder sb = getStartOrdExpres(e, levelSpecQuote, commPubInfo.getCommNum());
                    levelSpecQuote.setPriceExpres(sb.toString());
                    levelSpecQuote.preInsert();
                    commLevelPoList.add(levelSpecQuote);
                }
            });

            levelSpecQuoteMapper.batchInsert(commLevelPoList);
        }
        // 处理商品属性
        commAttriPoList(commPubInfoPo, commPubInfo);
        // 图片及 视频
        List<CommPictureMagePo> pictures = commPubInfoPo.getCommPictures();
        if (ConverterUtil.isNotEmpty(pictures)) {
            List<CommPicture> commPictures = Lists.newArrayList();
            pictures.forEach(e -> {
                CommPicture commPicture = new CommPicture();
                commPicture.setUrl(e.getUrl());
                commPicture.setCommPubId(commPubInfo.getId());
                commPicture.setSort(e.getSort());
                commPicture.setCommPictureType(e.getCommPictureType());
                commPicture.preInsert();
                commPictures.add(commPicture);
            });
            commPictureMapper.batchInsert(commPictures);
        }

        if (commPubInfo.getCommStateType().equals(DictConstants.COMM_STATE_TYPE_0)) {
            CommPubInfoGetPo commPubInfoGetPo = new CommPubInfoGetPo();
            commPubInfoGetPo.setId(commPubInfo.getId());
            commditySearchSercie.addIndexSearch(commPubInfoGetPo);
        }
        result.setResult(commPubInfo.getId().toString());
        return result;

    }

    /**
     * 对比商品信息,修改对应版本号;
     *
     * @param commPubInfo
     * @param commPubInfoPo
     * @return
     */
    @Transactional(readOnly = false)
    public DifferentCommPubInfo checkShoppingCartProduct(CommPubInfo commPubInfo, CommPubInfoPo commPubInfoPo) {

        DifferentCommPubInfo differentCommPubInfo = new DifferentCommPubInfo();
        Boolean flag = false;
        Javers javers = JaversBuilder.javers().build();
        // 根据id查询修改前数据信息 包括 商品标题、商品品类、品种,商品属性中commAttriVal字段,
        CheckShopCartProduct oldCommPubInfo = commPubInfoMapper.findDetailById(commPubInfoPo.getId());
        List<LevelSpecQuoteMagePo> commLevelPoList = new ArrayList<>();
        CommPubInfoPo commPubInfoPoOld = new CommPubInfoPo();
        commPubInfoPoOld.setId(oldCommPubInfo.getId());
        commPubInfoPoOld.setCommId(oldCommPubInfo.getCommId());
        commPubInfoPoOld.setCommVarietId(oldCommPubInfo.getCommVarietId());
        if (ConverterUtil.isNotEmpty(oldCommPubInfo.getStallsMageId())) {
            commPubInfoPoOld.setStallsMageId(oldCommPubInfo.getStallsMageId());
        }
        commPubInfoPoOld.setCommTitle(oldCommPubInfo.getCommTitle());
        commPubInfoPoOld.setCommAttris(oldCommPubInfo.getCommAttris());
        if (ConverterUtil.isNotEmpty(commPubInfoPo.getLevelSpecQuoteMagePos())) {
            commLevelPoList.addAll(commPubInfoPo.getLevelSpecQuoteMagePos());
            commPubInfoPo.setLevelSpecQuoteMagePos(null);
        }
        Diff compare = javers.compare(commPubInfoPoOld, commPubInfoPo);
        Diff diff = javers.compareCollections(commPubInfoPoOld.getCommAttris(), commPubInfoPo.getCommAttris(), CommAttriMagePo.class);
        if (compare.hasChanges() || diff.hasChanges()) {
            commPubInfo.setVersionNum(ConverterUtil.getCheckCode(8));
            flag = true;
            differentCommPubInfo.setFlag(flag);
            differentCommPubInfo.setResultMsg(ConstantCodeMsg.MSG_324);
            commPubInfoPo.setLevelSpecQuoteMagePos(commLevelPoList);
        } else {
            commPubInfoPo.setLevelSpecQuoteMagePos(commLevelPoList);
            // 说明商品基础信息没有变化 继续比较 商品规格信息
            List<LevelSpecQuoteMagePo> oldCommPubInfoCommLevelPo = oldCommPubInfo.getCommLevelPo();

            Diff diffCommLeve = javers.compareCollections(oldCommPubInfoCommLevelPo, commLevelPoList, LevelSpecQuoteMagePo.class);

            if (flag == false && diffCommLeve.hasChanges()) {
                List objectsByChangeType = diffCommLeve.getObjectsByChangeType(ValueChange.class);
                for (int i = 0; i < objectsByChangeType.size(); i++) {

                    LevelSpecQuoteMagePo commLevelPo = (LevelSpecQuoteMagePo) objectsByChangeType.get(i);
                    LevelSpecQuote levelSpecQuote = new LevelSpecQuote();
                    levelSpecQuote.setId(commLevelPo.getCommLevelSpecId());
                    levelSpecQuote.setVersionNum(ConverterUtil.getCheckCode(8));
                    // 更新规格表中对应的版本信息
                    levelSpecQuoteMapper.updateByPrimaryKeySelective(levelSpecQuote);
                }

                flag = true;
                differentCommPubInfo.setFlag(flag);
                differentCommPubInfo.setResultMsg(ConstantCodeMsg.MSG_323);
                return differentCommPubInfo;
            } else {
                // 继续对比起订量
                LevelCommPricePo levelCommPricePo = new LevelCommPricePo();
                oldCommPubInfoCommLevelPo.forEach(e -> {
                    List<CommPricePo> commPrice = Lists.newArrayList();
                    String wholePrice = e.getPriceExpres();
                    String[] a = wholePrice.split(" |;|\\|");
                    CommPricePo price = new CommPricePo();
                    for (int i = 0; i < a.length; i++) {
                        if (i % 2 == 0) {
                            String[] split = a[i].split("-");
                            price.setOrderStartCount(split[0]);
                            price.setLevelSpecQuotetId(e.getCommLevelSpecId());
                        } else {
                            price.setPrice(a[i]);
                        }
                        if (ConverterUtil.isNotEmpty(price.getOrderStartCount())) {
                            commPrice.add(price);
                            price = new CommPricePo();
                        }
                    }
                    levelCommPricePo.setCommPricePo(commPrice);
                });
                commLevelPoList.forEach(j -> {
                    if (j.getCommPricePo().size() != levelCommPricePo.getCommPricePo().size()) {
                        LevelSpecQuote levelSpecQuote = new LevelSpecQuote();
                        levelSpecQuote.setId(j.getCommLevelSpecId());
                        levelSpecQuote.setVersionNum(ConverterUtil.getCheckCode(8));
                        // 更新规格表中对应的版本信息
                        levelSpecQuoteMapper.updateByPrimaryKeySelective(levelSpecQuote);
                    }
                    Diff diffComm = javers.compareCollections(levelCommPricePo.getCommPricePo(), j.getCommPricePo(), CommPricePo.class);
                    if (diffComm.hasChanges()) {
                        List objectsByChangeType = diffComm.getObjectsByChangeType(ValueChange.class);
                        for (int i = 0; i < objectsByChangeType.size(); i++) {
                            CommPricePo commLevel = (CommPricePo) objectsByChangeType.get(i);
                            LevelSpecQuote levelSpecQuote = new LevelSpecQuote();
                            levelSpecQuote.setId(j.getCommLevelSpecId());
                            levelSpecQuote.setVersionNum(ConverterUtil.getCheckCode(8));
                            // 更新规格表中对应的版本信息
                            levelSpecQuoteMapper.updateByPrimaryKeySelective(levelSpecQuote);
                        }

                        differentCommPubInfo.setResultMsg(ConstantCodeMsg.MSG_323);
                        differentCommPubInfo.setCode(ConstantCodeMsg.ERR_325);
                    }
                });
            }
        }
        return differentCommPubInfo;
    }

    /**
     * 组装价格区间
     *
     * @param e
     * @param levelSpecQuote
     * @return
     */
    private StringBuilder getStartOrdExpres(LevelSpecQuoteMagePo e, LevelSpecQuote levelSpecQuote, String commNum) {
        List<CommPricePo> commPricePos = e.getCommPricePo();
        // 给阶梯价进行排序
        StringBuilder sb = new StringBuilder();
        String prefix = ";";
        String startCount = commPricePos.get(0).getOrderStartCount();
        MeasUnitMage measUnitMage = measUnitMageMapper.selectByPrimaryKey(e.getMeasUnitId());
        jedisDao.setStr(commNum, startCount.concat(",").concat(measUnitMage.getMeasUnitName()));
        if (commPricePos.size() == 3) {
            CommPricePo commPricePo = commPricePos.get(0);
            CommPricePo commPricePo1 = commPricePos.get(2);
            String price = getWholePriceThree(commPricePos, prefix, startCount);
            sb.append(price);
            levelSpecQuote.setStartOrdExpres(commPricePo1.getPrice().concat("~").concat(commPricePo.getPrice()));
        }
        if (commPricePos.size() == 2) {
            CommPricePo commPricePo = commPricePos.get(0);
            CommPricePo commPricePo1 = commPricePos.get(1);
            String price = getWholePrice(commPricePos, prefix, startCount);
            sb.append(price);
            levelSpecQuote.setStartOrdExpres(commPricePo1.getPrice().concat("~").concat(commPricePo.getPrice()));

        }
        if (commPricePos.size() == 1) {
            CommPricePo commPricePo = commPricePos.get(0);
            String price = startCount.concat("|").concat(commPricePo.getPrice());
            sb.append(price);
            // 去掉拼接 符号信息 fix.concat()
            levelSpecQuote.setStartOrdExpres(commPricePo.getPrice());

        }
        return sb;
    }

    /**
     * 组装验证商品属性信息
     *
     * @param commPubInfoPo
     * @param commPubInfo
     */
    private void commAttriPoList(CommPubInfoPo commPubInfoPo, CommPubInfo commPubInfo) {
        // 商品属性信息
        if (ConverterUtil.isNotEmpty(commPubInfoPo.getCommAttris())) {
            List<CommAttriMagePo> commAttriPoList = commPubInfoPo.getCommAttris();
            List<CommAttri> commAttris = checkCommAttriSetServie.setCommAttris(commAttriPoList, commPubInfo.getCommId(), commPubInfo.getId());
            if (commAttris.size() > 0) {
                commAttriMapper.batchInsert(commAttris);
            }
        }
    }

    /**
     * 拼装3个价格原始价格
     *
     * @param commPricePos
     * @param prefix
     * @param startCount
     * @return
     */
    private String getWholePriceThree(List<CommPricePo> commPricePos, String prefix, String startCount) {
        CommPricePo commPricePo = commPricePos.get(0);
        CommPricePo commPricePo1 = commPricePos.get(1);
        CommPricePo commPricePo2 = commPricePos.get(2);
        String count = commPricePo1.getOrderStartCount();
        int i1 = Integer.valueOf(count) - 1;
        String endCount = commPricePo2.getOrderStartCount();
        int i2 = Integer.valueOf(endCount) - 1;
        String str = startCount.concat("-").concat(String.valueOf(i1)).concat("|").concat(commPricePo.getPrice()).concat(prefix)
                .concat(count).concat("-").concat(String.valueOf(i2)).concat("|").concat(commPricePo1.getPrice()).concat(prefix)
                .concat(endCount).concat("|").concat(commPricePo2.getPrice());
        return str;
    }

    /**
     * 拼装2个价格表达式结构化数据
     *
     * @param commPricePos
     * @param prefix
     * @param startCount
     * @return
     */
    private String getWholePrice(List<CommPricePo> commPricePos, String prefix, String startCount) {
        CommPricePo commPricePo = commPricePos.get(0);
        CommPricePo commPricePo1 = commPricePos.get(1);
        String count = commPricePo1.getOrderStartCount();
        int i1 = Integer.valueOf(count) - 1;
        String str = startCount.concat("-").concat(String.valueOf(i1)).concat("|").concat(commPricePo.getPrice()).concat(prefix)
                .concat(count).concat("|").concat(commPricePo1.getPrice());
        return str;
    }

    /**
     * 商品详情
     *
     * @param commPubInfoGetPo
     * @return
     */
    public ResultPoJo<CommPubInfoInfoVo> details(CommPubInfoGetPo commPubInfoGetPo) {

        ResultPoJo<CommPubInfoInfoVo> PoJo = new ResultPoJo<>(ConstantCodeMsg.ERR_000);

        if (ConverterUtil.isEmpty(commPubInfoGetPo.getId())) {
            PoJo.setCode(ConstantCodeMsg.ERR_385);
            PoJo.setMsg(ConstantCodeMsg.MSG_385);
            return PoJo;
        }
        CommPubInfoInfoVo infoVo = commPubInfoMapper.findById(commPubInfoGetPo);
        if (ConverterUtil.isEmpty(infoVo)) {
            PoJo.setCode(ConstantCodeMsg.ERR_377);
            PoJo.setMsg(ConstantCodeMsg.MSG_377);
            return PoJo;
        }
        User user = SystemUtils.getUser();
        MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(user.getId());
        infoVo.setEntpName(membInfo.getAuthName());
        // 处理口岸名称
        if (ConverterUtil.isNotEmpty(infoVo.getPortId())) {
            infoVo.setAreaProvName(getAreaName(infoVo.getAreaProv()));
        }
        // 处理规格下面的每个阶梯价及计量单位名称
        assemblyPriceReturn(PoJo, infoVo);
        AssembyPriceVo productPrice = AssemblyPriceUtil.getProductPrice(infoVo.getId());
        infoVo.setPriceRange(productPrice.getPriceRang());
        if (ConverterUtil.isNotEmpty(infoVo.getOriginPlaceType())) {
            if (infoVo.getOriginPlaceType().equals(DictConstants.ORIGIN_PLACE_TYPE_0)) {
                infoVo.setCommLocalProvName(getAreaName(infoVo.getCommLocalProv()));
                infoVo.setCommLocalCouName(getAreaName(infoVo.getCommLocalCou()));
                infoVo.setCommLocalCityName(getAreaName(infoVo.getCommLocalCity()));
            } else {
                PlaceOriginMage placeOriginMage = placeOriginMageMapper.selectByPrimaryKey(infoVo.getAbroadId());
                infoVo.setAroudName(placeOriginMage.getPlaceOriginName());
            }
        }
        if (ConverterUtil.isNotEmpty(infoVo.getSerTypeExpres())) {
            List<EntpCommSerInfoVo> agentSerListInfoVos = Lists.newArrayList();
            String[] split = infoVo.getSerTypeExpres().split(",");
            for (int i = 0; i < split.length; i++) {
                LongIdPo longIdPo = new LongIdPo();
                longIdPo.setId(Long.valueOf(split[i]));
                EntpCommSerInfoVo info = entpCommSerMapper.findInfo(longIdPo);
                agentSerListInfoVos.add(info);
            }
            infoVo.setEntpCommSerInfoVo(agentSerListInfoVos);
        }

        PoJo.setResult(infoVo);
        return PoJo;
    }

    /**
     * 根据code码获取节点中文名称
     *
     * @param code
     * @return
     */
    private String getAreaName(String code) {

        AreaTree area = systemCacheService.getArea(code);

        if (ConverterUtil.isEmpty(area)) {

            LoggerUtil.infoWithContext("转换行政地区码-错误信息【{}】", code, ConstantCodeMsg.MSG_387);
            return ConstantCodeMsg.ERR_387;

        }
        return area.getName();
    }

    /**
     * 处理规格下面的每个阶梯价及计量单位名称
     *
     * @param poJo
     * @param infoVo
     */
    private void assemblyPriceReturn(ResultPoJo<CommPubInfoInfoVo> poJo, CommPubInfoInfoVo infoVo) {
        infoVo.getCommLevelPo().forEach(e -> {
            List<CommPricePo> commPrice = Lists.newArrayList();
            String wholePrice = e.getPriceExpres();
            String[] a = wholePrice.split(" |;|\\|");
            if (a.length == 0 || a.length > 6) {
                poJo.setCode(ConstantCodeMsg.ERR_395);
                poJo.setMsg(ConstantCodeMsg.MSG_395);
            }
            MeasUnitMage measUnitMage = measUnitMageMapper.selectByPrimaryKey(e.getMeasUnitId());
            e.setMeasUnitType(measUnitMage.getDimensionsType());
            if (measUnitMage.getDimensionsType().equals(DictConstants.DIMENSIONS_TYPE_0)) {
                Double transXs = measUnitMage.getTransXs();
                e.setMeasUnitTanXS(transXs);
                double totalWeight = ConverterUtil.mul(e.getAvaiSupplyCount(), transXs);
                double totalCount = ConverterUtil.div(totalWeight, 2000, 0);
                double endTotal = ConverterUtil.getRoundDownValue(totalCount, 0);
                e.setTotalAvaliCount(endTotal);
                // 净重
                double totalNetWeight = ConverterUtil.div(transXs, 2000, 0);
                double endTotalNetWeight = ConverterUtil.getRoundDownValue(totalNetWeight, 0).intValue();
                e.setTotalNetWeight(endTotalNetWeight);
            } else {
                double totalWeight = ConverterUtil.mul(e.getAvaiSupplyCount(), e.getNetWeight());
                // 转换成吨
                double totalNetWeight = ConverterUtil.div(e.getNetWeight(), 2000, 0);
                double endTotalNetWeight = ConverterUtil.getRoundDownValue(totalNetWeight, 0).intValue();
                e.setTotalNetWeight(endTotalNetWeight);
                // 库存量
                double totalCount = ConverterUtil.div(totalWeight, 2000, 0);
                double endTotal = ConverterUtil.getRoundDownValue(totalCount, 0).intValue();
                e.setTotalAvaliCount(endTotal);

            }
            e.setMeasUnitName(measUnitMage.getMeasUnitName());

            CommPricePo price = new CommPricePo();
            price.setLevelSpecQuotetId(e.getCommLevelSpecId());
            for (int i = 0; i < a.length; i++) {
                if (i % 2 == 0) {
                    price.setOrderStartCount(a[i]);
                } else {
                    price.setPrice(a[i]);
                }
                if (ConverterUtil.isNotEmpty(price.getOrderStartCount()) && ConverterUtil.isNotEmpty(price.getPrice())) {

                    double jtPrice = Double.valueOf(price.getPrice()).doubleValue();
                    String[] split = price.getOrderStartCount().split("-");
                    double v = Double.valueOf(split[0]).doubleValue();

                    if (measUnitMage.getDimensionsType().equals(DictConstants.DIMENSIONS_TYPE_0)) {
                        // 重量单位中; 总价 / 商品总重量(转换系数 * 起订量) = 每斤多少钱
                        double weightAmount = measUnitMage.getTransXs();
                        price.setNetPrice(ConverterUtil.div(jtPrice, weightAmount, 2));
                    } else {
                        // 非重量单位   总价 / 商品总重量(起订量 * 净重) = 每斤多少钱
                        // 总价 / 重量
                        double weightAmount = e.getNetWeight();
                        price.setNetPrice(ConverterUtil.div(jtPrice, weightAmount, 2));
                    }
                    commPrice.add(price);
                    price = new CommPricePo();
                }
            }
            Collections.sort(commPrice, Comparator.comparing(CommPricePo::getNetPrice).reversed());
            e.setCommPricePo(commPrice);

        });

    }

    /**
     * 改变商品状态
     *
     * @param commPubInfoStatePo
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo changeState(CommPubInfoStatePo commPubInfoStatePo) {

        ResultPoJo PoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        if (ConverterUtil.isEmpty(commPubInfoStatePo.getId()) || ConverterUtil.isEmpty(commPubInfoStatePo.getStateType())) {
            PoJo.setCode(ConstantCodeMsg.ERR_394);
            PoJo.setMsg(ConstantCodeMsg.MSG_394);
            return PoJo;
        }
        CommPubInfo commPubInfo = new CommPubInfo();
        commPubInfo.setId(commPubInfoStatePo.getId());
        commPubInfo.setCommStateType(commPubInfoStatePo.getStateType());
        if (ConverterUtil.isNotEmpty(commPubInfoStatePo.getRejectReason())) {
            commPubInfo.setRejectReason(commPubInfoStatePo.getRejectReason());
        }
        if (ConverterUtil.isNotEmpty(commPubInfoStatePo.getExamId())) {
            commPubInfo.setExamId(commPubInfoStatePo.getExamId());
        }
        commPubInfo.preUpdate();
        // 上架
        if (commPubInfo.getCommStateType().equals(DictConstants.COMM_STATE_TYPE_0)) {
            ResultPoJo<Dict> setting = tpSystemMss.getSetting();
            String dictValue = setting.getResult().getValue();
            if (dictValue.equals(DictConstants.ENTP_COMM_PUB_EXAM_TYPE_0)) {
                commPubInfo.setCommStateType(DictConstants.COMM_STATE_TYPE_2);
            } else if (dictValue.equals(DictConstants.ENTP_COMM_PUB_EXAM_TYPE_1)) {
                commPubInfo.setCommStateType(DictConstants.COMM_STATE_TYPE_0);
                // 商家改变商品状态插入到索引库
                CommPubInfoGetPo commPubInfoGetPo = new CommPubInfoGetPo();
                commPubInfoGetPo.setId(commPubInfo.getId());
                commditySearchSercie.addIndexSearch(commPubInfoGetPo);
            }
            commPubInfoMapper.updateByPrimaryKeySelective(commPubInfo);
        } else if (commPubInfo.getCommStateType().equals(DictConstants.COMM_STATE_TYPE_1)) {

            // 驳回操作
            commPubInfo.setCommStateType(DictConstants.COMM_STATE_TYPE_4);
            commPubInfoMapper.updateByPrimaryKeySelective(commPubInfo);
            // 删除索引库内容
            CommPubInfoGetPo commPubInfoGetPo = new CommPubInfoGetPo();
            commPubInfoGetPo.setId(commPubInfo.getId());
            commditySearchSercie.delIndexSearch(commPubInfoGetPo);

        } else if (commPubInfo.getCommStateType().equals(DictConstants.COMM_STATE_TYPE_2)) {
            // 去审核
            // 审核通过将状态改为销售中
            commPubInfo.setCommStateType(DictConstants.COMM_STATE_TYPE_0);
            commPubInfoMapper.updateByPrimaryKeySelective(commPubInfo);
            // 插入到索引库
            CommPubInfoGetPo commPubInfoGetPo = new CommPubInfoGetPo();
            commPubInfoGetPo.setId(commPubInfo.getId());
            commditySearchSercie.addIndexSearch(commPubInfoGetPo);

        } else if (commPubInfo.getCommStateType().equals(DictConstants.COMM_STATE_TYPE_3)) {
            commPubInfoMapper.updateByPrimaryKeySelective(commPubInfo);
            // 商家改变商品状态从索引库删除
            CommPubInfoGetPo commPubInfoGetPo = new CommPubInfoGetPo();
            commPubInfoGetPo.setId(commPubInfo.getId());
            commditySearchSercie.delIndexSearch(commPubInfoGetPo);

        } else if (commPubInfo.getCommStateType().equals(DictConstants.COMM_STATE_TYPE_5)) {
            // 删除
            commPubInfo.setDelFlag("1");
            commPubInfoMapper.updateByPrimaryKeySelective(commPubInfo);
        }

        return PoJo;
    }

    /**
     * 销售中的商品 - 批量驳回操作
     *
     * @param info
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo updateCommPubInfoState(UpdateCommPubInfoStatesPo info) {

        ResultPoJo poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        if (checkChooseOne(info, poJo)) {
            return poJo;
        }
        CommPubInfo commPubInfo = new CommPubInfo();
        commPubInfo.setCommStateType(info.getStateType());
        commPubInfo.setRejectReason(info.getRejectReason());
        commPubInfo.preUpdate();
        Map<String, Object> maps = Maps.newHashMap();
        maps.put("commPubInfo", commPubInfo);
        maps.put("ids", info.getIds());

        if (info.getStateType().equals(DictConstants.COMM_STATE_TYPE_4)) {
            // 只有销售中状态下的商品 可以批量驳回
            maps.put("stateType", DictConstants.COMM_STATE_TYPE_0);
            List<CommPubInfo> commPubInfos = commPubInfoMapper.findListByCommPubInfoStateType(maps);

            if (commPubInfos.size() > 0) {
                // 修改发布商品状态
                List<Long> ids = commPubInfos.stream().map(CommPubInfo::getId).collect(Collectors.toList());
                maps.put("ids", ids);
                commPubInfoMapper.updateCommPubInfoState(maps);
                // 删除索引库
                ids.forEach(e -> {
                    CommPubInfo pubInfo = commPubInfoMapper.selectByPrimaryKey(e);
                    // 事物提交之后执行删除商品索引
                    CommPubInfoGetPo commPubInfoGetPo = new CommPubInfoGetPo();
                    commPubInfoGetPo.setId(e);
                    commditySearchSercie.delIndexSearch(commPubInfoGetPo);
                    // 发送消息给管理员,业务员 商品被强制下架
                    NoticeProcutPo noticeProcutPo = new NoticeProcutPo();
                    noticeProcutPo.setCommPubStateType(DictConstants.COMM_STATE_TYPE_6);
                    noticeProcutPo.setCommTitle(pubInfo.getCommTitle());
                    if (ConverterUtil.isEmpty(pubInfo.getBaseId())) {
                        List<Long> staffMageIds = Lists.newArrayList();
                        staffMageIds.add(pubInfo.getStallsMageId());
                        noticeProcutPo.setStaffMageIds(staffMageIds);
                    } else {
                        noticeProcutPo.setMembId(pubInfo.getMembId());
                    }
                    noticeService.sendNoticeSer(noticeProcutPo);
                });
            } else {
                poJo.setCode(ConstantCodeMsg.ERR_349);
                poJo.setMsg(ConstantCodeMsg.MSG_349);
                LoggerUtil.infoWithContext("批量修改商品发布状态-错误信息【{}】", info, ConstantCodeMsg.MSG_349);
                return poJo;
            }
        }
        return poJo;
    }

    /**
     * 至少勾选一个信息
     *
     * @param info
     * @param poJo
     * @return
     */
    private boolean checkChooseOne(UpdateCommPubInfoStatesPo info, ResultPoJo poJo) {
        if (info.getIds().size() == 0) {
            poJo.setCode(ConstantCodeMsg.ERR_362);
            poJo.setMsg(ConstantCodeMsg.MSG_362);
            LoggerUtil.infoWithContext("修改商品发布状态-错误信息【{}】", info, ConstantCodeMsg.MSG_362);
            return true;
        }
        return false;
    }

    /**
     * 根据档口id 查询有关联的销售分类信息 去重
     *
     * @param commPubInfoPagePo
     * @return
     */
    public ResultPoJo<List<DistincCommSaleVo>> findCommMageListDisStaffId(CommPubInfoPagePo commPubInfoPagePo) {

        ResultPoJo<List<DistincCommSaleVo>> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);

        if (ConverterUtil.isEmpty(commPubInfoPagePo.getStallsMageIds())) {
            // 设置当前登录用户所属档口
            User user = SystemUtils.getUser();
            commPubInfoPagePo.setStallsMageIds(SellerMembUtils.getStallsIds(user.getId()));
        }

        if (ConverterUtil.isNotEmpty(commPubInfoPagePo.getMerchantId()) && commPubInfoPagePo.getStallsMageIds().size() == 0) {
            // 对应店铺中的商户id
            commPubInfoPagePo.setStallsMageIds(SellerMembUtils.getStallsIds(commPubInfoPagePo.getMerchantId()));
        }
        if (ConverterUtil.isNotEmpty(commPubInfoPagePo.getStallsMageIds()) && commPubInfoPagePo.getStallsMageIds().size() != 0) {
            List<DistincCommSaleVo> commMageListByStaffId = commPubInfoMapper.findCommMageListDistincStaffId(commPubInfoPagePo);
            // 查询销售分类配置 根据设置id 去重了
            List<CommListStaffMageVo> commSaleSetListByStaffId = commPubInfoMapper.findCommMageListByStaffId(commPubInfoPagePo);
            if (ConverterUtil.isNotEmpty(commMageListByStaffId) && ConverterUtil.isNotEmpty(commSaleSetListByStaffId)) {
                commMageListByStaffId.forEach(e -> {
                    List<CommSaleSetInfoVo> listCommSaleSetList = Lists.newArrayList();
                    commSaleSetListByStaffId.forEach(j -> {
                        if (j.getCommSaleCatgId().equals(e.getId())) {
                            CommSaleSetInfoVo commSaleSetInfoVo = new CommSaleSetInfoVo();
                            commSaleSetInfoVo.setCommName(j.getCommName());
                            commSaleSetInfoVo.setId(j.getId());
                            commSaleSetInfoVo.setCommSaleCatgId(j.getCommSaleCatgId());
                            commSaleSetInfoVo.setSort(j.getSort());
                            listCommSaleSetList.add(commSaleSetInfoVo);
                        }
                    });
                    e.setCommSalesSetVoList(listCommSaleSetList);
                });
            }
            result.setResult(commMageListByStaffId);
        }
        return result;

    }
}
