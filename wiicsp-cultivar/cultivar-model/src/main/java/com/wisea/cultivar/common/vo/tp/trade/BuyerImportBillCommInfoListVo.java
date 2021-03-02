package com.wisea.cultivar.common.vo.tp.trade;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 进货单的商品列表信息
 */
@ApiModel("进货单的商品列表信息")
public class BuyerImportBillCommInfoListVo {

	/*@ApiModelProperty("主键ID")
	@JsonSerialize(using = IdSerializer.class)
	private Long id;*/

	@ApiModelProperty("商家名称")
    private String membName;

	@ApiModelProperty("商家ID")
	private Long membId;

	@ApiModelProperty("运费")
	private Double freight;

    @ApiModelProperty("可用额度")
    private Double availableCredit;

    @ApiModelProperty("商品总金额")
	private Double totalCommMoney;

    @ApiModelProperty("账期服务费")
	private Double zqSerCost;

    @ApiModelProperty("定金金额")
	private Double depositAmount;

    @ApiModelProperty("额度是否足够支付(0是足够，1是不够)")
    private String enoughPay;

	@ApiModelProperty("进货单中 商家下的商品信息")
	private List<BuyerImportBillCommMsgListVo> importBillCommMsgList;

	@ApiModelProperty(value="是否可以能开发票(nfkfp_type0:能1:不能)")
	private String nfkfpType;//是否可以能开发票(nfkfp_type0:能1:不能)
	@ApiModelProperty(value="发票内容")
	private String invoContent;// 发票内容
	@ApiModelProperty(value="发票类型,多个用逗号分隔（字典值invo_type）")
	private String invoType;// 发票类型（多个用逗号分隔）
	@ApiModelProperty(value="发票类型列表")
	private List<String> invoList;

	public Double getFreight() {
		return freight;
	}

	public void setFreight(Double freight) {
		this.freight = freight;
	}

	public Double getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(Double depositAmount) {
		this.depositAmount = depositAmount;
	}

	public Double getZqSerCost() {
		return zqSerCost;
	}

	public void setZqSerCost(Double zqSerCost) {
		this.zqSerCost = zqSerCost;
	}

	public Double getTotalCommMoney() {
		return totalCommMoney;
	}

	public void setTotalCommMoney(Double totalCommMoney) {
		this.totalCommMoney = totalCommMoney;
	}

	public String getEnoughPay() {
		return enoughPay;
	}

	public void setEnoughPay(String enoughPay) {
		this.enoughPay = enoughPay;
	}

	public Double getAvailableCredit() {
		return availableCredit;
	}

	public void setAvailableCredit(Double availableCredit) {
		this.availableCredit = availableCredit;
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

	public String getNfkfpType() {
		return nfkfpType;
	}

	public void setNfkfpType(String nfkfpType) {
		this.nfkfpType = nfkfpType;
	}

	public String getInvoContent() {
		return invoContent;
	}

	public void setInvoContent(String invoContent) {
		this.invoContent = invoContent;
	}

	public String getInvoType() {
		return invoType;
	}

	public void setInvoType(String invoType) {
		this.invoType = invoType;
	}

	public List<String> getInvoList() {
		return invoList;
	}

	public void setInvoList(List<String> invoList) {
		this.invoList = invoList;
	}
}

