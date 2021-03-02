package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class StorageSensor extends DataLongEntity<StorageSensor> {
    /**
     * 仓储id
     */
    private Long storageId;

    /**
     * 安装位置
     */
    private String installPosition;

    /**
     * 设备厂商
     */
    private String equManufact;

    /**
     * 设备厂商ID
     */
    private Long equEntpId;

    /**
     * 设备编号
     */
    private String equNum;

    /**
     * 设备类型
     */
    private String equType;

    /**
     * 设备类型ID
     */
    private Long equModelId;

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

    public String getEquManufact() {
        return equManufact;
    }

    public void setEquManufact(String equManufact) {
        this.equManufact = equManufact;
    }

    public Long getEquEntpId() {
        return equEntpId;
    }

    public void setEquEntpId(Long equEntpId) {
        this.equEntpId = equEntpId;
    }

    public String getEquNum() {
        return equNum;
    }

    public void setEquNum(String equNum) {
        this.equNum = equNum;
    }

    public String getEquType() {
        return equType;
    }

    public void setEquType(String equType) {
        this.equType = equType;
    }

    public Long getEquModelId() {
        return equModelId;
    }

    public void setEquModelId(Long equModelId) {
        this.equModelId = equModelId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
