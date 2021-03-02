package com.wisea.cultivar.plant.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页查询MembCollectionVo")
public class MembCollectionPageListVo {
    @ApiModelProperty(value="会员id")
    private Long membId;

    @ApiModelProperty(value="收藏类型")
    private Long collectionType;

    @ApiModelProperty(value="收藏id")
    private Long collectionId;

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
