package com.wisea.cultivar.portal.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * UserMageInsertPo
 * 2020/08/24 20:28:13
 */
public class UserMageInsertPo {
    /**
     * sys_user_id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "sys_user_id", allowableValues = "length:(,19]")
    private Long sysUserId;

    /**
     * 成员姓名
     */
    @Check(test = { "maxLength;required" }, mixLength = 255)
    @ApiModelProperty(value = "成员姓名", allowableValues = "mixLength:(,255]")
    private String userName;

    /**
     * 手机号
     */
    @Check(test = { "maxLength;required" }, mixLength = 32)
    @ApiModelProperty(value = "手机号", allowableValues = "mixLength:(,32]")
    private String tel;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    @Check(test = "required")
    @ApiModelProperty(value = "所属角色id")
    private String roleIdList;

    @Check(test = { "maxLength;required" }, mixLength = 256)
    @ApiModelProperty(value = "系统账号", allowableValues = "mixLength:(,256]")
    private String loginName;

    @Check(test = { "maxLength;required" }, mixLength = 256)
    @ApiModelProperty(value = "密码", allowableValues = "mixLength:(,256]")
    private String password;

    @Check(test = { "maxLength;required" }, mixLength = 256)
    @ApiModelProperty(value = "确认密码", allowableValues = "mixLength:(,256]")
    private String affirmpassword;

    @Check(test = { "maxLength;required" }, length = 19)
    @ApiModelProperty(value = "所属机构", allowableValues = "length:(,19]")
    private String orgId;

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

    public String getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(String roleIdList) {
        this.roleIdList = roleIdList;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAffirmpassword() {
        return affirmpassword;
    }

    public void setAffirmpassword(String affirmpassword) {
        this.affirmpassword = affirmpassword;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }
}
