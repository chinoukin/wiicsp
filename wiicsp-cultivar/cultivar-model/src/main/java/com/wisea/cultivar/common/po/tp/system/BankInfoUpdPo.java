package com.wisea.cultivar.common.po.tp.system;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 修改企业银行卡信息PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年1月23日
 * @version 1.0
 */
@ApiModel("修改企业银行卡信息PO")
public class BankInfoUpdPo {
	@ApiModelProperty(value="短信授权码")
    @Check(test = "required")
    private String merAuthorizeNum; //短信授权码
	@ApiModelProperty(value="结算银行卡号")
    @Check(test = "required")
    private String entpBankNum; //银行卡号
	@ApiModelProperty(value="开户行")
    @Check(test = "required")
    private String openBankType; //开户行编码
	@ApiModelProperty(value="开户行省")
    @Check(test = "required")
    private String khProv; //开户行省
	@ApiModelProperty(value="开户行市")
    @Check(test = "required")
    private String khCity; //开户行市
	@ApiModelProperty(value="开户行支行")
    @Check(test = "required")
    private String openBank; //开户行支行编码

	public String getMerAuthorizeNum() {
		return merAuthorizeNum;
	}
	public void setMerAuthorizeNum(String merAuthorizeNum) {
		this.merAuthorizeNum = merAuthorizeNum;
	}
	public String getEntpBankNum() {
		return entpBankNum;
	}
	public void setEntpBankNum(String entpBankNum) {
		this.entpBankNum = entpBankNum;
	}
	public String getOpenBankType() {
		return openBankType;
	}
	public void setOpenBankType(String openBankType) {
		this.openBankType = openBankType;
	}
	public String getKhProv() {
		return khProv;
	}
	public void setKhProv(String khProv) {
		this.khProv = khProv;
	}
	public String getKhCity() {
		return khCity;
	}
	public void setKhCity(String khCity) {
		this.khCity = khCity;
	}
	public String getOpenBank() {
		return openBank;
	}
	public void setOpenBank(String openBank) {
		this.openBank = openBank;
	}

}
