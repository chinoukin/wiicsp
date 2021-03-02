package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

public class LtaRefundCommOperatorInfo extends DataLongEntity<LtaRefundCommOperatorInfo> {
    /**
     * id
     */
    private Long id;

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

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getRefundApplId() {
        return refundApplId;
    }

    public void setRefundApplId(Long refundApplId) {
        this.refundApplId = refundApplId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public OffsetDateTime getOpreatDate() {
        return opreatDate;
    }

    public void setOpreatDate(OffsetDateTime opreatDate) {
        this.opreatDate = opreatDate;
    }

    public String getOpreatContent() {
        return opreatContent;
    }

    public void setOpreatContent(String opreatContent) {
        this.opreatContent = opreatContent;
    }
}
