package com.wisea.transac.common.entity;


import io.swagger.annotations.ApiModel;

/**
 * @Description:
 * @author: wangs
 * @date :2020/5/14
 */
@ApiModel("查询批发市场的列表 从索引中,传入 {} ")
public class WholeSaleMarkePo extends BaseSearchPojo {
    private String location;
    private Double range;
    private String unit;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getRange() {
        return range;
    }

    public void setRange(Double range) {
        this.range = range;
    }
}
