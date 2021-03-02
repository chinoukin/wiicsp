package com.wisea.cultivar.plant.vo.oritrapla;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author:Liangzy(Wisea)
 * @Date:Create in 2019-05-28 17:51
 * @Description:APP端种植方法表格
 */
public class PlantingMethodTableVo {

    @ApiModelProperty(value = "时间")
    private Integer time;

    @ApiModelProperty(value = "周期名称")
    private String cycleName;

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getCycleName() {
        return cycleName;
    }

    public void setCycleName(String cycleName) {
        this.cycleName = cycleName;
    }
}
