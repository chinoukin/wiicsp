package com.wisea.cultivar.common.vo.tp.memb;

import java.io.Serializable;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

/**
 * 会员基本信息（农资政府端通不用）
 *
 * @author wangh(wisea)
 *
 * @date 2019年9月6日
 * @version 1.0
 */
public class MembInfoForNzVo implements Serializable{

	/**
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年9月6日
	 * @version 1.0
	 */
	private static final long serialVersionUID = -619000411942035769L;
	/**
	 * 会员ID
	 */
	private Long membId;// 会员ID
	/**
	 * 用户名
	 */
	private String loginName;// 用户名
	/**
	 * 公司名称
	 */
	private String compName;// 公司名称
	/**
	 * 联系人
	 */
	private String contacts;// 联系人
	/**
	 * 地址省
	 */
	private String registAddressProv;// 地址省
	private String registAddressCity;// 地址市
	private String registAddressCou;// 地址县
	private String address;// 详细地址
	private String bdTel;// 电话
	private String password;//密码
	private String addressDetail;//拼接的地址
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	private OffsetDateTime registDate;//注册时间
	private String ctscc;//统一社会信用代码
	private String yyzzUrl;//营业执照url

	public Long getMembId() {
		return membId;
	}
	public void setMembId(Long membId) {
		this.membId = membId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
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
	public String getBdTel() {
		return bdTel;
	}
	public void setBdTel(String bdTel) {
		this.bdTel = bdTel;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	public OffsetDateTime getRegistDate() {
		return registDate;
	}
	public void setRegistDate(OffsetDateTime registDate) {
		this.registDate = registDate;
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
}
