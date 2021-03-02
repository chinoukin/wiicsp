package com.wisea.cultivar.plant.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("BuySproutInfo详细信息Vo")
public class BuySproutInfoInfoVo {
    @ApiModelProperty(value="补贴申请管理id")
    private Long subsidyApplMageId;

    @ApiModelProperty(value="服务单id")
    private Long serListId;

    public Long getSubsidyApplMageId() {
        return subsidyApplMageId;
    }

    public void setSubsidyApplMageId(Long subsidyApplMageId) {
        this.subsidyApplMageId = subsidyApplMageId;
    }

    public Long getSerListId() {
        return serListId;
    }

    public void setSerListId(Long serListId) {
        this.serListId = serListId;
    }
}
