package com.wisea.cultivar.plant.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cultivar.plant.config.OffsetDateSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.List;

@ApiModel("SerListMage详细信息Vo")
public class SerListMageInfoVo {

    @ApiModelProperty(value="服务单id")
    private Long id;

    @ApiModelProperty(value="会员id（种植户）")
    private Long membId;

    @ApiModelProperty(value="商品发布id")
    private Long commPubId;

    @ApiModelProperty(value="服务单编号")
    private String serListNo;

    @ApiModelProperty(value="数量")
    private Integer num;

    @ApiModelProperty(value="总价")
    private Double totalPrice;

    @ApiModelProperty(value="联系人")
    private String conter;

    @ApiModelProperty(value="联系人手机号")
    private String contTel;

    @ApiModelProperty(value="服务日期")
    @JsonSerialize(
            using = OffsetDateSerializer.class
    )
    private OffsetDateTime serDate;

    @ApiModelProperty(value="服务地区省")
    private String serAreaProv;

    @ApiModelProperty(value="服务地区市")
    private String serAreaCity;

    @ApiModelProperty(value="服务地区区县")
    private String serAreaCou;

    @ApiModelProperty(value="计量单位名称")
    private String measUnitName;

    @ApiModelProperty(value="服务详细地址")
    private String serAreaAddress;

    @ApiModelProperty(value="留言")
    private String leavingMessage;

    @ApiModelProperty(value="服务单状态类型")
    private String serListStateType;

    @ApiModelProperty(value="预约下单时间")
    private OffsetDateTime subscribeDate;

    @ApiModelProperty(value="单价")
    private Double price;

    @ApiModelProperty(value="产品名称")
    private String commTitle;

    @ApiModelProperty(value="取消原因")
    private String serListCancelReason;

    @ApiModelProperty(value="自动取消返回的是小时和自动确认返回的是天数限制")
    private Integer limitDays;

    @ApiModelProperty(value="操作日志")
    private List<SerListOpreateInfoInfoVo> serOperateList;


    @ApiModelProperty(value="产品图片url")
    private String url;

    @ApiModelProperty(value="店铺名称")
    private String entpName;

    @ApiModelProperty(value="商家手机号 注册时候的手机号")
    private String registTel;

    @ApiModelProperty(value="商家id")
    private Long businessId;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLimitDays() {
        return limitDays;
    }

    public void setLimitDays(Integer limitDays) {
        this.limitDays = limitDays;
    }

    public List<SerListOpreateInfoInfoVo> getSerOperateList() {
        return serOperateList;
    }

    public void setSerOperateList(List<SerListOpreateInfoInfoVo> serOperateList) {
        this.serOperateList = serOperateList;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEntpName() {
        return entpName;
    }

    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }

    public String getRegistTel() {
        return registTel;
    }

    public void setRegistTel(String registTel) {
        this.registTel = registTel;
    }

    public String getCommTitle() {
        return commTitle;
    }

    public void setCommTitle(String commTitle) {
        this.commTitle = commTitle;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public String getMeasUnitName() {
        return measUnitName;
    }

    public void setMeasUnitName(String measUnitName) {
        this.measUnitName = measUnitName;
    }
}
