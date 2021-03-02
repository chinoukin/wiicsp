package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;
import java.time.OffsetDateTime;

public class IncomeDetail extends DataLongEntity<IncomeDetail> {
    /**
     * 会员id
     */
    private Long membId;

    /**
     * 买家ID
     */
    private Long buyerId;


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
     * 订单来源类型
     */
    private String ordSourceType;

    /**
     * 订单结算单id
     */
    private Long settOrdId;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
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

    public String getOrdSourceType() {
        return ordSourceType;
    }

    public void setOrdSourceType(String ordSourceType) {
        this.ordSourceType = ordSourceType;
    }

    public Long getSettOrdId() {
        return settOrdId;
    }

    public void setSettOrdId(Long settOrdId) {
        this.settOrdId = settOrdId;
    }
}
