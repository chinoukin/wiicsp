package com.wisea.cultivar.common.vo.tp;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author wangjh
 * @version 1.0
 * @className SettleOrdStatVo
 * @since 2018/10/13 12:02
 */
public class SettleOrdStatVo {

  @ApiModelProperty(value = "订单类型，0正常结算订单,1退货退款订单,2平台垫付订单")
  private String ordType;
  @ApiModelProperty(value = "订单个数")
  private Long count;
  @ApiModelProperty(value = "总金额")
  private Double amount;

  public String getOrdType() {
    return ordType;
  }

  public void setOrdType(String ordType) {
    this.ordType = ordType;
  }

  public Long getCount() {
    return count;
  }

  public void setCount(Long count) {
    this.count = count;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }
}
