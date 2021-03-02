package com.wisea.cultivar.common.vo.tp.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

/**
 * @author jirg
 * @version 1.0
 * @className ApPayMageListVo
 * @date 2019/4/22 10:38
 * @Description 账期支付设置列表Vo
 */
@ApiModel("账期支付设置列表Vo")
public class ApPayMageListVo {
    @ApiModelProperty("账期支付设置ID")
    private String id;
    @ApiModelProperty("买家id")
    private Long buyerId;
    @ApiModelProperty("采购商账号")
    private String purchaserAcct;
    @ApiModelProperty("采购商名称")
    private String purchaserAcctName;
    @ApiModelProperty("授信商家名称")
    private String sellerName;
    @ApiModelProperty("账期类型（周结、月结、双月结、季结）")
    private String settleCycleType;
    @ApiModelProperty("账单生成日类型（周一、周二。。。周日）")
    private String billDateType;
    @ApiModelProperty("账期授信额度")
    private Double acctCreditLine;
    @ApiModelProperty("可用额度")
    private Double availableCredit;
    @ApiModelProperty("最晚付款日")
    private Integer payDeadDate;
    @ApiModelProperty("授信状态（正常、冻结）")
    private String creditType;
    @ApiModelProperty("授信日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime createDate;
    @ApiModelProperty("是否收取滞纳金")
    private String sfLateFeeFlag;
    @ApiModelProperty("服务费比例")
    private Double serCostBl;
    @ApiModelProperty("滞纳金比例")
    private Double lateFeeBl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getLateFeeBl() {
		return lateFeeBl;
	}

	public void setLateFeeBl(Double lateFeeBl) {
		this.lateFeeBl = lateFeeBl;
	}

	public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getPurchaserAcct() {
        return purchaserAcct;
    }

    public void setPurchaserAcct(String purchaserAcct) {
        this.purchaserAcct = purchaserAcct;
    }

    public String getPurchaserAcctName() {
        return purchaserAcctName;
    }

    public void setPurchaserAcctName(String purchaserAcctName) {
        this.purchaserAcctName = purchaserAcctName;
    }

    public String getSettleCycleType() {
        return settleCycleType;
    }

    public void setSettleCycleType(String settleCycleType) {
        this.settleCycleType = settleCycleType;
    }

    public String getBillDateType() {
        return billDateType;
    }

    public void setBillDateType(String billDateType) {
        this.billDateType = billDateType;
    }

    public Double getAcctCreditLine() {
        return acctCreditLine;
    }

    public void setAcctCreditLine(Double acctCreditLine) {
        this.acctCreditLine = acctCreditLine;
    }

    public Double getAvailableCredit() {
        return availableCredit;
    }

    public void setAvailableCredit(Double availableCredit) {
        this.availableCredit = availableCredit;
    }

    public Integer getPayDeadDate() {
        return payDeadDate;
    }

    public void setPayDeadDate(Integer payDeadDate) {
        this.payDeadDate = payDeadDate;
    }

    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public OffsetDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(OffsetDateTime createDate) {
		this.createDate = createDate;
	}

    public String getSfLateFeeFlag() {
        return sfLateFeeFlag;
    }

    public void setSfLateFeeFlag(String sfLateFeeFlag) {
        this.sfLateFeeFlag = sfLateFeeFlag;
    }

    public Double getSerCostBl() {
        return serCostBl;
    }

    public void setSerCostBl(Double serCostBl) {
        this.serCostBl = serCostBl;
    }
}
