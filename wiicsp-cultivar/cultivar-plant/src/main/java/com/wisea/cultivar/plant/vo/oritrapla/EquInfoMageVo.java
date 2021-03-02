package com.wisea.cultivar.plant.vo.oritrapla;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @author jirg
 * @version 1.0
 * @className EquInfoMageVo
 * @date 2019/2/25 9:55
 * @Description 分页查询设备信息列表Vo
 */
@ApiModel("设备列表Vo")
public class EquInfoMageVo {
    @ApiModelProperty("设备Id")
    private Long id;
    @ApiModelProperty("设备名称")
    private String equName;
    @ApiModelProperty("设备厂商id")
    private Long equEntpId;
    @ApiModelProperty("厂商名称")
    private String firmName;
    @ApiModelProperty("设备类型")
    private String equType;
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
    @ApiModelProperty("备注")
    private String remarks;
    @ApiModelProperty("关联地块名称")
    private String massifName;
    @ApiModelProperty("关联地块ID")
    private Long massifId;
    @ApiModelProperty("安装基地名称")
    private String orgName;
    @ApiModelProperty("更新人")
    private String updateUserName;
    @ApiModelProperty("更新时间")
    private OffsetDateTime updateDate;

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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getMassifName() {
        return massifName;
    }

    public void setMassifName(String massifName) {
        this.massifName = massifName;
    }

    public Long getMassifId() {
        return massifId;
    }

    public void setMassifId(Long massifId) {
        this.massifId = massifId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    public OffsetDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(OffsetDateTime updateDate) {
        this.updateDate = updateDate;
    }
}
