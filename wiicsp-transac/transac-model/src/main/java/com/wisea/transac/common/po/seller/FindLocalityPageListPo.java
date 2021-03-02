package com.wisea.transac.common.po.seller;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.seller.FindLocalityPageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("产地交易商家PO")
public class FindLocalityPageListPo extends PagePo<FindLocalityPageListVo> {

    @ApiModelProperty(value = "会员id", hidden = true)
    private Long membId;

    @ApiModelProperty(value = "基地名称")
    private String baseName;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }
}
