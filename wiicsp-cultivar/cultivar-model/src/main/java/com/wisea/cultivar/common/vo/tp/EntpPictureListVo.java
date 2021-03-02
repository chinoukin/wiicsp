package com.wisea.cultivar.common.vo.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * EntpPictureListVo
 * 2018/09/18 14:36:47
 */
public class EntpPictureListVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 商家资料id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商家资料id")
    private Long entpDataId;

    /**
     * 图片url
     */
    @ApiModelProperty(value = "图片url")
    private String url;

    /**
     * 获取id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(Long id) {
        this.id = id;
    }

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
