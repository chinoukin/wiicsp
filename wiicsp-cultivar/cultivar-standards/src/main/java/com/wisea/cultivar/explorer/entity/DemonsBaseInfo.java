package com.wisea.cultivar.explorer.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * demons_base_info 表实体
 * 示范基地信息
 * 2020/08/11 13:21:46
 */
public class DemonsBaseInfo extends DataLongEntity<DemonsBaseInfo> {
    private static final long serialVersionUID = 1L;

    /**
     * 种植主体id
     */
    private Long entpInfoMageId;

    /**
     * 基地名称
     */
    private String demonsBaseName;

    /**
     * 行政区划代码
     */
    private String areaCode;

    private String areaProv;

    private String areaCity;

    private String areaCou;
    /**
     * 基地面积
     */
    private Double demonsBaseAcre;

    /**
     * 720巡场地址
     */
    private String fieldAddress;

    /**
     * 经度
     */
    private Double jd;

    /**
     * 纬度
     */
    private Double wd;

    /**
     *
     * @mbg.generated
     */
    public DemonsBaseInfo() {
        super();
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
}
