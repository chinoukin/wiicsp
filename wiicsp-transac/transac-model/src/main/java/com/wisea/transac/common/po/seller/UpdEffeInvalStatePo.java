package com.wisea.transac.common.po.seller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel("员工管理冻结启用")
public class UpdEffeInvalStatePo {

    @ApiModelProperty(value="id")
    private Long id;
    @ApiModelProperty(value="停启用状态")
    private String effeInvalState;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEffeInvalState() {
        return effeInvalState;
    }

    public void setEffeInvalState(String effeInvalState) {
        this.effeInvalState = effeInvalState;
    }
}
