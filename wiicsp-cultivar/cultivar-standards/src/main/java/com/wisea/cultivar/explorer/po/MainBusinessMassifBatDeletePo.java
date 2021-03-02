package com.wisea.cultivar.explorer.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * MainBusinessMassifBatDeletePo
 * 2020/08/24 20:19:05
 */
public class MainBusinessMassifBatDeletePo {
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
