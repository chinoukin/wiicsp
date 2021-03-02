package com.wisea.cultivar.plant.entity.oritrapla;

import com.wisea.cloud.common.entity.DataLongEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * farming_cycle 表实体
 * 农事周期
 * 2019/05/27 13:59:47
 */
public class FarmingCycle extends DataLongEntity<FarmingCycle> {
    private static final long serialVersionUID = 1L;

    private Long plantingMethodId;

    private String cycleName;

    private Integer startDays;

    private Integer endDays;

    @ApiModelProperty(value = "农事阶段")
    private List<FarmingStage> farmingStage;

    public List<FarmingStage> getFarmingStage() {
        return farmingStage;
    }

    public void setFarmingStage(List<FarmingStage> farmingStage) {
        this.farmingStage = farmingStage;
    }

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
}
