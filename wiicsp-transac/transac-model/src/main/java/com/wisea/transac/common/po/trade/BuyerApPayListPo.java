package com.wisea.transac.common.po.trade;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.trade.BuyerApPayMageListVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("买家查询账期设置列表Po")
public class BuyerApPayListPo extends PagePo<BuyerApPayMageListVo>{

    @ApiModelProperty("搜索栏输入内容")
    private String searchKey;
    @ApiModelProperty(value = "卖家ID", hidden = true)
    private Long sellerId;
    @ApiModelProperty(value = "会员ID", hidden = true)
    private Long membId;

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
    public Long getMembId() {
        return membId;
    }
    public void setMembId(Long membId) {
        this.membId = membId;
    }
}
