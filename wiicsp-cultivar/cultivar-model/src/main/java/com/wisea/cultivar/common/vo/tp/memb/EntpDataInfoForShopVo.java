package com.wisea.cultivar.common.vo.tp.memb;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * EntpDataInfoGetVo
 * 2018/10/08 10:50:19
 */
@ApiModel("企业详细信息(商铺显示)VO")
public class EntpDataInfoForShopVo {
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
     * 经营范围
     */
    @ApiModelProperty(value = "经营范围")
    private String operateRange;

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
	public String getCompType() {
		return compType;
	}
	public void setCompType(String compType) {
		this.compType = compType;
	}
	public String getCompShortName() {
		return compShortName;
	}
	public void setCompShortName(String compShortName) {
		this.compShortName = compShortName;
	}
	public String getOperateRange() {
		return operateRange;
	}
	public void setOperateRange(String operateRange) {
		this.operateRange = operateRange;
	}
}
