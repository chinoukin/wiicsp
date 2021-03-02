package com.wisea.cultivar.standards.po;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.standards.vo.StandardMageListVo;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.Date;

/**
 * StandardMagePagePo
 * 2020/07/24 11:21:45
 */
public class StandardMagePagePo extends PagePo<StandardMageListVo> {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 种植采收加工标准类型
     */
    @ApiModelProperty(value = "种植采收加工标准类型")
    @Check(test = "required")
    private String plantRecoProcessType;

    /**
     * 标准名称
     */
    @ApiModelProperty(value = "标准名称")
    private String plantStandardName;

    /**
     * 产品图片
     */
    @ApiModelProperty(value = "产品图片")
    private String prudtUrl;

    /**
     * 种植标准类型
     */
    @ApiModelProperty(value = "种植标准类型")
    private String plantType;

    /**
     * 摘要
     */
    @ApiModelProperty(value = "摘要")
    private String outline;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private Date createDate;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "更新时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private Date updateDate;

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @ApiModelProperty(value = "结束时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime endTime;

    @ApiModelProperty(value = "创建时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime startTime;

    public OffsetDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(OffsetDateTime endTime) {
        this.endTime = endTime;
    }

    public OffsetDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(OffsetDateTime startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取种植采收加工标准类型
     */
    public String getPlantRecoProcessType() {
        return plantRecoProcessType;
    }

    /**
     * 设置种植采收加工标准类型
     */
    public void setPlantRecoProcessType(String plantRecoProcessType) {
        this.plantRecoProcessType = plantRecoProcessType == null ? null : plantRecoProcessType.trim();
    }

    /**
     * 获取标准名称
     */
    public String getPlantStandardName() {
        return plantStandardName;
    }

    /**
     * 设置标准名称
     */
    public void setPlantStandardName(String plantStandardName) {
        this.plantStandardName = plantStandardName == null ? null : plantStandardName.trim();
    }

    /**
     * 获取产品图片
     */
    public String getPrudtUrl() {
        return prudtUrl;
    }

    /**
     * 设置产品图片
     */
    public void setPrudtUrl(String prudtUrl) {
        this.prudtUrl = prudtUrl == null ? null : prudtUrl.trim();
    }

    /**
     * 获取种植标准类型
     */
    public String getPlantType() {
        return plantType;
    }

    /**
     * 设置种植标准类型
     */
    public void setPlantType(String plantType) {
        this.plantType = plantType == null ? null : plantType.trim();
    }

    /**
     * 获取摘要
     */
    public String getOutline() {
        return outline;
    }

    /**
     * 设置摘要
     */
    public void setOutline(String outline) {
        this.outline = outline == null ? null : outline.trim();
    }

    /**
     * 获取备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 获取删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}
