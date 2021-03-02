package com.wisea.transac.common.po.customer;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModelProperty;

public class SysImCustomerConfigGetPo {

    /**
     * 分组id
     */
    @Check(test = { "required" })
    @ApiModelProperty(value = "分组id")
    private String groupId;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

}
