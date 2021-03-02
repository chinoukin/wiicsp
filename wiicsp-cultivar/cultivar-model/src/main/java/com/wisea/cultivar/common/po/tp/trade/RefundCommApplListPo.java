package com.wisea.cultivar.common.po.tp.trade;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.tp.trade.RefundCommApplListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * 查询退货退款申请列表PO
 */
@ApiModel("查询退货退款申请列表PO")
public class RefundCommApplListPo extends PagePo<RefundCommApplListVo> {
    @ApiModelProperty("退货退款申请状态")
    private String refundCommState;
    @ApiModelProperty("开始时间")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime startDate;
    @ApiModelProperty("结束时间")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime endDate;
    @ApiModelProperty("输入搜索内容")
    private String query;
    @ApiModelProperty(value = "查询端用户类型：0 后台 、1 卖家", hidden = true)
    private String queryUserFlag;
    @ApiModelProperty("处理方标志")
    private String handlerType;
    @ApiModelProperty(value = "卖家用户ID", hidden = true)
    private Long sellerId;
    @ApiModelProperty("补损状态")
    private String bsStateType;
    @ApiModelProperty("异议类型")
    private String examDissType;

    public String getRefundCommState() {
        return refundCommState;
    }

    public void setRefundCommState(String refundCommState) {
        this.refundCommState = refundCommState;
    }

    public OffsetDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(OffsetDateTime startDate) {
        this.startDate = startDate;
    }

    public OffsetDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(OffsetDateTime endDate) {
        this.endDate = endDate;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getQueryUserFlag() {
        return queryUserFlag;
    }

    public void setQueryUserFlag(String queryUserFlag) {
        this.queryUserFlag = queryUserFlag;
    }

    public String getHandlerType() {
        return handlerType;
    }

    public void setHandlerType(String handlerType) {
        this.handlerType = handlerType;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getBsStateType() {
        return bsStateType;
    }

    public void setBsStateType(String bsStateType) {
        this.bsStateType = bsStateType;
    }

    public String getExamDissType() {
        return examDissType;
    }

    public void setExamDissType(String examDissType) {
        this.examDissType = examDissType;
    }
}