package com.wisea.transac.common.po.memb;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 采购商会员管理导出处理PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年6月19日
 * @version 1.0
 */
@ApiModel("采购商会员管理导出处理PO")
public class MembSellerExportPo {

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

	@ApiModelProperty(value="会员id列表(如果为空则按照条件,如果不是空则按照id列表查询)")
	private List<String> idList;

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

	public List<String> getIdList() {
		return idList;
	}

	public void setIdList(List<String> idList) {
		this.idList = idList;
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
