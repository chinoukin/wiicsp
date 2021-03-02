package com.wisea.cultivar.common.vo.tp.trade;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * 退货申请操作记录
 */
@ApiModel("退货申请操作记录")
public class RefundCommOperatorInfoVo {
    @ApiModelProperty("操作者")
    private String operator;
    @ApiModelProperty("操作时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime opreatDate;
    @ApiModelProperty("操作内容")
    private String opreatContent;

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
