package com.wisea.transac.common.po.product;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.javers.core.metamodel.annotation.DiffInclude;

import java.util.List;

/**
 * @Description: 商品价格信息列表
 * @author: wangs
 * @date :2020/5/7
 */
@ApiModel("商品价格信息列表")
public class LevelSpecQuoteMagePo {

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
    @DiffInclude
    @Check(test = "required", requiredMsg = "可售数量不能为空")
    private Double avaiSupplyCount;

    /**
     * 计量单位id
     */
    @ApiModelProperty("计量单位id")
    @DiffInclude
    @Check(test = "required", requiredMsg = "计量单位不能为空")
    private Long measUnitId;

    /**
     * 规格
     */
    @ApiModelProperty("规格")
    @DiffInclude
    @Check(test = "required", requiredMsg = "规格不能为空")
    private String spec;

    /**
     * 净重
     */
    @ApiModelProperty("净重")
    @DiffInclude
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

    @ApiModelProperty("删除标记")
    private String delFalg;

    @ApiModelProperty("商品等级对应的区间价格")
    private List<CommPricePo> commPricePo;

    public String getDelFalg() {
        return delFalg;
    }

    public void setDelFalg(String delFalg) {
        this.delFalg = delFalg;
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
