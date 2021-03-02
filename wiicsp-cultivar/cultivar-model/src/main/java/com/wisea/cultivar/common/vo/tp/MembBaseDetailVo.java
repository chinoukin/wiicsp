package com.wisea.cultivar.common.vo.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 获取会员的基础信息VO
 *
 * @author wangh(wisea)
 *
 * @date 2018年10月13日
 * @version 1.0
 */
@ApiModel("获取会员的基础信息VO")
public class MembBaseDetailVo {
	@JsonSerialize(using = IdSerializer.class)
	@ApiModelProperty(value="ID")
    private Long id;
	@ApiModelProperty(value="用户名")
    private String userName;
	@ApiModelProperty(value="注册手机号")
    private String registTel;
	@ApiModelProperty(value="社会统筹编码")
    private String ctscc;
	@ApiModelProperty(value="法人")
    private String legalPerson;
	@ApiModelProperty(value="企业名称")
	private String compName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRegistTel() {
		return registTel;
	}
	public void setRegistTel(String registTel) {
		this.registTel = registTel;
	}
	public String getCtscc() {
		return ctscc;
	}
	public void setCtscc(String ctscc) {
		this.ctscc = ctscc;
	}
	public String getLegalPerson() {
		return legalPerson;
	}
	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
}
