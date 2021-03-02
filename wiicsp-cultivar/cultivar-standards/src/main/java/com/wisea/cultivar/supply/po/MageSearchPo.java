package com.wisea.cultivar.supply.po;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author chengq
 * @date 2020/8/15 18:19
 */
public class MageSearchPo {

    @ApiModelProperty("名称")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
