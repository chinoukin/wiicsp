package com.wisea.cultivar.common.vo.tp.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className OrdInvoCommVo
 * @date 2019/4/24 17:59
 * @Description 发票详情-商品信息Vo
 */
@ApiModel("发票详情-商品信息Vo")
public class OrdInvoCommVo {
    @ApiModelProperty("订单商品ID")
    private Long id;
    @ApiModelProperty("商品货号")
    private String commArtNum;
    @ApiModelProperty("商品名称")
    private String commName;
    @ApiModelProperty("商品金额")
    private Double commPriceAmount;
    @ApiModelProperty("商品退款总金额")
    private Double commRefundAmount;
    @ApiModelProperty("商品开票金额")
    private Double commInvoiceAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommArtNum() {
        return commArtNum;
    }

    public void setCommArtNum(String commArtNum) {
        this.commArtNum = commArtNum;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public Double getCommPriceAmount() {
        return commPriceAmount;
    }

    public void setCommPriceAmount(Double commPriceAmount) {
        this.commPriceAmount = commPriceAmount;
    }

    public Double getCommRefundAmount() {
        return commRefundAmount;
    }

    public void setCommRefundAmount(Double commRefundAmount) {
        this.commRefundAmount = commRefundAmount;
    }

    public Double getCommInvoiceAmount() {
        return commInvoiceAmount;
    }

    public void setCommInvoiceAmount(Double commInvoiceAmount) {
        this.commInvoiceAmount = commInvoiceAmount;
    }
}
