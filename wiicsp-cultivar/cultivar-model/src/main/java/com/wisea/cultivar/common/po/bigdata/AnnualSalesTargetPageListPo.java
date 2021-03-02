package com.wisea.cultivar.common.po.bigdata;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.bigdata.AnnualSalesTargetPageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页查询Po")
public class AnnualSalesTargetPageListPo extends PagePo<AnnualSalesTargetPageListVo> {
    @ApiModelProperty(value="主键")
    private Long id;

    @ApiModelProperty(value="年份")
    private String year;

    @ApiModelProperty(value="目标销售额（亿）")
    private Double salesTarget;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
