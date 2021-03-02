package com.wisea.cultivar.common.vo.tp.statistics;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 订单数量统计图表数据VO
 */
@ApiModel("统计图表数据VO")
public class ChartVo {
    @ApiModelProperty("X轴坐标点")
    private String xPoint;
    @ApiModelProperty("Y轴值")
    private Object yValue;

    public String getxPoint() {
        return xPoint;
    }

    public void setxPoint(String xPoint) {
        this.xPoint = xPoint;
    }

    public Object getyValue() {
        return yValue;
    }

    public void setyValue(Object yValue) {
        this.yValue = yValue;
    }
}
