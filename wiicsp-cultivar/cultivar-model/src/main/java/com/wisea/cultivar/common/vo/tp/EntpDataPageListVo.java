package com.wisea.cultivar.common.vo.tp;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModelProperty;

/**
 * EntpDataInfoListVo
 * 2018/09/18 14:36:47
 */
public class EntpDataPageListVo {

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "注册手机号")
    private String registTel;

    @ApiModelProperty(value = "申请认证时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime updateDate;

    @ApiModelProperty(value = "企业名称")
    private String compName;

    @ApiModelProperty(value = "认证审核状态(0:待审核1:审核通过2:驳回)")
    private String authExamState;

    @ApiModelProperty(value = "会员ID")
    private String membId;

    @ApiModelProperty(value = "会员类型(member_type[0:个人1:企业])")
    private String memberType;

    @ApiModelProperty(value = "企业类型（comp_type0:采购商认证1:供应商认证）")
	private String compType;


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRegistTel() {
		return registTel;
	}
	public void setRegistTel(String registTel) {
		this.registTel = registTel;
	}
	public OffsetDateTime getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(OffsetDateTime updateDate) {
		this.updateDate = updateDate;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public String getAuthExamState() {
		return authExamState;
	}
	public void setAuthExamState(String authExamState) {
		this.authExamState = authExamState;
	}
	public String getMembId() {
		return membId;
	}
	public void setMembId(String membId) {
		this.membId = membId;
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
