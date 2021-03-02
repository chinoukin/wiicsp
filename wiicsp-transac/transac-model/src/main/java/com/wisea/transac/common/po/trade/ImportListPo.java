package com.wisea.transac.common.po.trade;

import com.wisea.cloud.model.annotation.Check;
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
    @ApiModelProperty(value="交易模式类型")
    //@Check(test="required")
    private String transType;
    @ApiModelProperty(value="String类型的参数 (必填)",required=true)
    @Check(test="required")
    private String keyStr;
    @ApiModelProperty(value="市场id")
    @Check(test="required")
    private Long wholeSaleMarketId;

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
    public Long getWholeSaleMarketId() {
        return wholeSaleMarketId;
    }
    public void setWholeSaleMarketId(Long wholeSaleMarketId) {
        this.wholeSaleMarketId = wholeSaleMarketId;
    }

    public String getKeyStr() {
        return keyStr;
    }

    public void setKeyStr(String keyStr) {
        this.keyStr = keyStr;
    }
}
