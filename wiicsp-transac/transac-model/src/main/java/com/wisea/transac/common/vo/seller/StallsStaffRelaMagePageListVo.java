package com.wisea.transac.common.vo.seller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页查询Vo")
public class StallsStaffRelaMagePageListVo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="档口id")
    private Long stallsMageId;

    @ApiModelProperty(value="员工id")
    private Long staffInfoMageId;

    @ApiModelProperty(value="停启用状态")
    private String effeInvalState;

    @ApiModelProperty(value="关系状态")
    private String relaStateType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
