package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

public class LtaExamRecd extends DataLongEntity<LtaExamRecd> {
    /**
     * 长协合同id
     */
    private Long ltaContId;

    /**
     * 处理人
     */
    private String operator;

    /**
     * 处理时间
     */
    private OffsetDateTime operatDate;

    /**
     * 处理内容
     */
    private String operatorContent;

    public Long getLtaContId() {
        return ltaContId;
    }

    public void setLtaContId(Long ltaContId) {
        this.ltaContId = ltaContId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public OffsetDateTime getOperatDate() {
        return operatDate;
    }

    public void setOperatDate(OffsetDateTime operatDate) {
        this.operatDate = operatDate;
    }

    public String getOperatorContent() {
        return operatorContent;
    }

    public void setOperatorContent(String operatorContent) {
        this.operatorContent = operatorContent;
    }
}
