package com.wisea.cultivar.common.po;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.CommCurrencyInfoPageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("通用信息分页查询Po")
public class CommCurrencyInfoPageListPo extends PagePo<CommCurrencyInfoPageListVo> {
    @ApiModelProperty(value="id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
