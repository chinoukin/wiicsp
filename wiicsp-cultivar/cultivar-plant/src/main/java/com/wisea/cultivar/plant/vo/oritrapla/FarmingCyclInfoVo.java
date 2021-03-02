package com.wisea.cultivar.plant.vo.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * FarmingCycleVo
 * 2019/05/27 13:59:47
 */
public class FarmingCyclInfoVo {

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "种植方法id")
    private Long plantingMethodId;
    @ApiModelProperty(value = "种植周期名称")
    private String cycleName;
    @ApiModelProperty(value = "开始天数")
    private Integer cycleStart;
    @ApiModelProperty(value = "结束天数")
    private Integer cycleEnd;
    @ApiModelProperty(value = "种植阶段")
    private List<FarmingStageInfoVo> farmingStageInfoVo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
		this.cycleName = cycleName;
	}
	public List<FarmingStageInfoVo> getFarmingStageInfoVo() {
		return farmingStageInfoVo;
	}
	public void setFarmingStageInfoVo(List<FarmingStageInfoVo> farmingStageInfoVo) {
		this.farmingStageInfoVo = farmingStageInfoVo;
	}
	public Integer getCycleStart() {
		return cycleStart;
	}
	public void setCycleStart(Integer cycleStart) {
		this.cycleStart = cycleStart;
	}
	public Integer getCycleEnd() {
		return cycleEnd;
	}
	public void setCycleEnd(Integer cycleEnd) {
		this.cycleEnd = cycleEnd;
	}
}
