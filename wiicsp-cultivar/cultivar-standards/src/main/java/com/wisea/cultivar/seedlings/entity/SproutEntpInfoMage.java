package com.wisea.cultivar.seedlings.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * sprout_entp 表实体
 * 定点种苗企业
 * 2020/08/06 14:19:24
 */
public class SproutEntpInfoMage extends DataLongEntity<SproutEntpInfoMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 种苗目录管理id
     */
    private Long sproutCatalogMageId;

    /**
     * 种苗id
     */
    private Long oilTeaVarietId;

    /**
     *
     * @mbg.generated
     */
    public SproutEntpInfoMage() {
        super();
    }

    /**
     * 获取种苗目录管理id
     */
    public Long getSproutCatalogMageId() {
        return sproutCatalogMageId;
    }

    /**
     * 设置种苗目录管理id
     */
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
