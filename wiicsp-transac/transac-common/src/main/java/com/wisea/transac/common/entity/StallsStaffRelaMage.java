package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class StallsStaffRelaMage extends DataLongEntity<StallsStaffRelaMage> {
    /**
     * 档口id
     */
    private Long stallsMageId;

    /**
     * 员工id
     */
    private Long staffInfoMageId;

    /**
     * 停启用状态
     */
    private String effeInvalState;

    /**
     * 关系状态
     */
    private String relaStateType;

    public Long getStallsMageId() {
        return stallsMageId;
    }

    public void setStallsMageId(Long stallsMageId) {
        this.stallsMageId = stallsMageId;
    }

    public Long getStaffInfoMageId() {
        return staffInfoMageId;
    }

    public void setStaffInfoMageId(Long staffInfoMageId) {
        this.staffInfoMageId = staffInfoMageId;
    }

    public String getEffeInvalState() {
        return effeInvalState;
    }

    public void setEffeInvalState(String effeInvalState) {
        this.effeInvalState = effeInvalState;
    }

    public String getRelaStateType() {
        return relaStateType;
    }

    public void setRelaStateType(String relaStateType) {
        this.relaStateType = relaStateType;
    }
}
