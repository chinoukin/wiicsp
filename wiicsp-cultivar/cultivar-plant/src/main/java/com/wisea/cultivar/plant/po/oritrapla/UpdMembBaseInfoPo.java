package com.wisea.cultivar.plant.po.oritrapla;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 后台管理修改会员基础信息PO
 *
 * @author wangh(wisea)
 *
 * @date 2018年6月19日
 * @version 1.0
 */
@ApiModel("后台管理修改会员基础信息PO")
public class UpdMembBaseInfoPo {

	@ApiModelProperty(value="ID",required=true)
	@Check(test="required")
	private Long id = null;
	@ApiModelProperty(value="用户名",required=true)
	@Check(test="required")
	private String loginName;
	@ApiModelProperty(value="密码(不修改为空)")
	private String password;
	@ApiModelProperty(value="手机号",required=true)
	@Check(test="required")
	private String contTel;
	@ApiModelProperty(value="姓名",required=true)
	@Check(test="required")
	private String contName;
	@ApiModelProperty(value="性别[sex_type(0:男1:女)]",required=true)
	@Check(test={"required","regex"},regex = "^[0-1]$", regexMsg = "性别只能为0~1")
	private String sexType;
	@ApiModelProperty(value="职称")
	private String position;
	@ApiModelProperty(value="个人签名")
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
