package com.wisea.cultivar.common.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * SearchTagsMageInsertPo
 * 2020/08/04 09:36:59
 */
public class SearchTagsMageInsertPo {
    /**
     * 搜索标签名称
     */
    @Check(test = { "maxLength" }, mixLength = 100)
    @ApiModelProperty(value = "搜索标签名称", allowableValues = "mixLength:(,100]")
    private String searchTagsName;

    /**
     * 排序
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "排序", allowableValues = "length:(,10]")
    private Integer sort;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    /**
     * 获取搜索标签名称
     */
    public String getSearchTagsName() {
        return searchTagsName;
    }

    /**
     * 设置搜索标签名称
     */
    public void setSearchTagsName(String searchTagsName) {
        this.searchTagsName = searchTagsName == null ? null : searchTagsName.trim();
    }

    /**
     * 获取排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
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
