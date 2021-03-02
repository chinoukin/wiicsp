package com.wisea.cultivar.common.po.tp.lta;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wisea.cultivar.common.vo.tp.lta.LtaRefundApplListVo;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.po.PagePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @author jirg
 * @version 1.0
 * @className LtaRefundApplListPo
 * @date 2019/5/9 16:54
 * @Description 卖家查询退款申请列表PO
 */
@ApiModel("卖家查询退款申请列表PO")
public class LtaRefundApplListPo extends PagePo<LtaRefundApplListVo> {
    @ApiModelProperty(value = "卖家用户ID", hidden = true)
    private Long sellerId;
    @ApiModelProperty("退款申请状态")
    private String refundApplStateType;
    @ApiModelProperty("开始时间")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime startDate;
    @ApiModelProperty("结束时间")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime endDate;
    @ApiModelProperty("输入搜索内容")
    private String query;
    @ApiModelProperty("开始金额")
    private Double startAmount;
    @ApiModelProperty("结束金额")
    private Double endAmount;

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getRefundApplStateType() {
        return refundApplStateType;
    }

    public void setRefundApplStateType(String refundApplStateType) {
        this.refundApplStateType = refundApplStateType;
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
}
