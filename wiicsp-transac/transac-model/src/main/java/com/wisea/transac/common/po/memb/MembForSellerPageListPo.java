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
 * 运营平台/市场运营 供应商会员管理分页列表PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月20日
 * @version 1.0
 */
@ApiModel("运营平台/市场运营 供应商会员管理分页列表PO")
public class MembForSellerPageListPo extends PagePo<MembForManagerListVo>{

	private static final long serialVersionUID = -6789079952558013657L;

	@ApiModelProperty(value = "市场ID(查询全部市场为空)")
	private Long marketId;

	@ApiModelProperty(value = "用户名/注册手机号/企业名称")
	private String key;

	@ApiModelProperty(value="账户状态(acct_state 0:正常1:冻结)")
	private String acctState;

	@ApiModelProperty(value="会员类型(0:企业1:个体户2)为空为所有")
	private String custType;

	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value="注册开始时间")
	private OffsetDateTime registStartDate;

	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value="注册结束时间")
	private OffsetDateTime registEndDate;

	@ApiModelProperty(value="是否产地会员类型(0:是产地会员 0以外的情况非产地会员)默认是非产地会员")
	private String localityMembType = "1";

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

	public OffsetDateTime getRegistStartDate() {
		return registStartDate;
	}

	public void setRegistStartDate(OffsetDateTime registStartDate) {
		this.registStartDate = registStartDate;
	}

	public OffsetDateTime getRegistEndDate() {
		return registEndDate;
	}

	public void setRegistEndDate(OffsetDateTime registEndDate) {
		this.registEndDate = registEndDate;
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

	public String getLocalityMembType() {
		return localityMembType;
	}

	public void setLocalityMembType(String localityMembType) {
		this.localityMembType = localityMembType;
	}
}
