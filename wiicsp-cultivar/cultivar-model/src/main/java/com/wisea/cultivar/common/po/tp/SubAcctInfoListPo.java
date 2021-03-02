package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModelProperty;

/**
 * SubAcctInfoListPo
 * 2018/10/11 10:36:38
 */
public class SubAcctInfoListPo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 会员id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "会员id")
    private Long membId;

    /**
     * 账号
     */
    @ApiModelProperty(value = "账号")
    private String acctNum;

    /**
     * 员工姓名
     */
    @ApiModelProperty(value = "员工姓名")
    private String staffName;

    /**
     * 登录密码
     */
    @ApiModelProperty(value = "登录密码")
    private String loginPw;

    /**
     * 联系电话
     */
    @ApiModelProperty(value = "联系电话")
    private String tel;

    /**
     * 确认密码
     */
    @ApiModelProperty(value = "确认密码")
    private String confirmPw;

    /**
     * 邮箱地址
     */
    @ApiModelProperty(value = "邮箱地址")
    private String email;

    /**
     * 启用标志
     */
    @ApiModelProperty(value = "启用标志")
    private String enableFlag;

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
     * 获取会员id
     */
    public Long getMembId() {
        return membId;
    }

    /**
     * 设置会员id
     */
    public void setMembId(Long membId) {
        this.membId = membId;
    }

    /**
     * 获取账号
     */
    public String getAcctNum() {
        return acctNum;
    }

    /**
     * 设置账号
     */
    public void setAcctNum(String acctNum) {
        this.acctNum = acctNum == null ? null : acctNum.trim();
    }

    /**
     * 获取员工姓名
     */
    public String getStaffName() {
        return staffName;
    }

    /**
     * 设置员工姓名
     */
    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    /**
     * 获取登录密码
     */
    public String getLoginPw() {
        return loginPw;
    }

    /**
     * 设置登录密码
     */
    public void setLoginPw(String loginPw) {
        this.loginPw = loginPw == null ? null : loginPw.trim();
    }

    /**
     * 获取联系电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置联系电话
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * 获取确认密码
     */
    public String getConfirmPw() {
        return confirmPw;
    }

    /**
     * 设置确认密码
     */
    public void setConfirmPw(String confirmPw) {
        this.confirmPw = confirmPw == null ? null : confirmPw.trim();
    }

    /**
     * 获取邮箱地址
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱地址
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取启用标志
     */
    public String getEnableFlag() {
        return enableFlag;
    }

    /**
     * 设置启用标志
     */
    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag == null ? null : enableFlag.trim();
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
}
