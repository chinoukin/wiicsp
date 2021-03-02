package com.wisea.transac.common.vo.trade;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("买家查询未出账单列表Vo")
public class BuyerNotSettleListVo {

    @ApiModelProperty(value="账期设置ID")
    private Long apPayId;
    @ApiModelProperty(value="可用额度")
    private Double availableCredit;
    @ApiModelProperty(value="账期类型")
    private String settleCycleType;
    @ApiModelProperty(value="对账日类型")
    private String billDateType;
    @ApiModelProperty(value="最晚付款日")
    private Integer payDeadDate;
    @ApiModelProperty(value="商家名称")
    private String entpName;
    @ApiModelProperty(value="未出总金额")
    private Double totalAmont;
    @ApiModelProperty(value="账期订单")
    private List<SettleOrdRelaInfoVo> settleOrdList;

    public Long getApPayId() {
        return apPayId;
    }
    public void setApPayId(Long apPayId) {
        this.apPayId = apPayId;
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
    public String getEntpName() {
        return entpName;
    }
    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }
    public Double getTotalAmont() {
        return totalAmont;
    }
    public void setTotalAmont(Double totalAmont) {
        this.totalAmont = totalAmont;
    }
    public List<SettleOrdRelaInfoVo> getSettleOrdList() {
        return settleOrdList;
    }
    public void setSettleOrdList(List<SettleOrdRelaInfoVo> settleOrdList) {
        this.settleOrdList = settleOrdList;
    }
}
