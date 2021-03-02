package com.wisea.cultivar.explorer.po;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @ClassName: OilTeaBrandMageExportPo
 * @Author: tgz
 * @Date: 2020/7/30 15:26
 */
public class OilTeaBrandMageExportPo {
    /**
     * 批量导出列表id
     */
    @ApiModelProperty(value = "批量导出数组ID")
    private List<Long> ids;

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
