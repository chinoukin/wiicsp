package com.wisea.transac.common.po.trade;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.trade.MerchantOrderInfoListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

@ApiModel("商家/市场查询订单列表PO")
public class MerchantOrderInfoListPo extends PagePo<MerchantOrderInfoListVo> {
    @ApiModelProperty("订单状态")
    private String orderStateType;
    @ApiModelProperty("输入搜索内容")
    private String query;
    @ApiModelProperty("下单开始时间")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime startDate;
    @ApiModelProperty("下单结束时间")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime endDate;

    @ApiModelProperty(value = "查询端用户类型：0 市场 、1 卖家", hidden = true)
    private String queryUserFlag;
    @ApiModelProperty(value = "批发市场ID，超级管理员进入市场管理界面需要传")
    private Long marketId;
    @ApiModelProperty(value = "档口ID，如果当前登录用户关联了档口，传关联的档口ID，如果当前登录用户没有关联档口，默认不传，用户选择时再传")
    private List<Long> stallsIds;

    @ApiModelProperty(value = "卖家用户IDs", hidden = true)
    private List<Long> sellerIds;

    public String getOrderStateType() {
        return orderStateType;
    }

    public void setOrderStateType(String orderStateType) {
        this.orderStateType = orderStateType;
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

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    public List<Long> getStallsIds() {
        return stallsIds;
    }

    public void setStallsIds(List<Long> stallsIds) {
        this.stallsIds = stallsIds;
    }

    public List<Long> getSellerIds() {
        return sellerIds;
    }

    public void setSellerIds(List<Long> sellerIds) {
        this.sellerIds = sellerIds;
    }


}
