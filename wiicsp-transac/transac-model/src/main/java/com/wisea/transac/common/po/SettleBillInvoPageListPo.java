package com.wisea.transac.common.po;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.SettleBillInvoPageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页查询账期发票Po")
public class SettleBillInvoPageListPo extends PagePo<SettleBillInvoPageListVo> {
    @ApiModelProperty(value="发票类型")
    private String query;
    @ApiModelProperty(value="发票状态")
    private String invoState;
    @ApiModelProperty(value = "卖家ID", hidden = true)
    private Long sellerId;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getInvoState() {
        return invoState;
    }

    public void setInvoState(String invoState) {
        this.invoState = invoState;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
}
