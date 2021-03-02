package com.wisea.cultivar.common.po.tp.portal;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModelProperty;

/**
 *
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月29日
 * @version 1.0
 */
public class BulkTransactionActivityUpdPo {

	@JsonSerialize(using = IdSerializer.class)
	@ApiModelProperty(value = "id(新增为空,修改必须填写)")
	private Long id;

	@ApiModelProperty(value = "图片地址")
	private String imgUrl;

    @Check(test = { "maxLength" }, mixLength = 200)
    @ApiModelProperty(value = "商品名称")
    private String commName;

    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "交易额")
    private Double transPrice;

    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "交易内容")
    private String transSubject;

    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "交易日期")
    private OffsetDateTime transDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCommName() {
		return commName;
	}

	public void setCommName(String commName) {
		this.commName = commName;
	}

	public Double getTransPrice() {
		return transPrice;
	}

	public void setTransPrice(Double transPrice) {
		this.transPrice = transPrice;
	}

	public String getTransSubject() {
		return transSubject;
	}

	public void setTransSubject(String transSubject) {
		this.transSubject = transSubject;
	}

	public OffsetDateTime getTransDate() {
		return transDate;
	}

	public void setTransDate(OffsetDateTime transDate) {
		this.transDate = transDate;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

}
