package com.wisea.cultivar.plant.vo.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.annotation.LongSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户登录后获取的基本信息
 *
 * @author wangh(wisea)
 *
 * @date 2018年6月5日
 * @version 1.0
 */
@ApiModel("app端用户登录后获取的用户基本信息")
public class LoginBaseInfoVo {

	@ApiModelProperty("用户会员ID")
	@JsonSerialize(using= LongSerializer.class)
	private Long id;
	@ApiModelProperty("用户会员的父节点ID(如果是主体账户为空)")
	@JsonSerialize(using= LongSerializer.class)
	private Long pid;
	@ApiModelProperty("头像")
	private String logoUrl;
	@ApiModelProperty("姓名")
	private String contName;
	@ApiModelProperty("登录用户名")
	private String loginName;
	@ApiModelProperty("手机号码")
	private String contTel;
	@ApiModelProperty("职位")
	private String position;
	@ApiModelProperty("公司或农场名称")
	private String orgName;
	@ApiModelProperty("性別[sex_type(0:男1:女)]")
	private String sexType;
	@ApiModelProperty("个性签名")
	private String signature;
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
	/**
	 * @return the pid
	 */
	public Long getPid() {
		return pid;
	}
	/**
	 * @param pid the pid to set
	 */
	public void setPid(Long pid) {
		this.pid = pid;
	}
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
	 * @return the loginName
	 */
	public String getLoginName() {
		return loginName;
	}
	/**
	 * @param loginName the loginName to set
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
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
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
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
	 * @return the sexType
	 */
	public String getSexType() {
		return sexType;
	}
	/**
	 * @param sexType the sexType to set
	 */
	public void setSexType(String sexType) {
		this.sexType = sexType;
	}
	/**
	 * @return the signature
	 */
	public String getSignature() {
		return signature;
	}
	/**
	 * @param signature the signature to set
	 */
	public void setSignature(String signature) {
		this.signature = signature;
	}
}
