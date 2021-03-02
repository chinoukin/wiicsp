package com.wisea.transac.common.po.customer;

import com.google.common.collect.Lists;
import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * SysImCustomerConfigInsertPo 2018/09/29 13:46:47
 */
public class SysImCustomerConfigInsertPo {

    /**
     * 分组id
     */
    @Check(test = { "required" })
    @ApiModelProperty(value = "分组id")
    private String groupId;

    /**
     * 类型 0:轮询 1:指定
     */
    @Check(test = { "required", "liveable" }, liveable = { "0", "1" })
    @ApiModelProperty(value = "类型 0:轮询 1:指定")
    private String type;

    /**
     * 接待服务最大数量
     */
    @Check(test = { "required" })
    @ApiModelProperty(value = "接待服务最大数量 默认50")
    private Integer serMaxCount = 50;

    /**
     * 最近联系人优先 0:否 1:是
     */
    @Check(test = { "liveable" }, liveable = { "0", "1" })
    @ApiModelProperty(value = "最近联系人优先 0:否 1:是")
    private String retContact = "0";

    /**
     * 管理员不参与自动分配 0:否 1:是
     */
    @Check(test = { "liveable" }, liveable = { "0", "1" })
    @ApiModelProperty(value = "管理员不参与自动分配 0:否 1:是")
    private String depNoAdmin = "1";

    /**
     * 用户ID列表
     */
    @Check(test = "logic",logic = "#userList!=null",cascade = true)
    @ApiModelProperty(value = "用户列表")
    private List<CustomerConfigUserInsertPo> userList = Lists.newArrayList();

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    /**
     * 获取类型 0:轮询 1:指定
     */
    public String getType() {
        return type;
    }

    /**
     * 设置类型 0:轮询 1:指定
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取接待服务最大数量
     */
    public Integer getSerMaxCount() {
        return serMaxCount;
    }

    /**
     * 设置接待服务最大数量
     */
    public void setSerMaxCount(Integer serMaxCount) {
        this.serMaxCount = serMaxCount;
    }

    public String getRetContact() {
        return retContact;
    }

    public void setRetContact(String retContact) {
        this.retContact = retContact;
    }

    public String getDepNoAdmin() {
        return depNoAdmin;
    }

    public void setDepNoAdmin(String depNoAdmin) {
        this.depNoAdmin = depNoAdmin;
    }

    public List<CustomerConfigUserInsertPo> getUserList() {
        return userList;
    }

    public void setUserList(List<CustomerConfigUserInsertPo> userList) {
        this.userList = userList;
    }

}
