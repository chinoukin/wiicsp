package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class BaseInfo extends DataLongEntity<BaseInfo> {
    /**
     * 会员id（商家）
     */
    private Long membId;

    /**
     * 基地名称
     */
    private String baseName;

    /**
     * 基地详情
     */
    private String baseContent;

    /**
     * 720VR地址
     */
    private String vrUrl;

    /**
     * VR视频地址
     */
    private String vrVideoUrl;

    /**
     * 基地类型
     */
    private String baseType;

    /**
     * 省
     */
    private String areaProv;

    /**
     * 市
     */
    private String areaCity;

    /**
     * 区县
     */
    private String areaCou;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 经度
     */
    private String jd;

    /**
     * 纬度
     */
    private String wd;

    /**
     * 国外产地id
     */
    private Long abroadId;

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

    public Long getAbroadId() {
        return abroadId;
    }

    public void setAbroadId(Long abroadId) {
        this.abroadId = abroadId;
    }
}
