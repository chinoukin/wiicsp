package com.wisea.transac.common.vo.trade;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 收支明细列表vo
 * @author yangtao
 *
 */
@ApiModel("收支明细列表vo")
public class SellerIncomeListVo {

    @ApiModelProperty("交易服务费")
    private Double platTotal;
    @ApiModelProperty("实际总收入")
    private Double splitIncomeTotal;
    @ApiModelProperty("分账收入列表")
    private List<IncomeListVo> incomeList;

    public Double getPlatTotal() {
        return platTotal;
    }
    public void setPlatTotal(Double platTotal) {
        this.platTotal = platTotal;
    }
    public Double getSplitIncomeTotal() {
        return splitIncomeTotal;
    }
    public void setSplitIncomeTotal(Double splitIncomeTotal) {
        this.splitIncomeTotal = splitIncomeTotal;
    }
    public List<IncomeListVo> getIncomeList() {
        return incomeList;
    }
    public void setIncomeList(List<IncomeListVo> incomeList) {
        this.incomeList = incomeList;
    }
}
