package com.wisea.cultivar.common.vo.tp.portal;

import java.io.Serializable;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 水果价格列表的展示VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月30日
 * @version 1.0
 */
@ApiModel("水果价格列表的展示VO")
public class FruitsPricePortalVo implements Serializable{

	private static final long serialVersionUID = 9135144541949633373L;

	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id",hidden=true)
    private Long id;

    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "日期")
    private OffsetDateTime fpDate;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "显示商品名称")
    private String commName;

    @ApiModelProperty(value = "地区")
    private String areaDetail;

    @ApiModelProperty(value = "是否显示现在(0:显示具体时间1:显示现在2:显示昨天)")
    private String isShowNow;

    @ApiModelProperty(value = "价格")
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

	public String getCommName() {
		return commName;
	}

	public void setCommName(String commName) {
		this.commName = commName;
	}

	public String getAreaDetail() {
		return areaDetail;
	}

	public void setAreaDetail(String areaDetail) {
		this.areaDetail = areaDetail;
	}

	public String getIsShowNow() {
		return isShowNow;
	}

	public void setIsShowNow(String isShowNow) {
		this.isShowNow = isShowNow;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
