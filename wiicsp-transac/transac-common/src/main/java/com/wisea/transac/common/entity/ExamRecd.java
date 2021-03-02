package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

public class ExamRecd extends DataLongEntity<ExamRecd> {
    /**
     * 会员id
     */
    private Long membId;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 操作时间
     */
    private OffsetDateTime operatDate;

    /**
     * 操作内容
     */
    private String operatorContent;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
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
