package com.wisea.cultivar.operation.customer.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * sys_im_customer_config 表实体 客服管理配置表 2018/09/29 13:46:47
 */
public class SysImCustomerConfig extends DataLongEntity<SysImCustomerConfig> {
    private static final long serialVersionUID = 1L;

    /**
     * 分组id sys(系统客服)或用户id
     */
    private String groupId;

    /**
     * 类型 0:轮询 1:指定
     */
    private String type;

    /**
     * 接待服务最大数量
     */
    private Integer serMaxCount;
    /**
     * 最近联系人优先 0:否 1:是
     */
    private String retContact;

    /**
     * 管理员不参与自动分配 0:否 1:是
     */
    private String depNoAdmin;

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

}
