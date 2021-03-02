package com.wisea.cultivar.standards.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * IcsClassMageBatDeletePo
 * 2020/07/24 11:21:45
 */
public class IcsClassMageBatDeletePo {
    /**
     * 批量删除列表
     */
    @Check(test = "required")
    @ApiModelProperty(value = "删除id")
    private Long delId;

    public Long getDelId() {
        return delId;
    }

    public void setDelId(Long delId) {
        this.delId = delId;
    }
}
