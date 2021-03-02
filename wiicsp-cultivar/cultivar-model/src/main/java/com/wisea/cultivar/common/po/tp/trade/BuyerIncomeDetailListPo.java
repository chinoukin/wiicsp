package com.wisea.cultivar.common.po.tp.trade;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.tp.trade.BuyerIncomeDetailListVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * OrderInfoListPo
 *
 */
@ApiModel("收入明细列表列表po")
public class BuyerIncomeDetailListPo extends PagePo<BuyerIncomeDetailListVo>{

    @ApiModelProperty(value = "查询条件（流水号/账单编号/订单编号）")
    private String searchKey;
    @ApiModelProperty(value = "日期查询条件(近一周传0，一个月之前传1，三个月传2,今天传3)")
    private String timeKey;
    @ApiModelProperty(value = "开始时间")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime timeStart;
    @ApiModelProperty(value = "结束时间")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime timeEnd;
    @ApiModelProperty(value = "会员id", hidden=true)
    private Long membId;
    @ApiModelProperty(value = "会员查询条件(后台查询传1，其他传0)")
    private String admOrUserKey;

	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
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
	public Long getMembId() {
		return membId;
	}
	public void setMembId(Long membId) {
		this.membId = membId;
	}
	public String getAdmOrUserKey() {
		return admOrUserKey;
	}
	public void setAdmOrUserKey(String admOrUserKey) {
		this.admOrUserKey = admOrUserKey;
	}
}
