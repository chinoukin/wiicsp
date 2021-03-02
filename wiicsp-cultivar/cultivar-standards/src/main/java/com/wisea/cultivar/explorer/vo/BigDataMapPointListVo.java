package com.wisea.cultivar.explorer.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className BigDataBaseListVo
 * @date 2020/9/2 14:22
 * @Description 大数据 - 种植大数据 - 基地列表VO
 */
@ApiModel("基地列表VO")
public class BigDataMapPointListVo {
    @ApiModelProperty("数据ID")
    private Long id;
    @ApiModelProperty("数据类型：0 种植主体 、1 示范基地 、2 种植主体地块 、3 示范基地地块")
    private String dataType;
    @ApiModelProperty("基地/地块名称")
    private String name;
    @ApiModelProperty("所在位置")
    private String location;
    @ApiModelProperty(value = "行政区划代码省")
    private String areaProv;
    @ApiModelProperty(value = "行政区划代码市")
    private String areaCity;
    @ApiModelProperty(value = "行政区划代码区县")
    private String areaCou;
    @ApiModelProperty("种植面积")
    private Double plantArea;
    @ApiModelProperty("经度")
    private Double jd;
    @ApiModelProperty("纬度")
    private Double wd;
    @ApiModelProperty("地块坐标点集合（地块所有）")
    private String coordPointExpres;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getPlantArea() {
        return plantArea;
    }

    public void setPlantArea(Double plantArea) {
        this.plantArea = plantArea;
    }

    public Double getJd() {
        return jd;
    }

    public void setJd(Double jd) {
        this.jd = jd;
    }

    public Double getWd() {
        return wd;
    }

    public void setWd(Double wd) {
        this.wd = wd;
    }

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

    public String getCoordPointExpres() {
        return coordPointExpres;
    }

    public void setCoordPointExpres(String coordPointExpres) {
        this.coordPointExpres = coordPointExpres;
    }
}
