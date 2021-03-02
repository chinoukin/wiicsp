package com.wisea.cultivar.plant.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("新增或修改MembMomentsPicturePo")
public class MembMomentsPicturePo {
    @ApiModelProperty(value="数据ID，修改时该字段必填")
    private Long id;

    @ApiModelProperty(value="我的圈子id")
    private Long membMomentsId;

    @ApiModelProperty(value="排序")
    private Integer sort;

    @ApiModelProperty(value="图片url")
    private String url;

    @ApiModelProperty(value="图片类型")
    private String commPictureType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
