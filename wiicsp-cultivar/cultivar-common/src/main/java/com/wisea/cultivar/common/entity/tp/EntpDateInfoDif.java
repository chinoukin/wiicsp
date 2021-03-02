package com.wisea.cultivar.common.entity.tp;

import java.time.OffsetDateTime;
/**
 * 企业信息审核字段的entity
 *
 * @author wangh(wisea)
 *
 * @date 2018年12月7日
 * @version 1.0
 */
public class EntpDateInfoDif {
	/**
     * 企业名称
     */
    private String compName;

    /**
     * 注册地址省
     */
    private String registAddressProv;

    /**
     * 注册地址市
     */
    private String registAddressCity;

    /**
     * 注册地址区县
     */
    private String registAddressCou;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 注册资本
     */
    private Double registCapital;

    /**
     * 成立日期
     */
    private OffsetDateTime estaDate;

    /**
     * 统一社会信用代码
     */
    private String ctscc;

    /**
     * 法人代表
     */
    private String legalPerson;

    /**
     * 登记机关
     */
    private String registAuth;

    /**
     * 企业类型
     */
    private String compType;

    /**
     * 营业期限类型
     */
    private String businessTermType;

    /**
     * 营业开始日期
     */
    private OffsetDateTime businessStartDate;

    /**
     * 营业结束日期
     */
    private OffsetDateTime businessEndDate;

    /**
     * 经营范围
     */
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

	public String getBusinessTermType() {
		return businessTermType;
	}

	public void setBusinessTermType(String businessTermType) {
		this.businessTermType = businessTermType;
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
