package com.wisea.cultivar.plant.po.oritrapla;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 入参po
 * @author: wangs
 * @date :2018/6/21
 */
@ApiModel("入参po")
public class FarmDictPo {

    @ApiModelProperty("数据id")
    @Check(test = "required", regexMsg = "数据id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
