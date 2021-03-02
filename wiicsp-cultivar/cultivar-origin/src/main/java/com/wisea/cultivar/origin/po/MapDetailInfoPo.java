package com.wisea.cultivar.origin.po;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 查询地区详细信息PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年10月11日
 * @version 1.0
 */
@ApiModel("查询地区详细信息PO")
public class MapDetailInfoPo {


	@ApiModelProperty(value="纬度")
	@Check(test = { "required" })
	private String lat;
	@ApiModelProperty(value="经度")
	@Check(test = { "required" })
	private String lng;
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
