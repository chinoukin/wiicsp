package com.wisea.cultivar.common.entity.tp;

import java.time.OffsetDateTime;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * refund_comm_appl 表实体
 * 退货申请
 * 2018/09/30 09:46:17
 */
public class RefundCommAppl extends DataLongEntity<RefundCommAppl> {
    private static final long serialVersionUID = 1L;

    /**
     * 买方ID
     */
    private Long buyerId;

    /**
     * 卖方ID
     */
    private Long sellerId;

    /**
     * 订单商品id
     */
    private Long ordCommId;

    /**
     * 订单编号
     */
    private String ordNum;

    /**
     * 服务单号
     */
    private String serNum;

    /**
     * 退货状态
     */
    private String refundCommState;

    /**
     * 客户姓名
     */
    private String custName;

    /**
     * 手机号
     */
    private String tel;

    /**
     * 退款方式
     */
    private String refundModeType;

    /**
     * 退货原因
     */
    private Long refundReasonId;

    /**
     * 问题描述
     */
    private String refundDesc;

    /**
     * 退货数量
     */
    private Integer refundCounts;

    /**
     * 应退金额
     */
    private Double shouldRefundAmount;

    /**
     * 应退运费金额
     */
    private Double shouldYfAmount;

    /**
     * 商品总额(申请退款金额)
     */
    private Double commTotalAmount;

    /**
     * 平台服务费
     */
    private Double platfCost;

    /**
     * 申请时间
     */
    private OffsetDateTime applDate;

    /**
     * 收货人姓名
     */
    private String receName;

    /**
     * 收货人手机号
     */
    private String receTel;

    /**
     * 地区省
     */
    private String addressProv;

    /**
     * 地区市
     */
    private String addressCity;

    /**
     * 地区区县
     */
    private String addressCou;

    /**
     * 详细地址
     */
    private String addressDetail;

    /**
     * 邮编
     */
    private String zipCode;

    /**
     * 处理方式类型
     */
    private String handleType;

    /**
     * 服务类型
     */
    private String serType;

    /**
     * 审核服务单时间
     */
    private OffsetDateTime examSerBillDate;

    /**
     * 发货时间
     */
    private OffsetDateTime sendDate;

    /**
     * 完成时间
     */
    private OffsetDateTime doneDate;

    /**
     * 物流公司名称
     */
    private String logisticsCompName;

    /**
     * 物流单号
     */
    private String logisticsNum;

    /**
     * 货物状态类型
     */
    private String goodsStateType;

    /**
     * 拒收原因
     */
    private String rejeReason;

    /**
     * 退款唯一请求id
     */
    private String outRequestNo;

    /**
     * 商家处理备注（新增）
     */
    private String sellerHandleRemarks;

    /**
     * 买家发货类型
     */
    private String buyerSendType;

    /**
     * 运送人
     */
    private String sender;

    /**
     * 运送人联系电话
     */
    private String senderTel;

    /**
     * 车船号
     */
    private String cchNum;

    /**
     * 处理方类型
     */
    private String handlerType;

    /**
     * 异议类型
     */
    private String examDissType;

    /**
     * 优惠金额
     */
    private Double prefAmount;

    /**
     * 账期服务费
     */
    private Double zqSerCost;

    /**
     * 实退金额
     */
    private Double stAmount;

    /**
     * 买家货物状态
     */
    private String buyerCommState;

    /**
     * 补损状态
     */
    private String bsStateType;

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Long getOrdCommId() {
        return ordCommId;
    }

    public void setOrdCommId(Long ordCommId) {
        this.ordCommId = ordCommId;
    }

    public String getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
    }

    public String getSerNum() {
        return serNum;
    }

    public void setSerNum(String serNum) {
        this.serNum = serNum;
    }

    public String getRefundCommState() {
        return refundCommState;
    }

    public void setRefundCommState(String refundCommState) {
        this.refundCommState = refundCommState;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getRefundModeType() {
        return refundModeType;
    }

    public void setRefundModeType(String refundModeType) {
        this.refundModeType = refundModeType;
    }

    public Long getRefundReasonId() {
        return refundReasonId;
    }

    public void setRefundReasonId(Long refundReasonId) {
        this.refundReasonId = refundReasonId;
    }

    public String getRefundDesc() {
        return refundDesc;
    }

    public void setRefundDesc(String refundDesc) {
        this.refundDesc = refundDesc;
    }

    public Integer getRefundCounts() {
        return refundCounts;
    }

    public void setRefundCounts(Integer refundCounts) {
        this.refundCounts = refundCounts;
    }

    public Double getShouldRefundAmount() {
        return shouldRefundAmount;
    }

    public void setShouldRefundAmount(Double shouldRefundAmount) {
        this.shouldRefundAmount = shouldRefundAmount;
    }

    public Double getShouldYfAmount() {
        return shouldYfAmount;
    }

    public void setShouldYfAmount(Double shouldYfAmount) {
        this.shouldYfAmount = shouldYfAmount;
    }

    public Double getCommTotalAmount() {
        return commTotalAmount;
    }

    public void setCommTotalAmount(Double commTotalAmount) {
        this.commTotalAmount = commTotalAmount;
    }

    public Double getPlatfCost() {
        return platfCost;
    }

    public void setPlatfCost(Double platfCost) {
        this.platfCost = platfCost;
    }

    public OffsetDateTime getApplDate() {
        return applDate;
    }

    public void setApplDate(OffsetDateTime applDate) {
        this.applDate = applDate;
    }

    public String getReceName() {
        return receName;
    }

    public void setReceName(String receName) {
        this.receName = receName;
    }

    public String getReceTel() {
        return receTel;
    }

    public void setReceTel(String receTel) {
        this.receTel = receTel;
    }

    public String getAddressProv() {
        return addressProv;
    }

    public void setAddressProv(String addressProv) {
        this.addressProv = addressProv;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressCou() {
        return addressCou;
    }

    public void setAddressCou(String addressCou) {
        this.addressCou = addressCou;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getHandleType() {
        return handleType;
    }

    public void setHandleType(String handleType) {
        this.handleType = handleType;
    }

    public String getSerType() {
        return serType;
    }

    public void setSerType(String serType) {
        this.serType = serType;
    }

    public OffsetDateTime getExamSerBillDate() {
        return examSerBillDate;
    }

    public void setExamSerBillDate(OffsetDateTime examSerBillDate) {
        this.examSerBillDate = examSerBillDate;
    }

    public OffsetDateTime getSendDate() {
        return sendDate;
    }

    public void setSendDate(OffsetDateTime sendDate) {
        this.sendDate = sendDate;
    }

    public OffsetDateTime getDoneDate() {
        return doneDate;
    }

    public void setDoneDate(OffsetDateTime doneDate) {
        this.doneDate = doneDate;
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

    public String getGoodsStateType() {
        return goodsStateType;
    }

    public void setGoodsStateType(String goodsStateType) {
        this.goodsStateType = goodsStateType;
    }

    public String getRejeReason() {
        return rejeReason;
    }

    public void setRejeReason(String rejeReason) {
        this.rejeReason = rejeReason;
    }

    public String getOutRequestNo() {
        return outRequestNo;
    }

    public void setOutRequestNo(String outRequestNo) {
        this.outRequestNo = outRequestNo;
    }

    public String getSellerHandleRemarks() {
        return sellerHandleRemarks;
    }

    public void setSellerHandleRemarks(String sellerHandleRemarks) {
        this.sellerHandleRemarks = sellerHandleRemarks;
    }

    public String getBuyerSendType() {
        return buyerSendType;
    }

    public void setBuyerSendType(String buyerSendType) {
        this.buyerSendType = buyerSendType;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSenderTel() {
        return senderTel;
    }

    public void setSenderTel(String senderTel) {
        this.senderTel = senderTel;
    }

    public String getCchNum() {
        return cchNum;
    }

    public void setCchNum(String cchNum) {
        this.cchNum = cchNum;
    }

    public String getHandlerType() {
        return handlerType;
    }

    public void setHandlerType(String handlerType) {
        this.handlerType = handlerType;
    }

    public String getExamDissType() {
        return examDissType;
    }

    public void setExamDissType(String examDissType) {
        this.examDissType = examDissType;
    }

    public Double getPrefAmount() {
        return prefAmount;
    }

    public void setPrefAmount(Double prefAmount) {
        this.prefAmount = prefAmount;
    }

    public Double getZqSerCost() {
        return zqSerCost;
    }

    public void setZqSerCost(Double zqSerCost) {
        this.zqSerCost = zqSerCost;
    }

    public Double getStAmount() {
        return stAmount;
    }

    public void setStAmount(Double stAmount) {
        this.stAmount = stAmount;
    }

    public String getBuyerCommState() {
        return buyerCommState;
    }

    public void setBuyerCommState(String buyerCommState) {
        this.buyerCommState = buyerCommState;
    }

    public String getBsStateType() {
        return bsStateType;
    }

    public void setBsStateType(String bsStateType) {
        this.bsStateType = bsStateType;
    }
}
