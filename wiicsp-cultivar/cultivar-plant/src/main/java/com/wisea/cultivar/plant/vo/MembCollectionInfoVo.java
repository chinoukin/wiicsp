package com.wisea.cultivar.plant.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("MembCollection详细信息Vo")
public class MembCollectionInfoVo {


    @ApiModelProperty(value="收藏id")
    private Long id;
    @ApiModelProperty(value="会员id")
    private Long membId;

    @ApiModelProperty(value="收藏类型")
    private Long collectionType;

    @ApiModelProperty(value="收藏id")
    private Long collectionId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public Long getCollectionType() {
        return collectionType;
    }

    public void setCollectionType(Long collectionType) {
        this.collectionType = collectionType;
    }

    public Long getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Long collectionId) {
        this.collectionId = collectionId;
    }
}
