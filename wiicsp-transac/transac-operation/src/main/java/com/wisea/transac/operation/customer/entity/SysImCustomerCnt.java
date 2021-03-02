package com.wisea.transac.operation.customer.entity;

import java.time.OffsetDateTime;

/**
 * sys_im_customer_cnt 表实体 客服接待关系表 2018/09/29 13:46:47
 */
public class SysImCustomerCnt {

    /**
     * group id 分组id
     */
    private String groupId;
    /**
     * 客服id
     */
    private Long customerId;

    /**
     * 被接待的用户id
     */
    private Long userId;

    /**
     * 创建时间
     */
    private OffsetDateTime createDate;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    /**
     * 获取客服id
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * 设置客服id
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * 获取被接待的用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置被接待的用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取创建时间
     */
    public OffsetDateTime getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     */
    public void setCreateDate(OffsetDateTime createDate) {
        this.createDate = createDate;
    }
}
