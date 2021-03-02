package com.wisea.cultivar.common.po.bigdata;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * JydzMageInsertPo
 * 2019/12/02 14:39:38
 */
public class JydzMageInsertPo {
    @ApiModelProperty("数据ID，修改时非空")
    private Long id;
    @Check(test = { "maxLength", "required" }, mixLength = 5)
    @ApiModelProperty(value = "是否开启", allowableValues = "mixLength:(,5]")
    private String sfkqFlag;
    @Check(test = {"maxLength", "logic"}, length = 10, logic = "'1'.equals(#sfkqFlag)?#isNotEmpty(#zddzDate):true")
    @ApiModelProperty(value = "自动更新时间", allowableValues = "length:(,10]")
    private Integer zddzDate;
    @Check(test = { "maxLength" }, length = 10, logic = "'1'.equals(#sfkqFlag)?#isNotEmpty(#zddzMin):true")
    @ApiModelProperty(value = "自动递增小", allowableValues = "length:(,10]")
    private Integer zddzMin;
    @Check(test = { "maxLength" }, length = 10, logic = "'1'.equals(#sfkqFlag)?#isNotEmpty(#zddzMax):true")
    @ApiModelProperty(value = "自动递增大", allowableValues = "length:(,10]")
    private Integer zddzMax;
    @Check(test = {"maxLength", "required"}, mixLength = 5)
    @ApiModelProperty(value = "国外是否开启", allowableValues = "mixLength:(,5]")
    private String gwSfkqFlag;
    @Check(test = { "maxLength" }, length = 10, logic = "'1'.equals(#gwSfkqFlag)?#isNotEmpty(#gwZddzDate):true")
    @ApiModelProperty(value = "国外自动更新时间", allowableValues = "length:(,10]")
    private Integer gwZddzDate;
    @Check(test = { "maxLength" }, length = 10, logic = "'1'.equals(#gwSfkqFlag)?#isNotEmpty(#gwZddzMin):true")
    @ApiModelProperty(value = "国外自动递增小", allowableValues = "length:(,10]")
    private Integer gwZddzMin;
    @Check(test = { "maxLength" }, length = 10, logic = "'1'.equals(#gwSfkqFlag)?#isNotEmpty(#gwZddzMax):true")
    @ApiModelProperty(value = "国外自动递增大", allowableValues = "length:(,10]")
    private Integer gwZddzMax;

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
}
