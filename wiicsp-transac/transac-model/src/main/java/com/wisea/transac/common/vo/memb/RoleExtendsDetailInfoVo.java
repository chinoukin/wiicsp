package com.wisea.transac.common.vo.memb;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.Lists;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 查询市场或者运营帐号的角色信息信息VO
 *
 * @author wangh(wisea)
 *
 * @date 2020年4月30日
 * @version 1.0
 */
@ApiModel("查询市场或者运营帐号的角色信息信息VO")
public class RoleExtendsDetailInfoVo {

	@ApiModelProperty("ID")
	@JsonSerialize(using = IdSerializer.class)
	private Long id;

	@ApiModelProperty(value="市场ID(或者是洪九果品运营主体ID)")
	@JsonSerialize(using = IdSerializer.class)
	private Long relId;

	@ApiModelProperty(value="角色名称")
	private String roleName;

	@ApiModelProperty(value="角色介绍")
	private String roleRemarks;

	@ApiModelProperty(value="角色下的菜单列表")
	private List<String> menuIds = Lists.newArrayList();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleRemarks() {
		return roleRemarks;
	}

	public void setRoleRemarks(String roleRemarks) {
		this.roleRemarks = roleRemarks;
	}

	public List<String> getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(List<String> menuIds) {
		this.menuIds = menuIds;
	}

	public Long getRelId() {
		return relId;
	}

	public void setRelId(Long relId) {
		this.relId = relId;
	}
}
