package com.wisea.transac.common.vo.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

@ApiModel("账期结算单列表Vo")
public class BuyerSettleBillListVo {

    @ApiModelProperty(value="id")
    private Long id;
    @ApiModelProperty(value="卖方id")
    private Long sellerId;
    @ApiModelProperty("卖方名称")
    private String loginName;
    @ApiModelProperty("卖方电话")
    private String registTel;
    @ApiModelProperty("商家名称")
    private String entpName;
    @ApiModelProperty(value="买方id")
    private Long buyerId;
    @ApiModelProperty(value="结算单号")
    private String settleBillNumb;
    @ApiModelProperty(value="账期类型")
    private String settleCycleType;
    @ApiModelProperty(value="对账日")
    private OffsetDateTime recoDate;
    @ApiModelProperty(value="最晚付款日期")
    private OffsetDateTime lastPayDate;
    @ApiModelProperty(value="应结总额")
    private Double totalMoney;
    @ApiModelProperty(value="滞纳金")
    private Double lateFee;
    @ApiModelProperty(value="订单数")
    private Integer ordCount;
    @ApiModelProperty(value="结算单状态")
    private String settleBillStatueType;
    @ApiModelProperty("结算单生成类型")
    private String settleBillPrdutType;
    @ApiModelProperty("对账状态")
    private String reconStateType;
    @ApiModelProperty("对账截止日")
    private OffsetDateTime reconDeadline;
    @ApiModelProperty("开票截止日")
    private OffsetDateTime openBillDeadline;
    @ApiModelProperty("验票截止日")
    private OffsetDateTime examBillDeadline;
    @ApiModelProperty(value="对账日期限天数")
    private Integer deadLineDay;
    @ApiModelProperty(value="最晚付款日期限天数")
    private Integer payDeadDate;
    @ApiModelProperty("是否逾期")
    private String sfYqFlag;
    @ApiModelProperty("滞纳金比例")
    private Double lateFeeBl;
    @ApiModelProperty("当前时间")
    private OffsetDateTime nowDate;
    @ApiModelProperty("已支付总金额")
    private Double paymentAmount;
    @ApiModelProperty(value="结算单发票id")
    private Long invoId;
    @ApiModelProperty(value="结算单发票状态")
    private String invoState;
    @ApiModelProperty("当前日期")
    private OffsetDateTime nowData;
    @ApiModelProperty(value="逾期天数")
    private Long yuqiDay;
    @ApiModelProperty(value="还有几天逾期天数")
    private Long jyYuqiDay;
    @ApiModelProperty(value="总结算金额")
    private Double totalAllMoney;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getSellerId() {
        return sellerId;
    }
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
    public Long getYuqiDay() {
        return yuqiDay;
    }
    public void setYuqiDay(Long yuqiDay) {
        this.yuqiDay = yuqiDay;
    }
    public Integer getDeadLineDay() {
        return deadLineDay;
    }
    public void setDeadLineDay(Integer deadLineDay) {
        this.deadLineDay = deadLineDay;
    }
    public Double getTotalAllMoney() {
        return totalAllMoney;
    }
    public void setTotalAllMoney(Double totalAllMoney) {
        this.totalAllMoney = totalAllMoney;
    }
    public String getLoginName() {
        return loginName;
    }
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    public String getRegistTel() {
        return registTel;
    }
    public void setRegistTel(String registTel) {
        this.registTel = registTel;
    }
    public String getEntpName() {
        return entpName;
    }

    public Long getJyYuqiDay() {
        return jyYuqiDay;
    }

    public void setJyYuqiDay(Long jyYuqiDay) {
        this.jyYuqiDay = jyYuqiDay;
    }

    public Integer getPayDeadDate() {
        return payDeadDate;
    }

    public void setPayDeadDate(Integer payDeadDate) {
        this.payDeadDate = payDeadDate;
    }

    public String getSettleBillPrdutType() {
        return settleBillPrdutType;
    }

    public void setSettleBillPrdutType(String settleBillPrdutType) {
        this.settleBillPrdutType = settleBillPrdutType;
    }

    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }
    public Long getBuyerId() {
        return buyerId;
    }
    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }
    public String getSettleBillNumb() {
        return settleBillNumb;
    }
    public void setSettleBillNumb(String settleBillNumb) {
        this.settleBillNumb = settleBillNumb;
    }
    public String getSettleCycleType() {
        return settleCycleType;
    }
    public void setSettleCycleType(String settleCycleType) {
        this.settleCycleType = settleCycleType;
    }
    public OffsetDateTime getRecoDate() {
        return recoDate;
    }
    public void setRecoDate(OffsetDateTime recoDate) {
        this.recoDate = recoDate;
    }
    public OffsetDateTime getLastPayDate() {
        return lastPayDate;
    }
    public void setLastPayDate(OffsetDateTime lastPayDate) {
        this.lastPayDate = lastPayDate;
    }
    public Double getTotalMoney() {
        return totalMoney;
    }
    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }
    public Double getLateFee() {
        return lateFee;
    }
    public void setLateFee(Double lateFee) {
        this.lateFee = lateFee;
    }
    public Integer getOrdCount() {
        return ordCount;
    }
    public void setOrdCount(Integer ordCount) {
        this.ordCount = ordCount;
    }
    public String getSettleBillStatueType() {
        return settleBillStatueType;
    }
    public void setSettleBillStatueType(String settleBillStatueType) {
        this.settleBillStatueType = settleBillStatueType;
    }
    public String getReconStateType() {
        return reconStateType;
    }
    public void setReconStateType(String reconStateType) {
        this.reconStateType = reconStateType;
    }
    public OffsetDateTime getReconDeadline() {
        return reconDeadline;
    }
    public void setReconDeadline(OffsetDateTime reconDeadline) {
        this.reconDeadline = reconDeadline;
    }
    public OffsetDateTime getOpenBillDeadline() {
        return openBillDeadline;
    }
    public void setOpenBillDeadline(OffsetDateTime openBillDeadline) {
        this.openBillDeadline = openBillDeadline;
    }
    public OffsetDateTime getExamBillDeadline() {
        return examBillDeadline;
    }
    public void setExamBillDeadline(OffsetDateTime examBillDeadline) {
        this.examBillDeadline = examBillDeadline;
    }
    public String getSfYqFlag() {
        return sfYqFlag;
    }
    public void setSfYqFlag(String sfYqFlag) {
        this.sfYqFlag = sfYqFlag;
    }
    public Double getLateFeeBl() {
        return lateFeeBl;
    }
    public void setLateFeeBl(Double lateFeeBl) {
        this.lateFeeBl = lateFeeBl;
    }
    public OffsetDateTime getNowDate() {
        return nowDate;
    }
    public void setNowDate(OffsetDateTime nowDate) {
        this.nowDate = nowDate;
    }
    public Double getPaymentAmount() {
        return paymentAmount;
    }
    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
    public OffsetDateTime getNowData() {
        return nowData;
    }
    public void setNowData(OffsetDateTime nowData) {
        this.nowData = nowData;
    }
    public Long getInvoId() {
        return invoId;
    }
    public void setInvoId(Long invoId) {
        this.invoId = invoId;
    }
    public String getInvoState() {
        return invoState;
    }
    public void setInvoState(String invoState) {
        this.invoState = invoState;
    }

}
