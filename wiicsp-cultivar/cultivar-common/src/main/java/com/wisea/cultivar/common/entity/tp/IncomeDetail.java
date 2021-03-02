package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

/**
 * income_detail 表实体
 * 收入明细
 * 2019/01/23 10:21:32
 */
public class IncomeDetail extends DataLongEntity<IncomeDetail> {
    private static final long serialVersionUID = 1L;

    /**
     * 会员id
     */
    private Long membId;

    /**
     * 交易流水号
     */
    private String tradeNo;

    /**
     * 订单编号
     */
    private String ordNum;

    /**
     * 完成时间
     */
    private OffsetDateTime finishDate;

    /**
     * 订单总金额
     */
    private Double commTotalPrice;

    /**
     * 分账收入
     */
    private Double splitIncome;

    /**
     * 账单编号
     */
    private String settleBillNumb;

    /**
     * 订单运费
     */
    private Double ordFreight;

    /**
     * 退货退款金额
     */
    private Double refundPrice;

    /**
     * 运营服务费
     */
    private Double operSerCharge;

    /**
     * 技术服务费
     */
    private Double jsSerCost;

    /**
     * 账单编号
     */
    private String ordSourceType;

    /**
     * 获取会员id
     */
    public Long getMembId() {
        return membId;
    }

    /**
     * 设置会员id
     */
    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getOrdSourceType() {
		return ordSourceType;
	}

	public void setOrdSourceType(String ordSourceType) {
		this.ordSourceType = ordSourceType;
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
