package com.wisea.transac.seller.service;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.dao.BaseInfoMapper;
import com.wisea.transac.common.dao.CommPubInfoMapper;
import com.wisea.transac.common.dao.PlantationInfoMapper;
import com.wisea.transac.common.dao.PlantationPictureMapper;
import com.wisea.transac.common.dao.PlantationRealTimeVideoMapper;
import com.wisea.transac.common.dao.PlantationSensorMapper;
import com.wisea.transac.common.entity.BaseInfo;
import com.wisea.transac.common.entity.CommPubInfo;
import com.wisea.transac.common.entity.MembBaseInfo;
import com.wisea.transac.common.entity.PlantationInfo;
import com.wisea.transac.common.entity.PlantationPicture;
import com.wisea.transac.common.entity.PlantationRealTimeVideo;
import com.wisea.transac.common.entity.PlantationSensor;
import com.wisea.transac.common.entity.StorageInfo;
import com.wisea.transac.common.po.seller.EquInfoPo;
import com.wisea.transac.common.po.seller.EquInfoRemotPo;
import com.wisea.transac.common.po.seller.PlantationInfoPagePo;
import com.wisea.transac.common.po.seller.PlantationInfoPo;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.vo.CommPubInfoInfoVo;
import com.wisea.transac.common.vo.seller.PlantationInfoListVo;
import com.wisea.transac.common.vo.seller.PlantationInfoVo;
import com.wisea.transac.seller.mss.EquipmentMss;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jirg
 * @version 1.0
 * @className PlantationInfoService
 * @date 2020/7/2 16:42
 * @Description 种植园管理Service
 */
@Service
public class PlantationInfoService extends BaseService {
    @Autowired
    private PlantationInfoMapper mapper;
    @Autowired
    private PlantationPictureMapper pictureMapper;
    @Autowired
    private PlantationRealTimeVideoMapper timeVideoMapper;
    @Autowired
    private PlantationSensorMapper sensorMapper;
    @Autowired
    private BaseInfoMapper baseInfoMapper;
    @Autowired
    private CommPubInfoMapper commPubInfoMapper;
    @Autowired
    private EquipmentMss equipmentMss;

    /**
     * @author jirg
     * @date 2020/7/2 16:48
     * @Description 种植园列表
     */
    public ResultPoJo<List<PlantationInfoListVo>> findList(LongIdPo po) {
        LoggerUtil.infoWithContext("【findList】种植园列表：", po);
        ResultPoJo<List<PlantationInfoListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        BaseInfo baseInfo = baseInfoMapper.selectByPrimaryKey(po.getId());
        if (ConverterUtil.isNotEmpty(baseInfo)) {
            User user = SystemUtils.getUser();
            MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(user.getId());
            if (baseInfo.getMembId().equals(membInfo.getMembId())) {
                List<PlantationInfoListVo> list = mapper.findListByBaseId(po);
                resultPoJo.setResult(list);
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
     * @date 2020/7/2 17:10
     * @Description 种植园详细信息
     */
    public ResultPoJo<PlantationInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】种植园详细信息：", po);
        ResultPoJo<PlantationInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        PlantationInfoVo vo = mapper.findPlantationInfo(po);
        if (ConverterUtil.isNotEmpty(vo)) {
            resultPoJo.setResult(vo);
        } else {
            resultPoJo.setCode(ConstantCodeMsg.ERR_004);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * @author jirg
     * @date 2020/7/2 17:29
     * @Description 新增或修改种植园
     */
    @Transactional(readOnly = false)
    public ResultPoJo<?> saveOrUpdate(PlantationInfoPo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改种植园", null);
        ResultPoJo<?> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        BaseInfo baseInfo = baseInfoMapper.selectByPrimaryKey(po.getBaseId());
        if (ConverterUtil.isNotEmpty(baseInfo)) {
            User user = SystemUtils.getUser();
            MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(user.getId());
            if (baseInfo.getMembId().equals(membInfo.getMembId())) {
                PlantationInfo plantationInfo;
                if (ConverterUtil.isNotEmpty(po.getId())) {
                    //修改
                    plantationInfo = mapper.selectByPrimaryKey(po.getId());
                    if (ConverterUtil.isEmpty(plantationInfo)) {
                        resultPoJo.setCode(ConstantCodeMsg.ERR_004);
                        resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
                        return resultPoJo;
                    }
                    BeanUtils.copyProperties(po, plantationInfo);
                    plantationInfo.preUpdate();
                    mapper.updateByPrimaryKey(plantationInfo);
                } else {
                    //新增
                    plantationInfo = new PlantationInfo();
                    BeanUtils.copyProperties(po, plantationInfo);
                    plantationInfo.preInsert();
                    mapper.insert(plantationInfo);
                }

                Long plantationId = plantationInfo.getId();

                //仓储物联网传感器
                sensorMapper.deleteByPlantationId(plantationId);
                if (ConverterUtil.isNotEmpty(po.getEquInfo())) {
                    EquInfoPo equInfo = po.getEquInfo();
                    PlantationSensor plantationSensor = new PlantationSensor();
                    BeanUtils.copyProperties(equInfo, plantationSensor);
                    plantationSensor.setPlantationId(plantationId);
                    plantationSensor.preInsert();
                    sensorMapper.insert(plantationSensor);

                    //调用远程设备服务，添加设备
                    EquInfoRemotPo remotPo = new EquInfoRemotPo();
                    remotPo.setEquName(plantationSensor.getInstallPosition());
                    remotPo.setEquNum(plantationSensor.getEquNum());
                    remotPo.setEquEntpId(plantationSensor.getEquEntpId());
                    remotPo.setEquModelId(plantationSensor.getEquModelId());
                    ResultPoJo<?> remotResult = equipmentMss.remotSaveEquInfo(remotPo);
                }

                //删除旧图片文件数据
                pictureMapper.delByPlantationId(plantationId);
                //新增新的图片数据
                List<PlantationPicture> pictures = Lists.newArrayList();
                po.getFiles().forEach(e -> {
                    PlantationPicture picture = new PlantationPicture();
                    picture.setPlantationId(plantationId);
                    picture.setUrl(e.getFileUrl());
                    picture.setSort(e.getSort());
                    picture.setBasePictureType(e.getFileType());
                    picture.preInsert();
                    pictures.add(picture);
                });
                pictureMapper.batchInsert(pictures);
                //删除旧实时视频数据
                timeVideoMapper.delByPlantationId(plantationId);
                //新增新的实时视频数据
                if (ConverterUtil.isNotEmpty(po.getLiveVideos()) && po.getLiveVideos().size() > 0) {
                    List<PlantationRealTimeVideo> timeVideos = Lists.newArrayList();
                    po.getLiveVideos().forEach(e -> {
                        PlantationRealTimeVideo timeVideo = new PlantationRealTimeVideo();
                        timeVideo.setPlantationId(plantationId);
                        timeVideo.setInstallPosition(e.getInstallPosition());
                        timeVideo.setUrl(e.getUrl());
                        timeVideo.setEquManufact(e.getEquManufact());
                        timeVideo.setEquNum(e.getEquNum());
                        timeVideo.setSort(e.getSort());
                        timeVideo.preInsert();
                        timeVideos.add(timeVideo);
                    });
                    timeVideoMapper.batchInsert(timeVideos);
                }
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
     * @date 2020/7/2 14:11
     * @Description 删除种植园
     */
    @Transactional(readOnly = false)
    public ResultPoJo<?> delPlantationInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】删除种植园：", po);
        ResultPoJo<?> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        PlantationInfo plantationInfo = mapper.selectByPrimaryKey(po.getId());
        if (ConverterUtil.isNotEmpty(plantationInfo)) {
            BaseInfo baseInfo = baseInfoMapper.selectByPrimaryKey(plantationInfo.getBaseId());
            User user = SystemUtils.getUser();
            MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(user.getId());
            if (baseInfo.getMembId().equals(membInfo.getMembId())) {
                Long plantationId = plantationInfo.getId();
                //判断当前种植园下是否有在售的商品
                List<CommPubInfo> commPubInfos = commPubInfoMapper.findByPlantationId(plantationId);
                if (ConverterUtil.isEmpty(commPubInfos)) {
                    //没有在售的商品，删除种植园（逻辑）
                    plantationInfo.setDelFlag(StorageInfo.DEL_FLAG_DELETE);
                    plantationInfo.preUpdate();
                    mapper.updateByPrimaryKey(plantationInfo);
                } else {
                    //还有在售的商品不能删除
                    resultPoJo.setCode(ConstantCodeMsg.ERR_537);
                    resultPoJo.setMsg(ConstantCodeMsg.MSG_537);
                }
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
     * 买家在线查看种植园列表
     *
     * @param po
     *
     * @return
     */
    public ResultPoJo<Page<PlantationInfoVo>> findListForBuyer(PlantationInfoPagePo po) {
        LoggerUtil.infoWithContext("【findList】种植园列表：", po);
        ResultPoJo<Page<PlantationInfoVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        Page<PlantationInfoVo> page = po.getPage();
        BaseInfo baseInfo = baseInfoMapper.selectByPrimaryKey(po.getBaseId());
        if (ConverterUtil.isNotEmpty(baseInfo)) {
            List<PlantationInfoVo> list = mapper.findListByBaseIdForPage(po);

            list.stream().forEach(i -> {
                List<CommPubInfo> commPubInfos = commPubInfoMapper.findByPlantationId(i.getId());
                List<CommPubInfoInfoVo> collect = commPubInfos.stream().map(j -> {
                    CommPubInfoInfoVo infoVo = new CommPubInfoInfoVo();
                    ConverterUtil.copyProperties(j, infoVo);
                    return infoVo;
                }).collect(Collectors.toList());

                i.setCommPubInfos(collect);
                i.setSaleCount(commPubInfos.size());
            });
            page.setList(list);
            resultPoJo.setResult(page);
        }
        return resultPoJo;
    }

    /**
     * 买家在线查看种植园详情
     *
     * @param po
     *
     * @return
     */
    public ResultPoJo<PlantationInfoVo> findInfoForBuyer(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】种植园详细信息：", po);
        ResultPoJo<PlantationInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        PlantationInfoVo vo = mapper.findPlantationInfo(po);
        if (ConverterUtil.isNotEmpty(vo)) {
            List<CommPubInfoInfoVo> pubInfoInfoVos = commPubInfoMapper.findByPlantationId(vo.getId()).
                    stream().map(i -> {
                CommPubInfoInfoVo infoVo = new CommPubInfoInfoVo();
                ConverterUtil.copyProperties(i, infoVo);
                return infoVo;
            }).collect(Collectors.toList());

            vo.setCommPubInfos(pubInfoInfoVos);
            resultPoJo.setResult(vo);
        } else {
            resultPoJo.setCode(ConstantCodeMsg.ERR_004);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
        }
        return resultPoJo;
    }

}
