package com.wisea.cultivar.plant.entity.oritrapla;

import com.wisea.cloud.common.entity.DataLongEntity;

public class EquInfoMage extends DataLongEntity<EquInfoMage> {
    /**
     * 设备名称
     */
    private String equName;

    /**
     * 设备类型
     */
    private String equType;

    /**
     * 设备编号
     */
    private String equNum;

    /**
     * 设备厂商id
     */
    private Long equEntpId;

    /**
     * 厂商名称
     */
    private String firmName;

    /**
     * 设备型号id
     */
    private Long equModelId;

    /**
     * 设备型号
     */
    private String equXh;

    /**
     * 生产序列号
     */
    private String psn;

    /**
     * 播放地址
     */
    private String bfUrl;

    /**
     * 视频来源
     */
    private String splyUrl;

    /**
     * 封面图片
     */
    private String fmtpUrl;

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

    public String getEquNum() {
        return equNum;
    }

    public void setEquNum(String equNum) {
        this.equNum = equNum;
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
