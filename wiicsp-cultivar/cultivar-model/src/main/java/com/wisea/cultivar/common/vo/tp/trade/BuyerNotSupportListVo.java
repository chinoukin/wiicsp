package com.wisea.cultivar.common.vo.tp.trade;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 不支持商品列表
 */
@ApiModel("不支持商品列表")
public class BuyerNotSupportListVo {

	@ApiModelProperty("不支持商品信息")
	private List<BuyerNotSupportMsgListVo> buyerNotSupportMsgListVo;

	@ApiModelProperty("未授权商家")
	private List<String> buyerNotSupportSel;

	@ApiModelProperty("已授权冻结商家")
	private List<String> buyerSupportSel;

	public List<BuyerNotSupportMsgListVo> getBuyerNotSupportMsgListVo() {
		return buyerNotSupportMsgListVo;
	}

	public void setBuyerNotSupportMsgListVo(List<BuyerNotSupportMsgListVo> buyerNotSupportMsgListVo) {
		this.buyerNotSupportMsgListVo = buyerNotSupportMsgListVo;
	}

	public List<String> getBuyerNotSupportSel() {
		return buyerNotSupportSel;
	}

	public void setBuyerNotSupportSel(List<String> buyerNotSupportSel) {
		this.buyerNotSupportSel = buyerNotSupportSel;
	}

	public List<String> getBuyerSupportSel() {
		return buyerSupportSel;
	}

	public void setBuyerSupportSel(List<String> buyerSupportSel) {
		this.buyerSupportSel = buyerSupportSel;
	}
}
