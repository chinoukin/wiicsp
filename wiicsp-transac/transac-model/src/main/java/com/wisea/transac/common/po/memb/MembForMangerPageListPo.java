package com.wisea.transac.common.po.memb;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.memb.MembForManagerListVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 运营平台/市场运营供应商认证管理分页列表PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月20日
 * @version 1.0
 */
@ApiModel("运营平台/市场运营供应商认证管理分页列表PO")
public class MembForMangerPageListPo extends PagePo<MembForManagerListVo>{

	private static final long serialVersionUID = -6789079952558013657L;

	@ApiModelProperty(value = "市场ID(查询全部市场为空)")
	private Long marketId;

	@ApiModelProperty(value = "用户名/注册手机号/企业名称")
	private String key;

	@ApiModelProperty(value="账户状态(acct_state 0:正常1:冻结)")
	private String acctState;

	@ApiModelProperty(value="企业类型(0:企业1:个体户)")
	private String custType;

	@ApiModelProperty(value="报备状态(rp_state_type 0:待报备1:报备中2:已报备)")
	private String rpStateType;

	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value="认证申请开始时间")
	private OffsetDateTime authStartDate;

	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value="认证申请结束时间")
	private OffsetDateTime authEndDate;

	@ApiModelProperty(value="是否产地会员类型(0:是产地会员 0以外的情况非产地会员)默认是非产地会员")
	private String localityMembType = "1";

	@ApiModelProperty(value="审核状态(auth_state_type 0:待平台审核1:待银盛开户2:实名认证中3:审核通过4:审核未通过)")
	private String authStateType;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getAcctState() {
		return acctState;
	}

	public void setAcctState(String acctState) {
		this.acctState = acctState;
	}

	public OffsetDateTime getAuthStartDate() {
		return authStartDate;
	}

	public void setAuthStartDate(OffsetDateTime authStartDate) {
		this.authStartDate = authStartDate;
	}

	public OffsetDateTime getAuthEndDate() {
		return authEndDate;
	}

	public void setAuthEndDate(OffsetDateTime authEndDate) {
		this.authEndDate = authEndDate;
	}

	public Long getMarketId() {
		return marketId;
	}

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public String getRpStateType() {
		return rpStateType;
	}

	public void setRpStateType(String rpStateType) {
		this.rpStateType = rpStateType;
	}

	public String getLocalityMembType() {
		return localityMembType;
	}

	public void setLocalityMembType(String localityMembType) {
		this.localityMembType = localityMembType;
	}

	public String getAuthStateType() {
		return authStateType;
	}

	public void setAuthStateType(String authStateType) {
		this.authStateType = authStateType;
	}
}
