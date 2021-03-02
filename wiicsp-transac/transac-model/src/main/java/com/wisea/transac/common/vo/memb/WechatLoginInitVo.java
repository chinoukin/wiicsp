package com.wisea.transac.common.vo.memb;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * 小程序登录后回去的认证信息处理VO
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月29日
 * @version 1.0
 */
public class WechatLoginInitVo implements Serializable{

	private static final long serialVersionUID = -6360631470533185913L;

	@ApiModelProperty(value="ID")
	private Long id;

	@ApiModelProperty(value="会员ID(上一级的ID)")
	private Long membId;

	@ApiModelProperty(value="头像地址")
	private String logoUrl;

	@ApiModelProperty(value="姓名")
	private String contName;

	@ApiModelProperty("销售员员工姓名")
	private String saleName;

	@ApiModelProperty("采购员工姓名")
	private String purchaseName;
	// 如果企业已经认证（个体和个人无论是否认证）显示3，如果企业没有认证个体户已经认证显示2，如果企业和个体户都没有认证，个人认证显示1
	@ApiModelProperty(value="认证区分(0:企业认证1:个体户认证2:个人实名认证3:无认证)优先级顺序：企业>个体>个人")
	private String authType;

	@ApiModelProperty(value="认证名称(如果个人认证显示姓名,个体和企业显示企业名称)优先级顺序：企业>个体>个人")
	private String authName;

	@ApiModelProperty(value="选择的市场ID(如果是空表示用户未选择过市场)")
	private Long marketId;

	@ApiModelProperty(value="选择的市场名称(如果是空表示用户未选择过市场)")
	private String marketName;
	@ApiModelProperty(value="选择的市场坐标点(如果是空表示用户未选择过市场)")
	private String coordinatePoint;
	@ApiModelProperty(value="选择的市场所在区域省(如果是空表示用户未选择过市场)")
	private String marketProv;
	@ApiModelProperty(value="选择的市场所在区域市(如果是空表示用户未选择过市场)")
	private String marketCity;
	@ApiModelProperty(value="选择的市场所在区域县(如果是空表示用户未选择过市场)")
	private String marketCou;
	@ApiModelProperty(value = "所在区域省code")
	private String marketProvCode;
	@ApiModelProperty(value = "所在区域市code")
	private String marketCityCode;
	@ApiModelProperty(value = "所在区域区县code")
	private String marketCouCode;
	@ApiModelProperty(value="选择的市场所在区域详细地址(如果是空表示用户未选择过市场)")
	private String  marketAdress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMembId() {
		return membId;
	}

	public void setMembId(Long membId) {
		this.membId = membId;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public String getContName() {
		return contName;
	}

	public void setContName(String contName) {
		this.contName = contName;
	}

	public String getSaleName() {
		return saleName;
	}

	public void setSaleName(String saleName) {
		this.saleName = saleName;
	}

	public String getPurchaseName() {
		return purchaseName;
	}

	public void setPurchaseName(String purchaseName) {
		this.purchaseName = purchaseName;
	}

	public String getAuthType() {
		return authType;
	}

	public void setAuthType(String authType) {
		this.authType = authType;
	}

	public String getAuthName() {
		return authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

	public Long getMarketId() {
		return marketId;
	}

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}

	public String getMarketName() {
		return marketName;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public String getCoordinatePoint() {
		return coordinatePoint;
	}

	public void setCoordinatePoint(String coordinatePoint) {
		this.coordinatePoint = coordinatePoint;
	}

	public String getMarketProv() {
		return marketProv;
	}

	public void setMarketProv(String marketProv) {
		this.marketProv = marketProv;
	}

	public String getMarketCity() {
		return marketCity;
	}

	public void setMarketCity(String marketCity) {
		this.marketCity = marketCity;
	}

	public String getMarketCou() {
		return marketCou;
	}

	public void setMarketCou(String marketCou) {
		this.marketCou = marketCou;
	}

	public String getMarketAdress() {
		return marketAdress;
	}

	public void setMarketAdress(String marketAdress) {
		this.marketAdress = marketAdress;
	}

	public String getMarketProvCode() {
		return marketProvCode;
	}

	public void setMarketProvCode(String marketProvCode) {
		this.marketProvCode = marketProvCode;
	}

	public String getMarketCityCode() {
		return marketCityCode;
	}

	public void setMarketCityCode(String marketCityCode) {
		this.marketCityCode = marketCityCode;
	}

	public String getMarketCouCode() {
		return marketCouCode;
	}

	public void setMarketCouCode(String marketCouCode) {
		this.marketCouCode = marketCouCode;
	}
}
