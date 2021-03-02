package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

/**
 * ord_opreate_info 表实体
 * 订单操作信息
 * 2018/09/20 16:07:20
 */
public class OrdOpreateInfo extends DataLongEntity<OrdOpreateInfo> {
    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    private Long ordId;

    /**
     * 操作者
     */
    private String operator;

    /**
     * 操作时间
     */
    private OffsetDateTime opreatDate;

    /**
     * 付款状态
     */
    private String payStateType;

    /**
     * 订单状态类型
     */
    private String orderStateType;

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
}
