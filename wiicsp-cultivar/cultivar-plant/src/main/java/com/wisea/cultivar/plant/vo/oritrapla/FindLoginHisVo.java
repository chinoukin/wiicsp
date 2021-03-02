package com.wisea.cultivar.plant.vo.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.annotation.LongSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTime2LongStrSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * 查询历史上线记录VO
 *
 * @author wangh(wisea)
 *
 * @date 2018年6月20日
 * @version 1.0
 */
@ApiModel("查询历史上线记录VO")
public class FindLoginHisVo {

	@ApiModelProperty("ID")
	@JsonSerialize(using= LongSerializer.class)
	private Long id;
	@ApiModelProperty("用户名")
	private String loginName;
	@ApiModelProperty("姓名")
	private String contName;
	@ApiModelProperty("用户类型([acct_type]0:主账号1:子账号2:管理账号)")
	private String acctType;
	@ApiModelProperty("主体名称")
	private String orgName;
	@JsonSerialize(using = OffsetDateTime2LongStrSerializer.class)
	private OffsetDateTime loginDate;
	@ApiModelProperty("登录IP")
	private String loginIp;
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
	 * @return the acctType
	 */
	public String getAcctType() {
		return acctType;
	}
	/**
	 * @param acctType the acctType to set
	 */
	public void setAcctType(String acctType) {
		this.acctType = acctType;
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
	 * @return the loginDate
	 */
	public OffsetDateTime getLoginDate() {
		return loginDate;
	}
	/**
	 * @param loginDate the loginDate to set
	 */
	public void setLoginDate(OffsetDateTime loginDate) {
		this.loginDate = loginDate;
	}
	/**
	 * @return the loginIp
	 */
	public String getLoginIp() {
		return loginIp;
	}
	/**
	 * @param loginIp the loginIp to set
	 */
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
}
