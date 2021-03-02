package com.wisea.cultivar.common.vo.tp.portal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

/**
 * 大宗交易详细信息VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月29日
 * @version 1.0
 */
@ApiModel("大宗交易详细信息VO")
public class BulkTransactionActivityDetailVo {

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "图片地址")
	private String imgUrl;

    @ApiModelProperty(value = "商品名称")
    private String commName;

    @ApiModelProperty(value = "交易额")
    private Double transPrice;

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
