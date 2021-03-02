package com.wisea.cultivar.plant.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class ZhfwCommPicture extends DataLongEntity<ZhfwCommPicture> {
    /**
     *
     */
    private Long commPubId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 图片url
     */
    private String url;

    /**
     * 图片类型
     */
    private String commPictureType;

    public Long getCommPubId() {
        return commPubId;
    }

    public void setCommPubId(Long commPubId) {
        this.commPubId = commPubId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCommPictureType() {
        return commPictureType;
    }

    public void setCommPictureType(String commPictureType) {
        this.commPictureType = commPictureType;
    }
}
