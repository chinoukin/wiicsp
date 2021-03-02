package com.wisea.cultivar.plant.po.oritrapla;
import com.wisea.cultivar.plant.entity.oritrapla.FarmingCycle;
import com.wisea.cultivar.plant.entity.oritrapla.PlantingMethod;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Author:Liangzy(Wisea)
 * @Date:Create in 2019-05-28 14:19
 * @Description:添加种植方法的定制PO
 */
public class InsertPlantingMethodPo {

    @ApiModelProperty(value = "请求类型", notes = "0:添加种植方法;1:修改种植方法")
    private String requestType;

    @ApiModelProperty(value = "农事周期")
    private List<FarmingCycle> farmingCycle;

    @ApiModelProperty(value = "种植方法")
    private PlantingMethod plantingMethod;

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

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }
}
