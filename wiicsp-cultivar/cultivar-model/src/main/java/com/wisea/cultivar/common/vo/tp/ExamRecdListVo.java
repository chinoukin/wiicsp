package com.wisea.cultivar.common.vo.tp;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModelProperty;

/**
 * ExamRecdListVo
 * 2018/10/08 10:50:19
 */
public class ExamRecdListVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;
    /**
     * 操作人
     */
    @ApiModelProperty(value = "操作人")
    private String operator;

    /**
     * 操作时间
     */
    @ApiModelProperty(value = "操作时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime operatDate;

    /**
     * 操作内容
     */
    @ApiModelProperty(value = "操作内容")
    private String operatorContent;

    /**
     * 获取id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(Long id) {
        this.id = id;
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
