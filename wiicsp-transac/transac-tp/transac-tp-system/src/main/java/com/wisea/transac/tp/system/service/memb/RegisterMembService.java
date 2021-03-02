package com.wisea.transac.tp.system.service.memb;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wisea.cloud.common.cache.CacheKey;
import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.constants.Constants;
import com.wisea.cloud.common.mss.RemoteUserMss;
import com.wisea.cloud.common.po.PwdBackConfirmPo;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.service.ValidateCodeService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.IdGen;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.dao.MembInfoMapper;
import com.wisea.transac.common.entity.MembBaseInfo;
import com.wisea.transac.common.entity.MembInfo;
import com.wisea.transac.common.mss.UserMembInfoMss;
import com.wisea.transac.common.po.StringPo;
import com.wisea.transac.common.po.memb.MembCheckLoginNamePo;
import com.wisea.transac.common.po.memb.MembCheckMobilePo;
import com.wisea.transac.common.po.memb.MembForgotPwdPo;
import com.wisea.transac.common.po.memb.MembInfoRegisterPo;
import com.wisea.transac.common.po.memb.RegisterUserMembPo;
import com.wisea.transac.common.po.memb.UpdUserMembInfoPo;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.vo.memb.ChcekMobileIsEntpVo;
import com.wisea.transac.common.vo.memb.MembForgotPwdVo;

import io.seata.spring.annotation.GlobalTransactional;

/**
 * 商家注册会员相关的接口Service
 *
 * @author wangh(wisea)
 *
 * @date 2020年4月28日
 * @version 1.0
 */
@Service
public class RegisterMembService extends BaseService{


	@Autowired
	private MembInfoMapper membInfoMapper;
	@Autowired
	private ValidateCodeService validateCodeService;
	@Autowired
	private UserMembInfoMss userMembInfoMss;
	@Autowired
	private JedisDao jedisDao;
	@Autowired
	private RemoteUserMss remoteUserMss;
	/**
	 * 验证用户名称是否存在
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年4月28日
	 * @version 1.0
	 */
	public ResultPoJo<String> checkLoginNameExist(MembCheckLoginNamePo membCheckLoginNamePo){
		//  返回参数
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		int count = membInfoMapper.checkLoginNameExist(membCheckLoginNamePo);
		// 用户名称已经存在的情况
		if(count > 0){
			result.setCode(ConstantCodeMsg.ERR_502);
			result.setMsg(ConstantCodeMsg.MSG_502);
			return result;
		}
		return result;
	}

	/**
	 * 验证手机号是否已经存在
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年4月28日
	 * @version 1.0
	 */
	public ResultPoJo<String> checkMobileExist(MembCheckMobilePo membCheckMobilePo){
		//  返回参数
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		int mobileCount = membInfoMapper.checkMobileExist(membCheckMobilePo);
		// 手机号已经存在的情况
		if(mobileCount > 0){
			result.setCode(ConstantCodeMsg.ERR_501);
			result.setMsg(ConstantCodeMsg.MSG_501);
			return result;
		}
		return result;
	}
	/**
	 * 商家注册会员信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年4月28日
	 * @version 1.0
	 */
	//@TxTransaction(type = Transactions.LCN, propagation = DTXPropagation.REQUIRED)
	@GlobalTransactional
	@Transactional(readOnly = false)
	public ResultPoJo<MembInfo> register(MembInfoRegisterPo po){
		//  返回参数
		ResultPoJo<MembInfo> result = new ResultPoJo<MembInfo>(ConstantError.NOMAL);
		// 根据手机号查询该账号是否是已经存在的普通会员 (员工不能不能注册成为商户,解绑后操作)
		ChcekMobileIsEntpVo chcekMobileIsEntpVo = membInfoMapper.getPtMembByMobile(po.getRegistTel());
		// 验证用户名称
		MembCheckLoginNamePo membCheckLoginNamePo = new MembCheckLoginNamePo();
		membCheckLoginNamePo.setLoginName(po.getLoginName());
		int loginNameCount = membInfoMapper.checkLoginNameExist(membCheckLoginNamePo);
		// 用户存在的情况
		if(chcekMobileIsEntpVo != null && ConverterUtil.isNotEmpty(chcekMobileIsEntpVo.getMembId())){
			if(ConverterUtil.isNotEmpty(chcekMobileIsEntpVo.getPurId())
					|| ConverterUtil.isNotEmpty(chcekMobileIsEntpVo.getSaleId())){
				result.setCode(ConstantCodeMsg.ERR_855);
				result.setMsg(ConstantCodeMsg.MSG_855);
				return result;
			}
			// 用户名称是否存在
			if(!po.getLoginName().equals(chcekMobileIsEntpVo.getLoginName()) && loginNameCount > 0){
				result.setCode(ConstantCodeMsg.ERR_502);
				result.setMsg(ConstantCodeMsg.MSG_502);
				return result;
			}
			// 验证短信验证码是否正确
			if(!validateCodeService.checkSMSCode(po.getRegistTel(),po.getMobileCode(),true)){
				result.setCode(ConstantCodeMsg.ERR_503);
				result.setMsg(ConstantCodeMsg.MSG_503);
				return result;
			}
			// 本地数据库会员表的插入
			MembInfo membInfo = new MembInfo();
			membInfo.preUpdate();
			membInfo.setId(chcekMobileIsEntpVo.getMembId());
			membInfo.setLoginName(po.getLoginName());// 用户名
			membInfo.setPetName(po.getLoginName());// 昵称初期化显示登录用户名   20200814 产品确认
			membInfo.setLocalityMembType(po.getLocalityMembType());// 是否是产地会员的标识
			membInfo.setPasswordSetFlag(DictConstants.PASSWORD_SET_FLAG_0);
			membInfo.setLoginNameSetFlag(DictConstants.LOGIN_NAME_SET_FLAG_0);
			membInfoMapper.updateByPrimaryKeySelective(membInfo);
			// 登录用户名密码的处理
			if(!po.getLoginName().equals(chcekMobileIsEntpVo.getLoginName())){
				UpdUserMembInfoPo updUserMembInfoPo = new UpdUserMembInfoPo();
				updUserMembInfoPo.setId(chcekMobileIsEntpVo.getMembId());
				updUserMembInfoPo.setLoginName(po.getLoginName());
				updUserMembInfoPo.setPassword(po.getPassword());
				ResultPoJo<String> updUserRes = userMembInfoMss.updUserInfo(updUserMembInfoPo);
				if(!updUserRes.getCode().equals(ConstantError.NOMAL)){
					checkRemoteResult(updUserRes);
				}
			}
			// 清楚緩存
			MembUtils.delMembSelfUser(chcekMobileIsEntpVo.getMembId());
		// 用户不存在的情况
		}else{
			// 用户名称是否存在
			if(loginNameCount > 0){
				result.setCode(ConstantCodeMsg.ERR_502);
				result.setMsg(ConstantCodeMsg.MSG_502);
				return result;
			}
			// 手机号已经存在的情况
			MembCheckMobilePo membCheckMobilePo = new MembCheckMobilePo();
			membCheckMobilePo.setMobile(po.getRegistTel());
			int mobileCount = membInfoMapper.checkMobileExist(membCheckMobilePo);
			if(mobileCount > 0){
				result.setCode(ConstantCodeMsg.ERR_501);
				result.setMsg(ConstantCodeMsg.MSG_501);
				return result;
			}
			// 验证短信验证码是否正确
			if(!validateCodeService.checkSMSCode(po.getRegistTel(),po.getMobileCode(),true)){
				result.setCode(ConstantCodeMsg.ERR_503);
				result.setMsg(ConstantCodeMsg.MSG_503);
				return result;
			}
			// 本地数据库会员表的插入
			MembInfo membInfo = new MembInfo();
			membInfo.preInsert();
			membInfo.setId(IdGen.randomLong());// 用户id等于会员id
			membInfo.setLoginName(po.getLoginName());// 用户名
			membInfo.setRegistTel(po.getRegistTel());// 手机号
			// 新增的时候设置默认值
			membInfo.setPetName("用户" + MembUtils.getFixLenthString(10));
			membInfo.setRegistDate(OffsetDateTime.now());
			membInfo.setAcctState(DictConstants.ACCT_STATE_0);//账户状态0：正常
			membInfo.setMembType(DictConstants.MEMB_TYPE_2);// 0:企业1:个体户2：个人(初期化为空如果认证了显示对应的认证标识)
			membInfo.setAgentFlag(DictConstants.AGENT_FLAG_1);// 未认证前是普通用户 认证后是商家(0已经认证1未认证)
			membInfo.setEntpAuthStateType(DictConstants.ENTP_AUTH_STATE_TYPE_1);// 未认证
			membInfo.setLocalityMembType(po.getLocalityMembType());// 是否是产地会员的标识
			membInfo.setLoginNameSetFlag(DictConstants.LOGIN_NAME_SET_FLAG_0);
			membInfo.setPasswordSetFlag(DictConstants.PASSWORD_SET_FLAG_0);
			membInfoMapper.insert(membInfo);
			// 验证用户名是否已经存在 注册用户
			RegisterUserMembPo registerUserMembPo = new RegisterUserMembPo();
			registerUserMembPo.setId(membInfo.getId());
			registerUserMembPo.setLoginName(po.getLoginName());// 用户名
			registerUserMembPo.setPassword(po.getPassword());// 密码
			registerUserMembPo.setMobile(po.getRegistTel());// 手机号
			List<String> roleList = new ArrayList<String>();
			roleList.add("ROLE_person");
			registerUserMembPo.setRoleCodes(roleList);// 个人的情况 需要买家端的商品权限
			registerUserMembPo.setUserType(Constants.USER_TYPE_USER);//"0:管理员 1:用户帐户 2:用户子账户"
			ResultPoJo<User> userResult = userMembInfoMss.registerMemb(registerUserMembPo);
			if(!userResult.getCode().equals(ConstantError.NOMAL)
					|| ConverterUtil.isEmpty(userResult.getResult().getId())){
				checkRemoteResult(userResult);
			}
		}
		return result;
	}
	/**
	 * 忘记密码(点击发送手机验证码操作)
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年9月29日
	 * @version 1.0
	 */
	public ResultPoJo<MembForgotPwdVo> forgotPwdGetMobile(StringPo po){
		//  返回参数
		ResultPoJo<MembForgotPwdVo> result = new ResultPoJo<MembForgotPwdVo>(ConstantError.NOMAL);
		MembForgotPwdVo membForgotVo = new MembForgotPwdVo();
		//验证手机号是否存在
		MembBaseInfo membBaseInfo = membInfoMapper.getMembInfoByMobile(po.getKeyStr());
		if(ConverterUtil.isEmpty(membBaseInfo)){
			result.setCode(ConstantCodeMsg.ERR_528);
			result.setMsg(ConstantCodeMsg.MSG_528);
			return result;
		}
		// 设置key
		ResultPoJo<Object> userResult = remoteUserMss.pwdBackApply(membBaseInfo.getLoginName());
		if(!userResult.getCode().equals(ConstantError.NOMAL)){
			checkRemoteResult(userResult);
			result.setCode(userResult.getCode());
			result.setMsg(userResult.getMsg());
			return result;
		}else{
			// 从redis查询是否有过记录，如果有就不再设置 默认超时:600秒
	        String applyKey = CacheKey.getPwdBack(membBaseInfo.getLoginName());
	        String redisValu = jedisDao.getStr(applyKey);
	        if (ConverterUtil.isNotEmpty(redisValu)) {
	        	membForgotVo.setKeyCode(redisValu);
	        	membForgotVo.setMobile(membBaseInfo.getRegistTel());
				result.setResult(membForgotVo);
	            return result;
	        }else{
	        	result.setCode(ConstantCodeMsg.ERR_506);
				result.setMsg(ConstantCodeMsg.MSG_506);
	        }
		}
		return result;
	}
	/**
	 * 忘记密码保存操作
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年9月28日
	 * @version 1.0
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<String> forgotPassword(MembForgotPwdPo po){
		//  返回参数
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		//验证手机号是否存在
		MembBaseInfo membBaseInfo = membInfoMapper.getMembInfoByMobile(po.getMobile());
		if(ConverterUtil.isEmpty(membBaseInfo)){
			result.setCode(ConstantCodeMsg.ERR_528);
			result.setMsg(ConstantCodeMsg.MSG_528);
			return result;
		}
		// 验证短信验证码是否正确
		if(!validateCodeService.checkSMSCode(membBaseInfo.getRegistTel(),po.getMobileCode(),true)){
			result.setCode(ConstantCodeMsg.ERR_503);
			result.setMsg(ConstantCodeMsg.MSG_503);
			return result;
		}
		// 调用接口修改密码
		if(ConverterUtil.isNotEmpty(po.getKeyCode())){
			PwdBackConfirmPo pwdBackConfirmPo = new PwdBackConfirmPo();
			pwdBackConfirmPo.setCheckKey(po.getKeyCode());
			pwdBackConfirmPo.setNewPassword(po.getNewPwd());
			pwdBackConfirmPo.setLoginName(membBaseInfo.getLoginName());
			ResultPoJo<Object> userResult = remoteUserMss.pwdBackConfirm(pwdBackConfirmPo);
			if(!userResult.getCode().equals(ConstantError.NOMAL)){
				result.setCode(userResult.getCode());
				result.setMsg(userResult.getMsg());
				checkRemoteResult(userResult);
				return result;
			}
		}else{
			result.setCode(ConstantCodeMsg.ERR_507);
			result.setMsg(ConstantCodeMsg.MSG_507);
		}
		return result;
	}
}
