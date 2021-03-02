package com.wisea.cultivar.standards.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.standards.vo.FarmWorkTypeDictListVo;
import io.swagger.annotations.ApiModelProperty;

/**
 * FarmWorkTypeDictPagePo
 * 2020/07/24 11:21:45
 */
public class FarmWorkTypeDictPagePo extends PagePo<FarmWorkTypeDictListVo> {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 父节点id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "父节点id")
    private Long parentId;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sort;

    /**
     * 农事类别
     */
    @ApiModelProperty(value = "农事类别")
    private String farmWorkType;

    /**
     * 是否设为常用
     */
    @ApiModelProperty(value = "是否设为常用")
    private String comUsedFlag;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    /**
     * 获取id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(Long id) {
        this.id = id;
    }

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

    /**
     * 获取删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}
