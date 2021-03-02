package com.wisea.cultivar.explorer.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * DemonsBaseInfoGetVo
 * 2020/08/11 13:21:46
 */
public class DemonsBaseInfoGetVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 种植主体id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "种植主体id")
    private Long entpInfoMageId;

    /**
     * 基地名称
     */
    @ApiModelProperty(value = "基地名称")
    private String demonsBaseName;

    /**
     * 行政区划代码
     */
    @ApiModelProperty(value = "行政区划代码")
    private String areaCode;

    @ApiModelProperty(value = "行政区划代码省")
    private String areaProv;

    @ApiModelProperty(value = "行政区划代码市")
    private String areaCity;

    @ApiModelProperty(value = "行政区划代码区县")
    private String areaCou;
    /**
     * 基地面积
     */
    @ApiModelProperty(value = "基地面积")
    private Double demonsBaseAcre;

    /**
     * 720巡场地址
     */
    @ApiModelProperty(value = "720巡场地址")
    private String fieldAddress;

    /**
     * 经度
     */
    @ApiModelProperty(value = "经度")
    private Double jd;

    /**
     * 纬度
     */
    @ApiModelProperty(value = "纬度")
    private Double wd;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    /**
     * 经度纬度
     */
    @ApiModelProperty(value = "经度纬度")
    private String jdWd;

    /**
     * 详细介绍信息
     */
    @ApiModelProperty(value = "详细介绍信息")
    private List<DemonsBaseIntroduceListVo> introduceList;

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

    public String getJdWd() {
        if(this.jd != null && !Double.valueOf("0").equals(this.jd) && this.wd != null && !Double.valueOf("0").equals(this.wd)){
            return this.jd + "," + this.wd;
        }
        return jdWd;
    }

    public void setJdWd(String jdWd) {
        this.jdWd = jdWd;
    }

    public List<DemonsBaseIntroduceListVo> getIntroduceList() {
        return introduceList;
    }

    public void setIntroduceList(List<DemonsBaseIntroduceListVo> introduceList) {
        this.introduceList = introduceList;
    }
}
