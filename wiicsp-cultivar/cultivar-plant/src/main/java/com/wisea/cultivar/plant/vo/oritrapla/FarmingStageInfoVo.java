package com.wisea.cultivar.plant.vo.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * FarmingStageListVo
 * 2019/05/27 13:59:47
 */
public class FarmingStageInfoVo {

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long farmingStageId;

    @ApiModelProperty(value = "开始天数")
    private Integer startDays;

    @ApiModelProperty(value = "结束天数")
    private Integer endDays;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "农事类型id")
    private Long farmWorkTypeId;

    @ApiModelProperty(value = "农事要求")
    private String farmingRequire;

    @ApiModelProperty(value = "参考视频")
    private String videoUrl;

    @ApiModelProperty(value = "使用农资")
    private String usAgriculturalMaterials;

    @ApiModelProperty(value = "周期间隔")
    private String cycleInterval;

    @ApiModelProperty(value = "remarks")
    private String remarks;

    @ApiModelProperty(value = "delFlag")
    private String delFlag;

    @ApiModelProperty(value = "农事类型名称")
    private String farmName;


    public Long getFarmingStageId() {
		return farmingStageId;
	}

	public void setFarmingStageId(Long farmingStageId) {
		this.farmingStageId = farmingStageId;
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

	public String getFarmName() {
		return farmName;
	}

	public void setFarmName(String farmName) {
		this.farmName = farmName;
	}
}
