package com.wisea.transac.common.vo.trade;

import java.time.OffsetDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 收支明细列表vo
 * @author yangtao
 *
 */
@ApiModel("收支明细列表vo")
public class IncomeListVo {

    @ApiModelProperty("收支明细ID")
    private Long id;
    @ApiModelProperty("交易流水号")
    private String tradeNo;
    @ApiModelProperty("订单编号")
    private String ordNum;
    @ApiModelProperty("完成时间")
    private OffsetDateTime finishDate;
    @ApiModelProperty("买家支付金额")
    private Double commTotalPrice;
    @ApiModelProperty("分账收入")
    private Double splitIncome;
    @ApiModelProperty("账期编号")
    private String settleBillNumb;
    @ApiModelProperty("平台服务费")
    private Double operSerCharge;
    @ApiModelProperty("账期，订单ID")
    private Long settOrdId;
    @ApiModelProperty("采购商账户")
    private String loginName;
    @ApiModelProperty("采购商名称")
    private String entpName;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public Double getSplitIncome() {
        return splitIncome;
    }
    public void setSplitIncome(Double splitIncome) {
        this.splitIncome = splitIncome;
    }
    public String getSettleBillNumb() {
        return settleBillNumb;
    }
    public void setSettleBillNumb(String settleBillNumb) {
        this.settleBillNumb = settleBillNumb;
    }
    public OffsetDateTime getFinishDate() {
        return finishDate;
    }
    public void setFinishDate(OffsetDateTime finishDate) {
        this.finishDate = finishDate;
    }
    public Double getCommTotalPrice() {
        return commTotalPrice;
    }
    public void setCommTotalPrice(Double commTotalPrice) {
        this.commTotalPrice = commTotalPrice;
    }
    public Double getOperSerCharge() {
        return operSerCharge;
    }
    public void setOperSerCharge(Double operSerCharge) {
        this.operSerCharge = operSerCharge;
    }
    public Long getSettOrdId() {
        return settOrdId;
    }
    public void setSettOrdId(Long settOrdId) {
        this.settOrdId = settOrdId;
    }
    public String getLoginName() {
        return loginName;
    }
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    public String getEntpName() {
        return entpName;
    }
    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }
}
