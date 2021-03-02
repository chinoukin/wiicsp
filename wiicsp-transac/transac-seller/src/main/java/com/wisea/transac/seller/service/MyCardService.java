package com.wisea.transac.seller.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.entity.MembBaseInfo;
import com.wisea.transac.common.entity.MembInfo;
import com.wisea.transac.common.po.seller.QueryEntpAuthPo;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.vo.EntpAuthInfoVo;
import com.wisea.transac.common.vo.PurchaseStaffMageInfoVo;
import com.wisea.transac.common.vo.RealPersonAuthInfoVo;
import com.wisea.transac.common.vo.seller.SellerMembInfoVo;
import com.wisea.transac.common.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyCardService extends BaseService {

    @Autowired
    private MembInfoMapper membInfoMapper;

    @Autowired
    private RealPersonAuthMapper realPersonAuthMapper;

    @Autowired
    private EntpAuthMapper entpAuthMapper;

    @Autowired
    private IndBusiAuthMapper indBusiAuthMapper;

    @Autowired
    private PurchaseStaffMageMapper purchaseStaffMageMapper;
    /**
     * 我的名片
     *
     * @return
     */
    public ResultPoJo<SellerMembInfoVo> findInfo() {
        ResultPoJo<SellerMembInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        SellerMembInfoVo vo = new SellerMembInfoVo();
        User user= SystemUtils.getUser();
        MembBaseInfo info = MembUtils.getMembInfoByUserId(user.getId());
        if(ConverterUtil.isEmpty(info)){
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        vo.setId(info.getId());
        vo.setRegistTel(info.getRegistTel());
        vo.setPetName(info.getPetName());
        vo.setContName(info.getContName());
        vo.setLogoUrl(info.getLogoUrl());
        vo.setEntpAuth(info.getAuthName());
        MembInfo membInfo = membInfoMapper.selectByPrimaryKey(user.getId());
        if(ConverterUtil.isEmpty(membInfo)){
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        vo.setBindWechat(membInfo.getBindWechat());
        vo.setSignature(membInfo.getSignature());
        if (ConverterUtil.isNotEmpty(info.getSaleId()) || ConverterUtil.isNotEmpty(info.getPurId())){
           vo.setRoleFlag("1");
        }else{
           vo.setRoleFlag("0");
        }
        //获取个人认证信息
        RealPersonAuthInfoVo realPerson = realPersonAuthMapper.findInfoByUserId(user.getId());
        if (ConverterUtil.isNotEmpty(realPerson)) {
            vo.setRealPersonAuth(realPerson.getEntpAuthStateType());
        }
        vo.setMembClass(membInfo.getPosition());
        if(info.getId().equals(info.getMembId())){
            vo.setSfAdminFlag(DictConstants.SF_ADMIN_FLAG_0);
        }else{
            LongIdPo po1 = new LongIdPo();
            po1.setId(user.getId());
            PurchaseStaffMageInfoVo purchaseStaffMageInfoVo= purchaseStaffMageMapper.findByPurchaseStaffIdNormal(po1);
            if (ConverterUtil.isNotEmpty(purchaseStaffMageInfoVo)){
                vo.setSfAdminFlag(purchaseStaffMageInfoVo.getSfAdminFlag());
            }

        }
        //是否商家(agent_flag 0:是1:否) 是的话取商家
        if (info.getAgentFlag().equals("0")) {
            QueryEntpAuthPo queryEntpAuthPo = new QueryEntpAuthPo();
           // queryEntpAuthPo.setMembId(info.getMembId());
            if (ConverterUtil.isNotEmpty(info.getPurId())){
                queryEntpAuthPo.setMembId(info.getMembId());
            }else {
                queryEntpAuthPo.setMembId(user.getId());
            }
            queryEntpAuthPo.setAgentFlag(info.getAgentFlag());//标示字段
            queryEntpAuthPo.setCustType(DictConstants.CUST_TYPE_0);
            //查询企业信息
            EntpAuthInfoVo entpAuthInfoVo = entpAuthMapper.findAuthInfo(queryEntpAuthPo);
            if (ConverterUtil.isNotEmpty(entpAuthInfoVo)) {
                if (DictConstants.AUTH_STATE_TYPE_3.equals(entpAuthInfoVo.getAuthStateType())){
                    vo.setEntpAuth(entpAuthInfoVo.getAuthStateType());
                }
            }
        }else{
            QueryEntpAuthPo queryEntpAuthPo = new QueryEntpAuthPo();
            //queryEntpAuthPo.setMembId(info.getMembId());
            if (ConverterUtil.isNotEmpty(info.getPurId())){
                queryEntpAuthPo.setMembId(info.getMembId());
            }else {
                queryEntpAuthPo.setMembId(user.getId());
            }
            queryEntpAuthPo.setCustType(DictConstants.CUST_TYPE_0);
            //查询企业信息
            EntpAuthInfoVo entpAuthInfoVo = entpAuthMapper.findAuthInfo(queryEntpAuthPo);
            if (ConverterUtil.isNotEmpty(entpAuthInfoVo)) {
                if (DictConstants.ENTP_AUTH_STATE_TYPE_0.equals(entpAuthInfoVo.getEntpAuthStateType())){
                    vo.setEntpAuth(entpAuthInfoVo.getEntpAuthStateType());
                }
            }
        }
        if(ConverterUtil.isNotEmpty(vo)){
            resultPoJo.setResult(vo);
        }else{
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }

        return resultPoJo;
    }
}
