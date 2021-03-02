package com.wisea.cultivar.explorer.vo;

import com.wisea.cloud.common.util.excel.annotation.ExcelField;

import java.io.Serializable;
import java.time.OffsetDateTime;

/**
 * @author furui
 * 种苗企业导出
 */
public class EntpInfoSeedCompaniesExportVo extends EntpInfoMageExportVo implements Serializable {

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
    @ExcelField(title = "企业名称",width = 40)
    private String entpName;

    /**
     * 企业类型
     */
    @ExcelField(title = "企业类型",width = 20,fieldType = String.class)
    private String entpType;

    /**
     * 统一社会信用代码
     */
    @ExcelField(title = "统一社会信用代码",width = 20)
    private String ctscc;

    /**
     * 成立日期
     */
    @ExcelField(title = "成立日期",width = 20)
    private String estabDateStr;

    /**
     * 成立日期
     */
    private OffsetDateTime estabDate;

    /**
     * 法人代表
     */
    @ExcelField(title = "法人代表",width = 20)
    private String legalPersonName;

    /**
     * 企业地址
     */
    @ExcelField(title = "企业地址",width = 20)
    private String entpAddress;

    /**
     * 企业介绍
     */
    @ExcelField(title = "企业介绍",width = 20)
    private String entpIntroduce;

    /**
     * 主营品种
     */
    @ExcelField(title = "主营品种",width = 20,cellDataFormateAuto = false,fieldType = String.class)
    private String mainBusineVariet;

    /**
     * 年出苗量
     */
    @ExcelField(title = "年出苗量",width = 20)
    private Double prdutGermChitNum;

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

    @Override
    public String getAreaProv() {
        return areaProv;
    }

    @Override
    public void setAreaProv(String areaProv) {
        this.areaProv = areaProv;
    }

    @Override
    public String getAreaCity() {
        return areaCity;
    }

    @Override
    public void setAreaCity(String areaCity) {
        this.areaCity = areaCity;
    }

    @Override
    public String getAreaCou() {
        return areaCou;
    }

    @Override
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

    public String getMainBusineVariet() {
        return mainBusineVariet;
    }

    public void setMainBusineVariet(String mainBusineVariet) {
        this.mainBusineVariet = mainBusineVariet;
    }

    public Double getPrdutGermChitNum() {
        return prdutGermChitNum;
    }

    public void setPrdutGermChitNum(Double prdutGermChitNum) {
        this.prdutGermChitNum = prdutGermChitNum;
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
    public String getEntpType() {
        return entpType;
    }

    @Override
    public void setEntpType(String entpType) {
        this.entpType = entpType;
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
