package com.wisea.cultivar.plant.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class linkMage extends DataLongEntity<linkMage> {
    /**
     * 环节名称
     */
    private String linkName;

    /**
     * 显示顺序
     */
    private Integer sort;

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
