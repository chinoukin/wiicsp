package com.wisea.cultivar.common.vo.tp.trade;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 进货单的商品规格、等级信息
 */
@ApiModel("进货单的商品规格、等级信息")
public class SpecLevelVo {

	@ApiModelProperty("进货单ID")
	@JsonSerialize(using = IdSerializer.class)
	private Long billId;

	@ApiModelProperty("进货单商品规格")
	private double inportCommSpec;

	@ApiModelProperty("等级")
	private String commLevelType;

	@ApiModelProperty("数量")
	private int count;

	@ApiModelProperty("单价")
	private Double price;

	@ApiModelProperty("金额小计")
	private Double totalMoney;

	@ApiModelProperty("起订量")
    private Integer startOrdCount;

	@ApiModelProperty("可售数量")
    private Double avaiSupplyCount;

	@ApiModelProperty("是否修改过。0：修改过，1：否")
	private String changSpecFlag;

	public double getInportCommSpec() {
		return inportCommSpec;
	}

	public void setInportCommSpec(double inportCommSpec) {
		this.inportCommSpec = inportCommSpec;
	}

	public String getChangSpecFlag() {
		return changSpecFlag;
	}

	public void setChangSpecFlag(String changSpecFlag) {
		this.changSpecFlag = changSpecFlag;
	}

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public Integer getStartOrdCount() {
		return startOrdCount;
	}

	public void setStartOrdCount(Integer startOrdCount) {
		this.startOrdCount = startOrdCount;
	}

	public Double getAvaiSupplyCount() {
		return avaiSupplyCount;
	}

	public void setAvaiSupplyCount(Double avaiSupplyCount) {
		this.avaiSupplyCount = avaiSupplyCount;
	}

	public String getCommLevelType() {
		return commLevelType;
	}

	public void setCommLevelType(String commLevelType) {
		this.commLevelType = commLevelType;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}
}

