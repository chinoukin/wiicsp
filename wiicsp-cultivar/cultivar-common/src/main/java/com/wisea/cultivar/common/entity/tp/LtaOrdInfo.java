package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

public class LtaOrdInfo extends DataLongEntity<LtaOrdInfo> {
    /**
     * 长协订单编号
     */
    private String ltaOrdNumb;

    /**
     * 合同id
     */
    private Long ltaContId;

    /**
     * 合同编号
     */
    private String ltaContNumb;

    /**
     * 结算支付类型
     */
    private String payMethodType;

    /**
     * 订单发货类型
     */
    private String ordSendType;

    /**
     * 配送信息类型
     */
    private String deliveryInfoType;

    /**
     * 来源类型
     */
    private String sourceType;

    /**
     * 最晚到货日期
     */
    private OffsetDateTime latestArrivalDate;

    /**
     * 给卖家留言
     */
    private String leaveMessSeller;

    /**
     * 收货人姓名
     */
    private String receName;

    /**
     * 手机号码
     */
    private String tel;

    /**
     * 收货地址省
     */
    private String receAddressProv;

    /**
     * 收货地址市
     */
    private String receAddressCity;

    /**
     * 收货地址区县
     */
    private String receAddressCou;

    /**
     * 收货地址街道
     */
    private String receAddressStreet;

    /**
     * 详细地址
     */
    private String receAddressDetail;

    /**
     * 邮政编码
     */
    private String zipCode;

    /**
     * 提货人姓名
     */
    private String consigneeName;

    /**
     * 提货人手机号
     */
    private String consigneeTel;

    /**
     * 商品总金额
     */
    private Double commAmount;

    /**
     * 运费
     */
    private Double freight;

    /**
     * 应付总金额
     */
    private Double yfAmount;

    /**
     * 订单状态类型
     */
    private String orderStateType;

    /**
     * 自提点名称
     */
    private String ztName;

    /**
     * 自提码
     */
    private String ztNum;

    /**
     * 自提时间
     */
    private OffsetDateTime ztDate;

    /**
     * 自提地省
     */
    private String ztAddressProv;

    /**
     * 自提地市
     */
    private String ztAddressCity;

    /**
     * 自提地区县
     */
    private String ztAddressCou;

    /**
     * 自提详细地址
     */
    private String ztAddress;

    /**
     * 自提点联系人
     */
    private String ztContactsName;

    /**
     * 自提点联系电话
     */
    private String ztTel;

    /**
     * 自提点营业时间
     */
    private String ztBusinessHours;

    /**
     * 买方下单时间
     */
    private OffsetDateTime buyerOrdDate;

    /**
     * 卖方确认订单时间
     */
    private OffsetDateTime sellerConfirmOrdDate;

    /**
     * 买方支付时间
     */
    private OffsetDateTime buyerPayDate;

    /**
     * 商家发货时间
     */
    private OffsetDateTime sellerSendDate;

    /**
     * 订单完成时间
     */
    private OffsetDateTime ordCompleteDate;

    /**
     * 物流公司id
     */
    private Long logisticsCompId;

    /**
     * 物流单号
     */
    private String logisticsNum;

    /**
     * 物流公司联系电话
     */
    private String logisticsCompTel;

    /**
     * 订单取消原因id
     */
    private Long ordCancelReasonId;

    /**
     * 订单取消时间
     */
    private OffsetDateTime ordCancelDate;

    /**
     * 备注订单
     */
    private String remarkOrd;

    /**
     * 买家删除标记
     */
    private String buyerDelFlag;

    /**
     * 卖家删除标记
     */
    private String sellerDelFlag;

    /**
     * 确认收货截止日期
     */
    private OffsetDateTime confirmDeadLineDate;

    /**
     * 确认收货日期
     */
    private OffsetDateTime confirmDate;

    /**
     * 付款截止日期
     */
    private OffsetDateTime payDeadDate;

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
     * 商品发布类型
     */
    private String commPubType;

    /**
     * 供货方式类型
     */
    private String supplyModeType;

    /**
     * 物流服务类型
     */
    private String logisticsSerType;

    /**
     * 订单商品数量
     **/
    private Integer commTotalCount;

    /**
     * 平台服务费
     **/
    private Double platfCost;

    public String getLtaOrdNumb() {
        return ltaOrdNumb;
    }

    public void setLtaOrdNumb(String ltaOrdNumb) {
        this.ltaOrdNumb = ltaOrdNumb;
    }

    public Long getLtaContId() {
        return ltaContId;
    }

    public void setLtaContId(Long ltaContId) {
        this.ltaContId = ltaContId;
    }

    public String getLtaContNumb() {
        return ltaContNumb;
    }

    public void setLtaContNumb(String ltaContNumb) {
        this.ltaContNumb = ltaContNumb;
    }

    public String getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(String payMethodType) {
        this.payMethodType = payMethodType;
    }

    public String getOrdSendType() {
        return ordSendType;
    }

    public void setOrdSendType(String ordSendType) {
        this.ordSendType = ordSendType;
    }

    public String getDeliveryInfoType() {
        return deliveryInfoType;
    }

    public void setDeliveryInfoType(String deliveryInfoType) {
        this.deliveryInfoType = deliveryInfoType;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public OffsetDateTime getLatestArrivalDate() {
        return latestArrivalDate;
    }

    public void setLatestArrivalDate(OffsetDateTime latestArrivalDate) {
        this.latestArrivalDate = latestArrivalDate;
    }

    public String getLeaveMessSeller() {
        return leaveMessSeller;
    }

    public void setLeaveMessSeller(String leaveMessSeller) {
        this.leaveMessSeller = leaveMessSeller;
    }

    public String getReceName() {
        return receName;
    }

    public void setReceName(String receName) {
        this.receName = receName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getReceAddressProv() {
        return receAddressProv;
    }

    public void setReceAddressProv(String receAddressProv) {
        this.receAddressProv = receAddressProv;
    }

    public String getReceAddressCity() {
        return receAddressCity;
    }

    public void setReceAddressCity(String receAddressCity) {
        this.receAddressCity = receAddressCity;
    }

    public String getReceAddressCou() {
        return receAddressCou;
    }

    public void setReceAddressCou(String receAddressCou) {
        this.receAddressCou = receAddressCou;
    }

    public String getReceAddressStreet() {
        return receAddressStreet;
    }

    public void setReceAddressStreet(String receAddressStreet) {
        this.receAddressStreet = receAddressStreet;
    }

    public String getReceAddressDetail() {
        return receAddressDetail;
    }

    public void setReceAddressDetail(String receAddressDetail) {
        this.receAddressDetail = receAddressDetail;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    public String getConsigneeTel() {
        return consigneeTel;
    }

    public void setConsigneeTel(String consigneeTel) {
        this.consigneeTel = consigneeTel;
    }

    public Double getCommAmount() {
        return commAmount;
    }

    public void setCommAmount(Double commAmount) {
        this.commAmount = commAmount;
    }

    public Double getFreight() {
        return freight;
    }

    public void setFreight(Double freight) {
        this.freight = freight;
    }

    public Double getYfAmount() {
        return yfAmount;
    }

    public void setYfAmount(Double yfAmount) {
        this.yfAmount = yfAmount;
    }

    public String getOrderStateType() {
        return orderStateType;
    }

    public void setOrderStateType(String orderStateType) {
        this.orderStateType = orderStateType;
    }

    public String getZtName() {
        return ztName;
    }

    public void setZtName(String ztName) {
        this.ztName = ztName;
    }

    public String getZtNum() {
        return ztNum;
    }

    public void setZtNum(String ztNum) {
        this.ztNum = ztNum;
    }

    public OffsetDateTime getZtDate() {
        return ztDate;
    }

    public void setZtDate(OffsetDateTime ztDate) {
        this.ztDate = ztDate;
    }

    public String getZtAddressProv() {
        return ztAddressProv;
    }

    public void setZtAddressProv(String ztAddressProv) {
        this.ztAddressProv = ztAddressProv;
    }

    public String getZtAddressCity() {
        return ztAddressCity;
    }

    public void setZtAddressCity(String ztAddressCity) {
        this.ztAddressCity = ztAddressCity;
    }

    public String getZtAddressCou() {
        return ztAddressCou;
    }

    public void setZtAddressCou(String ztAddressCou) {
        this.ztAddressCou = ztAddressCou;
    }

    public String getZtAddress() {
        return ztAddress;
    }

    public void setZtAddress(String ztAddress) {
        this.ztAddress = ztAddress;
    }

    public String getZtContactsName() {
        return ztContactsName;
    }

    public void setZtContactsName(String ztContactsName) {
        this.ztContactsName = ztContactsName;
    }

    public String getZtTel() {
        return ztTel;
    }

    public void setZtTel(String ztTel) {
        this.ztTel = ztTel;
    }

    public String getZtBusinessHours() {
        return ztBusinessHours;
    }

    public void setZtBusinessHours(String ztBusinessHours) {
        this.ztBusinessHours = ztBusinessHours;
    }

    public OffsetDateTime getBuyerOrdDate() {
        return buyerOrdDate;
    }

    public void setBuyerOrdDate(OffsetDateTime buyerOrdDate) {
        this.buyerOrdDate = buyerOrdDate;
    }

    public OffsetDateTime getSellerConfirmOrdDate() {
        return sellerConfirmOrdDate;
    }

    public void setSellerConfirmOrdDate(OffsetDateTime sellerConfirmOrdDate) {
        this.sellerConfirmOrdDate = sellerConfirmOrdDate;
    }

    public OffsetDateTime getBuyerPayDate() {
        return buyerPayDate;
    }

    public void setBuyerPayDate(OffsetDateTime buyerPayDate) {
        this.buyerPayDate = buyerPayDate;
    }

    public OffsetDateTime getSellerSendDate() {
        return sellerSendDate;
    }

    public void setSellerSendDate(OffsetDateTime sellerSendDate) {
        this.sellerSendDate = sellerSendDate;
    }

    public OffsetDateTime getOrdCompleteDate() {
        return ordCompleteDate;
    }

    public void setOrdCompleteDate(OffsetDateTime ordCompleteDate) {
        this.ordCompleteDate = ordCompleteDate;
    }

    public Long getLogisticsCompId() {
        return logisticsCompId;
    }

    public void setLogisticsCompId(Long logisticsCompId) {
        this.logisticsCompId = logisticsCompId;
    }

    public String getLogisticsNum() {
        return logisticsNum;
    }

    public void setLogisticsNum(String logisticsNum) {
        this.logisticsNum = logisticsNum;
    }

    public String getLogisticsCompTel() {
        return logisticsCompTel;
    }

    public void setLogisticsCompTel(String logisticsCompTel) {
        this.logisticsCompTel = logisticsCompTel;
    }

    public Long getOrdCancelReasonId() {
        return ordCancelReasonId;
    }

    public void setOrdCancelReasonId(Long ordCancelReasonId) {
        this.ordCancelReasonId = ordCancelReasonId;
    }

    public OffsetDateTime getOrdCancelDate() {
        return ordCancelDate;
    }

    public void setOrdCancelDate(OffsetDateTime ordCancelDate) {
        this.ordCancelDate = ordCancelDate;
    }

    public String getRemarkOrd() {
        return remarkOrd;
    }

    public void setRemarkOrd(String remarkOrd) {
        this.remarkOrd = remarkOrd;
    }

    public String getBuyerDelFlag() {
        return buyerDelFlag;
    }

    public void setBuyerDelFlag(String buyerDelFlag) {
        this.buyerDelFlag = buyerDelFlag;
    }

    public String getSellerDelFlag() {
        return sellerDelFlag;
    }

    public void setSellerDelFlag(String sellerDelFlag) {
        this.sellerDelFlag = sellerDelFlag;
    }

    public OffsetDateTime getConfirmDeadLineDate() {
        return confirmDeadLineDate;
    }

    public void setConfirmDeadLineDate(OffsetDateTime confirmDeadLineDate) {
        this.confirmDeadLineDate = confirmDeadLineDate;
    }

    public OffsetDateTime getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(OffsetDateTime confirmDate) {
        this.confirmDate = confirmDate;
    }

    public OffsetDateTime getPayDeadDate() {
        return payDeadDate;
    }

    public void setPayDeadDate(OffsetDateTime payDeadDate) {
        this.payDeadDate = payDeadDate;
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

    public String getCommPubType() {
        return commPubType;
    }

    public void setCommPubType(String commPubType) {
        this.commPubType = commPubType;
    }

    public String getSupplyModeType() {
        return supplyModeType;
    }

    public void setSupplyModeType(String supplyModeType) {
        this.supplyModeType = supplyModeType;
    }

    public String getLogisticsSerType() {
        return logisticsSerType;
    }

    public void setLogisticsSerType(String logisticsSerType) {
        this.logisticsSerType = logisticsSerType;
    }

    public Integer getCommTotalCount() {
        return commTotalCount;
    }

    public void setCommTotalCount(Integer commTotalCount) {
        this.commTotalCount = commTotalCount;
    }

    public Double getPlatfCost() {
        return platfCost;
    }

    public void setPlatfCost(Double platfCost) {
        this.platfCost = platfCost;
    }
}
