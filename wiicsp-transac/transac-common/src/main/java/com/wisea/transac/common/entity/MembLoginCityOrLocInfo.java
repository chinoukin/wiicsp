package com.wisea.transac.common.entity;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModelProperty;

/**
 * 会员登录商家端验证会员信息
 *
 * @author wangh(wisea)
 *
 * @date 2018年10月10日
 * @version 1.0
 */
public class MembLoginCityOrLocInfo implements Serializable{


    /**
	 *
	 */
	private static final long serialVersionUID = 5496215684306621234L;

	/** ------会员基本信息   开始-------------------------- **/
	@ApiModelProperty(value="用户ID(如果是子账户为子账户ID会员为会员ID)")
    @JsonSerialize(using = IdSerializer.class)
	private Long id;//用户id（子账户或者会员ID）

	@ApiModelProperty(value="会员ID(如果是采购员或者销售员显示父节点会员ID)")
    @JsonSerialize(using = IdSerializer.class)
	private Long membId;// 会员ID

	@ApiModelProperty(value="用户名(当前ID的登录用户名)")
    private String loginName;

	@ApiModelProperty(value="注册手机号")
    private String registTel;

	@ApiModelProperty(value="会员类型(0:企业1:个体户2:个人)")
	private String membType;

	@ApiModelProperty(value="会员的状态(acct_state0:正常1:冻结)")
    private String acctState;

	@ApiModelProperty(value="会员区分(0:普通会员1:采购员2:销售员3:即使销售员又是采购员)")
	private String membClass;

	@ApiModelProperty(value="是否商家(agent_flag 0:是1:否)如果有父节点显示父节点的状态, 如果没有显示本身的状态")
	private String agentFlag;

	@ApiModelProperty(value="采购员ID(采购员工管理的ID和用户会员ID无关)")
	private String purId;

	@ApiModelProperty(value="销售员ID(销售员工信息管理的ID和用户会员ID无关)")
	private String saleId;

	@ApiModelProperty(value="审核状态区分[如果有父节点 显示父节点信息](0:企业认证1:个体户认证2:个人实名认证3:无认证)优先级顺序：企业>个体>个人")
	private String authType;

	@ApiModelProperty("是否产地会员类型(0:是产地会员0以外的非产地会员)(如果是销售员返回父节点的信息)")
	private String localityMembType;

	@ApiModelProperty(value="销售端启用停用状态(effe_inval_state 0:启用1:停用)")
    private String effeInvalState;

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

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getRegistTel() {
		return registTel;
	}

	public void setRegistTel(String registTel) {
		this.registTel = registTel;
	}

	public String getMembType() {
		return membType;
	}

	public void setMembType(String membType) {
		this.membType = membType;
	}

	public String getAcctState() {
		return acctState;
	}

	public void setAcctState(String acctState) {
		this.acctState = acctState;
	}

	public String getMembClass() {
		return membClass;
	}

	public void setMembClass(String membClass) {
		this.membClass = membClass;
	}

	public String getAgentFlag() {
		return agentFlag;
	}

	public void setAgentFlag(String agentFlag) {
		this.agentFlag = agentFlag;
	}

	public String getPurId() {
		return purId;
	}

	public void setPurId(String purId) {
		this.purId = purId;
	}

	public String getSaleId() {
		return saleId;
	}

	public void setSaleId(String saleId) {
		this.saleId = saleId;
	}

	public String getAuthType() {
		return authType;
	}

	public void setAuthType(String authType) {
		this.authType = authType;
	}

	public String getLocalityMembType() {
		return localityMembType;
	}

	public void setLocalityMembType(String localityMembType) {
		this.localityMembType = localityMembType;
	}

	public String getEffeInvalState() {
		return effeInvalState;
	}

	public void setEffeInvalState(String effeInvalState) {
		this.effeInvalState = effeInvalState;
	}
}
