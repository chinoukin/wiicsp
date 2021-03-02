package com.wisea.cultivar.common.vo.tp.memb;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * EntpDataInfoGetVo
 * 2018/10/08 10:50:19
 */
@ApiModel("企业详细信息VO")
public class EntpDataInfoGetVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 会员id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "会员id")
    private Long membId;

    @ApiModelProperty(value = "企业类型（comp_type0:采购商认证1:供应商认证）")
	private String compType;
    /**
     * 企业名称
     */
    @ApiModelProperty(value = "认证企业名称")
    private String compName;
    /**
     * 企业名称简称
     */
    @ApiModelProperty(value = "企业名称简称")
    private String compShortName;
    /**
     * 注册地址省
     */
    @ApiModelProperty(value = "注册地址省")
    private String registAddressProv;

    /**
     * 注册地址市
     */
    @ApiModelProperty(value = "注册地址市")
    private String registAddressCity;

    /**
     * 注册地址区县
     */
    @ApiModelProperty(value = "注册地址区县")
    private String registAddressCou;

    /**
     * 中文省市县地址
     */
    @ApiModelProperty(value = "中文注册地址(省市县)")
    private String registZhCn;
    /**
     * 详细地址
     */
    @ApiModelProperty(value = "详细地址")
    private String address;
    /**
     * 统一社会信用代码
     */
    @ApiModelProperty(value = "统一社会信用代码")
    private String ctscc;
    /**
     * 法人代表
     */
    @ApiModelProperty(value = "法人代表")
    private String legalPerson;

    /**
     * 联系人
     */
    @ApiModelProperty(value = "联系人")
    private String contacts;
    /**
     * 申請時間
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value="申请时间")
	private OffsetDateTime updateDate;
    /**
     * 法人代表身份证号
    */
    @ApiModelProperty(value = "法人代表身份证号")
    private String legalPersonNum;
    /**
     * 绑定手机号
     */
    @ApiModelProperty(value = "绑定手机号")
    private String bdTel;
    /**
    * 邮箱地址
    */
    @ApiModelProperty(value = "邮箱地址")
    private String contactsEmail;
    /**
    * 营业执照url
    */
    @ApiModelProperty(value = "营业执照url")
    private String yyzzUrl;
    /**
    * 身份证正面url
    */
    @ApiModelProperty(value = "身份证正面url")
    private String sfzZmUrl;
    /**
    * 身份证反面url
    */
    @ApiModelProperty(value = "身份证反面url")
    private String sfzFmUrl;
    /**
     * 开户许可证编号
     */
    @ApiModelProperty(value = "开户许可证编号")
    private String khxkzNum;// 开户许可证编号
    /**
     * 开户许可证url
     */
    @ApiModelProperty(value = "开户许可证url")
	private String khxkzUrl;// 开户许可证url
    /**
     * 企业银行卡号
     */
    @ApiModelProperty(value = "企业银行卡号")
    private String entpBankNum;//企业银行卡号
    /**
     * 开户名
     */
    @ApiModelProperty(value = "开户名")
    private String khName;//开户名
    /**
     * 开户行类型
     */
    @ApiModelProperty(value = "开户行类型")
    private String openBankType;// 开户行类型
    /**
     * 开户行省
     */
    @ApiModelProperty(value = "开户行省")
    private String khProv;// 开户行省
    /**
     * 开户行市
     */
    @ApiModelProperty(value = "开户行市")
    private String khCity;// 开户行市
    /**
     * 开户行
     */
    @ApiModelProperty(value = "开户行")
    private String openBank;// 开户行
    /**
     * 认证审核状态
     */
    @ApiModelProperty(value = "认证审核状态")
    private String authExamState;
    /**
     * 认证审核失败原因
     */
    @ApiModelProperty(value = "认证审核失败原因")
    private String examFailReason;
    /**
     * 是否技术服务商标记
     */
    @ApiModelProperty(value = "是否技术服务商标记")
    private String sfjsfwsFlag;

    protected String createBy; // 创建者
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    protected OffsetDateTime createDate; // 创建日期
    protected String updateBy; // 更新者
    protected String remarks; // 备注
    protected String delFlag; // 删除标记（0：正常；1：删除；2：审核）

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getMembId() {
		return membId;
	}
	public void setMembId(Long membId) {
		this.membId = membId;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
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
	public String getRegistZhCn() {
		return registZhCn;
	}
	public void setRegistZhCn(String registZhCn) {
		this.registZhCn = registZhCn;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getAuthExamState() {
		return authExamState;
	}
	public void setAuthExamState(String authExamState) {
		this.authExamState = authExamState;
	}
	public String getExamFailReason() {
		return examFailReason;
	}
	public void setExamFailReason(String examFailReason) {
		this.examFailReason = examFailReason;
	}
	public String getCompShortName() {
		return compShortName;
	}
	public void setCompShortName(String compShortName) {
		this.compShortName = compShortName;
	}
	public String getLegalPersonNum() {
		return legalPersonNum;
	}
	public void setLegalPersonNum(String legalPersonNum) {
		this.legalPersonNum = legalPersonNum;
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
	public String getYyzzUrl() {
		return yyzzUrl;
	}
	public void setYyzzUrl(String yyzzUrl) {
		this.yyzzUrl = yyzzUrl;
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
	public OffsetDateTime getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(OffsetDateTime updateDate) {
		this.updateDate = updateDate;
	}
	public String getCompType() {
		return compType;
	}
	public void setCompType(String compType) {
		this.compType = compType;
	}
}
