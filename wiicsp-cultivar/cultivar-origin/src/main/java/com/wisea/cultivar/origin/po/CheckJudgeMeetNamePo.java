package com.wisea.cultivar.origin.po;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 校验品鉴会名称PO
 * @author wzx
 *
 */
@ApiModel("校验品鉴会名称PO")
public class CheckJudgeMeetNamePo {
	@ApiModelProperty(value="id")
	private Long id;
	@ApiModelProperty(value="品鉴会名称")
	@Check(test = "required")
	private String judgeMeetName;//品鉴会名称

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

