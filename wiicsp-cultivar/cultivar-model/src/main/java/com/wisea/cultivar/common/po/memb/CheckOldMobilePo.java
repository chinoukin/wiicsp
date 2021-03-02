package com.wisea.cultivar.common.po.memb;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 验证旧手机号的参数信息PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月9日
 * @version 1.0
 */
@ApiModel("验证旧手机号的参数信息PO")
public class CheckOldMobilePo {

	@ApiModelProperty(value = "用户ID(如果为空验证当前用户)")
	@JsonSerialize(using = IdSerializer.class)
	private Long id;
	@Check(test = {"required"})
	@ApiModelProperty(value = "手机号码")
	private String mobile;

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
}
