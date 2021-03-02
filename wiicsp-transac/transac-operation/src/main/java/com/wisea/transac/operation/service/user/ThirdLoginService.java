package com.wisea.transac.operation.service.user;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.wisea.transac.operation.entity.MembRelevanceInfo;
import com.wisea.transac.operation.mapper.MembRelevanceInfoMapper;
import com.wisea.transac.operation.user.po.CheckMobileIsBdPo;
import com.wisea.transac.operation.user.po.MembBdThirdInfoPo;
import com.wisea.transac.operation.utils.LoginUserCheckUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.constants.Constants;
import com.wisea.cloud.common.entity.AuthInfo;
import com.wisea.cloud.common.exception.BusinessException;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.service.ValidateCodeService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.IdGen;
import com.wisea.cloud.files.service.FastDFSClientService;
import com.wisea.cloud.tencentim.po.PortraitSetPo;
import com.wisea.cloud.tencentim.po.ProfileItem;
import com.wisea.cloud.tencentim.service.TencentIMService;
import com.wisea.cloud.tencentim.vo.TencentIMVo;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.dao.MembInfoMapper;
import com.wisea.transac.common.entity.MembInfo;
import com.wisea.transac.common.entity.MembLoginCityOrLocInfo;
import com.wisea.transac.common.po.memb.LoginNameOrMobilePo;
import com.wisea.transac.common.po.memb.RegisterUserMembPo;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.operation.user.po.MembThirdUnBindPo;
import com.wisea.transac.operation.user.po.RegMembByThirdInfoPo;
import com.wisea.transac.operation.user.po.ValiUnionExistPo;

/**
 * 第三方登录处理Service
 *
 * @author wangh(wisea)
 *
 * @date 2020年8月20日
 * @version 1.0
 */
@Service
@Lazy
public class ThirdLoginService extends BaseService{

	@Autowired
	private MembRelevanceInfoMapper membRelevanceInfoMapper;
	@Autowired
	private MembInfoMapper membInfoMapper;
	@Autowired
	private UserLoginExtendsService userLoginExtendsService;
	@Autowired
	private ValidateCodeService validateCodeService;
	@Autowired
	private UserMembMssService userMembMssService;
	@Autowired
	private FastDFSClientService fastDFSClientService;
	@Autowired
	private TencentIMService tencentIMService;
	/**
	 * 验证获取的第三方帐号是否已经绑定已有帐号
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年8月20日
	 * @version 1.0
	 */
	public ResultPoJo<AuthInfo> valiUnionExist(HttpServletRequest request,ValiUnionExistPo po){
		// 返回值初期化处理
		ResultPoJo<AuthInfo> result = new ResultPoJo<AuthInfo>();
		// 根据unionid查询关联ID
		MembRelevanceInfo membRelevanceInfo = new MembRelevanceInfo();
		membRelevanceInfo.setUnionId(po.getUnionId());
		membRelevanceInfo.setType(po.getRelType());// 0:微信小程序1:微信登录APP
		Long membId = membRelevanceInfoMapper.getMembInfoByUnionId(membRelevanceInfo);
		// 验证是否已经绑定用户
		if(ConverterUtil.isNotEmpty(membId)){
			MembInfo membInfo = membInfoMapper.selectByPrimaryKey(membId);
			// 采购端的验证
			if("web".equals(po.getLoginType())){
				// 验证处理
				// 判断是否允许登录
				LoginNameOrMobilePo loginNameOrMobilePo = new LoginNameOrMobilePo();
				loginNameOrMobilePo.setMobile(membInfo.getRegistTel());
				MembLoginCityOrLocInfo checkMembInfo = MembUtils.sellerAppLoginCheck(loginNameOrMobilePo);
				if(checkMembInfo != null && "2".equals(checkMembInfo.getMembClass())){
					result.setCode(ConstantCodeMsg.ERR_954);
					result.setMsg(ConstantCodeMsg.MSG_954);
					return result;
				}
			// 同城商家和产地商家端的验证
			}else{
				ResultPoJo<String> checkResult = LoginUserCheckUtils.checkLocOrCityLogin(po.getLoginType(), null,membInfo.getRegistTel());
				if(checkResult == null || !ConstantCodeMsg.NOMAL.equals(checkResult.getCode())
						|| ConverterUtil.isEmpty(checkResult.getResult())){
					result.setCode(ConstantError.ERR_907);
					result.setMsg(ConstantError.MSG_907);
					return result;
				}
			}
			// 登录处理
			result = userLoginExtendsService.mobileLogin(request, null, membId,false);
		// 没有绑定的情况
		}else{
			result.setCode(ConstantCodeMsg.ERR_517);
			result.setMsg(ConstantCodeMsg.MSG_517);
			return result;
		}
		return result;
	}
	/**
	 * 验证该手机号的用户已经绑定了其他的微信
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年8月21日
	 * @version 1.0
	 */
	public ResultPoJo<String> checkMobileIfBd(CheckMobileIsBdPo po){
		// 返回值初期化处理
		ResultPoJo<String> result = new ResultPoJo<String>();
		// 查询处理
		MembRelevanceInfo parameter = new MembRelevanceInfo();
		parameter.setRegistTel(po.getMobile());
		parameter.setType(po.getRelType());
		MembRelevanceInfo info = membRelevanceInfoMapper.checkMobileIfBd(parameter);
		if(info != null){
			result.setCode(ConstantCodeMsg.ERR_518);
			result.setMsg(ConstantCodeMsg.MSG_518);
			return result;
		}
		return result;
	}
	/**
	 * 根据第三方信息和手机号注册绑定并且登录处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年8月20日
	 * @version 1.0
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<AuthInfo> regMmebByThirdMembInfo(HttpServletRequest request,RegMembByThirdInfoPo po){
		// 返回值初期化处理
		ResultPoJo<AuthInfo> result = new ResultPoJo<AuthInfo>();
		// 通过手机号验证该账号是否已经绑定了其他的微信
		MembRelevanceInfo parameter = new MembRelevanceInfo();
		parameter.setRegistTel(po.getMobile());
		parameter.setType(po.getRelType());
		MembRelevanceInfo info = membRelevanceInfoMapper.checkMobileIfBd(parameter);
		if(info != null){
			result.setCode(ConstantCodeMsg.ERR_518);
			result.setMsg(ConstantCodeMsg.MSG_518);
			return result;
		}
		// 通过unionid验证是否已经绑定
        MembRelevanceInfo membRelevanceInfo = new MembRelevanceInfo();
		membRelevanceInfo.setUnionId(po.getUnionId());
		membRelevanceInfo.setType(po.getRelType());
		Long membId = membRelevanceInfoMapper.getMembInfoByUnionId(membRelevanceInfo);
		if(ConverterUtil.isNotEmpty(membId)){
			result.setCode(ConstantCodeMsg.ERR_858);
			result.setMsg(ConstantCodeMsg.MSG_858);
			return result;
		}
		// 验证手机号是否已经存在
		MembInfo existInfo = MembUtils.getMembInfoByRegTel(po.getMobile());
		// 校验验证码是否正确
        if (!validateCodeService.checkSMSCode(po.getMobile(), po.getValCode(), false)) {
            // 验证码错误或已过期
            result.setCode(ConstantError.ERR_904);
			result.setMsg(ConstantError.MSG_904);
			return result;
        }
        // 如果手机号存在的情况 表示已经存在该用户 需要绑定处理并且返回登录信息
		if(existInfo != null){
			// 采购端的验证
			if("web".equals(po.getLoginType())){
				// 判断是否允许登录
				LoginNameOrMobilePo loginNameOrMobilePo = new LoginNameOrMobilePo();
				loginNameOrMobilePo.setMobile(existInfo.getRegistTel());
				MembLoginCityOrLocInfo checkMembInfo = MembUtils.sellerAppLoginCheck(loginNameOrMobilePo);
				if(checkMembInfo != null && "2".equals(checkMembInfo.getMembClass())){
					result.setCode(ConstantCodeMsg.ERR_954);
					result.setMsg(ConstantCodeMsg.MSG_954);
					return result;
				}
			// 同城商家和产地商家端的验证
			}else{
				ResultPoJo<String> checkResult = LoginUserCheckUtils.checkLocOrCityLogin(po.getLoginType(), null,existInfo.getRegistTel());
				if(checkResult == null || !ConstantCodeMsg.NOMAL.equals(checkResult.getCode())
						|| ConverterUtil.isEmpty(checkResult.getResult())){
					result.setCode(ConstantError.ERR_907);
					result.setMsg(ConstantError.MSG_907);
					return result;
				}
			}
			// 会员表中绑定昵称的处理
			MembInfo membInfo = new MembInfo();
			membInfo.setId(existInfo.getId());
			membInfo.setBindWechat(po.getPetName());
			membInfoMapper.updateByPrimaryKeySelective(membInfo);
			// 第三方登录关联表信息
			MembRelevanceInfo membReleVance = new MembRelevanceInfo();
			membReleVance.preInsert();
			membReleVance.setType(po.getRelType());//表示微信第三方登录
			membReleVance.setReleId(existInfo.getId());
			membReleVance.setOpenId(po.getOpenId());
			membReleVance.setOpenType("0");
			membReleVance.setUnionId(po.getUnionId());
			membReleVance.setRemarks(po.getPetName());
			membRelevanceInfoMapper.insertSelective(membReleVance);
			return userLoginExtendsService.mobileLogin(request, null, existInfo.getId(),false);
		}
        // 本地数据库会员表的插入
		String pwd = IdGen.randomBase62(32);
		String userName = MembUtils.getRandomUserName();
		MembInfo membInfo = new MembInfo();
		membInfo.preInsert();
		membInfo.setLoginName(userName);
		membInfo.setRegistTel(po.getMobile());
		// 新增的时候设置默认值
		if(ConverterUtil.isNotEmpty(po.getLogoUrl())){
			ResultPoJo<String> logoResult = fastDFSClientService.saveNetWorkFile(po.getLogoUrl());
			if(ConstantCodeMsg.NOMAL.equals(logoResult.getCode())){
				membInfo.setLogoUrl(logoResult.getResult());
			}
		}
		membInfo.setRegistDate(OffsetDateTime.now());
		membInfo.setBindWechat(po.getPetName());
		membInfo.setAgentFlag(DictConstants.AGENT_FLAG_1);//普通用户
		membInfo.setAcctState(DictConstants.ACCT_STATE_0);//账户状态0：正常
		if(ConverterUtil.isEmpty(po.getPetName())){
			membInfo.setPetName(MembUtils.getRandomUserName());//昵称
		}else{
			membInfo.setPetName(po.getPetName());//昵称
		}
		membInfo.setMembType(DictConstants.MEMB_TYPE_2);// 会员类型0:企业1：个体户2：个人(未认证前是空如果认证了 填写对应的认证标识)
		membInfo.setEntpAuthStateType(DictConstants.ENTP_AUTH_STATE_TYPE_1);//未认证
		membInfo.setPasswordSetFlag(DictConstants.PASSWORD_SET_FLAG_1);// 未设置密码
		membInfo.setLoginNameSetFlag(DictConstants.LOGIN_NAME_SET_FLAG_1);// 未设置用户名
		// 同城登录的情况
		if("city_bus".equals(po.getLoginType())){
			membInfo.setLocalityMembType(DictConstants.LOCALITY_MEMB_TYPE_1);
		// 产地登录的情况
		}else if("loc_bus".equals(po.getLoginType())){
			membInfo.setLocalityMembType(DictConstants.LOCALITY_MEMB_TYPE_0);
		}
		membInfoMapper.insertSelective(membInfo);
		// 第三方登录关联表信息
		MembRelevanceInfo membReleVance = new MembRelevanceInfo();
		membReleVance.preInsert();
		membReleVance.setType(po.getRelType());//表示微信第三方登录
		membReleVance.setReleId(membInfo.getId());
		membReleVance.setOpenId(po.getOpenId());
		membReleVance.setOpenType("0");
		membReleVance.setUnionId(po.getUnionId());
		membReleVance.setRemarks(po.getPetName());
		membRelevanceInfoMapper.insertSelective(membReleVance);
		// 验证用户名是否已经存在 注册用户
		RegisterUserMembPo registerUserMembPo = new RegisterUserMembPo();
		registerUserMembPo.setId(membInfo.getId());
		registerUserMembPo.setLoginName(userName);// 用户名
		registerUserMembPo.setPassword(pwd);//  随机密码
		registerUserMembPo.setMobile(po.getMobile());// 手机号
		List<String> roleList = new ArrayList<String>();
		roleList.add("ROLE_person");
		registerUserMembPo.setRoleCodes(roleList);// 个人的情况
		registerUserMembPo.setUserType(Constants.USER_TYPE_USER);//"0:管理员 1:用户帐户 2:用户子账户"
		ResultPoJo<User> userResult = userMembMssService.registerMemb(registerUserMembPo);
		if(!userResult.getCode().equals(ConstantError.NOMAL)
				|| ConverterUtil.isEmpty(userResult.getResult().getId())){
			checkRemoteResult(userResult);
		}
		// 及时通信的处理-- 昵称
		if(ConverterUtil.isNotEmpty(membInfo.getPetName())){
			PortraitSetPo portraitSetPo = new PortraitSetPo();
			portraitSetPo.setFromAccount(ConverterUtil.toString(membInfo.getId()));
			List<ProfileItem> profileItemList = Lists.newArrayList();
			ProfileItem profileItem = new ProfileItem();
			profileItem.setTag("Tag_Profile_IM_Nick");
			profileItem.setValue(po.getPetName());
			profileItemList.add(profileItem);
			portraitSetPo.setProfileItem(profileItemList);
			ResultPoJo<TencentIMVo<Object>> petNameResult = tencentIMService.portraitSet(portraitSetPo);
			if(!ConstantCodeMsg.NOMAL.equals(petNameResult.getCode())){
				BusinessException error = new BusinessException(petNameResult.getCode(), petNameResult.getMsg());
	            throw error;
			}
		}
		// 及时通信的处理-- 头像
		if(ConverterUtil.isNotEmpty(membInfo.getLogoUrl())){
			PortraitSetPo portraitSetPo = new PortraitSetPo();
			portraitSetPo.setFromAccount(ConverterUtil.toString(membInfo.getId()));
			List<ProfileItem> profileItemList = Lists.newArrayList();
			ProfileItem profileItem = new ProfileItem();
			profileItem.setTag("Tag_Profile_IM_Image");
			profileItem.setValue(po.getPetName());
			profileItemList.add(profileItem);
			portraitSetPo.setProfileItem(profileItemList);
			ResultPoJo<TencentIMVo<Object>> imgResult = tencentIMService.portraitSet(portraitSetPo);
			if(!ConstantCodeMsg.NOMAL.equals(imgResult.getCode())){
				BusinessException error = new BusinessException(imgResult.getCode(), imgResult.getMsg());
	            throw error;
			}
		}
		// 登录处理
		return userLoginExtendsService.mobileLogin(request, null, membInfo.getId(),false);
	}
	/**
	 * 微信绑定处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年8月24日
	 * @version 1.0
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<String> membBdThird(MembBdThirdInfoPo po){
		// 返回值初期化处理
		ResultPoJo<String> result = new ResultPoJo<String>();
		//验证登录用户的信息
		User user = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(user)){
			result.setCode(ConstantCodeMsg.ERR_912);
			result.setMsg(ConstantCodeMsg.MSG_912);
			return result;
		}
		// 如果会员ID是空表示当前用户
		if(ConverterUtil.isEmpty(po.getMembId())){
			po.setMembId(user.getId());
		}
		// 通过手机号验证该账号是否已经绑定了其他的微信
		MembRelevanceInfo parameter = new MembRelevanceInfo();
		parameter.setReleId(po.getMembId());
		parameter.setType(po.getRelType());
		MembRelevanceInfo info = membRelevanceInfoMapper.getMembReleInfo(parameter);
		if(info != null){
			result.setCode(ConstantCodeMsg.ERR_518);
			result.setMsg(ConstantCodeMsg.MSG_518);
			return result;
		}
		// 通过unionid验证是否已经绑定
        MembRelevanceInfo membRelevanceInfo = new MembRelevanceInfo();
		membRelevanceInfo.setUnionId(po.getUnionId());
		membRelevanceInfo.setType(po.getRelType());
		Long membId = membRelevanceInfoMapper.getMembInfoByUnionId(membRelevanceInfo);
		if(ConverterUtil.isNotEmpty(membId)){
			result.setCode(ConstantCodeMsg.ERR_858);
			result.setMsg(ConstantCodeMsg.MSG_858);
			return result;
		}
		// 第三方登录关联表信息
		MembRelevanceInfo membReleVance = new MembRelevanceInfo();
		membReleVance.preInsert();
		membReleVance.setType(po.getRelType());//表示微信第三方登录
		membReleVance.setReleId(po.getMembId());
		membReleVance.setOpenId(po.getOpenId());
		membReleVance.setOpenType("0");
		membReleVance.setUnionId(po.getUnionId());
		membReleVance.setRemarks(po.getPetName());
		membRelevanceInfoMapper.insertSelective(membReleVance);
		// 修改会员表中的昵称处理
		MembInfo membInfo = new MembInfo();
		membInfo.setId(po.getMembId());
		membInfo.setBindWechat(po.getPetName());
		membInfoMapper.updateByPrimaryKeySelective(membInfo);
		return result;
	}
	/**
	 * 第三方解绑处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年8月24日
	 * @version 1.0
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<String> membThirdUnBindPo(MembThirdUnBindPo po){
		// 返回值初期化处理
		ResultPoJo<String> result = new ResultPoJo<String>();
		//验证登录用户的信息
		User user = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(user)){
			result.setCode(ConstantCodeMsg.ERR_912);
			result.setMsg(ConstantCodeMsg.MSG_912);
			return result;
		}
		// 如果会员ID是空表示当前用户
		if(ConverterUtil.isEmpty(po.getMembId())){
			po.setMembId(user.getId());
		}
		MembRelevanceInfo selInfo = new MembRelevanceInfo();
		selInfo.setReleId(po.getMembId());
		selInfo.setType(po.getType());// 默认是微信
		MembRelevanceInfo entity = membRelevanceInfoMapper.getMembReleInfo(selInfo);
        if(ConverterUtil.isEmpty(entity) || ConverterUtil.isEmpty(entity.getId())){
        	result.setCode(ConstantCodeMsg.ERR_513);
			result.setMsg(ConstantCodeMsg.MSG_513);
			return result;
        }
        entity.preUpdate();
        membRelevanceInfoMapper.deleteLogic(entity);
        // 会员表中绑定微信字段的清空
        MembInfo membInfo = new MembInfo();
        membInfo.preUpdate();
        membInfo.setId(po.getMembId());
        membInfoMapper.updBindWechat(membInfo);;
        // 清空会员相关的缓存信息
 		MembUtils.delMembSelfUser(po.getMembId());
		return result;
	}

}
