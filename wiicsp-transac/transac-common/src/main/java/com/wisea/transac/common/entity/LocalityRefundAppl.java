package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

public class LocalityRefundAppl extends DataLongEntity<LocalityRefundAppl> {
    /**
     * 订单id
     */
    private Long ordId;

    /**
     * 订单编号
     */
    private String ordNum;

    /**
     * 服务单号
     */
    private String refundNum;

    /**
     * 申请时间
     */
    private OffsetDateTime applDate;

    /**
     * 订单金额
     */
    private Double ordAmount;

    /**
     * 退款金额
     */
    private Double refundAmount;

    /**
     * 退款申请状态类型
     */
    private String refundApplStateType;

    /**
     * 处理时间
     */
    private OffsetDateTime handleDate;

    /**
     * 问题描述
     */
    private String refundDesc;

    /**
     * 处理结果类型（同意、拒绝）
     */
    private String sellerOperatType;

    /**
     * 商家处理备注
     */
    private String sellerHandleRemarks;

    /**
     * 订单取消原因id
     */
    private Long refundReasonType;

    /**
     * 提出方标志
     */
    private String buySellFlag;

    /**
     * 处理方类型
     */
    private String handlerType;

    /**
     * 退款唯一请求id
     */
    private String outRequestNo;

    /**
     * 应退服务费
     */
    private Double refundSerFee;

    /**
     * 应退账期服务费金额
     */
    private Double refundZqSerCost;

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

    public Double getRefundSerFee() {
        return refundSerFee;
    }

    public void setRefundSerFee(Double refundSerFee) {
        this.refundSerFee = refundSerFee;
    }

    public Double getRefundZqSerCost() {
        return refundZqSerCost;
    }

    public void setRefundZqSerCost(Double refundZqSerCost) {
        this.refundZqSerCost = refundZqSerCost;
    }
}
