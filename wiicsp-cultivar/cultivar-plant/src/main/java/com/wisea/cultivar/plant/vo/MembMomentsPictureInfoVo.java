package com.wisea.cultivar.plant.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("MembMomentsPicture详细信息Vo")
public class MembMomentsPictureInfoVo {
    @ApiModelProperty(value="我的圈子id")
    private Long membMomentsId;

    @ApiModelProperty(value="排序")
    private Integer sort;

    @ApiModelProperty(value="图片url")
    private String url;

    @ApiModelProperty(value="图片类型")
    private String commPictureType;

    public Long getMembMomentsId() {
        return membMomentsId;
    }

    public void setMembMomentsId(Long membMomentsId) {
        this.membMomentsId = membMomentsId;
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
