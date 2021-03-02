package com.wisea.transac.common.vo.memb;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 运营平台/市场运营 会员列表VO
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月20日
 * @version 1.0
 */
@ApiModel("运营平台/市场运营 会员列表VO")
public class MembForManagerListVo {

	@ApiModelProperty(value="会员id")
	private Long membId;

	@ApiModelProperty(value="关联ID(企业ID/个体户ID/个人认证ID)")
	private Long relId;

	@ApiModelProperty(value="会员类型/企业类型(memb_type 0:企业1:个体户2:个人)")
	private String membType;

	@ApiModelProperty(value="用户名")
	private String loginName;

	@ApiModelProperty(value="注册手机号")
	private String registTel;

	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value="注册时间")
	private OffsetDateTime registDate;

	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value="认证时间")
	private OffsetDateTime authDate;

	@ApiModelProperty(value="企业名称")
	private String entpName;

	@ApiModelProperty(value="账户状态(acct_state 0:正常1:冻结)")
	private String acctState;

	@ApiModelProperty(value="报备状态(rp_state_type 0:待报备1:报备中2:已报备)")
	private String rpStateType;

	@ApiModelProperty(value="审核状态(auth_state_type 0:待平台审核1:待银盛开户2:实名认证中3:审核通过4:审核未通过)")
	private String authStateType;

	@ApiModelProperty(value="认证状态(entp_auth_state_type 0:已认证1:未认证 )")
	private String entpAuthStateType;

	public Long getRelId() {
		return relId;
	}
	public void setRelId(Long relId) {
		this.relId = relId;
	}
	public String getMembType() {
		return membType;
	}
	public void setMembType(String membType) {
		this.membType = membType;
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
	public OffsetDateTime getRegistDate() {
		return registDate;
	}
	public void setRegistDate(OffsetDateTime registDate) {
		this.registDate = registDate;
	}
	public OffsetDateTime getAuthDate() {
		return authDate;
	}
	public void setAuthDate(OffsetDateTime authDate) {
		this.authDate = authDate;
	}
	public String getEntpName() {
		return entpName;
	}
	public void setEntpName(String entpName) {
		this.entpName = entpName;
	}
	public String getAcctState() {
		return acctState;
	}
	public void setAcctState(String acctState) {
		this.acctState = acctState;
	}
	public String getAuthStateType() {
		return authStateType;
	}
	public void setAuthStateType(String authStateType) {
		this.authStateType = authStateType;
	}
	public Long getMembId() {
		return membId;
	}
	public void setMembId(Long membId) {
		this.membId = membId;
	}
	public String getEntpAuthStateType() {
		return entpAuthStateType;
	}
	public void setEntpAuthStateType(String entpAuthStateType) {
		this.entpAuthStateType = entpAuthStateType;
	}
	public String getRpStateType() {
		return rpStateType;
	}
	public void setRpStateType(String rpStateType) {
		this.rpStateType = rpStateType;
	}
}
