package com.wisea.cultivar.bigdata.service;

import com.wisea.cloud.common.cache.CacheKey;
import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.exception.BusinessException;
import com.wisea.cloud.common.mss.RemoteUserMss;
import com.wisea.cloud.common.po.LoginBatUpdatePo;
import com.wisea.cloud.common.po.RegisterUserPo;
import com.wisea.cloud.common.po.ResetPasswordUserPo;
import com.wisea.cloud.common.po.UpdateLoginNamePo;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.excel.ExportExcel;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.bigdata.constants.ConstantCodeMsg;
import com.wisea.cultivar.bigdata.constants.DictConstants;
import com.wisea.cultivar.common.dao.bigdata.BigdataMembInfoMapper;
import com.wisea.cultivar.common.entity.bigdata.MembInfo;
import com.wisea.cultivar.common.po.bigdata.MembInfoBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.MembInfoGetPo;
import com.wisea.cultivar.common.po.bigdata.MembInfoInsertPo;
import com.wisea.cultivar.common.po.bigdata.MembInfoListPo;
import com.wisea.cultivar.common.po.bigdata.MembInfoPagePo;
import com.wisea.cultivar.common.po.bigdata.MembInfoUpdatePo;
import com.wisea.cultivar.common.vo.bigdata.MembInfoGetVo;
import com.wisea.cultivar.common.vo.bigdata.MembInfoListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.List;

/**
 * MembInfoService
 * 用户管理 Service
 * 2019/12/02 11:02:14
 */
@Service
public class MembInfoService extends BaseService {
    /*@Autowired
    protected BigdataMembInfoMapper bigdataMembInfoMapper;
    @Autowired
    private RemoteUserMss remoteUserMss;
    @Autowired
    private JedisDao jedisDao;

    *//**
     * 查询分页列表
     *//*
    public ResultPoJo<Page<MembInfoListVo>> findPage(MembInfoPagePo membInfoPagePo) {
        ResultPoJo<Page<MembInfoListVo>> result = new ResultPoJo<>();
        Page<MembInfoListVo> page = membInfoPagePo.getPage();
        List<MembInfoListVo> list = bigdataMembInfoMapper.findPage(membInfoPagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    *//**
     * 查询列表
     *//*
    public ResultPoJo<List<MembInfoListVo>> findList(MembInfoListPo membInfoListPo) {
        ResultPoJo<List<MembInfoListVo>> result = new ResultPoJo<>();
        result.setResult(bigdataMembInfoMapper.findList(membInfoListPo));
        return result;
    }

    *//**
     * 查询
     *//*
    public ResultPoJo<MembInfoGetVo> get(MembInfoGetPo membInfoGetPo) {
        ResultPoJo<MembInfoGetVo> result = new ResultPoJo<>();
        MembInfo entity = bigdataMembInfoMapper.selectByPrimaryKey(membInfoGetPo.getId());
        MembInfoGetVo vo = new MembInfoGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    *//**
     * 新增
     *//*
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(MembInfoInsertPo membInfoInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        MembInfoListPo po = new MembInfoListPo();
        po.setUserName(membInfoInsertPo.getUserName());
        List<MembInfoListVo> all = bigdataMembInfoMapper.findAllByUsername(po);
        if (all.size() > 0) {
            result.setCode(ConstantCodeMsg.ERR_310);
            result.setMsg(ConstantCodeMsg.MSG_310);
            return result;
        }

        MembInfo membInfo = new MembInfo();
        ConverterUtil.copyProperties(membInfoInsertPo, membInfo);
        membInfo.setZcDate(OffsetDateTime.now());
        membInfo.setSfqyFlag("1");
        membInfo.preInsert();
        bigdataMembInfoMapper.insert(membInfo);

        RegisterUserPo regUser = new RegisterUserPo();
        regUser.setLoginName(membInfo.getUserName());
        regUser.setPassword(membInfo.getPassword());
        if ("1".equals(membInfoInsertPo.getQxType())) {
            regUser.setUserType("3");//维护人员
        } else {
            regUser.setUserType("1");//查看人员
        }
        ResultPoJo<User> regFlag = remoteUserMss.register(regUser);

        if (!regFlag.getCode().equals("000")) {
            throw new BusinessException(regFlag.getCode(), regFlag.getMsg());
        }
        return result;
    }

    *//**
     * 修改
     *//*
    @Transactional(readOnly = false)
    public ResultPoJo update(MembInfoUpdatePo membInfoUpdatePo) {
        ResultPoJo result = new ResultPoJo<>();
        MembInfo oldUser = bigdataMembInfoMapper.selectByPrimaryKey(membInfoUpdatePo.getId());
        MembInfoListPo po = new MembInfoListPo();
        po.setUserName(membInfoUpdatePo.getUserName());
        po.setId(membInfoUpdatePo.getId());
        List<MembInfoListVo> all = bigdataMembInfoMapper.findAllByUsername(po);
        if (all.size() > 1) {
            result.setCode(ConstantCodeMsg.ERR_310);
            result.setMsg(ConstantCodeMsg.MSG_310);
            return result;
        }

        MembInfo membInfo = new MembInfo();
        ConverterUtil.copyProperties(membInfoUpdatePo, membInfo);
        membInfo.preUpdate();
        bigdataMembInfoMapper.updateByPrimaryKeySelective(membInfo);

        ResultPoJo<User> userMssByLoginName = remoteUserMss.getByLoginName(oldUser.getUserName());
        if (!"000".equals(userMssByLoginName.getCode())) {
            throw new BusinessException(userMssByLoginName.getCode(), userMssByLoginName.getMsg());
        }
        //改用户名
        if (all.size() != 1) {
            UpdateLoginNamePo user = new UpdateLoginNamePo();
            user.setId(userMssByLoginName.getResult().getId());
            user.setLoginName(membInfoUpdatePo.getUserName());
            ResultPoJo<Object> updateFlag = remoteUserMss.updateLoginName(user);
            if (!updateFlag.getCode().equals("000")) {
                throw new BusinessException(updateFlag.getCode(), updateFlag.getMsg());
            }
        }

        //改密码
        if (membInfoUpdatePo.getPassword() != null) {
            ResetPasswordUserPo resetPasswordUserPo = new ResetPasswordUserPo();
            resetPasswordUserPo.setId(userMssByLoginName.getResult().getId());
            resetPasswordUserPo.setNewPassword(membInfoUpdatePo.getPassword());
            ResultPoJo<Object> updatePassword = remoteUserMss.pwdReset(resetPasswordUserPo);
            if (!"000".equals(updatePassword.getCode())) {
                throw new BusinessException(updatePassword.getCode(), updatePassword.getMsg());
            }
        }

        //更改角色
        User user = new User();
        ConverterUtil.copyProperties(userMssByLoginName.getResult(), user);
        if (membInfoUpdatePo.getQxType().equals("0")) {
            user.setUserType("1");
        } else {
            user.setUserType("3");
        }
        ResultPoJo<Object> roleUpdate = remoteUserMss.update(user);

        if (!"000".equals(roleUpdate.getCode())) {
            throw new BusinessException(roleUpdate.getCode(), roleUpdate.getMsg());
        }
        UserUtils.clearCache(UserUtils.getById(user.getId()));
        jedisDao.delSerialize(CacheKey.getJwtTokenKey(user.getLoginName()));
        return result;
    }

    @Transactional(readOnly = false)
    public ResultPoJo enable(MembInfoUpdatePo membInfoUpdatePo) {
        ResultPoJo result = new ResultPoJo<>();

        MembInfo user = bigdataMembInfoMapper.selectByPrimaryKey(membInfoUpdatePo.getId());
        user.setSfqyFlag(membInfoUpdatePo.getSfqyFlag());
        user.preUpdate();
        bigdataMembInfoMapper.updateByPrimaryKeySelective(user);

        ResultPoJo<User> userMssByLoginName = remoteUserMss.getByLoginName(user.getUserName());
        if (!"000".equals(userMssByLoginName.getCode())) {
            throw new BusinessException(userMssByLoginName.getCode(), userMssByLoginName.getMsg());
        }
        LoginBatUpdatePo loginBatUpdatePo = new LoginBatUpdatePo();
        loginBatUpdatePo.setIds(userMssByLoginName.getResult().getId().toString());
        loginBatUpdatePo.setLoginFlag(membInfoUpdatePo.getSfqyFlag());
        ResultPoJo<Object> loginBatUpdate = remoteUserMss.loginBatUpdate(loginBatUpdatePo);

        if (!"000".equals(loginBatUpdate.getCode())) {
            throw new BusinessException(loginBatUpdate.getCode(), loginBatUpdate.getMsg());
        }

        return result;
    }

    *//**
     * 批量删除
     *//*
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(MembInfoBatDeletePo membInfoBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for (Long delId : membInfoBatDeletePo.getDelList()) {
            MembInfo user = bigdataMembInfoMapper.selectByPrimaryKey(delId);
            user.preUpdate();
            bigdataMembInfoMapper.deleteLogic(user);

            ResultPoJo<User> userMssByLoginName = remoteUserMss.getByLoginName(user.getUserName());
            if (!"000".equals(userMssByLoginName.getCode())) {
                throw new BusinessException(userMssByLoginName.getCode(), userMssByLoginName.getMsg());
            }
            ResultPoJo<Object> batDelete = remoteUserMss.batDelete(userMssByLoginName.getResult().getId().toString());
            if (!"000".equals(batDelete.getCode())) {
                throw new BusinessException(batDelete.getCode(), batDelete.getMsg());
            }

        }
        return result;
    }

    public void excelExport(HttpServletResponse response) throws IOException {
        List<MembInfo> list = bigdataMembInfoMapper.findAllEntity();
        list.forEach(i -> {
            i.setSfqyFlag(i.getSfqyFlag().equals("0") ? "否" : "是");
            i.setQxType(i.getQxType().equals(DictConstants.QX_TYPE_0) ? "查看权限" : "维护权限");
        });
        new ExportExcel("用户管理", MembInfo.class)
                .setDataList(list)
                .writeWithAjaxHeader(response, "用户管理表.xlsx")
                .dispose();
    }*/
}
