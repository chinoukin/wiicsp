package com.wisea.cultivar.common.entity;

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

    private Integer sort;

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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
