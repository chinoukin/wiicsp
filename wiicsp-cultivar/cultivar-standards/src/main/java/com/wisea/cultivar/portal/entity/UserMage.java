package com.wisea.cultivar.portal.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * user_mage 表实体
 * 成员管理
 * 2020/08/24 20:28:13
 */
public class UserMage extends DataLongEntity<UserMage> {
    private static final long serialVersionUID = 1L;

    /**
     * sys_user_id
     */
    private Long sysUserId;

    /**
     * 成员姓名
     */
    private String userName;

    /**
     * 手机号
     */
    private String tel;

    /**
     *
     * @mbg.generated
     */
    public UserMage() {
        super();
    }

    /**
     * 获取sys_user_id
     */
    public Long getSysUserId() {
        return sysUserId;
    }

    /**
     * 设置sys_user_id
     */
    public void setSysUserId(Long sysUserId) {
        this.sysUserId = sysUserId;
    }

    /**
     * 获取成员姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置成员姓名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取手机号
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置手机号
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }
}
