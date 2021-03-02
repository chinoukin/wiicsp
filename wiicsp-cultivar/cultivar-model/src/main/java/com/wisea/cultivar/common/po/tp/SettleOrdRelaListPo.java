package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * SettleOrdRelaListPo
 * 2018/10/13 11:47:55
 */
public class SettleOrdRelaListPo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 结算单id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "结算单id")
    private Long settleId;

    /**
     * 订单id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "订单id")
    private Long ordId;

    /**
     * 订单类型
     */
    @ApiModelProperty(value = "订单类型")
    private String ordType;

    /**
     * 金额
     */
    @ApiModelProperty(value = "金额")
    private Double amount;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    /**
     * 获取id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(Long id) {
        this.id = id;
    }

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

    /**
     * 获取删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}
