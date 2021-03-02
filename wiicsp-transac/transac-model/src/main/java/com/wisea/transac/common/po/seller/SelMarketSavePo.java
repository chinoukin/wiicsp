package com.wisea.transac.common.po.seller;

import java.io.Serializable;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 小程序登录后选择市场后保存市场信息PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月29日
 * @version 1.0
 */
@ApiModel("小程序登录后选择市场后保存市场信息PO")
public class SelMarketSavePo implements Serializable{

	private static final long serialVersionUID = 8089600314320068239L;

	@ApiModelProperty(value="市场ID")
	@Check(test = {"required"})
	private Long marketId;
	@ApiModelProperty(value="市场名称")
	private String marketName;
	@ApiModelProperty(value="市场坐标点")
	private String coordinatePoint;
	@ApiModelProperty(value="市场所在区域省")
	private String marketProv;
	@ApiModelProperty(value="市场所在区域市")
	private String marketCity;
	@ApiModelProperty(value="市场所在区域县")
	private String marketCou;
	@ApiModelProperty(value = "所在区域省code")
	private String marketProvCode;
	@ApiModelProperty(value = "所在区域市code")
	private String marketCityCode;
	@ApiModelProperty(value = "所在区域区县code")
	private String marketCouCode;
	@ApiModelProperty(value="市场所在区域详细地址")
	private String  marketAdress;

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
