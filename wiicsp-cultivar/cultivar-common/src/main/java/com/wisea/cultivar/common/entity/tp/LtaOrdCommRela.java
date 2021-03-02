package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

public class LtaOrdCommRela extends DataLongEntity<LtaOrdCommRela> {
    /**
     * 长协订单id
     */
    private Long ltaOrdId;

    /**
     * 长协商品信息id
     */
    private Long ltaCommRelaId;

    /**
     * 长协商品包装id
     */
    private Long ltaCommPackId;

    /**
     * 等级
     */
    private String level;

    /**
     * 规格
     */
    private String spec;

    /**
     * 数量
     */
    private Integer slNum;

    /**
     * 单价
     */
    private Double price;

    /**
     * 平台服务费
     */
    private Double platfCost;

    public Long getLtaOrdId() {
        return ltaOrdId;
    }

    public void setLtaOrdId(Long ltaOrdId) {
        this.ltaOrdId = ltaOrdId;
    }

    public Long getLtaCommRelaId() {
        return ltaCommRelaId;
    }

    public void setLtaCommRelaId(Long ltaCommRelaId) {
        this.ltaCommRelaId = ltaCommRelaId;
    }

    public Long getLtaCommPackId() {
        return ltaCommPackId;
    }

    public void setLtaCommPackId(Long ltaCommPackId) {
        this.ltaCommPackId = ltaCommPackId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Integer getSlNum() {
        return slNum;
    }

    public void setSlNum(Integer slNum) {
        this.slNum = slNum;
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
}
