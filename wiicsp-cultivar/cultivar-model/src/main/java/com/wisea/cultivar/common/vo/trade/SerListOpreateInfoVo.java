package com.wisea.cultivar.common.vo.trade;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @ClassName: SerListOpreateInfoVo
 * @Author: tgz
 * @Date: 2020/8/5 9:27
 */
@ApiModel("操作日志信息")
public class SerListOpreateInfoVo {

    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "操作内容")
    private String opreatContent;

    @ApiModelProperty(value = "操作人")
    private String operator;
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "操作时间")
    private OffsetDateTime opreatDate;

    @ApiModelProperty("服务单状态 {0：待确认1：待服务2：服务中3：已取消}")
    private String serListStateType;
    @ApiModelProperty("服务单状态值")
    private String serListStateTypeValue;

    public String getSerListStateType() {
        return serListStateType;
    }

    public void setSerListStateType(String serListStateType) {
        this.serListStateType = serListStateType;
    }

    public String getSerListStateTypeValue() {
        return serListStateTypeValue;
    }

    public void setSerListStateTypeValue(String serListStateTypeValue) {
        this.serListStateTypeValue = serListStateTypeValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpreatContent() {
        return opreatContent;
    }

    public void setOpreatContent(String opreatContent) {
        this.opreatContent = opreatContent;
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
}
