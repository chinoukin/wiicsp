package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * comm_attri_set 表实体
 * 商品属性设置
 * 2018/09/18 14:36:47
 */
public class CommAttriSet extends DataLongEntity<CommAttriSet> {
    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    private Long commId;

    /**
     * 属性ID
     */
    private Long attriId;

    /**
     * 是否必填
     */
    private String ifRequ;

    /**
     * 搜索条件
     */
    private String ifSearch;

    /**
     * 显示顺序
     */
    private Integer sort;

    /**
     * 获取商品id
     */
    public Long getCommId() {
        return commId;
    }

    /**
     * 设置商品id
     */
    public void setCommId(Long commId) {
        this.commId = commId;
    }

    /**
     * 获取属性ID
     */
    public Long getAttriId() {
        return attriId;
    }

    /**
     * 设置属性ID
     */
    public void setAttriId(Long attriId) {
        this.attriId = attriId;
    }

    /**
     * 获取是否必填
     */
    public String getIfRequ() {
        return ifRequ;
    }

    /**
     * 设置是否必填
     */
    public void setIfRequ(String ifRequ) {
        this.ifRequ = ifRequ == null ? null : ifRequ.trim();
    }

    /**
     * 获取搜索条件
     */
    public String getIfSearch() {
        return ifSearch;
    }

    /**
     * 设置搜索条件
     */
    public void setIfSearch(String ifSearch) {
        this.ifSearch = ifSearch == null ? null : ifSearch.trim();
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
