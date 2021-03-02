package com.wisea.cultivar.plant.vo.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTime2LongStrSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * Auth： jirg
 * CreateDate:  2018/6/5
 * projectName:  oritrapla
 * remark:  追溯码申请Vo
 */
@ApiModel("追溯码申请Vo")
public class RtspCodeMageInfoVo {
    @ApiModelProperty("追溯码申请ID")
    private Long id;
    @ApiModelProperty("会员id")
    private Long membId;
    @ApiModelProperty("会员名称")
    private String membName;
    @ApiModelProperty("我的档案id")
    private Long mineArchId;
    @ApiModelProperty("档案id")
    private Long archId;
    @ApiModelProperty("档案编号")
    private String archNum;
    @ApiModelProperty("批次编号")
    private String batchNum;
    @ApiModelProperty("追溯码数量")
    private Integer rtspCodeCount;
    @ApiModelProperty("打印方式类型（0 自行打印，1 平台打印）")
    private String printMethType;
    @ApiModelProperty("地块名称")
    private String massifName;
    @ApiModelProperty("品类名称")
    private String commName; //只显示第三级
    @ApiModelProperty("品种名称")
    private String commVarietName;
    @ApiModelProperty("图片URL")
    private String url;
    @ApiModelProperty("开始种植时间")
    @JsonSerialize(using = OffsetDateTime2LongStrSerializer.class)
    private OffsetDateTime startDate;
    @ApiModelProperty(value = "我的档案状态", hidden = true)
    private String mineArchStatus;
    @ApiModelProperty("申请时间")
    @JsonSerialize(using = OffsetDateTime2LongStrSerializer.class)
    private OffsetDateTime creataDate;
    @ApiModelProperty("主体名称")
    private String orgName;
    @ApiModelProperty("联系人姓名")
    private String contName;
    @ApiModelProperty("联系人手机号")
    private String contTel;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getMembName() {
        return membName;
    }

    public void setMembName(String membName) {
        this.membName = membName;
    }

    public Long getMineArchId() {
        return mineArchId;
    }

    public void setMineArchId(Long mineArchId) {
        this.mineArchId = mineArchId;
    }

    public Long getArchId() {
        return archId;
    }

    public void setArchId(Long archId) {
        this.archId = archId;
    }

    public String getArchNum() {
        return archNum;
    }

    public void setArchNum(String archNum) {
        this.archNum = archNum;
    }

    public String getBatchNum() {
        return batchNum;
    }

    public void setBatchNum(String batchNum) {
        this.batchNum = batchNum;
    }

    public Integer getRtspCodeCount() {
        return rtspCodeCount;
    }

    public void setRtspCodeCount(Integer rtspCodeCount) {
        this.rtspCodeCount = rtspCodeCount;
    }

    public String getPrintMethType() {
        return printMethType;
    }

    public void setPrintMethType(String printMethType) {
        this.printMethType = printMethType;
    }

    public String getMassifName() {
        return massifName;
    }

    public void setMassifName(String massifName) {
        this.massifName = massifName;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public String getCommVarietName() {
        return commVarietName;
    }

    public void setCommVarietName(String commVarietName) {
        this.commVarietName = commVarietName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public OffsetDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(OffsetDateTime startDate) {
        this.startDate = startDate;
    }

    public String getMineArchStatus() {
        return mineArchStatus;
    }

    public void setMineArchStatus(String mineArchStatus) {
        this.mineArchStatus = mineArchStatus;
    }

    public OffsetDateTime getCreataDate() {
        return creataDate;
    }

    public void setCreataDate(OffsetDateTime creataDate) {
        this.creataDate = creataDate;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getContName() {
        return contName;
    }

    public void setContName(String contName) {
        this.contName = contName;
    }

    public String getContTel() {
        return contTel;
    }

    public void setContTel(String contTel) {
        this.contTel = contTel;
    }
}
