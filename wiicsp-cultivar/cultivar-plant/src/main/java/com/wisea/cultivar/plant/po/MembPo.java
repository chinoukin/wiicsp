package com.wisea.cultivar.plant.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassNameMembPo
 * @Description
 * @Author zhangbo
 * @Date2020/8/14 14:53
 **/
@ApiModel("会员主键id")
public class MembPo {

    @ApiModelProperty(value="当前查看会员id")
    @Check(test = { "required" })
    private Long membId;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }
}
