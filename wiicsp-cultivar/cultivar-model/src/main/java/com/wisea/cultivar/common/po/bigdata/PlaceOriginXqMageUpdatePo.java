package com.wisea.cultivar.common.po.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * PlaceOriginXqMageUpdatePo
 * 2019/12/02 11:02:15
 */
public class PlaceOriginXqMageUpdatePo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "required" })
    @ApiModelProperty(value = "id", required = true)
    private Long id;

    /**
     * 产地id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "产地id", allowableValues = "length:(,19]")
    private Long placeOriginId;

    /**
     * 详情名称
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "详情名称", allowableValues = "mixLength:(,255]")
    private String detailsName;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    /**
     * 删除标记
     */
    @Check(test = { "maxLength" }, mixLength = 1)
    @ApiModelProperty(value = "删除标记", allowableValues = "mixLength:(,1]")
    private String delFlag;

    /**
     * 详情
     */
    @Check(test = { "maxLength" }, mixLength = 16777215)
    @ApiModelProperty(value = "详情", allowableValues = "mixLength:(,16777215]")
    private String details;

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
