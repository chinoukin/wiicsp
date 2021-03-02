package com.wisea.transac.common.po.seller;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("基地详情查询PO")
public class FindBaseInfoPo {
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
