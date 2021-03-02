package com.wisea.transac.common.vo.memb;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 市场管理员列表信息VO
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月7日
 * @version 1.0
 */
@ApiModel("市场管理员列表信息VO")
public class MarketAdminInfoVo {

	@ApiModelProperty(value = "市场管理员ID")
	private Long id;
	@ApiModelProperty(value = "市场名称")
	private String wholeSaleMarketName;
	@ApiModelProperty(value = "市场所在区域-省")
	private String areaProv;
	@ApiModelProperty(value = "市场所在区域-市")
	private String areaCity;
	@ApiModelProperty(value = "市场所在区域-县")
	private String areaCou;
    @ApiModelProperty(value = "中文市场所在区域(省市县)")
    private String areaZhCn;
	@ApiModelProperty(value = "市场详细地址")
	private String address;
	@ApiModelProperty(value = "登录名")
	private String loginName;
	@ApiModelProperty(value = "姓名")
	private String name;
	@ApiModelProperty(value = "电话")
	private String tel;
	@ApiModelProperty(value = "密码")
	private String password;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getWholeSaleMarketName() {
		return wholeSaleMarketName;
	}
	public void setWholeSaleMarketName(String wholeSaleMarketName) {
		this.wholeSaleMarketName = wholeSaleMarketName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAreaProv() {
		return areaProv;
	}
	public void setAreaProv(String areaProv) {
		this.areaProv = areaProv;
	}
	public String getAreaCity() {
		return areaCity;
	}
	public void setAreaCity(String areaCity) {
		this.areaCity = areaCity;
	}
	public String getAreaCou() {
		return areaCou;
	}
	public void setAreaCou(String areaCou) {
		this.areaCou = areaCou;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAreaZhCn() {
		return areaZhCn;
	}
	public void setAreaZhCn(String areaZhCn) {
		this.areaZhCn = areaZhCn;
	}
}
