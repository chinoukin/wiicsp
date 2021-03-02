package com.wisea.transac.tp.system.service.memb;

import java.util.List;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.mss.RemoteUserMss;
import com.wisea.cloud.common.po.ResetPasswordUserPo;
import com.wisea.cloud.common.po.UpdatePasswordUserPo;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.service.ValidateCodeService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.JsonMapper;
import com.wisea.cloud.common.util.PasswordUtil;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.dao.MembInfoMapper;
import com.wisea.transac.common.dao.RealPersonAuthMapper;
import com.wisea.transac.common.entity.MembBaseInfo;
import com.wisea.transac.common.entity.MembInfo;
import com.wisea.transac.common.mss.RemoteTIMAccountMss;
import com.wisea.transac.common.mss.UserMembInfoMss;
import com.wisea.transac.common.po.StringPo;
import com.wisea.transac.common.po.memb.CheckOldMobilePo;
import com.wisea.transac.common.po.memb.MembBaseInfoUpdPo;
import com.wisea.transac.common.po.memb.MembCheckMobilePo;
import com.wisea.transac.common.po.memb.MembListForMsgPo;
import com.wisea.transac.common.po.memb.MembPwdUpdatePo;
import com.wisea.transac.common.po.memb.MembSaveNewMobilePo;
import com.wisea.transac.common.po.memb.MembWechatPwdPo;
import com.wisea.transac.common.po.memb.UpdUserMembInfoPo;
import com.wisea.transac.common.po.tim.RemotePortraitSetPo;
import com.wisea.transac.common.po.tim.RemotePortraitSetPo.RemoteProfileItem;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.vo.MembInfoInfoVo;
import com.wisea.transac.common.vo.RealPersonAuthInfoVo;
import com.wisea.transac.common.vo.memb.MembInfoForSetVo;
import com.wisea.transac.common.vo.memb.MembInfoListForMsgVo;
import com.wisea.transac.common.vo.memb.SetPwdOrNameInitVo;
import com.wisea.transac.common.vo.seller.MembInfoVo;

import io.seata.spring.annotation.GlobalTransactional;

/**
 * 会员基本操作接口Service
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月9日
 * @version 1.0
 */
@Service
public class MembInfoService extends BaseService{

	@Autowired
	private MembInfoMapper membInfoMapper;
	@Autowired
	private ValidateCodeService validateCodeService;
	@Autowired
	private RemoteUserMss remoteUserMss;
	@Autowired
	private UserMembInfoMss userMembInfoMss;
	@Autowired
	private RemoteTIMAccountMss remoteTIMAccountMss;
	@Autowired
	private RealPersonAuthMapper realPersonAuthMapper;
	/**
	 * 查询会员的基本信息（小程序端设置的初期话处理）
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月9日
	 * @version 1.0
	 */
	public ResultPoJo<MembInfoForSetVo> getMembInfoForSet(LongIdPo po){
		//  返回参数
		ResultPoJo<MembInfoForSetVo> result = new ResultPoJo<MembInfoForSetVo>(ConstantError.NOMAL);
		// 查询会员的基本信息
		MembInfoForSetVo vo = membInfoMapper.getMembInfoForSet(po.getId());
		if(vo  == null){
			result.setCode(ConstantCodeMsg.ERR_005);
			result.setMsg(ConstantCodeMsg.MSG_005);
			return result;
		}
		vo.setRegistTel(MembUtils.telEncrypt(vo.getRegistTel()));
		result.setResult(vo);
		return result;
	}
	/**
	 * 验证旧的注册手机号是否存在的处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月9日
	 * @version 1.0
	 */
	public ResultPoJo<String> checkOldMobile(CheckOldMobilePo po){
		//  返回参数
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		// 验证登录用户的信息
		User user = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(user)){
			result.setCode(ConstantCodeMsg.ERR_912);
			result.setMsg(ConstantCodeMsg.MSG_912);
			return result;
		}
		if(ConverterUtil.isEmpty(po.getId())){
			po.setId(user.getId());
		}
		// 查询处理
		int count = membInfoMapper.checkOldMobile(po);
		if(count < 1){
			result.setCode(ConstantCodeMsg.ERR_812);
			result.setMsg(ConstantCodeMsg.MSG_812);
			return result;
		}
		return result;
	}
	/**
	 *  验证新绑定的手机号是否已经绑定其他账号
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月9日
	 * @version 1.0
	 */
	public ResultPoJo<String> checkNewMobile(StringPo po){
		//  返回参数
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		// 查询处理
		MembCheckMobilePo membCheckMobilePo = new MembCheckMobilePo();
		membCheckMobilePo.setMobile(po.getKeyStr());
		int count = membInfoMapper.checkMobileExist(membCheckMobilePo);
		if(count > 0){
			result.setCode(ConstantCodeMsg.ERR_813);
			result.setMsg(ConstantCodeMsg.MSG_813);
			return result;
		}
		return result;
	}
	/**
	 * 保存新手机号的处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月9日
	 * @version 1.0
	 */
	//@TxTransaction(type = Transactions.LCN, propagation = DTXPropagation.REQUIRED)
	@GlobalTransactional
	@Transactional(readOnly = false)
	public ResultPoJo<String> saveNewMobile(MembSaveNewMobilePo po){
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		// 验证登录用户的信息
		User user = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(user)){
			result.setCode(ConstantCodeMsg.ERR_912);
			result.setMsg(ConstantCodeMsg.MSG_912);
			return result;
		}
		if(ConverterUtil.isEmpty(po.getId())){
			po.setId(user.getId());
		}
		// 验证旧手机号
		CheckOldMobilePo checkOldMobilePo = new CheckOldMobilePo();
		checkOldMobilePo.setId(po.getId());
		checkOldMobilePo.setMobile(po.getOldMobile());
		int count = membInfoMapper.checkOldMobile(checkOldMobilePo);
		if(count != 1){
			result.setCode(ConstantCodeMsg.ERR_812);
			result.setMsg(ConstantCodeMsg.MSG_812);
			return result;
		}
		// 查询处理
		MembCheckMobilePo membCheckMobilePo = new MembCheckMobilePo();
		membCheckMobilePo.setMobile(po.getNewMobile());
		int newCount = membInfoMapper.checkMobileExist(membCheckMobilePo);
		if(newCount > 0){
			result.setCode(ConstantCodeMsg.ERR_813);
			result.setMsg(ConstantCodeMsg.MSG_813);
			return result;
		}
		// 验证短信验证码是否正确
		if(!validateCodeService.checkSMSCode(po.getOldMobile(),po.getVilCode(),true)){
			result.setCode(ConstantCodeMsg.ERR_503);
			result.setMsg(ConstantCodeMsg.MSG_503);
			return result;
		}
		// 保存处理
		UpdUserMembInfoPo updUserMembInfoPo = new UpdUserMembInfoPo();
		updUserMembInfoPo.setId(po.getId());
		updUserMembInfoPo.setMobile(po.getNewMobile());
		ResultPoJo<String> userResult = userMembInfoMss.updUserMembInfo(updUserMembInfoPo);
		if(!userResult.getCode().equals(ConstantError.NOMAL)){
			checkRemoteResult(userResult);
		}
		// 保存到用户表中
		MembInfo membInfo = new MembInfo();
		membInfo.setId(po.getId());
		membInfo.setRegistTel(po.getNewMobile());
		membInfoMapper.updateByPrimaryKeySelective(membInfo);
		// 清楚緩存
		MembUtils.delMembSelfUser(po.getId());
		return result;
	}
	/**
	 * 通过旧密码修改用户密码(修改当前用户的密码)
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年9月26日
	 * @version 1.0
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<String> userUpdPwd(MembPwdUpdatePo membPwdUpdatePo){
		//  返回参数
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		// 验证登录用户的信息
		User user = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(user)){
			result.setCode(ConstantCodeMsg.ERR_912);
			result.setMsg(ConstantCodeMsg.MSG_912);
			return result;
		}
		// 验证密码和确认密码是否相同
		if(!membPwdUpdatePo.getNewPwd().equals(membPwdUpdatePo.getConNewPwd())){
			result.setCode(ConstantCodeMsg.ERR_504);
			result.setMsg(ConstantCodeMsg.MSG_504);
			return result;
		}
		// 校验旧密码是否正确
        if (!PasswordUtil.validatePassword(membPwdUpdatePo.getOldPwd(),user.getPassword())) {
            result.setCode(ConstantError.ERR_906);
            result.setMsg(ConstantError.MSG_906);
            return result;
        }
		// 调用修改用户密码的接口
		// 修改用户的密码
		UpdatePasswordUserPo updatePasswordUserPo = new UpdatePasswordUserPo();
		updatePasswordUserPo.setId(user.getId());
		updatePasswordUserPo.setPassword(membPwdUpdatePo.getOldPwd());
		updatePasswordUserPo.setNewPassword(membPwdUpdatePo.getConNewPwd());
		ResultPoJo<Object> userResult = remoteUserMss.updatePassword(updatePasswordUserPo);
		System.out.println(JsonMapper.toJsonString(userResult));
		if(!userResult.getCode().equals(ConstantError.NOMAL)){
			result.setCode(userResult.getCode());
			result.setMsg(userResult.getMsg());
			checkRemoteResult(userResult);
			return result;
		}
		return result;
	}
	/**
	 * 设置用户名密码判断
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年7月24日
	 * @version 1.0
	 */
	public ResultPoJo<SetPwdOrNameInitVo> setPwdOrNameInit(){
		// 返回参数
		ResultPoJo<SetPwdOrNameInitVo> result = new ResultPoJo<SetPwdOrNameInitVo>(ConstantError.NOMAL);
		// 验证登录用户的信息
		User user = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(user)){
			result.setCode(ConstantCodeMsg.ERR_912);
			result.setMsg(ConstantCodeMsg.MSG_912);
			return result;
		}
		// 会员是否存在
		MembInfo entity = membInfoMapper.selectByPrimaryKey(user.getId());
		SetPwdOrNameInitVo setPwdOrNameInitVo = new SetPwdOrNameInitVo();
		setPwdOrNameInitVo.setId(entity.getId());
		setPwdOrNameInitVo.setLoginNameSetFlag(entity.getLoginNameSetFlag());
		setPwdOrNameInitVo.setPasswordSetFlag(entity.getPasswordSetFlag());
		result.setResult(setPwdOrNameInitVo);
		return result;
	}
	/**
	 * 微信设定密码
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年12月10日
	 * @version 1.0
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<String> firstSavePwd(MembWechatPwdPo po){
		// 返回参数
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		// 验证登录用户的信息
		User user = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(user)){
			result.setCode(ConstantCodeMsg.ERR_912);
			result.setMsg(ConstantCodeMsg.MSG_912);
			return result;
		}
		po.setId(user.getId());
		// 会员是否存在
		MembInfo entity = membInfoMapper.selectByPrimaryKey(po.getId());
		if(entity == null || ConverterUtil.isEmpty(entity.getId())){
			result.setCode(ConstantCodeMsg.ERR_513);
			result.setMsg(ConstantCodeMsg.MSG_513);
			return result;
		}
		// 验证密码和确认密码是否相同
		if(!po.getNewPwd().equals(po.getConNewPwd())){
			result.setCode(ConstantCodeMsg.ERR_504);
			result.setMsg(ConstantCodeMsg.MSG_504);
			return result;
		}
		//验证用户是否已经保存密码
		if(DictConstants.PASSWORD_SET_FLAG_0.equals(entity.getPasswordSetFlag())){
			result.setCode(ConstantCodeMsg.ERR_311);
			result.setMsg(ConstantCodeMsg.MSG_311);
			return result;
		}
		// 修改会员表中的标识
		MembInfo newEntity = new MembInfo();
		newEntity.setId(po.getId());
		newEntity.setPasswordSetFlag(DictConstants.PASSWORD_SET_FLAG_0);
		membInfoMapper.updateByPrimaryKeySelective(newEntity);
		// 初期化用户表中的密码
		ResetPasswordUserPo pwdUser = new ResetPasswordUserPo();
		pwdUser.setId(po.getId());
		pwdUser.setNewPassword(po.getNewPwd());
		ResultPoJo<Object> userResult = remoteUserMss.pwdReset(pwdUser);
		if(!userResult.getCode().equals(ConstantError.NOMAL)){
			result.setCode(userResult.getCode());
			result.setMsg(userResult.getMsg());
			checkRemoteResult(userResult);
			return result;
		}
		return result;
	}
	/**
	 * 发送消息 -指定的时候查询所有的会员接口
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年7月16日
	 * @version 1.0
	 */
	public ResultPoJo<List<MembInfoListForMsgVo>> membListForMsg(MembListForMsgPo po){
		//  返回参数
		ResultPoJo<List<MembInfoListForMsgVo>> result = new ResultPoJo<List<MembInfoListForMsgVo>>(ConstantError.NOMAL);
		result.setResult(membInfoMapper.membListForMsg(po));
		return result;
	}
	/**
	 * 修改会员基础信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年8月17日
	 * @version 1.0
	 */
	@GlobalTransactional
	@Transactional(readOnly = false)
	public ResultPoJo<String> updMembBaseInfo(MembBaseInfoUpdPo po){
		// 返回参数
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		// 验证登录用户的信息
		User user = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(user)){
			result.setCode(ConstantCodeMsg.ERR_912);
			result.setMsg(ConstantCodeMsg.MSG_912);
			return result;
		}
		if(ConverterUtil.isEmpty(po.getId())){
			po.setId(user.getId());
		}
		// 会员是否存在
		MembInfo entity = membInfoMapper.selectByPrimaryKey(po.getId());
		if(entity == null || ConverterUtil.isEmpty(entity.getId())){
			result.setCode(ConstantCodeMsg.ERR_513);
			result.setMsg(ConstantCodeMsg.MSG_513);
			return result;
		}
		// 修改会员信息
		boolean isUpdFlag = false;
		MembInfo newMembInfo = new MembInfo();
		newMembInfo.preUpdate();
		newMembInfo.setId(po.getId());
		if(ConverterUtil.isNotEmpty(po.getPetName())){
			newMembInfo.setPetName(po.getPetName());
			isUpdFlag = true;
		}
		if(ConverterUtil.isNotEmpty(po.getLogoUrl())){
			newMembInfo.setLogoUrl(po.getLogoUrl());
			isUpdFlag = true;
		}
		if(ConverterUtil.isNotEmpty(po.getContName())){
			// 如果已经实名认证的不允许修改姓名
			RealPersonAuthInfoVo personAuthInfo = realPersonAuthMapper.findInfoByUserId(po.getId());
			if(personAuthInfo != null){
				result.setCode(ConstantCodeMsg.ERR_857);
				result.setMsg(ConstantCodeMsg.MSG_857);
				return result;
			}
			newMembInfo.setContName(po.getContName());
			isUpdFlag = true;
		}
		if(isUpdFlag){
			membInfoMapper.updateByPrimaryKeySelective(newMembInfo);
		}
		// 修改客服聊天窗口昵称
		if(ConverterUtil.isNotEmpty(po.getPetName())){
			RemotePortraitSetPo remotePortraitSetPo = new RemotePortraitSetPo();
			remotePortraitSetPo.setFromAccount(ConverterUtil.toString(po.getId()));
			List<RemoteProfileItem> profileItem = Lists.newArrayList();
			RemoteProfileItem remoteProfileItem = new RemoteProfileItem();
			remoteProfileItem.setTag("Tag_Profile_IM_Nick");
			remoteProfileItem.setValue(po.getPetName());
			profileItem.add(remoteProfileItem);
			remotePortraitSetPo.setProfileItem(profileItem);
			ResultPoJo<Object> customResult =  remoteTIMAccountMss.userPortraitSet(remotePortraitSetPo);
			if(!ConstantCodeMsg.NOMAL.equals(customResult.getCode())){
				checkRemoteResult(customResult);
				result.setCode(customResult.getCode());
				result.setMsg(customResult.getMsg());
				return result;
			}
		}
		// 修改客服聊天窗口头像信息
		if(ConverterUtil.isNotEmpty(po.getLogoUrl())){
			RemotePortraitSetPo remotePortraitSetPo = new RemotePortraitSetPo();
			remotePortraitSetPo.setFromAccount(ConverterUtil.toString(po.getId()));
			List<RemoteProfileItem> profileItem = Lists.newArrayList();
			RemoteProfileItem remoteProfileItem = new RemoteProfileItem();
			remoteProfileItem.setTag("Tag_Profile_IM_Image");
			remoteProfileItem.setValue(po.getLogoUrl());
			profileItem.add(remoteProfileItem);
			remotePortraitSetPo.setProfileItem(profileItem);
			ResultPoJo<Object> customResult =  remoteTIMAccountMss.userPortraitSet(remotePortraitSetPo);
			if(!ConstantCodeMsg.NOMAL.equals(customResult.getCode())){
				checkRemoteResult(customResult);
				result.setCode(customResult.getCode());
				result.setMsg(customResult.getMsg());
				return result;
			}
		}
		// 清楚緩存
		MembUtils.delMembSelfUser(po.getId());
		return result;
	}

	/**
	 * 查询客服基本信息
	 * @param po
	 * @return
	 */
	public ResultPoJo<MembInfoVo> getMembInfo(LongIdPo po) {
		ResultPoJo<MembInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		MembInfoVo vo = new MembInfoVo();
		MembBaseInfo info = MembUtils.getMembInfoByUserId(po.getId());
		vo.setId(info.getId());
		vo.setName(ConverterUtil.isNotEmpty(info.getContName())? info.getContName() : ConverterUtil.isNotEmpty(info.getLoginName())?info.getLoginName() : info.getRegistTel());
		vo.setContName(info.getContName());
		vo.setLogoUrl(info.getLogoUrl());
		vo.setEntpName(info.getAuthName());
		vo.setPetName(info.getPetName());
		vo.setLoginNameSetFlag(info.getLoginNameSetFlag());
		if (!DictConstants.LOGIN_NAME_SET_FLAG_1.equals(info.getLoginNameSetFlag())){
			vo.setLoginName(info.getLoginName());
		}
		vo.setRegistTel(info.getRegistTel());
		MembInfoInfoVo membInfoInfoVo = membInfoMapper.findInfo(po);
		if (ConverterUtil.isNotEmpty(membInfoInfoVo)){
			vo.setPosition(membInfoInfoVo.getPosition());
			vo.setSexType(membInfoInfoVo.getSexType());
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
