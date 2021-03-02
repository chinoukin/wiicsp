package com.wisea.cultivar.common.vo.tp.trade;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.util.excel.annotation.ExcelField;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModelProperty;

/**
 * 支付明细导出Excel(转换用)
 *
 * @author yantao
 *
 *
 */
public class BuyerIncomeDListExportExcelVo {

	@ApiModelProperty("id")
	@JsonSerialize(using = IdSerializer.class)
    private Long id;

	@ApiModelProperty("会员id")
	@JsonSerialize(using = IdSerializer.class)
    private Long membId;

	@ApiModelProperty("会员账号")
    private String membNo;

	@ExcelField(title = "采购商账号", sort = 3, width = 20)
	@ApiModelProperty("买家账号")
    private String buyerName;

	@ApiModelProperty("订单id")
	@JsonSerialize(using = IdSerializer.class)
    private Long orderId;

	@ApiModelProperty("交易流水号")
	@ExcelField(title = "流水号", sort = 0, width = 20)
    private String tradeNo;

	@ApiModelProperty("订单编号")
	@ExcelField(title = "订单编号", sort = 2, width = 20)
    private String ordNum;

	@ApiModelProperty("完成时间")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@ExcelField(title = "到账时间", sort = 4, width = 20)
    private OffsetDateTime finishDate;

	@ApiModelProperty("订单总金额")
	@ExcelField(title = "订单总金额", sort = 5, width = 20)
    private Double commTotalPrice;

	@ApiModelProperty("分账收入")
	@ExcelField(title = "实际收入", sort = 6, width = 20)
    private Double splitIncome;

	@ApiModelProperty("账单编号")
	@ExcelField(title = "账单编号", sort = 1, width = 20)
    private String settleBillNumb;

	@ApiModelProperty("订单运费")
    private Double ordFreight;

	@ApiModelProperty("退货退款金额")
	@ExcelField(title = "退货退款金额", sort = 7, width = 20)
    private Double refundPrice;

	@ApiModelProperty("运营服务费")
    private Double operSerCharge;

	@ApiModelProperty("技术服务费")
    private Double jsSerCost;

	@ApiModelProperty("服务费")
	@ExcelField(title = "服务费", sort = 8, width = 20)
    private Double platYFCost;

	@ApiModelProperty("订单来源类型")
    private String ordSourceType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public Long getMembId() {
		return membId;
	}

	public void setMembId(Long membId) {
		this.membId = membId;
	}

	public String getMembNo() {
		return membNo;
	}

	public void setMembNo(String membNo) {
		this.membNo = membNo;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getOrdNum() {
		return ordNum;
	}

	public void setOrdNum(String ordNum) {
		this.ordNum = ordNum;
	}

	public OffsetDateTime getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(OffsetDateTime finishDate) {
		this.finishDate = finishDate;
	}

	public Double getCommTotalPrice() {
		return commTotalPrice;
	}

	public void setCommTotalPrice(Double commTotalPrice) {
		this.commTotalPrice = commTotalPrice;
	}

	public Double getSplitIncome() {
		return splitIncome;
	}

	public void setSplitIncome(Double splitIncome) {
		this.splitIncome = splitIncome;
	}

	public String getSettleBillNumb() {
		return settleBillNumb;
	}

	public void setSettleBillNumb(String settleBillNumb) {
		this.settleBillNumb = settleBillNumb;
	}

	public Double getOrdFreight() {
		return ordFreight;
	}

	public void setOrdFreight(Double ordFreight) {
		this.ordFreight = ordFreight;
	}

	public Double getRefundPrice() {
		return refundPrice;
	}

	public void setRefundPrice(Double refundPrice) {
		this.refundPrice = refundPrice;
	}

	public Double getOperSerCharge() {
		return operSerCharge;
	}

	public void setOperSerCharge(Double operSerCharge) {
		this.operSerCharge = operSerCharge;
	}

	public Double getJsSerCost() {
		return jsSerCost;
	}

	public void setJsSerCost(Double jsSerCost) {
		this.jsSerCost = jsSerCost;
	}

	public Double getPlatYFCost() {
		return platYFCost;
	}

	public void setPlatYFCost(Double platYFCost) {
		this.platYFCost = platYFCost;
	}

	public String getOrdSourceType() {
		return ordSourceType;
	}

	public void setOrdSourceType(String ordSourceType) {
		this.ordSourceType = ordSourceType;
	}
}
