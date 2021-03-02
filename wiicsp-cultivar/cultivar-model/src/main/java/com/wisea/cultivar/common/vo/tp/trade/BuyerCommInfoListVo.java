package com.wisea.cultivar.common.vo.tp.trade;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 预定单的商品列表信息
 */
@ApiModel("预订单的商品列表信息")
public class BuyerCommInfoListVo {

	@ApiModelProperty("进货单的ID")
	@JsonSerialize(using = IdSerializer.class)
	private Long importBillId;

	/**
	 * 商品的ID
	 */
	@ApiModelProperty(hidden=true)
	private Long commPubId;

	@ApiModelProperty("商品名称")
	private String commName;

	@ApiModelProperty("批发价")
	private String wholePrice;

	@ApiModelProperty("代理价")
	private String agentWholePrice;

	@ApiModelProperty("数量")
	private int count;

	@ApiModelProperty("商品规格")
	private double commSpec;

	@ApiModelProperty("商品单价")
	private Double price;

	@ApiModelProperty("图片地址")
	private String url;

	@ApiModelProperty("计量单位名称")
	private String measUnitName;

	@ApiModelProperty("代理状态")
    private String agentStateType;

	public Long getImportBillId() {
		return importBillId;
	}

	public void setImportBillId(Long importBillId) {
		this.importBillId = importBillId;
	}

	public String getCommName() {
		return commName;
	}

	public void setCommName(String commName) {
		this.commName = commName;
	}

	public String getWholePrice() {
		return wholePrice;
	}

	public void setWholePrice(String wholePrice) {
		this.wholePrice = wholePrice;
	}

	public String getAgentWholePrice() {
		return agentWholePrice;
	}

	public void setAgentWholePrice(String agentWholePrice) {
		this.agentWholePrice = agentWholePrice;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getCommSpec() {
		return commSpec;
	}

	public void setCommSpec(double commSpec) {
		this.commSpec = commSpec;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getCommPubId() {
		return commPubId;
	}

	public void setCommPubId(Long commPubId) {
		this.commPubId = commPubId;
	}

	public String getMeasUnitName() {
		return measUnitName;
	}

	public void setMeasUnitName(String measUnitName) {
		this.measUnitName = measUnitName;
	}

	public String getAgentStateType() {
		return agentStateType;
	}

	public void setAgentStateType(String agentStateType) {
		this.agentStateType = agentStateType;
	}
}

