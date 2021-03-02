package com.wisea.transac.common.vo.trade;

import java.time.OffsetDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("进货单商品列表vo")
public class ImportCommListVo {

    @ApiModelProperty(value="进货单id")
    private Long id;
    @ApiModelProperty(value="买家id")
    private Long membId;
    @ApiModelProperty(value="卖家id")
    private Long sellerId;
    @ApiModelProperty(value="档口id")
    private Long stallsMageId;
    @ApiModelProperty(value="市场id")
    private Long wholeSaleMarketId;
    @ApiModelProperty(value="买家采购员id")
    private Long purchaseStaffId;
    @ApiModelProperty(value="购买数量id")
    private Integer count;
    @ApiModelProperty(value="规格")
    private String commSpec;
    @ApiModelProperty(value="商品发布id")
    private Long commPubId;
    @ApiModelProperty(value="商品规格id")
    private Long levelSpecQuoteId;
    @ApiModelProperty(value="进货单价格表达式")
    private String price;
    @ApiModelProperty(value="加入日期")
    private OffsetDateTime joinTime;
    @ApiModelProperty(value="进货单等级版本号")
    private String levelSpecQuoteVersionNum;
    @ApiModelProperty(value="进货单商品版本号")
    private String commVersionNum;
    @ApiModelProperty(value="净重")
    private Double netWeight;
    @ApiModelProperty(value="单位")
    private String measUnit;
    @ApiModelProperty(value="所属量纲")
    private String dimensionsType;
    @ApiModelProperty(value="规格版本号")
    private String levelVersion;
    @ApiModelProperty(value="价格表达式")
    private String priceExpres;
    @ApiModelProperty(value="可售数量")
    private Double avaiSupplyCount;
    @ApiModelProperty(value="商品标题")
    private String commTitle;
    @ApiModelProperty(value="商品状态")
    private String commStateType;
    @ApiModelProperty(value="商品版本号")
    private String commVersion;
    @ApiModelProperty(value="单价")
    private Double isPrice;
    @ApiModelProperty(value="最新单价")
    private Double commPrice;
    @ApiModelProperty(value="单个商品总价")
    private Double totalPrice;
    @ApiModelProperty(value="单价/每单位")
    private Double prePrice;
    @ApiModelProperty(value="失效、价格变动flag 0：正常；1：商品或规格信息变动；2：价格变动；3：不是同个市场")
    private String versionFlag;
    @ApiModelProperty(value="商品图片")
    private String commUrl;
    @ApiModelProperty(value = "起批量")
    private int statCount;
    @ApiModelProperty(value = "同一个区间最小值")
    private int minCount;
    @ApiModelProperty(value = "同一个区间最大值")
    private int maxCount;
    @ApiModelProperty(value="销量")
    private Double salesVolume;
    @ApiModelProperty(value="成交金额")
    private Double transactionAmount;
    @ApiModelProperty(value="基地ID")
    private Long baseId;
    @ApiModelProperty(value="商品服务表达式")
    private String serTypeExpres;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDimensionsType() {
        return dimensionsType;
    }
    public void setDimensionsType(String dimensionsType) {
        this.dimensionsType = dimensionsType;
    }
    public Long getStallsMageId() {
        return stallsMageId;
    }
    public void setStallsMageId(Long stallsMageId) {
        this.stallsMageId = stallsMageId;
    }
    public Long getBaseId() {
        return baseId;
    }
    public void setBaseId(Long baseId) {
        this.baseId = baseId;
    }
    public Long getSellerId() {
        return sellerId;
    }
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
    public Double getTransactionAmount() {
        return transactionAmount;
    }
    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
    public Long getLevelSpecQuoteId() {
        return levelSpecQuoteId;
    }
    public void setLevelSpecQuoteId(Long levelSpecQuoteId) {
        this.levelSpecQuoteId = levelSpecQuoteId;
    }
    public Double getSalesVolume() {
        return salesVolume;
    }
    public void setSalesVolume(Double salesVolume) {
        this.salesVolume = salesVolume;
    }
    public Double getCommPrice() {
        return commPrice;
    }
    public void setCommPrice(Double commPrice) {
        this.commPrice = commPrice;
    }
    public Double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public int getMinCount() {
        return minCount;
    }

    public String getSerTypeExpres() {
        return serTypeExpres;
    }

    public void setSerTypeExpres(String serTypeExpres) {
        this.serTypeExpres = serTypeExpres;
    }

    public void setMinCount(int minCount) {
        this.minCount = minCount;
    }
    public int getMaxCount() {
        return maxCount;
    }
    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }
    public int getStatCount() {
        return statCount;
    }
    public void setStatCount(int statCount) {
        this.statCount = statCount;
    }
    public Long getMembId() {
        return membId;
    }
    public void setMembId(Long membId) {
        this.membId = membId;
    }
    public Double getPrePrice() {
        return prePrice;
    }
    public void setPrePrice(Double prePrice) {
        this.prePrice = prePrice;
    }
    public Long getPurchaseStaffId() {
        return purchaseStaffId;
    }
    public void setPurchaseStaffId(Long purchaseStaffId) {
        this.purchaseStaffId = purchaseStaffId;
    }
    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }
    public String getCommSpec() {
        return commSpec;
    }
    public void setCommSpec(String commSpec) {
        this.commSpec = commSpec;
    }
    public Long getCommPubId() {
        return commPubId;
    }
    public void setCommPubId(Long commPubId) {
        this.commPubId = commPubId;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public OffsetDateTime getJoinTime() {
        return joinTime;
    }
    public void setJoinTime(OffsetDateTime joinTime) {
        this.joinTime = joinTime;
    }
    public String getLevelSpecQuoteVersionNum() {
        return levelSpecQuoteVersionNum;
    }
    public void setLevelSpecQuoteVersionNum(String levelSpecQuoteVersionNum) {
        this.levelSpecQuoteVersionNum = levelSpecQuoteVersionNum;
    }

    public Long getWholeSaleMarketId() {
        return wholeSaleMarketId;
    }

    public void setWholeSaleMarketId(Long wholeSaleMarketId) {
        this.wholeSaleMarketId = wholeSaleMarketId;
    }

    public String getCommVersionNum() {
        return commVersionNum;
    }
    public void setCommVersionNum(String commVersionNum) {
        this.commVersionNum = commVersionNum;
    }
    public Double getNetWeight() {
        return netWeight;
    }
    public void setNetWeight(Double netWeight) {
        this.netWeight = netWeight;
    }
    public String getMeasUnit() {
        return measUnit;
    }
    public void setMeasUnit(String measUnit) {
        this.measUnit = measUnit;
    }
    public String getLevelVersion() {
        return levelVersion;
    }
    public void setLevelVersion(String levelVersion) {
        this.levelVersion = levelVersion;
    }
    public String getPriceExpres() {
        return priceExpres;
    }
    public void setPriceExpres(String priceExpres) {
        this.priceExpres = priceExpres;
    }
    public Double getAvaiSupplyCount() {
        return avaiSupplyCount;
    }
    public void setAvaiSupplyCount(Double avaiSupplyCount) {
        this.avaiSupplyCount = avaiSupplyCount;
    }
    public String getCommTitle() {
        return commTitle;
    }
    public void setCommTitle(String commTitle) {
        this.commTitle = commTitle;
    }
    public String getCommStateType() {
        return commStateType;
    }
    public void setCommStateType(String commStateType) {
        this.commStateType = commStateType;
    }
    public String getCommVersion() {
        return commVersion;
    }
    public void setCommVersion(String commVersion) {
        this.commVersion = commVersion;
    }
    public Double getIsPrice() {
        return isPrice;
    }
    public void setIsPrice(Double isPrice) {
        this.isPrice = isPrice;
    }
    public String getVersionFlag() {
        return versionFlag;
    }
    public void setVersionFlag(String versionFlag) {
        this.versionFlag = versionFlag;
    }
    public String getCommUrl() {
        return commUrl;
    }
    public void setCommUrl(String commUrl) {
        this.commUrl = commUrl;
    }
}
