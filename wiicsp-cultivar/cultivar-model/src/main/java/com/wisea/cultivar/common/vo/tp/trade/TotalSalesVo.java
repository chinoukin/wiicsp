package com.wisea.cultivar.common.vo.tp.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className TotalSalesVo
 * @date 2020/9/28 9:44
 * @Description 销售总额Vo - 大数据使用
 */
@ApiModel("销售总额Vo")
public class TotalSalesVo {
    @ApiModelProperty("销售总额")
    private String totalSales;
    @ApiModelProperty("商品总件数")
    private String commCount;

    public String getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(String totalSales) {
        this.totalSales = totalSales;
    }

    public String getCommCount() {
        return commCount;
    }

    public void setCommCount(String commCount) {
        this.commCount = commCount;
    }
}
