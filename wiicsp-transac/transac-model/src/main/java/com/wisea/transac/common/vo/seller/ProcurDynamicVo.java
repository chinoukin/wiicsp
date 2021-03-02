package com.wisea.transac.common.vo.seller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("采购动态VO")
public class ProcurDynamicVo {

    /**
     * 认证主体名称
     */
    @ApiModelProperty("主体名称")
    private String authZtName;
    /**
     * 采购次数
     */
    @ApiModelProperty("采购次数")
    private String buyerSum;
    /**
     * 主采购
     */
    @ApiModelProperty("主采购")
    private String mainBuyer;

    /**
     * 订单ID
     */
    @ApiModelProperty(value = "订单ID",hidden = true)
    private String ordId;

    public String getAuthZtName() {
        return authZtName;
    }

    public void setAuthZtName(String authZtName) {
        this.authZtName = authZtName;
    }

    public String getBuyerSum() {
        return buyerSum;
    }

    public void setBuyerSum(String buyerSum) {
        this.buyerSum = buyerSum;
    }

    public String getMainBuyer() {
        return mainBuyer;
    }

    public void setMainBuyer(String mainBuyer) {
        this.mainBuyer = mainBuyer;
    }
    public String getOrdId() {
        return ordId;
    }

    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }

}
