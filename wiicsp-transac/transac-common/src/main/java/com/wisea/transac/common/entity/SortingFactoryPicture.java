package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class SortingFactoryPicture extends DataLongEntity<SortingFactoryPicture> {
    /**
     * 分选工厂id
     */
    private Long sortingFactoryId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 图片url
     */
    private String url;

    /**
     * 图片类型（图片、视频）
     */
    private String basePictureType;

    public Long getSortingFactoryId() {
        return sortingFactoryId;
    }

    public void setSortingFactoryId(Long sortingFactoryId) {
        this.sortingFactoryId = sortingFactoryId;
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
