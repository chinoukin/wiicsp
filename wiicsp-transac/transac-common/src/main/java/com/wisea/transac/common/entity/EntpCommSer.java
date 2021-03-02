package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.transac.common.entity.EntpCommSer;

public class EntpCommSer extends DataLongEntity<EntpCommSer> {
    /**
     * 服务类型
     */
    private String serType;

    /**
     * 服务简称
     */
    private String serAbbrev;

    /**
     * 服务说明
     */
    private String serIntr;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 停启用状态
     */
    private String effeInvalState;

    public String getSerType() {
        return serType;
    }

    public void setSerType(String serType) {
        this.serType = serType;
    }

    public String getSerAbbrev() {
        return serAbbrev;
    }

    public void setSerAbbrev(String serAbbrev) {
        this.serAbbrev = serAbbrev;
    }

    public String getSerIntr() {
        return serIntr;
    }

    public void setSerIntr(String serIntr) {
        this.serIntr = serIntr;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getEffeInvalState() {
        return effeInvalState;
    }

    public void setEffeInvalState(String effeInvalState) {
        this.effeInvalState = effeInvalState;
    }
}