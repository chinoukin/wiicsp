package com.wisea.cultivar.origin.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 地图详细信息Vo
 *
 * @author wangh(wisea)
 *
 * @date 2019年10月11日
 * @version 1.0
 */
@ApiModel("地图详细信息Vo")
public class MapDetailInfoVo {

	/**
	 * 地区编码
	 */
	@ApiModelProperty("地区编码")
	private String areaCode;
	@ApiModelProperty("省")
	private String province;
	@ApiModelProperty("市")
	private String city;
	@ApiModelProperty("县")
	private String county;
	@ApiModelProperty("乡(镇)")
	private String town;
	@ApiModelProperty("村")
	private String village;
	@ApiModelProperty("详细地区")
	private String detial;

	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getDetial() {
		return detial;
	}
	public void setDetial(String detial) {
		this.detial = detial;
	}

}

