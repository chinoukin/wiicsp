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
import com.wisea.transac.common.dao.SupPieceInfoMapper;
import com.wisea.transac.common.dao.SupPiecePictureMapper;
import com.wisea.transac.common.po.seller.SupPieceInfoPo;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.vo.seller.SupPieceInfoListVo;
import com.wisea.transac.common.vo.seller.SupPieceInfoVo;
import com.wisea.transac.common.entity.BaseInfo;
import com.wisea.transac.common.entity.MembBaseInfo;
import com.wisea.transac.common.entity.SupPieceInfo;
import com.wisea.transac.common.entity.SupPiecePicture;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className SupPieceInfoService
 * @date 2020/7/1 11:21
 * @Description 优势单品Service
 */
@Service
public class SupPieceInfoService extends BaseService {
    @Autowired
    private SupPieceInfoMapper mapper;
    @Autowired
    private SupPiecePictureMapper pictureMapper;
    @Autowired
    private BaseInfoMapper baseInfoMapper;

    /**
     * @author jirg
     * @date 2020/7/1 11:30
     * @Description 优势单品列表
     */
    public ResultPoJo<List<SupPieceInfoListVo>> findList(LongIdPo po) {
        LoggerUtil.infoWithContext("【findList】优势单品列表：", po);
        ResultPoJo<List<SupPieceInfoListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        BaseInfo baseInfo = baseInfoMapper.selectByPrimaryKey(po.getId());
        if(ConverterUtil.isNotEmpty(baseInfo)){
            User user = SystemUtils.getUser();
            MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(user.getId());
            if(baseInfo.getMembId().equals(membInfo.getMembId())){
                List<SupPieceInfoListVo> list = mapper.findListByBaseId(po);
                resultPoJo.setResult(list);
            }else{
                //数据不属于当前登录用户，没有权限操作
                resultPoJo.setCode(ConstantCodeMsg.ERR_534);
                resultPoJo.setMsg(ConstantCodeMsg.MSG_534);
            }
        }else{
            resultPoJo.setCode(ConstantCodeMsg.ERR_004);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * @author jirg
     * @date 2020/7/1 13:19
     * @Description 优势单品详细信息
     */
    public ResultPoJo<SupPieceInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】优势单品详细信息：", po);
        ResultPoJo<SupPieceInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        SupPieceInfoVo vo = mapper.findSupPieceInfo(po);
        if(ConverterUtil.isNotEmpty(vo)){
            resultPoJo.setResult(vo);
        }else{
            resultPoJo.setCode(ConstantCodeMsg.ERR_004);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * @author jirg
     * @date 2020/7/1 13:30
     * @Description 新增或修改优势单品
     */
    @Transactional(readOnly = false)
    public ResultPoJo<?> saveOrUpdate(SupPieceInfoPo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改优势单品", po);
        ResultPoJo<?> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        BaseInfo baseInfo = baseInfoMapper.selectByPrimaryKey(po.getBaseId());
        if(ConverterUtil.isNotEmpty(baseInfo)){
            User user = SystemUtils.getUser();
            MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(user.getId());
            if(baseInfo.getMembId().equals(membInfo.getMembId())){
                SupPieceInfo supPieceInfo;
                if(ConverterUtil.isNotEmpty(po.getId())){
                    //修改
                    supPieceInfo = mapper.selectByPrimaryKey(po.getId());
                    if(ConverterUtil.isEmpty(supPieceInfo)){
                        resultPoJo.setCode(ConstantCodeMsg.ERR_004);
                        resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
                        return resultPoJo;
                    }
                    BeanUtils.copyProperties(po, supPieceInfo);
                    supPieceInfo.preUpdate();
                    mapper.updateByPrimaryKey(supPieceInfo);
                }else{
                    //新增
                    supPieceInfo = new SupPieceInfo();
                    BeanUtils.copyProperties(po, supPieceInfo);
                    supPieceInfo.preInsert();
                    mapper.insert(supPieceInfo);
                }
                //删除旧图片文件数据
                pictureMapper.delBySupPieceId(supPieceInfo.getId());
                //新增新的图片数据
                if(ConverterUtil.isNotEmpty(po.getFiles())){
                    List<SupPiecePicture> pictures = Lists.newArrayList();
                    Long supPieceId = supPieceInfo.getId();
                    po.getFiles().forEach(e->{
                        SupPiecePicture picture = new SupPiecePicture();
                        picture.setSupPieceId(supPieceId);
                        picture.setUrl(e.getFileUrl());
                        picture.setSort(e.getSort());
                        picture.setBasePictureType(e.getFileType());
                        picture.preInsert();
                        pictures.add(picture);
                    });
                    pictureMapper.batchInsert(pictures);
                }
            }else{
                //数据不属于当前登录用户，没有权限操作
                resultPoJo.setCode(ConstantCodeMsg.ERR_534);
                resultPoJo.setMsg(ConstantCodeMsg.MSG_534);
            }
        }else{
            resultPoJo.setCode(ConstantCodeMsg.ERR_004);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * @author jirg
     * @date 2020/7/1 13:42
     * @Description 删除优势单品
     */
    @Transactional(readOnly = false)
    public ResultPoJo<?> delSupPiece(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】删除基地证书：", po);
        ResultPoJo<?> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        SupPieceInfo supPieceInfo = mapper.selectByPrimaryKey(po.getId());
        if(ConverterUtil.isNotEmpty(supPieceInfo)){
            BaseInfo baseInfo = baseInfoMapper.selectByPrimaryKey(supPieceInfo.getBaseId());
            User user = SystemUtils.getUser();
            MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(user.getId());
            if(baseInfo.getMembId().equals(membInfo.getMembId())){
                //删除图片文件数据
                pictureMapper.delBySupPieceId(supPieceInfo.getId());
                //删除优势单品
                mapper.deleteByPrimaryKey(supPieceInfo.getId());
            }else{
                //数据不属于当前登录用户，没有权限操作
                resultPoJo.setCode(ConstantCodeMsg.ERR_534);
                resultPoJo.setMsg(ConstantCodeMsg.MSG_534);
            }
        }else{
            resultPoJo.setCode(ConstantCodeMsg.ERR_004);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
        }
        return resultPoJo;
    }
}
