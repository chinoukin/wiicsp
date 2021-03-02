package com.wisea.cultivar.common.vo.bigdata;

import io.swagger.annotations.ApiModelProperty;

/**
 * JydzMageListVo
 * 2019/12/02 14:39:38
 */
public class JydzMageListVo {
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "是否开启")
    private String sfkqFlag;
    @ApiModelProperty(value = "自动更新时间")
    private Integer zddzDate;
    @ApiModelProperty(value = "自动递增小")
    private Integer zddzMin;
    @ApiModelProperty(value = "自动递增大")
    private Integer zddzMax;
    @ApiModelProperty(value = "已递增金额")
    private Double ydiJe;
    @ApiModelProperty(value = "国外是否开启")
    private String gwSfkqFlag;
    @ApiModelProperty(value = "国外自动更新时间")
    private Integer gwZddzDate;
    @ApiModelProperty(value = "国外自动递增小")
    private Integer gwZddzMin;
    @ApiModelProperty(value = "国外自动递增大")
    private Integer gwZddzMax;
    @ApiModelProperty(value = "国外已递增金额")
    private Double gwYdiJe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSfkqFlag() {
        return sfkqFlag;
    }

    public void setSfkqFlag(String sfkqFlag) {
        this.sfkqFlag = sfkqFlag;
    }

    public Integer getZddzDate() {
        return zddzDate;
    }

    public void setZddzDate(Integer zddzDate) {
        this.zddzDate = zddzDate;
    }

    public Integer getZddzMin() {
        return zddzMin;
    }

    public void setZddzMin(Integer zddzMin) {
        this.zddzMin = zddzMin;
    }

    public Integer getZddzMax() {
        return zddzMax;
    }

    public void setZddzMax(Integer zddzMax) {
        this.zddzMax = zddzMax;
    }

    public Double getYdiJe() {
        return ydiJe;
    }

    public void setYdiJe(Double ydiJe) {
        this.ydiJe = ydiJe;
    }

    public String getGwSfkqFlag() {
        return gwSfkqFlag;
    }

    public void setGwSfkqFlag(String gwSfkqFlag) {
        this.gwSfkqFlag = gwSfkqFlag;
    }

    public Integer getGwZddzDate() {
        return gwZddzDate;
    }

    public void setGwZddzDate(Integer gwZddzDate) {
        this.gwZddzDate = gwZddzDate;
    }

    public Integer getGwZddzMin() {
        return gwZddzMin;
    }

    public void setGwZddzMin(Integer gwZddzMin) {
        this.gwZddzMin = gwZddzMin;
    }

    public Integer getGwZddzMax() {
        return gwZddzMax;
    }

    public void setGwZddzMax(Integer gwZddzMax) {
        this.gwZddzMax = gwZddzMax;
    }

    public Double getGwYdiJe() {
        return gwYdiJe;
    }

    public void setGwYdiJe(Double gwYdiJe) {
        this.gwYdiJe = gwYdiJe;
    }
}
