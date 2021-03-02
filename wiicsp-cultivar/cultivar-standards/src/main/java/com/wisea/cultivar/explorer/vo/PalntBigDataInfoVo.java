package com.wisea.cultivar.explorer.vo;

import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className PalntBigDataInfoVo
 * @date 2020/9/2 16:11
 * @Description 基地/地块详细信息
 */
public class PalntBigDataInfoVo {
    @ApiModelProperty("数据ID")
    private Long id;
    @ApiModelProperty("数据类型")
    private String dataType;
    @ApiModelProperty("基地/地块名称")
    private String name;
    @ApiModelProperty("所在位置")
    private String location;
    @ApiModelProperty("主体名称")
    private String entpName;
    @ApiModelProperty("种植面积")
    private Double plantArea;
    @ApiModelProperty(value = "行政区划代码省")
    private String areaProv;

    @ApiModelProperty(value = "行政区划代码市")
    private String areaCity;

    @ApiModelProperty(value = "行政区划代码区县")
    private String areaCou;
    /********示范基地*********/
    @ApiModelProperty("示范基地 - 主体720巡场")
    private String fieldAddress;
    @ApiModelProperty("示范基地 - 基地详细介绍列表")
    private List<DemonsBaseIntroduceListVo> demonsBaseIntroduces;

    /********种植主体*********/
    @ApiModelProperty("种植主体 - 地址")
    private String entpAddress;
    @ApiModelProperty("种植主体 - 介绍")
    private String entpIntroduce;
    @ApiModelProperty(value = "种植主体 - 统一社会信用代码")
    private String ctscc;
    @ApiModelProperty(value = "种植主体 - 企业类型")
    private String entpType;
    @ApiModelProperty(value = "种植主体 - 联系人")
    private String conter;
    @ApiModelProperty(value = "种植主体 - 联系方式")
    private String contTel;

    /********地块*********/
    @ApiModelProperty(value = "地块 - 播种时间")
    private OffsetDateTime bzDate;
    @ApiModelProperty(value = "地块 - 种植品种")
    private String commName;

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

    public String getEntpName() {
        return entpName;
    }

    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }

    public Double getPlantArea() {
        return plantArea;
    }

    public void setPlantArea(Double plantArea) {
        this.plantArea = plantArea;
    }

    public String getFieldAddress() {
        return fieldAddress;
    }

    public void setFieldAddress(String fieldAddress) {
        this.fieldAddress = fieldAddress;
    }

    public List<DemonsBaseIntroduceListVo> getDemonsBaseIntroduces() {
        return demonsBaseIntroduces;
    }

    public void setDemonsBaseIntroduces(List<DemonsBaseIntroduceListVo> demonsBaseIntroduces) {
        this.demonsBaseIntroduces = demonsBaseIntroduces;
    }

    public String getEntpAddress() {
        return entpAddress;
    }

    public void setEntpAddress(String entpAddress) {
        this.entpAddress = entpAddress;
    }

    public String getEntpIntroduce() {
        return entpIntroduce;
    }

    public void setEntpIntroduce(String entpIntroduce) {
        this.entpIntroduce = entpIntroduce;
    }

    public String getCtscc() {
        return ctscc;
    }

    public void setCtscc(String ctscc) {
        this.ctscc = ctscc;
    }

    public String getEntpType() {
        return entpType;
    }

    public void setEntpType(String entpType) {
        this.entpType = entpType;
    }

    public String getConter() {
        return conter;
    }

    public void setConter(String conter) {
        this.conter = conter;
    }

    public String getContTel() {
        return contTel;
    }

    public void setContTel(String contTel) {
        this.contTel = contTel;
    }

    public OffsetDateTime getBzDate() {
        return bzDate;
    }

    public void setBzDate(OffsetDateTime bzDate) {
        this.bzDate = bzDate;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }
}
