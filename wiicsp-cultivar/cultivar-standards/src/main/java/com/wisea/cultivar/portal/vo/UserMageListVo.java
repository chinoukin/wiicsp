package com.wisea.cultivar.portal.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * UserMageListVo
 * 2020/08/24 20:28:13
 */
public class UserMageListVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * sys_user_id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "sys_user_id")
    private Long sysUserId;

    /**
     * 成员姓名
     */
    @ApiModelProperty(value = "成员姓名")
    private String userName;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String tel;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    @Check(test = "required")
    @ApiModelProperty(value = "所属角色id")
    private List<Long> roleIdList;

    @Check(test = { "maxLength" }, mixLength = 256)
    @ApiModelProperty(value = "系统账号", allowableValues = "mixLength:(,256]")
    private String loginName;

    @Check(test = { "maxLength" }, mixLength = 256)
    @ApiModelProperty(value = "密码", allowableValues = "mixLength:(,256]")
    private String password;

    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "所属机构", allowableValues = "length:(,19]")
    private Long orgId;

    @Check(test = { "maxLength" }, mixLength = 256)
    @ApiModelProperty(value = "是否激活", allowableValues = "mixLength:(,256]")
    private String activeFlag;
    @Check(test = { "maxLength" }, mixLength = 256)
    @ApiModelProperty(value = "账号状态", allowableValues = "mixLength:(,256]")
    private String loginFlag;

    @ApiModelProperty(value = "更新时间")
    private String updateDate;

    @ApiModelProperty(value = "所属机构")
    private String organ;  //返回给前端的所属机构中文名称，方便前端渲染数据
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

    /**
     * 获取删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public List<Long> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<Long> roleIdList) {
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

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(String activeFlag) {
        this.activeFlag = activeFlag;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getOrgan() {
        return organ;
    }

    public void setOrgan(String organ) {
        this.organ = organ;
    }

    public String getLoginFlag() {
        return loginFlag;
    }

    public void setLoginFlag(String loginFlag) {
        this.loginFlag = loginFlag;
    }
}
