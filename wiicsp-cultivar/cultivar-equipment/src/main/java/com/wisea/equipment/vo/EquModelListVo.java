package com.wisea.equipment.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className EquModelListVo
 * @date 2020/7/6 16:32
 * @Description 根据厂商查询设备型号列表Po
 */
@ApiModel("根据厂商查询设备型号列表Po")
public class EquModelListVo {
    @ApiModelProperty("设备型号ID")
    private Long id;
    @ApiModelProperty("设备型号")
    private String equModel;
    @ApiModelProperty("设备类型")
    private String equType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEquModel() {
        return equModel;
    }

    public void setEquModel(String equModel) {
        this.equModel = equModel;
    }

    public String getEquType() {
        return equType;
    }

    public void setEquType(String equType) {
        this.equType = equType;
    }
}
