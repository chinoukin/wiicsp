package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class BaseCertMage extends DataLongEntity<BaseCertMage> {
    /**
     * 基地id
     */
    private Long baseId;

    /**
     * 证书名称
     */
    private String certName;

    public Long getBaseId() {
        return baseId;
    }

    public void setBaseId(Long baseId) {
        this.baseId = baseId;
    }

    public String getCertName() {
        return certName;
    }

    public void setCertName(String certName) {
        this.certName = certName;
    }
}
