package com.wisea.transac.common.po.customer;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModelProperty;

public class CustomerConfigUserInsertPo {
    @Check(test = { "required" })
    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "是否为管理员 0:否 1:是")
    private String isAdmin = "0";

    public CustomerConfigUserInsertPo() {

    }

    public CustomerConfigUserInsertPo(Long userId) {
        this.userId = userId;
    }

    public CustomerConfigUserInsertPo(Long userId, String isAdmin) {
        this.userId = userId;
        this.isAdmin = isAdmin;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String isAdmin() {
        return isAdmin;
    }

    public void setAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

}
