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
import com.wisea.transac.common.dao.SortingFactoryMapper;
import com.wisea.transac.common.dao.SortingFactoryPictureMapper;
import com.wisea.transac.common.dao.SortingRealTimeVideoMapper;
import com.wisea.transac.common.entity.BaseInfo;
import com.wisea.transac.common.entity.MembBaseInfo;
import com.wisea.transac.common.entity.SortingFactory;
import com.wisea.transac.common.entity.SortingFactoryPicture;
import com.wisea.transac.common.entity.SortingRealTimeVideo;
import com.wisea.transac.common.po.seller.SortingFactoryListVo;
import com.wisea.transac.common.po.seller.SortingFactoryPo;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.vo.seller.SortingFactoryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className SortingFactoryService
 * @date 2020/7/1 14:43
 * @Description 分选工厂管理Service
 */
@Service
public class SortingFactoryService extends BaseService {
    @Autowired
    private SortingFactoryMapper mapper;
    @Autowired
    private SortingFactoryPictureMapper pictureMapper;
    @Autowired
    private SortingRealTimeVideoMapper timeVideoMapper;
    @Autowired
    private BaseInfoMapper baseInfoMapper;

    /**
     * @author jirg
     * @date 2020/7/1 14:53
     * @Description 分选工厂列表
     */
    public ResultPoJo<List<SortingFactoryListVo>> findList(LongIdPo po) {
        LoggerUtil.infoWithContext("【findList】分选工厂列表：", po);
        ResultPoJo<List<SortingFactoryListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        BaseInfo baseInfo = baseInfoMapper.selectByPrimaryKey(po.getId());
        if (ConverterUtil.isNotEmpty(baseInfo)) {
            List<SortingFactoryListVo> list = mapper.findListByBaseId(po);
            resultPoJo.setResult(list);
        } else {
            //数据不属于当前登录用户，没有权限操作
            resultPoJo.setCode(ConstantCodeMsg.ERR_534);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_534);
        }
        return resultPoJo;
    }

    /**
     * @author jirg
     * @date 2020/7/2 9:51
     * @Description 分选工厂详细信息
     */
    public ResultPoJo<SortingFactoryVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】基地证书详细信息：", po);
        ResultPoJo<SortingFactoryVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        SortingFactoryVo vo = mapper.findSortingFactoryInfo(po);
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
     * @date 2020/7/2 10:20
     * @Description 新增或修改分选工厂
     */
    @Transactional(readOnly = false)
    public ResultPoJo<?> saveOrUpdate(SortingFactoryPo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改分选工厂", po);
        ResultPoJo<?> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        BaseInfo baseInfo = baseInfoMapper.selectByPrimaryKey(po.getBaseId());
        if (ConverterUtil.isNotEmpty(baseInfo)) {
            User user = SystemUtils.getUser();
            MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(user.getId());
            if (baseInfo.getMembId().equals(membInfo.getMembId())) {
                SortingFactory sortingFactory;
                if (ConverterUtil.isNotEmpty(po.getId())) {
                    //修改
                    sortingFactory = mapper.selectByPrimaryKey(po.getId());
                    if (ConverterUtil.isEmpty(sortingFactory)) {
                        resultPoJo.setCode(ConstantCodeMsg.ERR_004);
                        resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
                        return resultPoJo;
                    }
                    BeanUtils.copyProperties(po, sortingFactory);
                    sortingFactory.preUpdate();
                    mapper.updateByPrimaryKey(sortingFactory);
                } else {
                    //新增
                    sortingFactory = new SortingFactory();
                    BeanUtils.copyProperties(po, sortingFactory);
                    sortingFactory.preInsert();
                    mapper.insert(sortingFactory);
                }
                Long sortingFactoryId = sortingFactory.getId();
                //删除旧图片文件数据
                pictureMapper.delBySortingFactoryId(sortingFactory.getId());
                //新增新的图片数据
                List<SortingFactoryPicture> pictures = Lists.newArrayList();
                po.getFiles().forEach(e -> {
                    SortingFactoryPicture picture = new SortingFactoryPicture();
                    picture.setSortingFactoryId(sortingFactoryId);
                    picture.setUrl(e.getFileUrl());
                    picture.setBasePictureType(e.getFileType());
                    picture.setSort(e.getSort());
                    picture.preInsert();
                    pictures.add(picture);
                });
                pictureMapper.batchInsert(pictures);
                //删除旧实时视频数据
                timeVideoMapper.delBySortingFactoryId(sortingFactory.getId());
                //新增新的实时视频数据
                if (ConverterUtil.isNotEmpty(po.getLiveVideos()) && po.getLiveVideos().size() > 0) {
                    List<SortingRealTimeVideo> timeVideos = Lists.newArrayList();
                    po.getLiveVideos().forEach(e -> {
                        SortingRealTimeVideo timeVideo = new SortingRealTimeVideo();
                        timeVideo.setSortingFactoryId(sortingFactoryId);
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
     * @date 2020/7/2 10:36
     * @Description 删除分选共享
     */
    @Transactional(readOnly = false)
    public ResultPoJo<?> delSortingFactory(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】删除基地证书：", po);
        ResultPoJo<?> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        SortingFactory sortingFactory = mapper.selectByPrimaryKey(po.getId());
        if (ConverterUtil.isNotEmpty(sortingFactory)) {
            BaseInfo baseInfo = baseInfoMapper.selectByPrimaryKey(sortingFactory.getBaseId());
            User user = SystemUtils.getUser();
            MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(user.getId());
            if (baseInfo.getMembId().equals(membInfo.getMembId())) {
                //删除图片文件数据
                pictureMapper.delBySortingFactoryId(sortingFactory.getId());
                //删除实时视频数据
                timeVideoMapper.delBySortingFactoryId(sortingFactory.getId());
                //删除分选工厂
                mapper.deleteByPrimaryKey(sortingFactory.getId());
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

    public ResultPoJo<List<SortingFactoryVo>> findListForBuyer(LongIdPo po) {
        ResultPoJo<List<SortingFactoryVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        BaseInfo baseInfo = baseInfoMapper.selectByPrimaryKey(po.getId());
        if (ConverterUtil.isNotEmpty(baseInfo)) {
            List<SortingFactoryVo> list = mapper.findListByBaseIdForBuyer(po);
            resultPoJo.setResult(list);
        }
        return resultPoJo;
    }



}
