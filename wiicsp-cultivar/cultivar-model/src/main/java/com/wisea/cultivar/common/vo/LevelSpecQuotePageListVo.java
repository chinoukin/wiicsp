package com.wisea.cultivar.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页查询Vo")
public class LevelSpecQuotePageListVo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="商品发布id")
    private Long commPubId;

    @ApiModelProperty(value="可售数量")
    private Double avaiSupplyCount;

    @ApiModelProperty(value="计量单位id")
    private Long measUnitId;

    @ApiModelProperty(value="规格")
    private String spec;

    @ApiModelProperty(value="净重")
    private Double netWeight;

    @ApiModelProperty(value="起订区间表达式")
    private String startOrdExpres;

    @ApiModelProperty(value="价格表达式")
    private String priceExpres;

    @ApiModelProperty(value="版本号")
    private String versionNum;

    @ApiModelProperty(value="成交金额")
    private Double transactionAmount;

    @ApiModelProperty(value="销量（kg）")
    private Double salesVolume;

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

    public Double getAvaiSupplyCount() {
        return avaiSupplyCount;
    }

    public void setAvaiSupplyCount(Double avaiSupplyCount) {
        this.avaiSupplyCount = avaiSupplyCount;
    }

    public Long getMeasUnitId() {
        return measUnitId;
    }

    public void setMeasUnitId(Long measUnitId) {
        this.measUnitId = measUnitId;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Double getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(Double netWeight) {
        this.netWeight = netWeight;
    }

    public String getStartOrdExpres() {
        return startOrdExpres;
    }

    public void setStartOrdExpres(String startOrdExpres) {
        this.startOrdExpres = startOrdExpres;
    }

    public String getPriceExpres() {
        return priceExpres;
    }

    public void setPriceExpres(String priceExpres) {
        this.priceExpres = priceExpres;
    }

    public String getVersionNum() {
        return versionNum;
    }

    public void setVersionNum(String versionNum) {
        this.versionNum = versionNum;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Double getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(Double salesVolume) {
        this.salesVolume = salesVolume;
    }
}
