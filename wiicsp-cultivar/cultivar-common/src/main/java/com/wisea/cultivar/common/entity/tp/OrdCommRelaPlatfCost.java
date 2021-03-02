package com.wisea.cultivar.common.entity.tp;

/**
 * @author jirg
 * @version 1.0
 * @className OrdCommRelaPlatfCost
 * @date 2019/5/16 10:52
 * @Description
 */
public class OrdCommRelaPlatfCost {
    /**
     * 订单商品ID
     */
    private Long ordCommRelaId;
    /**
     * 商品发布id
     */
    private Long commPubId;
    /**
     * 单价
     */
    private Double price;
    /**
     * 平台服务费
     */
    private Double platfCost;
    /**
     * 购买数量
     */
    private Integer count;
    /**
     * 品类ID
     */
    private Long commId;

    public Long getOrdCommRelaId() {
        return ordCommRelaId;
    }

    public void setOrdCommRelaId(Long ordCommRelaId) {
        this.ordCommRelaId = ordCommRelaId;
    }

    public Long getCommPubId() {
        return commPubId;
    }

    public void setCommPubId(Long commPubId) {
        this.commPubId = commPubId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPlatfCost() {
        return platfCost;
    }

    public void setPlatfCost(Double platfCost) {
        this.platfCost = platfCost;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }
}
