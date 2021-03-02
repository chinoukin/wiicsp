package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 会员银行信息的保存PO
 *
 * @author wangh(wisea)
 *
 * @date 2018年10月9日
 * @version 1.0
 */
@ApiModel("会员银行信息的保存PO")
public class EntpUpdBankInfoPo {
	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value="id")
    @Check(test = "required")
    private Long id;
	@ApiModelProperty(value="银行卡号")
	@Check(test = "required")
    private String bankNum;
	@ApiModelProperty(value="开户行")
	@Check(test = "required")
    private String openBank;
	public String getBankNum() {
		return bankNum;
	}
	public void setBankNum(String bankNum) {
		this.bankNum = bankNum;
	}
	public String getOpenBank() {
		return openBank;
	}
	public void setOpenBank(String openBank) {
		this.openBank = openBank;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
