package com.wisea.cultivar.common.po.tp.trade;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 备注PO
 */
@ApiModel("备注PO")
public class RemarkPo {
    @ApiModelProperty("数据ID")
    @Check(test = "required")
    private Long id;
    @ApiModelProperty("操作备注")
    @Check(test = "required")
    private String remarks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
