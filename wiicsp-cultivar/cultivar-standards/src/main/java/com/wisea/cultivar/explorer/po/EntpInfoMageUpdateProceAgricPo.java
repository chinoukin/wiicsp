package com.wisea.cultivar.explorer.po;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;

import java.time.OffsetDateTime;

/**
 * EntpInfoMageUpdatePo
 * 2020/07/24 11:21:45
 */
public class EntpInfoMageUpdateProceAgricPo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "required" })
    @ApiModelProperty(value = "id", required = true)
    private Long id;

    /**
     * 企业主体类型
     */
    @Check(test = {"required", "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "企业主体类型", allowableValues = "mixLength:(,5]")
    private String entpMainBusinessType;

    /**
     * 企业名称
     */
    @Check(test = {"required", "minLength", "maxLength" }, lengthRange = { 2, 100 })
    @ApiModelProperty(value = "企业名称", allowableValues = "mixLength:(2,100]")
    private String entpName;

    /**
     * 行政区划代码
     */
    @ApiModelProperty(value = "行政区划代码", allowableValues = "mixLength:(,30]")
    private String areaCode;

    @Check(test = {"required", "minLength", "maxLength","regex" }, lengthRange = { 12,12 },regex = "^[0-9]{12}$")
    @ApiModelProperty(value = "行政区划代码省")
    private String areaProv;

    @Check(test = {"required", "minLength", "maxLength","regex" }, lengthRange = { 12,12 },regex = "^[0-9]{12}$")
    @ApiModelProperty(value = "行政区划代码市")
    private String areaCity;

    @Check(test = {"required", "minLength", "maxLength","regex" }, lengthRange = { 12,12 },regex = "^[0-9]{12}$")
    @ApiModelProperty(value = "行政区划代码区县")
    private String areaCou;

    /**
     * 企业类型
     */
    @Check(test = { "maxLength" }, length = 255)
    @ApiModelProperty(value = "企业类型")
    private String entpType;

    /**
     * 种植面积
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$",nullSkip = true)
    @ApiModelProperty(value = "种植面积", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double plantMeasure;

    /**
     * 统一社会信用代码
     */
    @Check(test = {"regex", "minLength", "maxLength" }, regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{18,18}$", lengthRange = { 18, 18 },nullSkip = true)
    @ApiModelProperty(value = "统一社会信用代码", allowableValues = "mixLength:(,18]")
    private String ctscc;

    /**
     * 成立日期
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "成立日期")
    private OffsetDateTime estabDate;

    /**
     * 法人代表
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "法人代表", allowableValues = "mixLength:(,30]")
    private String legalPersonName;

    /**
     * 企业地址
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "企业地址", allowableValues = "mixLength:(,255]")
    private String entpAddress;

    /**
     * 企业介绍
     */
    @Check(test = { "maxLength" }, mixLength = 600)
    @ApiModelProperty(value = "企业介绍", allowableValues = "mixLength:(,600]")
    private String entpIntroduce;

    /**
     * 主营品种
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "主营品种", allowableValues = "mixLength:(,30]")
    private String mainBusineVariet;

    /**
     * 年出苗量
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$",nullSkip = true)
    @ApiModelProperty(value = "年出苗量", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double prdutGermChitNum;

    /**
     * 联系人
     */
    @Check(test = { "maxLength" }, mixLength = 20)
    @ApiModelProperty(value = "联系人", allowableValues = "mixLength:(,20]")
    private String conter;

    /**
     * 联系方式
     */
    @Check(test = { "maxLength" }, mixLength = 20)
    @ApiModelProperty(value = "联系方式", allowableValues = "mixLength:(,20]")
    private String contTel;

    /**
     * 经度
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$",nullSkip = true)
    @ApiModelProperty(value = "经度", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double jd;

    /**
     * 纬度
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$",nullSkip = true)
    @ApiModelProperty(value = "纬度", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double wd;

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

    @Check(test = { "regex" }, regex = "^\\d+(\\.\\d+)?,\\d+(\\.\\d+)?",nullSkip = true)
    @ApiModelProperty(value = "经度纬度", allowableValues = "regex:^\\d+(\\.\\d+)?,\\d+(\\.\\d+)?")
    private String jdWd;

    public String getJdWd() {
        return jdWd;
    }

    public void setJdWd(String jdWd) {
        this.jdWd = jdWd;
    }

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

    /**
     * 获取经度
     */
    public Double getJd() {
        if(StringUtils.isNotBlank(this.jdWd)){
            String[] jdWdSplit;
            try {
                jdWdSplit = this.jdWd.split(",");
            } catch (Exception e) {
                try {
                    jdWdSplit = this.jdWd.split("，");
                } catch (Exception exception) {
                    jdWdSplit = new String[]{"0","0"};
                }
            }
            this.jd =  Double.valueOf(jdWdSplit[0]);
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
            String[] jdWdSplit;
            try {
                jdWdSplit = this.jdWd.split(",");
            } catch (Exception e) {
                try {
                    jdWdSplit = this.jdWd.split("，");
                } catch (Exception exception) {
                    jdWdSplit = new String[]{"0","0"};
                }
            }
            this.wd =  Double.valueOf(jdWdSplit[1]);
        }
        return wd;
    }

    /**
     * 设置纬度
     */
    public void setWd(Double wd) {
        this.wd = wd;
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
