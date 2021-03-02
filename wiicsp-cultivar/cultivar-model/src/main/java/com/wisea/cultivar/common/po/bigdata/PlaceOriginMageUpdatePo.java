package com.wisea.cultivar.common.po.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * PlaceOriginMageUpdatePo
 * 2019/12/02 11:02:15
 */
public class PlaceOriginMageUpdatePo {

    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "required" })
    @ApiModelProperty(value = "产地id", required = true)
    private Long id;
    @Check(test = { "maxLength", "required"}, mixLength = 5)
    @ApiModelProperty(value = "产地类型(国内国外)", allowableValues = "mixLength:(,5]")
    private String placeOriginType;
    @Check(test = { "maxLength" , "required"}, mixLength = 255)
    @ApiModelProperty(value = "产地名称", allowableValues = "mixLength:(,255]")
    private String placeOriginName;
    @Check(test = { "maxLength" , "required"}, mixLength = 100)
    @ApiModelProperty(value = "所在区域", allowableValues = "mixLength:(,100]")
    private String locationType;
    @Check(test = { "maxLength" , "required"}, mixLength = 5)
    @ApiModelProperty(value = "基地类型（产地类型）", allowableValues = "mixLength:(,5]")
    private String jdType;
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" , "required"}, length = 19)
    @ApiModelProperty(value = "主要品种", allowableValues = "length:(,19]")
    private Long categoryId;
    @Check(test = { "regex" , "required"}, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "种植面积", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double zzmj;
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "经度", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double jd;
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "纬度", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double wd;
    @Check(test = {"required", "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "产地图片", allowableValues = "mixLength:(,255]")
    private String placeOriginUrl;
//    @ApiModelProperty(value = "产地详情")
//    private List<PlaceOriginXqMage> placeOriginXqMage;
//    @ApiModelProperty(value = "已选企业")
//    private List<YxEntp> yxEntp;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPlaceOriginType() {
        return placeOriginType;
    }
    public void setPlaceOriginType(String placeOriginType) {
        this.placeOriginType = placeOriginType;
    }
    public String getPlaceOriginName() {
        return placeOriginName;
    }
    public void setPlaceOriginName(String placeOriginName) {
        this.placeOriginName = placeOriginName;
    }
    public String getLocationType() {
        return locationType;
    }
    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }
    public String getJdType() {
        return jdType;
    }
    public void setJdType(String jdType) {
        this.jdType = jdType;
    }
    public Long getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    public Double getZzmj() {
        return zzmj;
    }
    public void setZzmj(Double zzmj) {
        this.zzmj = zzmj;
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
    public String getPlaceOriginUrl() {
        return placeOriginUrl;
    }
    public void setPlaceOriginUrl(String placeOriginUrl) {
        this.placeOriginUrl = placeOriginUrl;
    }
//    public List<PlaceOriginXqMage> getPlaceOriginXqMage() {
//        return placeOriginXqMage;
//    }
//    public void setPlaceOriginXqMage(List<PlaceOriginXqMage> placeOriginXqMage) {
//        this.placeOriginXqMage = placeOriginXqMage;
//    }
//    public List<YxEntp> getYxEntp() {
//        return yxEntp;
//    }
//    public void setYxEntp(List<YxEntp> yxEntp) {
//        this.yxEntp = yxEntp;
//    }
}
