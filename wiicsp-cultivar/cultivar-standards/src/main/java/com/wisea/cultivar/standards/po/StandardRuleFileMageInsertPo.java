package com.wisea.cultivar.standards.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * StandardRuleFileMageInsertPo
 * 2020/07/24 11:21:45
 */
public class StandardRuleFileMageInsertPo {
    /**
     * 标准规范管理id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "标准规范管理id", allowableValues = "length:(,19]")
    private Long standardRuleMageId;

    /**
     * 标准附件url
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "标准附件url", allowableValues = "mixLength:(,255]")
    private String url;

    /**
     * 显示顺序
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "显示顺序", allowableValues = "length:(,10]")
    private Integer sort;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    /**
     * 获取标准规范管理id
     */
    public Long getStandardRuleMageId() {
        return standardRuleMageId;
    }

    /**
     * 设置标准规范管理id
     */
    public void setStandardRuleMageId(Long standardRuleMageId) {
        this.standardRuleMageId = standardRuleMageId;
    }

    /**
     * 获取标准附件url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置标准附件url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取显示顺序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置显示顺序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
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
