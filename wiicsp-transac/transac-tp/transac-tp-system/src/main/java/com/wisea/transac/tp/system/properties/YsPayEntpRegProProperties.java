package com.wisea.transac.tp.system.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 银盛企业注册的时候配置参数
 *
 * @author wangh(wisea)
 *
 * @date 2020年6月29日
 * @version 1.0
 */
@ConfigurationProperties(prefix = "yspay.entpreg")
public class YsPayEntpRegProProperties {

	/**
	 * 企业法人证件类型
	 */
	private String legalCertType;
	/**
	 * 通知方式，此通知为商户号审核通知，通知内容包含帐号信息，
	 * 为空的情况下将不发送通知，支持通知方式1、邮箱，2手机短信，3、邮箱+手机短信
	 */
	private String notifyType;
	/**
	 * 开户人证件类型，目前只支持00,00为身份证
	 */
	private String certType;
	/**
	 * 商户属性。11为普通商户，12为代理商户，不填的情况下默认为普通商户
	 */
	private String merFlag;
	/**
	 * 行业类 别
	 */
	private String industry;
	/**
	 * 结算方式，0:平台内账户1:银行卡账户.
	 * 结算方式为0时银行卡信息只涉及提现，为1时涉及到提现以及清算
	 */
	private String settleType;
	/**
	 * 机构号
	 */
	private String orgNo;
	/**
	 * //银行卡类型，可填debit|credit|unit  debit借记卡，credit贷记卡，unit单位结算卡
	 */
	private String bankCardType;

	public String getLegalCertType() {
		return legalCertType;
	}
	public void setLegalCertType(String legalCertType) {
		this.legalCertType = legalCertType;
	}
	public String getNotifyType() {
		return notifyType;
	}
	public void setNotifyType(String notifyType) {
		this.notifyType = notifyType;
	}
	public String getCertType() {
		return certType;
	}
	public void setCertType(String certType) {
		this.certType = certType;
	}
	public String getMerFlag() {
		return merFlag;
	}
	public void setMerFlag(String merFlag) {
		this.merFlag = merFlag;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getSettleType() {
		return settleType;
	}
	public void setSettleType(String settleType) {
		this.settleType = settleType;
	}
	public String getOrgNo() {
		return orgNo;
	}
	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}
	public String getBankCardType() {
		return bankCardType;
	}
	public void setBankCardType(String bankCardType) {
		this.bankCardType = bankCardType;
	}
}
