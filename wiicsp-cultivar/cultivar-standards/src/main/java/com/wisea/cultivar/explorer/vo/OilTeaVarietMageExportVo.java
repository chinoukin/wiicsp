package com.wisea.cultivar.explorer.vo;

import com.wisea.cloud.common.util.excel.annotation.ExcelField;

import java.io.Serializable;

public class OilTeaVarietMageExportVo implements Serializable{
    /**
    * 品种名称
    */
    @ExcelField(title = "品种名称")
    private String oilTeaVarietName;

    /**
    * 品种编号
    */
    @ExcelField(title = "品种编号")
    private String oilTeaVarietNo;


    /**
    * 亩种植数
    */
    @ExcelField(title = "亩种植(株)")
    private Double acrePlantNum;

    /**
    * 亩均产果
    */
    @ExcelField(title = "亩均产果(kg)")
    private Double acrePlantCg;

    /**
    * 亩均产籽
    */
    @ExcelField(title = "亩均产籽(kg)")
    private Double acrePlantCz;

    /**
    * 亩均产油
    */
    @ExcelField(title = "亩均产油(kg)")
    private Double acrePlantCy;

    /**
    * 适合区域
    */
    @ExcelField(title = "适合区域")
    private String fitAre;

    /**
    * 特征特性
    */
    @ExcelField(title = "特征特性")
    private String features;

    /**
    * 栽植方式
    */
    @ExcelField(title = "栽植方式")
    private String plantMode;

    /**
     * 选育单位
     */
    @ExcelField(title = "选育单位")
    private String breedEntp;

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
