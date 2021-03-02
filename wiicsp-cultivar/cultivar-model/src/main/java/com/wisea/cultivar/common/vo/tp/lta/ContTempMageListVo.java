package com.wisea.cultivar.common.vo.tp.lta;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 合同管理列表VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月23日
 * @version 1.0
 */
@ApiModel("合同管理列表VO")
public class ContTempMageListVo {

	@ApiModelProperty(value="Id")
	@JsonSerialize(using = IdSerializer.class)
	private Long id;

	@ApiModelProperty(value="合同名称")
	private String tempName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTempName() {
		return tempName;
	}

	public void setTempName(String tempName) {
		this.tempName = tempName;
	}
}
