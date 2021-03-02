package com.wisea.cultivar.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class PlaceOriginMage extends DataLongEntity<PlaceOriginMage> {
    /**
     * 产地名称
     */
    private String placeOriginName;

    /**
     * 排序
     */
    private Integer sort;

    public String getPlaceOriginName() {
        return placeOriginName;
    }

    public void setPlaceOriginName(String placeOriginName) {
        this.placeOriginName = placeOriginName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
