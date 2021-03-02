package com.wisea.cultivar.common.entity.tp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Description: 按等级报价信息
 * @author: wangs
 * @date :2019/8/22
 */
@ApiModel("按等级报价信息")
public class CommLevelPo  implements Serializable {

    /**
     * 等价规格
     */
    @ApiModelProperty("等级规格")
    private String level;

    /**
     * 规格
     */
    @ApiModelProperty("规格")
    private Double spec;

    /**
     * 单价
     */
    @ApiModelProperty("单价")
    private Double price;

    /**
     * 说明
     */
    @ApiModelProperty("说明")
    private String content;

    /**
     * 起订量
     */
    @ApiModelProperty("起订量")
    private Integer startOrdCount;

    /**
     * 可售数量
     */
    @ApiModelProperty("可售数量")
    private Double avaiSupplyCount;

    /**
     * 排序字段
     */
    @ApiModelProperty("排序字段")
    private String remarks;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
}
