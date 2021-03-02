package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * SubAcctInfoInsertPo
 * 2018/10/11 10:54:17
 */
public class SubAcctInfoInsertPo {

	/**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "id(新增的时候为空，修改不为空)")
	private Long id;
    /**
     * 账号
     */
    @Check(test = {"maxLength","logic"},logic = "#isEmpty(#id)?#isNotEmpty(#acctNum):true",logicMsg = "新增的时候账号不能为空", mixLength = 30)
    @ApiModelProperty(value = "账号")
    private String acctNum;
    /**
     * 员工姓名
     */
    @Check(test = {"maxLength","logic"},logic = "#isEmpty(#id)?#isNotEmpty(#staffName):true",logicMsg = "新增的时候员工姓名不能为空", mixLength = 30)
    @ApiModelProperty(value = "员工姓名")
    private String staffName;
    /**
     * 联系电话
     */
    @Check(test = {"maxLength","required"}, mixLength = 30)
    @ApiModelProperty(value = "联系电话")
    private String tel;
    /**
     * 邮箱地址
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "邮箱地址")
    private String email;
    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 密码
     */
    @Check(test = {"maxLength","logic"},logic = "#isEmpty(#id)?#isNotEmpty(#password):true",logicMsg = "新增的时候密码不能为空", mixLength = 255)
    @ApiModelProperty(value = "密码")
    private String password;
    /**
     * 确认密码
     */
    @Check(test = {"maxLength","logic"},logic = "#isEmpty(#id)?#isNotEmpty(#conPwd):true",logicMsg = "新增的时候确认密码不能为空", mixLength = 255)
    @ApiModelProperty(value = "确认密码")
    private String conPwd;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAcctNum() {
		return acctNum;
	}
	public void setAcctNum(String acctNum) {
		this.acctNum = acctNum;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConPwd() {
		return conPwd;
	}
	public void setConPwd(String conPwd) {
		this.conPwd = conPwd;
	}


}
