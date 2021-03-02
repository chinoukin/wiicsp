package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * refund_reason_mage 表实体
 * 退货退款原因管理
 * 2018/09/18 14:36:47
 */
public class RefundReasonMage extends DataLongEntity<RefundReasonMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
    private String serialNum;

    /**
     * 退款原因
     */
    private String refundReason;

    /**
     * 获取序号
     */
    public String getSerialNum() {
        return serialNum;
    }

    /**
     * 设置序号
     */
    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum == null ? null : serialNum.trim();
    }

    /**
     * 获取退款原因
     */
    public String getRefundReason() {
        return refundReason;
    }

    /**
     * 设置退款原因
     */
    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason == null ? null : refundReason.trim();
    }
}
