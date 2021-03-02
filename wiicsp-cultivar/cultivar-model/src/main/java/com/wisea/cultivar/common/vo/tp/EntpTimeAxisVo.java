package com.wisea.cultivar.common.vo.tp;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 商户认证时间轴信息
 *
 * @author wangh(wisea)
 *
 * @date 2018年10月9日
 * @version 1.0
 */
@ApiModel("商户认证时间轴信息VO")
public class EntpTimeAxisVo {

	@ApiModelProperty(value = "会员类型(0：个人1:企业)")
	private String memberType;//会员类型(0：个人1:企业)

	@ApiModelProperty(value="企业类型(comp_type0:采购商认证1:供货商认证)")
	private String compType;

	@ApiModelProperty("0:注册企业账号1:商家认证通过2:商家认证(驳回)3:审核通过成为商家")
    private String authExamState;

	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty("注册成为平台会员的时间")
	private OffsetDateTime registerDate;

	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty("商家信息完善时间")
	private OffsetDateTime submitDate;

	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty("商家认证审核时间")
	private OffsetDateTime authDate;

	@ApiModelProperty("驳回内容")
	private String authContents;

	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty("审核通过成为商家")
	private OffsetDateTime authSucssDate;

	public String getAuthExamState() {
		return authExamState;
	}
	public void setAuthExamState(String authExamState) {
		this.authExamState = authExamState;
	}
	public OffsetDateTime getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(OffsetDateTime registerDate) {
		this.registerDate = registerDate;
	}
	public OffsetDateTime getSubmitDate() {
		return submitDate;
	}
	public void setSubmitDate(OffsetDateTime submitDate) {
		this.submitDate = submitDate;
	}
	public OffsetDateTime getAuthDate() {
		return authDate;
	}
	public void setAuthDate(OffsetDateTime authDate) {
		this.authDate = authDate;
	}
	public String getAuthContents() {
		return authContents;
	}
	public void setAuthContents(String authContents) {
		this.authContents = authContents;
	}
	public OffsetDateTime getAuthSucssDate() {
		return authSucssDate;
	}
	public void setAuthSucssDate(OffsetDateTime authSucssDate) {
		this.authSucssDate = authSucssDate;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	public String getCompType() {
		return compType;
	}
	public void setCompType(String compType) {
		this.compType = compType;
	}
}
