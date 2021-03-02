package com.wisea.transac.common.po.trade;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.trade.BuyerSettleBillListVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel("买家端结算单列表po")
public class BuyerSettleBillListPo extends PagePo<BuyerSettleBillListVo>{

    @ApiModelProperty(value = "结算单状态类型")
    private String settleBillStatueType;
    @ApiModelProperty(value = "是否逾期类型(逾期传0,其他不传)")
    private String sfYqFlag;
    @ApiModelProperty(value = "是否逾期查询条件，0需要sfyqflag不为0", hidden = true)
    private String sfYqChaxun;
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "买方ID", hidden = true)
    private Long buyerId;
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "卖方ID", hidden = true)
    private Long sellerId;
    @ApiModelProperty(value = "查询条件（商品名称，订单编号，结算单编号）")
    private String searchKey;

    public String getSettleBillStatueType() {
        return settleBillStatueType;
    }
    public void setSettleBillStatueType(String settleBillStatueType) {
        this.settleBillStatueType = settleBillStatueType;
    }

    public String getSfYqChaxun() {
        return sfYqChaxun;
    }

    public void setSfYqChaxun(String sfYqChaxun) {
        this.sfYqChaxun = sfYqChaxun;
    }

    public Long getBuyerId() {
        return buyerId;
    }
    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }
    public Long getSellerId() {
        return sellerId;
    }
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
    public String getSearchKey() {
        return searchKey;
    }
    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public void setSfYqFlag(String sfYqFlag) {
        this.sfYqFlag = sfYqFlag;
    }

    public String getSfYqFlag() {
        return sfYqFlag;
    }
}
