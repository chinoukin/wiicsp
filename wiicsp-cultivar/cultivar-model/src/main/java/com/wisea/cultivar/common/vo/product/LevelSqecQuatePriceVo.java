package com.wisea.cultivar.common.vo.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
    @ApiModelProperty(value = "商品规格id")
    private Long commLevelSpecId;

    /**
     * 商品发布id
     */
    @ApiModelProperty(value = "商品发布id")
    private Long commPubInfo;


    /**
     * 计量单位id
     */
    @ApiModelProperty(value = "计量单位id")
    private Long measUnitId;

    /**
     * 计量单位名称
     */
    @ApiModelProperty(value = "计量单位名称")
    private String measUnitName;

    /**
     * 计量单位类型
     */
    @ApiModelProperty(value = "计量单位类型")
    private String measUnitType;

    /**
     * 规格
     */
    @ApiModelProperty(value = "规格")
    private String spec;


    /**
     * 起订区间表达式
     */
    @ApiModelProperty(value = "起订区间表达式")
    private String startOrdExpres;

    /**
     * 价格表达式
     */
    @ApiModelProperty(value = "价格表达式")
    private String priceExpres;


    /**
     * 销量（kg）
     */
    @ApiModelProperty(value = "销量（kg）")
    private Double salesVolume;


    public Long getCommLevelSpecId() {
        return commLevelSpecId;
    }

    public void setCommLevelSpecId(Long commLevelSpecId) {
        this.commLevelSpecId = commLevelSpecId;
    }

    public Long getCommPubInfo() {
        return commPubInfo;
    }

    public void setCommPubInfo(Long commPubInfo) {
        this.commPubInfo = commPubInfo;
    }

    public Long getMeasUnitId() {
        return measUnitId;
    }

    public void setMeasUnitId(Long measUnitId) {
        this.measUnitId = measUnitId;
    }

    public String getMeasUnitName() {
        return measUnitName;
    }

    public void setMeasUnitName(String measUnitName) {
        this.measUnitName = measUnitName;
    }

    public String getMeasUnitType() {
        return measUnitType;
    }

    public void setMeasUnitType(String measUnitType) {
        this.measUnitType = measUnitType;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
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

    public Double getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(Double salesVolume) {
        this.salesVolume = salesVolume;
    }

}
