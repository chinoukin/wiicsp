package com.wisea.cultivar.explorer.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * demons_base_introduce 表实体
 * 示范基地详细介绍
 * 2020/08/11 13:21:46
 */
public class DemonsBaseIntroduce extends DataLongEntity<DemonsBaseIntroduce> {
    private static final long serialVersionUID = 1L;

    /**
     * 示范基地id
     */
    private Long demonsBaseId;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 排序
     */
    private Integer sort;

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     *
     * @mbg.generated
     */
    public DemonsBaseIntroduce() {
        super();
    }

    /**
     * 获取示范基地id
     */
    public Long getDemonsBaseId() {
        return demonsBaseId;
    }

    /**
     * 设置示范基地id
     */
    public void setDemonsBaseId(Long demonsBaseId) {
        this.demonsBaseId = demonsBaseId;
    }

    /**
     * 获取标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
