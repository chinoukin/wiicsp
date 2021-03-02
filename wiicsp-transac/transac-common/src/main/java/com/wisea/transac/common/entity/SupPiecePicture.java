package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class SupPiecePicture extends DataLongEntity<SupPiecePicture> {
    /**
     * 优势单品id
     */
    private Long supPieceId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 图片url
     */
    private String url;

    /**
     * 基地图片类型（图片、视频）
     */
    private String basePictureType;

    public Long getSupPieceId() {
        return supPieceId;
    }

    public void setSupPieceId(Long supPieceId) {
        this.supPieceId = supPieceId;
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

    public String getBasePictureType() {
        return basePictureType;
    }

    public void setBasePictureType(String basePictureType) {
        this.basePictureType = basePictureType;
    }
}
