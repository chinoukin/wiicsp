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
 * 水果价格信息VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月30日
 * @version 1.0
 */
@ApiModel("水果价格信息VO")
public class FruitsPriceInfoVo {

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
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
}
