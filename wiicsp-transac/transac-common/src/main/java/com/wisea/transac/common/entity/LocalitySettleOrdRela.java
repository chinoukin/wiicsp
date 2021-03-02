package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class LocalitySettleOrdRela extends DataLongEntity<LocalitySettleOrdRela> {
    /**
     * 结算单id
     */
    private Long settleId;

    /**
     * 订单id
     */
    private Long ordId;

    /**
     * 结算金额
     */
    private Double amount;

    /**
     * 订单编号
     */
    private String ordNum;

    /**
     * 订单金额
     */
    private Double ordAmount;

    /**
     * 退款金额
     */
    private Double refundAmount;

    public Long getSettleId() {
        return settleId;
    }

    public void setSettleId(Long settleId) {
        this.settleId = settleId;
    }

    public Long getOrdId() {
        return ordId;
    }

    public void setOrdId(Long ordId) {
        this.ordId = ordId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
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
}
