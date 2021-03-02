package com.wisea.transac.common.vo.memb;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.util.excel.annotation.ExcelField;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;

/**
 * 会员报备信息测查询处理VO
 *
 * @author wangh(wisea)
 *
 * @date 2020年6月30日
 * @version 1.0
 */
@ApiModel("会员报备信息测查询处理VO")
public class MembEntpRpExportVo {

	@JsonSerialize(using = IdSerializer.class)
	private Long id;
	@ExcelField(title = "商户号", sort = 10)
	private String merchantNo;
	@ExcelField(title = "商户名称", sort = 20)
	private String entpName;
	@ExcelField(title = "注册地址", sort = 30)
	private String regAdrZh;
	@ExcelField(title = "联系人", sort = 40)
	private String conter;
	@ExcelField(title = "联系电话", sort = 50)
	private String contTel;
	@ExcelField(title = "账户类型", sort = 60)
	private String bankAcctType;
	@ExcelField(title = "结算卡号", sort = 70)
	private String entpBankNum;
	@ExcelField(title = "开户行", sort = 80)
	private String openBank;
	@ExcelField(title = "报备状态", sort = 90)
	private String rpStateType;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMerchantNo() {
		return merchantNo;
	}
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
	public String getEntpName() {
		return entpName;
	}
	public void setEntpName(String entpName) {
		this.entpName = entpName;
	}
	public String getRegAdrZh() {
		return regAdrZh;
	}
	public void setRegAdrZh(String regAdrZh) {
		this.regAdrZh = regAdrZh;
	}
	public String getConter() {
		return conter;
	}
	public void setConter(String conter) {
		this.conter = conter;
	}
	public String getContTel() {
		return contTel;
	}
	public void setContTel(String contTel) {
		this.contTel = contTel;
	}
	public String getBankAcctType() {
		return bankAcctType;
	}
	public void setBankAcctType(String bankAcctType) {
		this.bankAcctType = bankAcctType;
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
	public String getRpStateType() {
		return rpStateType;
	}
	public void setRpStateType(String rpStateType) {
		this.rpStateType = rpStateType;
	}


}
