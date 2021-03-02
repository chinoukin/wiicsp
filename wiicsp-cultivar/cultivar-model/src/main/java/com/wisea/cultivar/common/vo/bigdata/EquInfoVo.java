package com.wisea.cultivar.common.vo.bigdata;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author jirg
 * @version 1.0
 * @className EquInfoVo
 * @date 2019/2/25 9:55
 * @Description 分页查询设备信息列表Vo
 */
@ApiModel("设备列表Vo")
public class EquInfoVo implements Serializable {
    @ApiModelProperty("设备Id")
    private Long id;
    @ApiModelProperty("设备名称")
    private String equName;
    @ApiModelProperty("厂商名称")
    private String firmName;
    @ApiModelProperty("设备类型")
    private String equType;
    @ApiModelProperty("设备编号")
    private String equNum;
    @ApiModelProperty("生产序列号")
    private String psn;
    @ApiModelProperty("备注")
    private String remarks;
    @ApiModelProperty("关联地块名称")
    private String massifName;
    @ApiModelProperty("关联茶区ID")
    private Long massifId;
    @ApiModelProperty("播放地址")
    private String bfUrl;
    @ApiModelProperty("视频来源地址")
    private String splyUrl;
    @ApiModelProperty("封面图片Url")
    private String fmtpUrl;
    @ApiModelProperty("精度")
    private Double jd;
    @ApiModelProperty("维度")
    private Double wd;

    public String getFmtpUrl() {
        return fmtpUrl;
    }

    public void setFmtpUrl(String fmtpUrl) {
        this.fmtpUrl = fmtpUrl;
    }

    public Double getJd() {
        return jd;
    }

    public void setJd(Double jd) {
        this.jd = jd;
    }

    public Double getWd() {
        return wd;
    }

    public void setWd(Double wd) {
        this.wd = wd;
    }

    public String getSplyUrl() {
        return splyUrl;
    }

    public void setSplyUrl(String splyUrl) {
        this.splyUrl = splyUrl;
    }

    public String getBfUrl() {
        return bfUrl;
    }

    public void setBfUrl(String bfUrl) {
        this.bfUrl = bfUrl;
    }

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

    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
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

    public String getPsn() {
        return psn;
    }

    public void setPsn(String psn) {
        this.psn = psn;
    }

    public String getMassifName() {
        return massifName;
    }

    public void setMassifName(String massifName) {
        this.massifName = massifName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getMassifId() {
        return massifId;
    }

    public void setMassifId(Long massifId) {
        this.massifId = massifId;
    }
}
