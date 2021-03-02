package com.wisea.cultivar.plant.po.oritrapla;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className EquInfoMageSavePo
 * @date 2019/2/25 10:35
 * @Description
 */
@ApiModel("保存设备信息Po")
public class EquInfoMageSavePo {
    @ApiModelProperty("设备Id（修改时必填）")
    private Long id;
    @ApiModelProperty("设备名称")
    @Check(test = "required")
    private String equName;
    @ApiModelProperty("设备类型：0物联网设备、1视频设备")
    @Check(test = {"required", "liveable"}, liveable = {"0", "1"}, liveableMsg = "设备类型只能为0或者1")
    private String equType;
    @ApiModelProperty("设备厂商id")
    @Check(test = "logic", logic = "'0'.equals(#equType)?#isNotEmpty(#equEntpId):true", logicMsg = "设备厂商id不能为空")
    private Long equEntpId;
    @ApiModelProperty("设备厂商名称")
    @Check(test = "required")
    private String firmName;
    @ApiModelProperty("设备型号Id")
    @Check(test = "logic", logic = "'0'.equals(#equType)?#isNotEmpty(#equModelId):true", logicMsg = "设备型号id不能为空")
    private Long equModelId;
    @ApiModelProperty("设备型号名称")
    @Check(test = "logic", logic = "'0'.equals(#equType)?#isNotEmpty(#equXh):true", logicMsg = "设备型号名称不能为空")
    private String equXh;
    @ApiModelProperty("关联地块ID")
    @Check(test = "required")
    private Long massifId;
    @ApiModelProperty("设备编号")
    @Check(test = "logic", logic = "'0'.equals(#equType)?#isNotEmpty(#equNum):true", logicMsg = "设备编号不能为空")
    private String equNum;

    @ApiModelProperty("生产序列号")
    private String psn;
    @ApiModelProperty("备注")
    private String remarks;
    @ApiModelProperty("视频来源地址,来源地址=播放地址")
    @Check(test = "logic", logic = "'1'.equals(#equType)?#isNotEmpty(#splyUrl):true", logicMsg = "播放地址不能为空")
    private String splyUrl;
    @ApiModelProperty("封面图片Url")
    private String fmtpUrl;

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

    public String getEquType() {
        return equType;
    }

    public void setEquType(String equType) {
        this.equType = equType;
    }

    public Long getEquEntpId() {
        return equEntpId;
    }

    public void setEquEntpId(Long equEntpId) {
        this.equEntpId = equEntpId;
    }

    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public Long getEquModelId() {
        return equModelId;
    }

    public void setEquModelId(Long equModelId) {
        this.equModelId = equModelId;
    }

    public String getEquXh() {
        return equXh;
    }

    public void setEquXh(String equXh) {
        this.equXh = equXh;
    }

    public Long getMassifId() {
        return massifId;
    }

    public void setMassifId(Long massifId) {
        this.massifId = massifId;
    }

    public String getEquNum() {
        return equNum;
    }

    public void setEquNum(String equNum) {
        this.equNum = equNum;
    }

    public String getPsn() {
        return psn;
    }

    public void setPsn(String psn) {
        this.psn = psn;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSplyUrl() {
        return splyUrl;
    }

    public void setSplyUrl(String splyUrl) {
        this.splyUrl = splyUrl;
    }

    public String getFmtpUrl() {
        return fmtpUrl;
    }

    public void setFmtpUrl(String fmtpUrl) {
        this.fmtpUrl = fmtpUrl;
    }
}
