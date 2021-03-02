package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * samp_picture 表实体
 * 样品图片信息
 * 2018/09/18 14:36:47
 */
public class SampPicture extends DataLongEntity<SampPicture> {
    private static final long serialVersionUID = 1L;

    /**
     * 样品id
     */
    private Long sampId;

    /**
     * 图片类型
     */
    private String pictureType;

    /**
     * 图片url
     */
    private String url;

    /**
     * 获取样品id
     */
    public Long getSampId() {
        return sampId;
    }

    /**
     * 设置样品id
     */
    public void setSampId(Long sampId) {
        this.sampId = sampId;
    }

    /**
     * 获取图片类型
     */
    public String getPictureType() {
        return pictureType;
    }

    /**
     * 设置图片类型
     */
    public void setPictureType(String pictureType) {
        this.pictureType = pictureType == null ? null : pictureType.trim();
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
