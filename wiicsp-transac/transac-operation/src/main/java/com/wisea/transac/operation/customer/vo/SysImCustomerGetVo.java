package com.wisea.transac.operation.customer.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * SysImCustomerGetVo 2018/09/29 13:46:47
 */
public class SysImCustomerGetVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 分组id sys(系统客服)或用户id
     */
    @ApiModelProperty(value = "分组id sys(系统客服)或用户id")
    private String groupId;

    /**
     * 用户id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "用户id")
    private Long userId;

    /**
     * 客服名称
     */
    @ApiModelProperty(value = "客服名称")
    private String name;

    /**
     * 是否管理员 0:否 1:是
     */
    @ApiModelProperty(value = "是否管理员 0:否 1:是")
    private String isAdmin;

    /**
     * 状态(0:离线 1:在线)
     */
    @ApiModelProperty(value = "状态(0:离线 1:在线)")
    private String status;

    /**
     * 当前服务数量
     */
    @ApiModelProperty(value = "当前服务数量")
    private Integer serCount;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 获取id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取分组id sys(系统客服)或用户id
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * 设置分组id sys(系统客服)或用户id
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

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

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    /**
     * 获取客服名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置客服名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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
}
