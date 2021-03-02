package com.wisea.cultivar.explorer.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * IndustryLayerAreaListPo
 * 2020/08/11 13:21:46
 */
public class IndustryLayerAreaListPo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 产业图层id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "产业图层id")
    private Long industryLayerId;

    /**
     * 区域名称
     */
    @ApiModelProperty(value = "区域名称")
    private String areaName;

    /**
     * 所在位置名称
     */
    @ApiModelProperty(value = "所在位置名称")
    private String location;

    /**
     * 区域面积
     */
    @ApiModelProperty(value = "区域面积")
    private Double areaAcre;

    /**
     * 区域介绍
     */
    @ApiModelProperty(value = "区域介绍")
    private String areaIntroduce;

    /**
     * 坐标点表达式
     */
    @ApiModelProperty(value = "坐标点表达式")
    private String coordPointExpres;

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
}
