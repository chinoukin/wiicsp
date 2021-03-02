package com.wisea.cultivar.explorer.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * oil_tea_variet_mage 表实体
 * 油茶品种信息维护
 * 2020/07/24 11:21:45
 */
public class OilTeaVarietMage extends DataLongEntity<OilTeaVarietMage> {
    private static final long serialVersionUID = 1L;

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
     * 选育单位
     */
    private String breedEntp;

    /**
     * 字母
     */
    private String initials;
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

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    /**
     * 栽植方式
     */
    private String plantMode;

    public String getBreedEntp() {
        return breedEntp;
    }

    public void setBreedEntp(String breedEntp) {
        this.breedEntp = breedEntp;
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
}
