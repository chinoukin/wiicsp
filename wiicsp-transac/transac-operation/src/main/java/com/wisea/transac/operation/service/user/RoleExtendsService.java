package com.wisea.transac.operation.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.constants.Constants;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.Role;
import com.wisea.cloud.common.sys.entity.RoleMenu;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.IdGen;
import com.wisea.cloud.common.util.TreeUtils;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cloud.security.dao.MenuDao;
import com.wisea.cloud.security.dao.RoleDao;
import com.wisea.cloud.security.dao.RoleMenuDao;
import com.wisea.cloud.security.vo.PermissionOptionVo;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.dao.RoleExtendsMapper;
import com.wisea.transac.common.po.memb.MarketRoleInfoPo;
import com.wisea.transac.common.po.memb.MarketRoleInfoUpdPo;
import com.wisea.transac.common.po.memb.MarketOrPlatIdPo;
import com.wisea.transac.common.po.memb.RoleExtendsPagePo;
import com.wisea.transac.common.po.memb.RoleNameCheckPo;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.vo.memb.RoleExtendsDetailInfoVo;
import com.wisea.transac.common.vo.memb.RoleExtendsListVo;

/**
 * 角色扩展信息操作接口Service
 *
 * @author wangh(wisea)
 *
 * @date 2020年4月29日
 * @version 1.0
 */
@Service
public class RoleExtendsService extends BaseService{

	@Autowired
	private RoleExtendsMapper roleExtendsMapper;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private RoleMenuDao roleMenuDao;
	@Autowired
	private MenuDao menuDao;

	/**
	 * 查询某个市场或者运营平台的全部角色列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年4月30日
	 * @version 1.0
	 */
	public ResultPoJo<List<RoleExtendsListVo>> findAllRoleList(MarketOrPlatIdPo po){
		// 返回值初期话处理
		ResultPoJo<List<RoleExtendsListVo>> result = new ResultPoJo<List<RoleExtendsListVo>>(ConstantError.NOMAL);
		// 设置总运营平台的超级管理员ID
		if(ConverterUtil.isEmpty(po.getMarketId())){
			po.setMarketId(MembUtils.getPlatOrMarketAdminId(null));
		}
		result.setResult(roleExtendsMapper.findAllRoleList(po.getMarketId()));
		return result;
	}
	/**
	 * 分页查询市场或者运营主体角色
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年4月30日
	 * @version 1.0
	 */
	public ResultPoJo<Page<RoleExtendsListVo>> findRolePage(RoleExtendsPagePo po){
		// 返回值初期话处理
		ResultPoJo<Page<RoleExtendsListVo>> result = new ResultPoJo<Page<RoleExtendsListVo>>(ConstantError.NOMAL);
		// 设置总运营平台的超级管理员ID
		if(ConverterUtil.isEmpty(po.getMarketId())){
			po.setMarketId(MembUtils.getPlatOrMarketAdminId(null));
		}
		// 分页查询的处理
        Page<RoleExtendsListVo> page = po.getPage();
        List<RoleExtendsListVo> list = roleExtendsMapper.findRolePage(po);
        page.setList(list);
        result.setResult(page);
		return result;
	}
	/**
	 * 验证角色名称是否存在
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年4月30日
	 * @version 1.0
	 */
	public ResultPoJo<String> checkRoleName(RoleNameCheckPo po){
		// 返回值初期话处理
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		// 设置总运营平台的超级管理员ID
		if(ConverterUtil.isEmpty(po.getMarketId())){
			po.setMarketId(MembUtils.getPlatOrMarketAdminId(null));
		}
		// 查询操作(大于0表示已经存在)
		int count = roleExtendsMapper.checkRoleName(po);
		if(count > 0){
			result.setCode(ConstantCodeMsg.ERR_914);
			result.setMsg(ConstantCodeMsg.MSG_914);
			return result;
		}
		return result;
	}
	/**
	 * 新增市场或者运营主体角色信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年4月29日
	 * @version 1.0
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<String> addRoleInfo(MarketRoleInfoPo po){
		// 返回值初期话处理
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		// 设置总运营平台的超级管理员ID
		if(ConverterUtil.isEmpty(po.getMarketId())){
			po.setMarketId(MembUtils.getPlatOrMarketAdminId(null));
		}
		// 验证名称是否重复
		RoleNameCheckPo roleNameCheckPo = new RoleNameCheckPo();
		roleNameCheckPo.setMarketId(po.getMarketId());
		roleNameCheckPo.setName(po.getRoleName());
		// 查询操作(大于0表示已经存在)
		int count = roleExtendsMapper.checkRoleName(roleNameCheckPo);
		if(count > 0){
			result.setCode(ConstantCodeMsg.ERR_914);
			result.setMsg(ConstantCodeMsg.MSG_914);
			return result;
		}
		// 新建角色表
		Role diyRole = new Role();
        diyRole.preInsert();
        diyRole.setId(ConverterUtil.toString(IdGen.randomLong()));
        diyRole.setRtype(Constants.ROLE_RTYPE_DIY);
        diyRole.setCreateBy(ConverterUtil.toString(po.getMarketId()));
        diyRole.setName(po.getRoleName());
        diyRole.setRemarks(po.getRoleRemarks());
        diyRole.setCode("ROLE_" + ConverterUtil.toString(po.getMarketId()) + "_" + po.getRoleName());
        roleDao.insert(diyRole);
        // 写入新的角色菜单关系
        for (String menuId : po.getMenuIds()) {
            RoleMenu rm = new RoleMenu();
            rm.setRoleId(diyRole.getId());
            rm.setMenuId(menuId);
            roleMenuDao.insert(rm);
        }
		return result;
	}
	/**
	 *  修改或者运营主体角色信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年4月30日
	 * @version 1.0
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<String> updRoleInfo(MarketRoleInfoUpdPo po){
		// 返回值初期话处理
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		// 设置总运营平台的超级管理员ID
		if(ConverterUtil.isEmpty(po.getMarketId())){
			po.setMarketId(MembUtils.getPlatOrMarketAdminId(null));
		}
		// 验证名称是否重复
		RoleNameCheckPo roleNameCheckPo = new RoleNameCheckPo();
		roleNameCheckPo.setId(po.getId());
		roleNameCheckPo.setMarketId(po.getMarketId());
		roleNameCheckPo.setName(po.getRoleName());
		// 查询操作(大于0表示已经存在)
		int count = roleExtendsMapper.checkRoleName(roleNameCheckPo);
		if(count > 0){
			result.setCode(ConstantCodeMsg.ERR_914);
			result.setMsg(ConstantCodeMsg.MSG_914);
			return result;
		}
		// 修改角色信息
		Role diyRole = new Role();
		diyRole.setId(ConverterUtil.toString(po.getId()));
		diyRole.preUpdate();
		diyRole.setName(po.getRoleName());
	    diyRole.setRemarks(po.getRoleRemarks());
	    diyRole.setCode("ROLE_" + ConverterUtil.toString(po.getMarketId()) + "_" + po.getRoleName());
		roleDao.update(diyRole);
		// 删除角色菜单关系表
        roleMenuDao.deleteRoleMenu(ConverterUtil.toString(po.getId()));
        // 写入新的角色菜单关系
        for (String menuId : po.getMenuIds()) {
            RoleMenu rm = new RoleMenu();
            rm.setRoleId(ConverterUtil.toString(po.getId()));
            rm.setMenuId(menuId);
            roleMenuDao.insert(rm);
        }
		return result;
	}
	/**
	 * 删除市场或者运营主体的角色信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年4月30日
	 * @version 1.0
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<String> delRoleInfo(LongIdPo po){
		// 返回值初期话处理
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		// 删除前的验证--是否有用户使用
		List<String> userList = roleExtendsMapper.findByRoleId(po.getId());
		if(userList != null && userList.size() > 0){
			result.setCode(ConstantCodeMsg.ERR_915);
			result.setMsg(ConstantCodeMsg.MSG_915);
			return result;
		}
		// 删除角色菜单关系表
		roleMenuDao.deleteRoleMenu(ConverterUtil.toString(po.getId()));
		// 删除角色信息
		Role role = new Role();
		role.setId(ConverterUtil.toString(po.getId()));
		roleDao.delete(role);
		return result;
	}
	/**
	 * 根据角色ID查询市场或者运营商的角色详细信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年4月30日
	 * @version 1.0
	 */
	public ResultPoJo<RoleExtendsDetailInfoVo> getRoleInfoDetail(LongIdPo po){
		// 返回值初期话处理
		ResultPoJo<RoleExtendsDetailInfoVo> result = new ResultPoJo<RoleExtendsDetailInfoVo>(ConstantError.NOMAL);
		RoleExtendsDetailInfoVo vo = new RoleExtendsDetailInfoVo();
		// 查询角色信息
		Role role = roleDao.get(ConverterUtil.toString(po.getId()));
		if(role != null){
			vo.setId(ConverterUtil.toLong(role.getId()));
			vo.setRelId(ConverterUtil.toLong(role.getCreateBy()));
			vo.setRoleName(role.getName());
			vo.setRoleRemarks(role.getRemarks());
			// 查询角色菜单列表
			vo.setMenuIds(roleMenuDao.findMenusByRoleId(role.getId()));
			result.setResult(vo);
		}
		return result;
	}
	/**
	 * 获取市场或者运营平台菜单列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月18日
	 * @version 1.0
	 */
	public ResultPoJo<List<PermissionOptionVo>> userMenuList(MarketOrPlatIdPo po) {
    	// 查询处理
		ResultPoJo<List<PermissionOptionVo>> result = new ResultPoJo<List<PermissionOptionVo>>();
		// 验证登录用户的信息
		User user = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(user)){
			result.setCode(ConstantCodeMsg.ERR_912);
			result.setMsg(ConstantCodeMsg.MSG_912);
			return result;
		}
		List<PermissionOptionVo> list = menuDao.findUserPermissionOption(MembUtils.getPlatOrMarketAdminId(po.getMarketId()));
        // 树状排序
        list = TreeUtils.listToTree(list);
        result.setResult(list);
		return result;
    }

}
