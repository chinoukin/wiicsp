package com.wisea.cultivar.common.vo.tp.trade;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.util.excel.annotation.ExcelField;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @author jirg
 * @version 1.0
 * @className SettleBillListVo
 * @date 2019/4/24 10:01
 * @Description 账期结算单列表Vo
 */
@ApiModel("账期结算单列表Vo")
public class SettleBillListVo {
    @ApiModelProperty("账期结算单ID")
    private Long id;
    @ApiModelProperty("结算单号")
    @ExcelField(title = "账单编号", sort = 0, width = 20)
    private String settleBillNumb;
    @ApiModelProperty("账期类型")
    @ExcelField(title = "账期类型", sort = 1, dictType="settle_cycle_type", width = 20)
    private String settleCycleType;
    @ApiModelProperty("结算周期开始时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @ExcelField(title = "结算周期开始时间", sort = 2, width = 20)
    private OffsetDateTime settleCycleStartDate;
    @ApiModelProperty("结算周期结束时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @ExcelField(title = "结算周期结束时间", sort = 3, width = 20)
    private OffsetDateTime settleCycleEndDate;
    @ApiModelProperty("采购商账号")
    @ExcelField(title = "采购商账号", sort = 4, width = 20)
    private String buyerAccount;
    @ApiModelProperty("采购商名称")
    @ExcelField(title = "采购商名称", sort = 5, width = 20)
    private String buyerName;
    @ApiModelProperty("结算单金额")
    @ExcelField(title = "结算单金额", sort = 6, width = 20)
    private Double settleBillMoney;
    @ApiModelProperty("订单数")
    @ExcelField(title = "订单数", sort = 7, width = 20)
    private Integer ordCount;
    @ApiModelProperty("最晚付款日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @ExcelField(title = "最晚付款日期", sort = 8, width = 20)
    private OffsetDateTime lastPayDate;
    @ApiModelProperty("滞纳金")
    @ExcelField(title = "滞纳金", sort = 9, width = 20)
    private Double lateFee;
    @ApiModelProperty("应结总额")
    @ExcelField(title = "应结总额", sort = 10, width = 20)
    private Double totalMoney;
    @ApiModelProperty("结算单状态")
    @ExcelField(title = "结算单状态", sort = 11, dictType="settle_bill_statue_type", width = 20)
    private String settleBillStatueType;
    @ApiModelProperty("卖方id")
    private Long sellerId;
    @ApiModelProperty("买方id")
    private Long buyerId;
    @ApiModelProperty("是否逾期")
    private String sfYqFlag;

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

    public String getSettleCycleType() {
        return settleCycleType;
    }

    public void setSettleCycleType(String settleCycleType) {
        this.settleCycleType = settleCycleType;
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

    public String getBuyerAccount() {
        return buyerAccount;
    }

    public void setBuyerAccount(String buyerAccount) {
        this.buyerAccount = buyerAccount;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public Double getSettleBillMoney() {
        return settleBillMoney;
    }

    public void setSettleBillMoney(Double settleBillMoney) {
        this.settleBillMoney = settleBillMoney;
    }

    public Integer getOrdCount() {
        return ordCount;
    }

    public void setOrdCount(Integer ordCount) {
        this.ordCount = ordCount;
    }

    public OffsetDateTime getLastPayDate() {
        return lastPayDate;
    }

    public void setLastPayDate(OffsetDateTime lastPayDate) {
        this.lastPayDate = lastPayDate;
    }

    public Double getLateFee() {
        return lateFee;
    }

    public void setLateFee(Double lateFee) {
        this.lateFee = lateFee;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getSettleBillStatueType() {
        return settleBillStatueType;
    }

    public void setSettleBillStatueType(String settleBillStatueType) {
        this.settleBillStatueType = settleBillStatueType;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getSfYqFlag() {
        return sfYqFlag;
    }

    public void setSfYqFlag(String sfYqFlag) {
        this.sfYqFlag = sfYqFlag;
    }
}
