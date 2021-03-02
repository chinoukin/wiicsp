package com.wisea.cultivar.standards.po;

import io.swagger.annotations.ApiModelProperty;

/**
 * IcsClassMagePagePo
 * 2020/07/24 11:21:45
 */
public class IcsClassMageTreePo{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "分类搜索内容（名称或编码）")
    private String classMageQuery;

    public String getClassMageQuery() {
        return classMageQuery;
    }

    public void setClassMageQuery(String classMageQuery) {
        this.classMageQuery = classMageQuery;
    }
}
