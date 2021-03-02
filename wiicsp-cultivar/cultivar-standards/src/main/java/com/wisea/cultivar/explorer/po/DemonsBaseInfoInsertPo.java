package com.wisea.cultivar.explorer.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * DemonsBaseInfoInsertPo
 * 2020/08/11 13:21:46
 */
public class DemonsBaseInfoInsertPo {
    /**
     * 种植主体id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "种植主体id", allowableValues = "length:(,19]")
    private Long entpInfoMageId;

    /**
     * 基地名称
     */
    @Check(test = {"required", "minLength", "maxLength" }, lengthRange = { 2, 200 })
    @ApiModelProperty(value = "基地名称", allowableValues = "mixLength:(2,200]")
    private String demonsBaseName;

    /**
     * 行政区划代码
     */
    @ApiModelProperty(value = "行政区划代码", allowableValues = "mixLength:(,12]")
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
     * 基地面积
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$",nullSkip = true)
    @ApiModelProperty(value = "基地面积", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double demonsBaseAcre;

    /**
     * 720巡场地址
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "720巡场地址", allowableValues = "mixLength:(,255]")
    private String fieldAddress;

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
     * 经度纬度
     */
    @Check(test = { "regex" }, regex = "^\\d+(\\.\\d+)?,\\d+(\\.\\d+)?",nullSkip = true)
    @ApiModelProperty(value = "经度纬度", allowableValues = "mixLength:(,255]")
    private String jdWd;

    /**
     * 详细介绍信息
     */
    @ApiModelProperty(value = "详细介绍信息")
    private List<DemonsBaseIntroduceInsertPo> introduceList;

    /**
     * 获取种植主体id
     */
    public Long getEntpInfoMageId() {
        return entpInfoMageId;
    }

    /**
     * 设置种植主体id
     */
    public void setEntpInfoMageId(Long entpInfoMageId) {
        this.entpInfoMageId = entpInfoMageId;
    }

    /**
     * 获取基地名称
     */
    public String getDemonsBaseName() {
        return demonsBaseName;
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
     * 设置基地名称
     */
    public void setDemonsBaseName(String demonsBaseName) {
        this.demonsBaseName = demonsBaseName == null ? null : demonsBaseName.trim();
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
     * 获取基地面积
     */
    public Double getDemonsBaseAcre() {
        return demonsBaseAcre;
    }

    /**
     * 设置基地面积
     */
    public void setDemonsBaseAcre(Double demonsBaseAcre) {
        this.demonsBaseAcre = demonsBaseAcre;
    }

    /**
     * 获取720巡场地址
     */
    public String getFieldAddress() {
        return fieldAddress;
    }

    /**
     * 设置720巡场地址
     */
    public void setFieldAddress(String fieldAddress) {
        this.fieldAddress = fieldAddress == null ? null : fieldAddress.trim();
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

    public String getJdWd() {
        return jdWd;
    }

    public void setJdWd(String jdWd) {
        this.jdWd = jdWd;
    }


    public List<DemonsBaseIntroduceInsertPo> getIntroduceList() {
        return introduceList;
    }

    public void setIntroduceList(List<DemonsBaseIntroduceInsertPo> introduceList) {
        this.introduceList = introduceList;
    }
}
