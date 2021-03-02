package com.wisea.equipment.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class EquModelMage extends DataLongEntity<EquModelMage> {
    /**
     * 设备厂商id
     */
    private Long equEntpId;

    /**
     * 设备型号
     */
    private String equModel;

    /**
     * 设备类型
     */
    private String equType;

    /**
     * 接口访问地址
     */
    private String url;

    public Long getEquEntpId() {
        return equEntpId;
    }

    public void setEquEntpId(Long equEntpId) {
        this.equEntpId = equEntpId;
    }

    public String getEquModel() {
        return equModel;
    }

    public void setEquModel(String equModel) {
        this.equModel = equModel;
    }

    public String getEquType() {
        return equType;
    }

    public void setEquType(String equType) {
        this.equType = equType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}