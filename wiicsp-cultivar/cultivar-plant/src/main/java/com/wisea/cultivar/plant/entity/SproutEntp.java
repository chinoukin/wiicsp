package com.wisea.cultivar.plant.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class SproutEntp extends DataLongEntity<SproutEntp> {
    /**
     * 种苗目录管理id
     */
    private Long sproutCatalogMageId;

    /**
     * 服务商id
     */
    private Long membId;

    public Long getSproutCatalogMageId() {
        return sproutCatalogMageId;
    }

    public void setSproutCatalogMageId(Long sproutCatalogMageId) {
        this.sproutCatalogMageId = sproutCatalogMageId;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }
}
