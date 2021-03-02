package com.wisea.cultivar.common.vo.tp.trade;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cultivar.common.vo.tp.SettleBillInvoListVo;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className SettleBillInfoVo
 * @date 2019/5/15 9:25
 * @Description 结算单详情Vo
 */
@ApiModel("结算单详情Vo")
public class SettleBillInfoVo {
    @ApiModelProperty("结算单ID")
    private Long id;
    @ApiModelProperty("结算单状态")
    private String settleBillStatueType;
    @ApiModelProperty("结算单号")
    private String settleBillNumb;
    @ApiModelProperty("买家用户ID")
    private Long buyerId;
    @ApiModelProperty("卖家用户ID")
    private Long sellerId;
    @ApiModelProperty("买家用户账号")
    private String buyerAccount;
    @ApiModelProperty("买家名称")
    private String buyerCompName;
    @ApiModelProperty("账期类型")
    private String settleCycleType;
    @ApiModelProperty("账单生成日")
    private String billDateType;
    @ApiModelProperty("结算周期开始时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime settleCycleStartDate;
    @ApiModelProperty("结算周期结束时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime settleCycleEndDate;
    @ApiModelProperty("最晚付款日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime lastPayDate;
    @ApiModelProperty(value = "账单生成日")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime createDate;
    @ApiModelProperty("滞纳金")
    private Double lateFee;
    @ApiModelProperty("应结总额")
    private Double totalMoney;
    @ApiModelProperty("订单总数")
    private Integer ordTotalCount;
    @ApiModelProperty("可开票金额")
    private Double invoAmount;
    @ApiModelProperty("订单总金额")
    private Double ordTotalAmount;
    @ApiModelProperty("退货申请总数")
    private Integer refundCommApplTotalCount;
    @ApiModelProperty("退款总额")
    private Double refundCommTotalAmount;
    @ApiModelProperty("结算周期内订单列表")
    private List<SettleBillOrdVo> settleBillOrdLists;
    @ApiModelProperty("结算周期内已完成的退货申请列表")
    private List<SettleBillRefundCommApplVo> settleBillRefundCommAppls;
    @ApiModelProperty("结算单发票")
    private SettleBillInvoListVo settleBillInvo;
    @ApiModelProperty("是否逾期")
    private String sfYqFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public OffsetDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(OffsetDateTime createDate) {
		this.createDate = createDate;
	}

	public SettleBillInvoListVo getSettleBillInvo() {
		return settleBillInvo;
	}

	public void setSettleBillInvo(SettleBillInvoListVo settleBillInvo) {
		this.settleBillInvo = settleBillInvo;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public Double getInvoAmount() {
		return invoAmount;
	}

	public void setInvoAmount(Double invoAmount) {
		this.invoAmount = invoAmount;
	}

	public String getSettleBillStatueType() {
        return settleBillStatueType;
    }

    public void setSettleBillStatueType(String settleBillStatueType) {
        this.settleBillStatueType = settleBillStatueType;
    }

    public String getSettleBillNumb() {
        return settleBillNumb;
    }

    public void setSettleBillNumb(String settleBillNumb) {
        this.settleBillNumb = settleBillNumb;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerAccount() {
        return buyerAccount;
    }

    public void setBuyerAccount(String buyerAccount) {
        this.buyerAccount = buyerAccount;
    }

    public String getBuyerCompName() {
        return buyerCompName;
    }

    public void setBuyerCompName(String buyerCompName) {
        this.buyerCompName = buyerCompName;
    }

    public String getSettleCycleType() {
        return settleCycleType;
    }

    public void setSettleCycleType(String settleCycleType) {
        this.settleCycleType = settleCycleType;
    }

    public String getBillDateType() {
        return billDateType;
    }

    public void setBillDateType(String billDateType) {
        this.billDateType = billDateType;
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

    public OffsetDateTime getLastPayDate() {
        return lastPayDate;
    }

    public void setLastPayDate(OffsetDateTime lastPayDate) {
        this.lastPayDate = lastPayDate;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getOrdTotalCount() {
        return ordTotalCount;
    }

    public void setOrdTotalCount(Integer ordTotalCount) {
        this.ordTotalCount = ordTotalCount;
    }

    public Double getOrdTotalAmount() {
        return ordTotalAmount;
    }

    public void setOrdTotalAmount(Double ordTotalAmount) {
        this.ordTotalAmount = ordTotalAmount;
    }

    public Integer getRefundCommApplTotalCount() {
        return refundCommApplTotalCount;
    }

    public void setRefundCommApplTotalCount(Integer refundCommApplTotalCount) {
        this.refundCommApplTotalCount = refundCommApplTotalCount;
    }

    public Double getRefundCommTotalAmount() {
        return refundCommTotalAmount;
    }

    public void setRefundCommTotalAmount(Double refundCommTotalAmount) {
        this.refundCommTotalAmount = refundCommTotalAmount;
    }

    public List<SettleBillOrdVo> getSettleBillOrdLists() {
        return settleBillOrdLists;
    }

    public void setSettleBillOrdLists(List<SettleBillOrdVo> settleBillOrdLists) {
        this.settleBillOrdLists = settleBillOrdLists;
    }

    public List<SettleBillRefundCommApplVo> getSettleBillRefundCommAppls() {
        return settleBillRefundCommAppls;
    }

    public void setSettleBillRefundCommAppls(List<SettleBillRefundCommApplVo> settleBillRefundCommAppls) {
        this.settleBillRefundCommAppls = settleBillRefundCommAppls;
    }

    public Double getLateFee() {
        return lateFee;
    }

    public void setLateFee(Double lateFee) {
        this.lateFee = lateFee;
    }

    public String getSfYqFlag() {
        return sfYqFlag;
    }

    public void setSfYqFlag(String sfYqFlag) {
        this.sfYqFlag = sfYqFlag;
    }
}
