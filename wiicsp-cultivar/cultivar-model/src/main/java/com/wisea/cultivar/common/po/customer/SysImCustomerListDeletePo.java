package com.wisea.cultivar.common.po.customer;

import java.util.List;

import com.google.common.collect.Lists;
import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModelProperty;

public class SysImCustomerListDeletePo {
    /**
     * 分组id
     */
    @Check(test = { "required" })
    @ApiModelProperty(value = "分组id")
    private String groupId;

    @Check(test = { "required" })
    @ApiModelProperty(value = "用户id列表")
    private List<Long> userList = Lists.newArrayList();

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<Long> getUserList() {
        return userList;
    }

    public void setUserList(List<Long> userList) {
        this.userList = userList;
    }

}
