package com.wisea.cultivar.common.vo.tp.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 进货单修改商品数量
 */
@ApiModel("进货单修改商品数量")
public class BuyerUpdateCountVo {


	@ApiModelProperty("数量")
    private Integer count;

	@ApiModelProperty("批发价格表达式")
    private String wholePrice;

    @ApiModelProperty("代理价格表达式")
    private String agentWholePrice;

    @ApiModelProperty("批发价格")
    private ImportBillPriceOperateVo wPrice;

    @ApiModelProperty("代理价格")
    private ImportBillPriceOperateVo awPrice;

    @ApiModelProperty("库存量")
    private Integer stock;

	@ApiModelProperty("商品状态类型")
	private String commStateType;

	@ApiModelProperty("商品单价")
	private Double price;

	@ApiModelProperty("此商品总价格")
	private Double allPrice;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getWholePrice() {
		return wholePrice;
	}

	public void setWholePrice(String wholePrice) {
		this.wholePrice = wholePrice;
	}

	public String getAgentWholePrice() {
		return agentWholePrice;
	}

	public void setAgentWholePrice(String agentWholePrice) {
		this.agentWholePrice = agentWholePrice;
	}

	public ImportBillPriceOperateVo getwPrice() {
		return wPrice;
	}

	public void setwPrice(ImportBillPriceOperateVo wPrice) {
		this.wPrice = wPrice;
	}

	public ImportBillPriceOperateVo getAwPrice() {
		return awPrice;
	}

	public void setAwPrice(ImportBillPriceOperateVo awPrice) {
		this.awPrice = awPrice;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getCommStateType() {
		return commStateType;
	}

	public void setCommStateType(String commStateType) {
		this.commStateType = commStateType;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getAllPrice() {
		return allPrice;
	}

	public void setAllPrice(Double allPrice) {
		this.allPrice = allPrice;
	}
}

