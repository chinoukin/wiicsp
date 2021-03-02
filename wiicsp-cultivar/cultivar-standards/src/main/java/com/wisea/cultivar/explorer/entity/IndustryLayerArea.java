package com.wisea.cultivar.explorer.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * industry_layer_area 表实体
 * 图层区域信息
 * 2020/08/11 13:21:46
 */
public class IndustryLayerArea extends DataLongEntity<IndustryLayerArea> {
    private static final long serialVersionUID = 1L;

    /**
     * 产业图层id
     */
    private Long industryLayerId;

    /**
     * 区域名称
     */
    private String areaName;

    /**
     * 所在位置名称
     */
    private String location;

    /**
     * 区域面积
     */
    private Double areaAcre;

    /**
     * 区域介绍
     */
    private String areaIntroduce;

    /**
     * 坐标点表达式
     */
    private String coordPointExpres;

    /**
     *
     * @mbg.generated
     */
    public IndustryLayerArea() {
        super();
    }

    /**
     * 获取产业图层id
     */
    public Long getIndustryLayerId() {
        return industryLayerId;
    }

    /**
     * 设置产业图层id
     */
    public void setIndustryLayerId(Long industryLayerId) {
        this.industryLayerId = industryLayerId;
    }

    /**
     * 获取区域名称
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 设置区域名称
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
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
     * 获取区域面积
     */
    public Double getAreaAcre() {
        return areaAcre;
    }

    /**
     * 设置区域面积
     */
    public void setAreaAcre(Double areaAcre) {
        this.areaAcre = areaAcre;
    }

    /**
     * 获取区域介绍
     */
    public String getAreaIntroduce() {
        return areaIntroduce;
    }

    /**
     * 设置区域介绍
     */
    public void setAreaIntroduce(String areaIntroduce) {
        this.areaIntroduce = areaIntroduce == null ? null : areaIntroduce.trim();
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
