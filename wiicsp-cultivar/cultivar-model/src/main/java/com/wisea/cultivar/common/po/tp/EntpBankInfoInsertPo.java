package com.wisea.cultivar.common.po.tp;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 新增企业银行卡信息的PO
 *
 * @author wangh(wisea)
 *
 * @date 2018年11月29日
 * @version 1.0
 */
@ApiModel("新增企业银行卡信息的PO")
public class EntpBankInfoInsertPo {

	@ApiModelProperty(value="银行卡号")
	@Check(test = "required")
	private String entpBankNum;
	@ApiModelProperty(value="银行名称")
	@Check(test = "required")
	private String openBank;

	public String getEntpBankNum() {
		return entpBankNum;
	}
	public void setEntpBankNum(String entpBankNum) {
		this.entpBankNum = entpBankNum;
	}
	public String getOpenBank() {
		return openBank;
	}
	public void setOpenBank(String openBank) {
		this.openBank = openBank;
	}
}
