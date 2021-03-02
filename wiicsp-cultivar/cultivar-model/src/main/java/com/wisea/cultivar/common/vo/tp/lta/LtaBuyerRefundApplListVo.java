package com.wisea.cultivar.common.vo.tp.lta;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cultivar.common.vo.tp.trade.BuyerOrdCommRela;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 买家退款申请列表VO
 */
@ApiModel("买家退款申请列表VO")
public class LtaBuyerRefundApplListVo{

    @ApiModelProperty("退款申请ID")
    private Long id;
    @ApiModelProperty("服务单号")
    private String refundNum;
    @ApiModelProperty("订单编号")
    private String ordNum;
    @ApiModelProperty("申请时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime applDate;
    @ApiModelProperty("应退金额")
    private Double ordAmount;
    @ApiModelProperty("实退金额")
    private Double refundAmount;
    @ApiModelProperty("支付类型")
    private String payMethodType;
    @ApiModelProperty("退款申请状态")
    private String refundApplStateType;
    @ApiModelProperty(value = "订单商品")
    private List<BuyerOrdCommRela> ordCommRelaList;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPayMethodType() {
		return payMethodType;
	}
	public void setPayMethodType(String payMethodType) {
		this.payMethodType = payMethodType;
	}
	public String getRefundNum() {
		return refundNum;
	}
	public void setRefundNum(String refundNum) {
		this.refundNum = refundNum;
	}
	public String getOrdNum() {
		return ordNum;
	}
	public void setOrdNum(String ordNum) {
		this.ordNum = ordNum;
	}
	public OffsetDateTime getApplDate() {
		return applDate;
	}
	public void setApplDate(OffsetDateTime applDate) {
		this.applDate = applDate;
	}
	public Double getOrdAmount() {
		return ordAmount;
	}
	public void setOrdAmount(Double ordAmount) {
		this.ordAmount = ordAmount;
	}
	public Double getRefundAmount() {
		return refundAmount;
	}
	public void setRefundAmount(Double refundAmount) {
		this.refundAmount = refundAmount;
	}
	public String getRefundApplStateType() {
		return refundApplStateType;
	}
	public void setRefundApplStateType(String refundApplStateType) {
		this.refundApplStateType = refundApplStateType;
	}
	public List<BuyerOrdCommRela> getOrdCommRelaList() {
		return ordCommRelaList;
	}
	public void setOrdCommRelaList(List<BuyerOrdCommRela> ordCommRelaList) {
		this.ordCommRelaList = ordCommRelaList;
	}

}
