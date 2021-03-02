package com.wisea.transac.common.po.customer;

import java.util.List;

import com.google.common.collect.Lists;
import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModelProperty;

public class SysImCustomerListUpdatePo {
    /**
     * 分组id
     */
    @Check(test = { "required" })
    @ApiModelProperty(value = "分组id")
    private String groupId;

    /**
     * 用户ID列表
     */
    @Check(test = { "required" }, cascade = true)
    @ApiModelProperty(value = "用户列表")
    private List<CustomerConfigUserInsertPo> userList = Lists.newArrayList();

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<CustomerConfigUserInsertPo> getUserList() {
        return userList;
    }

    public void setUserList(List<CustomerConfigUserInsertPo> userList) {
        this.userList = userList;
    }

}
