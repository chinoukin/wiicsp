package com.wisea.cultivar.common.po.tp.retro;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * RetrospPcMageGetPo
 * 2019/12/20 14:20:02
 */
public class RetrospPcMageGetPcNumPo {
    /**
     * 批次号
     */
    @ApiModelProperty(value = "批次号")
    @Check(test = "required")
    private String pcNum;

    public String getPcNum() {
        return pcNum;
    }

    public void setPcNum(String pcNum) {
        this.pcNum = pcNum;
    }
}
