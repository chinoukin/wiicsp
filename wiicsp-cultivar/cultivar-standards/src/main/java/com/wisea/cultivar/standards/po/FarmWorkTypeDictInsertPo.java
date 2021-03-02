package com.wisea.cultivar.standards.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * FarmWorkTypeDictInsertPo
 * 2020/07/24 11:21:45
 */
public class FarmWorkTypeDictInsertPo {
    /**
     * 父节点id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "父节点id", allowableValues = "length:(,19]")
    private Long parentId;

    /**
     * 名称
     */
    @Check(test = { "maxLength" }, mixLength = 50)
    @ApiModelProperty(value = "名称", allowableValues = "mixLength:(,50]")
    private String name;

    /**
     * 排序
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "排序", allowableValues = "length:(,10]")
    private Integer sort;

    /**
     * 农事类别
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "农事类别", allowableValues = "mixLength:(,5]")
    private String farmWorkType;

    /**
     * 是否设为常用
     */
    @Check(test = { "maxLength" }, mixLength = 1)
    @ApiModelProperty(value = "是否设为常用", allowableValues = "mixLength:(,1]")
    private String comUsedFlag;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    /**
     * 获取父节点id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父节点id
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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
     * 获取农事类别
     */
    public String getFarmWorkType() {
        return farmWorkType;
    }

    /**
     * 设置农事类别
     */
    public void setFarmWorkType(String farmWorkType) {
        this.farmWorkType = farmWorkType == null ? null : farmWorkType.trim();
    }

    /**
     * 获取是否设为常用
     */
    public String getComUsedFlag() {
        return comUsedFlag;
    }

    /**
     * 设置是否设为常用
     */
    public void setComUsedFlag(String comUsedFlag) {
        this.comUsedFlag = comUsedFlag == null ? null : comUsedFlag.trim();
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
