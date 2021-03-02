package com.wisea.cultivar.supply.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * 图片
 * @author chengq
 * @date 2020/8/12 10:14
 */
public class PictureVo {

    @ApiModelProperty(value = "图片")
    private String url;

    @ApiModelProperty(value = "图片/视频类型 0-图片 1-视频")
    private String pictureType;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPictureType() {
        return pictureType;
    }

    public void setPictureType(String pictureType) {
        this.pictureType = pictureType;
    }
}
