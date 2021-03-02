package com.wisea.cultivar.common.po.bigdata;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("新增或修改Po")
public class AnnualSalesTargetPo {
    @ApiModelProperty(value="年份")
    @Check(test = {"required"})
    private String year;

    @ApiModelProperty(value="目标销售额（亿）")
    @Check(test = {"required"})
    private Double salesTarget;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Double getSalesTarget() {
        return salesTarget;
    }

    public void setSalesTarget(Double salesTarget) {
        this.salesTarget = salesTarget;
    }
}
