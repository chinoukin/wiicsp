package com.wisea.cultivar.common.po.tp;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModelProperty;

/**
 * EntpPictureInsertPo
 * 2018/09/18 14:36:47
 */
public class EntpPictureInsertPo {

    /**
     * 图片url
     */
    @Check(test = {"required","maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "图片url")
    private String url;

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
