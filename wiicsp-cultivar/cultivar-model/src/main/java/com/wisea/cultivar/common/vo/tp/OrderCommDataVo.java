package com.wisea.cultivar.common.vo.tp;

import java.math.BigDecimal;

/**
 * @Author:Liangzy(Wisea)
 * @Date:Create in 2018/10/10 下午12:37
 * @Description:订单商品VO
 */
public class OrderCommDataVo {

    /**
     * 商品名称
     */
    private String commName;

    /**
     * 商品规格
     */
    private Double commSpec;

    /**
     * 计量单位名称
     */
    private String measUnitName;

    /**
     * 下单量
     */
    private Integer count;

    /**
     * 已退量
     */
    private Integer refundCounts;

    /**
     * 可开票量
     */
    private Integer canIssueInvoiceCounts;

    /**
     * 单价（代理价就是结算价）
     */
    private Double price;

    /**
     * 可开票金额
     */
    private Double canIssueInvoiceMoney;

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public Double getCommSpec() {
        return commSpec;
    }

    public void setCommSpec(Double commSpec) {
        this.commSpec = commSpec;
    }

    public String getMeasUnitName() {
        return measUnitName;
    }

    public void setMeasUnitName(String measUnitName) {
        this.measUnitName = measUnitName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getRefundCounts() {
        return refundCounts;
    }

    public void setRefundCounts(Integer refundCounts) {
        this.refundCounts = refundCounts;
    }

    public Integer getCanIssueInvoiceCounts() {
        return canIssueInvoiceCounts = count - refundCounts;
    }

    public void setCanIssueInvoiceCounts(Integer canIssueInvoiceCounts) {
        this.canIssueInvoiceCounts = canIssueInvoiceCounts;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getCanIssueInvoiceMoney() {
        if (canIssueInvoiceCounts == null) {
            canIssueInvoiceCounts = 0;
        }
        BigDecimal priceBigDecimal = BigDecimal.valueOf(price);
        BigDecimal canIssueInvoiceCountsBigDecimal = BigDecimal.valueOf(canIssueInvoiceCounts);
        BigDecimal multiply = priceBigDecimal.multiply(canIssueInvoiceCountsBigDecimal);
        return canIssueInvoiceMoney = Double.parseDouble(multiply.toString());
    }

    public void setCanIssueInvoiceMoney(Double canIssueInvoiceMoney) {
        this.canIssueInvoiceMoney = canIssueInvoiceMoney;
    }
}
