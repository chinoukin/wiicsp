package com.wisea.cultivar.supply.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class ZhfwCommPubInfo extends DataLongEntity<ZhfwCommPubInfo> {
    /**
     * 会员id（服务商）
     */
    private Long membId;

    /**
     * 商品标题
     */
    private String commTitle;

    /**
     * 品类id
     */
    private Long commId;

    /**
     * 商品品种id
     */
    private Long commVarietId;

    /**
     * 发货地省
     */
    private String commSendProv;

    /**
     * 发货地市
     */
    private String commSendCity;

    /**
     * 发货区县
     */
    private String commSendCou;

    /**
     * 发货地详细地址
     */
    private String commSendAddress;

    /**
     * 商品描述
     */
    private String commSignature;

    /**
     * 购买须知
     */
    private String notesToBuy;

    /**
     * 商品发布状态
     */
    private String zhfwCommStateType;

    /**
     * 驳回原因（审核意见）
     */
    private String rejectReason;

    /**
     * 审核人id(后台管理员id)
     */
    private Long examId;

    /**
     * 销量
     */
    private Double salesVolume;

    /**
     * 商品编号
     */
    public String commNum;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getCommTitle() {
        return commTitle;
    }

    public void setCommTitle(String commTitle) {
        this.commTitle = commTitle;
    }

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

    public Long getCommVarietId() {
        return commVarietId;
    }

    public void setCommVarietId(Long commVarietId) {
        this.commVarietId = commVarietId;
    }

    public String getCommSendProv() {
        return commSendProv;
    }

    public void setCommSendProv(String commSendProv) {
        this.commSendProv = commSendProv;
    }

    public String getCommSendCity() {
        return commSendCity;
    }

    public void setCommSendCity(String commSendCity) {
        this.commSendCity = commSendCity;
    }

    public String getCommSendCou() {
        return commSendCou;
    }

    public void setCommSendCou(String commSendCou) {
        this.commSendCou = commSendCou;
    }

    public String getCommSendAddress() {
        return commSendAddress;
    }

    public void setCommSendAddress(String commSendAddress) {
        this.commSendAddress = commSendAddress;
    }

    public String getCommSignature() {
        return commSignature;
    }

    public void setCommSignature(String commSignature) {
        this.commSignature = commSignature;
    }

    public String getNotesToBuy() {
        return notesToBuy;
    }

    public void setNotesToBuy(String notesToBuy) {
        this.notesToBuy = notesToBuy;
    }

    public String getZhfwCommStateType() {
        return zhfwCommStateType;
    }

    public void setZhfwCommStateType(String zhfwCommStateType) {
        this.zhfwCommStateType = zhfwCommStateType;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public Double getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(Double salesVolume) {
        this.salesVolume = salesVolume;
    }

    public String getCommNum() {
        return commNum;
    }

    public void setCommNum(String commNum) {
        this.commNum = commNum;
    }
}
