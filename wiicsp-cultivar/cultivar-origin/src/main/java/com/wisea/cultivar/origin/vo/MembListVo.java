package com.wisea.cultivar.origin.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 采样企业列表
 * @author wzx
 *
 */
@ApiModel("采样企业列表VO")
public class MembListVo {
	@ApiModelProperty("ID")
	@JsonSerialize(using = IdSerializer.class)
	private Long id;
	@ApiModelProperty("企业名称")
	private String membName; // 会员名称
	@ApiModelProperty("联系人")
	private String contacts; // 联系人
	@ApiModelProperty("联系方式")
	private String tel; // 联系方式
	@ApiModelProperty("所在地区")
	private String address; // 所在地区
	@ApiModelProperty("详细地址")
	private String detailAddress; // 详细地址
	@ApiModelProperty(value = "注册地址省", hidden = true)
    private String registAddressProv;
	@ApiModelProperty(value = "注册地址市", hidden = true)
	private String registAddressCity;
	@ApiModelProperty(value = "注册地址区县", hidden = true)
	private String registAddressCou;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMembName() {
		return membName;
	}
	public void setMembName(String membName) {
		this.membName = membName;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
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

}
