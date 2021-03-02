package com.wisea.cultivar.common.vo.tp.portal;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 水果价格比较分页列表返回VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年6月12日
 * @version 1.0
 */
@ApiModel("水果价格比较分页列表返回VO")
public class FruitsPriceCompPageVo {

	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id",hidden=true)
    private Long id;

	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "日期")
    private OffsetDateTime fpDate;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商品分类")
    private String commName;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商品品种")
    private String commVarietName;

    @ApiModelProperty(value = "地区")
    private String areaDetail;

    @ApiModelProperty(value = "单价")
    private Double price;

    @ApiModelProperty(value = "对比升降标识(0:相同1:上升2:下降)")
    private String compUdType;

    @ApiModelProperty(value = "比较的数值")
    private Double compValue;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OffsetDateTime getFpDate() {
		return fpDate;
	}

	public void setFpDate(OffsetDateTime fpDate) {
		this.fpDate = fpDate;
	}

	public String getCommName() {
		return commName;
	}

	public void setCommName(String commName) {
		this.commName = commName;
	}

	public String getCommVarietName() {
		return commVarietName;
	}

	public void setCommVarietName(String commVarietName) {
		this.commVarietName = commVarietName;
	}

	public String getAreaDetail() {
		return areaDetail;
	}

	public void setAreaDetail(String areaDetail) {
		this.areaDetail = areaDetail;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCompUdType() {
		return compUdType;
	}

	public void setCompUdType(String compUdType) {
		this.compUdType = compUdType;
	}

	public Double getCompValue() {
		return compValue;
	}

	public void setCompValue(Double compValue) {
		this.compValue = compValue;
	}
}
