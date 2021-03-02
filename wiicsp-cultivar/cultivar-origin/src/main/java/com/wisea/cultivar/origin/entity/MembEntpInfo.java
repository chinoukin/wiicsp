package com.wisea.cultivar.origin.entity;

import java.time.OffsetDateTime;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * 会员信息
 *
 * @author wangh(wisea)
 *
 * @date 2018年8月30日
 * @version 1.0
 */
public class MembEntpInfo extends DataLongEntity<MembEntpInfo> {

	/**
	 *
	 */
	private static final long serialVersionUID = -5815793216803793839L;

	private String userName;

	private String registTel;

	private OffsetDateTime registDate;

	private String entpAuthStateType;

	private String agentFlag;

	private String acctState;

	private String petName;

	private String url;
	private String compName;
	private String registAddressProv;
	private String registAddressCity;
	private String registAddressCou;
	private String address;
	private String contacts;
	private String compTel;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRegistTel() {
		return registTel;
	}

	public void setRegistTel(String registTel) {
		this.registTel = registTel;
	}

	public OffsetDateTime getRegistDate() {
		return registDate;
	}

	public void setRegistDate(OffsetDateTime registDate) {
		this.registDate = registDate;
	}

	public String getEntpAuthStateType() {
		return entpAuthStateType;
	}

	public void setEntpAuthStateType(String entpAuthStateType) {
		this.entpAuthStateType = entpAuthStateType;
	}

	public String getAgentFlag() {
		return agentFlag;
	}

	public void setAgentFlag(String agentFlag) {
		this.agentFlag = agentFlag;
	}

	public String getAcctState() {
		return acctState;
	}

	public void setAcctState(String acctState) {
		this.acctState = acctState;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getCompTel() {
		return compTel;
	}

	public void setCompTel(String compTel) {
		this.compTel = compTel;
	}

}
