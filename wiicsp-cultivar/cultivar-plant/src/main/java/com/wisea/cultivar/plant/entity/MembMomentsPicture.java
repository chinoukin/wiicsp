package com.wisea.cultivar.plant.entity;

import com.wisea.cloud.common.entity.DataLongEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("圈子图片信息")
public class MembMomentsPicture extends DataLongEntity<MembMomentsPicture> {
    /**
     * 我的圈子id
     */
    @ApiModelProperty("我的圈子id")
    private Long membMomentsId;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer sort;

    /**
     * 图片url
     */
    @ApiModelProperty("图片url")
    private String url;

    /**
     * 图片类型
     */
    @ApiModelProperty("图片类型,0-图片 1-视频")
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
