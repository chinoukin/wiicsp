package com.wisea.cultivar.explorer.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author jirg
 * @Date 2020/11/3 16:09
 * @Description
 **/
@ApiModel("大数据查询种植主体或示范基地列表PO")
public class PalntBigDataMapPointsPo {
    @ApiModelProperty(value = "行政区划代码省")
    private String areaProv;
    @ApiModelProperty(value = "行政区划代码市")
    private String areaCity;
    @ApiModelProperty(value = "行政区划代码区县")
    private String areaCou;
    @ApiModelProperty("数据类型：0 种植主体 、1 示范基地 、2 全部")
    @Check(test = "liveable", liveable = {"0", "1", "2"}, liveableMsg = "数据类型错误")
    private String dataType;

    public String getAreaProv() {
        return areaProv;
    }

    public void setAreaProv(String areaProv) {
        this.areaProv = areaProv;
    }

    public String getAreaCity() {
        return areaCity;
    }

    public void setAreaCity(String areaCity) {
        this.areaCity = areaCity;
    }

    public String getAreaCou() {
        return areaCou;
    }

    public void setAreaCou(String areaCou) {
        this.areaCou = areaCou;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}
