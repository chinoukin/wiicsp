package com.wisea.cultivar.seedlings.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * BuySproutInfoInsertPo
 * 2020/08/06 14:19:24
 */
public class BuySproutInfoInsertPo {
    /**
     * 补贴申请管理id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "补贴申请管理id", allowableValues = "length:(,19]")
    private Long subsidyApplMageId;

    /**
     * 服务单id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "服务单id", allowableValues = "length:(,19]")
    private Long serListId;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    /**
     * 获取补贴申请管理id
     */
    public Long getSubsidyApplMageId() {
        return subsidyApplMageId;
    }

    /**
     * 设置补贴申请管理id
     */
    public void setSubsidyApplMageId(Long subsidyApplMageId) {
        this.subsidyApplMageId = subsidyApplMageId;
    }

    /**
     * 获取服务单id
     */
    public Long getSerListId() {
        return serListId;
    }

    /**
     * 设置服务单id
     */
    public void setSerListId(Long serListId) {
        this.serListId = serListId;
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
