package com.wisea.cultivar.common.vo.tp.lta;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("买家端合同详情带商家信息vo")
public class LtaBuyerContInfoVo {

	@ApiModelProperty("合同编号")
    private String ltaContNumb;

	@ApiModelProperty("卖方id")
	@JsonSerialize(using = IdSerializer.class)
    private Long sellerId;

	@ApiModelProperty("买方id")
	@JsonSerialize(using = IdSerializer.class)
    private Long buyerId;

	@ApiModelProperty("合同开始时间")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime contStartDate;

	@ApiModelProperty("合同结束时间")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime contEndDate;

	@ApiModelProperty("结算支付类型")
    private String payMethodType;

	@ApiModelProperty("物流服务类型")
    private String logisticsSerType;

	@ApiModelProperty("长协合同状态")
    private String ltaContStateType;

	@ApiModelProperty("申请人")
    private String applicanter;

	@ApiModelProperty("卖家名称")
    private String compName;

	public String getLtaContNumb() {
		return ltaContNumb;
	}

	public void setLtaContNumb(String ltaContNumb) {
		this.ltaContNumb = ltaContNumb;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public OffsetDateTime getContStartDate() {
		return contStartDate;
	}

	public void setContStartDate(OffsetDateTime contStartDate) {
		this.contStartDate = contStartDate;
	}

	public OffsetDateTime getContEndDate() {
		return contEndDate;
	}

	public void setContEndDate(OffsetDateTime contEndDate) {
		this.contEndDate = contEndDate;
	}

	public String getPayMethodType() {
		return payMethodType;
	}

	public void setPayMethodType(String payMethodType) {
		this.payMethodType = payMethodType;
	}

	public String getLogisticsSerType() {
		return logisticsSerType;
	}

	public void setLogisticsSerType(String logisticsSerType) {
		this.logisticsSerType = logisticsSerType;
	}

	public String getLtaContStateType() {
		return ltaContStateType;
	}

	public void setLtaContStateType(String ltaContStateType) {
		this.ltaContStateType = ltaContStateType;
	}

	public String getApplicanter() {
		return applicanter;
	}

	public void setApplicanter(String applicanter) {
		this.applicanter = applicanter;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}
}
