package com.wisea.cultivar.common.vo.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 企业银行信息VO
 *
 * @author wangh(wisea)
 *
 * @date 2018年10月18日
 * @version 1.0
 */
@ApiModel("企业银行信息VO")
public class EntpBankInfoVo {
	@JsonSerialize(using = IdSerializer.class)
	@ApiModelProperty(value="ID")
	private Long id;
	@ApiModelProperty(value="开户行")
	private String openBank;
	@ApiModelProperty(value="银行号码")
	private String bankNum;
	@ApiModelProperty(value="法人代表")
	private String legalPerson;
	@ApiModelProperty(value="企业名称")
	private String compName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOpenBank() {
		return openBank;
	}
	public void setOpenBank(String openBank) {
		this.openBank = openBank;
	}
	public String getBankNum() {
		return bankNum;
	}
	public void setBankNum(String bankNum) {
		this.bankNum = bankNum;
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
