package com.wisea.cultivar.common.po.tp.origin;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.tp.origin.OriBreedTungInfoPageVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * @author wzx
 *
 */
@ApiModel("养殖栋信息po")
public class OriBreedTungInfoPagePo extends PagePo<OriBreedTungInfoPageVo>{

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
