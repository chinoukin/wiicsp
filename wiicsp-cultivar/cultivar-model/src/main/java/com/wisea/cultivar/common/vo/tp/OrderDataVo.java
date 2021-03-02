package com.wisea.cultivar.common.vo.tp;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

/**
 * @Author:Liangzy(Wisea)
 * @Date:Create in 2018/10/10 上午11:16
 * @Description:用来收集发票订单中的信息VO
 */
public class OrderDataVo {

    private static final long serialVersionUID = 10000L;

    /**
     * 订单编号
     */
    private String ordNum;

    /**
     * 订单id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "订单id")
    private Long ordId;

    /**
     * 下单日期
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "下单日期")
    private OffsetDateTime referOrdDate;

    /**
     * 订单总金额（商品发布价+运费）/可开票金额合计
     */
    private Double amountPayable;

    /**
     * 尾款金额
     */
    private Double tailAmount;

    /**
     * 应退金额
     */
    private Double shouldRefundAmount;

    /**
     * 运费总金额
     */
    private Double commTotalFreight;

    /**
     * 订单商品信息集合
     */
    private List<OrderCommDataVo> orderCommDataVoList;

    /**
     * 可开票商品总金额
     */
    private Double canIssueInvoiceSumMoney;

    public Long getOrdId() {
        return ordId;
    }

    public void setOrdId(Long ordId) {
        this.ordId = ordId;
    }

    public Double getTailAmount() {
		return tailAmount;
	}

	public void setTailAmount(Double tailAmount) {
		this.tailAmount = tailAmount;
	}

	public Double getCommTotalFreight() {
        return commTotalFreight;
    }

    public void setCommTotalFreight(Double commTotalFreight) {
        this.commTotalFreight = commTotalFreight;
    }

    public String getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
    }

    public OffsetDateTime getReferOrdDate() {
        return referOrdDate;
    }

    public void setReferOrdDate(OffsetDateTime referOrdDate) {
        this.referOrdDate = referOrdDate;
    }

    public Double getAmountPayable() {
        return amountPayable;
    }

    public void setAmountPayable(Double amountPayable) {
        this.amountPayable = amountPayable;
    }

    public Double getShouldRefundAmount() {
        return shouldRefundAmount;
    }

    public void setShouldRefundAmount(Double shouldRefundAmount) {
        if (shouldRefundAmount == null) {
            this.shouldRefundAmount = 0d;
        } else {
            this.shouldRefundAmount = shouldRefundAmount;
        }
    }

    public List<OrderCommDataVo> getOrderCommDataVoList() {
        return orderCommDataVoList;
    }

    public void setOrderCommDataVoList(List<OrderCommDataVo> orderCommDataVoList) {
        this.orderCommDataVoList = orderCommDataVoList;
    }

    public Double getCanIssueInvoiceSumMoney() {
        BigDecimal sum = new BigDecimal(0);
        for (OrderCommDataVo vo : orderCommDataVoList) {
            sum = sum.add(BigDecimal.valueOf(vo.getCanIssueInvoiceMoney()));
        }
        return Double.parseDouble(sum.toString());
    }

    public void setCanIssueInvoiceSumMoney(Double canIssueInvoiceSumMoney) {

        this.canIssueInvoiceSumMoney = canIssueInvoiceSumMoney;
    }
}
