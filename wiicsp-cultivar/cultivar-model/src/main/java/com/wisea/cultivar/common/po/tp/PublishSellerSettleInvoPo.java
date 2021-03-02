package com.wisea.cultivar.common.po.tp;

import com.wisea.cloud.model.annotation.Check;

import java.util.List;

/**
 * @Author:Liangzy(Wisea)
 * @Date:Create in 2018/10/19 上午10:45
 * @Description:用来用户确认结算单发票的开具
 */
public class PublishSellerSettleInvoPo {

    /**
     * 结算单ID集合
     */
    private List<Long> settleBillIdList;

    /**
     * 结算单编号集合
     */
    private List<String> settleBillNum;

    /**
     * 结算单钱集合
     */
    private List<String> settleBillMoney;

    /**
     * 发票类型
     */
    private String invoType;

    /**
     * 发票形式
     */
    private String invoForm;

    /**
     * 发票抬头
     */
    private String invoTitle;

    /**
     * 物流公司名称
     */
    @Check(test = "required")
    private String logisticsCompName;

    /**
     * 物流单号
     */
    @Check(test = "required")
    private String logisticsNum;

    /**
     * 发票状态
     */
    private String invoState;

    /**
     * 作废备注
     */
    private String cancelRemarks;

    /**
     * 发票ID集合
     */
    private List<Long> ids;

    /**
     * 开户行
     * */
    @Check(test = "required")
    private String openBank;

    /**
     * 银行卡号
     * */
    @Check(test = "required")
    private String bankCardNum;

    public String getOpenBank() {
        return openBank;
    }

    public void setOpenBank(String openBank) {
        this.openBank = openBank;
    }

    public String getBankCardNum() {
        return bankCardNum;
    }

    public void setBankCardNum(String bankCardNum) {
        this.bankCardNum = bankCardNum;
    }

    public List<Long> getSettleBillIdList() {
        return settleBillIdList;
    }

    public void setSettleBillIdList(List<Long> settleBillIdList) {
        this.settleBillIdList = settleBillIdList;
    }

    public List<String> getSettleBillNum() {
        return settleBillNum;
    }

    public void setSettleBillNum(List<String> settleBillNum) {
        this.settleBillNum = settleBillNum;
    }

    public List<String> getSettleBillMoney() {
        return settleBillMoney;
    }

    public void setSettleBillMoney(List<String> settleBillMoney) {
        this.settleBillMoney = settleBillMoney;
    }

    public String getInvoType() {
        return invoType;
    }

    public void setInvoType(String invoType) {
        this.invoType = invoType;
    }

    public String getInvoForm() {
        return invoForm;
    }

    public void setInvoForm(String invoForm) {
        this.invoForm = invoForm;
    }

    public String getInvoTitle() {
        return invoTitle;
    }

    public void setInvoTitle(String invoTitle) {
        this.invoTitle = invoTitle;
    }

    public String getLogisticsCompName() {
        return logisticsCompName;
    }

    public void setLogisticsCompName(String logisticsCompName) {
        this.logisticsCompName = logisticsCompName;
    }

    public String getLogisticsNum() {
        return logisticsNum;
    }

    public void setLogisticsNum(String logisticsNum) {
        this.logisticsNum = logisticsNum;
    }

    public String getInvoState() {
        return invoState;
    }

    public void setInvoState(String invoState) {
        this.invoState = invoState;
    }

    public String getCancelRemarks() {
        return cancelRemarks;
    }

    public void setCancelRemarks(String cancelRemarks) {
        this.cancelRemarks = cancelRemarks;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
