package com.wisea.cultivar.common.po.tp.retro;

import com.wisea.cloud.model.annotation.Check;

import com.wisea.cloud.model.po.LongIdPo;
import io.swagger.annotations.ApiModelProperty;

/**
 * 录入物流信息PO
 */
public class RetroLabelDelivePo extends LongIdPo {
    @Check(test = "required")
    @ApiModelProperty("物流公司名称")
    private String logisticsCompName;
    @Check(test = "required")
    @ApiModelProperty("物流单号")
    private String logisticsNum;

    public String getLogisticsCompName() {
        return logisticsCompName;
    }

    public void setLogisticsCompName(String logisticsCompName) {
        this.logisticsCompName = logisticsCompName;
    }

    public String getLogisticsNum() {
        return logisticsNum;
    }

    public void setLogisticsNum(String logisticsNum) {
        this.logisticsNum = logisticsNum;
    }
}
