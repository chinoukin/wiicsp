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
import com.wisea.transac.common.dao.BaseCertMageMapper;
import com.wisea.transac.common.dao.BaseCertPictureMapper;
import com.wisea.transac.common.dao.BaseInfoMapper;
import com.wisea.transac.common.entity.BaseCertMage;
import com.wisea.transac.common.entity.BaseCertPicture;
import com.wisea.transac.common.entity.BaseInfo;
import com.wisea.transac.common.entity.MembBaseInfo;
import com.wisea.transac.common.po.seller.BaseCertMagePo;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.vo.seller.BaseCertMageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className BaseCertMageService
 * @date 2020/7/1 9:42
 * @Description 基地证书管理Service
 */
@Service
public class BaseCertMageService extends BaseService {
    @Autowired
    private BaseCertMageMapper mapper;
    @Autowired
    private BaseCertPictureMapper pictureMapper;
    @Autowired
    private BaseInfoMapper baseInfoMapper;

    /**
     * @author jirg
     * @date 2020/7/1 9:44
     * @Description 基地证书列表
     */
    public ResultPoJo<List<BaseCertMageVo>> findList(LongIdPo po) {
        LoggerUtil.infoWithContext("【findList】基地证书列表：", po);
        ResultPoJo<List<BaseCertMageVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        BaseInfo baseInfo = baseInfoMapper.selectByPrimaryKey(po.getId());
        if(ConverterUtil.isNotEmpty(baseInfo)){
            User user = SystemUtils.getUser();
            MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(user.getId());
            if(baseInfo.getMembId().equals(membInfo.getMembId())){
                List<BaseCertMageVo> list = mapper.findListByBaseId(po);
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
     * @date 2020/7/1 10:02
     * @Description 基地证书详细信息
     */
    public ResultPoJo<BaseCertMageVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】基地证书详细信息：", po);
        ResultPoJo<BaseCertMageVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        BaseCertMageVo vo = mapper.findBaseCertInfo(po);
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
     * @date 2020/7/1 10:07
     * @Description 新增或修改基地证书
     */
    @Transactional(readOnly = false)
    public ResultPoJo<?> saveOrUpdate(BaseCertMagePo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改基地证书", po);
        ResultPoJo<BaseInfo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        BaseInfo baseInfo = baseInfoMapper.selectByPrimaryKey(po.getBaseId());
        if(ConverterUtil.isNotEmpty(baseInfo)){
            User user = SystemUtils.getUser();
            MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(user.getId());
            if(baseInfo.getMembId().equals(membInfo.getMembId())){
                //校验基地证书名称是否重复
                BaseCertMage baseCertMage = mapper.findInfo(po);
                if(ConverterUtil.isEmpty(baseCertMage)){
                    if(ConverterUtil.isNotEmpty(po.getId())){
                        //修改
                        baseCertMage = mapper.selectByPrimaryKey(po.getId());
                        if(ConverterUtil.isEmpty(baseCertMage)){
                            resultPoJo.setCode(ConstantCodeMsg.ERR_004);
                            resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
                            return resultPoJo;
                        }
                        baseCertMage.setCertName(po.getCertName());
                        baseCertMage.preUpdate();
                        mapper.updateByPrimaryKey(baseCertMage);
                    }else{
                        //新增
                        baseCertMage = new BaseCertMage();
                        baseCertMage.setCertName(po.getCertName());
                        baseCertMage.setBaseId(po.getBaseId());
                        baseCertMage.preInsert();
                        mapper.insert(baseCertMage);
                    }
                    //删除旧图片文件数据
                    pictureMapper.delByBaseCertId(baseCertMage.getId());
                    //新增新的图片数据
                    List<BaseCertPicture> pictures = Lists.newArrayList();
                    Long baseCertId = baseCertMage.getId();
                    po.getFiles().forEach(e->{
                        BaseCertPicture picture = new BaseCertPicture();
                        picture.setCertMageId(baseCertId);
                        picture.setUrl(e.getFileUrl());
                        picture.preInsert();
                        pictures.add(picture);
                    });
                    pictureMapper.batchInsert(pictures);
                }else{
                    //证书名称重复
                    resultPoJo.setCode(ConstantCodeMsg.ERR_536);
                    resultPoJo.setMsg(ConstantCodeMsg.MSG_536);
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
     * @date 2020/7/1 10:38
     * @Description 删除基地证书
     */
    @Transactional(readOnly = false)
    public ResultPoJo<?> delBaseCert(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】删除基地证书：", po);
        ResultPoJo<?> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        BaseCertMage certMage = mapper.selectByPrimaryKey(po.getId());
        if(ConverterUtil.isNotEmpty(certMage)){
            BaseInfo baseInfo = baseInfoMapper.selectByPrimaryKey(certMage.getBaseId());
            User user = SystemUtils.getUser();
            MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(user.getId());
            if(baseInfo.getMembId().equals(membInfo.getMembId())){
                //删除图片文件数据
                pictureMapper.delByBaseCertId(certMage.getId());
                //删除基地证书
                mapper.deleteByPrimaryKey(certMage.getId());
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
