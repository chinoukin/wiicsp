package com.wisea.cultivar.common.vo.tp.trade;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 提交订单返回订单信息
 */
@ApiModel("提交订单返回订单信息")
public class BuyerGeneratingOrderVo {

	@ApiModelProperty("订单截至时间")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime payDeadDate;

	@ApiModelProperty("订单编号List")
    private List<BuyerOrderInfoVo> ordInfoList;

	@ApiModelProperty("订单总金额")
	private double amountPayable;

	@ApiModelProperty("预付订金")
	private double depositPayable;

	@ApiModelProperty("是否可以分账期支付，0：否；1：是")
	private String canFjdpay;

	public OffsetDateTime getPayDeadDate() {
		return payDeadDate;
	}

	public void setPayDeadDate(OffsetDateTime payDeadDate) {
		this.payDeadDate = payDeadDate;
	}

	public String getCanFjdpay() {
		return canFjdpay;
	}

	public void setCanFjdpay(String canFjdpay) {
		this.canFjdpay = canFjdpay;
	}

	public double getDepositPayable() {
		return depositPayable;
	}

	public void setDepositPayable(double depositPayable) {
		this.depositPayable = depositPayable;
	}

	public List<BuyerOrderInfoVo> getOrdInfoList() {
		return ordInfoList;
	}

	public void setOrdInfoList(List<BuyerOrderInfoVo> ordInfoList) {
		this.ordInfoList = ordInfoList;
	}

	public double getAmountPayable() {
		return amountPayable;
	}

	public void setAmountPayable(double amountPayable) {
		this.amountPayable = amountPayable;
	}
}

