package com.wisea.cultivar.plant.po;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.plant.vo.CommGyPubInfoPageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页查询CommGyPubInfoPo")
public class CommGyPubInfoPageListPo extends PagePo<CommGyPubInfoPageListVo> {
    @ApiModelProperty(value="会员id")
    private Long membId;

    @ApiModelProperty(value="供求产品类型 0茶果 1茶籽")
    private String commQgType;

    @ApiModelProperty(value="关键字搜索")
    private String pubGyTitle;

    @ApiModelProperty(value="所在产地")
    private String placeOrigin;

    @ApiModelProperty(value="供求状态类型   0 上架 1下架")
    private String qgStateType;

    @ApiModelProperty(value = "排序 默认=5 发布时间倒序 0 联系数正序1 联系数倒序2 浏览数正序3 浏览数倒序4更新时间倒序5")
    private Integer sort=5;

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getCommQgType() {
        return commQgType;
    }

    public void setCommQgType(String commQgType) {
        this.commQgType = commQgType;
    }

    public String getPubGyTitle() {
        return pubGyTitle;
    }

    public void setPubGyTitle(String pubGyTitle) {
        this.pubGyTitle = pubGyTitle;
    }

    public String getQgStateType() {
        return qgStateType;
    }

    public void setQgStateType(String qgStateType) {
        this.qgStateType = qgStateType;
    }

    public String getPlaceOrigin() {
        return placeOrigin;
    }

    public void setPlaceOrigin(String placeOrigin) {
        this.placeOrigin = placeOrigin;
    }
}
