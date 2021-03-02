package com.wisea.cultivar.common.po.tp.lta;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author yangtao
 * ltaBuyerPreOrdCommPo
 * 2018/09/18 17:40:35
 */
@ApiModel("买家端提交订单商品列表po")
public class LtaBuyerPreOrdCommPo {

	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "长协商品信息id")
	@Check(test = "required")
    private Long commRelaId;
	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "长协商品规格对应id")
	@Check(test = "required")
    private Long commRelaPackId;
    @ApiModelProperty(value = "等级")
    @Check(test = "required")
    private String level;
    @ApiModelProperty(value = "规格")
    private String spec;
    @ApiModelProperty(value = "数量")
    @Check(test = "required")
    private int count;
    @ApiModelProperty(value = "单价")
    @Check(test = "required")
    private Double price;

	public Long getCommRelaId() {
		return commRelaId;
	}
	public void setCommRelaId(Long commRelaId) {
		this.commRelaId = commRelaId;
	}
	public Long getCommRelaPackId() {
		return commRelaPackId;
	}
	public void setCommRelaPackId(Long commRelaPackId) {
		this.commRelaPackId = commRelaPackId;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}
