package com.wisea.cultivar.seedlings.po;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

/**
 * SubsidyExamRecdInsertPo
 * 2020/08/06 14:19:24
 */
public class SubsidyExamRecdInsertPo {
    /**
     * 补贴申请管理id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "补贴申请管理id", allowableValues = "length:(,19]")
    private Long subsidyApplMageId;

    /**
     * 操作人
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "操作人", allowableValues = "mixLength:(,255]")
    private String operator;

    /**
     * 操作时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "操作时间")
    private OffsetDateTime operatDate;

    /**
     * 操作内容
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "操作内容", allowableValues = "mixLength:(,255]")
    private String operatorContent;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

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
