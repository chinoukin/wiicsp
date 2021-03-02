package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * settle_ord_rela 表实体
 * 结算订单关系表
 * 2018/10/13 11:47:55
 */
public class SettleOrdRela extends DataLongEntity<SettleOrdRela> {
    private static final long serialVersionUID = 1L;

    /**
     * 结算单id
     */
    private Long settleId;

    /**
     * 订单id
     */
    private Long ordId;

    /**
     * 订单类型
     */
    private String ordType;

    /**
     * 订单来源类型
     */
    private String ordSourceType;

    /**
     * 金额
     */
    private Double amount;

    /**
     * 获取结算单id
     */
    public Long getSettleId() {
        return settleId;
    }

    /**
     * 设置结算单id
     */
    public void setSettleId(Long settleId) {
        this.settleId = settleId;
    }

    /**
     * 获取订单id
     */
    public Long getOrdId() {
        return ordId;
    }

    /**
     * 设置订单id
     */
    public void setOrdId(Long ordId) {
        this.ordId = ordId;
    }

    /**
     * 获取订单类型
     */
    public String getOrdType() {
        return ordType;
    }

    /**
     * 设置订单类型
     */
    public void setOrdType(String ordType) {
        this.ordType = ordType == null ? null : ordType.trim();
    }

    public String getOrdSourceType() {
        return ordSourceType;
    }

    public void setOrdSourceType(String ordSourceType) {
        this.ordSourceType = ordSourceType;
    }

    /**
     * 获取金额
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * 设置金额
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
