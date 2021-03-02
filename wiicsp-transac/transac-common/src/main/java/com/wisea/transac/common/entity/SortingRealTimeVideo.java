package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class SortingRealTimeVideo extends DataLongEntity<SortingRealTimeVideo> {
    /**
     * 分选工厂id
     */
    private Long sortingFactoryId;

    /**
     * 安装位置
     */
    private String installPosition;

    /**
     * 接入地址
     */
    private String url;

    /**
     * 设备厂商
     */
    private String equManufact;

    /**
     * 设备编号
     */
    private String equNum;

    /**
     * 排序
     */
    private Integer sort;

    public Long getSortingFactoryId() {
        return sortingFactoryId;
    }

    public void setSortingFactoryId(Long sortingFactoryId) {
        this.sortingFactoryId = sortingFactoryId;
    }

    public String getInstallPosition() {
        return installPosition;
    }

    public void setInstallPosition(String installPosition) {
        this.installPosition = installPosition;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEquManufact() {
        return equManufact;
    }

    public void setEquManufact(String equManufact) {
        this.equManufact = equManufact;
    }

    public String getEquNum() {
        return equNum;
    }

    public void setEquNum(String equNum) {
        this.equNum = equNum;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
