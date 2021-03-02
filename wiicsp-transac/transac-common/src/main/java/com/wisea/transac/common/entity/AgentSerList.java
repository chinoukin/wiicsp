package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class AgentSerList extends DataLongEntity<AgentSerList> {
    /**
     * 图标
     */
    private String pictureUrl;

    /**
     * 服务简称
     */
    private String serName;

    /**
     * 服务说明
     */
    private String serContent;

    /**
     * 显示顺序
     */
    private Integer sort;

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getSerName() {
        return serName;
    }

    public void setSerName(String serName) {
        this.serName = serName;
    }

    public String getSerContent() {
        return serContent;
    }

    public void setSerContent(String serContent) {
        this.serContent = serContent;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
