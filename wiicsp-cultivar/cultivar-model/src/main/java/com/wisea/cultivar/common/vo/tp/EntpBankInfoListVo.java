package com.wisea.cultivar.common.vo.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModelProperty;

public class EntpBankInfoListVo {
	 /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "企业id")
    private Long entpDataId;//企业id
    @ApiModelProperty(value = "企业银行卡号")
	private String entpBankNum;//企业银行卡号
	@ApiModelProperty(value = "开户行")
	private String openBank;//开户行
	@ApiModelProperty(value="删除标识",hidden = true)
	private String delFlag;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getEntpDataId() {
		return entpDataId;
	}
	public void setEntpDataId(Long entpDataId) {
		this.entpDataId = entpDataId;
	}
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
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
}
