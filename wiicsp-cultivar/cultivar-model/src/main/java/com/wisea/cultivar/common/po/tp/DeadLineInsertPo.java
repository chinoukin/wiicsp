package com.wisea.cultivar.common.po.tp;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author wangjh
 * @version 1.0
 * @className DeadLineInsertPo
 * @since 2018/9/25 11:03
 */
public class DeadLineInsertPo {

  /**
   * 支付天数限制
   */
  @Check(test = { "maxLength","required" }, length = 10)
  @ApiModelProperty(value = "支付天数限制")
  private Integer payDeadline;
  /**
   * 确认收货天数限制
   */
  @Check(test = { "maxLength","required" }, length = 10)
  @ApiModelProperty(value = "确认收货天数限制")
  private Integer receDeadline;
  /**
   * 申请发票天数限制
   */
  @Check(test = { "maxLength","required" }, length = 10)
  @ApiModelProperty(value = "申请发票天数限制")
  private Integer invoDeadline;
  /**
   * 备注
   */
  @Check(test = { "maxLength" }, mixLength = 255)
  @ApiModelProperty(value = "支付备注")
  private String payRemarks;
  @Check(test = { "maxLength" }, mixLength = 255)
  @ApiModelProperty(value = "收获确认备注")
  private String receRemarks;
  @Check(test = { "maxLength" }, mixLength = 255)
  @ApiModelProperty(value = "申请退款备注")
  private String refundRemarks;
  @Check(test = { "maxLength" }, mixLength = 255)
  @ApiModelProperty(value = "申请发票备注")
  private String invoRemarks;

  public Integer getInvoDeadline() {
    return invoDeadline;
  }

  public void setInvoDeadline(Integer invoDeadline) {
    this.invoDeadline = invoDeadline;
  }

  public String getInvoRemarks() {
    return invoRemarks;
  }

  public void setInvoRemarks(String invoRemarks) {
    this.invoRemarks = invoRemarks;
  }

  public String getRefundRemarks() {
    return refundRemarks;
  }

  public void setRefundRemarks(String refundRemarks) {
    this.refundRemarks = refundRemarks;
  }

  public Integer getPayDeadline() {
    return payDeadline;
  }

  public void setPayDeadline(Integer payDeadline) {
    this.payDeadline = payDeadline;
  }

  public Integer getReceDeadline() {
    return receDeadline;
  }

  public void setReceDeadline(Integer receDeadline) {
    this.receDeadline = receDeadline;
  }

  public String getPayRemarks() {
    return payRemarks;
  }

  public void setPayRemarks(String payRemarks) {
    this.payRemarks = payRemarks;
  }

  public String getReceRemarks() {
    return receRemarks;
  }

  public void setReceRemarks(String receRemarks) {
    this.receRemarks = receRemarks;
  }
}
