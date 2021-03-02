package com.wisea.cultivar.plant.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("查询详情")
public class PolicyTechnologyInfoPo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="（产地通可不传）会员id")
    private Long membId;


    @ApiModelProperty(value="（产地通可不传）收藏类型")
    private Long collectionType;

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
}
