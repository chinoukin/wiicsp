package com.wisea.cultivar.seedlings.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * CheckFileBatDeletePo
 * 2020/08/06 14:19:24
 */
public class CheckFileBatDeletePo {
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
