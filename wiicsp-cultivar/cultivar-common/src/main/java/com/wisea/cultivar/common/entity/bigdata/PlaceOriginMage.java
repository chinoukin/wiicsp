package com.wisea.cultivar.common.entity.bigdata;

import com.wisea.cloud.common.entity.DataLongEntity;
import io.swagger.annotations.ApiModelProperty;

/**
 * place_origin_mage 表实体
 * 产地管理
 * 2019/12/02 11:02:15
 */
public class PlaceOriginMage extends DataLongEntity<PlaceOriginMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 产地类型
     */
    private String placeOriginType;

    /**
     * 产地名称
     */
    private String placeOriginName;

    @ApiModelProperty(value = "品类名称")
    private String categoryName;

    /**
     * 所在区域
     */
    private String locationType;

    /**
     * 基地类型
     */
    private String jdType;

    /**
     * 主要品种
     */
    private Long categoryId;

    /**
     * 种植面积
     */
    private Double zzmj;

    /**
     * 经度
     */
    private Double jd;

    /**
     * 纬度
     */
    private Double wd;

    /**
     * 状态
     */
    private String placeOriginState;

    /**
     * 产地图片
     */
    private String placeOriginUrl;

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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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
