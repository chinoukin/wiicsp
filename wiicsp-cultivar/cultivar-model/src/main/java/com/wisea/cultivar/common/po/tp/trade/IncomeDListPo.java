package com.wisea.cultivar.common.po.tp.trade;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.tp.trade.IncomeDListVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 支付明细Po
 * @author yangtao
 *
 */
@ApiModel("支付明细Po")
public class IncomeDListPo extends PagePo<IncomeDListVo>{

    @ApiModelProperty(value = "查询key")
    private String searchKey;
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "开始时间")
    private OffsetDateTime timeStart;
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "结束时间")
    private OffsetDateTime timeEnd;
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "用户ID", hidden = true)
    private Long membId;

	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public OffsetDateTime getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(OffsetDateTime timeStart) {
		this.timeStart = timeStart;
	}
	public OffsetDateTime getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(OffsetDateTime timeEnd) {
		this.timeEnd = timeEnd;
	}
	public Long getMembId() {
		return membId;
	}
	public void setMembId(Long membId) {
		this.membId = membId;
	}
}
