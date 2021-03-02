package com.wisea.equipment.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class EquInfo extends DataLongEntity<EquInfo> {
    /**
     * 设备名称
     */
    private String equName;

    /**
     * 设备厂商ID
     */
    private Long equEntpId;

    /**
     * 设备型号ID
     */
    private Long equModelId;

    /**
     * 设备编号
     */
    private String equNum;

    /**
     * 生产序列号
     */
    private String psn;

    /**
     * 扩展字段1
     */
    private String extFirst;

    /**
     * 扩展字段2
     */
    private String extSecond;

    public String getEquName() {
        return equName;
    }

    public void setEquName(String equName) {
        this.equName = equName;
    }

    public Long getEquEntpId() {
        return equEntpId;
    }

    public void setEquEntpId(Long equEntpId) {
        this.equEntpId = equEntpId;
    }

    public Long getEquModelId() {
        return equModelId;
    }

    public void setEquModelId(Long equModelId) {
        this.equModelId = equModelId;
    }

    public String getEquNum() {
        return equNum;
    }

    public void setEquNum(String equNum) {
        this.equNum = equNum;
    }

    public String getPsn() {
        return psn;
    }

    public void setPsn(String psn) {
        this.psn = psn;
    }

    public String getExtFirst() {
        return extFirst;
    }

    public void setExtFirst(String extFirst) {
        this.extFirst = extFirst;
    }

    public String getExtSecond() {
        return extSecond;
    }

    public void setExtSecond(String extSecond) {
        this.extSecond = extSecond;
    }
}