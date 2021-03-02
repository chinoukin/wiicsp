package com.wisea.cultivar.explorer.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * IndustryLayerInfoInsertPo
 * 2020/08/11 13:21:46
 */
public class IndustryLayerInfoInsertPo {
    /**
     * 图层名称
     */
    @Check(test = {"required", "minLength", "maxLength" }, lengthRange = { 2, 200 })
    @ApiModelProperty(value = "图层名称" )
    private String industryLayerName;

    /**
     * 图层介绍
     */
//    @Check(test = { "maxLength" }, mixLength = 300)
    @ApiModelProperty(value = "图层介绍" )
    private String industryLayerIntroduce;

    /**
     * 联系人
     */
    @ApiModelProperty(value = "联系人", allowableValues = "mixLength:(,20]")
    private String conter;

    /**
     * 联系人手机号
     */
    @Check(test = { "minLength", "minLength", "maxLength" }, lengthRange = { 11, 11 },regex = "^[0-9]$",nullSkip = true)
    @ApiModelProperty(value = "联系人手机号", allowableValues = "mixLength:(11,11]")
    private String contTel;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    /**
     * 获取图层名称
     */
    public String getIndustryLayerName() {
        return industryLayerName;
    }

    /**
     * 设置图层名称
     */
    public void setIndustryLayerName(String industryLayerName) {
        this.industryLayerName = industryLayerName == null ? null : industryLayerName.trim();
    }

    /**
     * 获取图层介绍
     */
    public String getIndustryLayerIntroduce() {
        return industryLayerIntroduce;
    }

    /**
     * 设置图层介绍
     */
    public void setIndustryLayerIntroduce(String industryLayerIntroduce) {
        this.industryLayerIntroduce = industryLayerIntroduce == null ? null : industryLayerIntroduce.trim();
    }

    /**
     * 获取联系人
     */
    public String getConter() {
        return conter;
    }

    /**
     * 设置联系人
     */
    public void setConter(String conter) {
        this.conter = conter == null ? null : conter.trim();
    }

    /**
     * 获取联系人手机号
     */
    public String getContTel() {
        return contTel;
    }

    /**
     * 设置联系人手机号
     */
    public void setContTel(String contTel) {
        this.contTel = contTel == null ? null : contTel.trim();
    }

    /**
     * 获取备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}
