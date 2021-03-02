package com.wisea.cultivar.standards.po;

import io.swagger.annotations.ApiModelProperty;

/**
 * ChinaStandardTypeMageListPo
 * 2020/07/24 11:21:45
 */
public class ChinaStandardTypeMageTreePo {

    @ApiModelProperty(value = "分类搜索内容（名称或编码）")
    private String standardTypeQuery;

    public String getStandardTypeQuery() {
        return standardTypeQuery;
    }

    public void setStandardTypeQuery(String standardTypeQuery) {
        this.standardTypeQuery = standardTypeQuery;
    }
}
