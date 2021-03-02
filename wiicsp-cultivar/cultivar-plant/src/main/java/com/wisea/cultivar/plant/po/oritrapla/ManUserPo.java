package com.wisea.cultivar.plant.po.oritrapla;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 保存管理员用户信息的PO
 *
 * @author wangh(wisea)
 *
 * @date 2018年6月20日
 * @version 1.0
 */
@ApiModel("保存管理员用户信息的PO")
public class ManUserPo {

	@ApiModelProperty(value="新增的时候为空，修改的时候必须填写")
	private Long id = null;
	@ApiModelProperty(value="用户名",required=true)
	@Check(test="required")
	private String loginName;
	@ApiModelProperty(value="密码(新增的时候必须填写)")
	 @Check(test = "logic", logic = "#isEmpty(#id)?#isNotEmpty(#password):true", logicMsg = "新增的时候密码不能为空")
	private String password;
	@ApiModelProperty(value="姓名",required=true)
	@Check(test="required")
	private String contName;
	@ApiModelProperty(value="手机号",required=true)
	@Check(test="required")
	private String contTel;
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
