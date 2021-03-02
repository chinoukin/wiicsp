package com.wisea.cultivar.common.po.tp.origin;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author wangjiahao
 * @version 1.0
 * @className OriClQuarantineGetPo
 * @since 2019-03-25 11:28
 */
@ApiModel("出栏检疫报告查询PO")
public class OriClQuarantineGetPo {

    @ApiModelProperty("出栏批次Id")
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = "required")
    private Long clBatchId;

    public Long getClBatchId() {
        return clBatchId;
    }

    public void setClBatchId(Long clBatchId) {
        this.clBatchId = clBatchId;
    }

}
