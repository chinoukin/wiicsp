package com.wisea.transac.common.po.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("买家查询未出账单列表Po")
public class BuyerNotSettleListPo {

    @ApiModelProperty("搜索栏输入内容")
    private String searchKey;
    @ApiModelProperty(value = "卖家ID", hidden = true)
    private Long sellerId;
    @ApiModelProperty(value = "买家ID", hidden = true)
    private Long buyerId;

    public String getSearchKey() {
        return searchKey;
    }
    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }
    public Long getSellerId() {
        return sellerId;
    }
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
    public Long getBuyerId() {
        return buyerId;
    }
    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }
}
