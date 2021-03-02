package com.wisea.cultivar.seedlings.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * ItemMageBatDeletePo
 * 2020/08/06 14:19:24
 */
public class ItemMageOverPo {
    /**
     * 批量结束项目列表id
     */
    @Check(test = "required")
    @ApiModelProperty(value = "批量结束项目列表id")
    private List<Long> overList;

    @Check(test = "required")
    @ApiModelProperty(value = "批量结束项目列表id")
    private String itemStateType;

    public List<Long> getOverList() {
        return overList;
    }

    public void setOverList(List<Long> overList) {
        this.overList = overList;
    }

    public String getItemStateType() {
        return itemStateType;
    }

    public void setItemStateType(String itemStateType) {
        this.itemStateType = itemStateType;
    }
}
