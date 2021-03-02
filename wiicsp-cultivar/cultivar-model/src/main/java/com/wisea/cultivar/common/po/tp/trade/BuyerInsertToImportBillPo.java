package com.wisea.cultivar.common.po.tp.trade;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * BuyerInsertToImportBillPo
 * 2018/09/18 17:40:35
 */
@ApiModel("买家端加入进货单po")
public class BuyerInsertToImportBillPo{

	@JsonSerialize(using = IdSerializer.class)
	@ApiModelProperty(value = "商品发布ID")
	@Check(test = "required")
	private Long commPubId;

	@ApiModelProperty(value = "报价方式")
	@Check(test = "required")
    private String quotMethodType;

    @ApiModelProperty(value = "商品数量")
    @Check(test = "logic", logic = "'0'.equals(#quotMethodType)?#isNotEmpty(#count):true", logicMsg = "商品数量不能为空")
    private int count;

    @ApiModelProperty(value = "商品规格列表")
    @Check(test = "logic", logic = "'1'.equals(#quotMethodType)?#isNotEmpty(#commSpecList):true", logicMsg = "商品规格列表不能为空", cascade=true)
    private List<BuyerImportBillCommSpecPo> commSpecList;

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

	public String getQuotMethodType() {
		return quotMethodType;
	}

	public void setQuotMethodType(String quotMethodType) {
		this.quotMethodType = quotMethodType;
	}

	public List<BuyerImportBillCommSpecPo> getCommSpecList() {
		return commSpecList;
	}

	public void setCommSpecList(List<BuyerImportBillCommSpecPo> commSpecList) {
		this.commSpecList = commSpecList;
	}
}
