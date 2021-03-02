package com.wisea.transac.common.vo.trade;

import com.wisea.cloud.common.util.OffsetDateTimeUtils;
import com.wisea.transac.common.vo.SettleBillInvoInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.temporal.WeekFields;
import java.util.List;

@ApiModel("结算单详细信息Vo")
public class SettleBillInfoVo {
    @ApiModelProperty(value="id")
    private Long id;
    @ApiModelProperty(value="卖方id")
    private Long sellerId;
    @ApiModelProperty("卖方账号")
    private String sellerAccount;
    @ApiModelProperty("卖方名称")
    private String sellerName;
    @ApiModelProperty(value="买方id")
    private Long buyerId;
    @ApiModelProperty("买方账号")
    private String buyerAccount;
    @ApiModelProperty("买方名称")
    private String buyerName;
    @ApiModelProperty(value="对账日期限天数")
    private Integer deadLineDay;
    @ApiModelProperty("结算单号")
    private String settleBillNumb;
    @ApiModelProperty(value="结算单状态")
    private String settleBillStatueType;
    @ApiModelProperty("结算单生成类型")
    private String settleBillPrdutType;
    @ApiModelProperty("账期类型")
    private String settleCycleType;
    @ApiModelProperty("账单生成日类型")
    private String billDateType;
    @ApiModelProperty("对账状态")
    private String reconStateType;
    @ApiModelProperty("应结总额")
    private Double totalMoney;
    @ApiModelProperty("滞纳金比例")
    private Double lateFeeBl;
    @ApiModelProperty("滞纳金")
    private Double lateFee;
    @ApiModelProperty("已支付总金额")
    private Double paymentAmount;
    @ApiModelProperty(value="总结算金额")
    private Double totalAllMoney;
    @ApiModelProperty("是否逾期")
    private String sfYqFlag;
    @ApiModelProperty("对账日")
    private OffsetDateTime recoDate;
    @ApiModelProperty("最晚付款期限（对账完成后）")
    private Integer payDeadDate;
    @ApiModelProperty("当前时间")
    private OffsetDateTime nowDate = OffsetDateTime.now();
    @ApiModelProperty("最晚付款日期")
    private OffsetDateTime lastPayDate;
    @ApiModelProperty("对账截止日")
    private OffsetDateTime reconDeadline;
    @ApiModelProperty("开票截止日")
    private OffsetDateTime openBillDeadline;
    @ApiModelProperty("验票截止日")
    private OffsetDateTime examBillDeadline;
    @ApiModelProperty("订单数")
    private Integer ordCount;
    @ApiModelProperty("结算单生成日")
    private OffsetDateTime createDate;
    @ApiModelProperty(value="还有几天逾期天数")
    private Long jyYuqiDay;

    @ApiModelProperty("账期发票信息")
    private SettleBillInvoInfoVo invoInfoVo;
    @ApiModelProperty("账期订单列表")
    private List<SettleOrdRelaInfoVo> settleOrdRelas;
    @ApiModelProperty("结算单操作记录列表")
    private List<OpreateInfoVo> opreateInfos;
    @ApiModelProperty("是否可以取消标识: true 可以取消 、false 不可以取消")
    private Boolean canCancel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerAccount() {
        return sellerAccount;
    }

    public void setSellerAccount(String sellerAccount) {
        this.sellerAccount = sellerAccount;
    }

    public Long getJyYuqiDay() {
        return jyYuqiDay;
    }

    public void setJyYuqiDay(Long jyYuqiDay) {
        this.jyYuqiDay = jyYuqiDay;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerAccount() {
        return buyerAccount;
    }

    public void setBuyerAccount(String buyerAccount) {
        this.buyerAccount = buyerAccount;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getSettleBillNumb() {
        return settleBillNumb;
    }

    public void setSettleBillNumb(String settleBillNumb) {
        this.settleBillNumb = settleBillNumb;
    }

    public String getSettleBillStatueType() {
        return settleBillStatueType;
    }

    public void setSettleBillStatueType(String settleBillStatueType) {
        this.settleBillStatueType = settleBillStatueType;
    }

    public String getSettleBillPrdutType() {
        return settleBillPrdutType;
    }

    public void setSettleBillPrdutType(String settleBillPrdutType) {
        this.settleBillPrdutType = settleBillPrdutType;
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

    public String getReconStateType() {
        return reconStateType;
    }

    public void setReconStateType(String reconStateType) {
        this.reconStateType = reconStateType;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Double getLateFeeBl() {
        return lateFeeBl;
    }

    public void setLateFeeBl(Double lateFeeBl) {
        this.lateFeeBl = lateFeeBl;
    }

    public Double getLateFee() {
        return lateFee;
    }

    public void setLateFee(Double lateFee) {
        this.lateFee = lateFee;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getSfYqFlag() {
        return sfYqFlag;
    }

    public void setSfYqFlag(String sfYqFlag) {
        this.sfYqFlag = sfYqFlag;
    }

    public OffsetDateTime getRecoDate() {
        return recoDate;
    }

    public void setRecoDate(OffsetDateTime recoDate) {
        this.recoDate = recoDate;
    }

    public Integer getPayDeadDate() {
        return payDeadDate;
    }

    public void setPayDeadDate(Integer payDeadDate) {
        this.payDeadDate = payDeadDate;
    }

    public OffsetDateTime getNowDate() {
        return nowDate;
    }

    public void setNowDate(OffsetDateTime nowDate) {
        this.nowDate = nowDate;
    }

    public OffsetDateTime getLastPayDate() {
        return lastPayDate;
    }

    public void setLastPayDate(OffsetDateTime lastPayDate) {
        this.lastPayDate = lastPayDate;
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

    public Integer getOrdCount() {
        return ordCount;
    }

    public void setOrdCount(Integer ordCount) {
        this.ordCount = ordCount;
    }

    public OffsetDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(OffsetDateTime createDate) {
        this.createDate = createDate;
    }

    public SettleBillInvoInfoVo getInvoInfoVo() {
        return invoInfoVo;
    }

    public void setInvoInfoVo(SettleBillInvoInfoVo invoInfoVo) {
        this.invoInfoVo = invoInfoVo;
    }

    public List<SettleOrdRelaInfoVo> getSettleOrdRelas() {
        return settleOrdRelas;
    }

    public void setSettleOrdRelas(List<SettleOrdRelaInfoVo> settleOrdRelas) {
        this.settleOrdRelas = settleOrdRelas;
    }

    public List<OpreateInfoVo> getOpreateInfos() {
        return opreateInfos;
    }

    public void setOpreateInfos(List<OpreateInfoVo> opreateInfos) {
        this.opreateInfos = opreateInfos;
    }

    public Boolean getCanCancel() {
        if(this.getSettleBillPrdutType().equals("0")){
            return false;
        }
        OffsetDateTime nowDate = OffsetDateTime.now(); //当前时间
        OffsetDateTime createDate = OffsetDateTimeUtils.getDayMinTime(this.getCreateDate()); //结算单创建时间
        String settleCycleType = this.getSettleCycleType();
        String billDateType = this.getBillDateType();
        //本周或本月对账日
        OffsetDateTime recoDate = null;
        if (settleCycleType.equals("0")){
            //周结 获取当前周对账日
            recoDate = OffsetDateTimeUtils.getDayMinTime(OffsetDateTime.now()).with(WeekFields.ISO.dayOfWeek(), Integer.valueOf(billDateType) - 28);
        }else{
            //月结 获取当前月对账日
            recoDate = OffsetDateTimeUtils.getDayMinTime(OffsetDateTime.now()).withMonth(MonthDay.now().getMonth().getValue()).withDayOfMonth(Integer.valueOf(billDateType));
        }
        //结算单生成日 < 本周（本月）对账日  &&  当前日期 > 本周（本月）对账日  不可取消
        if(createDate.compareTo(recoDate) < 0 && nowDate.compareTo(recoDate) > 0){
            return false;
        }else{
            return true;
        }
    }

    public void setCanCancel(Boolean canCancel) {
        this.canCancel = canCancel;
    }
}
