package com.wisea.cultivar.plant.po.oritrapla;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 保存会员信息的主体信息PO
 *
 * @author wangh(wisea)
 *
 * @date 2018年6月5日
 * @version 1.0
 */
@ApiModel("保存会员信息的主体信息PO")
public class SaveMainMembInfoPo {
	@ApiModelProperty("会员类型")
	@Check(test="required")
	private String membType;
	@ApiModelProperty(value="主体名称(必填)",required=true)
	@Check(test="required,minLength,maxLength",lengthRange={4,50},lengthMsg="主体名称的长度为4-50")
	private String orgName;
	@ApiModelProperty(value="联系人姓名(必填)",required=true)
	@Check(test="required,maxLength",lengthRange={20},lengthMsg="联系人姓名不超过20")
	private String contName;
	@ApiModelProperty(value="联系人电话")
//	@Check(test="required,minLength,maxLength",lengthRange={11,11},lengthMsg="联系人电话的长度为11")
	private String contTel;
	@ApiModelProperty(value="地区-省(必填)",required=true)
	@Check(test="required")
	private String areaCodeProv;
	@ApiModelProperty(value="地区-市(必填)",required=true)
	@Check(test="required")
	private String areaCodeCity;
	@ApiModelProperty(value="地区-县(必填)",required=true)
	@Check(test="required")
	private String areaCodeCou;
	@ApiModelProperty(value="详细地址")
	private String address;


	public String getMembType() {
		return membType;
	}

	public void setMembType(String membType) {
		this.membType = membType;
	}

	/**
	 * @return the orgName
	 */
	public String getOrgName() {
		return orgName;
	}
	/**
	 * @param orgName the orgName to set
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	/**
	 * @return the contName
	 */
	public String getContName() {
		return contName;
	}
	/**
	 * @param contName the contName to set
	 */
	public void setContName(String contName) {
		this.contName = contName;
	}
	/**
	 * @return the contTel
	 */
	public String getContTel() {
		return contTel;
	}
	/**
	 * @param contTel the contTel to set
	 */
	public void setContTel(String contTel) {
		this.contTel = contTel;
	}
	/**
	 * @return the areaCodeProv
	 */
	public String getAreaCodeProv() {
		return areaCodeProv;
	}
	/**
	 * @param areaCodeProv the areaCodeProv to set
	 */
	public void setAreaCodeProv(String areaCodeProv) {
		this.areaCodeProv = areaCodeProv;
	}
	/**
	 * @return the areaCodeCity
	 */
	public String getAreaCodeCity() {
		return areaCodeCity;
	}
	/**
	 * @param areaCodeCity the areaCodeCity to set
	 */
	public void setAreaCodeCity(String areaCodeCity) {
		this.areaCodeCity = areaCodeCity;
	}
	/**
	 * @return the areaCodeCou
	 */
	public String getAreaCodeCou() {
		return areaCodeCou;
	}
	/**
	 * @param areaCodeCou the areaCodeCou to set
	 */
	public void setAreaCodeCou(String areaCodeCou) {
		this.areaCodeCou = areaCodeCou;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
}
