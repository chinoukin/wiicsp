package com.wisea.transac.common.po.trade;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("新增或修改账期设置Po")
public class ApPayMagePo {
    @ApiModelProperty(value="id, 修改是不能为空")
    private Long id;
    @ApiModelProperty(value="会员（买家）id")
    @Check(test = "required", requiredMsg = "会员id不能为空")
    private Long membId;
    @ApiModelProperty(value="商家id", hidden = true)
    private Long sellerId;
    @ApiModelProperty(value="账期授信额度")
    @Check(test = "required", requiredMsg = "账期授信额度不能为空")
    private Double acctCreditLine;
    @ApiModelProperty(value="账期类型")
    @Check(test = "required", requiredMsg = "账期类型不能为空")
    private String settleCycleType;
    @ApiModelProperty(value="对账日类型")
    @Check(test = "required", requiredMsg = "对账日类型不能为空")
    private String billDateType;
    @ApiModelProperty(value="最晚付款日")
    @Check(test = "required", requiredMsg = "最晚付款日不能为空")
    private Integer payDeadDate;
    @ApiModelProperty(value="服务费比例")
    @Check(test = "required", requiredMsg = "服务费比例不能为空")
    private Double serCostBl;
    @ApiModelProperty(value="逾期滞纳金比例")
    private Double overdueLateFeeProp;
    @ApiModelProperty(value="授信状态")
    @Check(test = "required", requiredMsg = "授信状态不能为空")
    private String creditType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Double getAcctCreditLine() {
        return acctCreditLine;
    }

    public void setAcctCreditLine(Double acctCreditLine) {
        this.acctCreditLine = acctCreditLine;
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

    public Integer getPayDeadDate() {
        return payDeadDate;
    }

    public void setPayDeadDate(Integer payDeadDate) {
        this.payDeadDate = payDeadDate;
    }

    public Double getSerCostBl() {
        return serCostBl;
    }

    public void setSerCostBl(Double serCostBl) {
        this.serCostBl = serCostBl;
    }

    public Double getOverdueLateFeeProp() {
        return overdueLateFeeProp;
    }

    public void setOverdueLateFeeProp(Double overdueLateFeeProp) {
        this.overdueLateFeeProp = overdueLateFeeProp;
    }

    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }
}
