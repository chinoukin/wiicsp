package com.wisea.transac.common.vo.memb;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户注册信息详情VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年4月23日
 * @version 1.0
 */
@ApiModel("用户注册信息详情VO")
public class UserRegisterInfoVo {

	@ApiModelProperty(value="用户ID")
	private Long id;

    @ApiModelProperty(value = "用户名")
    private String loginName;

    @ApiModelProperty(value = "注册手机号")
    private String registTel;

    @ApiModelProperty(value = "联系人姓名")
    private String  contName;

    @ApiModelProperty(value = "会员类型(memb_type 0:企业1:个体户2：个人)")
    private String membType;

    @ApiModelProperty(value = "注册时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private  OffsetDateTime registDate;

    @ApiModelProperty(value = "是否商家(0:是1:否)")
    private String agentFlag;

    @ApiModelProperty(value = "账户状态(acct_state 0:正常1:冻结)")
    private String acctState;

    @ApiModelProperty(value = "商户编号")
    private String merchantNo;

    @ApiModelProperty(value = "认证状态(0:已认证1:未认证)")
    private String entpAuthStateType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getContName() {
		return contName;
	}

	public void setContName(String contName) {
		this.contName = contName;
	}

	public String getMembType() {
		return membType;
	}

	public void setMembType(String membType) {
		this.membType = membType;
	}

	public OffsetDateTime getRegistDate() {
		return registDate;
	}

	public void setRegistDate(OffsetDateTime registDate) {
		this.registDate = registDate;
	}

	public String getAgentFlag() {
		return agentFlag;
	}

	public void setAgentFlag(String agentFlag) {
		this.agentFlag = agentFlag;
	}

	public String getAcctState() {
		return acctState;
	}

	public void setAcctState(String acctState) {
		this.acctState = acctState;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getEntpAuthStateType() {
		return entpAuthStateType;
	}

	public void setEntpAuthStateType(String entpAuthStateType) {
		this.entpAuthStateType = entpAuthStateType;
	}
}
