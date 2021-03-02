package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

public class OriBatchInfo extends DataLongEntity<OriBatchInfo> {
    /**
     * 会员id
     */
    @ApiModelProperty("会员ID")
    private Long membId;

    /**
     * 批次名称
     */
    @ApiModelProperty("批次名称")
    @Check(test = "required")
    private String batchName;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }
}
