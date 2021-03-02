package com.wisea.cultivar.common.po.tp.lta;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wisea.cultivar.common.vo.tp.lta.LtaOrderListVo;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.po.PagePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @author jirg
 * @version 1.0
 * @className LtaOrderListPo
 * @date 2019/5/7 14:44
 * @Description 查询订单列表Po
 */
@ApiModel("查询订单列表Po")
public class LtaOrderListPo extends PagePo<LtaOrderListVo> {
    @ApiModelProperty("订单状态")
    private String orderStateType;
    @ApiModelProperty("下单开始时间")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime startDate;
    @ApiModelProperty("下单结束时间")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime endDate;
    @ApiModelProperty("输入搜索内容")
    private String query;
    @ApiModelProperty("开始金额（卖家使用）")
    private Double startAmount;
    @ApiModelProperty("结束金额（卖家使用）")
    private Double endAmount;
    @ApiModelProperty(value = "查询端用户类型：0 后台 、1 卖家", hidden = true)
    private String queryUserFlag;
    @ApiModelProperty(value = "卖家用户ID", hidden = true)
    private Long sellerId;
    @ApiModelProperty("支付方式类型")
    private String payMethodType;
    @ApiModelProperty("订单来源")
    private String sourceType;
    @ApiModelProperty("配送信息类型")
    private String deliveryInfoType;
    @ApiModelProperty("商品分类ID")
    private Long commCatgId;

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

    public Double getStartAmount() {
        return startAmount;
    }

    public void setStartAmount(Double startAmount) {
        this.startAmount = startAmount;
    }

    public Double getEndAmount() {
        return endAmount;
    }

    public void setEndAmount(Double endAmount) {
        this.endAmount = endAmount;
    }

    public String getQueryUserFlag() {
        return queryUserFlag;
    }

    public void setQueryUserFlag(String queryUserFlag) {
        this.queryUserFlag = queryUserFlag;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(String payMethodType) {
        this.payMethodType = payMethodType;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getDeliveryInfoType() {
        return deliveryInfoType;
    }

    public void setDeliveryInfoType(String deliveryInfoType) {
        this.deliveryInfoType = deliveryInfoType;
    }

    public Long getCommCatgId() {
        return commCatgId;
    }

    public void setCommCatgId(Long commCatgId) {
        this.commCatgId = commCatgId;
    }
}
