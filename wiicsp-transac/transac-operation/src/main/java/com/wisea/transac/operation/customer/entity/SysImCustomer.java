package com.wisea.transac.operation.customer.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * sys_im_customer 表实体
 * 客服管理表
 * 2018/09/29 13:46:47
 */
public class SysImCustomer extends DataLongEntity<SysImCustomer> {
    private static final long serialVersionUID = 1L;

    /**
     * 分组id sys(系统客服)或用户id
     */
    private String groupId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 是否管理员 0:否 1:是
     */
    private String isAdmin;

    /**
     * 状态(0:离线 1:在线)
     */
    private String status;

    /**
     * 当前服务数量
     */
    private Integer serCount;

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

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
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
}
