package com.wisea.cultivar.common.po.tp.retro;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("追溯模板VO")
public class RetroTemplateSavePo {

    @ApiModelProperty(value = "追溯信息模板")
    @Check(test = "required")
    private String currencyRetrospTemplate;

    public String getCurrencyRetrospTemplate() {
        return currencyRetrospTemplate;
    }

    public void setCurrencyRetrospTemplate(String currencyRetrospTemplate) {
        this.currencyRetrospTemplate = currencyRetrospTemplate;
    }
}
