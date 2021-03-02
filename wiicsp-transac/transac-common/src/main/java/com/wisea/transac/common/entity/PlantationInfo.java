package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class PlantationInfo extends DataLongEntity<PlantationInfo> {
    /**
     * 基地id
     */
    private Long baseId;

    /**
     * 种植园名称
     */
    private String plantationName;

    /**
     * 种植产品
     */
    private String plantationPrduct;

    /**
     * 种植面积
     */
    private Double plantationMj;

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
     * 联系人
     */
    private String conter;

    /**
     * 联系人手机号
     */
    private String contTel;

    /**
     * 种植园介绍
     */
    private String plantationContent;

    /**
     * 720VR地址
     */
    private String vrUrl;

    /**
     * 经度
     */
    private String jd;

    /**
     * 纬度
     */
    private String wd;

    /**
     * 定位名称
     */
    private String oriName;

    public Long getBaseId() {
        return baseId;
    }

    public void setBaseId(Long baseId) {
        this.baseId = baseId;
    }

    public String getPlantationName() {
        return plantationName;
    }

    public void setPlantationName(String plantationName) {
        this.plantationName = plantationName;
    }

    public String getPlantationPrduct() {
        return plantationPrduct;
    }

    public void setPlantationPrduct(String plantationPrduct) {
        this.plantationPrduct = plantationPrduct;
    }

    public Double getPlantationMj() {
        return plantationMj;
    }

    public void setPlantationMj(Double plantationMj) {
        this.plantationMj = plantationMj;
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

    public String getConter() {
        return conter;
    }

    public void setConter(String conter) {
        this.conter = conter;
    }

    public String getContTel() {
        return contTel;
    }

    public void setContTel(String contTel) {
        this.contTel = contTel;
    }

    public String getPlantationContent() {
        return plantationContent;
    }

    public void setPlantationContent(String plantationContent) {
        this.plantationContent = plantationContent;
    }

    public String getVrUrl() {
        return vrUrl;
    }

    public void setVrUrl(String vrUrl) {
        this.vrUrl = vrUrl;
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

    public String getOriName() {
        return oriName;
    }

    public void setOriName(String oriName) {
        this.oriName = oriName;
    }
}
