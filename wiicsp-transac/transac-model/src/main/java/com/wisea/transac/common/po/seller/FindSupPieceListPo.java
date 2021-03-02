package com.wisea.transac.common.po.seller;

import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.FindSupPieceListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("优势单品分页查询PO")
public class FindSupPieceListPo extends PagePo<FindSupPieceListVo> {
    /**
     * 基地id
     */
    @ApiModelProperty(value = "基地id")
    @Check(test = "required")
    private Long baseId;

    public Long getBaseId() {
        return baseId;
    }

    public void setBaseId(Long baseId) {
        this.baseId = baseId;
    }
}
