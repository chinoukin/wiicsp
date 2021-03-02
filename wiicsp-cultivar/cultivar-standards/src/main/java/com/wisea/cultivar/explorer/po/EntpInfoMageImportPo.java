package com.wisea.cultivar.explorer.po;

import com.wisea.cloud.common.util.excel.annotation.ExcelField;

import java.io.Serializable;
import java.time.OffsetDateTime;

public class EntpInfoMageImportPo implements Serializable{

    /**
    * 企业主体类型
    */
    @ExcelField(title = "企业主体类型")
    private String entpMainBusinessType;

    /**
    * 企业名称
    */
    @ExcelField(title = "企业名称")
    private String entpName;

    /**
    * 行政区划代码
    */
    @ExcelField(title = "行政区划代码")
    private String areaCode;

    /**
    * 企业类型
    */
    @ExcelField(title = "企业类型")
    private String entpType;

    /**
    * 种植面积
    */
    @ExcelField(title = "种植面积")
    private Double plantMeasure;

    /**
    * 统一社会信用代码
    */
    @ExcelField(title = "统一社会信用代码")
    private String ctscc;

    /**
    * 成立日期
    */
    @ExcelField(title = "成立日期")
    private OffsetDateTime estabDate;

    /**
    * 法人代表
    */
    @ExcelField(title = "法人代表")
    private String legalPersonName;

    /**
    * 企业地址
    */
    @ExcelField(title = "企业地址")
    private String entpAddress;

    /**
    * 企业介绍
    */
    @ExcelField(title = "企业介绍")
    private String entpIntroduce;

    /**
    * 主营品种
    */
    @ExcelField(title = "主营品种")
    private String mainBusineVariet;

    /**
    * 年出苗量
    */
    @ExcelField(title = "年出苗量")
    private Double prdutGermChitNum;

    /**
    * 联系人
    */
    @ExcelField(title = "联系人")
    private String conter;

    /**
    * 联系方式
    */
    @ExcelField(title = "联系方式")
    private String contTel;

    /**
     * 经纬度--导入传参
     */
    @ExcelField(title = "坐标点")
    private String jdWd;

    /**
    * 经度
    */
    @ExcelField(title = "经度")
    private Double jd;

    /**
    * 纬度
    */
    @ExcelField(title = "纬度")
    private Double wd;

    /**
     * 获取企业主体类型
     */
    public String getEntpMainBusinessType() {
        return entpMainBusinessType;
    }

    /**
     * 设置企业主体类型
     */
    public void setEntpMainBusinessType(String entpMainBusinessType) {
        this.entpMainBusinessType = entpMainBusinessType == null ? null : entpMainBusinessType.trim();
    }

    /**
     * 获取企业名称
     */
    public String getEntpName() {
        return entpName;
    }

    /**
     * 设置企业名称
     */
    public void setEntpName(String entpName) {
        this.entpName = entpName == null ? null : entpName.trim();
    }

    /**
     * 获取行政区划代码
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * 设置行政区划代码
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    /**
     * 获取企业类型
     */
    public String getEntpType() {
        return entpType;
    }

    /**
     * 设置企业类型
     */
    public void setEntpType(String entpType) {
        this.entpType = entpType == null ? null : entpType.trim();
    }

    /**
     * 获取种植面积
     */
    public Double getPlantMeasure() {
        return plantMeasure;
    }

    /**
     * 设置种植面积
     */
    public void setPlantMeasure(Double plantMeasure) {
        this.plantMeasure = plantMeasure;
    }

    /**
     * 获取统一社会信用代码
     */
    public String getCtscc() {
        return ctscc;
    }

    /**
     * 设置统一社会信用代码
     */
    public void setCtscc(String ctscc) {
        this.ctscc = ctscc == null ? null : ctscc.trim();
    }

    /**
     * 获取成立日期
     */
    public OffsetDateTime getEstabDate() {
        return estabDate;
    }

    /**
     * 设置成立日期
     */
    public void setEstabDate(OffsetDateTime estabDate) {
        this.estabDate = estabDate;
    }

    /**
     * 获取法人代表
     */
    public String getLegalPersonName() {
        return legalPersonName;
    }

    /**
     * 设置法人代表
     */
    public void setLegalPersonName(String legalPersonName) {
        this.legalPersonName = legalPersonName == null ? null : legalPersonName.trim();
    }

    /**
     * 获取企业地址
     */
    public String getEntpAddress() {
        return entpAddress;
    }

    /**
     * 设置企业地址
     */
    public void setEntpAddress(String entpAddress) {
        this.entpAddress = entpAddress == null ? null : entpAddress.trim();
    }

    /**
     * 获取企业介绍
     */
    public String getEntpIntroduce() {
        return entpIntroduce;
    }

    /**
     * 设置企业介绍
     */
    public void setEntpIntroduce(String entpIntroduce) {
        this.entpIntroduce = entpIntroduce == null ? null : entpIntroduce.trim();
    }

    /**
     * 获取主营品种
     */
    public String getMainBusineVariet() {
        return mainBusineVariet;
    }

    /**
     * 设置主营品种
     */
    public void setMainBusineVariet(String mainBusineVariet) {
        this.mainBusineVariet = mainBusineVariet == null ? null : mainBusineVariet.trim();
    }

    /**
     * 获取年出苗量
     */
    public Double getPrdutGermChitNum() {
        return prdutGermChitNum;
    }

    /**
     * 设置年出苗量
     */
    public void setPrdutGermChitNum(Double prdutGermChitNum) {
        this.prdutGermChitNum = prdutGermChitNum;
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
     * 获取联系方式
     */
    public String getContTel() {
        return contTel;
    }

    /**
     * 设置联系方式
     */
    public void setContTel(String contTel) {
        this.contTel = contTel == null ? null : contTel.trim();
    }

    public String getJdWd() {
        if(null != this.jd & null != this.wd){
            this.jdWd = this.jd + "," + this.wd;
        }
        return jdWd;
    }

    public void setJdWd(String jdWd) {
        this.jdWd = jdWd;
    }

    /**
     * 获取经度
     */
    public Double getJd() {
        return jd;
    }

    /**
     * 设置经度
     */
    public void setJd(Double jd) {
        this.jd = jd;
    }

    /**
     * 获取纬度
     */
    public Double getWd() {
        return wd;
    }

    /**
     * 设置纬度
     */
    public void setWd(Double wd) {
        this.wd = wd;
    }


}
