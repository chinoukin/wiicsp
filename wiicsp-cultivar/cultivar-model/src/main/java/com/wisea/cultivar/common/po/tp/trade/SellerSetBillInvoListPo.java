package com.wisea.cultivar.common.po.tp.trade;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.tp.trade.SellerSetBillInvoListVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author yangtao
 * @Description 分页查询结算单发票PO
 **/
@ApiModel("分页查询结算单发票PO")
public class SellerSetBillInvoListPo extends PagePo<SellerSetBillInvoListVo> {
    @ApiModelProperty(value = "输入框值")
    private String query;
    @ApiModelProperty("发票类型")
    private String invoType;
    @ApiModelProperty("账单周期开始日期")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime startDate;
    @ApiModelProperty("账单周期结束日期")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime endDate;
    @ApiModelProperty(value = "卖家id", hidden = true)
    private Long sellerId;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getInvoType() {
		return invoType;
	}

	public void setInvoType(String invoType) {
		this.invoType = invoType;
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

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
}
