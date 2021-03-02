package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * 企业银行卡信息
 *
 * @author wangh(wisea)
 *
 * @date 2018年11月29日
 * @version 1.0
 */
public class EntpBankInfo extends DataLongEntity<EntpBankInfo> {

	/**
	 *
	 */
	private static final long serialVersionUID = 5275122621534958722L;
	private Long entpDataId;//企业id
	private String khxkzNum;// 开户许可证编号
	private String khxkzUrl;// 开户许可证url
	private String entpBankNum;//企业银行卡号
	private String khName;//开户名
	private String openBankType;
	private String khProv;// 开户行省
	private String khCity;// 开户行市
	private String openBank;// 开户行

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
	public String getKhxkzNum() {
		return khxkzNum;
	}
	public void setKhxkzNum(String khxkzNum) {
		this.khxkzNum = khxkzNum;
	}
	public String getKhxkzUrl() {
		return khxkzUrl;
	}
	public void setKhxkzUrl(String khxkzUrl) {
		this.khxkzUrl = khxkzUrl;
	}
	public String getKhName() {
		return khName;
	}
	public void setKhName(String khName) {
		this.khName = khName;
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
	public String getOpenBankType() {
		return openBankType;
	}
	public void setOpenBankType(String openBankType) {
		this.openBankType = openBankType;
	}
}
