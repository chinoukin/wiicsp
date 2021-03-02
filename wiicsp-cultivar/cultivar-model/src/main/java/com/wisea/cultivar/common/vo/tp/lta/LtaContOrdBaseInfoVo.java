package com.wisea.cultivar.common.vo.tp.lta;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 长协合同中的订单信息VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月8日
 * @version 1.0
 */
@ApiModel("长协合同中的订单信息VO")
public class LtaContOrdBaseInfoVo {

	@JsonSerialize(using = IdSerializer.class)
	@ApiModelProperty(value="Id")
	private Long id;

	@ApiModelProperty(value="订单编号")
	private String ltaOrdNumb;//订单编号

	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value="下单时间")
	private OffsetDateTime buyerOrdDate;//下单时间

	@ApiModelProperty(value="订单金额")
	private double yfAmount;//订单金额

	@ApiModelProperty(value="支付方式pay_method_type(0:下单即付1:账期支付)")
	private String payMethodType;//支付方式

	@ApiModelProperty(value="订单状态order_state_type(0:待确认1:待付款2:待发货3:待收货4:已完成5:已取消6:待自提)")
	private String orderStateType;//订单状态

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLtaOrdNumb() {
		return ltaOrdNumb;
	}

	public void setLtaOrdNumb(String ltaOrdNumb) {
		this.ltaOrdNumb = ltaOrdNumb;
	}

	public OffsetDateTime getBuyerOrdDate() {
		return buyerOrdDate;
	}

	public void setBuyerOrdDate(OffsetDateTime buyerOrdDate) {
		this.buyerOrdDate = buyerOrdDate;
	}

	public double getYfAmount() {
		return yfAmount;
	}

	public void setYfAmount(double yfAmount) {
		this.yfAmount = yfAmount;
	}

	public String getPayMethodType() {
		return payMethodType;
	}

	public void setPayMethodType(String payMethodType) {
		this.payMethodType = payMethodType;
	}

	public String getOrderStateType() {
		return orderStateType;
	}

	public void setOrderStateType(String orderStateType) {
		this.orderStateType = orderStateType;
	}
}
