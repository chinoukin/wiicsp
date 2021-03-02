package com.wisea.transac.common.po.memb;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 修改市场管理员信息PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月7日
 * @version 1.0
 */
@ApiModel("修改市场管理员信息PO")
public class MarketAdminUpdPo {

	@ApiModelProperty(value="id")
    @Check(test = "required")
	private Long id;
	@ApiModelProperty(value="用户名")
    @Check(test = "required")
	private String loginName;
	@ApiModelProperty(value="密码(如果不修改默认为空)")
	private String password;
	@ApiModelProperty(value="姓名")
	private String name;
	@ApiModelProperty(value="联系电话")
	private String tel;

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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
}
