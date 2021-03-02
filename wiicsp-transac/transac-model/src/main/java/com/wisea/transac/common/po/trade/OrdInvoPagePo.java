package com.wisea.transac.common.po.trade;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.trade.OrdInvoPageVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 订单发票列表PO
 *
 * @author yangtao
 *
 */
@ApiModel("订单发票列表PO")
public class OrdInvoPagePo extends PagePo<OrdInvoPageVo>{

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "卖方ID", hidden = true)
    private Long sellerId;
    @ApiModelProperty(value = "发票状态")
    private String invoState;
    @ApiModelProperty(value = "查询条件（订单编号，买家名称，买家账号）")
    private String searchKey;

    public Long getSellerId() {
        return sellerId;
    }
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
    public String getInvoState() {
        return invoState;
    }
    public void setInvoState(String invoState) {
        this.invoState = invoState;
    }
    public String getSearchKey() {
        return searchKey;
    }
    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }
}
