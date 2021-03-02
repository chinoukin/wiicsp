package com.wisea.transac.common.po.trade;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className ServiceFeeStatisticsPo
 * @date 2020/5/25 15:50
 * @Description 服务费统计PO
 */
@ApiModel("服务费统计PO")
public class ServiceFeeStatisticsPo {
    @ApiModelProperty("查询方式：0 按月 、1 按年")
    @Check(test = {"required", "liveable"}, liveable = {"0", "1"}, liveableMsg = "查询方式是能是按年或按月")
    private String queryType;
    @ApiModelProperty("查询月份")
    @Check(test = "logic", logic = "'0'.equals(#queryType)?#isNotEmpty(#queryMonth):true", logicMsg = "月份不能为空")
    private String queryMonth;
    @ApiModelProperty(value = "批发市场ID，超级管理员进入市场管理界面需要传")
    private Long marketId;

    @ApiModelProperty(value = "查询开始时间", hidden = true)
    private OffsetDateTime startDate;
    @ApiModelProperty(value = "查询结束时间", hidden = true)
    private OffsetDateTime endDate;
    @ApiModelProperty(value = "市场卖家ID", hidden = true)
    private List<Long> sellerIds;


    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public String getQueryMonth() {
        return queryMonth;
    }

    public void setQueryMonth(String queryMonth) {
        this.queryMonth = queryMonth;
    }

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
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

    public List<Long> getSellerIds() {
        return sellerIds;
    }

    public void setSellerIds(List<Long> sellerIds) {
        this.sellerIds = sellerIds;
    }
}
