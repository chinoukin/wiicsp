package com.wisea.transac.common.vo.memb;

import java.io.Serializable;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 企业认证详细信息初期话VO
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月12日
 * @version 1.0
 */
@ApiModel("企业认证详细信息初期话VO")
public class EntpAuthUpdInitVo implements Serializable{

	private static final long serialVersionUID = 8888965535386471576L;

	@ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="会员id")
    private Long membId;

    @ApiModelProperty(value="企业名称")
    private String entpName;

    @ApiModelProperty(value="企业简称")
    private String entpShortName;

    @ApiModelProperty(value="批发市场id")
    private Long wholeSaleMarketId;

    @ApiModelProperty(value="批发市场名称")
    private String marketName;

    @ApiModelProperty(value="客户类型")
    private String custType;

    @ApiModelProperty(value="注册地省")
    private String areaProv;

    @ApiModelProperty(value="注册地市")
    private String areaCity;

    @ApiModelProperty(value="注册地区县")
    private String areaCou;

    @ApiModelProperty(value="注册地区省市县中文")
    private String remarks;

    @ApiModelProperty(value="详细地址")
    private String address;

    @ApiModelProperty(value="统一社会信用代码/营业执照号")
    private String ctscc;

    @ApiModelProperty(value="法人身份证有效期开始时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime legalPersonValidityStart;

    @ApiModelProperty(value="法人身份证有效期结束时间(为空默认是无期限)")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime legalPersonValidityEnd;

    @ApiModelProperty(value="营业执照url")
    private String yyzzUrl;

    @ApiModelProperty(value="门头照")
    private String mtzUrl;

    @ApiModelProperty(value="经营场所图1")
    private String jycsUrlOne;

    @ApiModelProperty(value="经营场所图2")
    private String jycsUrlTwo;

    @ApiModelProperty(value="联系人")
    private String conter;

    @ApiModelProperty(value="联系人手机号")
    private String contTel;

    @ApiModelProperty(value="邮箱")
    private String email;

    @ApiModelProperty(value="法人姓名")
    private String legalPersonName;

    @ApiModelProperty(value="法人手机号")
    private String legalPersonTel;

    @ApiModelProperty(value="法人身份证号")
    private String legalPersonNum;

    @ApiModelProperty(value="营业执照有效期开始时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime yyzzValidityStart;

    @ApiModelProperty(value="营业执照有效期结束时间(如果不填写则默认无期限)")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime yyzzValidityEnd;

    @ApiModelProperty(value="身份证正面url")
    private String sfzZmUrl;

    @ApiModelProperty(value="身份证反面url")
    private String sfzFmUrl;

    @ApiModelProperty(value="手持身份证照片")
    private String holdSfzZmUrl;

    @ApiModelProperty(value="企业类型")
    private String entpType;

    /**  企业银行信息  **/
    @ApiModelProperty(value="账户类型")
    private String bankAcctType;

    @ApiModelProperty(value="开户行名称")
    private String openBank;

    @ApiModelProperty(value="结算银行卡号")
    private String entpBankNum;

    @ApiModelProperty(value="银行预留手机号")
    private String bankReservedTel;

    @ApiModelProperty(value="开户名")
    private String khName;

    @ApiModelProperty(value="开户行省")
    private String khProv;

    @ApiModelProperty(value="开户行市")
    private String khCity;

    @ApiModelProperty(value="开户支行")
    private String acctOpenSubBank;

    @ApiModelProperty(value="结算银行卡正面url")
    private String bankCardZmUrl;

    @ApiModelProperty(value="结算银行卡反面url")
    private String bankCardFmUrl;

    @ApiModelProperty(value="开户许可证url")
    private String khxkzUrl;

    @ApiModelProperty(value="客户协议书")
    private String registAgreementFile;

    @ApiModelProperty(value="认证时间")
    private OffsetDateTime authDate;

    @ApiModelProperty(value="审核状态(auth_state_type 0:待平台审核1:待银盛开户2:实名认证中3:审核通过4:审核未通过)")
    private String authStateType;

    @ApiModelProperty(value="审核未通过原因")
    private String examFailReason;

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

	public String getEntpName() {
		return entpName;
	}

	public void setEntpName(String entpName) {
		this.entpName = entpName;
	}

	public String getEntpShortName() {
		return entpShortName;
	}

	public void setEntpShortName(String entpShortName) {
		this.entpShortName = entpShortName;
	}

	public Long getWholeSaleMarketId() {
		return wholeSaleMarketId;
	}

	public void setWholeSaleMarketId(Long wholeSaleMarketId) {
		this.wholeSaleMarketId = wholeSaleMarketId;
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public String getAreaProv() {
		return areaProv;
	}

	public void setAreaProv(String areaProv) {
		this.areaProv = areaProv;
	}

	public String getAreaCity() {
		return areaCity;
	}

	public void setAreaCity(String areaCity) {
		this.areaCity = areaCity;
	}

	public String getAreaCou() {
		return areaCou;
	}

	public void setAreaCou(String areaCou) {
		this.areaCou = areaCou;
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

	public String getYyzzUrl() {
		return yyzzUrl;
	}

	public void setYyzzUrl(String yyzzUrl) {
		this.yyzzUrl = yyzzUrl;
	}

	public String getMtzUrl() {
		return mtzUrl;
	}

	public void setMtzUrl(String mtzUrl) {
		this.mtzUrl = mtzUrl;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLegalPersonName() {
		return legalPersonName;
	}

	public void setLegalPersonName(String legalPersonName) {
		this.legalPersonName = legalPersonName;
	}

	public String getLegalPersonTel() {
		return legalPersonTel;
	}

	public void setLegalPersonTel(String legalPersonTel) {
		this.legalPersonTel = legalPersonTel;
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

	public String getHoldSfzZmUrl() {
		return holdSfzZmUrl;
	}

	public void setHoldSfzZmUrl(String holdSfzZmUrl) {
		this.holdSfzZmUrl = holdSfzZmUrl;
	}

	public String getMarketName() {
		return marketName;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public OffsetDateTime getLegalPersonValidityStart() {
		return legalPersonValidityStart;
	}

	public void setLegalPersonValidityStart(OffsetDateTime legalPersonValidityStart) {
		this.legalPersonValidityStart = legalPersonValidityStart;
	}

	public OffsetDateTime getLegalPersonValidityEnd() {
		return legalPersonValidityEnd;
	}

	public void setLegalPersonValidityEnd(OffsetDateTime legalPersonValidityEnd) {
		this.legalPersonValidityEnd = legalPersonValidityEnd;
	}

	public OffsetDateTime getYyzzValidityStart() {
		return yyzzValidityStart;
	}

	public void setYyzzValidityStart(OffsetDateTime yyzzValidityStart) {
		this.yyzzValidityStart = yyzzValidityStart;
	}

	public OffsetDateTime getYyzzValidityEnd() {
		return yyzzValidityEnd;
	}

	public void setYyzzValidityEnd(OffsetDateTime yyzzValidityEnd) {
		this.yyzzValidityEnd = yyzzValidityEnd;
	}

	public String getEntpType() {
		return entpType;
	}

	public void setEntpType(String entpType) {
		this.entpType = entpType;
	}

	public String getBankAcctType() {
		return bankAcctType;
	}

	public void setBankAcctType(String bankAcctType) {
		this.bankAcctType = bankAcctType;
	}

	public String getOpenBank() {
		return openBank;
	}

	public void setOpenBank(String openBank) {
		this.openBank = openBank;
	}

	public String getEntpBankNum() {
		return entpBankNum;
	}

	public void setEntpBankNum(String entpBankNum) {
		this.entpBankNum = entpBankNum;
	}

	public String getBankReservedTel() {
		return bankReservedTel;
	}

	public void setBankReservedTel(String bankReservedTel) {
		this.bankReservedTel = bankReservedTel;
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

	public String getAcctOpenSubBank() {
		return acctOpenSubBank;
	}

	public void setAcctOpenSubBank(String acctOpenSubBank) {
		this.acctOpenSubBank = acctOpenSubBank;
	}

	public String getBankCardZmUrl() {
		return bankCardZmUrl;
	}

	public void setBankCardZmUrl(String bankCardZmUrl) {
		this.bankCardZmUrl = bankCardZmUrl;
	}

	public String getBankCardFmUrl() {
		return bankCardFmUrl;
	}

	public void setBankCardFmUrl(String bankCardFmUrl) {
		this.bankCardFmUrl = bankCardFmUrl;
	}

	public String getKhxkzUrl() {
		return khxkzUrl;
	}

	public void setKhxkzUrl(String khxkzUrl) {
		this.khxkzUrl = khxkzUrl;
	}

	public String getRegistAgreementFile() {
		return registAgreementFile;
	}

	public void setRegistAgreementFile(String registAgreementFile) {
		this.registAgreementFile = registAgreementFile;
	}

	public OffsetDateTime getAuthDate() {
		return authDate;
	}

	public void setAuthDate(OffsetDateTime authDate) {
		this.authDate = authDate;
	}

	public String getAuthStateType() {
		return authStateType;
	}

	public void setAuthStateType(String authStateType) {
		this.authStateType = authStateType;
	}

	public String getExamFailReason() {
		return examFailReason;
	}

	public void setExamFailReason(String examFailReason) {
		this.examFailReason = examFailReason;
	}

	public String getJycsUrlOne() {
		return jycsUrlOne;
	}

	public void setJycsUrlOne(String jycsUrlOne) {
		this.jycsUrlOne = jycsUrlOne;
	}

	public String getJycsUrlTwo() {
		return jycsUrlTwo;
	}

	public void setJycsUrlTwo(String jycsUrlTwo) {
		this.jycsUrlTwo = jycsUrlTwo;
	}


}
