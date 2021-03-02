package com.wisea.cultivar.common.vo.bigdata;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

@ApiModel("采购类别占比分析Vo")
public class TypeTrendVo {

    @ApiModelProperty("X轴坐标点(日期)")
    private String xPoint;
    @ApiModelProperty("Y轴值(元)")
    private Object yValue;

    @ApiModelProperty("类型")
    private String bType;

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

    public String getbType() {
        return bType;
    }

    public void setbType(String bType) {
        this.bType = bType;
    }
}
