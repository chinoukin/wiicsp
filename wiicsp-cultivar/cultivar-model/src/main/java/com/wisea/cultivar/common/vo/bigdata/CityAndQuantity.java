package com.wisea.cultivar.common.vo.bigdata;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassNameCityAndQuantity
 * @Description
 * @Author zhangbo
 * @Date2020/9/3 10:23
 **/
@ApiModel("城市和数量")
public class CityAndQuantity {

    @ApiModelProperty(value="数量")
    private Double quantity;

    @ApiModelProperty(value="城市名称")
    private String cityName;

    @ApiModelProperty(value="合格占比")
    private String passRate;

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getPassRate() {
        return passRate;
    }

    public void setPassRate(String passRate) {
        this.passRate = passRate;
    }

}
