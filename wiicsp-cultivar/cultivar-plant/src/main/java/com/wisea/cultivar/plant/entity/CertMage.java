package com.wisea.cultivar.plant.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class CertMage extends DataLongEntity<CertMage> {
    /**
     * 店铺id
     */
    private Long shopInfoId;

    /**
     * 证书名称
     */
    private String certName;

    public Long getShopInfoId() {
        return shopInfoId;
    }

    public void setShopInfoId(Long shopInfoId) {
        this.shopInfoId = shopInfoId;
    }

    public String getCertName() {
        return certName;
    }

    public void setCertName(String certName) {
        this.certName = certName;
    }
}
