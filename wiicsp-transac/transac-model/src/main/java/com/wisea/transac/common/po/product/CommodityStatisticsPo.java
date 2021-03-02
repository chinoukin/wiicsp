package com.wisea.transac.common.po.product;

/**
 * @Description: 商家App 商品统计
 * @author: wangs
 * @date :2020/5/25
 */

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * @Author wangs
 */
@ApiModel(" 商家App 商品统计入参")
public class CommodityStatisticsPo {

    /**
     * 开始时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "开始时间")
    private OffsetDateTime startTime;

    /**
     * 结束时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "结束时间")
    private OffsetDateTime endTime;

    /**
     * 档口信息
     */
    @ApiModelProperty(value = "档口ID，如果当前登录用户关联了档口，传关联的档口ID，如果当前登录用户没有关联档口，默认不传，用户选择时再传")
    private List<Long> stallsMageIds;

    public OffsetDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(OffsetDateTime startTime) {
        this.startTime = startTime;
    }

    public OffsetDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(OffsetDateTime endTime) {
        this.endTime = endTime;
    }

    public List<Long> getStallsMageIds() {
        return stallsMageIds;
    }

    public void setStallsMageIds(List<Long> stallsMageIds) {
        this.stallsMageIds = stallsMageIds;
    }
}
