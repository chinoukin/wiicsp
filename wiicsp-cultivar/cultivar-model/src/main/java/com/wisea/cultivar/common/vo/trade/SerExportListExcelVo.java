package com.wisea.cultivar.common.vo.trade;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.util.excel.annotation.ExcelField;
import com.wisea.cloud.model.annotation.IdSerializer;

import java.time.OffsetDateTime;

/**
 * 会员相关导出数据VO
 *
 * @author wangh(wisea)
 *
 * @date 2020年6月19日
 * @version 1.0
 */
public class SerExportListExcelVo {

    @JsonSerialize(using = IdSerializer.class)
    private Long id;

    @ExcelField(title = "服务单编号", sort = 60)
    private String serListNo;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ExcelField(title = "预约下单时间", sort = 0)
    private OffsetDateTime subscribeDate;

    @ExcelField(title = "客户账号", sort = 30)
    private String buyerAccount;

    @ExcelField(title = "服务商账号", sort = 40)
    private String sellerAccount;

    @ExcelField(title = "服务单总金额", sort = 50)
    private Double totalPrice;

    @ExcelField(title = "状态", sort = 70)
    private String serListStateTypeValue;

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

    public OffsetDateTime getSubscribeDate() {
        return subscribeDate;
    }

    public void setSubscribeDate(OffsetDateTime subscribeDate) {
        this.subscribeDate = subscribeDate;
    }

    public String getBuyerAccount() {
        return buyerAccount;
    }

    public void setBuyerAccount(String buyerAccount) {
        this.buyerAccount = buyerAccount;
    }

    public String getSellerAccount() {
        return sellerAccount;
    }

    public void setSellerAccount(String sellerAccount) {
        this.sellerAccount = sellerAccount;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getSerListStateTypeValue() {
        return serListStateTypeValue;
    }

    public void setSerListStateTypeValue(String serListStateTypeValue) {
        this.serListStateTypeValue = serListStateTypeValue;
    }
}
