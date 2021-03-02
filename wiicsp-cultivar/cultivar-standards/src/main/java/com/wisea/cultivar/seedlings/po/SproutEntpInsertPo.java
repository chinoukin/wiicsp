package com.wisea.cultivar.seedlings.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * SproutEntpInsertPo
 * 2020/08/06 14:19:24
 */
public class SproutEntpInsertPo {
    /**
     * 种苗目录管理id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "种苗目录管理id", allowableValues = "length:(,19]")
    private Long sproutCatalogMageId;

    /**
     * 服务商id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "服务商id", allowableValues = "length:(,19]")
    private Long membId;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    /**
     * 获取种苗目录管理id
     */
    public Long getSproutCatalogMageId() {
        return sproutCatalogMageId;
    }

    /**
     * 设置种苗目录管理id
     */
    public void setSproutCatalogMageId(Long sproutCatalogMageId) {
        this.sproutCatalogMageId = sproutCatalogMageId;
    }

    /**
     * 获取服务商id
     */
    public Long getMembId() {
        return membId;
    }

    /**
     * 设置服务商id
     */
    public void setMembId(Long membId) {
        this.membId = membId;
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
}
