package com.wisea.cultivar.common.vo.tp.retro;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className RetrospFlagApplPreviewVo
 * @date 2019/12/20 13:43
 * @Description 追溯标签申请记录预览Vo
 */
@ApiModel("追溯标签申请记录预览Vo")
public class RetrospFlagApplPreviewVo {
    @ApiModelProperty("追溯信息模板")
    private String currencyRetrospTemplate;
    @ApiModelProperty("产品名称")
    private String prdutName;

    public String getCurrencyRetrospTemplate() {
        return currencyRetrospTemplate;
    }

    public void setCurrencyRetrospTemplate(String currencyRetrospTemplate) {
        this.currencyRetrospTemplate = currencyRetrospTemplate;
    }

    public String getPrdutName() {
        return prdutName;
    }

    public void setPrdutName(String prdutName) {
        this.prdutName = prdutName;
    }
}
