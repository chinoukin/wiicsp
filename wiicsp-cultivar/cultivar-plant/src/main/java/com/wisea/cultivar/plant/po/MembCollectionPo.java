package com.wisea.cultivar.plant.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("新增或修改MembCollectionPo")
public class MembCollectionPo {
    @ApiModelProperty(value="数据ID，修改时该字段必填")
    private Long id;

    @ApiModelProperty(value="会员id")
    @Check(test = { "required" })
    private Long membId;

    @ApiModelProperty(value="收藏类型 0政策信息" +
            "1标准信息" +
            "2农技信息" +
            "3病虫害信息" +
            "4茶果茶籽求购信息" +
            "5茶果茶籽供应信息" +
            "6种植服务供应信息")
    @Check(test = { "required" })
    private Long collectionType;

    @ApiModelProperty(value="详情id")
    @Check(test = { "required" })
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
