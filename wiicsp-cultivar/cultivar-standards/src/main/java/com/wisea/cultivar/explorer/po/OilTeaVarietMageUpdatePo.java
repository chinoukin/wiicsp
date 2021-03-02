package com.wisea.cultivar.explorer.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * OilTeaVarietMageUpdatePo
 * 2020/07/24 11:21:45
 */
public class OilTeaVarietMageUpdatePo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "required" })
    @ApiModelProperty(value = "id", required = true)
    private Long id;

    /**
     * 选育单位
     */
    @ApiModelProperty(value = "选育单位")
    private String breedEntp;

    public String getBreedEntp() {
        return breedEntp;
    }

    public void setBreedEntp(String breedEntp) {
        this.breedEntp = breedEntp;
    }
    /**
     * 品种名称
     */
    @Check(test = {"required", "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "品种名称", allowableValues = "mixLength:(,30]")
    private String oilTeaVarietName;

    /**
     * 品种编号
     */
    @Check(test = {"required", "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "品种编号", allowableValues = "mixLength:(,30]")
    private String oilTeaVarietNo;

    /**
     * 图片url
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "图片url", allowableValues = "mixLength:(,255]")
    private String url;

    /**
     * 亩种植数
     */
    @Check(test = { "regex" }, regex = "^S+$|^\\s*$|^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "亩种植数", allowableValues = "regex:^S+$|^\\s*$|^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double acrePlantNum;

    /**
     * 亩均产果
     */
    @Check(test = { "regex" }, regex = "^S+$|^\\s*$|^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "亩均产果", allowableValues = "regex:^S+$|^\\s*$|^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double acrePlantCg;

    /**
     * 亩均产籽
     */
    @Check(test = { "regex" }, regex = "^S+$|^\\s*$|^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "亩均产籽", allowableValues = "regex:^S+$|^\\s*$|^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double acrePlantCz;

    /**
     * 亩均产油
     */
    @Check(test = { "regex" }, regex = "^S+$|^\\s*$|^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "亩均产油", allowableValues = "^S+$|^\\s*$|^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double acrePlantCy;

    /**
     * 适合区域
     */
    @Check(test = { "maxLength" }, mixLength = 600)
    @ApiModelProperty(value = "适合区域", allowableValues = "mixLength:(,600]")
    private String fitAre;

    /**
     * 特征特性
     */
    @Check(test = { "maxLength" }, mixLength = 600)
    @ApiModelProperty(value = "特征特性", allowableValues = "mixLength:(,600]")
    private String features;

    /**
     * 栽植方式
     */
    @Check(test = { "maxLength" }, mixLength = 600)
    @ApiModelProperty(value = "栽植方式", allowableValues = "mixLength:(,600]")
    private String plantMode;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    /**
     * 删除标记
     */
    @Check(test = { "maxLength" }, mixLength = 1)
    @ApiModelProperty(value = "删除标记", allowableValues = "mixLength:(,1]")
    private String delFlag;

    /**
     * 获取id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取品种名称
     */
    public String getOilTeaVarietName() {
        return oilTeaVarietName;
    }

    /**
     * 设置品种名称
     */
    public void setOilTeaVarietName(String oilTeaVarietName) {
        this.oilTeaVarietName = oilTeaVarietName == null ? null : oilTeaVarietName.trim();
    }

    /**
     * 获取品种编号
     */
    public String getOilTeaVarietNo() {
        return oilTeaVarietNo;
    }

    /**
     * 设置品种编号
     */
    public void setOilTeaVarietNo(String oilTeaVarietNo) {
        this.oilTeaVarietNo = oilTeaVarietNo == null ? null : oilTeaVarietNo.trim();
    }

    /**
     * 获取图片url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置图片url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取亩种植数
     */
    public Double getAcrePlantNum() {
        return acrePlantNum;
    }

    /**
     * 设置亩种植数
     */
    public void setAcrePlantNum(Double acrePlantNum) {
        this.acrePlantNum = acrePlantNum;
    }

    /**
     * 获取亩均产果
     */
    public Double getAcrePlantCg() {
        return acrePlantCg;
    }

    /**
     * 设置亩均产果
     */
    public void setAcrePlantCg(Double acrePlantCg) {
        this.acrePlantCg = acrePlantCg;
    }

    /**
     * 获取亩均产籽
     */
    public Double getAcrePlantCz() {
        return acrePlantCz;
    }

    /**
     * 设置亩均产籽
     */
    public void setAcrePlantCz(Double acrePlantCz) {
        this.acrePlantCz = acrePlantCz;
    }

    /**
     * 获取亩均产油
     */
    public Double getAcrePlantCy() {
        return acrePlantCy;
    }

    /**
     * 设置亩均产油
     */
    public void setAcrePlantCy(Double acrePlantCy) {
        this.acrePlantCy = acrePlantCy;
    }

    /**
     * 获取适合区域
     */
    public String getFitAre() {
        return fitAre;
    }

    /**
     * 设置适合区域
     */
    public void setFitAre(String fitAre) {
        this.fitAre = fitAre == null ? null : fitAre.trim();
    }

    /**
     * 获取特征特性
     */
    public String getFeatures() {
        return features;
    }

    /**
     * 设置特征特性
     */
    public void setFeatures(String features) {
        this.features = features == null ? null : features.trim();
    }

    /**
     * 获取栽植方式
     */
    public String getPlantMode() {
        return plantMode;
    }

    /**
     * 设置栽植方式
     */
    public void setPlantMode(String plantMode) {
        this.plantMode = plantMode == null ? null : plantMode.trim();
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

    /**
     * 获取删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}
