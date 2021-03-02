package com.wisea.cultivar.common.po.tp.trade;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.tp.trade.SettleBillListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @Author jirg
 * @Date 2019/4/24 10:10
 * @Description 分页查询结算单PO
 **/
@ApiModel("分页查询结算单PO")
public class SettleBillListPo extends PagePo<SettleBillListVo> {
    @ApiModelProperty(value = "输入框值")
    private String query;
    @ApiModelProperty("账期类型")
    private String settleCycleType;
    @ApiModelProperty("最晚付款开始日期")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime lastPayStartDate;
    @ApiModelProperty("最晚付款结束日期")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime lastPayEndDate;
    @ApiModelProperty("结算单状态")
    private String settleBillStatueType;
    @ApiModelProperty(value = "卖方id", hidden = true)
    private Long sellerId;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getSettleCycleType() {
        return settleCycleType;
    }

    public void setSettleCycleType(String settleCycleType) {
        this.settleCycleType = settleCycleType;
    }

    public OffsetDateTime getLastPayStartDate() {
        return lastPayStartDate;
    }

    public void setLastPayStartDate(OffsetDateTime lastPayStartDate) {
        this.lastPayStartDate = lastPayStartDate;
    }

    public OffsetDateTime getLastPayEndDate() {
        return lastPayEndDate;
    }

    public void setLastPayEndDate(OffsetDateTime lastPayEndDate) {
        this.lastPayEndDate = lastPayEndDate;
    }

    public String getSettleBillStatueType() {
        return settleBillStatueType;
    }

    public void setSettleBillStatueType(String settleBillStatueType) {
        this.settleBillStatueType = settleBillStatueType;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
}
