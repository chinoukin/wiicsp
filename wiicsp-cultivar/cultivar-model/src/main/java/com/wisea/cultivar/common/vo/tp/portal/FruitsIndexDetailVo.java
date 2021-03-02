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
 * 后台查询水果指数详细信息VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月29日
 * @version 1.0
 */
@ApiModel("后台查询水果指数详细信息VO")
public class FruitsIndexDetailVo {

	@JsonSerialize(using = IdSerializer.class)
	@ApiModelProperty(value="ID")
	private Long id;

	@ApiModelProperty(value="日期")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime fiDate;

	@ApiModelProperty(value="商品名称")
    private String commName;

	@ApiModelProperty(value="指数")
    private Double priceIndex;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OffsetDateTime getFiDate() {
		return fiDate;
	}

	public void setFiDate(OffsetDateTime fiDate) {
		this.fiDate = fiDate;
	}

	public String getCommName() {
		return commName;
	}

	public void setCommName(String commName) {
		this.commName = commName;
	}

	public Double getPriceIndex() {
		return priceIndex;
	}

	public void setPriceIndex(Double priceIndex) {
		this.priceIndex = priceIndex;
	}

}
