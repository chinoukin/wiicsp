package com.wisea.cultivar.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class CommAttriSet extends DataLongEntity<CommAttriSet> {
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
     * 品类等级用来验证是哪一级信息
     */
    private String level;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

    public Long getAttriId() {
        return attriId;
    }

    public void setAttriId(Long attriId) {
        this.attriId = attriId;
    }

    public String getIfRequ() {
        return ifRequ;
    }

    public void setIfRequ(String ifRequ) {
        this.ifRequ = ifRequ;
    }

    public String getIfSearch() {
        return ifSearch;
    }

    public void setIfSearch(String ifSearch) {
        this.ifSearch = ifSearch;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
