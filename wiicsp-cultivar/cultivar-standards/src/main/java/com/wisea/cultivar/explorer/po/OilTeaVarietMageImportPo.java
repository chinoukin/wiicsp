package com.wisea.cultivar.explorer.po;

import com.wisea.cloud.common.util.excel.annotation.ExcelField;
import com.wisea.cloud.model.annotation.Check;

import java.io.Serializable;

public class OilTeaVarietMageImportPo implements Serializable{

    /**
     * 品种名称
     */
    @Check(test = {"required", "maxLength" }, mixLength = 30)
    @ExcelField(title = "品种名称")
    private String oilTeaVarietName;

    /**
     * 品种编号
     */
    @Check(test = {"required", "maxLength" }, mixLength = 30)
    @ExcelField(title = "品种编号")
    private String oilTeaVarietNo;


    /**
     * 亩种植数
     */
    @Check(test = { "regex" }, regex = "^\\S$|^\\s*$|^[1-9]\\d*(\\.[0-9]+)?$|^0$")
    @ExcelField(title = "亩种植(株)")
    private Double acrePlantNum;

    /**
     * 亩均产果
     */

    @Check(test = { "regex" }, regex = "^\\s*$|^[1-9]\\d*(\\.[0-9]+)?$|^0$")
    @ExcelField(title = "亩均产果(kg)")
    private Double acrePlantCg;

    /**
     * 亩均产籽
     */
    @Check(test = { "regex" }, regex = "^\\s*$|^[1-9]\\d*(\\.[0-9]+)?$|^0$")
    @ExcelField(title = "亩均产籽(kg)")
    private Double acrePlantCz;

    /**
     * 亩均产油
     */
    @Check(test = { "regex" }, regex = "^\\s*$|^[1-9]\\d*(\\.[0-9]+)?$|^0$")
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
}
