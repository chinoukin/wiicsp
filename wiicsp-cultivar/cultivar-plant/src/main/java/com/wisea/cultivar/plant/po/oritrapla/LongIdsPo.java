package com.wisea.cultivar.plant.po.oritrapla;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Auth： jirg
 * CreateDate:  2018/3/2
 * projectName:  wtp
 * remark:   数据IDs Po
 */
@ApiModel("ID列表 Po")
public class LongIdsPo {
    @ApiModelProperty("数据IDs")
    @Check(test = "required")
    private List<Long> ids;

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
