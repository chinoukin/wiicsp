package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

public class LtaContInfo extends DataLongEntity<LtaContInfo> {
    /**
     * 合同编号
     */
    private String ltaContNumb;

    /**
     * 卖方id
     */
    private Long sellerId;

    /**
     * 买方id
     */
    private Long buyerId;

    /**
     * 合同开始时间
     */
    private OffsetDateTime contStartDate;

    /**
     * 合同结束时间
     */
    private OffsetDateTime contEndDate;

    /**
     * 结算支付类型
     */
    private String payMethodType;

    /**
     * 物流服务类型
     */
    private String logisticsSerType;

    /**
     * 供应商品
     */
    private String supplyComm;

    /**
     * 拟定合同时间
     */
    private OffsetDateTime draftContDate;

    /**
     * 长协合同状态
     */
    private String ltaContStateType;

    /**
     * 合同终止原因
     */
    private String contEndReason;

    /**
     * 申请人
     */
    private String applicanter;

    /**
     * 申请时间
     */
    private OffsetDateTime appDate;

    /**
     * 拒绝申请原因
     */
    private String refuseAppReason;

    /**
     * 取消合同原因
     */
    private String cancelContReason;

    /**
     * 解除申请提出方
     */
    private String buySellFlag;

    /**
     * 商家终止原因
     */
    private String sellerConcelReason;

    /**
     * 商家处理意见类型（同意、拒绝）
     */
    private String sellerOperatType;

    /**
     * 商家处理意见备注
     */
    private String sellerOperatRemarks;

    /**
     * 合同模板
     */
    private String contTemp;

    public String getLtaContNumb() {
        return ltaContNumb;
    }

    public void setLtaContNumb(String ltaContNumb) {
        this.ltaContNumb = ltaContNumb;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public OffsetDateTime getContStartDate() {
        return contStartDate;
    }

    public void setContStartDate(OffsetDateTime contStartDate) {
        this.contStartDate = contStartDate;
    }

    public OffsetDateTime getContEndDate() {
        return contEndDate;
    }

    public void setContEndDate(OffsetDateTime contEndDate) {
        this.contEndDate = contEndDate;
    }

    public String getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(String payMethodType) {
        this.payMethodType = payMethodType;
    }

    public String getLogisticsSerType() {
        return logisticsSerType;
    }

    public void setLogisticsSerType(String logisticsSerType) {
        this.logisticsSerType = logisticsSerType;
    }

    public String getSupplyComm() {
        return supplyComm;
    }

    public void setSupplyComm(String supplyComm) {
        this.supplyComm = supplyComm;
    }

    public OffsetDateTime getDraftContDate() {
        return draftContDate;
    }

    public void setDraftContDate(OffsetDateTime draftContDate) {
        this.draftContDate = draftContDate;
    }

    public String getLtaContStateType() {
        return ltaContStateType;
    }

    public void setLtaContStateType(String ltaContStateType) {
        this.ltaContStateType = ltaContStateType;
    }

    public String getContEndReason() {
        return contEndReason;
    }

    public void setContEndReason(String contEndReason) {
        this.contEndReason = contEndReason;
    }

    public String getApplicanter() {
        return applicanter;
    }

    public void setApplicanter(String applicanter) {
        this.applicanter = applicanter;
    }

    public OffsetDateTime getAppDate() {
        return appDate;
    }

    public void setAppDate(OffsetDateTime appDate) {
        this.appDate = appDate;
    }

    public String getRefuseAppReason() {
        return refuseAppReason;
    }

    public void setRefuseAppReason(String refuseAppReason) {
        this.refuseAppReason = refuseAppReason;
    }

    public String getCancelContReason() {
        return cancelContReason;
    }

    public void setCancelContReason(String cancelContReason) {
        this.cancelContReason = cancelContReason;
    }

    public String getBuySellFlag() {
        return buySellFlag;
    }

    public void setBuySellFlag(String buySellFlag) {
        this.buySellFlag = buySellFlag;
    }

    public String getSellerConcelReason() {
        return sellerConcelReason;
    }

    public void setSellerConcelReason(String sellerConcelReason) {
        this.sellerConcelReason = sellerConcelReason;
    }

    public String getSellerOperatType() {
        return sellerOperatType;
    }

    public void setSellerOperatType(String sellerOperatType) {
        this.sellerOperatType = sellerOperatType;
    }

    public String getSellerOperatRemarks() {
        return sellerOperatRemarks;
    }

    public void setSellerOperatRemarks(String sellerOperatRemarks) {
        this.sellerOperatRemarks = sellerOperatRemarks;
    }

    public String getContTemp() {
        return contTemp;
    }

    public void setContTemp(String contTemp) {
        this.contTemp = contTemp;
    }
}
