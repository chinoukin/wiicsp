package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class StallsVideoMage extends DataLongEntity<StallsVideoMage> {
    /**
     * 档口id
     */
    private Long stallsMageId;

    /**
     * 所属档口
     */
    private String belongStalls;

    /**
     * 名称
     */
    private String name;

    /**
     * 接入地址
     */
    private String accUrl;

    /**
     * 是否设为封面标志
     */
    private String setAsCoverFlag;

    public Long getStallsMageId() {
        return stallsMageId;
    }

    public void setStallsMageId(Long stallsMageId) {
        this.stallsMageId = stallsMageId;
    }

    public String getBelongStalls() {
        return belongStalls;
    }

    public void setBelongStalls(String belongStalls) {
        this.belongStalls = belongStalls;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccUrl() {
        return accUrl;
    }

    public void setAccUrl(String accUrl) {
        this.accUrl = accUrl;
    }

    public String getSetAsCoverFlag() {
        return setAsCoverFlag;
    }

    public void setSetAsCoverFlag(String setAsCoverFlag) {
        this.setAsCoverFlag = setAsCoverFlag;
    }
}
