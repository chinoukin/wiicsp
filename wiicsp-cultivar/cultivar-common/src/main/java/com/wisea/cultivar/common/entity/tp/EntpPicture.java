package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * entp_picture 表实体
 * 商家图片
 * 2018/09/18 14:36:47
 */
public class EntpPicture extends DataLongEntity<EntpPicture> {
    private static final long serialVersionUID = 1L;

    /**
     * 商家资料id
     */
    private Long entpDataId;

    /**
     * 图片url
     */
    private String url;

    /**
     * 获取商家资料id
     */
    public Long getEntpDataId() {
        return entpDataId;
    }

    /**
     * 设置商家资料id
     */
    public void setEntpDataId(Long entpDataId) {
        this.entpDataId = entpDataId;
    }

    /**
     * 获取图片url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置图片url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}
