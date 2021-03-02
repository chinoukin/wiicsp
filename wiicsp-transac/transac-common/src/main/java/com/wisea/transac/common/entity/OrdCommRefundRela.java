package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class OrdCommRefundRela extends DataLongEntity<OrdCommRefundRela> {
    /**
     * 订单商品id
     */
    private Long ordCommRelaId;

    /**
     * 退款申请id
     */
    private Long refundApplId;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 单价
     */
    private Double price;

    /**
     * 商品规格
     */
    private String commSpec;

    /**
     * 退货重量
     */
    private Double refundWeight;

    /**
     * 计量单位名称
     */
    private String measUnitName;

    public Long getOrdCommRelaId() {
        return ordCommRelaId;
    }

    public void setOrdCommRelaId(Long ordCommRelaId) {
        this.ordCommRelaId = ordCommRelaId;
    }

    public Long getRefundApplId() {
        return refundApplId;
    }

    public void setRefundApplId(Long refundApplId) {
        this.refundApplId = refundApplId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCommSpec() {
        return commSpec;
    }

    public void setCommSpec(String commSpec) {
        this.commSpec = commSpec;
    }

    public Double getRefundWeight() {
        return refundWeight;
    }

    public void setRefundWeight(Double refundWeight) {
        this.refundWeight = refundWeight;
    }

    public String getMeasUnitName() {
        return measUnitName;
    }

    public void setMeasUnitName(String measUnitName) {
        this.measUnitName = measUnitName;
    }
}
