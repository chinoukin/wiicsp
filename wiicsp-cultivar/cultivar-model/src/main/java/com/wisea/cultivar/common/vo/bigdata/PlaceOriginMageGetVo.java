package com.wisea.cultivar.common.vo.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * PlaceOriginMageGetVo
 * 2019/12/02 11:02:15
 */
public class PlaceOriginMageGetVo {

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "产地类型")
    private String placeOriginType;
    @ApiModelProperty(value = "产地名称")
    private String placeOriginName;
    @ApiModelProperty(value = "所在区域")
    private String locationType;
    @ApiModelProperty(value = "基地类型")
    private String jdType;
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "主要品种")
    private Long categoryId;
    @ApiModelProperty(value = "品类名称")
    private String categoryName;
    @ApiModelProperty(value = "种植面积")
    private Double zzmj;
    @ApiModelProperty(value = "经度")
    private Double jd;
    @ApiModelProperty(value = "纬度")
    private Double wd;
    @ApiModelProperty(value = "状态")
    private String placeOriginState;
    @ApiModelProperty(value = "产地图片")
    private String placeOriginUrl;
    @ApiModelProperty(value = "产地详情")
    private List<PlaceOriginXqMageListVo> placeOriginXqMageListVo;
    @ApiModelProperty(value = "已选企业")
    private List<YxEntpListVo> yxEntpListVo;

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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<PlaceOriginXqMageListVo> getPlaceOriginXqMageListVo() {
        return placeOriginXqMageListVo;
    }

    public void setPlaceOriginXqMageListVo(List<PlaceOriginXqMageListVo> placeOriginXqMageListVo) {
        this.placeOriginXqMageListVo = placeOriginXqMageListVo;
    }

    public List<YxEntpListVo> getYxEntpListVo() {
        return yxEntpListVo;
    }

    public void setYxEntpListVo(List<YxEntpListVo> yxEntpListVo) {
        this.yxEntpListVo = yxEntpListVo;
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

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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
}
