package com.wisea.cultivar.common.po.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

public class QueryTotalPo {

	@JsonSerialize(using = IdSerializer.class)
	@ApiModelProperty(value = "公司id")
	private Long subEntpId;

	public Long getSubEntpId() {
		return subEntpId;
	}

	public void setSubEntpId(Long subEntpId) {
		this.subEntpId = subEntpId;
	}

}
