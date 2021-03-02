package com.wisea.cultivar.common.vo.tp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 提现查询返回参数信息
 * @author: wangs
 * @date :2019/1/22
 */
@ApiModel("提现查询返回参数信息")
public class CashByOrderVo {

    /**
     * 提现金额
     */
    @ApiModelProperty("提现金额")
    private String amount;
    /**
     * 提现账户名称
     */
    @ApiModelProperty("提现账户名称")
    private String bankAccountName;

    @ApiModelProperty("提现卡号或账户号")
    private String bankAccountNo;
    /**
     * 错误信息
     */
    @ApiModelProperty("错误信息")
    private String bankMsg;
    /**
     * 提现银行
     */
    @ApiModelProperty("提现银行")
    private String bankName;
    /**
     * 银行状态
     */
    @ApiModelProperty("银行状态")
    private String bankTrxStatusCode;
    /**
     * 提现支行名称
     */
    @ApiModelProperty("提现支行名称")
    private String branchName;
    /**
     * 商户编号
     */
    @ApiModelProperty("商户编号")
    private String customerNumber;
    /**
     * 手续费
     */
    @ApiModelProperty("手续费")
    private String fee;
    /**
     * 计费类型
     */
    @ApiModelProperty("计费类型")
    private String feeType;
    /**
     * 结束时间
     */
    @ApiModelProperty("结束时间")
    private String finishTime;
    /**
     * 系统商编号
     */
    @ApiModelProperty("系统商编号")
    private String groupNumber;
    /**
     * 商户订单号
     */
    @ApiModelProperty("商户订单号")
    private String orderId;
    /**
     * 实际提现额度
     */
    @ApiModelProperty("实际提现额度")
    private String realAmount;
    /**
     * 请求时间
     */
    @ApiModelProperty("请求时间")
    private String requestDate;
    /**
     * 出款状态
     */
    @ApiModelProperty("出款状态")
    private String transferStatusCode;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public String getBankMsg() {
        return bankMsg;
    }

    public void setBankMsg(String bankMsg) {
        this.bankMsg = bankMsg;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankTrxStatusCode() {
        return bankTrxStatusCode;
    }

    public void setBankTrxStatusCode(String bankTrxStatusCode) {
        this.bankTrxStatusCode = bankTrxStatusCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(String realAmount) {
        this.realAmount = realAmount;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getTransferStatusCode() {
        return transferStatusCode;
    }

    public void setTransferStatusCode(String transferStatusCode) {
        this.transferStatusCode = transferStatusCode;
    }
}
