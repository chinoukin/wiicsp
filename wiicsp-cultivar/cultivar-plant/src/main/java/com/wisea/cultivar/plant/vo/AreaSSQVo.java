package com.wisea.cultivar.plant.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("查找省市区的vo")
public class AreaSSQVo {

    @ApiModelProperty(value="区域_省名称")
    private String areaCodeProvName;



    @ApiModelProperty(value="区域_市名称")
    private String areaCodeCityName;



    @ApiModelProperty(value="区域_区县名称")
    private String areaCodeCouName;

    public String getAreaCodeProvName() {
        return areaCodeProvName;
    }

    public void setAreaCodeProvName(String areaCodeProvName) {
        this.areaCodeProvName = areaCodeProvName;
    }

    public String getAreaCodeCityName() {
        return areaCodeCityName;
    }

    public void setAreaCodeCityName(String areaCodeCityName) {
        this.areaCodeCityName = areaCodeCityName;
    }

    public String getAreaCodeCouName() {
        return areaCodeCouName;
    }

    public void setAreaCodeCouName(String areaCodeCouName) {
        this.areaCodeCouName = areaCodeCouName;
    }
}
