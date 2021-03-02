package com.wisea.cultivar.common.vo;

import com.wisea.cultivar.common.po.product.CommPricePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Description:
 * @author: wangs
 * @date :2020/5/12
 */
@ApiModel("价格信息")
public class LevelSqecQuatePriceVo {

    /**
     * 商品规格id
     */
    @ApiModelProperty("商品规格id")
    private Long commLevelSpecId;

    /**
     * 商品发布id
     */
    @ApiModelProperty("商品发布id")
    private Long commPubId;

    /**
     * 可售数量
     */
    @ApiModelProperty("可售数量")
    private Double avaiSupplyCount;

    /**
     * 计量单位id
     */
    @ApiModelProperty("计量单位id")
    private Long measUnitId;

    /**
     * 计量单位名称
     */
    @ApiModelProperty("计量单位名称")
    private String measUnitName;

    /**
     * 计量单位类型
     */
    @ApiModelProperty("计量单位类型")
    private String measUnitType;

    @ApiModelProperty("计量单位转换系数")
    private Double measUnitTanXS;

    /**
     * 规格
     */
    @ApiModelProperty("规格")
    private String spec;

    /**
     * 净重
     */
    @ApiModelProperty("净重")
    private Double netWeight;

    /**
     * 起订区间表达式
     */
    @ApiModelProperty("起订区间表达式")
    private String startOrdExpres;

    /**
     * 价格表达式
     */
    @ApiModelProperty("价格表达式")
    private String priceExpres;

    /**
     * 版本号
     */
    @ApiModelProperty("版本号")
    private String versionNum;

    /**
     * 成交金额
     */
    @ApiModelProperty("成交金额")
    private Double transactionAmount;

    /**
     * 销量（kg）
     */
    @ApiModelProperty("销量（kg）")
    private Double salesVolume;

    @ApiModelProperty("库存量")
    private Double totalAvaliCount;

    @ApiModelProperty("净重吨数")
    private Double totalNetWeight;

    @ApiModelProperty("商品等级对应的区间价格")
    private List<CommPricePo> commPricePo;

    public Double getMeasUnitTanXS() {
        return measUnitTanXS;
    }

    public void setMeasUnitTanXS(Double measUnitTanXS) {
        this.measUnitTanXS = measUnitTanXS;
    }

    public String getMeasUnitType() {
        return measUnitType;
    }

    public void setMeasUnitType(String measUnitType) {
        this.measUnitType = measUnitType;
    }

    public Double getTotalAvaliCount() {
        return totalAvaliCount;
    }

    public void setTotalAvaliCount(Double totalAvaliCount) {
        this.totalAvaliCount = totalAvaliCount;
    }

    public Double getTotalNetWeight() {
        return totalNetWeight;
    }

    public void setTotalNetWeight(Double totalNetWeight) {
        this.totalNetWeight = totalNetWeight;
    }

    public String getMeasUnitName() {
        return measUnitName;
    }

    public void setMeasUnitName(String measUnitName) {
        this.measUnitName = measUnitName;
    }

    public Long getCommLevelSpecId() {
        return commLevelSpecId;
    }

    public void setCommLevelSpecId(Long commLevelSpecId) {
        this.commLevelSpecId = commLevelSpecId;
    }

    public List<CommPricePo> getCommPricePo() {
        return commPricePo;
    }

    public void setCommPricePo(List<CommPricePo> commPricePo) {
        this.commPricePo = commPricePo;
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
