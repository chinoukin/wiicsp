package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

/**
 * settle_bill_opreate_info 表实体
 * 结算单操作信息
 * 2018/10/13 17:14:52
 */
public class SettleBillOpreateInfo extends DataLongEntity<SettleBillOpreateInfo> {
    private static final long serialVersionUID = 1L;

    /**
     * 结算单id
     */
    private Long settleId;

    /**
     * 操作者
     */
    private String operator;

    /**
     * 操作时间
     */
    private OffsetDateTime opreatDate;

    /**
     * 操作内容
     */
    private String operatorContent;

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
     * 获取操作内容
     */
    public String getOperatorContent() {
        return operatorContent;
    }

    /**
     * 设置操作内容
     */
    public void setOperatorContent(String operatorContent) {
        this.operatorContent = operatorContent == null ? null : operatorContent.trim();
    }
}
