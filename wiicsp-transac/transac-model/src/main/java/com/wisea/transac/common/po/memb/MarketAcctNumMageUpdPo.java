package com.wisea.transac.common.po.memb;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 总运营平台或者市场用户修改PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月6日
 * @version 1.0
 */
@ApiModel("总运营平台或者市场用户修改PO")
public class MarketAcctNumMageUpdPo extends MarketAcctNumMagePo{

	@ApiModelProperty(value="id(新增的时候为空，修改的时候必须填写)")
	private Long id;

	@ApiModelProperty(value = "密码(新增的时候必须填写,修改的时候不填写默认不修改密码)")
	@Check(test = {"logic"},logic = "#isEmpty(#id)?#isNotEmpty(#password):true", logicMsg = "新增的情况密码必须填写")
	private String password;

	@ApiModelProperty(value = "是否设置成为管理员(sf_admin_flag0:是1:否)",hidden=true)
	private String sfAdminFlag;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSfAdminFlag() {
		return sfAdminFlag;
	}

	public void setSfAdminFlag(String sfAdminFlag) {
		this.sfAdminFlag = sfAdminFlag;
	}
}
