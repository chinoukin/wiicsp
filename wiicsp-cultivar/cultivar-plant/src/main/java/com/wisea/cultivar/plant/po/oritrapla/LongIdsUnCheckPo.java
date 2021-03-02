package com.wisea.cultivar.plant.po.oritrapla;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className LongIdsUnCheckPo
 * @date 2019/7/19 11:08
 * @Description
 */
@ApiModel("ID列表 Po")
public class LongIdsUnCheckPo {
    @ApiModelProperty("数据IDs")
    private List<Long> ids;

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
