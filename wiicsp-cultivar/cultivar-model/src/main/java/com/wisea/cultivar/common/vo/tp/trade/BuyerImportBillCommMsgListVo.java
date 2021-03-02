package com.wisea.cultivar.common.vo.tp.trade;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 进货单的商品列表信息
 */
@ApiModel("进货单的商品列表信息")
public class BuyerImportBillCommMsgListVo {

	@ApiModelProperty("商品ID")
	@JsonSerialize(using = IdSerializer.class)
	private Long id;

	@ApiModelProperty("主键进货单ID")
	@JsonSerialize(using = IdSerializer.class)
	private Long importBillId;

	@ApiModelProperty("商品名称")
    private String commName;

	@ApiModelProperty("商品规格")
    private Double commSpec;

	@ApiModelProperty("数量")
    private Integer count;

	@ApiModelProperty("批发价格表达式")
    private String wholePrice;

    @ApiModelProperty("代理价格表达式")
    private String agentWholePrice;

    @ApiModelProperty("批发价格")
    private ImportBillPriceOperateVo wPrice;

    @ApiModelProperty("批发价格all")
    private List<ImportBillPriceOperateVo> wPriceList;

    @ApiModelProperty("代理价格all")
    private List<ImportBillPriceOperateVo> awPriceList;

    @ApiModelProperty("代理价格")
    private ImportBillPriceOperateVo awPrice;

    @ApiModelProperty("库存量")
    private Integer stock;

    @ApiModelProperty("最小起订量")
    private Integer startOrdCount;

	@ApiModelProperty("商品状态类型")
	private String commStateType;

	@ApiModelProperty("计量单位名称")
	private String measUnitName;

	@ApiModelProperty("图片地址")
	private String url;

	@ApiModelProperty("商品单价")
	private Double price;

	@ApiModelProperty("是否收藏")
	private Boolean ifCollect;

	@ApiModelProperty("代理状态")
    private String agentStateType;

	@ApiModelProperty("商品总价格")
	private double allPrice;

	@ApiModelProperty("是否支持买家自提类型（是、否）")
	private String sfzcmjztType;

	@ApiModelProperty("物流服务类型")
	private String logisticsSerType;

	@ApiModelProperty("运费类型（商家包邮、设置运费模板）")
	private String freightFormworkType;

	@ApiModelProperty("运费模板_id")
	private Long freightFormworkId;

	@ApiModelProperty("支付类型")
	private String payMethodType;

	@ApiModelProperty("进货单商品规格")
	private double inportCommSpec;

	@ApiModelProperty("等级")
	private String commLevelType;

	@ApiModelProperty("报价方式")
	private String quotMethodType;

	@ApiModelProperty("混批类型")
	private String hpType;

	@ApiModelProperty("货品总件数大于数量")
	private double hpzjsdyCount;

	@ApiModelProperty("验收标准表达式")
	private String ysbzBds;

	@ApiModelProperty("订金比例")
    private Double depositBl;

	@ApiModelProperty("该商品下面的等级规格变化了多少标识。0：没有变化，1：部分变化，2：全部变化")
	private String changFlag;

	@ApiModelProperty("等级规格列表")
	private List<SpecLevelVo> specLevelList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getChangFlag() {
		return changFlag;
	}

	public void setChangFlag(String changFlag) {
		this.changFlag = changFlag;
	}

	public Double getDepositBl() {
		return depositBl;
	}

	public void setDepositBl(Double depositBl) {
		this.depositBl = depositBl;
	}

	public String getYsbzBds() {
		return ysbzBds;
	}

	public void setYsbzBds(String ysbzBds) {
		this.ysbzBds = ysbzBds;
	}

	public String getHpType() {
		return hpType;
	}

	public void setHpType(String hpType) {
		this.hpType = hpType;
	}

	public String getQuotMethodType() {
		return quotMethodType;
	}

	public void setQuotMethodType(String quotMethodType) {
		this.quotMethodType = quotMethodType;
	}

	public double getHpzjsdyCount() {
		return hpzjsdyCount;
	}

	public void setHpzjsdyCount(double hpzjsdyCount) {
		this.hpzjsdyCount = hpzjsdyCount;
	}

	public List<SpecLevelVo> getSpecLevelList() {
		return specLevelList;
	}

	public void setSpecLevelList(List<SpecLevelVo> specLevelList) {
		this.specLevelList = specLevelList;
	}

	public String getPayMethodType() {
		return payMethodType;
	}

	public void setPayMethodType(String payMethodType) {
		this.payMethodType = payMethodType;
	}

	public String getFreightFormworkType() {
		return freightFormworkType;
	}

	public void setFreightFormworkType(String freightFormworkType) {
		this.freightFormworkType = freightFormworkType;
	}

	public Long getFreightFormworkId() {
		return freightFormworkId;
	}

	public void setFreightFormworkId(Long freightFormworkId) {
		this.freightFormworkId = freightFormworkId;
	}

	public String getLogisticsSerType() {
		return logisticsSerType;
	}

	public void setLogisticsSerType(String logisticsSerType) {
		this.logisticsSerType = logisticsSerType;
	}

	public String getSfzcmjztType() {
		return sfzcmjztType;
	}

	public void setSfzcmjztType(String sfzcmjztType) {
		this.sfzcmjztType = sfzcmjztType;
	}

	public String getCommName() {
		return commName;
	}

	public void setCommName(String commName) {
		this.commName = commName;
	}

	public Double getCommSpec() {
		return commSpec;
	}

	public void setCommSpec(Double commSpec) {
		this.commSpec = commSpec;
	}

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

	public Long getImportBillId() {
		return importBillId;
	}

	public void setImportBillId(Long importBillId) {
		this.importBillId = importBillId;
	}

	public String getMeasUnitName() {
		return measUnitName;
	}

	public void setMeasUnitName(String measUnitName) {
		this.measUnitName = measUnitName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getStartOrdCount() {
		return startOrdCount;
	}

	public void setStartOrdCount(Integer startOrdCount) {
		this.startOrdCount = startOrdCount;
	}

	public Boolean getIfCollect() {
		return ifCollect;
	}

	public void setIfCollect(Boolean ifCollect) {
		this.ifCollect = ifCollect;
	}

	public List<ImportBillPriceOperateVo> getwPriceList() {
		return wPriceList;
	}

	public void setwPriceList(List<ImportBillPriceOperateVo> wPriceList) {
		this.wPriceList = wPriceList;
	}

	public List<ImportBillPriceOperateVo> getAwPriceList() {
		return awPriceList;
	}

	public void setAwPriceList(List<ImportBillPriceOperateVo> awPriceList) {
		this.awPriceList = awPriceList;
	}

	public String getAgentStateType() {
		return agentStateType;
	}

	public void setAgentStateType(String agentStateType) {
		this.agentStateType = agentStateType;
	}

	public double getAllPrice() {
		return allPrice;
	}

	public void setAllPrice(double allPrice) {
		this.allPrice = allPrice;
	}

	public double getInportCommSpec() {
		return inportCommSpec;
	}

	public void setInportCommSpec(double inportCommSpec) {
		this.inportCommSpec = inportCommSpec;
	}

	public String getCommLevelType() {
		return commLevelType;
	}

	public void setCommLevelType(String commLevelType) {
		this.commLevelType = commLevelType;
	}

}

