package com.wisea.cultivar.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

public class FeedBackMage extends DataLongEntity<FeedBackMage> {
    /**
     * 用户名
     */
    private String loginName;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String tel;

    /**
     * 企业名称
     */
    private String entpName;

    /**
     * 问题类型
     */
    private String problemType;

    /**
     * 反馈内容
     */
    private String feedbackContent;

    /**
     * 来源类型
     */
    private String sourceType;

    /**
     * 处理状态类型
     */
    private String procesStatusType;

    /**
     * 处理者
     */
    private String operator;

    /**
     * 处理时间
     */
    private OffsetDateTime opreatDate;

    /**
     * 处理结果
     */
    private String opreatContent;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEntpName() {
        return entpName;
    }

    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }

    public String getProblemType() {
        return problemType;
    }

    public void setProblemType(String problemType) {
        this.problemType = problemType;
    }

    public String getFeedbackContent() {
        return feedbackContent;
    }

    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getProcesStatusType() {
        return procesStatusType;
    }

    public void setProcesStatusType(String procesStatusType) {
        this.procesStatusType = procesStatusType;
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
