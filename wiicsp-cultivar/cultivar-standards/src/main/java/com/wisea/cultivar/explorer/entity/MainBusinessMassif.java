package com.wisea.cultivar.explorer.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

/**
 * main_business_massif 表实体
 * 主体地块信息
 * 2020/08/24 20:19:05
 */
public class MainBusinessMassif extends DataLongEntity<MainBusinessMassif> {
    private static final long serialVersionUID = 1L;

    /**
     * 种植主体id
     */
    private Long entpInfoMageId;

    /**
     * 地块名称
     */
    private String massifName;

    /**
     * 地块面积
     */
    private Double massifAcre;

    /**
     * 播种时间
     */
    private OffsetDateTime bzDate;

    /**
     * 种植品种
     */
    private String commName;

    /**
     * 所在位置名称
     */
    private String location;

    /**
     * 坐标点表达式
     */
    private String coordPointExpres;

    /**
     *
     * @mbg.generated
     */
    public MainBusinessMassif() {
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
     * 获取地块名称
     */
    public String getMassifName() {
        return massifName;
    }

    /**
     * 设置地块名称
     */
    public void setMassifName(String massifName) {
        this.massifName = massifName == null ? null : massifName.trim();
    }

    /**
     * 获取地块面积
     */
    public Double getMassifAcre() {
        return massifAcre;
    }

    /**
     * 设置地块面积
     */
    public void setMassifAcre(Double massifAcre) {
        this.massifAcre = massifAcre;
    }

    /**
     * 获取播种时间
     */
    public OffsetDateTime getBzDate() {
        return bzDate;
    }

    /**
     * 设置播种时间
     */
    public void setBzDate(OffsetDateTime bzDate) {
        this.bzDate = bzDate;
    }

    /**
     * 获取种植品种
     */
    public String getCommName() {
        return commName;
    }

    /**
     * 设置种植品种
     */
    public void setCommName(String commName) {
        this.commName = commName == null ? null : commName.trim();
    }

    /**
     * 获取所在位置名称
     */
    public String getLocation() {
        return location;
    }

    /**
     * 设置所在位置名称
     */
    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    /**
     * 获取坐标点表达式
     */
    public String getCoordPointExpres() {
        return coordPointExpres;
    }

    /**
     * 设置坐标点表达式
     */
    public void setCoordPointExpres(String coordPointExpres) {
        this.coordPointExpres = coordPointExpres == null ? null : coordPointExpres.trim();
    }
}
