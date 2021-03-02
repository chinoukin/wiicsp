package com.wisea.cultivar.explorer.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * DemonsBaseIntroduceInsertPo
 * 2020/08/11 13:21:46
 */
public class DemonsBaseIntroduceInsertPo {
    /**
     * 示范基地id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "示范基地id", allowableValues = "length:(,19]")
    private Long demonsBaseId;

    /**
     * 标题
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "标题", allowableValues = "mixLength:(,30]")
    private String title;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    /**
     * 内容
     */
    @Check(test = { "maxLength" }, mixLength = 16777215)
    @ApiModelProperty(value = "内容", allowableValues = "mixLength:(,16777215]")
    private String content;

    /**
     * sort 排序
     */
    @Check(test = { "required" })
    @ApiModelProperty(value = "sort", required = true)
    private Integer sort;

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取示范基地id
     */
    public Long getDemonsBaseId() {
        return demonsBaseId;
    }

    /**
     * 设置示范基地id
     */
    public void setDemonsBaseId(Long demonsBaseId) {
        this.demonsBaseId = demonsBaseId;
    }

    /**
     * 获取标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
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
     * 获取内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
