package com.wisea.cultivar.supply.entity;

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

    /**
     * 主图类型
     */
    private String mainPictureType;

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

    public String getMainPictureType() {
        return mainPictureType;
    }

    public void setMainPictureType(String mainPictureType) {
        this.mainPictureType = mainPictureType;
    }

    public ZhfwCommPicture() {
    }

    public ZhfwCommPicture(Long commPubId, Integer sort, String url, String commPictureType, String mainPictureType) {
        this.commPubId = commPubId;
        this.sort = sort;
        this.url = url;
        this.commPictureType = commPictureType;
        this.mainPictureType = mainPictureType;
    }
}
