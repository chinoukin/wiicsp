package com.wisea.cultivar.common.vo.tp;

/**
 * @author wangjh
 * @version 1.0
 * @className OrderInfoForSettleVo
 * @since 2018/10/17 14:01
 */
public class OrderInfoForSettleVo {

  private Long id;
  private String amount;
  private Long sellerId;
  private String sellerName;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public Long getSellerId() {
    return sellerId;
  }

  public void setSellerId(Long sellerId) {
    this.sellerId = sellerId;
  }

  public String getSellerName() {
    return sellerName;
  }

  public void setSellerName(String sellerName) {
    this.sellerName = sellerName;
  }
}
