package com.wisea.cultivar.common.entity.tp;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * @Author jirg
 * @Date 2019/3/25 10:21
 * @Description 养殖日志
 **/
public class OriBreedLog extends DataLongEntity<OriBreedLog> {
    /**
     * 批次id
     */
    private Long batchId;

    /**
     * 牦牛id
     */
    private Long oriYakId;

    /**
     * 操作类型
     */
    private String oriOperateType;

    /**
     * 操作时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime operateDate;

    /**
     * 内容
     */
    private String content;

    /**
     * 耳标号
     */
    private String earLabel;

    /**
     * 操作图片
     */
    @ApiModelProperty(value = "操作图片")
    private List<String> operateUrlList;

    public List<String> getOperateUrlList() {
        return operateUrlList;
    }

    public void setOperateUrlList(List<String> operateUrlList) {
        this.operateUrlList = operateUrlList;
    }

    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public Long getOriYakId() {
        return oriYakId;
    }

    public void setOriYakId(Long oriYakId) {
        this.oriYakId = oriYakId;
    }

    public String getOriOperateType() {
        return oriOperateType;
    }

    public void setOriOperateType(String oriOperateType) {
        this.oriOperateType = oriOperateType;
    }

    public OffsetDateTime getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(OffsetDateTime operateDate) {
        this.operateDate = operateDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEarLabel() {
        return earLabel;
    }

    public void setEarLabel(String earLabel) {
        this.earLabel = earLabel;
    }
}
