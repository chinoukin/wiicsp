package com.wisea.cultivar.common.po.tp;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * PlatfFreightFormworkMageBatImportPo
 * 2018/09/18 14:36:47
 */
public class PlatfFreightFormworkMageBatImportPo {
    /**
     * 批量导入列表
     */
    @Check(test = "required")
    @ApiModelProperty(value = "批量导入列表")
    private List<Long> impList;

    public List<Long> getImpList() {
        return impList;
    }

    public void setImpList(List<Long> impList) {
        this.impList = impList;
    }
}
