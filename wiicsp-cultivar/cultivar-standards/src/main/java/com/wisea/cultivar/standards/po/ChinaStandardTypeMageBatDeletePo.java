package com.wisea.cultivar.standards.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * ChinaStandardTypeMageBatDeletePo
 * 2020/07/24 11:21:45
 */
public class ChinaStandardTypeMageBatDeletePo {
    /**
     * 批量删除列表
     */
    @ApiModelProperty(value = "批量删除列表")
    private List<Long> delList;

    /**
    * 单删ID
    * Author: xiehy
    * Date: 2020/8/25 11:25
    */
    @Check(test = "required")
    @ApiModelProperty(value = "删除id")
    private Long delId;
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

    public Long getDelId() {
        return delId;
    }

    public void setDelId(Long delId) {
        this.delId = delId;
    }
}
