package com.wisea.cultivar.seedlings.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

/**
 * subsidy_exam_recd 表实体
 * 补贴审核记录
 * 2020/08/06 14:19:24
 */
public class SubsidyExamRecd extends DataLongEntity<SubsidyExamRecd> {
    private static final long serialVersionUID = 1L;

    /**
     * 补贴申请管理id
     */
    private Long subsidyApplMageId;

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

    /**
     *
     * @mbg.generated
     */
    public SubsidyExamRecd() {
        super();
    }

    /**
     * 获取补贴申请管理id
     */
    public Long getSubsidyApplMageId() {
        return subsidyApplMageId;
    }

    /**
     * 设置补贴申请管理id
     */
    public void setSubsidyApplMageId(Long subsidyApplMageId) {
        this.subsidyApplMageId = subsidyApplMageId;
    }

    /**
     * 获取操作人
     */
    public String getOperator() {
        return operator;
    }

    /**
     * 设置操作人
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * 获取操作时间
     */
    public OffsetDateTime getOperatDate() {
        return operatDate;
    }

    /**
     * 设置操作时间
     */
    public void setOperatDate(OffsetDateTime operatDate) {
        this.operatDate = operatDate;
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
