package com.wisea.cultivar.common.po.tp.system;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.tp.system.SellerSpeSerCostMageListVo;
import io.swagger.annotations.ApiModelProperty;

/**
 * SellerSpeSerCostMagePagePo
 * 2019/01/14 13:49:31
 */
public class SellerSpeSerCostMagePagePo extends PagePo<SellerSpeSerCostMageListVo> {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 卖家id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "卖家id")
    private Long sellerId;

    /**
     * 买家id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "买家id")
    private Long buyerId;

    /**
     * 服务费
     */
    @ApiModelProperty(value = "服务费")
    private Double serCost;

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
     * 企业名称
     */
    @ApiModelProperty(value = "企业名称")
    private String compName;

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

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
     * 获取卖家id
     */
    public Long getSellerId() {
        return sellerId;
    }

    /**
     * 设置卖家id
     */
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    /**
     * 获取买家id
     */
    public Long getBuyerId() {
        return buyerId;
    }

    /**
     * 设置买家id
     */
    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    /**
     * 获取服务费
     */
    public Double getSerCost() {
        return serCost;
    }

    /**
     * 设置服务费
     */
    public void setSerCost(Double serCost) {
        this.serCost = serCost;
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
