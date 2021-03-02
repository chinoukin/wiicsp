package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

public class LocalitySettleBillPayRecord extends DataLongEntity<LocalitySettleBillPayRecord> {
    /**
     * 结算单id
     */
    private Long settleId;

    /**
     * 支付总金额
     */
    private Double paymentAmount;

    /**
     * 支付结算金额
     */
    private Double paymentSettleAmount;

    /**
     * 支付滞纳金金额
     */
    private Double paymentLateFeeAmount;

    /**
     * 支付时间
     */
    private OffsetDateTime payDate;

    /**
     * 分账信息
     */
    private String subLedInfo;

    /**
     * 分账标识
     */
    private String subLedFlag;

    /**
     * 支付id
     */
    private String payId;

    public Long getSettleId() {
        return settleId;
    }

    public void setSettleId(Long settleId) {
        this.settleId = settleId;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Double getPaymentSettleAmount() {
        return paymentSettleAmount;
    }

    public void setPaymentSettleAmount(Double paymentSettleAmount) {
        this.paymentSettleAmount = paymentSettleAmount;
    }

    public Double getPaymentLateFeeAmount() {
        return paymentLateFeeAmount;
    }

    public void setPaymentLateFeeAmount(Double paymentLateFeeAmount) {
        this.paymentLateFeeAmount = paymentLateFeeAmount;
    }

    public OffsetDateTime getPayDate() {
        return payDate;
    }

    public void setPayDate(OffsetDateTime payDate) {
        this.payDate = payDate;
    }

    public String getSubLedInfo() {
        return subLedInfo;
    }

    public void setSubLedInfo(String subLedInfo) {
        this.subLedInfo = subLedInfo;
    }

    public String getSubLedFlag() {
        return subLedFlag;
    }

    public void setSubLedFlag(String subLedFlag) {
        this.subLedFlag = subLedFlag;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }
}
