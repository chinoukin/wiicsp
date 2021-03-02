package com.wisea.cultivar.common.po.tp;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cultivar.common.vo.tp.SendMessageListVo;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;

import io.swagger.annotations.ApiModelProperty;

/**
 * SendMessagePagePo
 * 2018/10/20 15:06:50
 */
public class SendMessagePagePo extends PagePo<SendMessageListVo> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "发送标题")
    private String title;
    @ApiModelProperty(value = "发送范围(0:全部会员 1:个人会员 2:企业会员 3:代理商会员 4:指定会员)")
    private String scope;
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "发送开始时间")
    private OffsetDateTime startDate;
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "发送开始时间")
    private OffsetDateTime endDate;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public OffsetDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(OffsetDateTime startDate) {
		this.startDate = startDate;
	}
	public OffsetDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(OffsetDateTime endDate) {
		this.endDate = endDate;
	}

}
