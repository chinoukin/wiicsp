package com.wisea.cultivar.common.vo.tp.product;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * LevelSpecQuoteListVo
 * 2019/08/20 10:18:34
 */
public class LevelSpecQuoteListVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 商品发布id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商品发布id")
    private Long commPubId;

    /**
     * 等级
     */
    @ApiModelProperty(value = "等级")
    private String level;

    /**
     * 规格
     */
    @ApiModelProperty(value = "规格")
    private Double spec;

    /**
     * 单价
     */
    @ApiModelProperty(value = "单价")
    private Double price;

    /**
     * 说明
     */
    @ApiModelProperty(value = "说明")
    private String content;

    /**
     * 起订量
     */
    @ApiModelProperty(value = "起订量")
    private Integer startOrdCount;

    /**
     * 可售数量
     */
    @ApiModelProperty(value = "可售数量")
    private Double avaiSupplyCount;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    /**
     * 获取id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(Long id) {
        this.id = id;
    }

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

    /**
     * 获取备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 获取删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}
