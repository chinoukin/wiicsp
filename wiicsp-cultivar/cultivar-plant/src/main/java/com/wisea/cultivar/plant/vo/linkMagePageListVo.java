package com.wisea.cultivar.plant.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页查询linkMageVo")
public class linkMagePageListVo {
    @ApiModelProperty(value="环节名称")
    private String linkName;

    @ApiModelProperty(value="显示顺序")
    private Integer sort;

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
