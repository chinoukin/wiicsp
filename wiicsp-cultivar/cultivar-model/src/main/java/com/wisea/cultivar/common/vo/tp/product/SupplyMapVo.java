package com.wisea.cultivar.common.vo.tp.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 地图显示返回地城市名称和数量
 * @author: wangs
 * @date :2019/5/31
 */
@ApiModel("地图显示返回地城市名称和数量")
public class SupplyMapVo {

    @ApiModelProperty("城市名称")
    private String name;

    @ApiModelProperty("显示数量")
    private Double value;

    private String cityCode;

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
