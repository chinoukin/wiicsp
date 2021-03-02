package com.wisea.cultivar.plant.service.oritrapla;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.cache.CacheKey;
import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.constants.Constants;
import com.wisea.cloud.common.mss.RemoteUserMss;
import com.wisea.cloud.common.po.PwdBackConfirmPo;
import com.wisea.cloud.common.po.RegisterUserPo;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.service.ValidateCodeService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cultivar.plant.constants.ConstantCodeMsg;
import com.wisea.cultivar.plant.constants.DictConstants;
import com.wisea.cultivar.plant.entity.ZhfwMembInfo;
import com.wisea.cultivar.plant.mapper.ZhfwMembInfoMapper;
import com.wisea.cultivar.plant.po.oritrapla.CheckStringPo;
import com.wisea.cultivar.plant.po.oritrapla.RegisterBaseInfoPo;
import com.wisea.cultivar.plant.po.oritrapla.SaveForgetPwdPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * app端会员信息中不需要登录的接口
 *
 * @author wangh(wisea)
 *
 * @date 2018年6月5日
 * @version 1.0
 */

@Service
public class NotAuthMembAppService extends BaseService {

	@Autowired
	private ZhfwMembInfoMapper membInfoMapper;
	@Autowired
	private ValidateCodeService validateCodeService;

	/** 远程调用接口 **/
	@Autowired(required = false)
	private RemoteUserMss remoteUserMss;
	@Autowired
	private JedisDao jedisdao;
//	@Autowired(required = false)
//	private LocalUserService localUserService;


	/**
	 * oritrapla_001_【会员】注册时用户名的不重复的验证
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月5日
	 * @version 1.0
	 */
	public ResultPoJo<String> checkUsername(CheckStringPo po){
		// 返回参数初期化
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		// 根据输入字符串查询数据库中是否存在
		int count =  membInfoMapper.checkUsername(po.getStr().trim());
		// 如果查询的结果大于0 表示用户名已经存在
		if(count > 0){
			result.setCode(ConstantCodeMsg.ERR_701);
			result.setMsg(ConstantCodeMsg.MSG_701);
			return result;
		}
		//返回结果
		return result;
	}

	/**
	 * 验证手机号是否存在
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月5日
	 * @version 1.0
	 */
	public ResultPoJo<String> checkMobile(CheckStringPo po){
		// 返回参数初期化
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		// 手机号验证是否存在
		int mobilecount =  membInfoMapper.checkMobile(po.getStr().trim());
		if(mobilecount > 0){
			result.setCode(ConstantCodeMsg.ERR_713);
			result.setMsg(ConstantCodeMsg.MSG_713);
			return result;
		}
		return result;
	}

	/**
	 * 注册操作
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月5日
	 * @version 1.0
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<String> saveBaseMembInfo(RegisterBaseInfoPo po){
		// 返回参数初期化
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		// 用户注册操作
		// 用户名验证是否存在
		int count =  membInfoMapper.checkUsername(po.getLoginName().trim());
		// 如果查询的结果大于0 表示用户名已经存在
		if(count > 0){
			result.setCode(ConstantCodeMsg.ERR_701);
			result.setMsg(ConstantCodeMsg.MSG_701);
			return result;
		}
		// 手机号验证是否存在
		int mobilecount =  membInfoMapper.checkMobile(po.getRegistTel().trim());
		if(mobilecount > 0){
			result.setCode(ConstantCodeMsg.ERR_713);
			result.setMsg(ConstantCodeMsg.MSG_713);
			return result;
		}
		// 手机验证码是否正确
		if(!validateCodeService.checkSMSCode(po.getRegistTel(),po.getViliCode(),true)){
			result.setCode(ConstantCodeMsg.ERR_703);
			result.setMsg(ConstantCodeMsg.MSG_703);
			return result;
		}
		// 注册操作 调用远程接口
		// 验证用户名是否已经存在 注册用户
		RegisterUserPo registerUser = new RegisterUserPo();
		registerUser.setLoginName(po.getLoginName());// 用户名
		registerUser.setPassword(po.getPassword());// 密码
		registerUser.setMobile(po.getRegistTel());// 手机号
		registerUser.setUserType(Constants.USER_TYPE_USER);//"0:管理员 1:用户帐户 2:用户子账户"
		List<String> roleCodes = Lists.newArrayList();
		roleCodes.add("ROLE_plat_app"); //增加角色
		registerUser.setRoleCodes(roleCodes);
		ResultPoJo<User> userResult = new ResultPoJo<User>(ConstantError.NOMAL);
		if (ConverterUtil.isNotEmpty(remoteUserMss)) {
			userResult = remoteUserMss.register(registerUser);
		} else {
			throw new RuntimeException("remoteUserMss or localUserMssService must be required");
		}
		if(!userResult.getCode().equals(ConstantError.NOMAL)
				|| ConverterUtil.isEmpty(userResult.getResult().getId())){
			checkRemoteResult(userResult);
			result.setCode(userResult.getCode());
			result.setMsg(userResult.getMsg());
			return result;
		}
		// 插入会员信息内容
		ZhfwMembInfo membInfo = new ZhfwMembInfo();
		membInfo.preInsert();//
		membInfo.setId(userResult.getResult().getId());// 设置成调用注册返回的user的ID
		membInfo.setLoginName(po.getLoginName().trim());// 登录用户名
		membInfo.setRegistTel(po.getRegistTel());//注册手机号码
		membInfo.setContTel(po.getRegistTel());//联系人手机号码

		membInfo.setRegisterDate(OffsetDateTime.now());//注册时间
		membInfo.setEntpAuthStateType("1");// 认证状态:未认证
		membInfo.setAcctState("0");//账户状态:正常
		membInfo.setAcctStatus("1");//账号状态:正常 只用于产地通
		membInfo.setMembType(po.getMembType());//会员类型

		membInfo.setAcctType(DictConstants.ACCT_TYPE_0);// 设置为主账户
		membInfo.setAcctStatus(DictConstants.ACCT_STATUS_1); // 设置状态为启用
		membInfo.setRegisterDate(userResult.getResult().getCreateDate()); //注册时间等于用户创建时间
		// 插入表操作
		membInfoMapper.insertSelective(membInfo);
		// 返回结果
		return result;
	}

	/**
	 * 【会员】修改密码时验证用户名是否存在(忘记密码)
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月5日
	 * @version 1.0
	 */
	public ResultPoJo<String> checkLogNameForPwd(CheckStringPo po){
		// 返回参数初期化
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		// 根据用户名查询输入的登录用户是否正确
		ZhfwMembInfo membInfo = membInfoMapper.getMembInfoByUserName(po.getStr().trim());
		// 判断查询的信息为空的情况
		if(membInfo == null){
			result.setCode(ConstantCodeMsg.ERR_705);
			result.setMsg(ConstantCodeMsg.MSG_705);
			return result;
		}
		// 联系人手机号为空的情况
		if(ConverterUtil.isEmpty(membInfo.getRegistTel())){
			result.setCode(ConstantCodeMsg.ERR_706);
			result.setMsg(ConstantCodeMsg.MSG_706);
			return result;
		}
		// 返回手机号信息
		result.setResult(membInfo.getRegistTel());
		// 返回结果
		return result;
	}

	/**
	 * 【会员】修改密码时验证用户名是否存在(忘记密码)
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月5日
	 * @version 1.0
	 */
	public ResultPoJo<String> checkContTelForPwd(CheckStringPo po){
		// 返回参数初期化
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		// 根据用户名查询输入的手机号是否正确
		List<ZhfwMembInfo> membInfos = membInfoMapper.findByMobile(po.getStr().trim());
		// 判断查询的信息为空的情况
		if(ConverterUtil.isEmpty(membInfos)){
			result.setCode(ConstantCodeMsg.ERR_714);
			result.setMsg(ConstantCodeMsg.MSG_714);
		}
		return result;
	}

	/**
	 * oritrapla_007_【会员】修改密码保存操作(忘记密码)
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月5日
	 * @version 1.0
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<String> saveForgtPwd(SaveForgetPwdPo po){
		// 返回参数初期化
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);

		ZhfwMembInfo membInfo = null;

		if(ConverterUtil.isNotEmpty(po.getLoginName())){
			membInfo = membInfoMapper.getMembInfoByUserName(po.getLoginName().trim());
		}else if (ConverterUtil.isNotEmpty(po.getRegistTel())){
			List<ZhfwMembInfo> membInfos = membInfoMapper.findByMobile(po.getRegistTel().trim());
			membInfo = membInfos.get(0);
		}

		// 判断查询的信息为空的情况
		if(membInfo == null){
			result.setCode(ConstantCodeMsg.ERR_705);
			result.setMsg(ConstantCodeMsg.MSG_705);
			return result;
		}

		// 联系人手机号为空的情况
		if(ConverterUtil.isEmpty(membInfo.getRegistTel())){
			result.setCode(ConstantCodeMsg.ERR_706);
			result.setMsg(ConstantCodeMsg.MSG_706);
			return result;
		}
		// 手机验证码是否正确
		if(!validateCodeService.checkSMSCode(membInfo.getRegistTel(),po.getViliCode(),true)){
			result.setCode(ConstantCodeMsg.ERR_703);
			result.setMsg(ConstantCodeMsg.MSG_703);
			return result;
		}

		if (ConverterUtil.isNotEmpty(remoteUserMss)) {
			// 设置key
			ResultPoJo<Object> pwdBackApplyResult = remoteUserMss.pwdBackApply(membInfo.getLoginName());
			if(!pwdBackApplyResult.getCode().equals(ConstantError.NOMAL)){
				checkRemoteResult(pwdBackApplyResult);
				result.setCode(pwdBackApplyResult.getCode());
				result.setMsg(pwdBackApplyResult.getMsg());
				return result;
			}
			// 从redis查询是否有过记录，如果有就不再设置 默认超时:600秒
	        String applyKey = jedisdao.getStr(CacheKey.getPwdBack(membInfo.getLoginName()));
	        if (ConverterUtil.isEmpty(applyKey)) {
	        	result.setCode(ConstantCodeMsg.ERR_009);
				result.setMsg(ConstantCodeMsg.MSG_009);
	            return result;
	        }
			PwdBackConfirmPo pwdBackConfirmPo = new PwdBackConfirmPo();
			pwdBackConfirmPo.setCheckKey(applyKey);
			pwdBackConfirmPo.setLoginName(membInfo.getLoginName());
			pwdBackConfirmPo.setNewPassword(po.getNewPwd());
			ResultPoJo<Object> pwdBackConfirmResult = remoteUserMss.pwdBackConfirm(pwdBackConfirmPo);
			if(!pwdBackConfirmResult.getCode().equals(ConstantError.NOMAL)){
				checkRemoteResult(pwdBackConfirmResult);
				result.setCode(pwdBackConfirmResult.getCode());
				result.setMsg(pwdBackConfirmResult.getMsg());
				return result;
			}
		} else {
			throw new RuntimeException("remoteUserMss or localUserMssService must be required");
		}
		// 返回结果
		return result;
	}
}
