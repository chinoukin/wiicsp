package com.wisea.cultivar.plant.po.oritrapla;

import com.google.common.collect.Lists;
import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 保存会员主题信息PO
 *
 * @author wangh(wisea)
 *
 * @date 2018年6月6日
 * @version 1.0
 */
@ApiModel("保存会员主题信息PO")
public class MembMainInfoPo {

	@ApiModelProperty(value="头像")
	private String logoUrl;
	@ApiModelProperty(value="主体名称",required= true)
	@Check(test = "required")
	private String orgName;
	@ApiModelProperty(value="主体类型(0:企业1:合作社2:散户3:经纪人)",required= true)
	@Check(test={"required","regex"},regex = "^[0-3]$", regexMsg = "主体类型只能为0~3")
	private String subjectType;
	@ApiModelProperty(value="联系人",required= true)
	@Check(test = "required")
	private String contName;
	@ApiModelProperty(value="手机号",required= true)
	@Check(test = "required")
	private String contTel;
	@ApiModelProperty(value="地区-省",required= true)
	@Check(test = "required")
	private String areaCodeProv;
	@ApiModelProperty(value="地区-市",required= true)
	@Check(test = "required")
	private String areaCodeCity;
	@ApiModelProperty(value="地区-县",required= true)
	@Check(test = "required")
	private String areaCodeCou;
	@ApiModelProperty(value="详细地址",required= true)
	@Check(test = "required")
	private String address;
	@ApiModelProperty(value="介绍")
	private String introduce;
	@ApiModelProperty(value="图片信息列表(最多六张图片)")
	private List<String> membPicList = Lists.newArrayList();
	/**
	 * @return the logoUrl
	 */
	public String getLogoUrl() {
		return logoUrl;
	}
	/**
	 * @param logoUrl the logoUrl to set
	 */
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
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
	 * @return the subjectType
	 */
	public String getSubjectType() {
		return subjectType;
	}
	/**
	 * @param subjectType the subjectType to set
	 */
	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType;
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
	/**
	 * @return the introduce
	 */
	public String getIntroduce() {
		return introduce;
	}
	/**
	 * @param introduce the introduce to set
	 */
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	/**
	 * @return the membPicList
	 */
	public List<String> getMembPicList() {
		return membPicList;
	}
	/**
	 * @param membPicList the membPicList to set
	 */
	public void setMembPicList(List<String> membPicList) {
		this.membPicList = membPicList;
	}
}
