package com.wisea.cultivar.common.vo.tp.trade;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 退款明细Vo
 * @author yangtao
 *
 */
@ApiModel("退款明细Vo")
public class RefundDListVo {

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "退款明细id")
    private Long id;
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "订单id")
    private Long ordId;
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "会员id")
    private Long membId;
    @ApiModelProperty(value = "会员账号")
    private String membNo;
    @ApiModelProperty(value = "交易流水号")
    private String tradeNo;
    @ApiModelProperty(value = "订单编号")
    private String ordNum;
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @ApiModelProperty(value = "交易时间")
    private OffsetDateTime tradeDate;
    @ApiModelProperty(value = "服务单号")
    private String serNum;
    @ApiModelProperty(value = "申请金额")
    private Double applAmount;
    @ApiModelProperty(value = "退款方式")
    private String refundModeType;
    @ApiModelProperty(value = "退款金额")
    private Double refundAmount;
    @ApiModelProperty(value = "退款、退货id")
    @JsonSerialize(using = IdSerializer.class)
    private Long refundMoneyId;
    @ApiModelProperty(value = "退款、退货标识(0，退款，1退货)")
    private String refundFlag;
    @ApiModelProperty(value = "买家账号")
    private String buyerName;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public Long getRefundMoneyId() {
		return refundMoneyId;
	}
	public void setRefundMoneyId(Long refundMoneyId) {
		this.refundMoneyId = refundMoneyId;
	}
	public String getRefundFlag() {
		return refundFlag;
	}
	public void setRefundFlag(String refundFlag) {
		this.refundFlag = refundFlag;
	}
	public Long getOrdId() {
		return ordId;
	}
	public void setOrdId(Long ordId) {
		this.ordId = ordId;
	}
	public Long getMembId() {
		return membId;
	}
	public void setMembId(Long membId) {
		this.membId = membId;
	}
	public String getMembNo() {
		return membNo;
	}
	public void setMembNo(String membNo) {
		this.membNo = membNo;
	}
	public String getTradeNo() {
		return tradeNo;
	}
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	public String getOrdNum() {
		return ordNum;
	}
	public void setOrdNum(String ordNum) {
		this.ordNum = ordNum;
	}
	public OffsetDateTime getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(OffsetDateTime tradeDate) {
		this.tradeDate = tradeDate;
	}
	public String getSerNum() {
		return serNum;
	}
	public void setSerNum(String serNum) {
		this.serNum = serNum;
	}
	public Double getApplAmount() {
		return applAmount;
	}
	public void setApplAmount(Double applAmount) {
		this.applAmount = applAmount;
	}
	public String getRefundModeType() {
		return refundModeType;
	}
	public void setRefundModeType(String refundModeType) {
		this.refundModeType = refundModeType;
	}
	public Double getRefundAmount() {
		return refundAmount;
	}
	public void setRefundAmount(Double refundAmount) {
		this.refundAmount = refundAmount;
	}
}
