package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class StorageInfo extends DataLongEntity<StorageInfo> {
    /**
     * 基地id
     */
    private Long baseId;

    /**
     * 仓库名称
     */
    private String storageName;

    /**
     * 仓库面积
     */
    private Double storageMj;

    /**
     * 仓库类型
     */
    private String warehType;

    /**
     * 仓库介绍
     */
    private String storageContent;

    public Long getBaseId() {
        return baseId;
    }

    public void setBaseId(Long baseId) {
        this.baseId = baseId;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public Double getStorageMj() {
        return storageMj;
    }

    public void setStorageMj(Double storageMj) {
        this.storageMj = storageMj;
    }

    public String getWarehType() {
        return warehType;
    }

    public void setWarehType(String warehType) {
        this.warehType = warehType;
    }

    public String getStorageContent() {
        return storageContent;
    }

    public void setStorageContent(String storageContent) {
        this.storageContent = storageContent;
    }
}
