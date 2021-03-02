package com.wisea.cultivar.common.po.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * PlaceOriginMageListPo
 * 2019/12/02 11:02:15
 */
public class PlaceOriginMageListPo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 产地类型
     */
    @ApiModelProperty(value = "产地类型")
    private String placeOriginType;

    /**
     * 产地名称
     */
    @ApiModelProperty(value = "产地名称")
    private String placeOriginName;

    /**
     * 所在区域
     */
    @ApiModelProperty(value = "所在区域")
    private String areaProv;

    /**
     * 基地类型
     */
    @ApiModelProperty(value = "基地类型")
    private String jdType;

    /**
     * 主要品种
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "主要品种")
    private Long mainVarit;

    /**
     * 种植面积
     */
    @ApiModelProperty(value = "种植面积")
    private Double zzmj;

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
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private String placeOriginState;

    /**
     * 产地图片
     */
    @ApiModelProperty(value = "产地图片")
    private String placeOriginUrl;

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
     * 获取产地类型
     */
    public String getPlaceOriginType() {
        return placeOriginType;
    }

    /**
     * 设置产地类型
     */
    public void setPlaceOriginType(String placeOriginType) {
        this.placeOriginType = placeOriginType == null ? null : placeOriginType.trim();
    }

    /**
     * 获取产地名称
     */
    public String getPlaceOriginName() {
        return placeOriginName;
    }

    /**
     * 设置产地名称
     */
    public void setPlaceOriginName(String placeOriginName) {
        this.placeOriginName = placeOriginName == null ? null : placeOriginName.trim();
    }

    /**
     * 获取所在区域
     */
    public String getAreaProv() {
        return areaProv;
    }

    /**
     * 设置所在区域
     */
    public void setAreaProv(String areaProv) {
        this.areaProv = areaProv == null ? null : areaProv.trim();
    }

    /**
     * 获取基地类型
     */
    public String getJdType() {
        return jdType;
    }

    /**
     * 设置基地类型
     */
    public void setJdType(String jdType) {
        this.jdType = jdType == null ? null : jdType.trim();
    }

    /**
     * 获取主要品种
     */
    public Long getMainVarit() {
        return mainVarit;
    }

    /**
     * 设置主要品种
     */
    public void setMainVarit(Long mainVarit) {
        this.mainVarit = mainVarit;
    }

    /**
     * 获取种植面积
     */
    public Double getZzmj() {
        return zzmj;
    }

    /**
     * 设置种植面积
     */
    public void setZzmj(Double zzmj) {
        this.zzmj = zzmj;
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
     * 获取状态
     */
    public String getPlaceOriginState() {
        return placeOriginState;
    }

    /**
     * 设置状态
     */
    public void setPlaceOriginState(String placeOriginState) {
        this.placeOriginState = placeOriginState == null ? null : placeOriginState.trim();
    }

    /**
     * 获取产地图片
     */
    public String getPlaceOriginUrl() {
        return placeOriginUrl;
    }

    /**
     * 设置产地图片
     */
    public void setPlaceOriginUrl(String placeOriginUrl) {
        this.placeOriginUrl = placeOriginUrl == null ? null : placeOriginUrl.trim();
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
