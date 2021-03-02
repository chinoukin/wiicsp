package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;
import java.time.OffsetDateTime;

/**
 * cash_depo_detail 表实体
 * 提现明细
 * 2019/01/22 09:30:04
 */
public class CashDepoDetail extends DataLongEntity<CashDepoDetail> {
    private static final long serialVersionUID = 1L;

    /**
     * 会员id
     */
    private Long membId;

    /**
     * 交易流水号
     */
    private String tradeNo;

    /**
     * 提现账户
     */
    private String cashDepoAcct;

    /**
     * 提现时间
     */
    private OffsetDateTime cashDepoDate;

    /**
     * 完成时间
     */
    private OffsetDateTime finishDate;

    /**
     * 提现金额
     */
    private Double cashDepoAmount;

    /**
     * 手续费
     */
    private Double serCharge;

    /**
     * 提现状态
     */
    private String cashDepoState;

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
}
