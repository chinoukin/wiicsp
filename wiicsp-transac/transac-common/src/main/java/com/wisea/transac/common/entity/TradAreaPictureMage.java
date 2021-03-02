package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class TradAreaPictureMage extends DataLongEntity<TradAreaPictureMage> {
    /**
     * 交易区id
     */
    private Long tradAreaId;

    /**
     * 图片url
     */
    private String url;

    /**
     * 显示顺序
     */
    private Integer sort;

    public Long getTradAreaId() {
        return tradAreaId;
    }

    public void setTradAreaId(Long tradAreaId) {
        this.tradAreaId = tradAreaId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
