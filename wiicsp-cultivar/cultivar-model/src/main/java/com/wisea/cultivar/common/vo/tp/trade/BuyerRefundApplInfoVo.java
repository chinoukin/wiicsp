package com.wisea.cultivar.common.vo.tp.trade;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * 买家端退款申请详细信息
 */
@ApiModel("买家端退款申请详细信息")
public class BuyerRefundApplInfoVo {

	@ApiModelProperty("id")
    private Long id;
	/** 服务单进度 **/
	@ApiModelProperty("申请状态")
    private String refundApplStateType;
	@ApiModelProperty("服务单号")
    private String refundNum;
	@ApiModelProperty("申请时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime applDate;
	@ApiModelProperty("订单id")
    private Long orderId;
	@ApiModelProperty("退款金额")
    private Double refundAmount;
	@ApiModelProperty("处理时间")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime handleDate;
	@ApiModelProperty("订单金额")
    private Double ordAmount;
	@ApiModelProperty("商家处理备注")
    private String sellerHandleRemarks;
	@ApiModelProperty("卖家id")
    private Long sellerId;
	@ApiModelProperty("商家公司名称")
    private String sellerCompName;
	@ApiModelProperty("提出方标志")
    private String buySellFlag;
	@ApiModelProperty("处理方类型")
    private String handlerType;
	@ApiModelProperty("退款原因")
    private String ordCancelReason;
	/**  订单信息  **/
	@ApiModelProperty("订单信息")
    private OrderInfoVo orderInfoVo;

	public String getRefundApplStateType() {
		return refundApplStateType;
	}
	public void setRefundApplStateType(String refundApplStateType) {
		this.refundApplStateType = refundApplStateType;
	}
	public String getRefundNum() {
		return refundNum;
	}
	public void setRefundNum(String refundNum) {
		this.refundNum = refundNum;
	}
	public OffsetDateTime getApplDate() {
		return applDate;
	}
	public void setApplDate(OffsetDateTime applDate) {
		this.applDate = applDate;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Double getRefundAmount() {
		return refundAmount;
	}
	public void setRefundAmount(Double refundAmount) {
		this.refundAmount = refundAmount;
	}
	public OffsetDateTime getHandleDate() {
		return handleDate;
	}
	public void setHandleDate(OffsetDateTime handleDate) {
		this.handleDate = handleDate;
	}
	public Double getOrdAmount() {
		return ordAmount;
	}
	public void setOrdAmount(Double ordAmount) {
		this.ordAmount = ordAmount;
	}
	public String getSellerHandleRemarks() {
		return sellerHandleRemarks;
	}
	public void setSellerHandleRemarks(String sellerHandleRemarks) {
		this.sellerHandleRemarks = sellerHandleRemarks;
	}
	public OrderInfoVo getOrderInfoVo() {
		return orderInfoVo;
	}
	public void setOrderInfoVo(OrderInfoVo orderInfoVo) {
		this.orderInfoVo = orderInfoVo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSellerId() {
		return sellerId;
	}
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
	public String getSellerCompName() {
		return sellerCompName;
	}
	public void setSellerCompName(String sellerCompName) {
		this.sellerCompName = sellerCompName;
	}
	public String getBuySellFlag() {
		return buySellFlag;
	}
	public void setBuySellFlag(String buySellFlag) {
		this.buySellFlag = buySellFlag;
	}
	public String getHandlerType() {
		return handlerType;
	}
	public void setHandlerType(String handlerType) {
		this.handlerType = handlerType;
	}
	public String getOrdCancelReason() {
		return ordCancelReason;
	}
	public void setOrdCancelReason(String ordCancelReason) {
		this.ordCancelReason = ordCancelReason;
	}
}
