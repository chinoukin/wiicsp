package com.wisea.transac.common.po.memb;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 新增市场权限信息PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年4月29日
 * @version 1.0
 */
@ApiModel("新增市场权限信息PO")
public class MarketRoleInfoPo {

	@ApiModelProperty(value="市场ID(或者是洪九果品运营主体ID)为空表示运营主体")
	@JsonSerialize(using = IdSerializer.class)
	private Long marketId;

	@ApiModelProperty(value="角色名称")
    @Check(test = "required")
	private String roleName;

	@ApiModelProperty(value="角色介绍")
	private String roleRemarks;

	@ApiModelProperty(value = "菜单ID字符串数组非空", required = true)
    @Check(test = "required")
    private List<String> menuIds;

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

	public Long getMarketId() {
		return marketId;
	}

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}

}
