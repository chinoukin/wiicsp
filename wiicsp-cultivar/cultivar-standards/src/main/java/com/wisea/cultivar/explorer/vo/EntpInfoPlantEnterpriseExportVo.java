package com.wisea.cultivar.explorer.vo;

import com.wisea.cloud.common.util.excel.annotation.ExcelField;

import java.io.Serializable;
import java.time.OffsetDateTime;

/**
 * @author furui
 * 种植主体导出
 */
public class EntpInfoPlantEnterpriseExportVo extends EntpInfoMageExportVo implements Serializable {

    /**
     * 行政区划代码
     */
    private String areaCode;
    @ExcelField(title = "行政区划代码省",width = 20)
    private String areaProv;
    @ExcelField(title = "行政区划代码市",width = 20)
    private String areaCity;
    @ExcelField(title = "行政区划代码区县",width = 20)
    private String areaCou;


    /**
     * 企业名称
     */
    @ExcelField(title = "主体名称",width = 40)
    private String entpName;

    /**
     * 主体类型
     */
    @ExcelField(title = "主体类型",width = 20,fieldType = String.class)
    private String entpType;

    /**
     * 种植面积
     */
    @ExcelField(title = "种植面积",width = 20,fieldType = String.class)
    private Double plantMeasure;

    /**
     * 统一社会信用代码
     */
    @ExcelField(title = "统一社会信用代码",width = 20)
    private String ctscc;

    /**
     * 成立日期
     */
    private OffsetDateTime estabDate;

    /**
     * 成立日期
     */
    @ExcelField(title = "成立日期",width = 20)
    private String estabDateStr;

    /**
     * 法人代表
     */
    @ExcelField(title = "法人代表",width = 20)
    private String legalPersonName;

    /**
     * 企业地址
     */
    @ExcelField(title = "主体地址",width = 20)
    private String entpAddress;

    /**
     * 企业介绍
     */
    @ExcelField(title = "主体介绍",width = 20)
    private String entpIntroduce;

    /**
     * 联系人
     */
    @ExcelField(title = "联系人",width = 20)
    private String conter;

    /**
     * 联系方式
     */
    @ExcelField(title = "联系方式",width = 30,cellDataFormateAuto = false,fieldType = String.class)
    private String contTel;

    /**
     * 经纬度--导入传参
     */
    @ExcelField(title = "坐标点",width = 40,cellDataFormateAuto = false,fieldType = String.class)
    private String jdWd;

    /**
     * 经度
     */
    private Double jd;

    /**
     * 纬度
     */
    private Double wd;

    public String getAreaProv() {
        return areaProv;
    }

    public void setAreaProv(String areaProv) {
        this.areaProv = areaProv;
    }

    public String getAreaCity() {
        return areaCity;
    }

    public void setAreaCity(String areaCity) {
        this.areaCity = areaCity;
    }

    public String getAreaCou() {
        return areaCou;
    }

    public void setAreaCou(String areaCou) {
        this.areaCou = areaCou;
    }

    @Override
    public String getEstabDateStr() {
        return estabDateStr;
    }

    @Override
    public void setEstabDateStr(String estabDateStr) {
        this.estabDateStr = estabDateStr;
    }

    public Double getPlantMeasure() {
        return plantMeasure;
    }


    @Override
    public String getEntpType() {
        return entpType;
    }

    @Override
    public void setEntpType(String entpType) {
        this.entpType = entpType;
    }

    public void setPlantMeasure(Double plantMeasure) {
        this.plantMeasure = plantMeasure;
    }

    @Override
    public String getAreaCode() {
        return areaCode;
    }

    @Override
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    @Override
    public String getEntpName() {
        return entpName;
    }

    @Override
    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }

    @Override
    public String getCtscc() {
        return ctscc;
    }

    @Override
    public void setCtscc(String ctscc) {
        this.ctscc = ctscc;
    }

    @Override
    public OffsetDateTime getEstabDate() {
        return estabDate;
    }

    @Override
    public void setEstabDate(OffsetDateTime estabDate) {
        this.estabDate = estabDate;
    }

    @Override
    public String getLegalPersonName() {
        return legalPersonName;
    }

    @Override
    public void setLegalPersonName(String legalPersonName) {
        this.legalPersonName = legalPersonName;
    }

    @Override
    public String getEntpAddress() {
        return entpAddress;
    }

    @Override
    public void setEntpAddress(String entpAddress) {
        this.entpAddress = entpAddress;
    }

    @Override
    public String getEntpIntroduce() {
        return entpIntroduce;
    }

    @Override
    public void setEntpIntroduce(String entpIntroduce) {
        this.entpIntroduce = entpIntroduce;
    }

    @Override
    public String getConter() {
        return conter;
    }

    @Override
    public void setConter(String conter) {
        this.conter = conter;
    }

    @Override
    public String getContTel() {
        return contTel;
    }

    @Override
    public void setContTel(String contTel) {
        this.contTel = contTel;
    }

    public String getJdWd() {
        if(null != this.jd & null != this.wd){
            this.jdWd = this.jd + "," + this.wd;
        }
        return jdWd;
    }

    @Override
    public void setJdWd(String jdWd) {
        this.jdWd = jdWd;
    }

    @Override
    public Double getJd() {
        return jd;
    }

    @Override
    public void setJd(Double jd) {
        this.jd = jd;
    }

    @Override
    public Double getWd() {
        return wd;
    }

    @Override
    public void setWd(Double wd) {
        this.wd = wd;
    }
}
