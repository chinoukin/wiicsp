package com.wisea.transac.tp.system.service.memb;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.mss.RemoteUserMss;
import com.wisea.cloud.common.po.LoginBatUpdatePo;
import com.wisea.cloud.common.po.ResetPasswordUserPo;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.dao.EntpAuthMapper;
import com.wisea.transac.common.dao.MembInfoMapper;
import com.wisea.transac.common.dao.RealPersonAuthMapper;
import com.wisea.transac.common.entity.MembBaseInfo;
import com.wisea.transac.common.entity.MembInfo;
import com.wisea.transac.common.mss.UserMembInfoMss;
import com.wisea.transac.common.po.memb.*;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.tp.system.utils.TpSystemMembUtils;
import com.wisea.transac.common.vo.memb.*;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
/**
 * 会员后台管理相关的接口Service
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月25日
 * @version 1.0
 */
@Service
public class MembBackService extends BaseService{

	@Autowired
	private RemoteUserMss remoteUserMss;
	@Autowired
	private MembInfoMapper membInfoMapper;
	@Autowired
	private EntpAuthMapper entpAuthMapper;
	@Autowired
	private RealPersonAuthMapper realPersonAuthMapper;
	@Autowired
	private UserMembInfoMss userMembInfoMss;

	/**
	 * 查询当前用户是市场用户还是运营平台用户
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月28日
	 * @version 1.0
	 */
	public ResultPoJo<PlatOrMarketLoginInfoVo> platLoginInit(){
		// 返回值初期化处理
		ResultPoJo<PlatOrMarketLoginInfoVo> result  = new ResultPoJo<PlatOrMarketLoginInfoVo>(ConstantCodeMsg.NOMAL);
		// 验证用户是否存在
		MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(ConverterUtil.toLong(SystemUtils.getUserOnlyId().getId()));
		if(membInfo == null){
			result.setCode(ConstantCodeMsg.ERR_711);
			result.setMsg(ConstantCodeMsg.MSG_711);
			return result;
		}
		PlatOrMarketLoginInfoVo vo = new PlatOrMarketLoginInfoVo();
		// 返回信息
		vo.setFlag(membInfo.getUserSourceType());
		vo.setMarketId(membInfo.getMarketId());
		vo.setMarketName(membInfo.getMarketName());
		result.setResult(vo);
		return result;
	}
	/**
	 * 冻结会员的操作
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月25日
	 * @version 1.0
	 */
	//@TxTransaction(type = Transactions.LCN, propagation = DTXPropagation.REQUIRED)
	@GlobalTransactional
	@Transactional(readOnly = false)
	public ResultPoJo<String> freezeMemb(FreezeMembUpdPo po){
		// 返回值初期化处理
		ResultPoJo<String> result  = new ResultPoJo<String>(ConstantCodeMsg.NOMAL);
		// 验证用户是否存在
		User oldUser = SystemUtils.getById(po.getMembId());
		if(oldUser == null){
			result.setCode(ConstantCodeMsg.ERR_711);
			result.setMsg(ConstantCodeMsg.MSG_711);
			return result;
		}
		// 根据会员查询销售和采购会员列表
		List<Long> purAndSaleIds = membInfoMapper.getPruAndSaleList(po.getMembId());
		// 修改会员表中的状态
		List<MembInfo> delList = Lists.newArrayList();
		MembInfo delMembInfo = new MembInfo();
		delMembInfo.preUpdate();
		delMembInfo.setId(po.getMembId());
		delMembInfo.setAcctState(po.getAcctState());
		delList.add(delMembInfo);
		List<String> delIds = Lists.newArrayList();
		delIds.add(ConverterUtil.toString(po.getMembId()));
		for(Long relId : purAndSaleIds){
			MembInfo delMemb = new MembInfo();
			delMemb.preUpdate();
			delMemb.setId(relId);
			delMemb.setAcctState(po.getAcctState());
			delIds.add(ConverterUtil.toString(relId));
		}
		membInfoMapper.batchUpdAcctStateByKey(delList);
		// 修改用户表中的状态
		LoginBatUpdatePo loginBatUpdate = new LoginBatUpdatePo();
		loginBatUpdate.setLoginFlag(TpSystemMembUtils.changeAcctState(po.getAcctState()));
		loginBatUpdate.setIds(String.join(",", delIds));
		ResultPoJo<Object> loginFlagUserResult = userMembInfoMss.membLoginBatUpdate(loginBatUpdate);
		if(!loginFlagUserResult.getCode().equals(ConstantError.NOMAL)){
			checkRemoteResult(loginFlagUserResult);
			result.setCode(loginFlagUserResult.getCode());
			result.setMsg(loginFlagUserResult.getMsg());
			return result;
		}
		// 清楚緩存
		MembUtils.delMembSelfUser(po.getMembId());
		return result;
	}
	/**
	 * 后台会员重置密码的操作
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月25日
	 * @version 1.0
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<String> membPwdReset(MembPwdUpdPo po){
		// 返回参数定义
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		// 验证登录用户的信息
		User user = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(user)){
			result.setCode(ConstantCodeMsg.ERR_912);
			result.setMsg(ConstantCodeMsg.MSG_912);
			return result;
		}
		// 验证参数是否真实存在
		MembBaseInfo exist = MembUtils.getMembInfoByUserId(po.getId());
		if(ConverterUtil.isEmpty(exist)){
			result.setCode(ConstantCodeMsg.ERR_513);
			result.setMsg(ConstantCodeMsg.MSG_513);
			return result;
		}
		// 修改用户的密码
		ResetPasswordUserPo resetPasswordUserPo = new ResetPasswordUserPo();
		resetPasswordUserPo.setId(po.getId());
		resetPasswordUserPo.setNewPassword(po.getPassword());
		ResultPoJo<Object> userResult = remoteUserMss.pwdReset(resetPasswordUserPo);
		if(!userResult.getCode().equals(ConstantError.NOMAL)){
			checkRemoteResult(userResult);
			result.setCode(userResult.getCode());
			result.setMsg(userResult.getMsg());
			return result;
		}
		return result;
	}
	/**
	 * 后台会员注册手机号的修改
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月25日
	 * @version 1.0
	 */
	//@TxTransaction(type = Transactions.LCN, propagation = DTXPropagation.REQUIRED)
	@GlobalTransactional
	@Transactional(readOnly = false)
	public ResultPoJo<String> updMembMobile(MembMobileUpdPo po){
		// 返回参数定义
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		// 验证登录用户的信息
		User loginUser = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(loginUser)){
			result.setCode(ConstantCodeMsg.ERR_912);
			result.setMsg(ConstantCodeMsg.MSG_912);
			return result;
		}
		// 验证参数是否真实存在
		MembBaseInfo exist = MembUtils.getMembInfoByUserId(po.getId());
		if(ConverterUtil.isEmpty(exist)){
			result.setCode(ConstantCodeMsg.ERR_513);
			result.setMsg(ConstantCodeMsg.MSG_513);
			return result;
		}
		// 手机号已经存在的情况
		MembCheckMobilePo membCheckMobilePo = new MembCheckMobilePo();
		membCheckMobilePo.setMobile(po.getMobile());
		membCheckMobilePo.setMembId(po.getId());
		int mobileCount = membInfoMapper.checkMobileExist(membCheckMobilePo);
		if(mobileCount > 0){
			result.setCode(ConstantCodeMsg.ERR_501);
			result.setMsg(ConstantCodeMsg.MSG_501);
			return result;
		}
		// 修改会员表中的信息
		MembInfo membInfo = new MembInfo();
		membInfo.setId(po.getId());
		membInfo.setRegistTel(po.getMobile());
		membInfo.preUpdate();
		membInfoMapper.updateByPrimaryKeySelective(membInfo);
		// 修改用户表中的手机号
		UpdUserMembInfoPo updUserMembInfoPo = new UpdUserMembInfoPo();
		updUserMembInfoPo.setId(po.getId());
		updUserMembInfoPo.setMobile(po.getMobile());
		ResultPoJo<String> userResult = userMembInfoMss.updUserMembInfo(updUserMembInfoPo);
		if(!userResult.getCode().equals(ConstantError.NOMAL)){
			checkRemoteResult(userResult);
		}
		// 清楚緩存
		MembUtils.delMembSelfUser(po.getId());
		return result;
	}
	/**
	 * 根据企业ID查询会员详细信息(传入企业ID)
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月22日
	 * @version 1.0
	 */
	public ResultPoJo<MembEntpDetailBackVo> getEntpMembDetail(LongIdPo po){
		// 返回值初期化处理
		ResultPoJo<MembEntpDetailBackVo> result = new ResultPoJo<MembEntpDetailBackVo>(ConstantCodeMsg.NOMAL);
		// 查询结果的处理
		MembEntpDetailBackVo vo = entpAuthMapper.getEntpMembDetail(po.getId());
		if(vo != null && vo.getEntpAuthVo() != null){
			vo.getRegInfoVo().setMembType(vo.getEntpAuthVo().getCustType());
		}
		result.setResult(vo);
		return result;
	}
	/**
	 * 根据个人认证ID查询会员详细信息(传入个人认证ID)
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月22日
	 * @version 1.0
	 */
	public ResultPoJo<MembPersonDetailBackVo> getPersonMembDetail(LongIdPo po){
		// 返回值初期化处理
		ResultPoJo<MembPersonDetailBackVo> result = new ResultPoJo<MembPersonDetailBackVo>(ConstantCodeMsg.NOMAL);
		// 查询结果的处理
		result.setResult(realPersonAuthMapper.getPersonMembDetail(po.getId()));
		return result;
	}
	/**
	 * getPersonMembDetail
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月19日
	 * @version 1.0
	 */
	public ResultPoJo<MembInfoDetailBackVo> getMembInfoDetail(LongIdPo po){
		// 返回值初期化处理
		ResultPoJo<MembInfoDetailBackVo> result = new ResultPoJo<MembInfoDetailBackVo>(ConstantCodeMsg.NOMAL);
		// 查询结果的处理
		UserRegisterInfoVo regInfo = entpAuthMapper.getMemRegInfoByMembId(po.getId());
		if(regInfo != null){
			MembInfoDetailBackVo vo = new MembInfoDetailBackVo();
			vo.setMembId(regInfo.getId());
			vo.setRegInfoVo(regInfo);
			result.setResult(vo);
		}
		return result;
	}
	/**
	 * 冻结/修改手机号/重置密码时初期化会员基本信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月28日
	 * @version 1.0
	 */
	public ResultPoJo<MembProveBaseInfoVo> membProveInit(LongIdPo po){
		// 返回值初期化处理
		ResultPoJo<MembProveBaseInfoVo> result = new ResultPoJo<MembProveBaseInfoVo>(ConstantCodeMsg.NOMAL);
		// 验证登录用户的信息
		User loginUser = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(loginUser)){
			result.setCode(ConstantCodeMsg.ERR_912);
			result.setMsg(ConstantCodeMsg.MSG_912);
			return result;
		}
		// 验证参数是否真实存在
		MembProveBaseInfoVo vo = membInfoMapper.getMembProveInit(po.getId());
		if(vo == null){
			result.setCode(ConstantCodeMsg.ERR_513);
			result.setMsg(ConstantCodeMsg.MSG_513);
			return result;
		}
		result.setResult(vo);
		return result;
	}
	/**
	 * 根据条件查询会员信息列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年12月4日
	 * @version 1.0
	 */
	public ResultPoJo<List<EntpInfoForAllListVo>> findMembInfoAll(EntpInfoForAllListPo po){
		// 返回参数定义
		ResultPoJo<List<EntpInfoForAllListVo>> result = new ResultPoJo<List<EntpInfoForAllListVo>>(ConstantError.NOMAL);
		// 查询列表信息
		result.setResult(membInfoMapper.findMembInfoAll(po));
		return result;
	}

	/**
	 * 获取所有的会员信息列表(设置手续费)
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年5月17日
	 * @version 1.0
	 */
	public List<MembEntpInfoListVo> findEntpListForSer(){
		// 返回参数
		List<MembEntpInfoListVo> vo = new ArrayList<MembEntpInfoListVo>();
		//查询处理
		vo = entpAuthMapper.findEntpListForSer();
		return vo;
	}
}
