package com.wisea.cultivar.plant.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("新增或修改SproutCatalogMagePo")
public class SproutCatalogMagePo {
    @ApiModelProperty(value="数据ID，修改时该字段必填")
    private Long id;

    @ApiModelProperty(value="种苗目录名称")
    private String sproutCatalogName;

    @ApiModelProperty(value="年份")
    private Integer sproutYear;

    @ApiModelProperty(value="油茶品种信息id")
    private Long oilTeaVarietId;

    @ApiModelProperty(value="审（认）定良种编号")
    private String sdlzNo;

    @ApiModelProperty(value="适合区域")
    private String fitArea;

    @ApiModelProperty(value="亩产")
    private Double acrePlantCg;

    @ApiModelProperty(value="选育单位")
    private String breedEntp;

    @ApiModelProperty(value="特征特性")
    private String features;

    @ApiModelProperty(value="苗木栽植方式")
    private String plantMode;

    @ApiModelProperty(value="种苗目录状态类型")
    private String sproutCatalogStateType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSproutCatalogName() {
        return sproutCatalogName;
    }

    public void setSproutCatalogName(String sproutCatalogName) {
        this.sproutCatalogName = sproutCatalogName;
    }

    public Integer getSproutYear() {
        return sproutYear;
    }

    public void setSproutYear(Integer sproutYear) {
        this.sproutYear = sproutYear;
    }

    public Long getOilTeaVarietId() {
        return oilTeaVarietId;
    }

    public void setOilTeaVarietId(Long oilTeaVarietId) {
        this.oilTeaVarietId = oilTeaVarietId;
    }

    public String getSdlzNo() {
        return sdlzNo;
    }

    public void setSdlzNo(String sdlzNo) {
        this.sdlzNo = sdlzNo;
    }

    public String getFitArea() {
        return fitArea;
    }

    public void setFitArea(String fitArea) {
        this.fitArea = fitArea;
    }

    public Double getAcrePlantCg() {
        return acrePlantCg;
    }

    public void setAcrePlantCg(Double acrePlantCg) {
        this.acrePlantCg = acrePlantCg;
    }

    public String getBreedEntp() {
        return breedEntp;
    }

    public void setBreedEntp(String breedEntp) {
        this.breedEntp = breedEntp;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getPlantMode() {
        return plantMode;
    }

    public void setPlantMode(String plantMode) {
        this.plantMode = plantMode;
    }

    public String getSproutCatalogStateType() {
        return sproutCatalogStateType;
    }

    public void setSproutCatalogStateType(String sproutCatalogStateType) {
        this.sproutCatalogStateType = sproutCatalogStateType;
    }
}
