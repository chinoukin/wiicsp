package com.wisea.transac.common.po.memb;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 角色名称的验证PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年4月30日
 * @version 1.0
 */
@ApiModel("角色名称的验证PO")
public class RoleNameCheckPo {

	@ApiModelProperty(value="角色ID(更新的时候使用)", hidden = true)
	@JsonSerialize(using = IdSerializer.class)
	private Long id;

	@ApiModelProperty(value="角色名称")
	@Check(test = "required")
	private String name;

	@ApiModelProperty(value="市场ID(或者是洪九果品运营主体ID)")
	private Long marketId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMarketId() {
		return marketId;
	}

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}
}
