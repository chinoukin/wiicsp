package com.wisea.cultivar.plant.po.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.plant.vo.oritrapla.EquInfoMageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @author jirg
 * @version 1.0
 * @className EquInfoMagePo
 * @date 2019/2/25 9:57
 * @Description
 */
@ApiModel("设备分页查询Po")
public class EquInfoMagePagePo extends PagePo<EquInfoMageListVo> {

    /**
     * 设备名称
     */
    @ApiModelProperty("设备名称")
    private String equName;

    /**
     * 厂商名称
     */
    @ApiModelProperty("设备厂商")
    private String firmName;

    /**
     * 设备类型
     */
    @ApiModelProperty("设备类型")
    @Check(test = "required")
    private String equType;

    /**
     * 设备编号
     */
    @ApiModelProperty("设备编号")
    private String equNum;

    /**
     * 生产序列号
     */
    @ApiModelProperty("生产系列号")
    private String psn;
    /**
     * 视频来源url
     */
    private String splyUrl;
    /**
     * 播放地址url
     */
    private String bfUrl;
    /**
     * 封面图片url
     */
    private String fmtpUrl;

    /**
     * 设备型号
     */
    @ApiModelProperty("设备型号")
    private String equXh;
    @ApiModelProperty("设备型号ID")
    private String equId;

    @ApiModelProperty("更新人")
    private String updateBy;

    @ApiModelProperty("安装基地")
    private String orgName;
    @ApiModelProperty("安装地块")
    private String massifName;

    @ApiModelProperty("更新时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime updateDate;

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

    public String getFmtpUrl() {
        return fmtpUrl;
    }

    public void setFmtpUrl(String fmtpUrl) {
        this.fmtpUrl = fmtpUrl;
    }

    public String getEquXh() {
        return equXh;
    }

    public void setEquXh(String equXh) {
        this.equXh = equXh;
    }

    public String getEquId() {
        return equId;
    }

    public void setEquId(String equId) {
        this.equId = equId;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getMassifName() {
        return massifName;
    }

    public void setMassifName(String massifName) {
        this.massifName = massifName;
    }

    public OffsetDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(OffsetDateTime updateDate) {
        this.updateDate = updateDate;
    }
}
