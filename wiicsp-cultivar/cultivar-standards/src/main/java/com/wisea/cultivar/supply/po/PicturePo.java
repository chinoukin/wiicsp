package com.wisea.cultivar.supply.po;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;

/**
 * 图片
 * @author chengq
 * @date 2020/8/12 10:14
 */
public class PicturePo {

    @ApiModelProperty(value = "图片")
    private String url;

    @ApiModelProperty(value = "图片/视频类型 0-图片 1-视频")
    @Pattern(regexp = "[01]", message = "图片/视频类型只能为0或1")
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
