package com.wisea.transac.common.vo.trade;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("进货单列表Vo")
public class ImportListVo {

    @ApiModelProperty(value="商家id")
    private Long sellerId;
    @ApiModelProperty(value="商家名称id")
    private String entpName;
    @ApiModelProperty(value="档口列表")
    private List<ImportStallsListVo> stallsList;

    public Long getSellerId() {
        return sellerId;
    }
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
    public String getEntpName() {
        return entpName;
    }
    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }
    public List<ImportStallsListVo> getStallsList() {
        return stallsList;
    }
    public void setStallsList(List<ImportStallsListVo> stallsList) {
        this.stallsList = stallsList;
    }
}
