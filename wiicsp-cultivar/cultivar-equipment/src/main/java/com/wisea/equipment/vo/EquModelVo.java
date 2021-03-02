package com.wisea.equipment.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className EquModelVo
 * @date 2020/7/6 16:43
 * @Description 设备型号VO
 */
@ApiModel("设备型号VO")
public class EquModelVo {
    @ApiModelProperty("设备型号ID")
    private Long id;
    @ApiModelProperty("设备厂商id")
    private Long equEntpId;
    @ApiModelProperty("设备厂商名称")
    private String equEntpName;
    @ApiModelProperty("设备型号")
    private String equModel;
    @ApiModelProperty("设备类型")
    private String equType;
    @ApiModelProperty("接口访问地址")
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEquEntpId() {
        return equEntpId;
    }

    public void setEquEntpId(Long equEntpId) {
        this.equEntpId = equEntpId;
    }

    public String getEquEntpName() {
        return equEntpName;
    }

    public void setEquEntpName(String equEntpName) {
        this.equEntpName = equEntpName;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
