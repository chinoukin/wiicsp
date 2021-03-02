package com.wisea.transac.common.po;

import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.memb.MembInfoListForMsgVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页查询Po")
public class SendMessageReciverPageListPo extends PagePo<MembInfoListForMsgVo> {
    private static final long serialVersionUID = 2212282419381925824L;

    @ApiModelProperty(value = "消息ID")
    @Check(test = "required")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
