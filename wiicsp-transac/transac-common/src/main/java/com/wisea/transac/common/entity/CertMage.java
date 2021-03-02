package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class CertMage extends DataLongEntity<CertMage> {
    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * 证书名称
     */
    private String certName;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getCertName() {
        return certName;
    }

    public void setCertName(String certName) {
        this.certName = certName;
    }
}
