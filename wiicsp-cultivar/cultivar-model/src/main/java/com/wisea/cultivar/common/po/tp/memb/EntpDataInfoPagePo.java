package com.wisea.cultivar.common.po.tp.memb;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cultivar.common.vo.tp.EntpDataPageListVo;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;

import io.swagger.annotations.ApiModelProperty;

/**
 * EntpDataInfoPagePo
 * 2018/09/18 14:36:47
 */
public class EntpDataInfoPagePo extends PagePo<EntpDataPageListVo> {
    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "用户名/注册手机号/企业名称")
    private String key;

    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "申请日期开始时间")
    private OffsetDateTime updateDateStart;

    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "申请日期结束时间")
    private OffsetDateTime updateDateEnd;

    @ApiModelProperty(value = "认证审核状态(空为全部,0:待审核1:审核通过2:驳回3:审核中)")
    private String authExamState;

    @ApiModelProperty(value="会员类型member_type0:个人1:企业")
    private String memberType;

    @ApiModelProperty(value = "企业类型（comp_type0:采购商认证1:供应商认证）")
	private String compType;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public OffsetDateTime getUpdateDateStart() {
		return updateDateStart;
	}

	public void setUpdateDateStart(OffsetDateTime updateDateStart) {
		this.updateDateStart = updateDateStart;
	}

	public OffsetDateTime getUpdateDateEnd() {
		return updateDateEnd;
	}

	public void setUpdateDateEnd(OffsetDateTime updateDateEnd) {
		this.updateDateEnd = updateDateEnd;
	}

	public String getAuthExamState() {
		return authExamState;
	}

	public void setAuthExamState(String authExamState) {
		this.authExamState = authExamState;
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
