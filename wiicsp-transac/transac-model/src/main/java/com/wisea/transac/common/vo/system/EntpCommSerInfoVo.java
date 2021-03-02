package com.wisea.transac.common.vo.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("EntpCommSer详细信息Vo")
public class EntpCommSerInfoVo {
    @ApiModelProperty(value="服务ID")
    private Long id;

    @ApiModelProperty(value="服务类型")
    private String serType;

    @ApiModelProperty(value="服务简称")
    private String serAbbrev;

    @ApiModelProperty(value="服务说明")
    private String serIntr;

    @ApiModelProperty(value="排序")
    private Integer sort;

    @ApiModelProperty(value="停启用状态")
    private String effeInvalState;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerType() {
        return serType;
    }

    public void setSerType(String serType) {
        this.serType = serType;
    }

    public String getSerAbbrev() {
        return serAbbrev;
    }

    public void setSerAbbrev(String serAbbrev) {
        this.serAbbrev = serAbbrev;
    }

    public String getSerIntr() {
        return serIntr;
    }

    public void setSerIntr(String serIntr) {
        this.serIntr = serIntr;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getEffeInvalState() {
        return effeInvalState;
    }

    public void setEffeInvalState(String effeInvalState) {
        this.effeInvalState = effeInvalState;
    }
}
