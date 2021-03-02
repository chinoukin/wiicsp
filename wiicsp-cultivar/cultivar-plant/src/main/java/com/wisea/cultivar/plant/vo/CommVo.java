package com.wisea.cultivar.plant.vo;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Administrator
 * @Auther: Administrator
 * @Date: 2020/8/10 15:09
 * @Description:
 */
@ApiModel("查看单个的详情")
public class CommVo {
    @ApiModelProperty(value="业务id 必填 当前信息的详情id")
    @Check(test = { "required" })
    private Long id;
    @ApiModelProperty(value="当前查看会员id")
    @Check(test = { "required" })
    private Long membId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }
}
