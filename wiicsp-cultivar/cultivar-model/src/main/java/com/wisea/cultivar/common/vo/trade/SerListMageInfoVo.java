package com.wisea.cultivar.common.vo.trade;

import com.wisea.cultivar.common.vo.product.CommPubMessageVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @ClassName: SerListMageInfoVo
 * @Author: tgz
 * @Date: 2020/8/5 9:08
 */
@ApiModel("商家查询服务单详情信息VO")
public class SerListMageInfoVo {

    /***** 订单信息 *****/
    @ApiModelProperty("ID")
    private Long id;
    @ApiModelProperty("服务单编号")
    private String serListNo;
    @ApiModelProperty("服务单状态 {0：待确认1：待服务2：服务中3：已取消}")
    private String serListStateType;
    @ApiModelProperty("服务单状态值")
    private String serListStateTypeValue;
    @ApiModelProperty("预约下单时间")
    private String subscribeDate;
    @ApiModelProperty("买家ID")
    private Long buyerId;
    @ApiModelProperty("客户账号")
    private String buyerAccount;
    @ApiModelProperty("客户名称")
    private String buyerName;
    @ApiModelProperty("服务商ID")
    private Long sellerId;
    @ApiModelProperty("服务商账号")
    private String sellerAccount;
    @ApiModelProperty("服务商名称")
    private String sellerName;

    @ApiModelProperty("服务单总金额")
    private Double totalPrice;

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * 预约信息
     */
    private OrderInfoVo orderInfoVo;

    /**
     * 商品信息
     */
    private CommPubMessageVo commPubMessageVo;

    /**
     * 操作日志
     */
    private List<SerListOpreateInfoVo> serListOpreateInfoVos;

    public String getSubscribeDate() {
        return subscribeDate;
    }

    public void setSubscribeDate(String subscribeDate) {
        this.subscribeDate = subscribeDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerListNo() {
        return serListNo;
    }

    public void setSerListNo(String serListNo) {
        this.serListNo = serListNo;
    }

    public String getSerListStateType() {
        return serListStateType;
    }

    public void setSerListStateType(String serListStateType) {
        this.serListStateType = serListStateType;
    }

    public String getSerListStateTypeValue() {
        return serListStateTypeValue;
    }

    public void setSerListStateTypeValue(String serListStateTypeValue) {
        this.serListStateTypeValue = serListStateTypeValue;
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

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public OrderInfoVo getOrderInfoVo() {
        return orderInfoVo;
    }

    public void setOrderInfoVo(OrderInfoVo orderInfoVo) {
        this.orderInfoVo = orderInfoVo;
    }

    public CommPubMessageVo getCommPubMessageVo() {
        return commPubMessageVo;
    }

    public void setCommPubMessageVo(CommPubMessageVo commPubMessageVo) {
        this.commPubMessageVo = commPubMessageVo;
    }

    public List<SerListOpreateInfoVo> getSerListOpreateInfoVos() {
        return serListOpreateInfoVos;
    }

    public void setSerListOpreateInfoVos(List<SerListOpreateInfoVo> serListOpreateInfoVos) {
        this.serListOpreateInfoVos = serListOpreateInfoVos;
    }
}
