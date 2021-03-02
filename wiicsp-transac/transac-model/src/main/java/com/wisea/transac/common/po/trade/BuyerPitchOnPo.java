package com.wisea.transac.common.po.trade;
import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * BuyerDeleManyImportBillPo
 * 2020/05/06 15:40:35
 */
@ApiModel("选中的商品po")
public class BuyerPitchOnPo{

	@ApiModelProperty(value = "进货单进入为进货单id，以“，”分隔；直接购买时为商品规格id")
	@Check(test = "required")
	private String importBillIds;

	@ApiModelProperty(value = "商品数量")
    @Check(test = "logic", logic = "('0'.equals(#buyType))?#isNotEmpty(#count):true", logicMsg = "商品数量不能为空")
    private int count;

	@ApiModelProperty(value = "立即购买0，进货单进入为1")
	@Check(test = "required")
    private String buyType;

	@ApiModelProperty(value = "交易类型，产地交易、同城交易")
    private String transType;

    @ApiModelProperty(value = "商品价格")
    private Double price;

	@ApiModelProperty(hidden=true)
	private Long membId;

    public String getImportBillIds() {
        return importBillIds;
    }

    public void setImportBillIds(String importBillIds) {
        this.importBillIds = importBillIds;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getBuyType() {
        return buyType;
    }

    public void setBuyType(String buyType) {
        this.buyType = buyType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }
}
