package com.wisea.cultivar.common.po.bigdata;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className HeadquartersDomesticAndForeignPo
 * @date 2019/12/5 16:52
 * @Description 国内/国外货源各列表查询Po
 */
@ApiModel(value = "国内/国外货源各列表查询Po")
public class HeadquartersSupplyPo {
    @Check(test = "required")
    @ApiModelProperty(value = "货源类型（必填）")
    private String sourceType;

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }
}
