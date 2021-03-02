package com.wisea.transac.common.po;

import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.SettleBillPageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

@ApiModel("分页查询结算单列表Po")
public class SettleBillPageListPo extends PagePo<SettleBillPageListVo> {
    @ApiModelProperty("查询类型：0 待对账、 1 待开票、 2 待结算、 3 逾期、 4 全部")
    @Check(test = "logic", logic = "#isEmpty(#query) ? #isNotEmpty(#queryFlag) : true", logicMsg = "查询类型不能为空")
    //@Check(test = "required", requiredMsg = "查询类型不能为空")
    private String queryFlag;
    @ApiModelProperty("输入框搜索内容")
    private String query;
    @ApiModelProperty(value="最晚付款日开始时间")
    private OffsetDateTime lastPayStartDate;
    @ApiModelProperty(value="最晚付款日结束时间")
    private OffsetDateTime lastPayEndDate;
    @ApiModelProperty(value="账期类型")
    private String settleCycleType;
    @ApiModelProperty(value="结算单状态")
    private String settleBillStatueType;

    @ApiModelProperty(value = "查询端用户类型：0 市场 、1 卖家", hidden = true)
    private String queryUserFlag;
    @ApiModelProperty(value = "批发市场ID，超级管理员进入市场管理界面需要传")
    private Long marketId;
    @ApiModelProperty(value = "卖家用户IDs", hidden = true)
    private List<Long> sellerIds;

    public String getQueryFlag() {
        return queryFlag;
    }

    public void setQueryFlag(String queryFlag) {
        this.queryFlag = queryFlag;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
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

    public String getSettleCycleType() {
        return settleCycleType;
    }

    public void setSettleCycleType(String settleCycleType) {
        this.settleCycleType = settleCycleType;
    }

    public String getSettleBillStatueType() {
        return settleBillStatueType;
    }

    public void setSettleBillStatueType(String settleBillStatueType) {
        this.settleBillStatueType = settleBillStatueType;
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

    public List<Long> getSellerIds() {
        return sellerIds;
    }

    public void setSellerIds(List<Long> sellerIds) {
        this.sellerIds = sellerIds;
    }
}
