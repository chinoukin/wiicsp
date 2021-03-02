package com.wisea.cultivar.common.po.tp.statistics;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.tp.statistics.BuyerTopNumVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户排行po
 * @author yangtao
 *
 */
@ApiModel("用户排行po")
public class BuyerTopNumPo extends PagePo<BuyerTopNumVo>{

	@ApiModelProperty("查询日期标识，0：最近7天；1：最近30天；2：最近90天；5：全部。注意：该字段和开始/结束时间互斥")
    @Check(test = "logic", logic = "(#isNotEmpty(#timeStart) || #isNotEmpty(#timeEnd))?#isEmpty(#timeKey):true", logicMsg = "开始时间和结束时间不为空，近几天需要为空")
	private String timeKey;
	@ApiModelProperty(value = "开始时间")
	@Check(test = "logic", logic = "#isNotEmpty(#timeKey) ? #isEmpty(#timeStart) : true", logicMsg = "近几天不为空，开始时间和结束时间需要为空")
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime timeStart;
    @ApiModelProperty(value = "结束时间")
    @Check(test = "logic", logic = "#isNotEmpty(#timeKey) ? #isEmpty(#timeEnd) : true", logicMsg = "近几天不为空，开始时间和结束时间需要为空")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime timeEnd;
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "卖方ID", hidden = true)
    private Long sellerId;

	public String getTimeKey() {
		return timeKey;
	}
	public void setTimeKey(String timeKey) {
		this.timeKey = timeKey;
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
	public Long getSellerId() {
		return sellerId;
	}
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
}
