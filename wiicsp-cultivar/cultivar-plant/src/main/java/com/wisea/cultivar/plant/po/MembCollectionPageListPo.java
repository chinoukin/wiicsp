package com.wisea.cultivar.plant.po;

import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.plant.vo.MembCollectionPageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页查询MembCollectionPo")
public class MembCollectionPageListPo extends PagePo<MembCollectionPageListVo> {
    @ApiModelProperty(value="会员id")
    private Long membId;

    @ApiModelProperty(value="收藏类型" +
            "0政策信息 "+
            "1标准信息" +
            "2农技信息" +
            "3病虫害信息" +
            "4茶果茶籽求购信息" +
            "5茶果茶籽供应信息" +
            "6种植服务供应信息")
    @Check(test = {"required"})
    private Long collectionType;


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
