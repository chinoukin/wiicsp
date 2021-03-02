package com.wisea.transac.operation.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cloud.security.vo.PermissionOptionVo;
import com.wisea.transac.common.po.memb.MarketRoleInfoUpdPo;
import com.wisea.transac.common.po.memb.MarketOrPlatIdPo;
import com.wisea.transac.common.po.memb.RoleExtendsPagePo;
import com.wisea.transac.common.po.memb.RoleNameCheckPo;
import com.wisea.transac.common.vo.memb.RoleExtendsDetailInfoVo;
import com.wisea.transac.common.vo.memb.RoleExtendsListVo;
import com.wisea.transac.operation.service.user.RoleExtendsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 角色扩展信息操作Controller
 *
 * @author wangh(wisea)
 *
 * @date 2020年4月29日
 * @version 1.0
 */
@Api(tags = "角色扩展信息操作接口")
@RestController
@RequestMapping(value = "/w/admin/role")
public class RoleExtendsController {


	@Autowired
	private RoleExtendsService roleExtendsService;

	/**
	 * 查询某个市场或者运营平台的全部角色列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月18日
	 * @version 1.0
	 */
	@ApiOperation(value = "查询某个市场或者运营平台的全部角色列表",notes = "查询某个市场或者运营平台的全部角色列表")
	@PostMapping(value = "/findAllRoleList")
	@DataCheck
	public ResultPoJo<List<RoleExtendsListVo>> findAllRoleList(@RequestBody MarketOrPlatIdPo po){
		// 查询角色信息
		return roleExtendsService.findAllRoleList(po);
	}
	/**
	 * 分页查询市场或者运营主体角色列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年4月30日
	 * @version 1.0
	 */
	@ApiOperation(value = "分页查询市场或者运营主体角色列表",notes = "分页查询市场或者运营主体角色列表")
	@PostMapping(value = "/findRolePage")
	@DataCheck
	public ResultPoJo<Page<RoleExtendsListVo>> findRolePage(@RequestBody RoleExtendsPagePo po){
		// 分页查询角色信息
		return roleExtendsService.findRolePage(po);
	}
	/**
	 * 验证市场或者运营平台的角色是否重复
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年4月30日
	 * @version 1.0
	 */
	@ApiOperation(value = "验证市场或者运营平台的角色是否重复",notes = "验证市场或者运营平台的角色是否重复")
	@PostMapping(value = "/checkRoleName")
	@DataCheck
	public ResultPoJo<String> checkRoleName(@RequestBody RoleNameCheckPo po){
		// 验证并且返回的处理
		return roleExtendsService.checkRoleName(po);
	}
	/**
	 * 新增或者修改市场、运营主体角色信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年4月30日
	 * @version 1.0
	 */
	@ApiOperation(value = "新增或者修改市场、运营主体角色信息",notes = "新增或者修改市场、运营主体角色信息")
	@PostMapping(value = "/updRoleInfo")
	@DataCheck
	public ResultPoJo<String> updRoleInfo(@RequestBody MarketRoleInfoUpdPo po){
		if(ConverterUtil.isEmpty(po.getId())){
			// 插入操作
			return roleExtendsService.addRoleInfo(po);
		}else{
			// 修改操作
			return  roleExtendsService.updRoleInfo(po);
		}
	}
	/**
	 * 删除市场或者运营主体的角色信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年4月30日
	 * @version 1.0
	 */
	@ApiOperation(value = "删除市场或者运营主体的角色信息",notes = "删除市场或者运营主体的角色信息")
	@PostMapping(value = "/delRoleInfo")
	@DataCheck
	public ResultPoJo<String> delRoleInfo(@RequestBody LongIdPo po){
		// 删除角色信息
		return roleExtendsService.delRoleInfo(po);
	}
	/**
	 * 根据角色ID查询市场或者运营商的角色详细信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年4月30日
	 * @version 1.0
	 */
	@ApiOperation(value = "根据角色ID查询市场或者运营商的角色详细信息",notes = "根据角色ID查询市场或者运营商的角色详细信息")
	@PostMapping(value = "/getDetail")
	@DataCheck
	public ResultPoJo<RoleExtendsDetailInfoVo> getRoleInfoDetail(@RequestBody LongIdPo po){
		// 查询角色信息详情并且返回
		return roleExtendsService.getRoleInfoDetail(po);
	}
	/**
     * 获取市场或者运营平台菜单列表
     *
     * @param menuList
     * @return
     */
    @ApiOperation(value = "获取市场或者运营平台菜单列表")
    @PostMapping(value = "platOrMarket/menu/list")
    @DataCheck
    public ResultPoJo<List<PermissionOptionVo>> userMenuList(@RequestBody MarketOrPlatIdPo po) {
    	// 查询处理
        return roleExtendsService.userMenuList(po);
    }
}
