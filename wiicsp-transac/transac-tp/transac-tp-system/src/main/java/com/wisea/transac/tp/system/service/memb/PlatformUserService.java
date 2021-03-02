package com.wisea.transac.tp.system.service.memb;

import java.util.ArrayList;
import java.util.List;

import com.wisea.transac.tp.system.utils.TpSystemMembUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.constants.Constants;
import com.wisea.cloud.common.exception.BusinessException;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.Role;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.IdGen;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.dao.MarketAcctNumMageMapper;
import com.wisea.transac.common.dao.MembInfoMapper;
import com.wisea.transac.common.dao.RoleExtendsMapper;
import com.wisea.transac.common.entity.MarketAcctNumMage;
import com.wisea.transac.common.mss.UserMembInfoMss;
import com.wisea.transac.common.po.memb.MarketAdminExportPo;
import com.wisea.transac.common.po.memb.MarketAdminInfoPagePo;
import com.wisea.transac.common.po.memb.MarketAdminUpdPo;
import com.wisea.transac.common.po.memb.MembCheckLoginNamePo;
import com.wisea.transac.common.po.memb.PlatFormUserExportPo;
import com.wisea.transac.common.po.memb.PlatFormUserInfoPo;
import com.wisea.transac.common.po.memb.PlatFormUserPagePo;
import com.wisea.transac.common.po.memb.RegisterUserMembPo;
import com.wisea.transac.common.po.memb.RoleExtendsCheckPo;
import com.wisea.transac.common.po.memb.UpdUserMembInfoPo;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.vo.memb.MarketAdminInfoExportVo;
import com.wisea.transac.common.vo.memb.MarketAdminInfoVo;
import com.wisea.transac.common.vo.memb.PlatFormUserInfoExportVo;
import com.wisea.transac.common.vo.memb.PlatFormUserInfoVo;

import io.seata.spring.annotation.GlobalTransactional;

/**
 * 运营平台用户管理Service
 *
 * @author wangh(wisea)
 *
 * @date 2020年4月30日
 * @version 1.0
 */
@Service
public class PlatformUserService extends BaseService{

	@Autowired
	private MembInfoMapper membInfoMapper;
	@Autowired
	private MarketAcctNumMageMapper marketAcctNumMageMapper;
	@Autowired
	private RoleExtendsMapper roleExtendsMapper;
	@Autowired
	private UserMembInfoMss userMembInfoMss;

	/**
	 * 分页查询市场管理员信息列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月7日
	 * @version 1.0
	 */
	public ResultPoJo<List<MarketAdminInfoVo>> findMarketAdminList(MarketAdminInfoPagePo po){
		//  返回参数
		ResultPoJo<List<MarketAdminInfoVo>> result = new ResultPoJo<List<MarketAdminInfoVo>>(ConstantError.NOMAL);
		// 分页查询并且返回
		result.setResult(marketAcctNumMageMapper.findMarketAdminList(po));
		return result;
	}
	/**
	 * 导出市场管理员信息列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月19日
	 * @version 1.0
	 */
	public List<MarketAdminInfoExportVo> marketAdminListExport(MarketAdminExportPo po){
		return marketAcctNumMageMapper.marketAdminListExport(po);
	}
	/**
	 * 根据ID查询市场管理员的基本信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月7日
	 * @version 1.0
	 */
	public ResultPoJo<MarketAdminInfoVo> getMarketAdminInfo(LongIdPo po){
		//  返回参数
		ResultPoJo<MarketAdminInfoVo> result = new ResultPoJo<MarketAdminInfoVo>(ConstantError.NOMAL);
		// 查询并且返回处理
		result.setResult(marketAcctNumMageMapper.getMarketAdminInfo(po.getId()));
		return result;
	}
	/**
	 * 修改市场管理员信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月7日
	 * @version 1.0
	 */
	//@TxTransaction(type = Transactions.LCN, propagation = DTXPropagation.REQUIRED)
	@GlobalTransactional
	@Transactional(readOnly = false)
	public ResultPoJo<String> updMarketAdmin(MarketAdminUpdPo po){
		//  返回参数
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		// 根据ID验证用户是否存在
		MarketAcctNumMage oldEntity = marketAcctNumMageMapper.selectByPrimaryKey(po.getId());
		if(oldEntity == null || ConverterUtil.isEmpty(oldEntity.getId())){
			result.setCode(ConstantCodeMsg.ERR_711);
			result.setMsg(ConstantCodeMsg.MSG_711);
			return result;
		}
		// 验证用户名是否重复
		MembCheckLoginNamePo membCheckLoginNamePo = new MembCheckLoginNamePo();
		membCheckLoginNamePo.setLoginName(po.getLoginName());
		membCheckLoginNamePo.setMembId(po.getId());
		int count = membInfoMapper.checkLoginNameExist(membCheckLoginNamePo);
		// 用户名称已经存在的情况
		if(count > 0){
			result.setCode(ConstantCodeMsg.ERR_502);
			result.setMsg(ConstantCodeMsg.MSG_502);
			return result;
		}
		// 修改用户的处理
		UpdUserMembInfoPo updUserMembInfoPo = new UpdUserMembInfoPo();
		updUserMembInfoPo.setId(po.getId());
		boolean isUpd = false;
		// 是否修改用户名称
		if(!oldEntity.getLoginName().equals(po.getLoginName())){
			updUserMembInfoPo.setLoginName(po.getLoginName());
			isUpd = true;
		}
		// 是否修改密码
		if(ConverterUtil.isNotEmpty(po.getPassword())){
			updUserMembInfoPo.setPassword(po.getPassword());
			isUpd = true;
		}
		if(isUpd){
			updUserMembInfoPo.setLoginFlag(null);
			ResultPoJo<String> updUserMembRes = userMembInfoMss.updUserMembInfo(updUserMembInfoPo);
			if(!updUserMembRes.getCode().equals(ConstantError.NOMAL)){
				throw new BusinessException(updUserMembRes.getCode(), updUserMembRes.getMsg());
			}
		}
		// 保存市场员工管理表信息
		MarketAcctNumMage marketAcctNumMage = new MarketAcctNumMage();
		marketAcctNumMage.setId(po.getId());
		marketAcctNumMage.setLoginName(po.getLoginName());
		marketAcctNumMage.setName(po.getName());
		marketAcctNumMage.setTel(po.getTel());
		marketAcctNumMageMapper.updateByPrimaryKeySelective(marketAcctNumMage);
		// 清空缓存的处理
		MembUtils.delMembUser(po.getId());
		return result;
	}
	/**
	 * 分页查询用户信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月7日
	 * @version 1.0
	 */
	public ResultPoJo<List<PlatFormUserInfoVo>> findPageForPlat(PlatFormUserPagePo po){
		//  返回参数
		ResultPoJo<List<PlatFormUserInfoVo>> result = new ResultPoJo<List<PlatFormUserInfoVo>>(ConstantError.NOMAL);
		// 分页查询处理
		result.setResult(marketAcctNumMageMapper.findPageList(po));
		return result;
	}
	/**
	 * 导出运营平台、市场人员用户列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月19日
	 * @version 1.0
	 */
	public List<PlatFormUserInfoExportVo> userListExport(PlatFormUserExportPo po){
		return marketAcctNumMageMapper.userListExport(po);
	}
	/**
	 * 根据ID查询总运营平台或者市场下员工的信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月6日
	 * @version 1.0
	 */
	public ResultPoJo<PlatFormUserInfoVo> getPlatFormUserInfo(LongIdPo po){
		//  返回参数
		ResultPoJo<PlatFormUserInfoVo> result = new ResultPoJo<PlatFormUserInfoVo>(ConstantError.NOMAL);
		PlatFormUserInfoVo vo = new PlatFormUserInfoVo();
		// 查询市场帐号管理表的信息
		MarketAcctNumMage marketAcctNumMage = marketAcctNumMageMapper.selectByPrimaryKey(po.getId());
		if(marketAcctNumMage != null){
			ConverterUtil.copyProperties(marketAcctNumMage, vo);
		}
		result.setResult(vo);
		return result;
	}
	/**
	 * 新增或者修改修改总运营平台、市场管理的用户信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月18日
	 * @version 1.0
	 */
	//@TxTransaction(type = Transactions.LCN, propagation = DTXPropagation.REQUIRED)
	@GlobalTransactional
	@Transactional(readOnly = false)
	public ResultPoJo<String> saveMarketOrPlatFormUser(PlatFormUserInfoPo po){
		// 新增修改处理的判断
		if(ConverterUtil.isEmpty(po.getId())){
			// 操作并且返回
			po.setSfAdminFlag(DictConstants.SF_ADMIN_FLAG_1);// 设置成非管理员
			return addMarketAcctNumMage(po);
		}else{
			// 操作并且返回
			return updMarketAcctNumMage(po);
		}
	}
	/**
	 * 平台或者市场添加员工的处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月6日
	 * @version 1.0
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<String> addMarketAcctNumMage(PlatFormUserInfoPo po){
		//  返回参数
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		// 验证用户名是否重复
		MembCheckLoginNamePo membCheckLoginNamePo = new MembCheckLoginNamePo();
		membCheckLoginNamePo.setLoginName(po.getLoginName());
		int count = membInfoMapper.checkLoginNameExist(membCheckLoginNamePo);
		// 用户名称已经存在的情况
		if(count > 0){
			result.setCode(ConstantCodeMsg.ERR_502);
			result.setMsg(ConstantCodeMsg.MSG_502);
			return result;
		}
		// 插入用户信息
		RegisterUserMembPo registerUserMembPo = new RegisterUserMembPo();
		registerUserMembPo.setId(IdGen.randomLong());// 生成ID
		registerUserMembPo.setParentId(membInfoMapper.getAdminId(po.getMarketId()));
		registerUserMembPo.setLoginName(po.getLoginName());// 登录用户名
		registerUserMembPo.setPassword(po.getPassword());// 密码
		registerUserMembPo.setLoginFlag(TpSystemMembUtils.changeFlag(po.getEffeInvalState()));// 登录标识
		// 自定义角色类型的处理
		List<String> roleList = new ArrayList<String>();
		// 总运营平台的情况
		if(ConverterUtil.isEmpty(po.getMarketId())){
			// 子账号的情况需要验证角色信息是否存在
			RoleExtendsCheckPo roleExtendsCheckPo = new RoleExtendsCheckPo();
			roleExtendsCheckPo.setId(po.getRoleType());
			roleExtendsCheckPo.setMarketId(ConverterUtil.toString(membInfoMapper.getAdminId(null)));
			Role role = roleExtendsMapper.getRoleById(roleExtendsCheckPo);
			if(role == null  || ConverterUtil.isEmpty(po.getRoleType())){
				result.setCode(ConstantCodeMsg.ERR_916);
				result.setMsg(ConstantCodeMsg.MSG_916);
				return result;
			}
			registerUserMembPo.setUserType(Constants.USER_TYPE_SUBUSER);// 用户类型：子账户
			roleList.add(role.getCode());// 新建用户的权限 -- 自定义权限
		// 新增市场用户的
		}else{
			// 市场超级管理员的情况
			if(DictConstants.SF_ADMIN_FLAG_0.equals(po.getSfAdminFlag())){
				registerUserMembPo.setUserType(Constants.USER_TYPE_USER);// 用户类型：普通用户
				roleList.add("ROLE_market_admin");// 市场超级用户
			// 市场子账户的情况
			}else{
				// 子账号的情况需要验证角色信息是否存在
				RoleExtendsCheckPo roleExtendsCheckPo = new RoleExtendsCheckPo();
				roleExtendsCheckPo.setId(po.getRoleType());
				roleExtendsCheckPo.setMarketId(ConverterUtil.toString(po.getMarketId()));
				Role role = roleExtendsMapper.getRoleById(roleExtendsCheckPo);
				if(role == null  || ConverterUtil.isEmpty(po.getRoleType())){
					result.setCode(ConstantCodeMsg.ERR_916);
					result.setMsg(ConstantCodeMsg.MSG_916);
					return result;
				}
				registerUserMembPo.setUserType(Constants.USER_TYPE_SUBUSER);// 用户类型：子账户
				roleList.add(role.getCode());// 新建用户的权限 -- 自定义权限
			}
		}
		registerUserMembPo.setRoleCodes(roleList);
		ResultPoJo<User> userResult = userMembInfoMss.registerMemb(registerUserMembPo);
		if(!userResult.getCode().equals(ConstantError.NOMAL)
				|| ConverterUtil.isEmpty(userResult.getResult().getId())){
			checkRemoteResult(userResult);
			result.setCode(userResult.getCode());
			result.setMsg(userResult.getMsg());
			return result;
		}
		// 添加市场或者平台账号
		MarketAcctNumMage marketAcctNumMage = new MarketAcctNumMage();
		marketAcctNumMage.setId(userResult.getResult().getId());
		marketAcctNumMage.setWholeSaleMarketId(po.getMarketId());
		marketAcctNumMage.setLoginName(po.getLoginName());
		marketAcctNumMage.setName(po.getName());
		marketAcctNumMage.setTel(po.getTel());
		marketAcctNumMage.setRoleType(po.getRoleType());
		marketAcctNumMage.setSfAdminFlag(po.getSfAdminFlag());
		marketAcctNumMage.setEffeInvalState(po.getEffeInvalState());
		marketAcctNumMageMapper.insert(marketAcctNumMage);
		return result;
	}
	/**
	 * 平台或者市场修改员工的处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月6日
	 * @version 1.0
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<String> updMarketAcctNumMage(PlatFormUserInfoPo po){
		//  返回参数
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		// 根据ID验证用户是否存在
		MarketAcctNumMage oldEntity = marketAcctNumMageMapper.selectByPrimaryKey(po.getId());
		if(oldEntity == null || ConverterUtil.isEmpty(oldEntity.getId())){
			result.setCode(ConstantCodeMsg.ERR_711);
			result.setMsg(ConstantCodeMsg.MSG_711);
			return result;
		}
		// 验证用户名是否重复
		MembCheckLoginNamePo membCheckLoginNamePo = new MembCheckLoginNamePo();
		membCheckLoginNamePo.setLoginName(po.getLoginName());
		membCheckLoginNamePo.setMembId(po.getId());
		int count = membInfoMapper.checkLoginNameExist(membCheckLoginNamePo);
		// 用户名称已经存在的情况
		if(count > 0){
			result.setCode(ConstantCodeMsg.ERR_502);
			result.setMsg(ConstantCodeMsg.MSG_502);
			return result;
		}
		// 如果角色不是空的时候判断角色是否存在
		if(ConverterUtil.isNotEmpty(po.getRoleType())){
			// 验证角色是否存在
			RoleExtendsCheckPo roleExtendsCheckPo = new RoleExtendsCheckPo();
			roleExtendsCheckPo.setId(po.getRoleType());
			if(ConverterUtil.isEmpty(po.getMarketId())){
				roleExtendsCheckPo.setMarketId(ConverterUtil.toString(membInfoMapper.getAdminId(null)));
			}else{
				roleExtendsCheckPo.setMarketId(ConverterUtil.toString(po.getMarketId()));
			}
			Role role = roleExtendsMapper.getRoleById(roleExtendsCheckPo);
			if(role == null){
				result.setCode(ConstantCodeMsg.ERR_916);
				result.setMsg(ConstantCodeMsg.MSG_916);
				return result;
			}
		}
		// 修改用户的处理
		UpdUserMembInfoPo updUserMembInfoPo = new UpdUserMembInfoPo();
		updUserMembInfoPo.setId(po.getId());
		// 是否修改用户名称
		if(!oldEntity.getLoginName().equals(po.getLoginName())){
			updUserMembInfoPo.setLoginName(po.getLoginName());
		}
		// 是否修改密码
		if(ConverterUtil.isNotEmpty(po.getPassword())){
			updUserMembInfoPo.setPassword(po.getPassword());
		}
		// 是否修改启用停用状态
		if(ConverterUtil.isNotEmpty(po.getEffeInvalState()) && !oldEntity.getEffeInvalState().equals(po.getEffeInvalState())){
			updUserMembInfoPo.setLoginFlag(TpSystemMembUtils.changeFlag(po.getEffeInvalState()));
		}
		ResultPoJo<String> updUserMembRes = userMembInfoMss.updUserMembInfo(updUserMembInfoPo);
		if(!updUserMembRes.getCode().equals(ConstantError.NOMAL)){
			throw new BusinessException(updUserMembRes.getCode(), updUserMembRes.getMsg());
		}
		// 添加市场或者平台账号
		MarketAcctNumMage marketAcctNumMage = new MarketAcctNumMage();
		marketAcctNumMage.setId(po.getId());
		marketAcctNumMage.setLoginName(po.getLoginName());
		marketAcctNumMage.setName(po.getName());
		marketAcctNumMage.setTel(po.getTel());
		marketAcctNumMage.setRoleType(po.getRoleType());
		marketAcctNumMage.setEffeInvalState(po.getEffeInvalState());
		marketAcctNumMageMapper.updateByPrimaryKeySelective(marketAcctNumMage);
		// 清空缓存的处理
		MembUtils.delMembUser(po.getId());
		return result;
	}
	/**
	 * 根据ID删除平台用户信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月7日
	 * @version 1.0
	 */
	//@TxTransaction(type = Transactions.LCN, propagation = DTXPropagation.REQUIRED)
	@GlobalTransactional
	@Transactional(readOnly = false)
	public ResultPoJo<String> del(LongIdPo po){
		//  返回参数
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		// 根据ID验证用户是否存在
		MarketAcctNumMage oldEntity = marketAcctNumMageMapper.selectByPrimaryKey(po.getId());
		if(oldEntity == null || ConverterUtil.isEmpty(oldEntity.getId())){
			result.setCode(ConstantCodeMsg.ERR_711);
			result.setMsg(ConstantCodeMsg.MSG_711);
			return result;
		}
		// 删除用户表中的信息
		UpdUserMembInfoPo updUserMembInfoPo = new UpdUserMembInfoPo();
		updUserMembInfoPo.setId(po.getId());
		updUserMembInfoPo.setPhysicalDelFLag(Constants.YES);
		ResultPoJo<String> delUserResult = userMembInfoMss.updUserMembInfo(updUserMembInfoPo);
		if(!delUserResult.getCode().equals(ConstantError.NOMAL)){
			checkRemoteResult(delUserResult);
		}
		// 删除批发市场管理表中的信息
		MarketAcctNumMage marketAcctNumMage = new MarketAcctNumMage();
		marketAcctNumMage.setId(po.getId());
		marketAcctNumMage.setDelFlag("1");
		marketAcctNumMageMapper.updateByPrimaryKeySelective(marketAcctNumMage);
		return result;
	}
}
