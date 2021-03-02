package com.wisea.cultivar.plant.vo.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.annotation.LongSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 会员信息中的主体信息VO
 *
 * @author wangh(wisea)
 *
 * @date 2018年6月6日
 * @version 1.0
 */
@ApiModel("会员信息中的主体信息VO")
public class MembMainInfoVo {

	/** 基本信息 */
	@ApiModelProperty("会员ID")
	@JsonSerialize(using= LongSerializer.class)
	private Long id;
	@ApiModelProperty("头像")
	private String logoUrl;
	@ApiModelProperty("主体名称")
	private String orgName;
	@ApiModelProperty("联系人")
	private String contName;
	@ApiModelProperty("手机号码")
	private String contTel;
	@ApiModelProperty("会员地址-省")
	private String areaCodeProv;
	@ApiModelProperty("会员地址-市")
	private String areaCodeCity;
	@ApiModelProperty("会员地址-县")
	private String areaCodeCou;
	@ApiModelProperty("会员详细地址")
	private String address;
	@ApiModelProperty("会员主体类型[subject_type(0:企业1:合作社2:散户3:经纪人)]")
	private String subjectType;
	@ApiModelProperty("会员介绍")
	private String introduce;
	@ApiModelProperty("会员类型")
	private String membType;
	/** 会员图片信息 */
	@ApiModelProperty("会员图片信息列表")
	private List<String> membPicList = null;
	/** 会员品牌信息 */
	@ApiModelProperty("会员品牌信息")
	private List<MembBrandInfoVo> membBrandInfoList = null;
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
	 * @return the membBrandInfoList
	 */
	public List<MembBrandInfoVo> getMembBrandInfoList() {
		return membBrandInfoList;
	}
	/**
	 * @param membBrandInfoList the membBrandInfoList to set
	 */
	public void setMembBrandInfoList(List<MembBrandInfoVo> membBrandInfoList) {
		this.membBrandInfoList = membBrandInfoList;
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
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	public String getMembType() {
		return membType;
	}

	public void setMembType(String membType) {
		this.membType = membType;
	}
}
