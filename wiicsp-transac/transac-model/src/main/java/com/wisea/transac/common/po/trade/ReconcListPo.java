package com.wisea.transac.common.po.trade;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.SettleBillPageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className ReconcListPo
 * @date 2020/5/18 14:37
 * @Description 对账异议列表PO
 */
@ApiModel("对账异议列表Po")
public class ReconcListPo extends PagePo<SettleBillPageListVo> {
    @ApiModelProperty("输入框搜索内容")
    private String query;
    @ApiModelProperty(value="最晚付款日开始时间")
    private OffsetDateTime lastPayStartDate;
    @ApiModelProperty(value="最晚付款日结束时间")
    private OffsetDateTime lastPayEndDate;
    @ApiModelProperty(value="账期类型")
    private String settleCycleType;
    @ApiModelProperty("市场ID")
    private Long marketId;
    @ApiModelProperty(value = "卖家ID列表", hidden = true)
    private List<Long> sellerIds;


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
