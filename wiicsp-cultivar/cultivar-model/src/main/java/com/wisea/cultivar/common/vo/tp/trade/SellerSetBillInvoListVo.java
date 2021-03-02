package com.wisea.cultivar.common.vo.tp.trade;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.util.excel.annotation.ExcelField;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * @author yangtao
 *
 */
@ApiModel("卖家查询账期发票列表vo")
public class SellerSetBillInvoListVo {
	@ApiModelProperty(value = "发票id")
    private Long id;
    @ApiModelProperty(value = "申请编号")
	@ExcelField(title = "申请编号", sort = 0, width = 20)
    private String applNum;
	@ApiModelProperty(value = "开票日期")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@ExcelField(title = "开票日期", sort = 1, width = 20)
	private OffsetDateTime drawDate;
    @ApiModelProperty(value = "账单编号")
	@ExcelField(title = "账单编号", sort = 2, width = 20)
    private String settleBillNumb;
    @ApiModelProperty(value = "采购商账号")
	@ExcelField(title = "采购商账号", sort = 3, width = 20)
    private String buyerUserName;
    @ApiModelProperty(value = "结算周期开始时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
	@ExcelField(title = "结算周期开始时间", sort = 4, width = 20)
    private OffsetDateTime settleCycleStartDate;
    @ApiModelProperty(value = "结算周期结束时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
	@ExcelField(title = "结算周期结束时间", sort = 5, width = 20)
    private OffsetDateTime settleCycleEndDate;
    @ApiModelProperty(value = "开票金额")
	@ExcelField(title = "开票金额", sort = 6, width = 20)
    private Double drawAmount;
    @ApiModelProperty(value = "发票类型")
	@ExcelField(title = "发票类型", sort = 7, width = 20)
    private String invoType;
    @ApiModelProperty(value = "发票抬头")
	@ExcelField(title = "发票抬头", sort = 8, width = 20)
    private String invoTitle;
	@ApiModelProperty("发票状态")
	@ExcelField(title = "发票状态", sort = 9, width = 20)
    private String invoState;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSettleBillNumb() {
		return settleBillNumb;
	}

	public void setSettleBillNumb(String settleBillNumb) {
		this.settleBillNumb = settleBillNumb;
	}

	public String getBuyerUserName() {
		return buyerUserName;
	}

	public void setBuyerUserName(String buyerUserName) {
		this.buyerUserName = buyerUserName;
	}

	public String getApplNum() {
		return applNum;
	}

	public void setApplNum(String applNum) {
		this.applNum = applNum;
	}

	public OffsetDateTime getSettleCycleStartDate() {
		return settleCycleStartDate;
	}

	public void setSettleCycleStartDate(OffsetDateTime settleCycleStartDate) {
		this.settleCycleStartDate = settleCycleStartDate;
	}

	public OffsetDateTime getSettleCycleEndDate() {
		return settleCycleEndDate;
	}

	public void setSettleCycleEndDate(OffsetDateTime settleCycleEndDate) {
		this.settleCycleEndDate = settleCycleEndDate;
	}

	public Double getDrawAmount() {
		return drawAmount;
	}

	public void setDrawAmount(Double drawAmount) {
		this.drawAmount = drawAmount;
	}

	public String getInvoType() {
		return invoType;
	}

	public void setInvoType(String invoType) {
		this.invoType = invoType;
	}

	public String getInvoTitle() {
		return invoTitle;
	}

	public void setInvoTitle(String invoTitle) {
		this.invoTitle = invoTitle;
	}

	public OffsetDateTime getDrawDate() {
		return drawDate;
	}

	public void setDrawDate(OffsetDateTime drawDate) {
		this.drawDate = drawDate;
	}

	public String getInvoState() {
		return invoState;
	}

	public void setInvoState(String invoState) {
		this.invoState = invoState;
	}
}
