package com.wisea.cultivar.plant.vo.oritrapla.mss;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className EquInfo
 * @date 2020/9/3 9:31
 * @Description
 */
public class EquInfo {
    @ApiModelProperty("设备ID")
    private Long id;
    @ApiModelProperty("设备类型：0 物联网设备 、1 视频设备")
    private String equType;
    @ApiModelProperty("设备名称")
    private String equName;
    @ApiModelProperty("设备厂商id")
    private Long equEntpId;
    @ApiModelProperty("厂商名称")
    private String firmName;
    @ApiModelProperty("设备型号id")
    private Long equModelId;
    @ApiModelProperty("设备型号")
    private String equXh;
    @ApiModelProperty("设备编号")
    private String equNum;
    @ApiModelProperty("生产序列号")
    private String psn;
    @ApiModelProperty("播放地址")
    private String bfUrl;
    @ApiModelProperty("视频来源地址")
    private String splyUrl;
    @ApiModelProperty("封面图片Url")
    private String fmtpUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEquType() {
        return equType;
    }

    public void setEquType(String equType) {
        this.equType = equType;
    }

    public String getEquName() {
        return equName;
    }

    public void setEquName(String equName) {
        this.equName = equName;
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

    public String getBfUrl() {
        return bfUrl;
    }

    public void setBfUrl(String bfUrl) {
        this.bfUrl = bfUrl;
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
