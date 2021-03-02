package com.wisea.cultivar.common.vo.memb;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

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
    @ApiModelProperty(value="企业id")
	private Long entpId;

	@ApiModelProperty(value="用户名")
	private String loginName;

	@ApiModelProperty(value="注册手机号")
	private String registTel;

	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value="注册时间")
	private OffsetDateTime registDate;

	@ApiModelProperty(value="企业名称")
	private String entpName;

    @ApiModelProperty(value="账户状态(acct_state 0:正常1:禁用)")
    private String acctState;

    @ApiModelProperty(value="账户状态值(acct_state 0:正常1:禁用)")
    private String acctStateValue;

	@ApiModelProperty(value="认证状态(entp_auth_state_type 0:已认证1:未认证 )")
	private String entpAuthStateType;

    @ApiModelProperty(value="认证状态值(entp_auth_state_type 0:已认证1:未认证 )")
	private String entpAuthStateTypeValue;

    @ApiModelProperty(value="审核状态(auth_state_type 0:审核通过1:审核未通过2:待审核 )")
    private String authStateType;
    @ApiModelProperty(value="审核状态值(auth_state_type_value 0:审核通过1:审核未通过2:待审核 )")
	private String authStateTypeValue;

    @ApiModelProperty(value = "认证类型(auth_type 0:企业1:个人)")
    private String authType;
    @ApiModelProperty(value = "认证类型(auth_type 0:企业1:个人)")
    private String authTypeValue;

    @ApiModelProperty(value = "会员类型(memb_type 0:服务商1:会员)")
    private String membType;

    public String getAuthTypeValue() {
        return authTypeValue;
    }

    public void setAuthTypeValue(String authTypeValue) {
        this.authTypeValue = authTypeValue;
    }

    public String getMembType() {
        return membType;
    }

    public void setMembType(String membType) {
        this.membType = membType;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public String getAuthStateType() {
        return authStateType;
    }

    public void setAuthStateType(String authStateType) {
        this.authStateType = authStateType;
    }

    public String getAuthStateTypeValue() {
        return authStateTypeValue;
    }

    public void setAuthStateTypeValue(String authStateTypeValue) {
        this.authStateTypeValue = authStateTypeValue;
    }

    public String getAcctStateValue() {
        return acctStateValue;
    }

    public void setAcctStateValue(String acctStateValue) {
        this.acctStateValue = acctStateValue;
    }

    public String getEntpAuthStateTypeValue() {
        return entpAuthStateTypeValue;
    }

    public void setEntpAuthStateTypeValue(String entpAuthStateTypeValue) {
        this.entpAuthStateTypeValue = entpAuthStateTypeValue;
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

    public OffsetDateTime getRegistDate() {
        return registDate;
    }

    public void setRegistDate(OffsetDateTime registDate) {
        this.registDate = registDate;
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

    public String getEntpAuthStateType() {
        return entpAuthStateType;
    }

    public Long getEntpId() {
        return entpId;
    }

    public void setEntpId(Long entpId) {
        this.entpId = entpId;
    }

    public void setEntpAuthStateType(String entpAuthStateType) {
        this.entpAuthStateType = entpAuthStateType;
    }
}
