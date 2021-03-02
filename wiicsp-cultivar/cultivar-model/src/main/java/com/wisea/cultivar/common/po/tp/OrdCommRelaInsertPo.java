package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * OrdCommRelaInsertPo
 * 2018/09/18 17:40:35
 */
public class OrdCommRelaInsertPo {
    /**
     * 订单id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "订单id")
    private Long ordId;

    /**
     * 进货单id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "进货单id")
    private Long importBillId;

    /**
     * 商品发布id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "商品发布id")
    private Long commPubId;

    /**
     * 数量
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "数量")
    private Integer count;

    /**
     * 单价（代理价就是结算价）
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "单价（代理价就是结算价）")
    private Double price;

    /**
     * 平台服务费
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "平台服务费")
    private Double platfCost;

    /**
     * 商品名称
     */
    @Check(test = { "maxLength" }, mixLength = 100)
    @ApiModelProperty(value = "商品名称")
    private String commName;

    /**
     * 商品规格
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "商品规格")
    private Double commSpec;

    /**
     * 批发价
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "批发价")
    private Double wholePrice;

    /**
     * 商品图片
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "商品图片")
    private String commUrl;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 获取订单id
     */
    public Long getOrdId() {
        return ordId;
    }

    /**
     * 设置订单id
     */
    public void setOrdId(Long ordId) {
        this.ordId = ordId;
    }

    /**
     * 获取进货单id
     */
    public Long getImportBillId() {
        return importBillId;
    }

    /**
     * 设置进货单id
     */
    public void setImportBillId(Long importBillId) {
        this.importBillId = importBillId;
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
     * 获取单价（代理价就是结算价）
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置单价（代理价就是结算价）
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 获取平台服务费
     */
    public Double getPlatfCost() {
        return platfCost;
    }

    /**
     * 设置平台服务费
     */
    public void setPlatfCost(Double platfCost) {
        this.platfCost = platfCost;
    }

    /**
     * 获取商品名称
     */
    public String getCommName() {
        return commName;
    }

    /**
     * 设置商品名称
     */
    public void setCommName(String commName) {
        this.commName = commName == null ? null : commName.trim();
    }

    /**
     * 获取商品规格
     */
    public Double getCommSpec() {
        return commSpec;
    }

    /**
     * 设置商品规格
     */
    public void setCommSpec(Double commSpec) {
        this.commSpec = commSpec;
    }

    /**
     * 获取批发价
     */
    public Double getWholePrice() {
        return wholePrice;
    }

    /**
     * 设置批发价
     */
    public void setWholePrice(Double wholePrice) {
        this.wholePrice = wholePrice;
    }

    /**
     * 获取商品图片
     */
    public String getCommUrl() {
        return commUrl;
    }

    /**
     * 设置商品图片
     */
    public void setCommUrl(String commUrl) {
        this.commUrl = commUrl == null ? null : commUrl.trim();
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
}
