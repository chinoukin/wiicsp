package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * ord_cancel_reason_mage 表实体
 * 订单取消原因管理
 * 2018/10/10 14:42:38
 */
public class OrdCancelReasonMage extends DataLongEntity<OrdCancelReasonMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private String num;

    /**
     * 订单取消原因
     */
    private String ordCancelReason;

    /**
     * 获取编号
     */
    public String getNum() {
        return num;
    }

    /**
     * 设置编号
     */
    public void setNum(String num) {
        this.num = num == null ? null : num.trim();
    }

    /**
     * 获取订单取消原因
     */
    public String getOrdCancelReason() {
        return ordCancelReason;
    }

    /**
     * 设置订单取消原因
     */
    public void setOrdCancelReason(String ordCancelReason) {
        this.ordCancelReason = ordCancelReason == null ? null : ordCancelReason.trim();
    }
}
