package com.wisea.cultivar.standards.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * farm_work_type_dict 表实体
 * 农事操作类型字典
 * 2020/07/24 11:21:45
 */
public class FarmWorkTypeDict extends DataLongEntity<FarmWorkTypeDict> {
    private static final long serialVersionUID = 1L;

    /**
     * 父节点id
     */
    private Long parentId;

    /**
     * 名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 农事类别
     */
    private String farmWorkType;

    /**
     * 是否设为常用
     */
    private String comUsedFlag;

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
}
