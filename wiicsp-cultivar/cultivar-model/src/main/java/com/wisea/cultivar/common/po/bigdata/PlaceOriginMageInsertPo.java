package com.wisea.cultivar.common.po.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * PlaceOriginMageInsertPo
 * 2019/12/02 11:02:15
 */
public class PlaceOriginMageInsertPo {

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

    /**
     * 获取产地类型
     */
    public String getPlaceOriginType() {
        return placeOriginType;
    }

    /**
     * 设置产地类型
     */
    public void setPlaceOriginType(String placeOriginType) {
        this.placeOriginType = placeOriginType == null ? null : placeOriginType.trim();
    }


    /**
     * 获取产地名称
     */
    public String getPlaceOriginName() {
        return placeOriginName;
    }

    /**
     * 设置产地名称
     */
    public void setPlaceOriginName(String placeOriginName) {
        this.placeOriginName = placeOriginName == null ? null : placeOriginName.trim();
    }

    /**
     * 获取基地类型
     */
    public String getJdType() {
        return jdType;
    }

    /**
     * 设置基地类型
     */
    public void setJdType(String jdType) {
        this.jdType = jdType == null ? null : jdType.trim();
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取种植面积
     */
    public Double getZzmj() {
        return zzmj;
    }

    /**
     * 设置种植面积
     */
    public void setZzmj(Double zzmj) {
        this.zzmj = zzmj;
    }

    /**
     * 获取经度
     */
    public Double getJd() {
        return jd;
    }

    /**
     * 设置经度
     */
    public void setJd(Double jd) {
        this.jd = jd;
    }

    /**
     * 获取纬度
     */
    public Double getWd() {
        return wd;
    }

    /**
     * 设置纬度
     */
    public void setWd(Double wd) {
        this.wd = wd;
    }

    /**
     * 获取产地图片
     */
    public String getPlaceOriginUrl() {
        return placeOriginUrl;
    }

    /**
     * 设置产地图片
     */
    public void setPlaceOriginUrl(String placeOriginUrl) {
        this.placeOriginUrl = placeOriginUrl == null ? null : placeOriginUrl.trim();
    }
}
