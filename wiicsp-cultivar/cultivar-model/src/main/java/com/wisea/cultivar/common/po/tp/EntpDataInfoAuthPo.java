package com.wisea.cultivar.common.po.tp;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * EntpDataInfoPo
 * 2018/09/18 14:36:47
 */
@ApiModel("修改需要审批的商家信息PO")
public class EntpDataInfoAuthPo {

    /**
     * 企业名称
     */
    @Check(test = {"required","maxLength" }, mixLength = 100)
    @ApiModelProperty(value = "企业名称")
    private String compName;

    /**
     * 注册地址省
     */
    @Check(test = {"required","maxLength" }, mixLength = 20)
    @ApiModelProperty(value = "注册地址省")
    private String registAddressProv;

    /**
     * 注册地址市
     */
    @Check(test = { "required","maxLength" }, mixLength = 20)
    @ApiModelProperty(value = "注册地址市")
    private String registAddressCity;

    /**
     * 注册地址区县
     */
    @Check(test = { "required","maxLength" }, mixLength = 20)
    @ApiModelProperty(value = "注册地址区县")
    private String registAddressCou;

    /**
     * 详细地址
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "详细地址")
    private String address;

    /**
     * 注册资本
     */
    @Check(test = { "required","regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "注册资本")
    private Double registCapital;

    /**
     * 成立日期
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @Check(test="required")
    @ApiModelProperty(value = "成立日期")
    private OffsetDateTime estaDate;

    /**
     * 统一社会信用代码
     */
    @Check(test = { "required","maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "统一社会信用代码")
    private String ctscc;

//    /**
//     * 企业银行卡号
//     */
//    @Check(test = { "required","maxLength" }, mixLength = 30)
//    @ApiModelProperty(value = "企业银行卡号")
//    private String entpBankNum;
//    /**
//     * 开户行
//     */
//    @Check(test = { "required","maxLength" }, mixLength = 100)
//    @ApiModelProperty(value = "开户行")
//    private String openBank;
    /**
     * 法人代表
     */
    @Check(test = { "required","maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "法人代表")
    private String legalPerson;

    /**
     * 登记机关
     */
    @Check(test = { "required","maxLength" }, mixLength = 100)
    @ApiModelProperty(value = "登记机关")
    private String registAuth;

    /**
     * 企业类型
     */
    @Check(test = { "required","maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "企业类型")
    private String compType;

    /**
     * 营业开始日期
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "营业开始日期")
    private OffsetDateTime businessStartDate;

    /**
     * 营业结束日期
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "营业结束日期")
    private OffsetDateTime businessEndDate;

    /**
     * 经营范围
     */
    @Check(test = { "required","maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "经营范围")
    private String operateRange;

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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Double getRegistCapital() {
		return registCapital;
	}
	public void setRegistCapital(Double registCapital) {
		this.registCapital = registCapital;
	}
	public OffsetDateTime getEstaDate() {
		return estaDate;
	}
	public void setEstaDate(OffsetDateTime estaDate) {
		this.estaDate = estaDate;
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
	public String getRegistAuth() {
		return registAuth;
	}
	public void setRegistAuth(String registAuth) {
		this.registAuth = registAuth;
	}
	public String getCompType() {
		return compType;
	}
	public void setCompType(String compType) {
		this.compType = compType;
	}
	public OffsetDateTime getBusinessStartDate() {
		return businessStartDate;
	}
	public void setBusinessStartDate(OffsetDateTime businessStartDate) {
		this.businessStartDate = businessStartDate;
	}
	public OffsetDateTime getBusinessEndDate() {
		return businessEndDate;
	}
	public void setBusinessEndDate(OffsetDateTime businessEndDate) {
		this.businessEndDate = businessEndDate;
	}
	public String getOperateRange() {
		return operateRange;
	}
	public void setOperateRange(String operateRange) {
		this.operateRange = operateRange;
	}
}
