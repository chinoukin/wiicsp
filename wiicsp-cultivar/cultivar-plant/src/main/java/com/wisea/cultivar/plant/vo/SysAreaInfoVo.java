package com.wisea.cultivar.plant.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("SysArea详细信息Vo")
public class SysAreaInfoVo {
    @ApiModelProperty(value="父级编号")
    private String parentId;

    @ApiModelProperty(value="所有父级编号")
    private String parentIds;

    @ApiModelProperty(value="名称")
    private String name;

    @ApiModelProperty(value="")
    private String shortName;

    @ApiModelProperty(value="排序")
    private Long sort;

    @ApiModelProperty(value="区域编码")
    private String code;

    @ApiModelProperty(value="区域类型")
    private String type;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
