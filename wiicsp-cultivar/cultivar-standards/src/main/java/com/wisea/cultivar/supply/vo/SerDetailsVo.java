package com.wisea.cultivar.supply.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * 服务单详情
 * @author chengq
 * @date 2020/8/12 10:18
 */
public class SerDetailsVo {

    /**
     * 服务单id
     */
    @ApiModelProperty("服务单id")
    @JsonSerialize(using = IdSerializer.class)
    private Long id;

    @ApiModelProperty("联系人")
    private String conter;

    @ApiModelProperty("联系电话")
    private String contTel;

    @ApiModelProperty("买家id")
    private String buyerId;

    @ApiModelProperty("服务地区省")
    private String serAreaProv;

    @ApiModelProperty("服务地区市")
    private String serAreaCity;

    @ApiModelProperty("服务地区县")
    private String serAreaCou;

    @ApiModelProperty("服务地区省")
    private String serAreaProvId;

    @ApiModelProperty("服务地区市")
    private String serAreaCityId;

    @ApiModelProperty("服务地区县")
    private String serAreaCouId;

    @ApiModelProperty("服务地详细地址")
    private String serAreaAddress;

    @ApiModelProperty("服务日期")
    private String serDate;

    /**
     * 商品图片
     */
    @ApiModelProperty("商品图片")
    private String pictureUrl;

    /**
     * 图片类型
     */
    @ApiModelProperty("图片类型 0-图片 1-视频")
    private String pictureType;

    /**
     * 商品标题
     */
    @ApiModelProperty("商品标题")
    private String commTitle;

    /**
     * 数量
     */
    @ApiModelProperty(value = "数量", example = "500株")
    private String num;

    /**
     * 总价
     */
    @ApiModelProperty(value = "总价", example = "3.00")
    private String totalPrice;

    /**
     * 服务单编号
     */
    @ApiModelProperty("服务单编号")
    private String serListNo;

    /**
     * 单位
     */
    @ApiModelProperty("计数单位")
    private String measUnitName;

    /**
     * 预约时间
     */
    @ApiModelProperty(value = "预约时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime subscribeDate;

    /**
     * 预约时间
     */
    @ApiModelProperty(value = "到期时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime endDate;

    /**
     * 商品总额
     */
    @ApiModelProperty(value = "商品总额", example = "¥3.00")
    private String totalAmount;

    /**
     * 商品总额
     */
    @ApiModelProperty(value = "联系人账号")
    private String loginName;

    @ApiModelProperty(value = "取消原因")
    private String serListCancelReason;

    @ApiModelProperty(value = "取消时间")
    private String serListCancelDate;

    /**
     * 剩余时间
     */
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime residueDate;

    /**
     * 剩余时间
     */
    @ApiModelProperty(value = "留言")
    private String leavingMessage;

    /**
     * 服务单状态
     */
    @ApiModelProperty(value = "服务单状态 0-待确认 1-待服务 2-服务中 3-已取消 4-已完成")
    private String stateType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getSerDate() {
        return serDate;
    }

    public void setSerDate(String serDate) {
        this.serDate = serDate;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getPictureType() {
        return pictureType;
    }

    public void setPictureType(String pictureType) {
        this.pictureType = pictureType;
    }

    public String getCommTitle() {
        return commTitle;
    }

    public void setCommTitle(String commTitle) {
        this.commTitle = commTitle;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getSerListNo() {
        return serListNo;
    }

    public void setSerListNo(String serListNo) {
        this.serListNo = serListNo;
    }

    public OffsetDateTime getSubscribeDate() {
        return subscribeDate;
    }

    public void setSubscribeDate(OffsetDateTime subscribeDate) {
        this.subscribeDate = subscribeDate;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public OffsetDateTime getResidueDate() {
        return residueDate;
    }

    public void setResidueDate(OffsetDateTime residueDate) {
        this.residueDate = residueDate;
    }

    public String getLeavingMessage() {
        return leavingMessage;
    }

    public void setLeavingMessage(String leavingMessage) {
        this.leavingMessage = leavingMessage;
    }

    public String getStateType() {
        return stateType;
    }

    public void setStateType(String stateType) {
        this.stateType = stateType;
    }

    public String getMeasUnitName() {
        return measUnitName;
    }

    public void setMeasUnitName(String measUnitName) {
        this.measUnitName = measUnitName;
    }

    public String getSerListCancelReason() {
        return serListCancelReason;
    }

    public void setSerListCancelReason(String serListCancelReason) {
        this.serListCancelReason = serListCancelReason;
    }

    public String getSerListCancelDate() {
        return serListCancelDate;
    }

    public void setSerListCancelDate(String serListCancelDate) {
        this.serListCancelDate = serListCancelDate;
    }

    public OffsetDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(OffsetDateTime endDate) {
        this.endDate = endDate;
    }

    public String getSerAreaProvId() {
        return serAreaProvId;
    }

    public void setSerAreaProvId(String serAreaProvId) {
        this.serAreaProvId = serAreaProvId;
    }

    public String getSerAreaCityId() {
        return serAreaCityId;
    }

    public void setSerAreaCityId(String serAreaCityId) {
        this.serAreaCityId = serAreaCityId;
    }

    public String getSerAreaCouId() {
        return serAreaCouId;
    }

    public void setSerAreaCouId(String serAreaCouId) {
        this.serAreaCouId = serAreaCouId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }
}
