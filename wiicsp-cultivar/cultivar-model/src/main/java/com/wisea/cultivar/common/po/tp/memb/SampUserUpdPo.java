package com.wisea.cultivar.common.po.tp.memb;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

/**
 * 采样人员添加的PO
 *
 * @author wangh(wisea)
 *
 * @date 2018年11月6日
 * @version 1.0
 */
@Api("采样人员修改的PO")
public class SampUserUpdPo {

	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value="id")
	@Check(test = { "required" })
	private Long id;
	@ApiModelProperty(value="采样人姓名")
	@Check(test = { "required" })
	private String sampName;
	@ApiModelProperty(value="手机号")
	@Check(test = { "required" })
	private String mobile;
	@ApiModelProperty(value="邮箱")
	private String email;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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

	public String getSampName() {
		return sampName;
	}

	public void setSampName(String sampName) {
		this.sampName = sampName;
	}
}
