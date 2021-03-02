package com.wisea.cultivar.explorer.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

/**
 * demons_base_massif 表实体
 * 示范基地地块信息
 * 2020/08/11 13:21:46
 */
public class DemonsBaseMassif extends DataLongEntity<DemonsBaseMassif> {
    private static final long serialVersionUID = 1L;

    public static String defaultCoordPointExpres = "{\"lng\":112.111834,\"lat\":26.791385}";
    /**
     * 示范基地id
     */
    private Long demonsBaseId;

    /**
     * 地块名称
     */
    private String massifName;

    /**
     * 所在位置名称
     */
    private String location;

    /**
     * 地块面积
     */
    private Double massifAcre;

    /**
     * 种植品种
     */
    private String commName;

    /**
     * 播种时间
     */
    private OffsetDateTime bzDate;

    /**
     * 坐标点表达式
     */
    private String coordPointExpres;

    /**
     *
     * @mbg.generated
     */
    public DemonsBaseMassif() {
        super();
    }

    /**
     * 获取示范基地id
     */
    public Long getDemonsBaseId() {
        return demonsBaseId;
    }

    /**
     * 设置示范基地id
     */
    public void setDemonsBaseId(Long demonsBaseId) {
        this.demonsBaseId = demonsBaseId;
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
