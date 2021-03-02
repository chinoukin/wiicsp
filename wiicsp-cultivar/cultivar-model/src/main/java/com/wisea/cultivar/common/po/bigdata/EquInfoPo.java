package com.wisea.cultivar.common.po.bigdata;

import com.wisea.cloud.model.po.PagePo;

import com.wisea.cultivar.common.vo.bigdata.EquInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className EquInfoPo
 * @date 2019/2/25 9:57
 * @Description
 */
@ApiModel("设备信息Po")
public class EquInfoPo extends PagePo<EquInfoVo> {
    @ApiModelProperty(value = "用户ID")
    private Long userId;

    @ApiModelProperty(value = "会员ID")
    private Long membId;

    @ApiModelProperty(value = "设备类型0传感设备，1视频设备")
    private String equType;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getEquType() {
        return equType;
    }

    public void setEquType(String equType) {
        this.equType = equType;
    }
}
