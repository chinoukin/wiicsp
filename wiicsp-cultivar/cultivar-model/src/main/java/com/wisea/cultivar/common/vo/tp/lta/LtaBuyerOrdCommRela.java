package com.wisea.cultivar.common.vo.tp.lta;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 订单列表的订单商品
 */
@ApiModel("订单商品")
public class LtaBuyerOrdCommRela {

	@ApiModelProperty("订单id")
	@JsonSerialize(using = IdSerializer.class)
    private Long ordId;

	@ApiModelProperty("订单商品id")
	@JsonSerialize(using = IdSerializer.class)
    private Long ordCommId;

	@ApiModelProperty("数量")
    private Integer slNum;

	@ApiModelProperty("可退数量")
    private Integer subCount;

	@ApiModelProperty("单价（代理价就是结算价）")
    private Double price;

	@ApiModelProperty("商品名称")
    private String commName;

	@ApiModelProperty("商品编号")
    private String commNum;

	@ApiModelProperty("规格重量")
    private Double spec;

	@ApiModelProperty("包装说明")
    private String packInstr;

	@ApiModelProperty("计量单位名称")
	private String measUnitName;

	@ApiModelProperty("商品等级")
    private String level;

	@ApiModelProperty("商品品牌")
    private String brandName;

    /**
     * 商品图片
     */
	@ApiModelProperty("商品图片")
    private String commUrl;

	public Long getOrdId() {
		return ordId;
	}

	public void setOrdId(Long ordId) {
		this.ordId = ordId;
	}

	public Long getOrdCommId() {
		return ordCommId;
	}

	public void setOrdCommId(Long ordCommId) {
		this.ordCommId = ordCommId;
	}

	public Integer getSlNum() {
		return slNum;
	}

	public void setSlNum(Integer slNum) {
		this.slNum = slNum;
	}

	public Integer getSubCount() {
		return subCount;
	}

	public void setSubCount(Integer subCount) {
		this.subCount = subCount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCommName() {
		return commName;
	}

	public void setCommName(String commName) {
		this.commName = commName;
	}

	public String getCommNum() {
		return commNum;
	}

	public void setCommNum(String commNum) {
		this.commNum = commNum;
	}

	public Double getSpec() {
		return spec;
	}

	public void setSpec(Double spec) {
		this.spec = spec;
	}

	public String getPackInstr() {
		return packInstr;
	}

	public void setPackInstr(String packInstr) {
		this.packInstr = packInstr;
	}

	public String getMeasUnitName() {
		return measUnitName;
	}

	public void setMeasUnitName(String measUnitName) {
		this.measUnitName = measUnitName;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getCommUrl() {
		return commUrl;
	}

	public void setCommUrl(String commUrl) {
		this.commUrl = commUrl;
	}

}
