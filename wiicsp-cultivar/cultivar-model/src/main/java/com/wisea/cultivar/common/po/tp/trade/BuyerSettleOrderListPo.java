package com.wisea.cultivar.common.po.tp.trade;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.tp.trade.BuyerOrderInfoListVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel("账期详情订单列表po")
public class BuyerSettleOrderListPo extends PagePo<BuyerOrderInfoListVo> {

	@ApiModelProperty(value = "账期ID")
	private Long settleId;

	@ApiModelProperty(value = "订单ID")
	private Long ordId;

	@ApiModelProperty("输入框查询条件")
    private String searchKey;

	@ApiModelProperty("订单类型，普通订单是0，长协订单是1")
	@Check(test = "required")
    private String ordType;

	@ApiModelProperty("下单日期开始")
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime startTime;

	@ApiModelProperty("下单日期结束")
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime endTime;

	public Long getSettleId() {
		return settleId;
	}

	public void setSettleId(Long settleId) {
		this.settleId = settleId;
	}

	public String getOrdType() {
		return ordType;
	}

	public void setOrdType(String ordType) {
		this.ordType = ordType;
	}

	public Long getOrdId() {
		return ordId;
	}

	public void setOrdId(Long ordId) {
		this.ordId = ordId;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public OffsetDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(OffsetDateTime startTime) {
		this.startTime = startTime;
	}

	public OffsetDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(OffsetDateTime endTime) {
		this.endTime = endTime;
	}


}
