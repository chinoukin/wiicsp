package com.wisea.cultivar.common.vo.tp.trade;

import java.time.OffsetDateTime;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 退款详情Vo
 */
@ApiModel("退款详情Vo")
public class BuyerRefundInfoVo {

    @ApiModelProperty("订单ID")
    private Long id;
    @ApiModelProperty("买家用户ID")
    private Long buyerId;
    @ApiModelProperty("买家用户账号")
    private String buyerAccount;
    @ApiModelProperty("买家名称")
    private String buyerCompName;
    @ApiModelProperty("卖家用户ID")
    private Long sellerId;
    @ApiModelProperty("卖家用户账号")
    private String sellerAccount;
    @ApiModelProperty("卖家名称")
    private String sellerCompName;
    @ApiModelProperty("商品单价小计")
    private Double priceCount;
    @ApiModelProperty("商品信息")
    private List<BuyerOrdCommRela> buyerOrdCommRela;
    @ApiModelProperty(value = "退款金额")
    private Double refundAmount;
    @ApiModelProperty(value = "问题描述")
    private String refundDesc;
    @ApiModelProperty(value = "退款编号")
    private String refundNum;
    @ApiModelProperty(value = "退款申请状态类型")
    private String refundApplStateType;
    @ApiModelProperty(value = "申请时间")
    private OffsetDateTime applDate;
    @ApiModelProperty(value = "处理时间")
    private OffsetDateTime handleDate;
    @ApiModelProperty(value = "订单金额")
    private Double ordAmount;
    @ApiModelProperty(value = "商家处理备注")
    private String sellerHandleRemarks;
    @ApiModelProperty(value = "退款原因")
    private String refundReason;
    @ApiModelProperty("退款信息ID")
    private Long refundId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}
	public String getBuyerAccount() {
		return buyerAccount;
	}
	public void setBuyerAccount(String buyerAccount) {
		this.buyerAccount = buyerAccount;
	}
	public String getBuyerCompName() {
		return buyerCompName;
	}
	public void setBuyerCompName(String buyerCompName) {
		this.buyerCompName = buyerCompName;
	}
	public Long getSellerId() {
		return sellerId;
	}
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
	public String getMerchantAccount() {
		return sellerAccount;
	}
	public void setMerchantAccount(String sellerAccount) {
		this.sellerAccount = sellerAccount;
	}
	public List<BuyerOrdCommRela> getBuyerOrdCommRela() {
		return buyerOrdCommRela;
	}
	public void setBuyerOrdCommRela(List<BuyerOrdCommRela> buyerOrdCommRela) {
		this.buyerOrdCommRela = buyerOrdCommRela;
	}
	public String getSellerCompName() {
		return sellerCompName;
	}
	public void setSellerCompName(String sellerCompName) {
		this.sellerCompName = sellerCompName;
	}
	public Double getPriceCount() {
		return priceCount;
	}
	public void setPriceCount(Double priceCount) {
		this.priceCount = priceCount;
	}
	public Double getRefundAmount() {
		return refundAmount;
	}
	public void setRefundAmount(Double refundAmount) {
		this.refundAmount = refundAmount;
	}
	public String getRefundDesc() {
		return refundDesc;
	}
	public void setRefundDesc(String refundDesc) {
		this.refundDesc = refundDesc;
	}
	public String getRefundNum() {
		return refundNum;
	}
	public void setRefundNum(String refundNum) {
		this.refundNum = refundNum;
	}
	public String getRefundApplStateType() {
		return refundApplStateType;
	}
	public void setRefundApplStateType(String refundApplStateType) {
		this.refundApplStateType = refundApplStateType;
	}
	public OffsetDateTime getApplDate() {
		return applDate;
	}
	public void setApplDate(OffsetDateTime applDate) {
		this.applDate = applDate;
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
	public String getRefundReason() {
		return refundReason;
	}
	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}
	public Long getRefundId() {
		return refundId;
	}
	public void setRefundId(Long refundId) {
		this.refundId = refundId;
	}

}
