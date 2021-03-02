package com.wisea.cultivar.common.vo.bigdata;

import io.swagger.annotations.ApiModelProperty;

public class CoordinateVo {

	/**
	 * 经度
	 */
	@ApiModelProperty(value = "经度")
	private Double lng;

	/**
	 * 纬度
	 */
	@ApiModelProperty(value = "纬度")
	private Double lat;

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

}
