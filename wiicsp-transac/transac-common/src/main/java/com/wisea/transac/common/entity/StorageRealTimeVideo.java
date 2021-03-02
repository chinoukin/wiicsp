package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class StorageRealTimeVideo extends DataLongEntity<StorageRealTimeVideo> {
    /**
     * 仓储id
     */
    private Long storageId;

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

    public Long getStorageId() {
        return storageId;
    }

    public void setStorageId(Long storageId) {
        this.storageId = storageId;
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
