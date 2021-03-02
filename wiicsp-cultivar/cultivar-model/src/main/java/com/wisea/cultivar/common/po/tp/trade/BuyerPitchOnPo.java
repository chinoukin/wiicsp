package com.wisea.cultivar.common.po.tp.trade;
import java.util.List;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * BuyerDeleManyImportBillPo
 * 2018/09/18 17:40:35
 */
@ApiModel("选中的商品po")
public class BuyerPitchOnPo{

	@ApiModelProperty(value = "进货单进入为进货单id，以“，”分隔；直接购买时为商品id")
	@Check(test = "required")
	private String importBillIds;

	@ApiModelProperty(value = "商品数量")
    @Check(test = "logic", logic = "('0'.equals(#buyType) && '0'.equals(#quotMethodType))?#isNotEmpty(#count):true", logicMsg = "商品数量不能为空")
    private int count;

	@ApiModelProperty(value = "商品发布类型(0:大宗单品。1：中小零批)")
	@Check(test = "required")
	private String commPubType;

	@ApiModelProperty(value = "报价方式")
	@Check(test = "logic", logic = "'0'.equals(#buyType)?#isNotEmpty(#quotMethodType):true", logicMsg = "报价方式不能为空")
    private String quotMethodType;

	@ApiModelProperty(value = "立即购买0，进货单进入为1")
	@Check(test = "required")
    private String buyType;

	@ApiModelProperty(value = "商品规格列表")
    @Check(test = "logic", logic = "'1'.equals(#quotMethodType)?#isNotEmpty(#commSpecList):true", logicMsg = "商品规格列表不能为空", cascade=true)
    private List<BuyerImportBillCommSpecPo> commSpecList;

	@ApiModelProperty(hidden=true)
	private Long membId;

	public String getImportBillIds() {
		return importBillIds;
	}

	public void setImportBillIds(String importBillIds) {
		this.importBillIds = importBillIds;
	}

	public String getBuyType() {
		return buyType;
	}

	public void setBuyType(String buyType) {
		this.buyType = buyType;
	}

	public Long getMembId() {
		return membId;
	}

	public void setMembId(Long membId) {
		this.membId = membId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getCommPubType() {
		return commPubType;
	}

	public void setCommPubType(String commPubType) {
		this.commPubType = commPubType;
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
