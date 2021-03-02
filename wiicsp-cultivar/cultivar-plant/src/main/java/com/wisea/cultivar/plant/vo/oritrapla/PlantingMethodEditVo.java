package com.wisea.cultivar.plant.vo.oritrapla;

import com.wisea.cultivar.plant.entity.oritrapla.FarmingCycle;
import com.wisea.cultivar.plant.entity.oritrapla.PlantingMethod;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Author:Liangzy(Wisea)
 * @Date:Create in 2019-05-28 16:38
 * @Description:种植方法编辑按钮定制VO
 */
public class PlantingMethodEditVo {

    @ApiModelProperty(value = "种植方法")
    private PlantingMethod plantingMethod;

    @ApiModelProperty(value = "农事周期")
    private List<FarmingCycle> farmingCycle;

    private List<PlantingMethodTableVo> tables;

    public List<PlantingMethodTableVo> getTables() {
        return tables;
    }

    public void setTables(List<PlantingMethodTableVo> tables) {
        this.tables = tables;
    }

    public PlantingMethod getPlantingMethod() {
        return plantingMethod;
    }

    public void setPlantingMethod(PlantingMethod plantingMethod) {
        this.plantingMethod = plantingMethod;
    }

    public List<FarmingCycle> getFarmingCycle() {
        return farmingCycle;
    }

    public void setFarmingCycle(List<FarmingCycle> farmingCycle) {
        this.farmingCycle = farmingCycle;
    }
}
