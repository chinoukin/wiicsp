package com.wisea.cultivar.common.vo.tp.trade;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 支付明细Vo
 *
 * @author yangtao
 *
 */
@ApiModel("支付明细Vo")
public class IncomeDListVo {

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "支付明细id")
    private Long id;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "订单id")
    private Long ordId;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "会员id")
    private Long membId;

    @ApiModelProperty(value = "会员账号")
    private String membNo;

    @ApiModelProperty(value = "交易流水号")
    private String tradeNo;
    @ApiModelProperty(value = "订单编号")
    private String ordNum;

    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @ApiModelProperty(value = "完成时间")
    private OffsetDateTime finishDate;

    @ApiModelProperty(value = "订单金额")
    private Double commTotalPrice;

    @ApiModelProperty(value = "分账收入")
    private Double splitIncome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrdId() {
        return ordId;
    }

    public void setOrdId(Long ordId) {
        this.ordId = ordId;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getMembNo() {
        return membNo;
    }

    public void setMembNo(String membNo) {
        this.membNo = membNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
    }

    public OffsetDateTime getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(OffsetDateTime finishDate) {
        this.finishDate = finishDate;
    }

    public Double getCommTotalPrice() {
        return commTotalPrice;
    }

    public void setCommTotalPrice(Double commTotalPrice) {
        this.commTotalPrice = commTotalPrice;
    }

    public Double getSplitIncome() {
        return splitIncome;
    }

    public void setSplitIncome(Double splitIncome) {
        this.splitIncome = splitIncome;
    }
}
