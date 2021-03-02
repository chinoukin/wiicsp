package com.wisea.cultivar.origin.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 品鉴会列表
 *
 * @author wzx
 *
 */
@ApiModel("品鉴会列表VO")
public class JudgeMeetChoiceListVo {
	@ApiModelProperty("ID")
	@JsonSerialize(using = IdSerializer.class)
	private Long id;
	@ApiModelProperty(value="品鉴会名称")
	private String judgeMeetName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getJudgeMeetName() {
		return judgeMeetName;
	}
	public void setJudgeMeetName(String judgeMeetName) {
		this.judgeMeetName = judgeMeetName;
	}


}
