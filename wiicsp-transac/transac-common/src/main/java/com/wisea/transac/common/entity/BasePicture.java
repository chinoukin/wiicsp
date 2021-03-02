package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class BasePicture extends DataLongEntity<BasePicture> {
    /**
     * 基地id
     */
    private Long baseId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 图片url
     */
    private String url;

    /**
     * 基地图片类型（图片、视频）
     */
    private String basePictureType;

    public Long getBaseId() {
        return baseId;
    }

    public void setBaseId(Long baseId) {
        this.baseId = baseId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBasePictureType() {
        return basePictureType;
    }

    public void setBasePictureType(String basePictureType) {
        this.basePictureType = basePictureType;
    }
}
