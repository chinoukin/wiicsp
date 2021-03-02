package com.wisea.cultivar.portal.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * ZhfwCultureZxRecoInsertPo
 * 2020/08/24 20:28:13
 */
public class ZhfwCultureZxRecoInsertPo {
    /**
     * 种植服文化资讯列表id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "required","maxLength" }, length = 19)
    @ApiModelProperty(value = "种植服文化资讯列表id", allowableValues = "length:(,19]")
    private Long zhfwCultureZxListId;

    /**
     * 显示顺序
     */
    @Check(test = { "required","maxLength" }, length = 10)
    @ApiModelProperty(value = "显示顺序", allowableValues = "length:(,10]")
    private Integer sort;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    /**
     * 获取种植服文化资讯列表id
     */
    public Long getZhfwCultureZxListId() {
        return zhfwCultureZxListId;
    }

    /**
     * 设置种植服文化资讯列表id
     */
    public void setZhfwCultureZxListId(Long zhfwCultureZxListId) {
        this.zhfwCultureZxListId = zhfwCultureZxListId;
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
