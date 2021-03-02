package com.wisea.transac.common.po.trade;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * BuyerInsertToImportBillPo
 */
@ApiModel("买家端加入进货单po")
public class BuyerInsertToImportBillPo{

	@JsonSerialize(using = IdSerializer.class)
	@ApiModelProperty(value = "商品发布ID")
	@Check(test = "required")
	private Long commPubId;

    @ApiModelProperty(value = "商品数量")
    @Check(test = "required")
    private int count;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "等级规格id")
    @Check(test = "required")
    private Long levelSpecQuoteId;

    public Long getCommPubId() {
        return commPubId;
    }

    public void setCommPubId(Long commPubId) {
        this.commPubId = commPubId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Long getLevelSpecQuoteId() {
        return levelSpecQuoteId;
    }

    public void setLevelSpecQuoteId(Long levelSpecQuoteId) {
        this.levelSpecQuoteId = levelSpecQuoteId;
    }
}
