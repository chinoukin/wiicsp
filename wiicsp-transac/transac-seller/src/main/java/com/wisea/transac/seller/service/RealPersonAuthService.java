package com.wisea.transac.seller.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.dao.EntpAuthMapper;
import com.wisea.transac.common.dao.IndBusiAuthMapper;
import com.wisea.transac.common.dao.MembInfoMapper;
import com.wisea.transac.common.dao.RealPersonAuthMapper;
import com.wisea.transac.common.entity.MembBaseInfo;
import com.wisea.transac.common.entity.MembInfo;
import com.wisea.transac.common.entity.RealPersonAuth;
import com.wisea.transac.common.po.RealPersonAuthPageListPo;
import com.wisea.transac.common.po.RealPersonAuthPo;
import com.wisea.transac.common.po.seller.QueryEntpAuthPo;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.vo.EntpAuthInfoVo;
import com.wisea.transac.common.vo.RealPersonAuthInfoVo;
import com.wisea.transac.common.vo.RealPersonAuthPageListVo;
import com.wisea.transac.common.vo.seller.AuthInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className RealPersonAuthService
 * @date 2020/04/27 17:01:29
 * @Description
 */
@Service
public class RealPersonAuthService extends BaseService {
    @Autowired
    private RealPersonAuthMapper realPersonAuthMapper;

    @Autowired
    private EntpAuthMapper entpAuthMapper;

    @Autowired
    private IndBusiAuthMapper indBusiAuthMapper;

    @Autowired
    private MembInfoMapper membInfoMapper;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询RealPersonAuth
     */
    public ResultPoJo<Page<RealPersonAuthPageListVo>> findPageList(RealPersonAuthPageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
        ResultPoJo<Page<RealPersonAuthPageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        Page<RealPersonAuthPageListVo> page = po.getPage();
        List<RealPersonAuthPageListVo> list = realPersonAuthMapper.findPageList(po);
        page.setList(list);
        resultPoJo.setResult(page);
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 逻辑删除RealPersonAuth
     */
    @Transactional(readOnly = false)
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        RealPersonAuth entity = realPersonAuthMapper.selectByPrimaryKey(po.getId());
        if (ConverterUtil.isNotEmpty(entity)) {
            entity.setDelFlag(RealPersonAuth.DEL_FLAG_DELETE);
            entity.preUpdate();
            realPersonAuthMapper.updateByPrimaryKey(entity);
        } else {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 新增或修改RealPersonAuth
     */
    @Transactional(readOnly = false)
    public ResultPoJo saveOrUpdate(RealPersonAuthPo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        if (ConverterUtil.isNotEmpty(po.getId())) {
            //修改
            RealPersonAuth entity = realPersonAuthMapper.selectByPrimaryKey(po.getId());
            if (ConverterUtil.isNotEmpty(entity)) {
                BeanUtils.copyProperties(po, entity);
                entity.preUpdate();
                realPersonAuthMapper.updateByPrimaryKeySelective(entity);
            } else {
                resultPoJo.setCode(ConstantError.ERR_004);
                resultPoJo.setMsg(ConstantError.MSG_004);
            }
        } else {
            User user = SystemUtils.getUser();
            //新增
            RealPersonAuth entity = new RealPersonAuth();
            BeanUtils.copyProperties(po, entity);
            entity.preInsert();
            entity.setMembId(user.getId());
            entity.setAuthDate(OffsetDateTime.now());
            entity.setEntpAuthStateType(DictConstants.ENTP_AUTH_STATE_TYPE_0);
            realPersonAuthMapper.insert(entity);
            //更新用户姓名
            MembInfo info = membInfoMapper.selectByPrimaryKey(user.getId());
            if (ConverterUtil.isEmpty(info.getContName())) {
                info.preUpdate();
                info.setContName(po.getRealName());
                membInfoMapper.updateByPrimaryKey(info);
            }
        }
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息RealPersonAuth
     */
    public ResultPoJo<RealPersonAuthInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
        ResultPoJo<RealPersonAuthInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        RealPersonAuthInfoVo vo = realPersonAuthMapper.findInfo(po);
        if (ConverterUtil.isNotEmpty(vo)) {
            resultPoJo.setResult(vo);
        } else {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * 认证信息列表
     *
     * @return
     */
    public ResultPoJo<AuthInfoVo> findAuthList() {
        ResultPoJo<AuthInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        User user = SystemUtils.getUser();
        AuthInfoVo vo = new AuthInfoVo();
        MembBaseInfo membBaseInfo = MembUtils.getMembInfoByUserId(user.getId());
        if (ConverterUtil.isEmpty(membBaseInfo)) {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
            return resultPoJo;
        }
        vo.setAgentFlag(membBaseInfo.getAgentFlag());
        //获取个人认证信息
        RealPersonAuthInfoVo realPerson = realPersonAuthMapper.findInfoByUserId(user.getId());
        if (ConverterUtil.isNotEmpty(realPerson)) {
            vo.setRealPersonAuth(realPerson.getEntpAuthStateType());
            vo.setRealPersonAuthId(realPerson.getId());
        }else{
            vo.setRealPersonAuth(DictConstants.ENTP_AUTH_STATE_TYPE_1);
        }

            QueryEntpAuthPo queryEntpAuthPo = new QueryEntpAuthPo();
            if (ConverterUtil.isNotEmpty(membBaseInfo.getPurId())){
                queryEntpAuthPo.setMembId(membBaseInfo.getMembId());
            }else {
                queryEntpAuthPo.setMembId(user.getId());
            }
            //是否商家(agent_flag 0:是1:否) 是的话取商家
            if (membBaseInfo.getAgentFlag().equals("0")) {
                queryEntpAuthPo.setAgentFlag(membBaseInfo.getAgentFlag());//标示字段
            }
            queryEntpAuthPo.setCustType(DictConstants.CUST_TYPE_0);
            //查询企业信息
            EntpAuthInfoVo entpAuthInfoVo = entpAuthMapper.findAuthInfo(queryEntpAuthPo);
            if (ConverterUtil.isNotEmpty(entpAuthInfoVo)) {
                vo.setEntpAuth(entpAuthInfoVo.getEntpAuthStateType());
                vo.setEntpAuthId(entpAuthInfoVo.getId());
            }else{
                vo.setEntpAuth(DictConstants.ENTP_AUTH_STATE_TYPE_1);
            }
            queryEntpAuthPo.setCustType(DictConstants.CUST_TYPE_1);
            //查询个体户信息
            EntpAuthInfoVo indEntpAuthInfoVo = entpAuthMapper.findAuthInfo(queryEntpAuthPo);
            if (ConverterUtil.isNotEmpty(indEntpAuthInfoVo)){
                vo.setIndBusiAuth(indEntpAuthInfoVo.getEntpAuthStateType());
                vo.setIndBusiAuthId(indEntpAuthInfoVo.getId());
            }else{
                vo.setIndBusiAuth(DictConstants.ENTP_AUTH_STATE_TYPE_1);
            }

        resultPoJo.setResult(vo);
        return resultPoJo;
    }
}
