package com.wisea.cultivar.plant.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class OilTeaVarietMage extends DataLongEntity<OilTeaVarietMage> {
    /**
     * 品种名称
     */
    private String oilTeaVarietName;

    /**
     * 品种编号
     */
    private String oilTeaVarietNo;

    /**
     * 图片url
     */
    private String url;

    /**
     * 亩种植数
     */
    private Double acrePlantNum;

    /**
     * 亩均产果
     */
    private Double acrePlantCg;

    /**
     * 亩均产籽
     */
    private Double acrePlantCz;

    /**
     * 亩均产油
     */
    private Double acrePlantCy;

    /**
     * 适合区域
     */
    private String fitAre;

    /**
     * 特征特性
     */
    private String features;

    /**
     * 栽植方式
     */
    private String plantMode;

    /**
     * 名称首字母
     */
    private String initials;

    /**
     * 选育单位
     */
    private String breedEntp;

    public String getOilTeaVarietName() {
        return oilTeaVarietName;
    }

    public void setOilTeaVarietName(String oilTeaVarietName) {
        this.oilTeaVarietName = oilTeaVarietName;
    }

    public String getOilTeaVarietNo() {
        return oilTeaVarietNo;
    }

    public void setOilTeaVarietNo(String oilTeaVarietNo) {
        this.oilTeaVarietNo = oilTeaVarietNo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getAcrePlantNum() {
        return acrePlantNum;
    }

    public void setAcrePlantNum(Double acrePlantNum) {
        this.acrePlantNum = acrePlantNum;
    }

    public Double getAcrePlantCg() {
        return acrePlantCg;
    }

    public void setAcrePlantCg(Double acrePlantCg) {
        this.acrePlantCg = acrePlantCg;
    }

    public Double getAcrePlantCz() {
        return acrePlantCz;
    }

    public void setAcrePlantCz(Double acrePlantCz) {
        this.acrePlantCz = acrePlantCz;
    }

    public Double getAcrePlantCy() {
        return acrePlantCy;
    }

    public void setAcrePlantCy(Double acrePlantCy) {
        this.acrePlantCy = acrePlantCy;
    }

    public String getFitAre() {
        return fitAre;
    }

    public void setFitAre(String fitAre) {
        this.fitAre = fitAre;
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

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getBreedEntp() {
        return breedEntp;
    }

    public void setBreedEntp(String breedEntp) {
        this.breedEntp = breedEntp;
    }
}
