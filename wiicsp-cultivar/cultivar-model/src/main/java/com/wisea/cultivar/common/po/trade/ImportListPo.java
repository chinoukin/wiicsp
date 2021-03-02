package com.wisea.cultivar.common.po.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("进货单列表po")
public class ImportListPo {

    @ApiModelProperty(value="买家会员id")
    private Long membId;
    @ApiModelProperty(value="采购员id")
    private Long purchaseStaffId;
    @ApiModelProperty(hidden=true)
    private String importIds;
    @ApiModelProperty(hidden=true)
    private String transType;

    public Long getMembId() {
        return membId;
    }
    public void setMembId(Long membId) {
        this.membId = membId;
    }
    public Long getPurchaseStaffId() {
        return purchaseStaffId;
    }
    public void setPurchaseStaffId(Long purchaseStaffId) {
        this.purchaseStaffId = purchaseStaffId;
    }
    public String getImportIds() {
        return importIds;
    }
    public void setImportIds(String importIds) {
        this.importIds = importIds;
    }
    public String getTransType() {
        return transType;
    }
    public void setTransType(String transType) {
        this.transType = transType;
    }
}
