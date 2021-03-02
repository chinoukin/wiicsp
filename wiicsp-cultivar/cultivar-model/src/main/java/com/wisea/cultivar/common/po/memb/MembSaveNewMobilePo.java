package com.wisea.cultivar.common.po.memb;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 保存绑定手机号的参数PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月9日
 * @version 1.0
 */
@ApiModel("保存绑定手机号的参数PO")
public class MembSaveNewMobilePo {

	@ApiModelProperty(value = "ID(如果不传，修改当前用户信息)")
	@JsonSerialize(using = IdSerializer.class)
	private Long id;

	@Check(test = {"required"})
	@ApiModelProperty(value = "旧手机号码")
	private String oldMobile;

	@Check(test = {"required"})
	@ApiModelProperty(value = "新手机号码")
	private String newMobile;

	@Check(test = {"required"})
	@ApiModelProperty(value = "验证码")
	private String vilCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOldMobile() {
		return oldMobile;
	}

	public void setOldMobile(String oldMobile) {
		this.oldMobile = oldMobile;
	}

	public String getNewMobile() {
		return newMobile;
	}

	public void setNewMobile(String newMobile) {
		this.newMobile = newMobile;
	}

	public String getVilCode() {
		return vilCode;
	}

	public void setVilCode(String vilCode) {
		this.vilCode = vilCode;
	}

}
