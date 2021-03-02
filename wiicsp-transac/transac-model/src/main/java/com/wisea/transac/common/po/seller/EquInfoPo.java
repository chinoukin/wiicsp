package com.wisea.transac.common.po.seller;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className EquInfoPo
 * @date 2020/7/7 14:37
 * @Description
 */
@ApiModel("物联网设备PO")
public class EquInfoPo {
    @ApiModelProperty("物联网设备-安装位置")
    @Check(test = {"required"})
    private String installPosition;
    @ApiModelProperty("物联网设备-设备厂商")
    @Check(test = {"required"})
    private String equManufact;
    @ApiModelProperty("设备厂商ID")
    @Check(test = {"required"})
    private Long equEntpId;
    @ApiModelProperty("物联网设备-设备类型")
    @Check(test = {"required"})
    private String equType;
    @ApiModelProperty("设备类型ID")
    @Check(test = {"required"})
    private Long equModelId;
    @ApiModelProperty("物联网设备-设备编号")
    @Check(test = {"required"})
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
