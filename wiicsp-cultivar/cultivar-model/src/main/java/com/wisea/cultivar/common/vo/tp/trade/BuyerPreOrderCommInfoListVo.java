package com.wisea.cultivar.common.vo.tp.trade;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 进货单的商品列表信息
 */
@ApiModel("进货单的商品列表信息")
public class BuyerPreOrderCommInfoListVo {

	/*@ApiModelProperty("主键ID")
	@JsonSerialize(using = IdSerializer.class)
	private Long id;*/

	@ApiModelProperty("商家名称")
    private String membName;

	@ApiModelProperty("商家ID")
	private Long membId;

	@ApiModelProperty("运费")
	private Double freight;

	@ApiModelProperty("进货单中 商家下的商品信息")
	private List<BuyerImportBillCommMsgListVo> importBillCommMsgList;

	public Double getFreight() {
		return freight;
	}

	public void setFreight(Double freight) {
		this.freight = freight;
	}

	public String getMembName() {
		return membName;
	}

	public void setMembName(String membName) {
		this.membName = membName;
	}

	public List<BuyerImportBillCommMsgListVo> getImportBillCommMsgList() {
		return importBillCommMsgList;
	}

	public void setImportBillCommMsgList(List<BuyerImportBillCommMsgListVo> importBillCommMsgList) {
		this.importBillCommMsgList = importBillCommMsgList;
	}

	public Long getMembId() {
		return membId;
	}

	public void setMembId(Long membId) {
		this.membId = membId;
	}
}

