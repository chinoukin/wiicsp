package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cultivar.common.vo.tp.MembInfoListVo;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 消息详细中的会员列表查询PO
 *
 * SendMessageGetPo
 * 2018/10/20 15:06:50
 */
@ApiModel("消息详细中的会员列表查询PO")
public class SendMsgListByMegIdPo  extends PagePo<MembInfoListVo> {

	private static final long serialVersionUID = 5518000891629739642L;
	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value="id")
    @Check(test = "required")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
