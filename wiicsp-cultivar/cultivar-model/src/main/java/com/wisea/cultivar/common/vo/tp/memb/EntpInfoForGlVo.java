package com.wisea.cultivar.common.vo.tp.memb;

import java.io.Serializable;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

/**
 * 果链需要的企业信息VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年6月13日
 * @version 1.0
 */
public class EntpInfoForGlVo implements Serializable{

	private static final long serialVersionUID = -8527418004574646927L;

	private Long id;//ID
	private String compName;//企业名称
	private String legalPerson;// 法人
	private String registAddressProv;// 地址省
	private String registAddressCity;// 地址市
	private String registAddressCou;// 地址县
	private String address;// 详细地址
	private String salePrdut;// 销售产品
	private String bdTel;// 电话
	private String password;//密码
	private String addressDetail;//拼接的地址
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	private OffsetDateTime registDate;//注册时间

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public String getLegalPerson() {
		return legalPerson;
	}
	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
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
	public String getSalePrdut() {
		return salePrdut;
	}
	public void setSalePrdut(String salePrdut) {
		this.salePrdut = salePrdut;
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
}
