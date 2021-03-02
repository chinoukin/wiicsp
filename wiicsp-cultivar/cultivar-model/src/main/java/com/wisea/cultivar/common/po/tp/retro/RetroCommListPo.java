package com.wisea.cultivar.common.po.tp.retro;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.tp.retro.RetroCommListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 查询可申请追溯标签商品列表Po
 */
@ApiModel("查询可申请追溯标签商品列表Po")
public class RetroCommListPo extends PagePo<RetroCommListVo> {
    @ApiModelProperty("查询输入框（商品编号/商品名称）")
    private String query;
    @ApiModelProperty("商品品牌ID")
    private Long brandId;
    @ApiModelProperty(value = "卖家用户ID", hidden = true)
    private Long sellerId;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
}
