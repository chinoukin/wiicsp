package com.wisea.transac.operation.service.user;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.wisea.transac.operation.customer.service.SysImCustomerConfigService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.constants.Constants;
import com.wisea.cloud.common.exception.BusinessException;
import com.wisea.cloud.common.exception.VerifyException;
import com.wisea.cloud.common.mss.RemoteOfImMss;
import com.wisea.cloud.common.openfire.po.OfPasswordUpdatePo;
import com.wisea.cloud.common.po.LoginBatUpdatePo;
import com.wisea.cloud.common.po.RegisterUserPo;
import com.wisea.cloud.common.po.ResetPasswordUserPo;
import com.wisea.cloud.common.po.UpdateLoginNamePo;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.properties.LoginCenterProperties;
import com.wisea.cloud.common.service.BusEventsService;
import com.wisea.cloud.common.service.RemoteLoginCenterService;
import com.wisea.cloud.common.sys.entity.Role;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.entity.UserRole;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.IdGen;
import com.wisea.cloud.common.util.PasswordUtil;
import com.wisea.cloud.rabbit.events.info.UserUpdateEventInfo;
import com.wisea.cloud.security.dao.RoleDao;
import com.wisea.cloud.security.dao.RoleMenuDao;
import com.wisea.cloud.security.po.UpdateMobileUserPo;
import com.wisea.cloud.security.po.UserAuthUpdatePo;
import com.wisea.cloud.security.service.MenuService;
import com.wisea.cloud.security.service.RoleService;
import com.wisea.cloud.security.service.UserBaseService;
import com.wisea.cloud.security.service.UserService;
import com.wisea.cloud.security.service.lcn.UserLcnAbsService;
import com.wisea.cloud.security.utils.UserUtils;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.dao.MembInfoMapper;
import com.wisea.transac.common.entity.MembInfo;
import com.wisea.transac.common.po.customer.CustomerConfigUserInsertPo;
import com.wisea.transac.common.po.customer.SysImCustomerListInsertPo;
import com.wisea.transac.common.po.customer.SysImCustomerListUpdatePo;
import com.wisea.transac.common.po.memb.AddRoleByUserIdPo;
import com.wisea.transac.common.po.memb.MembCheckMobilePo;
import com.wisea.transac.common.po.memb.MembStaffInfoAddPo;
import com.wisea.transac.common.po.memb.MembStaffInfoUpdPo;
import com.wisea.transac.common.po.memb.RegisterUserMembPo;
import com.wisea.transac.common.po.memb.UpdUserMembInfoPo;
import com.wisea.transac.common.utils.MembUtils;

/**
 * 用户会员远程服务相关接口处理
 *
 * @author wangh(wisea)
 *
 * @date 2020年6月11日
 * @version 1.0
 */
@EnableConfigurationProperties({ LoginCenterProperties.class })
@Service
public class UserMembMssService extends UserBaseService{

	@Autowired
	private RoleService roleService;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private UserService userService;
	@Autowired
	private UserLcnAbsService userLcnAbsService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private RoleMenuDao roleMenuDao;
	@Autowired
    private LoginCenterProperties loginCenterProperties;
	@Autowired(required = false)
    protected RemoteLoginCenterService remoteLoginCenterService;
	@Autowired
    private BusEventsService busEventsService;
	@Autowired(required = false)
    private RemoteOfImMss remoteOfImMss;
	@Autowired
	private MembInfoMapper membInfoMapper;
	@Autowired
	private SysImCustomerConfigService sysImCustomerConfigService;


	/**
	 * 注册用户会员信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月12日
	 * @version 1.0
	 */
	//@TxTransaction(type = Transactions.LCN, propagation = DTXPropagation.REQUIRED)
	@Transactional(readOnly = false)
	public ResultPoJo<User> registerMemb(RegisterUserMembPo po){
		// 返回值初期化处理
		ResultPoJo<User> result = new ResultPoJo<User>();
		if(po != null){
			RegisterUserPo registerUser = new RegisterUserPo();
			ConverterUtil.copyProperties(po, registerUser);
			User user = userLcnAbsService.register(registerUser, null);
			result.setResult(user);
		}else{
			result.setCode(ConstantError.ERR_001);
        	result.setMsg(ConstantError.MSG_001);
		}
		return result;
	}
	/**
	 * 无权限的修改用户名和密码信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年7月23日
	 * @version 1.0
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<String> updUserInfo(UpdUserMembInfoPo updUserMembInfoPo){
		// 返回值初期化处理
		ResultPoJo<String> result = new ResultPoJo<String>();
		// 验证参数
		if(updUserMembInfoPo != null && ConverterUtil.isNotEmpty(updUserMembInfoPo.getId())){
			User user = UserUtils.getById(updUserMembInfoPo.getId());
        	if(user == null){
        		result.setCode(ConstantError.ERR_907);
            	result.setMsg(ConstantError.MSG_907);
            	return result;
        	}
			// 用户名处理
        	if(ConverterUtil.isNotEmpty(updUserMembInfoPo.getLoginName())){
        		// 校验本地库中是否存在
                User existsUser = userDao.findByLoginName(updUserMembInfoPo.getLoginName());
                if (ConverterUtil.isNotEmpty(existsUser)) {
                    result.setCode(ConstantError.ERR_905);
                    result.setMsg(ConstantError.MSG_905);
                    return result;
                }
                // 旧的登录用户名称
                String oldLoginName = user.getLoginName();
                // 更新用户名称到sys_user表中
                user.setLoginName(updUserMembInfoPo.getLoginName());
                user.preUpdate();
                userDao.updateLoginName(user);
                // 开启了logincenter的话要进行远程端更新
                if (loginCenterProperties.isEnabled()) {
                    // 调用logincenter修改loginname
                    ResultPoJo<Object> remoteResult = remoteLoginCenterService.updateLoginName(oldLoginName, updUserMembInfoPo.getLoginName());
                    // 校验远程结果
                    checkRemoteResult(remoteResult);
                }
                // 清除缓存
                UserUtils.clearUserLoginCache(user);

                // 如果需要修改OF用户
                if (null != remoteOfImMss) {
                    OfPasswordUpdatePo po = new OfPasswordUpdatePo();
                    // 设置用户名为id
                    po.setUserName(ConverterUtil.toString(user.getId()));
                    // 密码为登录名
                    po.setPassword(user.getLoginName());
                    // 远程调用
                    ResultPoJo<Object> ofUserRes = remoteOfImMss.passwordUpdate(po);
                    checkRemoteResult(ofUserRes);
                }

                // 发送用户修改登录名事件(若没有配置wbfc.busevents则不会生效)
                UserUpdateEventInfo eventInfo = new UserUpdateEventInfo(user, "loginName");
                busEventsService.sendUserLoginNameUpdateEvent(eventInfo);
        	}
        	if(ConverterUtil.isNotEmpty(updUserMembInfoPo.getPassword())){
        		// 将md5的密码再做一次sha-1的转换
                user.setPassword(PasswordUtil.entryptPassword(updUserMembInfoPo.getPassword()));
                user.preUpdate();
                // 登录中心是否启动
                if (loginCenterProperties.isEnabled()) {
                	ResetPasswordUserPo resetPasswordUserPo = new ResetPasswordUserPo();
                	resetPasswordUserPo.setId(user.getId());
                	resetPasswordUserPo.setNewPassword(updUserMembInfoPo.getPassword());
                    remoteLoginCenterService.updatePassword(resetPasswordUserPo, user.getOpenId(), user.getPassword());
                }
                // 更新User表的数据
                userDao.updatePassword(user);
                // 清除缓存
                UserUtils.clearUserLoginCache(UserUtils.getById(user.getId()));
                // 发送修改密码事件(若没有配置wbfc.busevents则不会生效)
                UserUpdateEventInfo eventInfo = new UserUpdateEventInfo(user, "password");
                busEventsService.sendUserPasswordUpdateEvent(eventInfo);
        	}
		}
		return result;
	}
	/**
	 * 添加员工的处理(销售员工和采购员工)
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年8月13日
	 * @version 1.0
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<MembInfo> addUserMembStaff(MembStaffInfoAddPo po){
		// 返回值初期化处理
		ResultPoJo<MembInfo> result = new ResultPoJo<MembInfo>();
		// 查询会员信息
		MembInfo oldInfo  = membInfoMapper.selectByPrimaryKey(po.getId());
        MembInfo membInfo = new MembInfo();
        // 用户不存在  需要注册新的账号的处理
        if (oldInfo == null || ConverterUtil.isEmpty(oldInfo.getId())) {
        	//  会员表中信息的处理   -------开始
            membInfo.preInsert();
            if(ConverterUtil.isNotEmpty(po.getId())){
            	membInfo.setId(po.getId());
            }
    	    String loginName = MembUtils.getRandomUserName();// 用户名
            membInfo.setLoginName(loginName);// 用户名
            membInfo.setPetName(loginName);// 昵称初期化显示登录用户名   20200814 产品确认
            membInfo.setRegistTel(po.getMobile());// 注册手机号
            membInfo.setContName(po.getContName());// 名称
            membInfo.setSexType(po.getSexType());// 性别
            membInfo.setPosition(po.getPosition());// 职称
            membInfo.setAcctState(DictConstants.ACCT_STATE_0);// 帐号状态    默认正常 0:正常
            membInfo.setRegistDate(OffsetDateTime.now());// 注册时间
            membInfo.setAgentFlag(DictConstants.AGENT_FLAG_1);// 是否是商家 默认不是商家为1否
            membInfo.setMembType(DictConstants.MEMB_TYPE_2);// 会员类型是个人
            membInfo.setLoginNameSetFlag(DictConstants.LOGIN_NAME_SET_FLAG_1);// 未设置过用户名
            membInfo.setPasswordSetFlag(DictConstants.PASSWORD_SET_FLAG_1);// 未设置过密码
            membInfo.setEntpAuthStateType(DictConstants.ENTP_AUTH_STATE_TYPE_1);// 认证状态是未认证
            membInfo.setApFlag(DictConstants.AP_FLAG_1);//账期开通标记 未开通
            membInfoMapper.insertSelective(membInfo);
            //  会员表中信息的处理   -------结束
            //  用户表中添加的处理 --- 开始
            String pwd = IdGen.randomBase62(32);
            RegisterUserPo registerUser = new RegisterUserPo();
            registerUser.setId(membInfo.getId());
            registerUser.setLoginName(membInfo.getLoginName());
            registerUser.setMobile(membInfo.getRegistTel());
            registerUser.setPassword(pwd);
            registerUser.setUserType(Constants.USER_TYPE_USER);//"0:管理员 1:用户帐户 2:用户子账户"
            List<String> roleList = new ArrayList<String>();
    		roleList.add("ROLE_person");
    		registerUser.setRoleCodes(roleList);// 个人的情况
            //registerUser.setParentId(po.getParentId());//父节点ID
    		userLcnAbsService.register(registerUser, null);
        // 用户已经存在修改用户信息
        }else{
        	if(!oldInfo.getRegistTel().equals(po.getMobile())){
        		result.setCode(ConstantError.ERR_001);
            	result.setMsg(ConstantError.MSG_001);
            	return result;
        	}
        	membInfo.setId(po.getId());
    		membInfo.preUpdate();
    		if(ConverterUtil.isEmpty(oldInfo.getContName())){// 如果会员中的姓名是空的时候将员工的姓名同步到会员姓名中  20200814 产品确认
    			membInfo.setContName(po.getContName());
    			membInfoMapper.updateByPrimaryKeySelective(membInfo);
    		}
        }
		// 销售员工  需要处理菜单和客服操作
		if("0".equals(po.getStaffType())){
			// 菜单的处理
			if(ConverterUtil.isNotEmpty(po.getMenuIds())){
				UserAuthUpdatePo userAuthUpdate = new UserAuthUpdatePo();
				userAuthUpdate.setId(ConverterUtil.toString(membInfo.getId()));
				userAuthUpdate.setMenuIds(po.getMenuIds());
				ResultPoJo<Object> menuResult = menuService.userAuthUpdate(userAuthUpdate);
				if(!ConstantError.NOMAL.equals(menuResult.getCode())){
			        BusinessException error = new BusinessException(menuResult.getCode(), menuResult.getMsg());
		            throw error;
				}
			}
			//  添加客服(只有销售端需要客服处理) ------ 开始
			SysImCustomerListInsertPo siccipo = new SysImCustomerListInsertPo();
	        siccipo.setGroupId(po.getGroupId());// 分组ID
	        CustomerConfigUserInsertPo customerConfigUser = new CustomerConfigUserInsertPo();
	        customerConfigUser.setUserId(membInfo.getId());
	        if (po.getSfAdminFlag().equals(DictConstants.SF_ADMIN_FLAG_0)) {
	        	customerConfigUser.setAdmin("1");
	        }else{
	        	customerConfigUser.setAdmin("0");
	        }
	        siccipo.getUserList().add(customerConfigUser);
	        ResultPoJo<Object> customResult = sysImCustomerConfigService.customerListInsert(siccipo);
	        if (!customResult.getCode().equals(ConstantError.NOMAL)) {
	        	BusinessException error = new BusinessException(customResult.getCode(), customResult.getMsg());
	            throw error;
	        }
		}
        result.setResult(membInfo);
		return result;
	}
	/**
	 * 修改员工的处理(销售员工和采购员工)
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年8月14日
	 * @version 1.0
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<Object> updUserMembStaff(MembStaffInfoUpdPo po){
		// 返回值初期化处理
		ResultPoJo<Object> result = new ResultPoJo<Object>();
		// 旧数据查询处理
		User user = UserUtils.getById(po.getId());
		MembInfo oldInfo  = membInfoMapper.selectByPrimaryKey(po.getId());
		if(user == null || oldInfo == null){
			result.setCode(ConstantError.ERR_907);
        	result.setMsg(ConstantError.MSG_907);
        	return result;
		}
		// 修改了注册手机号的情况 判断手机号是否已经存在
		if(!oldInfo.getRegistTel().equals(po.getMobile())){
			// 手机号已经存在的情况
            MembCheckMobilePo membCheckMobilePo = new MembCheckMobilePo();
            membCheckMobilePo.setMembId(po.getId());
            membCheckMobilePo.setMobile(po.getMobile());
            int mobileCount = membInfoMapper.checkMobileExist(membCheckMobilePo);
            if (mobileCount > 0) {
            	result.setCode(ConstantCodeMsg.ERR_501);
            	result.setMsg(ConstantCodeMsg.MSG_501);
                return result;
            }
            // 修改会员表中的内容
    		MembInfo membInfo = new MembInfo();
    		membInfo.setId(po.getId());
    		membInfo.preUpdate();
    		membInfo.setRegistTel(po.getMobile());// 注册手机号
    		membInfoMapper.updateByPrimaryKeySelective(membInfo);
    		// 用户信息的修改
    		// 注册手机号的修改
    		UpdateMobileUserPo updateMobileUser = new UpdateMobileUserPo();
    		updateMobileUser.setId(po.getId());
    		updateMobileUser.setMobile(po.getMobile());
    		ResultPoJo<Object> mobileResult = userService.mobileUpdate(updateMobileUser);
    		if(!ConstantError.NOMAL.equals(mobileResult.getCode())){
				BusinessException error = new BusinessException(mobileResult.getCode(), mobileResult.getMsg());
	            throw error;
			}
		}
		// 如果是销售员工 菜单和客服相关功能的操作
		if("0".equals(po.getStaffType())){
			// 菜单的处理
			if(ConverterUtil.isNotEmpty(po.getMenuIds())){
				UserAuthUpdatePo userAuthUpdate = new UserAuthUpdatePo();
				userAuthUpdate.setId(ConverterUtil.toString(po.getId()));
				userAuthUpdate.setMenuIds(po.getMenuIds());
				ResultPoJo<Object> menuResult = menuService.userAuthUpdate(userAuthUpdate);
				if(!ConstantError.NOMAL.equals(menuResult.getCode())){
					BusinessException error = new BusinessException(menuResult.getCode(), menuResult.getMsg());
		            throw error;
				}
			}else{
				// 修改的时候如果没有菜单则清空
				clearMenu(user);
			}
			// 修改会员客服信息的处理
	    	if(ConverterUtil.isNotEmpty(po.getGroupId(),po.getSfAdminFlag())){
	    		//修改客服
	            SysImCustomerListUpdatePo siccipo = new SysImCustomerListUpdatePo();
	            siccipo.setGroupId(po.getGroupId());
	            CustomerConfigUserInsertPo customerConfigUser = new CustomerConfigUserInsertPo();
	            customerConfigUser.setUserId(po.getId());
	            if (po.getSfAdminFlag().equals(DictConstants.SF_ADMIN_FLAG_0)) {
	            	customerConfigUser.setAdmin("1");
	            }else{
	            	customerConfigUser.setAdmin("0");
	            }
	            siccipo.getUserList().add(customerConfigUser);
	            ResultPoJo<Object> customResult = sysImCustomerConfigService.customerListUpdate(siccipo);
		        if (!customResult.getCode().equals(ConstantError.NOMAL)) {
		        	BusinessException error = new BusinessException(customResult.getCode(), customResult.getMsg());
		            throw error;
		        }
	    	}
		}
    	//清楚缓存
        MembUtils.delMembUser(po.getId());
		return result;
	}
	/**
	 * 注册用户会员信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月12日
	 * @version 1.0
	 */
	//@TxTransaction(type = Transactions.LCN, propagation = DTXPropagation.REQUIRED)
	@Transactional(readOnly = false)
	public ResultPoJo<User> addUserMemb(RegisterUserMembPo po){
		// 返回值初期化处理
		ResultPoJo<User> result = new ResultPoJo<User>();
		if(po != null){
			RegisterUserPo registerUser = new RegisterUserPo();
			ConverterUtil.copyProperties(po, registerUser);
			User user = userLcnAbsService.register(registerUser, null);
			// 登录标识处理 默认是可以登录如果不可以登录需要设置成NO
			if(po.getLoginFlag() != null && Constants.NO.equals(po.getLoginFlag())){
				LoginBatUpdatePo loginBatUpdatePo = new LoginBatUpdatePo();
        		loginBatUpdatePo.setIds(ConverterUtil.toString(user.getId()));
        		loginBatUpdatePo.setLoginFlag(po.getLoginFlag());
        		ResultPoJo<Object> flagResult = userService.loginBatUpdate(loginBatUpdatePo);
        		if(!ConstantError.NOMAL.equals(flagResult.getCode())){
        			BusinessException error = new BusinessException(flagResult.getCode(), flagResult.getMsg());
		            throw error;
				}
			}
			// 菜单的处理
			if(ConverterUtil.isNotEmpty(po.getMenuIds())){
				UserAuthUpdatePo userAuthUpdate = new UserAuthUpdatePo();
				userAuthUpdate.setId(ConverterUtil.toString(user.getId()));
				userAuthUpdate.setMenuIds(po.getMenuIds());
				ResultPoJo<Object> menuResult = menuService.userAuthUpdate(userAuthUpdate);
				if(!ConstantError.NOMAL.equals(menuResult.getCode())){
					BusinessException error = new BusinessException(menuResult.getCode(), menuResult.getMsg());
		            throw error;
				}
			}
			result.setResult(user);
		}else{
			result.setCode(ConstantError.ERR_001);
        	result.setMsg(ConstantError.MSG_001);
		}
		return result;
	}

	/**
	 * 通过用户ID和角色Code添加用户角色权限
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月8日
	 * @version 1.0
	 */
	//@TxTransaction(type = Transactions.LCN, propagation = DTXPropagation.REQUIRED)
	@Transactional(readOnly = false)
	public ResultPoJo<String> addRoleById(AddRoleByUserIdPo value){
        ResultPoJo<String> result = new ResultPoJo<String>();
        // 解析参数
        if(value != null && ConverterUtil.isNotEmpty(value.getUserId(),value.getRoleCodeList())){
        	User user = SystemUtils.getById(value.getUserId());
        	if(user == null){
        		result.setCode(ConstantError.ERR_907);
            	result.setMsg(ConstantError.MSG_907);
            	return result;
        	}
        	for(String code : value.getRoleCodeList()){
        		Role role = roleDao.findByCode(roleService.makeRoleStr(code));
                if (role == null) {
                    throw new VerifyException(ConstantError.ERR_005, "role code = " + code + " are not exists");
                }
                UserRole userRole = new UserRole();
                userRole.setRoleId(role.getId());
                userRole.setUserId(value.getUserId());
                userRoleDao.insert(userRole);
                // 清空该User缓存
                UserUtils.clearCache(user);
                // 注销清除oauth信息 避免权限修改后jwt不变
                clearOauthInfo(user.getLoginName());
        	}
        }else{
        	result.setCode(ConstantError.ERR_001);
        	result.setMsg(ConstantError.MSG_001);
        }
        return result;
    }
	/**
	 * 修改用户会员基础信息操作
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月11日
	 * @version 1.0
	 */
	//@TxTransaction(type = Transactions.LCN, propagation = DTXPropagation.REQUIRED)
	@Transactional(readOnly = false)
	public ResultPoJo<String> updUserMembInfo(UpdUserMembInfoPo value){
		// 返回值初期化处理
		ResultPoJo<String> result = new ResultPoJo<String>();
		// 验证参数
		if(value != null && ConverterUtil.isNotEmpty(value.getId())){
			User user = UserUtils.getById(value.getId());
        	if(user == null){
        		result.setCode(ConstantError.ERR_907);
            	result.setMsg(ConstantError.MSG_907);
            	return result;
        	}
			// 用户名处理
        	if(ConverterUtil.isNotEmpty(value.getLoginName())){
        		UpdateLoginNamePo updateLoginNamePo = new UpdateLoginNamePo();
        		updateLoginNamePo.setId(value.getId());
        		updateLoginNamePo.setLoginName(value.getLoginName());
        		ResultPoJo<Object> loginNameResult = userService.updateLoginName(updateLoginNamePo);
        		if(!ConstantError.NOMAL.equals(loginNameResult.getCode())){
        			BusinessException error = new BusinessException(loginNameResult.getCode(), loginNameResult.getMsg());
		            throw error;
				}
        	}
        	// 注册手机号的修改
        	if(ConverterUtil.isNotEmpty(value.getMobile())){
        		UpdateMobileUserPo updateMobileUser = new UpdateMobileUserPo();
        		updateMobileUser.setId(value.getId());
        		updateMobileUser.setMobile(value.getMobile());
        		ResultPoJo<Object> mobileResult = userService.mobileUpdate(updateMobileUser);
        		if(!ConstantError.NOMAL.equals(mobileResult.getCode())){
        			BusinessException error = new BusinessException(mobileResult.getCode(), mobileResult.getMsg());
		            throw error;
				}
        	}
        	// 登录标识的处理
        	if(ConverterUtil.isNotEmpty(value.getLoginFlag())){
        		LoginBatUpdatePo loginBatUpdatePo = new LoginBatUpdatePo();
        		loginBatUpdatePo.setIds(ConverterUtil.toString(value.getId()));
        		loginBatUpdatePo.setLoginFlag(value.getLoginFlag());
        		ResultPoJo<Object> loginBathReult = userService.loginBatUpdate(loginBatUpdatePo);
        		if(!ConstantError.NOMAL.equals(loginBathReult.getCode())){
        			BusinessException error = new BusinessException(loginBathReult.getCode(), loginBathReult.getMsg());
		            throw error;
				}
        	}
        	// 登录密码的处理
        	if(ConverterUtil.isNotEmpty(value.getPassword())){
        		ResetPasswordUserPo resetPasswordUserPo = new ResetPasswordUserPo();
        		resetPasswordUserPo.setId(value.getId());
        		resetPasswordUserPo.setNewPassword(value.getPassword());
        		ResultPoJo<Object> passResult = userService.resetPassword(resetPasswordUserPo);
        		if(!ConstantError.NOMAL.equals(passResult.getCode())){
        			BusinessException error = new BusinessException(passResult.getCode(), passResult.getMsg());
		            throw error;
				}
        	}
        	// 如果标识为1标识物理删除用户
        	if(ConverterUtil.isNotEmpty(value.getPhysicalDelFLag()) && Constants.YES.equals(value.getPhysicalDelFLag())){
        		List<User> delList = userService.getBatDeleteUser(ConverterUtil.toString(value.getId()));
        		ResultPoJo<Object> deluserResult = userService.batDelete(delList);
        		if(!ConstantError.NOMAL.equals(deluserResult.getCode())){
        			BusinessException error = new BusinessException(deluserResult.getCode(), deluserResult.getMsg());
		            throw error;
				}
        	}
        	// 菜单的处理
			if(ConverterUtil.isNotEmpty(value.getMenuIds())){
				UserAuthUpdatePo userAuthUpdate = new UserAuthUpdatePo();
				userAuthUpdate.setId(ConverterUtil.toString(value.getId()));
				userAuthUpdate.setMenuIds(value.getMenuIds());
				ResultPoJo<Object> menuResult = menuService.userAuthUpdate(userAuthUpdate);
				if(!ConstantError.NOMAL.equals(menuResult.getCode())){
					BusinessException error = new BusinessException(menuResult.getCode(), menuResult.getMsg());
		            throw error;
				}
			}
			// 清空菜单的处理
			if(value.isClearMenuFlag()){
				clearMenu(user);
			}
        	// 清除缓存
            UserUtils.clearUserLoginCache(user);
		}else{
			result.setCode(ConstantError.ERR_001);
        	result.setMsg(ConstantError.MSG_001);
		}
		return result;
	}
	/**
	 * 清空菜单的处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年8月14日
	 * @version 1.0
	 */
	public void clearMenu(User user){
		// 非(当前操作用户是被操作用户的父账户 或 当前操作用户是管理员)
        if (!UserUtils.isParentOrHasAuthor(user, "ROLE_admin", "user:menu")) {
            // 没有修改的权限 抛出权限异常
            throw ConstantError.VER_901;
        }
        // 将原有的角色菜单关系全部删除，再新建新的关系数据
        // 查询自定义的所有角色
        Role diyRole = userRoleDao.findDiyRoleByUserId(user.getId());
        if(diyRole != null && ConverterUtil.isNotEmpty(diyRole.getId())){
        	 // 删除角色菜单关系表
            roleMenuDao.deleteRoleMenu(diyRole.getId());
        }
        // 清空该User缓存
        UserUtils.clearCache(user);
        // 注销清除oauth信息 避免权限修改后jwt不变
        userService.clearOauthInfo(user.getLoginName());
	}
	/**
	 * 批量修改会员登录标识
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月12日
	 * @version 1.0
	 */
	//@TxTransaction(type = Transactions.LCN, propagation = DTXPropagation.REQUIRED)
	@Transactional(readOnly = false)
	public ResultPoJo<Object> membLoginBatUpdate(LoginBatUpdatePo po){
		return userService.loginBatUpdate(po);
	}
}
