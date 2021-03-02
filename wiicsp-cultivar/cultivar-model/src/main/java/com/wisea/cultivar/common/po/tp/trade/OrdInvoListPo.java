package com.wisea.cultivar.common.po.tp.trade;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.tp.trade.OrdInvoListVo;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @Author jirg
 * @Date 2019/4/24 16:25
 * @Description 分页查询发票申请列表Po
 **/
public class OrdInvoListPo extends PagePo<OrdInvoListVo> {
    @ApiModelProperty("发票状态")
    private String invoState;
    @ApiModelProperty(value = "卖家ID", hidden = true)
    private Long sellerId;
    @ApiModelProperty("输入框查询条件")
    private String query;
    @ApiModelProperty("申请开始时间")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime applStartDate;
    @ApiModelProperty("申请结束时间")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime applEndDate;
    @ApiModelProperty("发票类型")
    private String invoType;
    @ApiModelProperty("开票开始时间")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime drawStartDate;
    @ApiModelProperty("开票结束时间")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime drawEndDate;

    public String getInvoState() {
        return invoState;
    }

    public void setInvoState(String invoState) {
        this.invoState = invoState;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public OffsetDateTime getApplStartDate() {
        return applStartDate;
    }

    public void setApplStartDate(OffsetDateTime applStartDate) {
        this.applStartDate = applStartDate;
    }

    public OffsetDateTime getApplEndDate() {
        return applEndDate;
    }

    public void setApplEndDate(OffsetDateTime applEndDate) {
        this.applEndDate = applEndDate;
    }

    public String getInvoType() {
        return invoType;
    }

    public void setInvoType(String invoType) {
        this.invoType = invoType;
    }

    public OffsetDateTime getDrawStartDate() {
        return drawStartDate;
    }

    public void setDrawStartDate(OffsetDateTime drawStartDate) {
        this.drawStartDate = drawStartDate;
    }

    public OffsetDateTime getDrawEndDate() {
        return drawEndDate;
    }

    public void setDrawEndDate(OffsetDateTime drawEndDate) {
        this.drawEndDate = drawEndDate;
    }
}
