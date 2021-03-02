package com.wisea.cultivar.plant.vo.oritrapla;

import io.swagger.annotations.ApiModelProperty;

/**
 * 獲取會員经纬度信息
 *
 * @author wangh
 *
 */
public class MembLatLngInfoVo {

	@ApiModelProperty(value="经度")
	private String lat;

	@ApiModelProperty(value="纬度")
	private String lng;

	@ApiModelProperty(value="农产名称")
	private String orgName;

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
}
