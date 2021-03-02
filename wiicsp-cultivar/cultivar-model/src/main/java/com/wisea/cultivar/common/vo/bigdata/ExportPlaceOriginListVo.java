package com.wisea.cultivar.common.vo.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.util.excel.annotation.ExcelField;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * PlaceOriginMageListVo
 * 2019/12/02 11:02:15
 */
public class ExportPlaceOriginListVo {

    @ApiModelProperty(value = "产地类型")
    private String placeOriginType;
    @ApiModelProperty(value = "产地名称")
    @ExcelField(title = "产地名称", sort = 0, width = 20)
    private String placeOriginName;
    @ApiModelProperty(value = "所在区域类型")
    @ExcelField(title = "所在地区", sort = 1, width = 20, dictType = "location_type")
    private String locationType;
    @ApiModelProperty(value = "基地类型")
    @ExcelField(title = "产地类型", sort = 2, width = 20, dictType = "jd_type")
    private String jdType;
    @ApiModelProperty(value = "种植面积")
    @ExcelField(title = "种植面积(亩)", sort = 4, width = 20)
    private Double zzmj;
    @ApiModelProperty(value = "经度")
    private Double jd;
    @ApiModelProperty(value = "纬度")
    private Double wd;
    @ApiModelProperty(value = "状态")
    @ExcelField(title = "状态", sort = 7, width = 20, dictType = "place_origin_state")
    private String placeOriginState;
    @ApiModelProperty(value = "产地图片")
    private String placeOriginUrl;
    @ApiModelProperty(value = "品类名称")
    @ExcelField(title = "主要品类", sort = 3, width = 20)
    private String categoryName;
    @ApiModelProperty(value = "创建时间")
    @ExcelField(title = "创建时间", sort = 6, width = 20, formate = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime createDate;
    @ApiModelProperty(value = "经纬度拼接")
    @ExcelField(title = "经纬度", sort = 5, width = 20)
    private String jdwd;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getJdwd() {
        return jdwd;
    }

    public void setJdwd(String jdwd) {
        this.jdwd = jdwd;
    }

    public OffsetDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(OffsetDateTime createDate) {
        this.createDate = createDate;
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

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
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
