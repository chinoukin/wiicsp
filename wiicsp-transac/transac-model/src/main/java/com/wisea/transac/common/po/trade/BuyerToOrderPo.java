package com.wisea.transac.common.po.trade;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * BuyerInsertToImportBillPo
 */
@ApiModel("买家端生成订单时商品信息po")
public class BuyerToOrderPo{

	@ApiModelProperty(value = "商品规格id")
	@Check(test = "required")
	private Long levelSpecQuoteId;
    @ApiModelProperty(value = "商品数量")
    private int count;
    @ApiModelProperty(value = "商品价格")
    private Double isPrice;
    @ApiModelProperty(value="规格版本号")
    private String levelVersion;
    @ApiModelProperty(value="商品版本号")
    private String commVersion;

    public Long getLevelSpecQuoteId() {
        return levelSpecQuoteId;
    }
    public void setLevelSpecQuoteId(Long levelSpecQuoteId) {
        this.levelSpecQuoteId = levelSpecQuoteId;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public Double getIsPrice() {
        return isPrice;
    }
    public void setIsPrice(Double isPrice) {
        this.isPrice = isPrice;
    }
    public String getLevelVersion() {
        return levelVersion;
    }
    public void setLevelVersion(String levelVersion) {
        this.levelVersion = levelVersion;
    }
    public String getCommVersion() {
        return commVersion;
    }
    public void setCommVersion(String commVersion) {
        this.commVersion = commVersion;
    }
}
