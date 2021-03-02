package com.wisea.cultivar.common.po.tp;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author wangjh
 * @version 1.0
 * @className InvoInfoUpdateDefaultFlagPo
 * @since 2018/10/12 14:42
 */
public class InvoInfoUpdateDefaultFlagPo {
  @Check(test = "required")
  @ApiModelProperty(value = "会员ID")
  private Long membId;


  public InvoInfoUpdateDefaultFlagPo() {
  }

  public InvoInfoUpdateDefaultFlagPo(Long membId) {
    this.membId = membId;
  }

  public Long getMembId() {
    return membId;
  }

  public void setMembId(Long membId) {
    this.membId = membId;
  }
}
