package com.wisea.transac.common.po.system;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author jirg
 * @Date 2020/4/30 16:13
 * @Description 期限设置PO
 **/
public class DeadLineInsertPo {
  @Check(test="required")
  @ApiModelProperty(value = "商家确认期限")
  private Integer confirmDeadline;
  @Check(test="required")
  @ApiModelProperty(value = "买家支付期限")
  private Integer payDeadline;
  @Check(test="required")
  @ApiModelProperty(value = "商品提货期限")
  private Integer deliveryDeadline;
  @Check(test="required")
  @ApiModelProperty(value = "申请开票期限")
  private Integer invoDeadline;
  @Check(test="required")
  @ApiModelProperty(value = "双方评价期限")
  private Integer assessDeadline;
  @Check(test="required")
  @ApiModelProperty(value = "双方对账期限")
  private Integer reconcDeadline;
  @Check(test="required")
  @ApiModelProperty(value = "商家开票期限")
  private Integer billingDeadline;
  @Check(test="required")
  @ApiModelProperty(value = "买家验票期限")
  private Integer ticketCheckDeadline;

  public Integer getConfirmDeadline() {
    return confirmDeadline;
  }

  public void setConfirmDeadline(Integer confirmDeadline) {
    this.confirmDeadline = confirmDeadline;
  }

  public Integer getPayDeadline() {
    return payDeadline;
  }

  public void setPayDeadline(Integer payDeadline) {
    this.payDeadline = payDeadline;
  }

  public Integer getDeliveryDeadline() {
    return deliveryDeadline;
  }

  public void setDeliveryDeadline(Integer deliveryDeadline) {
    this.deliveryDeadline = deliveryDeadline;
  }

  public Integer getInvoDeadline() {
    return invoDeadline;
  }

  public void setInvoDeadline(Integer invoDeadline) {
    this.invoDeadline = invoDeadline;
  }

  public Integer getAssessDeadline() {
    return assessDeadline;
  }

  public void setAssessDeadline(Integer assessDeadline) {
    this.assessDeadline = assessDeadline;
  }

  public Integer getReconcDeadline() {
    return reconcDeadline;
  }

  public void setReconcDeadline(Integer reconcDeadline) {
    this.reconcDeadline = reconcDeadline;
  }

  public Integer getBillingDeadline() {
    return billingDeadline;
  }

  public void setBillingDeadline(Integer billingDeadline) {
    this.billingDeadline = billingDeadline;
  }

  public Integer getTicketCheckDeadline() {
    return ticketCheckDeadline;
  }

  public void setTicketCheckDeadline(Integer ticketCheckDeadline) {
    this.ticketCheckDeadline = ticketCheckDeadline;
  }
}
