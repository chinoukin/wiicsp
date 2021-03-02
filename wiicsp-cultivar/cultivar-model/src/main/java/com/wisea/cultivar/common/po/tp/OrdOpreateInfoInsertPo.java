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
 * OrdOpreateInfoInsertPo
 * 2018/09/20 16:07:20
 */
public class OrdOpreateInfoInsertPo {
    /**
     * 订单id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "订单id")
    private Long ordId;

    /**
     * 操作者
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "操作者")
    private String operator;

    /**
     * 操作时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "操作时间")
    private OffsetDateTime opreatDate;

    /**
     * 付款状态
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "付款状态")
    private String payStateType;

    /**
     * 订单状态类型
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "订单状态类型")
    private String orderStateType;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

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
     * 获取操作者
     */
    public String getOperator() {
        return operator;
    }

    /**
     * 设置操作者
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * 获取操作时间
     */
    public OffsetDateTime getOpreatDate() {
        return opreatDate;
    }

    /**
     * 设置操作时间
     */
    public void setOpreatDate(OffsetDateTime opreatDate) {
        this.opreatDate = opreatDate;
    }

    /**
     * 获取付款状态
     */
    public String getPayStateType() {
        return payStateType;
    }

    /**
     * 设置付款状态
     */
    public void setPayStateType(String payStateType) {
        this.payStateType = payStateType == null ? null : payStateType.trim();
    }

    /**
     * 获取订单状态类型
     */
    public String getOrderStateType() {
        return orderStateType;
    }

    /**
     * 设置订单状态类型
     */
    public void setOrderStateType(String orderStateType) {
        this.orderStateType = orderStateType == null ? null : orderStateType.trim();
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
