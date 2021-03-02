package com.wisea.cultivar.common.vo.tp.lta;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 买家端退货退款申请列表VO
 */
@ApiModel("买家端退货退款申请列表VO")
public class LtaBuyerRefundCommApplListVo {

    @ApiModelProperty("退货退款申请ID")
    private Long id;
    @ApiModelProperty("商品ID")
    private Long ordCommId;
    @ApiModelProperty("服务单号")
    private String serNum;
    @ApiModelProperty("订单编号")
    private String ordNum;
    @ApiModelProperty("商品名称")
    private String commName;
    @ApiModelProperty("商品url")
    private String commUrl;
    @ApiModelProperty("退货数量")
    private Double refundCounts;
    @ApiModelProperty("应退金额")
    private Double shouldRefundAmount;
    @ApiModelProperty("申请时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime applDate;
    @ApiModelProperty("退货退款申请状态")
    private String refundCommState;
    @ApiModelProperty("操作标识")
    private String operaFlag;
    @ApiModelProperty(value = "买家名称")
    private String buyerName;
    @ApiModelProperty(value = "买家账号")
    private String buyerUserName;
    @ApiModelProperty(value = "卖家名称")
    private String sellerName;
	@ApiModelProperty("申请时间")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	private OffsetDateTime examSerBillDate;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public Long getOrdCommId() {
		return ordCommId;
	}
	public void setOrdCommId(Long ordCommId) {
		this.ordCommId = ordCommId;
	}
	public String getSerNum() {
		return serNum;
	}
	public void setSerNum(String serNum) {
		this.serNum = serNum;
	}
	public String getCommUrl() {
		return commUrl;
	}
	public void setCommUrl(String commUrl) {
		this.commUrl = commUrl;
	}
	public String getOrdNum() {
		return ordNum;
	}
	public void setOrdNum(String ordNum) {
		this.ordNum = ordNum;
	}
	public String getCommName() {
		return commName;
	}
	public void setCommName(String commName) {
		this.commName = commName;
	}
	public Double getRefundCounts() {
		return refundCounts;
	}
	public void setRefundCounts(Double refundCounts) {
		this.refundCounts = refundCounts;
	}
	public Double getShouldRefundAmount() {
		return shouldRefundAmount;
	}
	public void setShouldRefundAmount(Double shouldRefundAmount) {
		this.shouldRefundAmount = shouldRefundAmount;
	}
	public OffsetDateTime getApplDate() {
		return applDate;
	}
	public void setApplDate(OffsetDateTime applDate) {
		this.applDate = applDate;
	}
	public String getRefundCommState() {
		return refundCommState;
	}
	public void setRefundCommState(String refundCommState) {
		this.refundCommState = refundCommState;
	}
	public String getOperaFlag() {
		return operaFlag;
	}
	public void setOperaFlag(String operaFlag) {
		this.operaFlag = operaFlag;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getBuyerUserName() {
		return buyerUserName;
	}
	public void setBuyerUserName(String buyerUserName) {
		this.buyerUserName = buyerUserName;
	}

	public OffsetDateTime getExamSerBillDate() {
		return examSerBillDate;
	}

	public void setExamSerBillDate(OffsetDateTime examSerBillDate) {
		this.examSerBillDate = examSerBillDate;
	}
}
