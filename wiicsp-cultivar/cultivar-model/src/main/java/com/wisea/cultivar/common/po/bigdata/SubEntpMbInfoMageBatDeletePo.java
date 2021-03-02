package com.wisea.cultivar.common.po.bigdata;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * SubEntpMbInfoMageBatDeletePo
 * 2019/12/02 11:02:15
 */
public class SubEntpMbInfoMageBatDeletePo {
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
