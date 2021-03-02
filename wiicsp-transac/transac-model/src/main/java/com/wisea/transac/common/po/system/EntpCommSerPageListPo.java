package com.wisea.transac.common.po.system;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.system.EntpCommSerPageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页查询EntpCommSerPo")
public class EntpCommSerPageListPo extends PagePo<EntpCommSerPageListVo> {
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
