package com.wisea.cultivar.plant.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassNameSerListStateTypeCount
 * @Description
 * @Author zhangbo
 * @Date2020/8/8 15:44
 **/
@ApiModel("服务单不同状态数量")
public class SerListStateTypeCountVo {

    @ApiModelProperty(value="数量")
    private int count;

    @ApiModelProperty(value="服务单状态 0待确认 1待服务 2服务中 3已取消 4已完成")
    private String serListStateType;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getSerListStateType() {
        return serListStateType;
    }

    public void setSerListStateType(String serListStateType) {
        this.serListStateType = serListStateType;
    }
}
