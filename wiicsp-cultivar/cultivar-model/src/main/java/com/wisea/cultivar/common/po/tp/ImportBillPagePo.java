package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cultivar.common.vo.tp.ImportBillListVo;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;
import io.swagger.annotations.ApiModelProperty;

/**
 * ImportBillPagePo
 * 2018/09/19 16:06:10
 */
public class ImportBillPagePo extends PagePo<ImportBillListVo> {
    private static final long serialVersionUID = 1L;

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
     * 会员id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "会员id")
    private Long membId;

    /**
     * 卖方ID
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "卖方ID")
    private Long sellerId;

    /**
     * 数量
     */
    @ApiModelProperty(value = "数量")
    private Integer count;

    /**
     * 批发价
     */
    @ApiModelProperty(value = "批发价")
    private Double price;

    /**
     * 代理价
     */
    @ApiModelProperty(value = "代理价")
    private Double agentPrice;

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
     * 获取会员id
     */
    public Long getMembId() {
        return membId;
    }

    /**
     * 设置会员id
     */
    public void setMembId(Long membId) {
        this.membId = membId;
    }

    /**
     * 获取卖方ID
     */
    public Long getSellerId() {
        return sellerId;
    }

    /**
     * 设置卖方ID
     */
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    /**
     * 获取数量
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置数量
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 获取批发价
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置批发价
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 获取代理价
     */
    public Double getAgentPrice() {
        return agentPrice;
    }

    /**
     * 设置代理价
     */
    public void setAgentPrice(Double agentPrice) {
        this.agentPrice = agentPrice;
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
