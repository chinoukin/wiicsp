package com.wisea.cultivar.common.po.tp.origin;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.tp.origin.OriBreedPenInfoPageVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("养殖栏信息po")
public class OriBreedPenInfoPagePo extends PagePo<OriBreedPenInfoPageVo>{

	@ApiModelProperty(value = "查询框输入内容")
	private String val;

	/**
	 * 会员id
	 */
	@JsonSerialize(using = IdSerializer.class)
	@ApiModelProperty(value = "会员id" ,hidden=true)
	private Long membId;

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public Long getMembId() {
		return membId;
	}

	public void setMembId(Long membId) {
		this.membId = membId;
	}

}
