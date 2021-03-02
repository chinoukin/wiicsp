package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class OrdCancelReasonMage extends DataLongEntity<OrdCancelReasonMage> {
    /**
     * 编号
     */
    private String num;

    /**
     * 订单取消原因
     */
    private String ordCancelReason;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getOrdCancelReason() {
        return ordCancelReason;
    }

    public void setOrdCancelReason(String ordCancelReason) {
        this.ordCancelReason = ordCancelReason;
    }
}
