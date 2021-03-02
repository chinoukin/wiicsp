package com.wisea.cultivar.common.vo.tp.origin;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

/**
 * OriBreedLogListVo
 * 2019/03/25 16:58:39
 */
public class OriBreedLogListVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 批次id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "批次id")
    private Long batchId;

    /**
     * 牦牛id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "牦牛id")
    private Long oriYakId;

    /**
     * 操作类型
     */
    @ApiModelProperty(value = "操作类型")
    private String oriOperateType;

    /**
     * 操作时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "操作时间")
    private OffsetDateTime operateDate;

    /**
     * 内容
     */
    @ApiModelProperty(value = "内容")
    private String content;

    /**
     * 耳标号
     */
    @ApiModelProperty(value = "耳标号")
    private String earLabel;

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
     * 获取批次id
     */
    public Long getBatchId() {
        return batchId;
    }

    /**
     * 设置批次id
     */
    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    /**
     * 获取牦牛id
     */
    public Long getOriYakId() {
        return oriYakId;
    }

    /**
     * 设置牦牛id
     */
    public void setOriYakId(Long oriYakId) {
        this.oriYakId = oriYakId;
    }

    /**
     * 获取操作类型
     */
    public String getOriOperateType() {
        return oriOperateType;
    }

    /**
     * 设置操作类型
     */
    public void setOriOperateType(String oriOperateType) {
        this.oriOperateType = oriOperateType == null ? null : oriOperateType.trim();
    }

    /**
     * 获取操作时间
     */
    public OffsetDateTime getOperateDate() {
        return operateDate;
    }

    /**
     * 设置操作时间
     */
    public void setOperateDate(OffsetDateTime operateDate) {
        this.operateDate = operateDate;
    }

    /**
     * 获取内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 获取耳标号
     */
    public String getEarLabel() {
        return earLabel;
    }

    /**
     * 设置耳标号
     */
    public void setEarLabel(String earLabel) {
        this.earLabel = earLabel == null ? null : earLabel.trim();
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
