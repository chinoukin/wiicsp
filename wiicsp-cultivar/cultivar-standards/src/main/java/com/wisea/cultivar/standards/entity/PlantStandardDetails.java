package com.wisea.cultivar.standards.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * plant_standard_details 表实体
 * 标准详情
 * 2020/07/24 11:21:45
 */
public class PlantStandardDetails extends DataLongEntity<PlantStandardDetails> {
    private static final long serialVersionUID = 1L;

    /**
     * 种植标准管理id
     */
    private Long plantStandardMageId;

    /**
     * 标题名称
     */
    private String titleName;

    /**
     * 显示顺序
     */
    private Integer sort;

    /**
     * 内容介绍
     */
    private String content;

    /**
     * 获取种植标准管理id
     */
    public Long getPlantStandardMageId() {
        return plantStandardMageId;
    }

    /**
     * 设置种植标准管理id
     */
    public void setPlantStandardMageId(Long plantStandardMageId) {
        this.plantStandardMageId = plantStandardMageId;
    }

    /**
     * 获取标题名称
     */
    public String getTitleName() {
        return titleName;
    }

    /**
     * 设置标题名称
     */
    public void setTitleName(String titleName) {
        this.titleName = titleName == null ? null : titleName.trim();
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
     * 获取内容介绍
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容介绍
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
