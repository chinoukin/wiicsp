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
 * 运营平台采购商会员管理分页列表查询PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月20日
 * @version 1.0
 */
@ApiModel("运营平台采购商会员管理分页列表查询PO")
public class MembForBuyerPageListPo extends PagePo<MembForManagerListVo>{

	private static final long serialVersionUID = -8131158386150160329L;

	@ApiModelProperty(value = "用户名/注册手机号/企业名称")
	private String key;

	@ApiModelProperty(value="账户状态(acct_state 0:正常1:冻结)")
	private String acctState;

	@ApiModelProperty(value="会员类型(0:企业1:个体户2:个人;为空是全部)")
	private String membType;

	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value="注册开始时间")
	private OffsetDateTime registStartDate;

	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value="注册结束时间")
	private OffsetDateTime registEndDate;

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

	public String getMembType() {
		return membType;
	}

	public void setMembType(String membType) {
		this.membType = membType;
	}
}
