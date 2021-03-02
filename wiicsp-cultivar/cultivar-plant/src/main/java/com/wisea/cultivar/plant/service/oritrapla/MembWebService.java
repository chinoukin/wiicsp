package com.wisea.cultivar.plant.service.oritrapla;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.constants.Constants;
import com.wisea.cloud.common.mss.RemoteUserMss;
import com.wisea.cloud.common.po.*;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.*;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.plant.constants.ConstantCodeMsg;
import com.wisea.cultivar.plant.constants.DictConstants;
import com.wisea.cultivar.plant.entity.ZhfwMembInfo;
import com.wisea.cultivar.plant.mapper.ZhfwMembInfoMapper;
import com.wisea.cultivar.plant.po.oritrapla.*;
import com.wisea.cultivar.plant.vo.oritrapla.ManUserVo;
import com.wisea.cultivar.plant.vo.oritrapla.MembBaseInfoVo;
import com.wisea.cultivar.plant.vo.oritrapla.MembDetailInfoVo;
import com.wisea.cultivar.plant.vo.oritrapla.MembListInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台管理会员相关的接口
 *
 * @author wangh(wisea)
 * @version 1.0
 * @date 2018年6月19日
 */
@Service
public class MembWebService extends BaseService {

    @Autowired
    private ZhfwMembInfoMapper membInfoMapper;
//    @Autowired
//    private MembLoginHisMapper membLoginHisMapper;
    /**
     * 远程调用接口
     **/
    @Autowired
    private RemoteUserMss remoteUserMss;
    /*@Autowired
    private RemoteLoginCenterMss remoteLoginCenterMss;*/

    /**
     * @author wangh(wisea)
     * @date 2018年6月19日
     * @version 1.0
     */
    public ResultPoJo<Page<MembListInfoVo>> list(WebMembListPo po) {
        // 初期化返回值
        ResultPoJo<Page<MembListInfoVo>> result = new ResultPoJo<Page<MembListInfoVo>>(ConstantError.NOMAL);
        Page<MembListInfoVo> page = po.getPage();
        // 时间的设定
        po.setRegStaDate(OffsetDateTimeUtils.getDayMinTime(po.getRegStaDate()));
        po.setRegEndDate(OffsetDateTimeUtils.getDayMaxTime(po.getRegEndDate()));
        po.setUpdStaDate(OffsetDateTimeUtils.getDayMinTime(po.getUpdStaDate()));
        po.setUpdEndDate(OffsetDateTimeUtils.getDayMaxTime(po.getUpdEndDate()));
        // 分页查询并设置返回信息
        List<MembListInfoVo> list = membInfoMapper.getMembInfoList(po);
        page.setList(list);
        result.setResult(page);
        // 返回查询结果
        return result;
    }

    /**
     * 后台账号管理列表
     * @param po
     * @return
     */
    public ResultPoJo<Page<MembListInfoVo>> listBackMan(WebMembListPo po) {
        // 初期化返回值
        ResultPoJo<Page<MembListInfoVo>> result = new ResultPoJo<Page<MembListInfoVo>>(ConstantError.NOMAL);
        Page<MembListInfoVo> page = po.getPage();
        // 时间的设定
        po.setRegStaDate(OffsetDateTimeUtils.getDayMinTime(po.getRegStaDate()));
        po.setRegEndDate(OffsetDateTimeUtils.getDayMaxTime(po.getRegEndDate()));
        po.setUpdStaDate(OffsetDateTimeUtils.getDayMinTime(po.getUpdStaDate()));
        po.setUpdEndDate(OffsetDateTimeUtils.getDayMaxTime(po.getUpdEndDate()));
        // 分页查询并设置返回信息
        List<MembListInfoVo> list = membInfoMapper.getMembInfoBackManList(po);
        page.setList(list);
        result.setResult(page);
        // 返回查询结果
        return result;
    }

    /**
     * 批量冻结,解冻会员状态
     *
     * @author wangh(wisea)
     *         <p>
     *         idList：需要修改的会员列表 acctStatus：0：冻结1：解冻
     * @date 2018年6月19日
     * @version 1.0
     */
    @Transactional(readOnly = false)
    public ResultPoJo<String> batchMembLoginFlag(BatchMembLoginFlagPo po) {
        // 初期化返回值
        ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
        // 修改会员表中的状态
        Map<String, Object> pare = new HashMap<String, Object>();
        // 需要修改的列表
        pare.put("idList", po.getIdList());
        // 冻结或者解冻标识（0：冻结1：解冻）
        pare.put("acctStatus", po.getAcctStatus());
        // 执行操作
        membInfoMapper.batchMembLoginFlag(pare);
        // 修改用户信息0:冻结1:解冻[正常]
        LoginBatUpdatePo loginBatUpdate = new LoginBatUpdatePo();
        loginBatUpdate.setLoginFlag(po.getAcctStatus());// 冻结状态不允许登录
        loginBatUpdate.setIds(String.join(",",po.getIdList()));// 传入要修改的ID
        ResultPoJo<Object> userResult = new ResultPoJo<Object>(ConstantError.NOMAL);
        userResult = remoteUserMss.loginBatUpdate(loginBatUpdate);
        if (!userResult.getCode().equals(ConstantError.NOMAL)) {
            checkRemoteResult(userResult);
            result.setCode(userResult.getCode());
            result.setMsg(userResult.getMsg());
            return result;
        }

        // 返回结果
        return result;
    }

    /**
     * oritrapla_073_【后台会员】查询会员详细信息
     *
     * @author wangh(wisea)
     * @date 2018年6月19日
     * @version 1.0
     */
    public ResultPoJo<MembDetailInfoVo> getDetaiInfo(@RequestBody LongIdPo po) {
        // 初期化返回值
        ResultPoJo<MembDetailInfoVo> result = new ResultPoJo<MembDetailInfoVo>(ConstantError.NOMAL);
        // 查询详细信息
        result.setResult(membInfoMapper.getDetaiInfo(po.getId()));
        // 返回结果
        return result;
    }

    /**
     * oritrapla_074_【后台会员】查询会员基础信息
     *
     * @author wangh(wisea)
     * @date 2018年6月19日
     * @version 1.0
     */
    public ResultPoJo<MembBaseInfoVo> getBaseInfo(@RequestBody LongIdPo po) {
        // 初期化返回值
        ResultPoJo<MembBaseInfoVo> result = new ResultPoJo<MembBaseInfoVo>(ConstantError.NOMAL);
        // 查询详细信息
        result.setResult(membInfoMapper.getMembBaseInfoById(po.getId()));
        // 返回结果
        return result;
    }

    /**
     * oritrapla_075_【后台会员】保存会员基础信息
     *
     * @author wangh(wisea)
     * @date 2018年6月19日
     * @version 1.0
     */
    @Transactional(readOnly = false)
    public ResultPoJo<String> saveBaseInfo(@RequestBody UpdMembBaseInfoPo po) {
        // 初期化返回值
        ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
        // 根据id查询会员的基础信息
        MembBaseInfoVo oldData = membInfoMapper.getMembBaseInfoById(po.getId());
        // 更新会员信息
        ZhfwMembInfo membInfo = new ZhfwMembInfo();
        ConverterUtil.copyProperties(po, membInfo);
        membInfo.preUpdate();
        membInfoMapper.updateByPrimaryKeySelective(membInfo);
        // 用户名称是否修改
        if (!po.getLoginName().equals(oldData.getLoginName())) {
        	UpdateLoginNamePo updateLoginNamePo = new UpdateLoginNamePo();
        	updateLoginNamePo.setId(po.getId());
        	updateLoginNamePo.setLoginName(po.getLoginName());
        	ResultPoJo<Object> userResult = remoteUserMss.updateLoginName(updateLoginNamePo);
            if (!userResult.getCode().equals(ConstantError.NOMAL)) {
                checkRemoteResult(userResult);
                result.setCode(userResult.getCode());
                result.setMsg(userResult.getMsg());
                return result;
            }
        }
        if (!po.getContTel().equals(oldData.getContTel())) {// 手机号是否修改
        	User user = new User();
        	user.setId(po.getId());
        	user.setMobile(po.getContTel());
        	ResultPoJo<Object> userResult = remoteUserMss.mobileUpdate(user);
            if (!userResult.getCode().equals(ConstantError.NOMAL)) {
                checkRemoteResult(userResult);
                result.setCode(userResult.getCode());
                result.setMsg(userResult.getMsg());
                return result;
            }
        }
        // 修改密码的情况
        if (ConverterUtil.isNotEmpty(po.getPassword())) {// 密码修改的情况
            // 调用用户重置密码的接口
        	ResetPasswordUserPo resetPasswordUserPo = new ResetPasswordUserPo();
        	resetPasswordUserPo.setId(po.getId());
            resetPasswordUserPo.setNewPassword(po.getPassword());
            ResultPoJo<Object> userResult = remoteUserMss.pwdReset(resetPasswordUserPo);
            if (!userResult.getCode().equals(ConstantError.NOMAL)) {
                checkRemoteResult(userResult);
                result.setCode(userResult.getCode());
                result.setMsg(userResult.getMsg());
                return result;
            }
        }
        // 返回结果
        return result;
    }

    /**
     * oritrapla_077_【后台会员】查询历史上线记录
     *
     * @author wangh(wisea)
     * @date 2018年6月20日
     * @version 1.0
     */
    /*public ResultPoJo<Page<FindLoginHisVo>> hisOnliRecList(LoginHisPo po) {
        // 初期化返回值
        ResultPoJo<Page<FindLoginHisVo>> result = new ResultPoJo<Page<FindLoginHisVo>>(ConstantError.NOMAL);
        Page<FindLoginHisVo> page = po.getPage();
        // 时间的设定
        po.setLoginStaDate(OffsetDateTimeUtils.getDayMinTime(po.getLoginStaDate()));
        po.setLoginEndDate(OffsetDateTimeUtils.getDayMaxTime(po.getLoginEndDate()));
        // 分页查询并设置返回信息
        List<FindLoginHisVo> list = membLoginHisMapper.findHisOnliRecList(po);
        page.setList(list);
        result.setResult(page);
        // 返回查询结果
        return result;
    }*/

    /**
     * oritrapla_079_【后台会员】新增后台管理账号
     *
     * @author wangh(wisea)
     * @date 2018年6月20日
     * @version 1.0
     */
    @Transactional(readOnly = false)
    public ResultPoJo<String> saveManInfo(ManUserPo po) {
        // 初期化返回值
        ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);

        // 获取当前登入用户
        User currentUser = SystemUtils.getUser();
        // 新增的情况
        if (ConverterUtil.isEmpty(po.getId())) {
            // 用户名验证是否存在
            int count = membInfoMapper.checkUsername(po.getLoginName().trim());
            // 如果查询的结果大于0 表示用户名已经存在
            if (count > 0) {
                result.setCode(ConstantCodeMsg.ERR_701);
                result.setMsg(ConstantCodeMsg.MSG_701);
                return result;
            }
            // 保存用户信息
            // 验证用户名是否已经存在 注册用户
            SubUserInsertPo insertPo = new SubUserInsertPo();
            insertPo.setLoginName(po.getLoginName());// 用户名
            insertPo.setPassword(po.getPassword());// 密码
            insertPo.setMobile(po.getContTel());// 手机号
            insertPo.setUserType(Constants.USER_TYPE_ADMIN);// "0:管理员 1:用户帐户 2:用户子账户"
            insertPo.setAuthFlag("1");// 审核标识：0未审核1审核
            ResultPoJo<User> userResult = new ResultPoJo<User>(ConstantError.NOMAL);
            userResult = remoteUserMss.insert(insertPo);
            LoggerUtil.infoWithContext("调用security远程服务插入新用户：", insertPo, userResult);
            if (!userResult.getCode().equals(ConstantError.NOMAL) || ConverterUtil.isEmpty(userResult.getResult().getId())) {
                checkRemoteResult(userResult);
                result.setCode(userResult.getCode());
                result.setMsg(userResult.getMsg());
                return result;
            }
            // 保存会员信息
            ZhfwMembInfo membInfo = new ZhfwMembInfo();
            ConverterUtil.copyProperties(po, membInfo);
            // 会员状态
            membInfo.setAcctStatus(DictConstants.ACCT_STATUS_1);
            // 会员type类型
            membInfo.setAcctType(DictConstants.ACCT_TYPE_2);
            // 当前登入人为更新人
            membInfo.setUpdateBy(currentUser.getUpdateBy());
            membInfo.setUpdateDate(OffsetDateTime.now());
            membInfo.preInsert();
            membInfo.setId(userResult.getResult().getId());
            membInfoMapper.insertSelective(membInfo);
        } else {
            // 根据id查询会员的基础信息
            MembBaseInfoVo oldData = membInfoMapper.getMembBaseInfoById(po.getId());
            // 修改会员信息
            ZhfwMembInfo membInfo = new ZhfwMembInfo();
            ConverterUtil.copyProperties(po, membInfo);
            membInfoMapper.updateByPrimaryKeySelective(membInfo);
            // 是否修改User，默认不修改
            // 用户名称是否修改
            if (!oldData.getLoginName().equals(po.getLoginName())) {
            	UpdateLoginNamePo updateLoginNamePo = new UpdateLoginNamePo();
            	updateLoginNamePo.setId(po.getId());
            	updateLoginNamePo.setLoginName(po.getLoginName());
            	ResultPoJo<Object> userResult = remoteUserMss.updateLoginName(updateLoginNamePo);
                if (!userResult.getCode().equals(ConstantError.NOMAL)) {
                    checkRemoteResult(userResult);
                    result.setCode(userResult.getCode());
                    result.setMsg(userResult.getMsg());
                    return result;
                }
            }
            // 手机号是否修改
            if (!oldData.getContTel().equals(po.getContTel())) {
            	User user = new User();
            	user.setId(po.getId());
            	user.setMobile(po.getContTel());
            	ResultPoJo<Object> userResult = remoteUserMss.mobileUpdate(user);
                if (!userResult.getCode().equals(ConstantError.NOMAL)) {
                    checkRemoteResult(userResult);
                    result.setCode(userResult.getCode());
                    result.setMsg(userResult.getMsg());
                    return result;
                }
            }
            // 修改密码的情况
            if (ConverterUtil.isNotEmpty(po.getPassword())) {
                // 调用用户重置密码的接口
                ResetPasswordUserPo resetPasswordUserPo = new ResetPasswordUserPo();
                User updUser = SystemUtils.getById(po.getId());
                resetPasswordUserPo.setId(ConverterUtil.toLong(updUser.getOpenId()));
                resetPasswordUserPo.setNewPassword(PasswordUtil.entryptPassword(po.getPassword()));
                String param = JsonMapper.toJsonString(resetPasswordUserPo);
                // json加密
                String encodeParam = WbfcJwtOauthUtil.encode(param);
//                ResultPoJo<String> userResult = remoteLoginCenterMss.updatePassword(encodeParam);
//                LoggerUtil.infoWithContext("调用loginCenter远程服务修改用户：", param, encodeParam, userResult);
//                if (!userResult.getCode().equals(ConstantError.NOMAL)) {
//                    checkRemoteResult(userResult);
//                    result.setCode(userResult.getCode());
//                    result.setMsg(userResult.getMsg());
//                    return result;
//                }
            }
        }
        return result;
    }

    /**
     * oritrapla_080_【后台会员】查询后台管理员的基础信息
     *
     * @author wangh(wisea)
     * @date 2018年6月20日
     * @version 1.0
     */
    public ResultPoJo<ManUserVo> getManInfoById(@RequestBody LongIdPo po) {
        // 初期化返回值
        ResultPoJo<ManUserVo> result = new ResultPoJo<ManUserVo>(ConstantError.NOMAL);
        // 查询并且返回结果
        result.setResult(membInfoMapper.getManInfoById(po.getId()));
        return result;
    }

    /**
     * 修改后台用户密码
     *
     * @param updatePasswordUserPo
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> managerPwdUpdate(UpdatePasswordUserPo updatePasswordUserPo) {
        return remoteUserMss.updatePassword(updatePasswordUserPo);
    }
}
