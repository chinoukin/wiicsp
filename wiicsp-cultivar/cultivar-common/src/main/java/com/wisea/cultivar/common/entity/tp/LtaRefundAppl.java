package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

public class LtaRefundAppl extends DataLongEntity<LtaRefundAppl> {
    /**
     * id
     */
    private Long id;

    /**
     * 长协订单id
     */
    private Long ltaOrdId;

    /**
     * 退款编号
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

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getLtaOrdId() {
        return ltaOrdId;
    }

    public void setLtaOrdId(Long ltaOrdId) {
        this.ltaOrdId = ltaOrdId;
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
