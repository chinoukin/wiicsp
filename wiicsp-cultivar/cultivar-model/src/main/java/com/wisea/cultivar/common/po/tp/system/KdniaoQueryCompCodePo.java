package com.wisea.cultivar.common.po.tp.system;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author wangjiahao
 * @version 1.0
 * @className KdniaoQueryPo
 * @since 2019-03-08 16:02
 */
@ApiModel(value = "快递鸟查询快递公司code参数")
public class KdniaoQueryCompCodePo {

    @ApiModelProperty("快递公司名称")
    @Check(test = "required")
    private String compName;

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }
}
