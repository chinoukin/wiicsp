package com.wisea.cultivar.common.po.tp.memb;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 商家认证信息PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年1月17日
 * @version 1.0
 */
@ApiModel("商家信息PO")
public class EntpDataInfoPo {

	/**
	 * 企业类型（comp_type：采购商认证1：供应商认证）
	 */
	@Check(test = {"required", "liveable"}, liveable = {"0", "1"}, liveableMsg = "企业类型只能为0或者1")
	@ApiModelProperty(value = "企业类型（comp_type0:采购商认证1:供应商认证）")
	private String compType;
	// ----------------企业信息  开始-------------------------------
	/**
     * 企业名称
     */
    @Check(test = {"required","maxLength" }, mixLength = 100,logicMsg="企业名称不能为空")
    @ApiModelProperty(value = "企业名称")
    private String compName;
    /**
     * 企业名称简称
     */
    @Check(test = {"required","maxLength" }, mixLength = 100,logicMsg="企业简称不能为空")
    @ApiModelProperty(value = "企业名称简称")
    private String compShortName;
    /**
     * 统一社会信用代码
     */
    @Check(test = { "required","maxLength" }, mixLength = 30,logicMsg="统一社会信用代码不能为空")
    @ApiModelProperty(value = "统一社会信用代码")
    private String ctscc;
    /**
     * 营业执照url
     */
    @Check(test = { "required","maxLength" }, mixLength = 255,logicMsg="营业执照不能为空")
    @ApiModelProperty(value = "营业执照url")
    private String yyzzUrl;
    /**
     * 联系人
     */
    @Check(test = {"required","maxLength" }, mixLength = 30,logicMsg="联系人不能为空")
    @ApiModelProperty(value = "联系人")
    private String contacts;
    /**
     * 绑定手机号
     */
    @Check(test = {"required","maxLength" }, mixLength = 30,logicMsg="绑定手机号不能为空")
    @ApiModelProperty(value = "绑定手机号")
    private String bdTel;
    /**
     * 注册地址省
     */
    @Check(test = {"required","maxLength" }, mixLength = 20,logicMsg="注册地址-省不能为空")
    @ApiModelProperty(value = "注册地址省")
    private String registAddressProv;

    /**
     * 注册地址市
     */
    @Check(test = { "required","maxLength" }, mixLength = 20,logicMsg="注册地址-市不能为空")
    @ApiModelProperty(value = "注册地址市")
    private String registAddressCity;

    /**
     * 注册地址区县
     */
    @Check(test = { "required","maxLength" }, mixLength = 20,logicMsg="注册地址-区县不能为空")
    @ApiModelProperty(value = "注册地址区县")
    private String registAddressCou;

    /**
     * 详细地址
     */
    @Check(test = { "required","maxLength" }, mixLength = 255,logicMsg="详细地址不能为空")
    @ApiModelProperty(value = "详细地址")
    private String address;
    // ----------------企业信息  结束-------------------------------
    // ----------------法人信息  开始-------------------------------
    /**
     * 法人代表
     */
    @Check(test = { "required","maxLength" }, mixLength = 30,logicMsg="法人代表不能为空")
    @ApiModelProperty(value = "法人代表")
    private String legalPerson;
    /**
     * 法人代表身份证号
     */
    @Check(test = { "required","maxLength" }, mixLength = 30,logicMsg="法人代表身份证号不能为空")
    @ApiModelProperty(value = "法人代表身份证号")
    private String legalPersonNum;
    /**
     * 身份证正面url
     */
    @Check(test = { "required","maxLength" }, mixLength = 255,logicMsg="身份证正面不能为空")
    @ApiModelProperty(value = "身份证正面url")
    private String sfzZmUrl;
    /**
     * 身份证反面url
     */
    @Check(test = { "required","maxLength" }, mixLength = 255,logicMsg="身份证反面不能为空")
    @ApiModelProperty(value = "身份证反面url")
    private String sfzFmUrl;
    // ----------------法人信息  结束-------------------------------
    // ----------------银行开户信息  开始-------------------------------
    /**
     * 开户许可证编号
     */
    @Check(test = "logic", logic = "'1'.equals(#compType)?#isNotEmpty(#khxkzNum):true", logicMsg = "【供应商】的场合开户许可证编号不能为空")
    @ApiModelProperty(value = "开户许可证编号")
    private String khxkzNum;
    /**
     * 开户许可证url
     */
    @Check(test = "logic", logic = "'1'.equals(#compType)?#isNotEmpty(#khxkzUrl):true", logicMsg = "【供应商】的场合开户许可证不能为空")
    @ApiModelProperty(value = "开户许可证url")
    private String khxkzUrl;
    /**
     * 企业银行卡号
     */
    @Check(test = "logic", logic = "'1'.equals(#compType)?#isNotEmpty(#entpBankNum):true", logicMsg = "【供应商】的场合企业银行卡号不能为空")
    @ApiModelProperty(value = "企业银行卡号")
    private String entpBankNum;
    /**
     * 开户名
     */
    @Check(test = "logic", logic = "'1'.equals(#compType)?#isNotEmpty(#khName):true", logicMsg = "【供应商】的场合开户名不能为空")
    @ApiModelProperty(value = "开户名")
    private String khName;
    /**
     * 开户行
     */
    @Check(test = "logic", logic = "'1'.equals(#compType)?#isNotEmpty(#openBankType):true", logicMsg = "【供应商】的场合开户行不能为空")
    @ApiModelProperty(value = "开户行")
    private String openBankType;
    /**
     * 开户行 -省
     */
    @Check(test = "logic", logic = "'1'.equals(#compType)?#isNotEmpty(#khProv):true", logicMsg = "【供应商】的场合开户行 -省不能为空")
    @ApiModelProperty(value = "开户行 -省")
    private String khProv;
    /**
     * 开户行-市
     */
    @Check(test = "logic", logic = "'1'.equals(#compType)?#isNotEmpty(#khCity):true", logicMsg = "【供应商】的场合开户行-市不能为空")
    @ApiModelProperty(value = "开户行-市")
    private String khCity;
    /**
     * 开户行-详细
     */
    @Check(test = "logic", logic = "'1'.equals(#compType)?#isNotEmpty(#openBank):true", logicMsg = "【供应商】的场合开户行-详细不能为空")
    @ApiModelProperty(value = "开户行-详细")
    private String openBank;
    /**
     * 邮箱地址
     */
    @Check(test = "logic", logic = "'1'.equals(#compType)?#isNotEmpty(#contactsEmail):true", logicMsg = "【供应商】的场合邮箱地址不能为空")
    @ApiModelProperty(value = "邮箱地址")
    private String contactsEmail;
    /**
     * 邮箱验证码
     */
    @ApiModelProperty(value = "邮箱验证码")
    private String emailValiCode;

    @ApiModelProperty(value = "注册地址中文名称")
    private String remarks;
    // ----------------银行开户信息  结束-------------------------------

	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public String getCompShortName() {
		return compShortName;
	}
	public void setCompShortName(String compShortName) {
		this.compShortName = compShortName;
	}
	public String getCtscc() {
		return ctscc;
	}
	public void setCtscc(String ctscc) {
		this.ctscc = ctscc;
	}
	public String getYyzzUrl() {
		return yyzzUrl;
	}
	public void setYyzzUrl(String yyzzUrl) {
		this.yyzzUrl = yyzzUrl;
	}
	public String getLegalPerson() {
		return legalPerson;
	}
	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}
	public String getLegalPersonNum() {
		return legalPersonNum;
	}
	public void setLegalPersonNum(String legalPersonNum) {
		this.legalPersonNum = legalPersonNum;
	}
	public String getSfzZmUrl() {
		return sfzZmUrl;
	}
	public void setSfzZmUrl(String sfzZmUrl) {
		this.sfzZmUrl = sfzZmUrl;
	}
	public String getSfzFmUrl() {
		return sfzFmUrl;
	}
	public void setSfzFmUrl(String sfzFmUrl) {
		this.sfzFmUrl = sfzFmUrl;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getBdTel() {
		return bdTel;
	}
	public void setBdTel(String bdTel) {
		this.bdTel = bdTel;
	}
	public String getContactsEmail() {
		return contactsEmail;
	}
	public void setContactsEmail(String contactsEmail) {
		this.contactsEmail = contactsEmail;
	}
	public String getRegistAddressProv() {
		return registAddressProv;
	}
	public void setRegistAddressProv(String registAddressProv) {
		this.registAddressProv = registAddressProv;
	}
	public String getRegistAddressCity() {
		return registAddressCity;
	}
	public void setRegistAddressCity(String registAddressCity) {
		this.registAddressCity = registAddressCity;
	}
	public String getRegistAddressCou() {
		return registAddressCou;
	}
	public void setRegistAddressCou(String registAddressCou) {
		this.registAddressCou = registAddressCou;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getEntpBankNum() {
		return entpBankNum;
	}
	public void setEntpBankNum(String entpBankNum) {
		this.entpBankNum = entpBankNum;
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
	public String getOpenBank() {
		return openBank;
	}
	public void setOpenBank(String openBank) {
		this.openBank = openBank;
	}
	public String getOpenBankType() {
		return openBankType;
	}
	public void setOpenBankType(String openBankType) {
		this.openBankType = openBankType;
	}
	public String getEmailValiCode() {
		return emailValiCode;
	}
	public void setEmailValiCode(String emailValiCode) {
		this.emailValiCode = emailValiCode;
	}
	public String getCompType() {
		return compType;
	}
	public void setCompType(String compType) {
		this.compType = compType;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}





}
