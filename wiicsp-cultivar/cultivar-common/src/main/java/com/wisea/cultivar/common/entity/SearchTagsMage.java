package com.wisea.cultivar.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * search_tags_mage 表实体
 * 搜索标签设置
 * 2020/08/04 09:36:59
 */
public class SearchTagsMage extends DataLongEntity<SearchTagsMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 搜索标签名称
     */
    private String searchTagsName;

    /**
     * 排序
     */
    private Integer sort;

    /**
     *
     * @mbg.generated
     */
    public SearchTagsMage() {
        super();
    }

    /**
     * 获取搜索标签名称
     */
    public String getSearchTagsName() {
        return searchTagsName;
    }

    /**
     * 设置搜索标签名称
     */
    public void setSearchTagsName(String searchTagsName) {
        this.searchTagsName = searchTagsName == null ? null : searchTagsName.trim();
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
}
