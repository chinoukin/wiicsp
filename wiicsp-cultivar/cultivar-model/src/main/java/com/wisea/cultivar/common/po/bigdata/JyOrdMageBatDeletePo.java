package com.wisea.cultivar.common.po.bigdata;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * JyOrdMageBatDeletePo
 * 2019/12/02 11:02:14
 */
public class JyOrdMageBatDeletePo {
    @Check(test = "required")
    @ApiModelProperty(value = "批量删除列表")
    private List<Long> delList;

    public List<Long> getDelList() {
        return delList;
    }

    public void setDelList(List<Long> delList) {
        this.delList = delList;
    }
}
