package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * level_spec_quote 表实体
 * 等级规格报价
 * 2019/08/20 10:18:34
 */
public class LevelSpecQuote extends DataLongEntity<LevelSpecQuote> {
    private static final long serialVersionUID = 1L;

    /**
     * 商品发布id
     */
    private Long commPubId;

    /**
     * 等级
     */
    private String level;

    /**
     * 规格
     */
    private Double spec;

    /**
     * 单价
     */
    private Double price;

    /**
     * 说明
     */
    private String content;

    /**
     * 起订量
     */
    private Integer startOrdCount;

    /**
     * 可售数量
     */
    private Double avaiSupplyCount;

    /**
     * 获取商品发布id
     */
    public Long getCommPubId() {
        return commPubId;
    }

    /**
     * 设置商品发布id
     */
    public void setCommPubId(Long commPubId) {
        this.commPubId = commPubId;
    }

    /**
     * 获取等级
     */
    public String getLevel() {
        return level;
    }

    /**
     * 设置等级
     */
    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public Double getSpec() {
        return spec;
    }

    public void setSpec(Double spec) {
        this.spec = spec;
    }

    /**
     * 获取单价
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置单价
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 获取说明
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置说明
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 获取起订量
     */
    public Integer getStartOrdCount() {
        return startOrdCount;
    }

    /**
     * 设置起订量
     */
    public void setStartOrdCount(Integer startOrdCount) {
        this.startOrdCount = startOrdCount;
    }

    public Double getAvaiSupplyCount() {
        return avaiSupplyCount;
    }

    public void setAvaiSupplyCount(Double avaiSupplyCount) {
        this.avaiSupplyCount = avaiSupplyCount;
    }
}
