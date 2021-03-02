package com.wisea.cultivar.plant.vo.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.annotation.LongSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTime2LongStrSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * Auth： jirg
 * CreateDate:  2018/6/22
 * projectName:  oritrapla
 * remark:  我的档案Vo
 */
public class ArchInfoVo {
    @ApiModelProperty(value="我的档案id")
    private Long id;
    @ApiModelProperty(value="来源会员id")
    private Long sourceMembId;
    @ApiModelProperty(value="来源农场或公司名称")
    private String sourceOrgName;
    @ApiModelProperty(value="会员id")
    @JsonSerialize(using= LongSerializer.class)
    private Long membId;
    @ApiModelProperty(value="创建、接受人姓名")
    private String menbName;
    @ApiModelProperty(value="档案类型（扫码，推送，自建）")
    private String archType;
    @ApiModelProperty(value="我的档案状态")
    private String mineArchStatus;
    @ApiModelProperty(value="创建、接收日期")
    @JsonSerialize(using = OffsetDateTime2LongStrSerializer.class)
    private OffsetDateTime createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSourceMembId() {
        return sourceMembId;
    }

    public void setSourceMembId(Long sourceMembId) {
        this.sourceMembId = sourceMembId;
    }

    public String getSourceOrgName() {
        return sourceOrgName;
    }

    public void setSourceOrgName(String sourceOrgName) {
        this.sourceOrgName = sourceOrgName;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getMenbName() {
        return menbName;
    }

    public void setMenbName(String menbName) {
        this.menbName = menbName;
    }

    public String getArchType() {
        return archType;
    }

    public void setArchType(String archType) {
        this.archType = archType;
    }

    public String getMineArchStatus() {
        return mineArchStatus;
    }

    public void setMineArchStatus(String mineArchStatus) {
        this.mineArchStatus = mineArchStatus;
    }

    public OffsetDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(OffsetDateTime createDate) {
        this.createDate = createDate;
    }
}
