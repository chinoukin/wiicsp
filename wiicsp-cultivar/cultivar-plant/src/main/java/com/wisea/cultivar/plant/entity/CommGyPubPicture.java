package com.wisea.cultivar.plant.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class CommGyPubPicture extends DataLongEntity<CommGyPubPicture> {
    /**
     * 商品供应发布id
     */
    private Long commGyPubId;

    /**
     * 图片url
     */
    private String url;

    public Long getCommGyPubId() {
        return commGyPubId;
    }

    public void setCommGyPubId(Long commGyPubId) {
        this.commGyPubId = commGyPubId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
