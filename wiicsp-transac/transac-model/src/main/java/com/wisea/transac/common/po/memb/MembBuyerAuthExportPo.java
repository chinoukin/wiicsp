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
 * 采购商认证管理导出处理PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年6月19日
 * @version 1.0
 */
@ApiModel("采购商认证管理导出处理PO")
public class MembBuyerAuthExportPo {

	@ApiModelProperty(value = "用户名/注册手机号/企业名称")
	private String key;

	@ApiModelProperty(value="会员类型(0:企业1:个体户2:个人;为空是全部)")
	private String membType;

	@ApiModelProperty(value="审核状态(0:已认证(审核通过)2:待审核3:审核未通过;为空是全部)")
	private String entpAuthStateType;

	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value="认证申请开始时间")
	private OffsetDateTime authStartDate;

	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value="认证申请结束时间")
	private OffsetDateTime authEndDate;

	@ApiModelProperty(value="会员id列表(如果为空则按照条件,如果不是空则按照id列表查询)")
	private List<String> idList;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<String> getIdList() {
		return idList;
	}

	public void setIdList(List<String> idList) {
		this.idList = idList;
	}

	public String getMembType() {
		return membType;
	}

	public void setMembType(String membType) {
		this.membType = membType;
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

	public String getEntpAuthStateType() {
		return entpAuthStateType;
	}

	public void setEntpAuthStateType(String entpAuthStateType) {
		this.entpAuthStateType = entpAuthStateType;
	}


}
