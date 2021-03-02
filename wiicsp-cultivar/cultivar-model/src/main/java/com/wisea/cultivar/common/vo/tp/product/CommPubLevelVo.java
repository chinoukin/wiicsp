package com.wisea.cultivar.common.vo.tp.product;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description:
 * @author: wangs
 * @date :2019/8/29
 */
public class CommPubLevelVo {

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommPubId() {
        return commPubId;
    }

    public void setCommPubId(Long commPubId) {
        this.commPubId = commPubId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Double getSpec() {
        return spec;
    }

    public void setSpec(Double spec) {
        this.spec = spec;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStartOrdCount() {
        return startOrdCount;
    }

    public void setStartOrdCount(Integer startOrdCount) {
        this.startOrdCount = startOrdCount;
    }

    public Double getAvaiSupplyCount() {
        return avaiSupplyCount;
    }

    public void setAvaiSupplyCount(Double avaiSupplyCount) {
        this.avaiSupplyCount = avaiSupplyCount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
