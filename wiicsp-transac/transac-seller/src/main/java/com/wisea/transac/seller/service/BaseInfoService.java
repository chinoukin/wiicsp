package com.wisea.transac.seller.service;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.po.seller.BaseInfoPagePo;
import com.wisea.transac.common.po.seller.BaseInfoPo;
import com.wisea.transac.common.po.seller.BaseVrPo;
import com.wisea.transac.common.po.seller.FollowMerchantBasePo;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.vo.BaseStatVo;
import com.wisea.transac.common.vo.CommPubNumAndWeightVo;
import com.wisea.transac.common.vo.PlaceOriginMagePageListVo;
import com.wisea.transac.common.dao.*;
import com.wisea.transac.common.entity.*;
import com.wisea.transac.common.vo.seller.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author jirg
 * @version 1.0
 * @className BaseInfoService
 * @date 2020/6/30 11:00
 * @Description 数字基地Service
 */
@Service
public class BaseInfoService extends BaseService {
    @Autowired
    private BaseInfoMapper mapper;
    @Autowired
    private BasePictureMapper basePictureMapper;
    @Autowired
    private SortingFactoryMapper sortingFactoryMapper;
    @Autowired
    private StorageInfoMapper storageInfoMapper;
    @Autowired
    private PlantationInfoMapper plantationInfoMapper;
    @Autowired
    private SupPieceInfoMapper supPieceInfoMapper;
    @Autowired
    private CommPubInfoMapper commPubInfoMapper;
    @Autowired
    private PlaceOriginMageMapper placeOriginMageMapper;
    @Autowired
    private FollowMerchantMapper followMerchantMapper;

    /**
     * @author jirg
     * @date 2020/7/3 14:21
     * @Description 查询基地首页信息
     */
    public ResultPoJo<BaseInfoHomeVo> baseHome() {
        LoggerUtil.infoWithContext("【baseHome】查询基地首页信息", null);
        ResultPoJo<BaseInfoHomeVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        User user = SystemUtils.getUser();
        MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(user.getId());
        BaseInfoHomeVo vo = mapper.findBaseHome(membInfo.getMembId());
        resultPoJo.setResult(vo);
        return resultPoJo;
    }

    /**
     * @author jirg
     * @date 2020/6/30 11:29
     * @Description 查询当前登录卖家基地信息
     */
    public ResultPoJo<BaseInfoVo> findInfo() {
        LoggerUtil.infoWithContext("【findInfo】查询当前登录卖家基地信息", null);
        ResultPoJo<BaseInfoVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        User user = SystemUtils.getUser();
        MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(user.getId());
        BaseInfoVo vo = mapper.findByMembId(membInfo.getMembId());
        resultPoJo.setResult(vo);
        return resultPoJo;
    }

    /**
     * @author jirg
     * @date 2020/6/30 14:41
     * @Description 修改基地信息
     */
    @Transactional(readOnly = false)
    public ResultPoJo<?> updateBase(BaseInfoPo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】保存或修改基地信息", po);
        ResultPoJo<BaseInfo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        BaseInfo baseInfo = mapper.selectByPrimaryKey(po.getId());
        if (ConverterUtil.isNotEmpty(baseInfo)) {
            User user = SystemUtils.getUser();
            MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(user.getId());
            if (baseInfo.getMembId().equals(membInfo.getMembId())) {
                if (ConverterUtil.isNotEmpty(baseInfo.getBaseName()) &&
                        !baseInfo.getBaseName().equals(po.getBaseName()) && !baseInfo.getRemarks().equals(baseInfo.getBaseName())) {
                    //基地名称，只能设置一次
                    resultPoJo.setCode(ConstantCodeMsg.ERR_535);
                    resultPoJo.setMsg(ConstantCodeMsg.MSG_535);
                    return resultPoJo;
                }
                BeanUtils.copyProperties(po, baseInfo);
                baseInfo.preUpdate();
                mapper.updateByPrimaryKey(baseInfo);

                List<BasePicture> basePictures = Lists.newArrayList();
                po.getFileLists().forEach(e -> {
                    BasePicture basePicture = new BasePicture();
                    basePicture.setBaseId(baseInfo.getId());
                    basePicture.setBasePictureType(e.getFileType());
                    basePicture.setUrl(e.getFileUrl());
                    basePicture.setSort(e.getSort());
                    basePicture.preInsert();
                    basePictures.add(basePicture);
                });
                //删除基地图片文件
                basePictureMapper.delteByBaseId(baseInfo.getId());
                //批量插入基地图片
                basePictureMapper.batchInsert(basePictures);
            } else {
                //数据不属于当前登录用户，没有权限操作
                resultPoJo.setCode(ConstantCodeMsg.ERR_534);
                resultPoJo.setMsg(ConstantCodeMsg.MSG_534);
            }
        } else {
            resultPoJo.setCode(ConstantCodeMsg.ERR_004);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * @author jirg
     * @date 2020/6/30 17:59
     * @Description 设置基地720VR
     */
    @Transactional(readOnly = false)
    public ResultPoJo<?> setBaseVR(BaseVrPo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】保存或修改基地信息", po);
        ResultPoJo<BaseInfo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        BaseInfo baseInfo = mapper.selectByPrimaryKey(po.getId());
        if (ConverterUtil.isNotEmpty(baseInfo)) {
            User user = SystemUtils.getUser();
            MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(user.getId());
            if (baseInfo.getMembId().equals(membInfo.getMembId())) {
                baseInfo.setVrUrl(po.getVrUrl());
                baseInfo.setVrVideoUrl(po.getVrVideoUrl());
                baseInfo.preUpdate();
                mapper.updateByPrimaryKey(baseInfo);
            } else {
                //数据不属于当前登录用户，没有权限操作
                resultPoJo.setCode(ConstantCodeMsg.ERR_534);
                resultPoJo.setMsg(ConstantCodeMsg.MSG_534);
            }
        } else {
            resultPoJo.setCode(ConstantCodeMsg.ERR_004);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * 分页查询基地信息
     *
     * @param po
     *
     * @return
     */
    public ResultPoJo<Page<BaseInfoVo>> findForPage(BaseInfoPagePo po) {

        ResultPoJo<Page<BaseInfoVo>> result = new ResultPoJo<>();

        Page<BaseInfoVo> page = po.getPage();
        List<BaseInfoVo> list = mapper.findForPage(po);
        page.setList(list);

        result.setResult(page);

        return result;
    }

    /**
     * 基地详情页统计
     *
     * @param po
     *
     * @return
     */
    public ResultPoJo<BaseStatVo> stat(LongIdPo po) {
        BaseStatVo vo = new BaseStatVo();

        List<SortingFactory> factories = sortingFactoryMapper.findAllByBaseId(po.getId());
        //工厂面积
        double sfArea = factories.stream().mapToDouble(SortingFactory::getSortingFactoryMj).sum();
        vo.setSfCount(factories.size());
        vo.setSfArea(sfArea);

        List<StorageInfo> storageInfos = storageInfoMapper.findAllByBaseId(po.getId());
        //仓库面积
        double siArea = storageInfos.stream().mapToDouble(StorageInfo::getStorageMj).sum();
        vo.setSiCount(storageInfos.size());
        vo.setSiArea(siArea);

        List<PlantationInfo> plantationInfos = plantationInfoMapper.findAllByBaseId(po.getId());
        //种植园面积
        double piArea = plantationInfos.stream().mapToDouble(PlantationInfo::getPlantationMj).sum();
        vo.setPiCount(plantationInfos.size());
        vo.setPiArea(piArea);

        //优势单品数量
        Integer spiCount = supPieceInfoMapper.countAllByBaseId(po.getId());
        vo.setSpiCount(spiCount);
//        0,仓储现货,storage_type
//        1,树上果,storage_type
        CommPubInfo commPubInfo = new CommPubInfo();
        commPubInfo.setBaseId(po.getId());
        commPubInfo.setStorageType(DictConstants.STORAGE_TYPE_0);
        List<CommPubNumAndWeightVo> siList = commPubInfoMapper.findAllByBaseIdAndStoreType(commPubInfo);
        Double siTotal = 0D;
        for (CommPubNumAndWeightVo i : siList) {
            if ("KG".equalsIgnoreCase(i.getUnitName()) || "千克".equals(i.getUnitName())) {
                siTotal += i.getCount() / 1000;
            } else if ("G".equalsIgnoreCase(i.getUnitName()) || "克".equals(i.getUnitName())) {
                siTotal += i.getCount() / 1000 / 1000;
            }
        }
        vo.setSiTotal(siTotal);

        commPubInfo.setStorageType(DictConstants.STORAGE_TYPE_1);
        List<CommPubNumAndWeightVo> piLsit = commPubInfoMapper.findAllByBaseIdAndStoreType(commPubInfo);

        Double piTotal = 0D;
        for (CommPubNumAndWeightVo i : piLsit) {
            if ("KG".equalsIgnoreCase(i.getUnitName()) || "千克".equals(i.getUnitName())) {
                piTotal += i.getCount() / 1000;
            } else if ("G".equalsIgnoreCase(i.getUnitName()) || "克".equals(i.getUnitName())) {
                piTotal += i.getCount() / 1000 / 1000;
            }
        }
        vo.setPiTotal(piTotal);

        ResultPoJo<BaseStatVo> result = new ResultPoJo<>();
        result.setResult(vo);
        return result;
    }

    /**
     * 查询国外产地并包括基地数量数据
     *
     * @return
     */
    public ResultPoJo<List<PlaceOriginMagePageListVo>> findAbroadList() {
        ResultPoJo<List<PlaceOriginMagePageListVo>> result = new ResultPoJo<>();
        List<PlaceOriginMagePageListVo> list = placeOriginMageMapper.findAbroadList();
        PlaceOriginMagePageListVo total = new PlaceOriginMagePageListVo();
        total.setCount(list.stream().mapToInt(PlaceOriginMagePageListVo::getCount).sum());
        total.setId(0L);
        total.setPlaceOriginName("全部");
        total.setSort(0);

        list.add(0,total);

        result.setResult(list);
        return result;
    }

    /**
     * 查询国内基地省份和基地数量列表
     * @return
     */
    public ResultPoJo<List<BaseListVo>> finInlandAndBaseCountList() {
        ResultPoJo<List<BaseListVo>> result = new ResultPoJo<>();
        List<BaseListVo> list = mapper.findAllAndCount();
        BaseListVo total = new BaseListVo();
        total.setCount(list.stream().mapToInt(BaseListVo::getCount).sum());
        total.setAreaProvName("全部");
        list.add(0, total);
        result.setResult(list);
        return result;
    }

    /**
     * 查询国内外分类列表
     * @param isAbroad
     * @return
     */
    public ResultPoJo<List<BaseCataTreeVo>> findCataList(Boolean isAbroad) {
        ResultPoJo<List<BaseCataTreeVo>> result = new ResultPoJo<>();
        List<BaseCataListVo> cataList;
        if (isAbroad) {
            cataList = supPieceInfoMapper.findAbroadCataList();
        } else {
            cataList = supPieceInfoMapper.findCataList();
        }
        cataList = cataList.stream().filter(i -> i.getCatgId() != null).collect(Collectors.toList());

        if (cataList.size()==0){
            return result;
        }

        Map<Long, List<BaseCataListVo>> map = cataList.stream()
                .collect(Collectors.groupingBy(BaseCataListVo::getCatgId));

        List<BaseCataTreeVo> list = map.entrySet().stream().map(e -> {

            BaseCataTreeVo treeVo = new BaseCataTreeVo();
            treeVo.setCatgId(e.getKey());
            treeVo.setCatgName(e.getValue().get(0).getCatgName());
            treeVo.setChildren(e.getValue());
            return treeVo;
        }).collect(Collectors.toList());


//        BaseCataTreeVo all = new BaseCataTreeVo();
//        all.setCatgId(0L);
//        all.setCatgName("全部");
//        all.setChildren(cataList);
//        list.add(0,all);

        result.setResult(list);

        return result;
    }


    public ResultPoJo<BaseInfoVo> findById(LongIdPo po) {
        ResultPoJo<BaseInfoVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        BaseInfoVo vo = mapper.findBaseInfoById(po.getId());

        if (vo == null) {
            resultPoJo.setCode("999");
            resultPoJo.setMsg("找不到该基地");
            return resultPoJo;
        }
        User user = SystemUtils.getUser();

        if (user.getId() != null) {
            FollowMerchantBasePo basePo = new FollowMerchantBasePo();
            basePo.setBaseId(vo.getId());
            basePo.setMembId(user.getId());
            FollowMerchant followMerchant = followMerchantMapper.findBaseByBaseIdAndMembId(basePo);
            if (followMerchant != null) {
                vo.setFollow("1");
            }
        }

        resultPoJo.setResult(vo);
        return resultPoJo;
    }
}
