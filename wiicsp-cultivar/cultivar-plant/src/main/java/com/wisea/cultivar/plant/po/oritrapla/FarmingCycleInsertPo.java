package com.wisea.cultivar.plant.po.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * FarmingCycleInsertPo
 * 2019/05/27 13:59:47
 */
public class FarmingCycleInsertPo {
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "plantingMethodId")
    private Long plantingMethodId;

    @Check(test = { "maxLength" }, mixLength = 100)
    @ApiModelProperty(value = "cycleName")
    private String cycleName;

    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "startDays")
    private Integer startDays;

    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "endDays")
    private Integer endDays;

    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "remarks")
    private String remarks;

    public Long getPlantingMethodId() {
        return plantingMethodId;
    }

    public void setPlantingMethodId(Long plantingMethodId) {
        this.plantingMethodId = plantingMethodId;
    }

    public String getCycleName() {
        return cycleName;
    }

    public void setCycleName(String cycleName) {
        this.cycleName = cycleName == null ? null : cycleName.trim();
    }

    public Integer getStartDays() {
        return startDays;
    }

    public void setStartDays(Integer startDays) {
        this.startDays = startDays;
    }

    public Integer getEndDays() {
        return endDays;
    }

    public void setEndDays(Integer endDays) {
        this.endDays = endDays;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}
