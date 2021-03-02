package com.wisea.cultivar.common.po.tp.trade;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * BuyerInsertToImportBillPo
 */
@ApiModel("买家端生成订单时商品信息po")
public class BuyerToOrderPo{

	@ApiModelProperty(value = "商品id")
	@Check(test = "required")
	private Long commpubId;
	@ApiModelProperty(value = "报价方式")
	@Check(test = "required")
    private String quotMethodType;
	@ApiModelProperty(value = "商品规格")
	@Check(test = "logic", logic = "'1'.equals(#quotMethodType)?#isNotEmpty(#commSpec):true", logicMsg = "商品规格不能为空", cascade=true)
    private Double commSpec;
    @ApiModelProperty(value = "商品等级")
    @Check(test = "logic", logic = "'1'.equals(#quotMethodType)?#isNotEmpty(#commLevelType):true", logicMsg = "商品等级不能为空", cascade=true)
    private String commLevelType;
    @ApiModelProperty(value = "商品数量")
    private int count;
    @ApiModelProperty(value = "商品价格")
    @Check(test = "logic", logic = "'1'.equals(#quotMethodType)?#isNotEmpty(#price):true", logicMsg = "商品价格不能为空")
    private Double price;

	public Long getCommpubId() {
		return commpubId;
	}
	public void setCommpubId(Long commpubId) {
		this.commpubId = commpubId;
	}
	public String getQuotMethodType() {
		return quotMethodType;
	}
	public void setQuotMethodType(String quotMethodType) {
		this.quotMethodType = quotMethodType;
	}
	public Double getCommSpec() {
		return commSpec;
	}
	public void setCommSpec(Double commSpec) {
		this.commSpec = commSpec;
	}
	public String getCommLevelType() {
		return commLevelType;
	}
	public void setCommLevelType(String commLevelType) {
		this.commLevelType = commLevelType;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}
