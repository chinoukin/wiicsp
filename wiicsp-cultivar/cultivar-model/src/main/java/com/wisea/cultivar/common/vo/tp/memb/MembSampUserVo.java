package com.wisea.cultivar.common.vo.tp.memb;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 抽样人员个人信息详情VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年4月22日
 * @version 1.0
 */
@ApiModel("抽样人员个人信息详情VO")
public class MembSampUserVo {

	@ApiModelProperty(value="ID")
	@JsonSerialize(using = IdSerializer.class)
	private Long id;
	@ApiModelProperty(value="用户名")
	private String loginName;
	@ApiModelProperty(value="采样人姓名")
	private String sampName;
	@ApiModelProperty(value="密码")
	private String password;
	@ApiModelProperty(value="手机号")
	private String mobile;
	@ApiModelProperty(value="邮箱")
	private String email;
    @ApiModelProperty(value = "账户状态(acct_state0:正常1:冻结)")
    private String acctState;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getSampName() {
		return sampName;
	}
	public void setSampName(String sampName) {
		this.sampName = sampName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAcctState() {
		return acctState;
	}
	public void setAcctState(String acctState) {
		this.acctState = acctState;
	}
}
