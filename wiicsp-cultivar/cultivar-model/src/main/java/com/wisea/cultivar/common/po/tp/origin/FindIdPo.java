package com.wisea.cultivar.common.po.tp.origin;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 查询详情po
 * @author wzx
 *
 */
@ApiModel("查询详情--按ID")
public class FindIdPo {
	@ApiModelProperty(value = "id")
	@Check(test = "required")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
