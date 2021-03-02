package com.wisea.cultivar.plant.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("ZhfwCommPicture详细信息Vo")
public class ZhfwCommPictureInfoVo {
    @ApiModelProperty(value="")
    private Long commPubId;

    @ApiModelProperty(value="排序")
    private Integer sort;

    @ApiModelProperty(value="图片url")
    private String url;

    @ApiModelProperty(value="图片类型")
    private String commPictureType;
    @ApiModelProperty(value="主图类型")
    private String mainPictureType;


    public String getMainPictureType() {
        return mainPictureType;
    }

    public void setMainPictureType(String mainPictureType) {
        this.mainPictureType = mainPictureType;
    }

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
