package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

/**
 * refund_detail 表实体
 * 退款明细
 * 2019/01/23 10:21:32
 */
public class RefundDetail extends DataLongEntity<RefundDetail> {
    private static final long serialVersionUID = 1L;

    /**
     * 会员id
     */
    private Long membId;

    /**
     * 服务单号
     */
    private String serNum;

    /**
     * 订单编号
     */
    private String ordNum;

    /**
     * 交易时间
     */
    private OffsetDateTime tradeDate;

    /**
     * 申请金额
     */
    private Double applAmount;

    /**
     * 退款方式
     */
    private String refundModeType;

    /**
     * 退款金额
     */
    private Double refundAmount;

    /**
     * 退款、退货id
     */
    private Long refundMoneyId;

    /**
     * 退货退款标识(0，退款，1退货)
     */
    private String refundFlag;

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

    public Long getRefundMoneyId() {
		return refundMoneyId;
	}

	public void setRefundMoneyId(Long refundMoneyId) {
		this.refundMoneyId = refundMoneyId;
	}

	public String getRefundFlag() {
		return refundFlag;
	}

	public void setRefundFlag(String refundFlag) {
		this.refundFlag = refundFlag;
	}

	/**
     * 获取服务单号
     */
    public String getSerNum() {
        return serNum;
    }

    /**
     * 设置服务单号
     */
    public void setSerNum(String serNum) {
        this.serNum = serNum == null ? null : serNum.trim();
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
     * 获取交易时间
     */
    public OffsetDateTime getTradeDate() {
        return tradeDate;
    }

    /**
     * 设置交易时间
     */
    public void setTradeDate(OffsetDateTime tradeDate) {
        this.tradeDate = tradeDate;
    }

    /**
     * 获取申请金额
     */
    public Double getApplAmount() {
        return applAmount;
    }

    /**
     * 设置申请金额
     */
    public void setApplAmount(Double applAmount) {
        this.applAmount = applAmount;
    }

    /**
     * 获取退款方式
     */
    public String getRefundModeType() {
        return refundModeType;
    }

    /**
     * 设置退款方式
     */
    public void setRefundModeType(String refundModeType) {
        this.refundModeType = refundModeType == null ? null : refundModeType.trim();
    }

    /**
     * 获取退款金额
     */
    public Double getRefundAmount() {
        return refundAmount;
    }

    /**
     * 设置退款金额
     */
    public void setRefundAmount(Double refundAmount) {
        this.refundAmount = refundAmount;
    }
}
