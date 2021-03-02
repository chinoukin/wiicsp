package com.wisea.cultivar.common.po.tp.portal;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 后台水果指数保存具体信息PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月29日
 * @version 1.0
 */
@ApiModel("后台水果指数保存具体信息PO")
public class FruitsIndexInsPo {

    /**
     * 日期
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "日期")
    @Check(test ="required")
    private OffsetDateTime fiDate;

    /**
     * 商品名称
     */
    @Check(test = {"required","maxLength"}, mixLength = 190)
    @ApiModelProperty(value = "商品名称")
    private String commName;

    /**
     * 价格指数
     */
    @Check(test = {"required","regex"}, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "价格指数")
    private Double priceIndex;

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
