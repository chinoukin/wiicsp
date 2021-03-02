package com.wisea.transac.common.vo.seller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className EquInfoVo
 * @date 2020/7/7 16:15
 * @Description 物联网设备VO
 */
@ApiModel("物联网设备VO")
public class EquInfoVo {
    @ApiModelProperty("物联网设备-安装位置")
    private String installPosition;
    @ApiModelProperty("物联网设备-设备厂商")
    private String equManufact;
    @ApiModelProperty("设备厂商ID")
    private Long equEntpId;
    @ApiModelProperty("物联网设备-设备类型")
    private String equType;
    @ApiModelProperty("设备类型ID")
    private Long equModelId;
    @ApiModelProperty("物联网设备-设备编号")
    private String equNum;

    public String getInstallPosition() {
        return installPosition;
    }

    public void setInstallPosition(String installPosition) {
        this.installPosition = installPosition;
    }

    public String getEquManufact() {
        return equManufact;
    }

    public void setEquManufact(String equManufact) {
        this.equManufact = equManufact;
    }

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

    public Long getEquModelId() {
        return equModelId;
    }

    public void setEquModelId(Long equModelId) {
        this.equModelId = equModelId;
    }

    public String getEquNum() {
        return equNum;
    }

    public void setEquNum(String equNum) {
        this.equNum = equNum;
    }
}
