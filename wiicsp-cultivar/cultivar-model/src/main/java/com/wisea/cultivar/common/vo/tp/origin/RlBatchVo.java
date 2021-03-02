package com.wisea.cultivar.common.vo.tp.origin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author wangjiahao
 */
@ApiModel("入栏批次")
public class RlBatchVo {
    @ApiModelProperty("批次号")
    private String batchName;
    @ApiModelProperty("数量")
    private Integer count;

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
