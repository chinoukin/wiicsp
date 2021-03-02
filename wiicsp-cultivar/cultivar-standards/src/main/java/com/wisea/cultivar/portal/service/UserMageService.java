package com.wisea.cultivar.portal.service;

import com.wisea.cloud.common.constants.Constants;
import com.wisea.cloud.common.mss.RemoteUserMss;
import com.wisea.cloud.common.po.RegisterUserPo;
import com.wisea.cloud.common.po.ResetPasswordUserPo;
import com.wisea.cloud.common.po.UpdateLoginNamePo;
import com.wisea.cloud.common.po.UserRoleUpdatePo;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.IdGen;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.constants.QdcyStandardsError;
import com.wisea.cultivar.portal.entity.UserMage;
import com.wisea.cultivar.portal.mapper.UserMageMapper;
import com.wisea.cultivar.portal.po.*;
import com.wisea.cultivar.portal.vo.UserMageGetVo;
import com.wisea.cultivar.portal.vo.UserMageListVo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * UserMageService
 * 成员管理 Service
 * 2020/08/24 20:28:13
 */
@Service
public class UserMageService extends BaseService {
    @Autowired
    protected UserMageMapper userMageMapper;
    @Autowired(required = false)
    private RemoteUserMss remoteUserMss;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<UserMageListVo>> findPage(UserMagePagePo userMagePagePo) {
        ResultPoJo<Page<UserMageListVo>> result = new ResultPoJo<>();
        Page<UserMageListVo> page = userMagePagePo.getPage();
       /* List<UserMageListVo> list = userMageMapper.findPage(userMagePagePo);
        List<UserMageListVo> userList = new ArrayList<>();
        for (UserMageListVo userMageListVo : list) {
            Long orgId = userMageMapper.getOrgUser(userMageListVo.getSysUserId());
            userMageListVo.setOrgId(orgId);
            String organ = "";
          *//*  if (ConverterUtil.isNotEmpty(orgId)) {
                Org org = userMageMapper.getByIdSysOrg(orgId);
                Org orgf = userMageMapper.getByIdSysOrg(org.getPid());
                organ = orgf.getName() + "-" + org.getName();
            }*//*
            userMageListVo.setOrgan(organ);

            User user = userMageMapper.getSysUserId(userMageListVo.getSysUserId());
            userMageListVo.setLoginName(user.getLoginName());
            userMageListVo.setActiveFlag(user.getActiveFlag());
            userMageListVo.setLoginFlag(user.getLoginFlag());
            userList.add(userMageListVo);
        }*/


        List<UserMageListVo> listzx = userMageMapper.selectPage(userMagePagePo);
        boolean status = Optional.ofNullable(userMagePagePo.getLoginFlag())
                .filter(ConverterUtil::isNotEmpty)
                .isPresent();

        //如果存在
        if (status) {
            listzx = listzx.stream()
                    .filter(x -> x.getLoginFlag().equals(userMagePagePo.getLoginFlag()))
                    .collect(Collectors.toList());
        }
        page.setList(listzx);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<UserMageListVo>> findList(UserMageListPo userMageListPo) {
        ResultPoJo<List<UserMageListVo>> result = new ResultPoJo<>();
        result.setResult(userMageMapper.findList(userMageListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<UserMageGetVo> get(UserMageGetPo userMageGetPo) {
        ResultPoJo<UserMageGetVo> result = new ResultPoJo<>();
        UserMage entity = userMageMapper.selectByPrimaryKey(userMageGetPo.getId());

        Long orgId = userMageMapper.getOrgUser(entity.getSysUserId());
        List<Long> userRoleId = userMageMapper.getUserRole(entity.getSysUserId());
        String ids="";
        for (Long aLong : userRoleId) {
            ids=ids+String.valueOf(aLong)+",";
        }
        System.out.println(ids);
        User user = userMageMapper.getSysUserId(entity.getSysUserId());

        UserMageGetVo vo = new UserMageGetVo();
        ConverterUtil.copyProperties(entity, vo);
        vo.setOrgId(orgId);
        vo.setRoleIdList(ids);
        vo.setLoginName(user.getLoginName());
        vo.setPassword("");
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(UserMageInsertPo userMageInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
     /*   if (!userMageInsertPo.getPassword().equals(userMageInsertPo.getAffirmpassword())){
            result.setCode(QdcyStandardsError.ERR_30003);
            result.setMsg(QdcyStandardsError.MSG_30003);
            return result;
        }*/
        Long suId = null;
        List<User> list = userMageMapper.getByLoginName(userMageInsertPo.getLoginName(), suId);
        if (list.size() > 0) {
            result.setCode(QdcyStandardsError.ERR_30002);
            result.setMsg(QdcyStandardsError.MSG_30002);
            return result;
        }
        RegisterUserPo registerUser = new RegisterUserPo();
        registerUser.setLoginName(userMageInsertPo.getLoginName());// 用户名
        registerUser.setPassword(userMageInsertPo.getPassword());// 密码
        registerUser.setMobile(userMageInsertPo.getTel());// 手机号
        registerUser.setParentId(1L);
        registerUser.setUserType(Constants.USER_TYPE_SUBUSER);
        long sysUserId = IdGen.randomLong();
        registerUser.setId(sysUserId);
        remoteUserMss.register(registerUser);

        UserMage userMage = new UserMage();
        ConverterUtil.copyProperties(userMageInsertPo, userMage);
        userMage.preInsert();
        userMage.setSysUserId(sysUserId);
        userMageMapper.insert(userMage);

        Long userId = userMage.getSysUserId();
        String rolesplit = userMageInsertPo.getRoleIdList();
        String[] split = rolesplit.split(",");
        for (String roleId : split) {
            userMageMapper.addUserRole(userId, Long.valueOf(roleId));
        }
        System.out.println( Long.valueOf(userMageInsertPo.getOrgId()));
        userMageMapper.addOrgUser(userId, Long.valueOf(userMageInsertPo.getOrgId()));
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(UserMageUpdatePo userMageUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
    /*    if (!userMageUpdatePo.getPassword().equals(userMageUpdatePo.getAffirmpassword())){
            result.setCode(QdcyStandardsError.ERR_30003);
            result.setMsg(QdcyStandardsError.MSG_30003);
            return result;
        }*/
        Long suId = userMageUpdatePo.getSysUserId();
        List<User> list = userMageMapper.getByLoginName(userMageUpdatePo.getLoginName(), suId);
        if (list.size() > 0) {
            result.setCode(QdcyStandardsError.ERR_30002);
            result.setMsg(QdcyStandardsError.MSG_30002);
            return result;
        }

        UserMage entity = userMageMapper.selectByPrimaryKey(userMageUpdatePo.getId());
        if (!entity.getTel().equals(userMageUpdatePo.getTel())) {
            User user = new User();
            user.setId(userMageUpdatePo.getSysUserId());
            user.setMobile(userMageUpdatePo.getTel());
            remoteUserMss.mobileUpdate(user);
        }

        UserRoleUpdatePo userRoleUpdatePo = new UserRoleUpdatePo();
        userRoleUpdatePo.setId(userMageUpdatePo.getSysUserId());
        userRoleUpdatePo.setRoleIds(userMageUpdatePo.getRoleIdList());
        remoteUserMss.roleUpdate(userRoleUpdatePo);

        UpdateLoginNamePo updateLoginNamePo = new UpdateLoginNamePo();
        updateLoginNamePo.setId(userMageUpdatePo.getSysUserId());
        updateLoginNamePo.setLoginName(userMageUpdatePo.getLoginName());
        remoteUserMss.updateLoginName(updateLoginNamePo);

        if (userMageUpdatePo.getPassword() != null || userMageUpdatePo.getPassword() != "") {
            ResetPasswordUserPo resetPasswordUserPo = new ResetPasswordUserPo();
            resetPasswordUserPo.setId(userMageUpdatePo.getSysUserId());
            resetPasswordUserPo.setNewPassword(userMageUpdatePo.getPassword());
            remoteUserMss.pwdReset(resetPasswordUserPo);
        }
        UserMage userMage = new UserMage();
        ConverterUtil.copyProperties(userMageUpdatePo, userMage);
        userMage.preUpdate();
        userMageMapper.updateByPrimaryKeySelective(userMage);
        //  userMageMapper.deleteUserRole(userMageUpdatePo.getId());
        userMageMapper.deleteOrgUser(userMageUpdatePo.getSysUserId());

      /*  List<Long> roleIdList = userMageUpdatePo.getRoleIdList();
        for (Long roleId : roleIdList) {
            userMageMapper.addUserRole(userMageUpdatePo.getId(),roleId);
        }*/
        System.out.println(Long.valueOf(userMageUpdatePo.getOrgId()));
        userMageMapper.addOrgUser(userMageUpdatePo.getSysUserId(),Long.valueOf(userMageUpdatePo.getOrgId()));

        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(UserMageBatDeletePo userMageBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for (Long delId : userMageBatDeletePo.getDelList()) {
            UserMage userMage = new UserMage();
            userMage.setId(delId);
            userMage.preUpdate();
            UserMage entity = userMageMapper.selectByPrimaryKey(delId);
            userMageMapper.deleteLogic(userMage);
            Long sysUserId = entity.getSysUserId();
            userMageMapper.deleteSysUser(sysUserId);
            userMageMapper.deleteUserRole(entity.getSysUserId());
            userMageMapper.deleteOrgUser(entity.getSysUserId());
        }
        return result;
    }


    public ResultPoJo<Object> status(UserMageActiveFlagPo po) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        userMageMapper.status(po);
        return result;
    }
}
