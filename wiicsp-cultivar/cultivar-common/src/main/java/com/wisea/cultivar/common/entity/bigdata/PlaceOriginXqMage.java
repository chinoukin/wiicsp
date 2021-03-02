package com.wisea.cultivar.common.entity.bigdata;

import com.wisea.cloud.common.entity.DataLongEntity;
import io.swagger.annotations.ApiModelProperty;

/**
 * place_origin_xq_mage 表实体
 * 产地详情管理
 * 2019/12/02 11:02:15
 */
public class PlaceOriginXqMage extends DataLongEntity<PlaceOriginXqMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 产地id
     */
    @ApiModelProperty(value = "产地id")
    private Long placeOriginId;

    /**
     * 详情名称
     */
    @ApiModelProperty(value = "详情名称")
    private String detailsName;

    /**
     * 详情
     */
    @ApiModelProperty(value = "详情")
    private String details;

    /**
     * 获取产地id
     */
    public Long getPlaceOriginId() {
        return placeOriginId;
    }

    /**
     * 设置产地id
     */
    public void setPlaceOriginId(Long placeOriginId) {
        this.placeOriginId = placeOriginId;
    }

    /**
     * 获取详情名称
     */
    public String getDetailsName() {
        return detailsName;
    }

    /**
     * 设置详情名称
     */
    public void setDetailsName(String detailsName) {
        this.detailsName = detailsName == null ? null : detailsName.trim();
    }

    /**
     * 获取详情
     */
    public String getDetails() {
        return details;
    }

    /**
     * 设置详情
     */
    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }
}
