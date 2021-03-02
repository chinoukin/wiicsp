package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class LocalitySettleBillEleInvoFile extends DataLongEntity<LocalitySettleBillEleInvoFile> {
    /**
     * 计算单发票id
     */
    private Long settleBillInvoId;

    /**
     * 电子发票url
     */
    private String eleInvoUrl;

    public Long getSettleBillInvoId() {
        return settleBillInvoId;
    }

    public void setSettleBillInvoId(Long settleBillInvoId) {
        this.settleBillInvoId = settleBillInvoId;
    }

    public String getEleInvoUrl() {
        return eleInvoUrl;
    }

    public void setEleInvoUrl(String eleInvoUrl) {
        this.eleInvoUrl = eleInvoUrl;
    }
}
