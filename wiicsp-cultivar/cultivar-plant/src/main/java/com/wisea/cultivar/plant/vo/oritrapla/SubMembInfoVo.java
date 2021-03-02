package com.wisea.cultivar.plant.vo.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.annotation.LongSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 人员管理列表信息VO
 *
 * @author wangh(wisea)
 *
 * @date 2018年6月6日
 * @version 1.0
 */
@ApiModel("人员管理列表信息VO")
public class SubMembInfoVo{

	@ApiModelProperty("ID")
	@JsonSerialize(using= LongSerializer.class)
	private Long id;
	@ApiModelProperty("姓名")
	private String contName;
	@ApiModelProperty("用户名")
	private String loginName;
	@ApiModelProperty("职称")
	private String position;
	@ApiModelProperty("手机号")
	private String contTel;
	@ApiModelProperty("账号状态[acct_status(0:禁用1:启用)]")
	private String acctStatus;

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

}
