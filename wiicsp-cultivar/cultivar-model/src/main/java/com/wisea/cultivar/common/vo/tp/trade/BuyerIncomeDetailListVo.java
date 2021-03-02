package com.wisea.cultivar.common.vo.tp.trade;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * income_detaiPo
 * 收入明细
 *
 */
@ApiModel("收入明细列表vo")
public class BuyerIncomeDetailListVo  {

	@ApiModelProperty("id")
	@JsonSerialize(using = IdSerializer.class)
    private Long id;

	@ApiModelProperty("会员id")
	@JsonSerialize(using = IdSerializer.class)
    private Long membId;

	@ApiModelProperty("会员账号")
    private String membNo;

	@ApiModelProperty("买家账号")
    private String buyerName;

	@ApiModelProperty("订单id")
	@JsonSerialize(using = IdSerializer.class)
    private Long orderId;

	@ApiModelProperty("交易流水号")
    private String tradeNo;

	@ApiModelProperty("订单编号")
    private String ordNum;

	@ApiModelProperty("完成时间")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime finishDate;

	@ApiModelProperty("订单总金额")
    private Double commTotalPrice;

	@ApiModelProperty("分账收入")
    private Double splitIncome;

	@ApiModelProperty("账单编号")
    private String settleBillNumb;

	@ApiModelProperty("订单运费")
    private Double ordFreight;

	@ApiModelProperty("退货退款金额")
    private Double refundPrice;

	@ApiModelProperty("运营服务费")
    private Double operSerCharge;

	@ApiModelProperty("技术服务费")
    private Double jsSerCost;

	@ApiModelProperty("服务费")
    private Double platYFCost;

	@ApiModelProperty("订单来源类型")
    private String ordSourceType;

    /**
     * 获取会员id
     */
    public Long getMembId() {
        return membId;
    }

    public Double getPlatYFCost() {
		return platYFCost;
	}

	public void setPlatYFCost(Double platYFCost) {
		this.platYFCost = platYFCost;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	/**
     * 设置会员id
     */
    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getMembNo() {
		return membNo;
	}

	public void setMembNo(String membNo) {
		this.membNo = membNo;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrdSourceType() {
		return ordSourceType;
	}

	public void setOrdSourceType(String ordSourceType) {
		this.ordSourceType = ordSourceType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
     * 获取交易流水号
     */
    public String getTradeNo() {
        return tradeNo;
    }

    /**
     * 设置交易流水号
     */
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    /**
     * 获取订单编号
     */
    public String getOrdNum() {
        return ordNum;
    }

    /**
     * 设置订单编号
     */
    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum == null ? null : ordNum.trim();
    }

    /**
     * 获取完成时间
     */
    public OffsetDateTime getFinishDate() {
        return finishDate;
    }

    /**
     * 设置完成时间
     */
    public void setFinishDate(OffsetDateTime finishDate) {
        this.finishDate = finishDate;
    }

    /**
     * 获取订单总金额
     */
    public Double getCommTotalPrice() {
        return commTotalPrice;
    }

    /**
     * 设置订单总金额
     */
    public void setCommTotalPrice(Double commTotalPrice) {
        this.commTotalPrice = commTotalPrice;
    }

    /**
     * 获取分账收入
     */
    public Double getSplitIncome() {
        return splitIncome;
    }

    /**
     * 设置分账收入
     */
    public void setSplitIncome(Double splitIncome) {
        this.splitIncome = splitIncome;
    }

	public String getSettleBillNumb() {
		return settleBillNumb;
	}

	public void setSettleBillNumb(String settleBillNumb) {
		this.settleBillNumb = settleBillNumb;
	}

	public Double getOrdFreight() {
		return ordFreight;
	}

	public void setOrdFreight(Double ordFreight) {
		this.ordFreight = ordFreight;
	}

	public Double getRefundPrice() {
		return refundPrice;
	}

	public void setRefundPrice(Double refundPrice) {
		this.refundPrice = refundPrice;
	}

	public Double getOperSerCharge() {
		return operSerCharge;
	}

	public void setOperSerCharge(Double operSerCharge) {
		this.operSerCharge = operSerCharge;
	}

	public Double getJsSerCost() {
		return jsSerCost;
	}

	public void setJsSerCost(Double jsSerCost) {
		this.jsSerCost = jsSerCost;
	}
}
