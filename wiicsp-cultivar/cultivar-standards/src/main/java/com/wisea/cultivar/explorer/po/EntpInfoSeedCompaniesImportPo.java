package com.wisea.cultivar.explorer.po;

import com.wisea.cloud.common.util.excel.annotation.ExcelField;
import com.wisea.cultivar.explorer.utils.CheckUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * @author furui
 * 种苗企业导入
 */
public class EntpInfoSeedCompaniesImportPo implements Serializable {

    /**
     * 行政区划代码
     */
    private String areaCode;
    @ExcelField(title = "行政区划代码省")
    private String areaProv;
    @ExcelField(title = "行政区划代码市")
    private String areaCity;
    @ExcelField(title = "行政区划代码区县")
    private String areaCou;

    /**
     * 企业名称
     */
    @ExcelField(title = "企业名称")
    private String entpName;

    /**
     * 企业类型
     */
    @ExcelField(title = "企业类型")
    private String entpType;

    /**
     * 统一社会信用代码
     */
    @ExcelField(title = "统一社会信用代码")
    private String ctscc;


    /**
     * 成立日期
     */
    @ExcelField(title = "成立日期")
    private String estabDate;


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
    @ExcelField(title = "联系方式", cellDataFormateAuto = false,fieldType = String.class)
    private String contTel;



    /**
     * 经纬度--导入传参
     */
    @ExcelField(title = "坐标点", cellDataFormateAuto = false,fieldType = String.class)
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
    public String getEstabDate() {
        return estabDate;
    }

    /**
     * 设置成立日期
     */
    public void setEstabDate(String estabDate) {
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
        this.contTel = contTel;
    }

    /**
     * 获取经度
     */
    public Double getJd() {
        if(StringUtils.isNotBlank(this.jdWd)){
            this.jd =  CheckUtils.getJdWdSplit(jdWd, 0);
        }
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
        if(StringUtils.isNotBlank(this.jdWd)){
            this.wd = CheckUtils.getJdWdSplit(jdWd, 1);
        }
        return wd;
    }


    /**
     * 设置纬度
     */
    public void setWd(Double wd) {
        this.wd = wd;
    }

    public String getJdWd() {
        return jdWd;
    }

    public void setJdWd(String jdWd) {
        this.jdWd = jdWd;
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
}
