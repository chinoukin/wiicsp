package com.wisea.cultivar.plant.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

public class SerListMage extends DataLongEntity<SerListMage> {
    /**
     * 会员id（种植户）
     */
    private Long membId;

    /**
     * 商品发布id
     */
    private Long commPubId;

    /**
     * 服务单编号
     */
    private String serListNo;

    /**
     * 数量
     */
    private Integer num;

    /**
     * 总价
     */
    private Double totalPrice;

    /**
     * 联系人
     */
    private String conter;

    /**
     * 联系人手机号
     */
    private String contTel;

    /**
     * 服务日期
     */
    private OffsetDateTime serDate;

    /**
     * 服务地区省
     */
    private String serAreaProv;

    /**
     * 服务地区市
     */
    private String serAreaCity;

    /**
     * 服务地区区县
     */
    private String serAreaCou;

    /**
     * 服务详细地址
     */
    private String serAreaAddress;

    /**
     * 留言
     */
    private String leavingMessage;

    /**
     * 服务单状态类型
     */
    private String serListStateType;

    /**
     * 预约下单时间
     */
    private OffsetDateTime subscribeDate;

    /**
     * 单价
     */
    private Double price;
    /**
     * 取消原因
     */
    private String serListCancelReason;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public Long getCommPubId() {
        return commPubId;
    }

    public void setCommPubId(Long commPubId) {
        this.commPubId = commPubId;
    }

    public String getSerListNo() {
        return serListNo;
    }

    public void setSerListNo(String serListNo) {
        this.serListNo = serListNo;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getConter() {
        return conter;
    }

    public void setConter(String conter) {
        this.conter = conter;
    }

    public String getContTel() {
        return contTel;
    }

    public void setContTel(String contTel) {
        this.contTel = contTel;
    }

    public OffsetDateTime getSerDate() {
        return serDate;
    }

    public void setSerDate(OffsetDateTime serDate) {
        this.serDate = serDate;
    }

    public String getSerAreaProv() {
        return serAreaProv;
    }

    public void setSerAreaProv(String serAreaProv) {
        this.serAreaProv = serAreaProv;
    }

    public String getSerAreaCity() {
        return serAreaCity;
    }

    public void setSerAreaCity(String serAreaCity) {
        this.serAreaCity = serAreaCity;
    }

    public String getSerAreaCou() {
        return serAreaCou;
    }

    public void setSerAreaCou(String serAreaCou) {
        this.serAreaCou = serAreaCou;
    }

    public String getSerAreaAddress() {
        return serAreaAddress;
    }

    public void setSerAreaAddress(String serAreaAddress) {
        this.serAreaAddress = serAreaAddress;
    }

    public String getLeavingMessage() {
        return leavingMessage;
    }

    public void setLeavingMessage(String leavingMessage) {
        this.leavingMessage = leavingMessage;
    }

    public String getSerListStateType() {
        return serListStateType;
    }

    public void setSerListStateType(String serListStateType) {
        this.serListStateType = serListStateType;
    }

    public OffsetDateTime getSubscribeDate() {
        return subscribeDate;
    }

    public void setSubscribeDate(OffsetDateTime subscribeDate) {
        this.subscribeDate = subscribeDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSerListCancelReason() {
        return serListCancelReason;
    }

    public void setSerListCancelReason(String serListCancelReason) {
        this.serListCancelReason = serListCancelReason;
    }
}
