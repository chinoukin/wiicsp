package com.wisea.transac.common.vo.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("账期支付设置详细信息Vo")
public class ApPayMageInfoVo {
    @ApiModelProperty(value="id")
    private Long id;
    @ApiModelProperty(value="会员id")
    private Long membId;
    @ApiModelProperty(value="商家id")
    private Long sellerId;
    @ApiModelProperty(value="账期授信额度")
    private Double acctCreditLine;
    @ApiModelProperty(value="可用额度")
    private Double availableCredit;
    @ApiModelProperty(value="账期类型")
    private String settleCycleType;
    @ApiModelProperty(value="对账日类型")
    private String billDateType;
    @ApiModelProperty(value="最晚付款日")
    private Integer payDeadDate;
    @ApiModelProperty(value="服务费比例")
    private Double serCostBl;
    @ApiModelProperty(value="逾期滞纳金比例")
    private Double overdueLateFeeProp;
    @ApiModelProperty(value="授信状态")
    private String creditType;
    @ApiModelProperty("买家用户名")
    private String loginName;
    @ApiModelProperty("买家头像")
    private String logoUrl;
    @ApiModelProperty("买家注册手机号")
    private String registTel;
    @ApiModelProperty("买家名称")
    private String authName;
    @ApiModelProperty("会员类型")
    private String authType;

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

    public Double getAvailableCredit() {
        return availableCredit;
    }

    public void setAvailableCredit(Double availableCredit) {
        this.availableCredit = availableCredit;
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

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getRegistTel() {
        return registTel;
    }

    public void setRegistTel(String registTel) {
        this.registTel = registTel;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }
}
