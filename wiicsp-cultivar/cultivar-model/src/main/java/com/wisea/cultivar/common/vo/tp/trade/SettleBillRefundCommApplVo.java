package com.wisea.cultivar.common.vo.tp.trade;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @author jirg
 * @version 1.0
 * @className SettleBillRefundCommApplVo
 * @date 2019/5/15 9:40
 * @Description 结算周期内已完成的退货申请Vo
 */
@ApiModel("结算周期内已完成的退货申请Vo")
public class SettleBillRefundCommApplVo {
    @ApiModelProperty("退货退款申请ID")
    private Long id;
    @ApiModelProperty("服务单号")
    private String serNum;
    @ApiModelProperty("申请时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime applDate;
    @ApiModelProperty("订单编号")
    private String ordNum;
    @ApiModelProperty("应退金额")
    private Double shouldRefundAmount;
    @ApiModelProperty("处理时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime examSerBillDate;
    @ApiModelProperty("退货申请来源，1 普通订单退货 、 2 长期协议订单退货。注：根据类型不同查询详情时需要调用不同的详情接口")
    private String ordSourceType;
    @ApiModelProperty("商家名称")
    private String sellerName;
    @ApiModelProperty("商品名称")
    private String commName;
    @ApiModelProperty("退货数量")
    private Double refundCounts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getCommName() {
		return commName;
	}

	public void setCommName(String commName) {
		this.commName = commName;
	}

	public Double getRefundCounts() {
		return refundCounts;
	}

	public void setRefundCounts(Double refundCounts) {
		this.refundCounts = refundCounts;
	}

	public String getSerNum() {
        return serNum;
    }

    public void setSerNum(String serNum) {
        this.serNum = serNum;
    }

    public OffsetDateTime getApplDate() {
        return applDate;
    }

    public void setApplDate(OffsetDateTime applDate) {
        this.applDate = applDate;
    }

    public String getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
    }

    public Double getShouldRefundAmount() {
        return shouldRefundAmount;
    }

    public void setShouldRefundAmount(Double shouldRefundAmount) {
        this.shouldRefundAmount = shouldRefundAmount;
    }

    public OffsetDateTime getExamSerBillDate() {
        return examSerBillDate;
    }

    public void setExamSerBillDate(OffsetDateTime examSerBillDate) {
        this.examSerBillDate = examSerBillDate;
    }

    public String getOrdSourceType() {
        return ordSourceType;
    }

    public void setOrdSourceType(String ordSourceType) {
        this.ordSourceType = ordSourceType;
    }
}
