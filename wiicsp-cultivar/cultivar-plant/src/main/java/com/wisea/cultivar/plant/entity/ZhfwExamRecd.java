package com.wisea.cultivar.plant.entity;

import com.wisea.cloud.common.entity.DataLongEntity;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

public class ZhfwExamRecd extends DataLongEntity<ZhfwExamRecd> {
    /**
     * 会员名id
     */
    @ApiModelProperty("会员名id")
    private Long membId;

    /**
     * 操作人
     */
    @ApiModelProperty("操作人")
    private String operator;

    /**
     * 操作时间
     */
    @ApiModelProperty("操作时间")
    private OffsetDateTime operatDate;

    /**
     * 操作内容
     */
    @ApiModelProperty("操作内容")
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
