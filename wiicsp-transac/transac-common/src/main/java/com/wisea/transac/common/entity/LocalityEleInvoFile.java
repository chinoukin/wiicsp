package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class LocalityEleInvoFile extends DataLongEntity<LocalityEleInvoFile> {
    /**
     * 订单发票id
     */
    private Long ordInvoId;

    /**
     * 电子发票url
     */
    private String eleInvoUrl;

    public Long getOrdInvoId() {
        return ordInvoId;
    }

    public void setOrdInvoId(Long ordInvoId) {
        this.ordInvoId = ordInvoId;
    }

    public String getEleInvoUrl() {
        return eleInvoUrl;
    }

    public void setEleInvoUrl(String eleInvoUrl) {
        this.eleInvoUrl = eleInvoUrl;
    }
}
