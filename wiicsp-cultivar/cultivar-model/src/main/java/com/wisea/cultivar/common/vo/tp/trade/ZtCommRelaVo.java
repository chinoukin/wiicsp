package com.wisea.cultivar.common.vo.tp.trade;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className ZtCommRelaVo
 * @date 2019/5/13 17:29
 * @Description
 */
public class ZtCommRelaVo {
    @ApiModelProperty("订单商品ID")
    private Long id;
    @ApiModelProperty("商品发布ID")
    private Long commPubId;
    @ApiModelProperty("商品编号")
    private String commNum;
    @ApiModelProperty("商品名称")
    private String commName;
    @ApiModelProperty("商品货号")
    private String commArtNum;
    @ApiModelProperty("商品单价")
    private Double price;
    @ApiModelProperty("购买数量")
    private Integer count;
    @ApiModelProperty("商品计量单位")
    private String measUnitName;
    @ApiModelProperty("商品规格")
    private Double commSpec;
    @ApiModelProperty("商品图片")
    private String commUrl;
    @ApiModelProperty("商品单价小计")
    private Double priceCount;
    @ApiModelProperty(value = "服务费", hidden = true)
    private Double platfCost;

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

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public String getCommArtNum() {
        return commArtNum;
    }

    public void setCommArtNum(String commArtNum) {
        this.commArtNum = commArtNum;
    }

    public String getCommNum() {
        return commNum;
    }

    public void setCommNum(String commNum) {
        this.commNum = commNum;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getMeasUnitName() {
        return measUnitName;
    }

    public void setMeasUnitName(String measUnitName) {
        this.measUnitName = measUnitName;
    }

    public Double getCommSpec() {
        return commSpec;
    }

    public void setCommSpec(Double commSpec) {
        this.commSpec = commSpec;
    }

    public String getCommUrl() {
        return commUrl;
    }

    public void setCommUrl(String commUrl) {
        this.commUrl = commUrl;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPriceCount() {
        return priceCount;
    }

    public void setPriceCount(Double priceCount) {
        this.priceCount = priceCount;
    }

    public Double getPlatfCost() {
        return platfCost;
    }

    public void setPlatfCost(Double platfCost) {
        this.platfCost = platfCost;
    }
}
