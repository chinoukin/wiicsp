package com.wisea.cultivar.portal.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * ZhfwZczxCatgMageBatDeletePo
 * 2020/08/24 20:28:13
 */
public class ZhfwZczxCatgMageBatDeletePo {
    /**
     * 批量删除列表
     */
    @Check(test = "required")
    @ApiModelProperty(value = "删除ID")
    private Long delId;

    public Long getDelId() {
        return delId;
    }

    public void setDelId(Long delId) {
        this.delId = delId;
    }

}
