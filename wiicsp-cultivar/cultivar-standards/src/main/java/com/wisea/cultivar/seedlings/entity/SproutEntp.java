package com.wisea.cultivar.seedlings.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * sprout_entp 表实体
 * 定点种苗企业
 * 2020/08/06 14:19:24
 */
public class SproutEntp extends DataLongEntity<SproutEntp> {
    private static final long serialVersionUID = 1L;

    /**
     * 种苗目录管理id
     */
    private Long sproutCatalogMageId;

    /**
     * 服务商id
     */
    private Long membId;

    /**
     *
     * @mbg.generated
     */
    public SproutEntp() {
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

    /**
     * 获取服务商id
     */
    public Long getMembId() {
        return membId;
    }

    /**
     * 设置服务商id
     */
    public void setMembId(Long membId) {
        this.membId = membId;
    }
}
