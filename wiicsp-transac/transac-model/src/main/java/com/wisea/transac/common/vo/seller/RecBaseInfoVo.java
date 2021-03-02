package com.wisea.transac.common.vo.seller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("基地查询PO")
public class RecBaseInfoVo {
    @ApiModelProperty("基地ID")
    private Long id;
    @ApiModelProperty("会员id（商家）")
    private Long membId;
    @ApiModelProperty("基地名称")
    private String baseName;
    @ApiModelProperty("基地详情")
    private String baseContent;
    @ApiModelProperty("720VR地址")
    private String vrUrl;
    @ApiModelProperty("VR视频地址")
    private String vrVideoUrl;
    @ApiModelProperty("基地类型")
    private String baseType;
    @ApiModelProperty("省")
    private String areaProv;
    @ApiModelProperty("市")
    private String areaCity;
    @ApiModelProperty("区县")
    private String areaCou;
    @ApiModelProperty("详细地址")
    private String address;
    @ApiModelProperty("经度")
    private String jd;
    @ApiModelProperty("纬度")
    private String wd;
    @ApiModelProperty("基地标签 - 基地 0 :不显示 1：显示")
    private String baseTag;
    @ApiModelProperty("基地标签 - 在线看工厂 0 :不显示 1：显示")
    private String factoryTag;
    @ApiModelProperty("基地标签 - 在线看仓库 0 :不显示 1：显示")
    private String storageTag;
    @ApiModelProperty("基地标签 - 在线看种植园 0 :不显示 1：显示")
    private String plantationTag;
    @ApiModelProperty("优势单品")
    private String supPieceName;
    @ApiModelProperty("基地封面图")
    private String baseUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public String getBaseContent() {
        return baseContent;
    }

    public void setBaseContent(String baseContent) {
        this.baseContent = baseContent;
    }

    public String getVrUrl() {
        return vrUrl;
    }

    public void setVrUrl(String vrUrl) {
        this.vrUrl = vrUrl;
    }

    public String getVrVideoUrl() {
        return vrVideoUrl;
    }

    public void setVrVideoUrl(String vrVideoUrl) {
        this.vrVideoUrl = vrVideoUrl;
    }

    public String getBaseType() {
        return baseType;
    }

    public void setBaseType(String baseType) {
        this.baseType = baseType;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJd() {
        return jd;
    }

    public void setJd(String jd) {
        this.jd = jd;
    }

    public String getWd() {
        return wd;
    }

    public void setWd(String wd) {
        this.wd = wd;
    }

    public String getBaseTag() {
        return baseTag;
    }

    public void setBaseTag(String baseTag) {
        this.baseTag = baseTag;
    }

    public String getFactoryTag() {
        return factoryTag;
    }

    public void setFactoryTag(String factoryTag) {
        this.factoryTag = factoryTag;
    }

    public String getStorageTag() {
        return storageTag;
    }

    public void setStorageTag(String storageTag) {
        this.storageTag = storageTag;
    }

    public String getPlantationTag() {
        return plantationTag;
    }

    public void setPlantationTag(String plantationTag) {
        this.plantationTag = plantationTag;
    }

    public String getSupPieceName() {
        return supPieceName;
    }

    public void setSupPieceName(String supPieceName) {
        this.supPieceName = supPieceName;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
