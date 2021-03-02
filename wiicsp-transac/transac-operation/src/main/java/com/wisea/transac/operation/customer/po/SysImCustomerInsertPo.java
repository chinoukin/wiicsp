package com.wisea.transac.operation.customer.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * SysImCustomerInsertPo 2018/09/29 13:46:47
 */
public class SysImCustomerInsertPo {

    @Check(test = { "required" })
    @ApiModelProperty(value = "分组id sys(系统客服)或用户id")
    private String groupId;

    /**
     * 用户id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "required", "maxLength" }, length = 19)
    @ApiModelProperty(value = "用户id")
    private Long userId;

    /**
     * 是否管理员 0:否 1:是
     */
    @Check(test = { "required", "liveable" }, liveable = { "0", "1" })
    @ApiModelProperty(value = "是否管理员 0:否 1:是")
    private String isAdmin;

    /**
     * 状态(0:离线 1:在线)
     */
    @Check(test = { "required", "liveable" }, liveable = { "0", "1" })
    @ApiModelProperty(value = "状态(0:离线 1:在线)")
    private String status;

    /**
     * 当前服务数量
     */
    @JsonIgnore
    @ApiModelProperty(value = "当前服务数量", hidden = true)
    private Integer serCount = 0;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 获取用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取状态(0:离线 1:在线)
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态(0:离线 1:在线)
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取当前服务数量
     */
    public Integer getSerCount() {
        return serCount;
    }

    /**
     * 设置当前服务数量
     */
    public void setSerCount(Integer serCount) {
        this.serCount = serCount;
    }

    /**
     * 获取备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

}
