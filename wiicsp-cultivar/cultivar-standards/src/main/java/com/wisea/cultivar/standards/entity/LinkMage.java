package com.wisea.cultivar.standards.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * link_mage 表实体
 * 环节管理
 * 2020/07/24 11:21:45
 */
public class LinkMage extends DataLongEntity<LinkMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 环节名称
     */
    private String linkName;

    /**
     * 显示顺序
     */
    private Integer sort;

    /**
     * 获取环节名称
     */
    public String getLinkName() {
        return linkName;
    }

    /**
     * 设置环节名称
     */
    public void setLinkName(String linkName) {
        this.linkName = linkName == null ? null : linkName.trim();
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
}
