package com.wisea.transac.seller.service;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.dao.BaseInfoMapper;
import com.wisea.transac.common.dao.CommPubInfoMapper;
import com.wisea.transac.common.dao.StorageInfoMapper;
import com.wisea.transac.common.dao.StoragePictureMapper;
import com.wisea.transac.common.dao.StorageRealTimeVideoMapper;
import com.wisea.transac.common.dao.StorageSensorMapper;
import com.wisea.transac.common.entity.BaseInfo;
import com.wisea.transac.common.entity.CommPubInfo;
import com.wisea.transac.common.entity.MembBaseInfo;
import com.wisea.transac.common.entity.StorageInfo;
import com.wisea.transac.common.entity.StoragePicture;
import com.wisea.transac.common.entity.StorageRealTimeVideo;
import com.wisea.transac.common.entity.StorageSensor;
import com.wisea.transac.common.po.seller.EquInfoPo;
import com.wisea.transac.common.po.seller.EquInfoRemotPo;
import com.wisea.transac.common.po.seller.StorageInfoPo;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.vo.CommPubInfoInfoVo;
import com.wisea.transac.common.vo.seller.StorageInfoListVo;
import com.wisea.transac.common.vo.seller.StorageInfoVo;
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
 * @className StorageInfoService
 * @date 2020/7/2 13:47
 * @Description 仓储信息Service
 */
@Service
public class StorageInfoService extends BaseService {
    @Autowired
    private StorageInfoMapper mapper;
    @Autowired
    private StoragePictureMapper pictureMapper;
    @Autowired
    private StorageRealTimeVideoMapper timeVideoMapper;
    @Autowired
    private StorageSensorMapper storageSensorMapper;
    @Autowired
    private BaseInfoMapper baseInfoMapper;
    @Autowired
    private CommPubInfoMapper commPubInfoMapper;
    @Autowired
    private EquipmentMss equipmentMss;

    /**
     * @author jirg
     * @date 2020/7/2 14:06
     * @Description 仓储列表
     */
    public ResultPoJo<List<StorageInfoListVo>> findList(LongIdPo po) {
        LoggerUtil.infoWithContext("【findList】仓储列表：", po);
        ResultPoJo<List<StorageInfoListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        BaseInfo baseInfo = baseInfoMapper.selectByPrimaryKey(po.getId());
        if (ConverterUtil.isNotEmpty(baseInfo)) {
            User user = SystemUtils.getUser();
            MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(user.getId());
            if (baseInfo.getMembId().equals(membInfo.getMembId())) {
                List<StorageInfoListVo> list = mapper.findListByBaseId(po);
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
     * @date 2020/7/2 14:11
     * @Description 仓储详细信息
     */
    public ResultPoJo<StorageInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】仓储详细信息：", po);
        ResultPoJo<StorageInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        StorageInfoVo vo = mapper.findStorageInfo(po);
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
     * @date 2020/7/2 14:11
     * @Description 新增或修改仓储
     */
    @Transactional(readOnly = false)
    public ResultPoJo<?> saveOrUpdate(StorageInfoPo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改仓储", po);
        ResultPoJo<?> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        BaseInfo baseInfo = baseInfoMapper.selectByPrimaryKey(po.getBaseId());
        if (ConverterUtil.isNotEmpty(baseInfo)) {
            User user = SystemUtils.getUser();
            MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(user.getId());
            if (baseInfo.getMembId().equals(membInfo.getMembId())) {
                StorageInfo storageInfo;
                if (ConverterUtil.isNotEmpty(po.getId())) {
                    //修改
                    storageInfo = mapper.selectByPrimaryKey(po.getId());
                    if (ConverterUtil.isEmpty(storageInfo)) {
                        resultPoJo.setCode(ConstantCodeMsg.ERR_004);
                        resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
                        return resultPoJo;
                    }
                    BeanUtils.copyProperties(po, storageInfo);
                    storageInfo.preUpdate();
                    mapper.updateByPrimaryKey(storageInfo);
                } else {
                    //新增
                    storageInfo = new StorageInfo();
                    BeanUtils.copyProperties(po, storageInfo);
                    storageInfo.preInsert();
                    mapper.insert(storageInfo);
                }

                Long storageId = storageInfo.getId();

                //仓储物联网传感器
                storageSensorMapper.deleteByStorageId(storageId);
                if (ConverterUtil.isNotEmpty(po.getEquInfo())) {
                    EquInfoPo equInfo = po.getEquInfo();
                    StorageSensor storageSensor = new StorageSensor();
                    BeanUtils.copyProperties(equInfo, storageSensor);
                    storageSensor.setStorageId(storageId);
                    storageSensor.preInsert();
                    storageSensorMapper.insert(storageSensor);

                    //调用远程设备服务，添加设备
                    EquInfoRemotPo remotPo = new EquInfoRemotPo();
                    remotPo.setEquName(storageSensor.getInstallPosition());
                    remotPo.setEquNum(storageSensor.getEquNum());
                    remotPo.setEquEntpId(storageSensor.getEquEntpId());
                    remotPo.setEquModelId(storageSensor.getEquModelId());
                    ResultPoJo<?> remotResult = equipmentMss.remotSaveEquInfo(remotPo);
                }

                //删除旧图片文件数据
                pictureMapper.delByStorageId(storageId);
                //新增新的图片数据
                List<StoragePicture> pictures = Lists.newArrayList();
                po.getFiles().forEach(e -> {
                    StoragePicture picture = new StoragePicture();
                    picture.setStorageId(storageId);
                    picture.setBasePictureType(e.getFileType());
                    picture.setUrl(e.getFileUrl());
                    picture.setSort(e.getSort());
                    picture.preInsert();
                    pictures.add(picture);
                });
                pictureMapper.batchInsert(pictures);

                //删除旧实时视频数据
                timeVideoMapper.delByStorageId(storageId);
                //新增新的实时视频数据
                if (ConverterUtil.isNotEmpty(po.getLiveVideos()) && po.getLiveVideos().size() > 0) {
                    List<StorageRealTimeVideo> timeVideos = Lists.newArrayList();
                    po.getLiveVideos().forEach(e -> {
                        StorageRealTimeVideo timeVideo = new StorageRealTimeVideo();
                        timeVideo.setStorageId(storageId);
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
     * @Description 删除仓储
     */
    @Transactional(readOnly = false)
    public ResultPoJo<?> delStorageInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】删除仓储：", po);
        ResultPoJo<?> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        StorageInfo sortingFactory = mapper.selectByPrimaryKey(po.getId());
        if (ConverterUtil.isNotEmpty(sortingFactory)) {
            BaseInfo baseInfo = baseInfoMapper.selectByPrimaryKey(sortingFactory.getBaseId());
            User user = SystemUtils.getUser();
            MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(user.getId());
            if (baseInfo.getMembId().equals(membInfo.getMembId())) {
                Long sortingFactoryId = sortingFactory.getId();
                //判断当前仓库下是否有在售的商品
                List<CommPubInfo> commPubInfos = commPubInfoMapper.findBySortingFactoryId(sortingFactoryId);
                if (ConverterUtil.isEmpty(commPubInfos)) {
                    //没有在售的商品，删除仓储（逻辑）
                    sortingFactory.setDelFlag(StorageInfo.DEL_FLAG_DELETE);
                    sortingFactory.preUpdate();
                    mapper.updateByPrimaryKey(sortingFactory);
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
     * 买家查看仓库列表
     *
     * @param po
     *
     * @return
     */
    public ResultPoJo<List<StorageInfoListVo>> findListForBuyer(LongIdPo po) {
        LoggerUtil.infoWithContext("【findList】仓储列表：", po);
        ResultPoJo<List<StorageInfoListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        BaseInfo baseInfo = baseInfoMapper.selectByPrimaryKey(po.getId());
        if (ConverterUtil.isNotEmpty(baseInfo)) {
            List<StorageInfoListVo> list = mapper.findListByBaseId(po);
            list.stream().forEach(i -> {
                List<CommPubInfo> commPubInfoList = commPubInfoMapper.findBySortingFactoryId(i.getId());
                i.setSaleCount(commPubInfoList.size());

                List<StorageRealTimeVideo> videos = timeVideoMapper.findByStorageId(i.getId());
                i.setVideoFlag(videos.size() > 0 ? "1" : "0");

            });

            resultPoJo.setResult(list);
        } else {
            //数据不属于当前登录用户，没有权限操作
            resultPoJo.setCode(ConstantCodeMsg.ERR_534);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_534);
        }
        return resultPoJo;
    }

    /**
     * 买家查看仓库详情
     *
     * @param po
     *
     * @return
     */
    public ResultPoJo<StorageInfoVo> findInfoForBuyer(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】仓储详细信息：", po);
        ResultPoJo<StorageInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        StorageInfoVo vo = mapper.findStorageInfo(po);
        if (ConverterUtil.isNotEmpty(vo)) {
            List<CommPubInfoInfoVo> pubInfoInfoVos = commPubInfoMapper.findBySortingFactoryId(vo.getId()).
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
