package com.wisea.transac.common.po.system;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @author wangjiahao
 * @since 2020/5/11 10:12 上午
 */
@ApiModel("批发市场排名PO")
public class MarketRankPo {

    private final static String ORDER_COUNT = "orderCount";
    private final static String TOTAL_AMOUNT = "totalAmount";
    private final static String SHOP_COUNT = "shopCount";

    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty("开始时间")
    private OffsetDateTime startDate;

    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty("结束时间")
    private OffsetDateTime endDate;

    @ApiModelProperty(value = "排序字段，orderCount，totalAmount，shopCount：", allowableValues = ORDER_COUNT + "," + TOTAL_AMOUNT + "," + SHOP_COUNT)
    private String order = TOTAL_AMOUNT;

    @ApiModelProperty("查询前几名")
    private Long limit = 10L;

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

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    /**
     * 检查两个日期前后顺序，如果开始在结束之后，则交换他们的值
     */
    public void checkDate() {
        if (this.startDate == null || this.endDate == null) {
            return;
        }
        if (this.startDate.isAfter(this.endDate)) {
            OffsetDateTime tmp = this.startDate;
            this.startDate = this.endDate;
            this.endDate = tmp;
        }
    }

    public void checkOrder() {
        if (ConverterUtil.isNotEmpty(this.order)) {
            switch (this.order) {
                case ORDER_COUNT:
                case TOTAL_AMOUNT:
                case SHOP_COUNT:
                    break;
                default:
                    this.order = null;
                    break;
            }
        }
    }
}
