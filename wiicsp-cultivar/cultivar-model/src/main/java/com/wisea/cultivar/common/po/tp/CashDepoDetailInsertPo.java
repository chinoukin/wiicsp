package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

/**
 * CashDepoDetailInsertPo
 * 2019/01/22 09:30:04
 */
public class CashDepoDetailInsertPo {
    /**
     * 会员id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "会员id")
    private Long membId;

    /**
     * 交易流水号
     */
    @Check(test = { "maxLength" }, mixLength = 50)
    @ApiModelProperty(value = "交易流水号")
    private String tradeNo;

    /**
     * 提现账户
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "提现账户")
    private String cashDepoAcct;

    /**
     * 提现时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "提现时间")
    private OffsetDateTime cashDepoDate;

    /**
     * 完成时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "完成时间")
    private OffsetDateTime finishDate;

    /**
     * 提现金额
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "提现金额")
    private Double cashDepoAmount;

    /**
     * 手续费
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "手续费")
    private Double serCharge;

    /**
     * 提现状态
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "提现状态")
    private String cashDepoState;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 获取会员id
     */
    public Long getMembId() {
        return membId;
    }

    /**
     * 设置会员id
     */
    public void setMembId(Long membId) {
        this.membId = membId;
    }

    /**
     * 获取交易流水号
     */
    public String getTradeNo() {
        return tradeNo;
    }

    /**
     * 设置交易流水号
     */
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    /**
     * 获取提现账户
     */
    public String getCashDepoAcct() {
        return cashDepoAcct;
    }

    /**
     * 设置提现账户
     */
    public void setCashDepoAcct(String cashDepoAcct) {
        this.cashDepoAcct = cashDepoAcct == null ? null : cashDepoAcct.trim();
    }

    /**
     * 获取提现时间
     */
    public OffsetDateTime getCashDepoDate() {
        return cashDepoDate;
    }

    /**
     * 设置提现时间
     */
    public void setCashDepoDate(OffsetDateTime cashDepoDate) {
        this.cashDepoDate = cashDepoDate;
    }

    /**
     * 获取完成时间
     */
    public OffsetDateTime getFinishDate() {
        return finishDate;
    }

    /**
     * 设置完成时间
     */
    public void setFinishDate(OffsetDateTime finishDate) {
        this.finishDate = finishDate;
    }

    /**
     * 获取提现金额
     */
    public Double getCashDepoAmount() {
        return cashDepoAmount;
    }

    /**
     * 设置提现金额
     */
    public void setCashDepoAmount(Double cashDepoAmount) {
        this.cashDepoAmount = cashDepoAmount;
    }

    /**
     * 获取手续费
     */
    public Double getSerCharge() {
        return serCharge;
    }

    /**
     * 设置手续费
     */
    public void setSerCharge(Double serCharge) {
        this.serCharge = serCharge;
    }

    /**
     * 获取提现状态
     */
    public String getCashDepoState() {
        return cashDepoState;
    }

    /**
     * 设置提现状态
     */
    public void setCashDepoState(String cashDepoState) {
        this.cashDepoState = cashDepoState == null ? null : cashDepoState.trim();
    }

    /**
     * 获取备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}
