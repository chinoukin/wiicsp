package com.wisea.cultivar.common.po.tp;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * OrdCancelReasonMageBatDeletePo
 * 2018/10/10 14:42:38
 */
public class OrdCancelReasonMageBatDeletePo {
    /**
     * 批量删除列表
     */
    @Check(test = "required")
    @ApiModelProperty(value = "批量删除列表")
    private List<Long> delList;

    /**
     * 获取批量删除列表
     */
    public List<Long> getDelList() {
        return delList;
    }

    /**
     * 设置批量删除列表
     */
    public void setDelList(List<Long> delList) {
        this.delList = delList;
    }
}
