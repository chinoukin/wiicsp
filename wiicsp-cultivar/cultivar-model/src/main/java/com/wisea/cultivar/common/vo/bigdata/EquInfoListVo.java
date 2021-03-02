package com.wisea.cultivar.common.vo.bigdata;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className EquInfoListVo
 * @date 2019/7/19 17:23
 * @Description 设备信息列表
 */
@ApiModel("设备信息列表")
public class EquInfoListVo {
    @ApiModelProperty("设备ID")
    private Long id;
    @ApiModelProperty("设备名称")
    private String equName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEquName() {
        return equName;
    }

    public void setEquName(String equName) {
        this.equName = equName;
    }
}
