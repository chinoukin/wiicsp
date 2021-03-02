package com.wisea.cultivar.common.po.tp.origin;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 基地信息po
 *
 * @author wzx
 *
 */
@ApiModel("查询基地信息--按ID")
public class OriBreedBaseInfoFindPo {

	@ApiModelProperty(value = "id")
	@Check(test = "required")
	private Long id;

	/**
	 * 会员id
	 */
	@JsonSerialize(using = IdSerializer.class)
	@ApiModelProperty(value = "会员id" ,hidden=true)
	private Long membId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMembId() {
		return membId;
	}

	public void setMembId(Long membId) {
		this.membId = membId;
	}


}
