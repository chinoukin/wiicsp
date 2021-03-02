package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author:Liangzy(Wisea)
 * @Date:Create in 2018/9/20 下午4:47
 * @Description:修改商品代理价PO
 */
public class modifyCommAgentPricePo {

    /**
     * 商品id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商品id")
    private Long id;

    /**
     * 代理结算价指定方式
     */
    @ApiModelProperty(value = "代理结算价指定方式")
    private String agentSettType;

    /**
     * 代理结算值（可为：固定值/小数）
     */
    @ApiModelProperty(value = "代理结算值")
    private String agentPrice;

    /**
     * 结算价
     */
    @ApiModelProperty(value = "结算价")
    private Double price;

    /**
     * 数量
     */
    @ApiModelProperty(value = "数量")
    private String num;

    /**
     * 代理结算价表达式
     */
    @ApiModelProperty(value = "代理结算价表达式")
    private String agentWholePrice;

    /**
     * 代理结算价显示区间
     */
    @ApiModelProperty(value = "代理结算价显示区间")
    private String agentWholePriceSection;

    /**
     * 原始代理结算价显示区间
     */
    @ApiModelProperty(value = "原始代理结算价显示区间")
    private String originalAgentPrice;

    public String getOriginalAgentPrice() {
        return originalAgentPrice;
    }

    public void setOriginalAgentPrice(String originalAgentPrice) {
        this.originalAgentPrice = originalAgentPrice;
    }

    public String getAgentWholePriceSection() {
        return agentWholePriceSection;
    }

    public void setAgentWholePriceSection(String agentWholePriceSection) {
        this.agentWholePriceSection = agentWholePriceSection;
    }

    public String getAgentWholePrice() {
        return agentWholePrice;
    }

    public void setAgentWholePrice(String agentWholePrice) {
        this.agentWholePrice = agentWholePrice;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAgentSettType() {
        return agentSettType;
    }

    public void setAgentSettType(String agentSettType) {
        this.agentSettType = agentSettType;
    }

    public String getAgentPrice() {
        return agentPrice;
    }

    public void setAgentPrice(String agentPrice) {
        this.agentPrice = agentPrice;
    }
}
