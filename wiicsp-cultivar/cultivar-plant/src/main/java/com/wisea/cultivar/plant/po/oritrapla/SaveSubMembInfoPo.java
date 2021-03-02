package com.wisea.cultivar.plant.po.oritrapla;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 修改或者新增人员管理信息PO
 *
 * @author wangh(wisea)
 *
 * @date 2018年6月7日
 * @version 1.0
 */
@ApiModel("修改或者新增人员管理信息PO")
public class SaveSubMembInfoPo {

	@ApiModelProperty(value="id(新增的时候为空，修改的时候必须填写)")
	private Long id;
	@ApiModelProperty(value="联系人",required=true)
	@Check(test="required")
	private String contName;
	@ApiModelProperty(value="职称",required=true)
	@Check(test="required")
	private String position;
	@ApiModelProperty(value="手机号",required=true)
	@Check(test="required")
	private String contTel;
	@ApiModelProperty(value="帐号状态(0:禁用1:启用)",required=true)
	@Check(test = {"required", "regex"}, requiredMsg = "帐号状态不能为空", regex = "^[0-1]$", regexMsg = "帐号状态(acctStatus)只能为0、1")
	private String acctStatus;
	@ApiModelProperty(value="登录用户名",required=true)
	@Check(test="required")
	private String loginName;
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
	 * @return the acctStatus
	 */
	public String getAcctStatus() {
		return acctStatus;
	}
	/**
	 * @param acctStatus the acctStatus to set
	 */
	public void setAcctStatus(String acctStatus) {
		this.acctStatus = acctStatus;
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
}
