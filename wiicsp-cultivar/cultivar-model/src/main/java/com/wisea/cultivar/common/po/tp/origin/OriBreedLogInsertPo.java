package com.wisea.cultivar.common.po.tp.origin;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

/**
 * OriBreedLogInsertPo
 * 2019/03/25 10:56:25
 */
public class OriBreedLogInsertPo {
    /**
     * 批次id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "批次id")
    private Long batchId;

    /**
     * 牦牛id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "牦牛id")
    private Long oriYakId;

    /**
     * 操作类型
     */
    @Check(test = { "maxLength" }, mixLength = 5)
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
    @Check(test = { "maxLength" }, mixLength = 1000)
    @ApiModelProperty(value = "内容")
    private String content;

    /**
     * 耳标号
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "耳标号")
    private String earLabel;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

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
}
