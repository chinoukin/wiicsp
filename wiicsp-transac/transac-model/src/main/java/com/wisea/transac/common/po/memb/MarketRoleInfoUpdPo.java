package com.wisea.transac.common.po.memb;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 修改市场权限信息PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年4月30日
 * @version 1.0
 */
@ApiModel("修改市场权限信息PO")
public class MarketRoleInfoUpdPo extends MarketRoleInfoPo{

	@ApiModelProperty(value="id(修改的时候必须填写,新增为空)")
	@JsonSerialize(using = IdSerializer.class)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
