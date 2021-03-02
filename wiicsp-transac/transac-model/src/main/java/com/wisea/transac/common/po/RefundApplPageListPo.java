package com.wisea.transac.common.po;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.RefundApplPageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

@ApiModel("分页查询退款列表Po")
public class RefundApplPageListPo extends PagePo<RefundApplPageListVo> {
    @ApiModelProperty(value="申请开始时间")
    private OffsetDateTime startDate;
    @ApiModelProperty(value="申请结束时间")
    private OffsetDateTime endDate;
    @ApiModelProperty(value="退款申请状态类型")
    private String refundApplStateType;
    @ApiModelProperty("输入搜索内容")
    private String query;

    @ApiModelProperty(value = "查询端用户类型：0 市场 、1 卖家", hidden = true)
    private String queryUserFlag;
    @ApiModelProperty(value = "批发市场ID，超级管理员进入市场管理界面需要传")
    private Long marketId;
    @ApiModelProperty(value = "档口ID，如果当前登录用户关联了档口，传关联的档口ID，如果当前登录用户没有关联档口，默认不传，用户选择时再传")
    private List<Long> stallsIds;

    @ApiModelProperty(value = "卖家用户IDs", hidden = true)
    private List<Long> sellerIds;

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

    public String getRefundApplStateType() {
        return refundApplStateType;
    }

    public void setRefundApplStateType(String refundApplStateType) {
        this.refundApplStateType = refundApplStateType;
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
