package com.wisea.transac.common.vo.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 进货单修改商品数量
 */
@ApiModel("进货单修改商品数量")
public class BuyerUpdateCountVo {

	@ApiModelProperty("数量")
    private Integer count;

	@ApiModelProperty("商品状态类型")
	private String commStateType;

	@ApiModelProperty(value="失效、价格变动flag 0：正常；1：商品或规格信息变动；2：价格变动")
    private String versionFlag;

	@ApiModelProperty(value = "起批量")
    private int statCount;
    @ApiModelProperty(value = "同一个区间最小值")
    private int minCount;
    @ApiModelProperty(value = "同一个区间最大值")
    private int maxCount;
	@ApiModelProperty(value="单价")
    private Double isPrice;
    @ApiModelProperty(value="最新单价")
    private Double commPrice;
    @ApiModelProperty(value="单个商品总价")
    private Double totalPrice;
    @ApiModelProperty(value="单价/每单位")
    private Double prePrice;
    @ApiModelProperty(value="可售数量")
    private Double avaiSupplyCount;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Double getIsPrice() {
        return isPrice;
    }

    public void setIsPrice(Double isPrice) {
        this.isPrice = isPrice;
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

    public Double getPrePrice() {
        return prePrice;
    }

    public void setPrePrice(Double prePrice) {
        this.prePrice = prePrice;
    }

    public String getVersionFlag() {
        return versionFlag;
    }

    public void setVersionFlag(String versionFlag) {
        this.versionFlag = versionFlag;
    }

    public String getCommStateType() {
        return commStateType;
    }

    public void setCommStateType(String commStateType) {
        this.commStateType = commStateType;
    }

    public int getStatCount() {
        return statCount;
    }

    public void setStatCount(int statCount) {
        this.statCount = statCount;
    }

    public int getMinCount() {
        return minCount;
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

    public Double getAvaiSupplyCount() {
        return avaiSupplyCount;
    }

    public void setAvaiSupplyCount(Double avaiSupplyCount) {
        this.avaiSupplyCount = avaiSupplyCount;
    }
}

