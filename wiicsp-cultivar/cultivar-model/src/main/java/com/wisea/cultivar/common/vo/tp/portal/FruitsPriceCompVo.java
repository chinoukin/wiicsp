package com.wisea.cultivar.common.vo.tp.portal;

import io.swagger.annotations.ApiModelProperty;

public class FruitsPriceCompVo {

	@ApiModelProperty(value = "对比升降标识(0:相同1:上升2:下降)")
    private String compUdType;

    @ApiModelProperty(value = "比较的数值")
    private Double compValue;

	public String getCompUdType() {
		return compUdType;
	}

	public void setCompUdType(String compUdType) {
		this.compUdType = compUdType;
	}

	public Double getCompValue() {
		return compValue;
	}

	public void setCompValue(Double compValue) {
		this.compValue = compValue;
	}
}
