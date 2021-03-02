package com.wisea.transac.common.po.product;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Description:
 * @author: wangs
 * @date :2020/4/7
 */
public class CommdityPojoPo {

    @ApiModelProperty("当前登入人的 坐标信息 用逗号分隔 eg:　39.982118,116.341846;前面是纬度 ")
    private String location;
    @ApiModelProperty("以当前登录人为中心点 去匹配的 范围 ")
    private Double range;
    @ApiModelProperty("距离默认传 km ")
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
