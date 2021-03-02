package com.wisea.equipment.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className EquModelListPo
 * @date 2020/7/6 16:34
 * @Description 根据厂商查询设备型号列表Po
 */
@ApiModel("根据厂商查询设备型号列表Po")
public class EquModelListPo {
    @ApiModelProperty("设备厂商id")
    @Check(test = { "required" })
    private Long equEntpId;
    @ApiModelProperty("设备类型")
    private String equType;

    public Long getEquEntpId() {
        return equEntpId;
    }

    public void setEquEntpId(Long equEntpId) {
        this.equEntpId = equEntpId;
    }

    public String getEquType() {
        return equType;
    }

    public void setEquType(String equType) {
        this.equType = equType;
    }
}
