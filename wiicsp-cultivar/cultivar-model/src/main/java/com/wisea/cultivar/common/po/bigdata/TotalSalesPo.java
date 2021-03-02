package com.wisea.cultivar.common.po.bigdata;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className TotalSalesPo
 * @date 2020/2/6 14:32
 * @Description 国内/国外品类交易走势分析
 */
@ApiModel(value = "国内外销售总额统计Po")
public class TotalSalesPo {
    @Check(test = {"required"})
    @ApiModelProperty("年份")
    private String year;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
