package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class SortingFactory extends DataLongEntity<SortingFactory> {
    /**
     * 基地id
     */
    private Long baseId;

    /**
     * 分选工厂名称
     */
    private String sortingFactoryName;

    /**
     * 工厂面积
     */
    private Double sortingFactoryMj;

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
     * 分选工厂介绍
     */
    private String sortingFactoryContent;

    /**
     * 经度
     */
    private String jd;

    /**
     * 定位名称
     */
    private String oriName;

    /**
     * 纬度
     */
    private String wd;

    public Long getBaseId() {
        return baseId;
    }

    public void setBaseId(Long baseId) {
        this.baseId = baseId;
    }

    public String getSortingFactoryName() {
        return sortingFactoryName;
    }

    public void setSortingFactoryName(String sortingFactoryName) {
        this.sortingFactoryName = sortingFactoryName;
    }

    public Double getSortingFactoryMj() {
        return sortingFactoryMj;
    }

    public void setSortingFactoryMj(Double sortingFactoryMj) {
        this.sortingFactoryMj = sortingFactoryMj;
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

    public String getSortingFactoryContent() {
        return sortingFactoryContent;
    }

    public void setSortingFactoryContent(String sortingFactoryContent) {
        this.sortingFactoryContent = sortingFactoryContent;
    }

    public String getJd() {
        return jd;
    }

    public void setJd(String jd) {
        this.jd = jd;
    }

    public String getOriName() {
        return oriName;
    }

    public void setOriName(String oriName) {
        this.oriName = oriName;
    }

    public String getWd() {
        return wd;
    }

    public void setWd(String wd) {
        this.wd = wd;
    }
}
