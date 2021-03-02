package com.wisea.transac.operation.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.entity.MembLoginCityOrLocInfo;
import com.wisea.transac.common.po.memb.LoginNameOrMobilePo;
import com.wisea.transac.common.utils.MembUtils;

/**
 * 登录相关验证的处理工具类
 *
 * @author wangh(wisea)
 *
 * @date 2020年7月29日
 * @version 1.0
 */
public class LoginUserCheckUtils {

	/**
     * 日志对象
     */
	private static Logger logger = LoggerFactory.getLogger(LoginUserCheckUtils.class);

	/**
	 * 验证同城或者产地登录的验证处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年7月29日
	 * @version 1.0
	 */
	public static ResultPoJo<String>  checkLocOrCityLogin(String loginType,String loginName,String regTel){
		// 返回值初期化处理
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantCodeMsg.NOMAL);
		// 根据用户名称或者手机号查询用户信息
		LoginNameOrMobilePo loginNameOrMobilePo = new LoginNameOrMobilePo();
		loginNameOrMobilePo.setLoginName(loginName);
		loginNameOrMobilePo.setMobile(regTel);
		MembLoginCityOrLocInfo checkMembInfo = MembUtils.sellerAppLoginCheck(loginNameOrMobilePo);
		if(checkMembInfo != null && ConverterUtil.isNotEmpty(checkMembInfo.getLoginName())
				&& ConverterUtil.isNotEmpty(checkMembInfo.getId())){
			logger.debug("MembBaseInfo" + ":LocalityMembType=" + checkMembInfo.getLocalityMembType()
							            +"  AuthType=" + checkMembInfo.getAuthType()
							            +"  AgentFlag=" + checkMembInfo.getAgentFlag()
							            +"  EffeInvalState=" + checkMembInfo.getEffeInvalState()
							            +"  MembClass=" + checkMembInfo.getMembClass());
			if(ConverterUtil.isNotEmpty(loginName)){
				result.setResult(checkMembInfo.getLoginName());
			}else{
				result.setResult(ConverterUtil.toString(checkMembInfo.getId()));
			}
			// 当同城端APP登录的情况
			if("city_bus".equals(loginType) && DictConstants.LOCALITY_MEMB_TYPE_1.equals(checkMembInfo.getLocalityMembType())){
				// 账号冻结
				if(checkMembInfo.getEffeInvalState() != null && DictConstants.EFFE_INVAL_STATE_1.equals(checkMembInfo.getEffeInvalState())){
					result.setCode(ConstantCodeMsg.ERR_908);
					result.setMsg(ConstantCodeMsg.MSG_908);
					return result;
				}
				// 企业下采购员无商家APP使用权限
				if("1".equals(checkMembInfo.getMembClass())){
					result.setCode(ConstantCodeMsg.ERR_850);
					result.setMsg(ConstantCodeMsg.MSG_850);
					return result;
				}
				// 员工帐号登录的情况 -子账号并且父节点没有认证未商户的情况
				if(!checkMembInfo.getId().equals(checkMembInfo.getMembId()) && !DictConstants.AGENT_FLAG_0.equals(checkMembInfo.getAgentFlag())){
					result.setCode(ConstantCodeMsg.ERR_851);
					result.setMsg(ConstantCodeMsg.MSG_851);
					return result;
				}
			// 当产地端APP登录的情况
			}else if("loc_bus".equals(loginType) && DictConstants.LOCALITY_MEMB_TYPE_0.equals(checkMembInfo.getLocalityMembType())){
				// 账号冻结
				if(checkMembInfo.getEffeInvalState() != null && DictConstants.EFFE_INVAL_STATE_1.equals(checkMembInfo.getEffeInvalState())){
					result.setCode(ConstantCodeMsg.ERR_908);
					result.setMsg(ConstantCodeMsg.MSG_908);
					return result;
				}
				// 企业下采购员无商家APP使用权限
				if("1".equals(checkMembInfo.getMembClass())){
					result.setCode(ConstantCodeMsg.ERR_850);
					result.setMsg(ConstantCodeMsg.MSG_850);
					return result;
				}
				// 员工帐号登录的情况 -子账号并且父节点没有认证未商户的情况
				if(!checkMembInfo.getId().equals(checkMembInfo.getMembId()) && !DictConstants.AGENT_FLAG_0.equals(checkMembInfo.getAgentFlag())){
					result.setCode(ConstantCodeMsg.ERR_851);
					result.setMsg(ConstantCodeMsg.MSG_851);
					return result;
				}
			}else{
				result.setCode(ConstantCodeMsg.ERR_907);
				result.setMsg(ConstantCodeMsg.MSG_907);
				return result;
			}
		}else{
			result.setCode(ConstantCodeMsg.ERR_907);
			result.setMsg(ConstantCodeMsg.MSG_907);
			return result;
		}
		return result;
	}
}
