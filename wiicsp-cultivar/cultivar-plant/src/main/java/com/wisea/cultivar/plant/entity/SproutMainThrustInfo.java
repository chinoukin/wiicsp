package com.wisea.cultivar.plant.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class SproutMainThrustInfo extends DataLongEntity<SproutMainThrustInfo> {
    /**
     * 种苗目录管理id
     */
    private Long sproutCatalogMageId;

    /**
     * 油茶品种信息id
     */
    private Long oilTeaVarietId;

    public Long getSproutCatalogMageId() {
        return sproutCatalogMageId;
    }

    public void setSproutCatalogMageId(Long sproutCatalogMageId) {
        this.sproutCatalogMageId = sproutCatalogMageId;
    }

    public Long getOilTeaVarietId() {
        return oilTeaVarietId;
    }

    public void setOilTeaVarietId(Long oilTeaVarietId) {
        this.oilTeaVarietId = oilTeaVarietId;
    }
}
