package com.wisea.cultivar.common.vo.bigdata;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class PsCarJcReport {
	@ApiModelProperty(value = "公司坐标")
	private CoordinateVo enptZb;
	@ApiModelProperty(value = "车辆坐标")
	private List<CoordinateVo> carZb;

	public CoordinateVo getEnptZb() {
		return enptZb;
	}

	public void setEnptZb(CoordinateVo enptZb) {
		this.enptZb = enptZb;
	}

	public List<CoordinateVo> getCarZb() {
		return carZb;
	}

	public void setCarZb(List<CoordinateVo> carZb) {
		this.carZb = carZb;
	}

}
