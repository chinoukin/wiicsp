package com.wisea.cultivar.plant.po.oritrapla;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 设置农场的经纬度PO
 * @author wangh
 *
 */
@ApiModel("设置农场的经纬度PO")
public class MembLatLngSetPo {

	@ApiModelProperty(value="会员ID")
	@Check(test = "required")
	private long membId;
	@ApiModelProperty(value="纬度")
	@Check(test = "required")
	private String lat;
	@ApiModelProperty(value="经度")
	@Check(test = "required")
	private String lng;

	public long getMembId() {
		return membId;
	}
	public void setMembId(long membId) {
		this.membId = membId;
	}
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
}
