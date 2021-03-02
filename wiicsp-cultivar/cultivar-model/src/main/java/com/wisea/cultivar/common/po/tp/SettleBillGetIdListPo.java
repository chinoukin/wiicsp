package com.wisea.cultivar.common.po.tp;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author wangjh
 * @version 1.0
 * @className SettleBillGetIdListPo
 * @since 2018/10/17 17:19
 */
public class SettleBillGetIdListPo {

  @ApiModelProperty("id集合")
  private List<Long> idList;

  public List<Long> getIdList() {
    return idList;
  }

  public void setIdList(List<Long> idList) {
    this.idList = idList;
  }
}
