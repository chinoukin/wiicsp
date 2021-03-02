package com.wisea.cultivar.origin.po;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 校验机构编号PO
 * @author wzx
 *
 */
@ApiModel("校验机构编号PO")
public class CheckOrgNumPo {
	@ApiModelProperty(value="id")
	private Long id;
	@ApiModelProperty(value="机构编号")
	@Check(test = "required")
	private String orgNum;//机构编号
	@ApiModelProperty(value="机构名称")
	@Check(test = "required")
	private String orgName;//机构名称

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrgNum() {
		return orgNum;
	}

	public void setOrgNum(String orgNum) {
		this.orgNum = orgNum;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

}

