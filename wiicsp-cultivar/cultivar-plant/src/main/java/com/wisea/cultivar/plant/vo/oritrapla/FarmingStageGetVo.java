package com.wisea.cultivar.plant.vo.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * FarmingStageGetVo
 * 2019/05/27 13:59:47
 */
public class FarmingStageGetVo {
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "farmingCycleId")
    private Long farmingCycleId;

    @ApiModelProperty(value = "startDays")
    private Integer startDays;

    @ApiModelProperty(value = "endDays")
    private Integer endDays;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "farmWorkTypeId")
    private Long farmWorkTypeId;

    @ApiModelProperty(value = "farmingRequire")
    private String farmingRequire;

    @ApiModelProperty(value = "videoUrl")
    private String videoUrl;

    @ApiModelProperty(value = "usAgriculturalMaterials")
    private String usAgriculturalMaterials;

    @ApiModelProperty(value = "cycleInterval")
    private String cycleInterval;

    @ApiModelProperty(value = "remarks")
    private String remarks;

    @ApiModelProperty(value = "delFlag")
    private String delFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFarmingCycleId() {
        return farmingCycleId;
    }

    public void setFarmingCycleId(Long farmingCycleId) {
        this.farmingCycleId = farmingCycleId;
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

    public Long getFarmWorkTypeId() {
        return farmWorkTypeId;
    }

    public void setFarmWorkTypeId(Long farmWorkTypeId) {
        this.farmWorkTypeId = farmWorkTypeId;
    }

    public String getFarmingRequire() {
        return farmingRequire;
    }

    public void setFarmingRequire(String farmingRequire) {
        this.farmingRequire = farmingRequire == null ? null : farmingRequire.trim();
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    public String getUsAgriculturalMaterials() {
        return usAgriculturalMaterials;
    }

    public void setUsAgriculturalMaterials(String usAgriculturalMaterials) {
        this.usAgriculturalMaterials = usAgriculturalMaterials == null ? null : usAgriculturalMaterials.trim();
    }

    public String getCycleInterval() {
        return cycleInterval;
    }

    public void setCycleInterval(String cycleInterval) {
        this.cycleInterval = cycleInterval == null ? null : cycleInterval.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}
