package com.wisea.transac.common.vo.memb;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 市场或者运营主体的角色列表VO
 *
 * @author wangh(wisea)
 *
 * @date 2020年4月30日
 * @version 1.0
 */
@ApiModel("市场或者运营主体的角色列表VO")
public class RoleExtendsListVo {

	@ApiModelProperty("ID")
	private String id;

	@ApiModelProperty(value="市场ID(或者是洪九果品运营主体ID)")
	@JsonSerialize(using = IdSerializer.class)
	private Long marketId;

	@ApiModelProperty(value="角色名称")
	private String roleName;

	@ApiModelProperty(value="角色介绍")
	private String roleRemarks;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public Long getMarketId() {
		return marketId;
	}

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}
}
