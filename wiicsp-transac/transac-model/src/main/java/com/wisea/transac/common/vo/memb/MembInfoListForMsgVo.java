package com.wisea.transac.common.vo.memb;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

/**
 * 发送消息获取会员列表Vo
 *
 * @author wangh(wisea)
 *
 * @date 2020年7月16日
 * @version 1.0
 */
@ApiModel("发送消息获取会员列表Vo")
public class MembInfoListForMsgVo {

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String loginName;

    @ApiModelProperty(value = "注册手机号")
    private String registTel;

    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "注册时间")
    private OffsetDateTime registDate;

    @ApiModelProperty(value = "会员状态(0:正常1:冻结)")
    private String acctState;

    @ApiModelProperty(value = "企业认证状态类型(0:已认证1:未认证)")
    private String entpAuthStateType;

    @ApiModelProperty(value = "是否代理商标记(0:是1:否)")
    private String agentFlag;

    @ApiModelProperty(value = "企业名称")
    private String entpName;

    @ApiModelProperty(value = "会员类型(membType[0:企业1:个体户2:个人])")
    private String membType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getAcctState() {
		return acctState;
	}

	public void setAcctState(String acctState) {
		this.acctState = acctState;
	}

	public String getEntpAuthStateType() {
		return entpAuthStateType;
	}

	public void setEntpAuthStateType(String entpAuthStateType) {
		this.entpAuthStateType = entpAuthStateType;
	}

	public String getAgentFlag() {
		return agentFlag;
	}

	public void setAgentFlag(String agentFlag) {
		this.agentFlag = agentFlag;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getEntpName() {
		return entpName;
	}

	public void setEntpName(String entpName) {
		this.entpName = entpName;
	}

	public String getMembType() {
		return membType;
	}

	public void setMembType(String membType) {
		this.membType = membType;
	}
}
