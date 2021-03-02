package com.wisea.cultivar.common.po.tp;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * SettleBillExportPo
 * 2018/10/12 11:10:09
 */
public class SettleBillExportPo {
    /**
     * 批量导出列表
     */
    @Check(test = "required")
    @ApiModelProperty(value = "批量导出列表")
    private List<Long> exportList;

    public List<Long> getExportList() {
        return exportList;
    }

    public void setExportList(List<Long> exportList) {
        this.exportList = exportList;
    }
}
