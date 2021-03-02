package com.wisea.transac.common.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

@ApiModel("取消订单Po")
public class RefundApplPo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="订单id")
    private Long ordId;

    @ApiModelProperty(value="订单编号")
    private String ordNum;

    @ApiModelProperty(value="服务单号")
    private String refundNum;

    @ApiModelProperty(value="申请时间")
    private OffsetDateTime applDate;

    @ApiModelProperty(value="订单金额")
    private Double ordAmount;

    @ApiModelProperty(value="退款金额")
    private Double refundAmount;

    @ApiModelProperty(value="退款申请状态类型")
    private String refundApplStateType;

    @ApiModelProperty(value="处理时间")
    private OffsetDateTime handleDate;

    @ApiModelProperty(value="问题描述")
    private String refundDesc;

    @ApiModelProperty(value="处理结果类型（同意、拒绝）")
    private String sellerOperatType;

    @ApiModelProperty(value="商家处理备注")
    private String sellerHandleRemarks;

    @ApiModelProperty(value="订单取消原因id")
    private Long refundReasonType;

    @ApiModelProperty(value="提出方标志")
    private String buySellFlag;

    @ApiModelProperty(value="处理方类型")
    private String handlerType;

    @ApiModelProperty(value="退款唯一请求id")
    private String outRequestNo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrdId() {
        return ordId;
    }

    public void setOrdId(Long ordId) {
        this.ordId = ordId;
    }

    public String getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
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

    public OffsetDateTime getHandleDate() {
        return handleDate;
    }

    public void setHandleDate(OffsetDateTime handleDate) {
        this.handleDate = handleDate;
    }

    public String getRefundDesc() {
        return refundDesc;
    }

    public void setRefundDesc(String refundDesc) {
        this.refundDesc = refundDesc;
    }

    public String getSellerOperatType() {
        return sellerOperatType;
    }

    public void setSellerOperatType(String sellerOperatType) {
        this.sellerOperatType = sellerOperatType;
    }

    public String getSellerHandleRemarks() {
        return sellerHandleRemarks;
    }

    public void setSellerHandleRemarks(String sellerHandleRemarks) {
        this.sellerHandleRemarks = sellerHandleRemarks;
    }

    public Long getRefundReasonType() {
        return refundReasonType;
    }

    public void setRefundReasonType(Long refundReasonType) {
        this.refundReasonType = refundReasonType;
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

    public String getOutRequestNo() {
        return outRequestNo;
    }

    public void setOutRequestNo(String outRequestNo) {
        this.outRequestNo = outRequestNo;
    }
}
