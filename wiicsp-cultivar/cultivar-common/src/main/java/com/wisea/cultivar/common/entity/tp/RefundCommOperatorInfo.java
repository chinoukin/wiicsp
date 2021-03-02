package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

/**
 * refund_comm_operator_info 表实体
 * 退货操作信息
 * 2018/09/30 09:46:17
 */
public class RefundCommOperatorInfo extends DataLongEntity<RefundCommOperatorInfo> {
    private static final long serialVersionUID = 1L;

    /**
     * 退货申请id
     */
    private Long refundApplId;

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
    private String opreatContent;

    /**
     * 获取退货申请id
     */
    public Long getRefundApplId() {
        return refundApplId;
    }

    /**
     * 设置退货申请id
     */
    public void setRefundApplId(Long refundApplId) {
        this.refundApplId = refundApplId;
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
    public String getOpreatContent() {
        return opreatContent;
    }

    /**
     * 设置操作内容
     */
    public void setOpreatContent(String opreatContent) {
        this.opreatContent = opreatContent == null ? null : opreatContent.trim();
    }
}
