package com.wisea.transac.common.po.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className OutstandingBillPo
 * @date 2020/5/19 14:33
 * @Description 未出账单PO
 */
@ApiModel("未出账单PO")
public class OutstandingBillPo {
    @ApiModelProperty("输入框搜索内容")
    private String query;
    @ApiModelProperty(value="账期类型")
    private String settleCycleType;
    @ApiModelProperty(value = "查询端用户类型：0 市场 、1 卖家", hidden = true)
    private String queryUserFlag;
    @ApiModelProperty(value = "批发市场ID，超级管理员进入市场管理界面需要传")
    private Long marketId;

    @ApiModelProperty(value = "卖家用户IDs", hidden = true)
    private List<Long> sellerIds;

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
