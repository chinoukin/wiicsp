package com.wisea.cultivar.plant.entity.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @Description: 平台公告
 * @author: wangs
 * @date :2018/7/6
 */
@ApiModel("平台公告展示信息")
public class PlatfNoticeVo {

    @ApiModelProperty(value="id")
    private Long id;
    /**
     * 标题
     */
    @ApiModelProperty(value="标题")
    private String title;
    /**
     * 摘要
     */
    @ApiModelProperty(value="摘要")
    private String tabloid;
    /**
     * 内容
     */
    @ApiModelProperty(value="内容")
    private String content;
    @ApiModelProperty(value="发布时间开始")
    private OffsetDateTime releDateStart;
    @ApiModelProperty(value="发布时间结束")
    private OffsetDateTime releDateEnd;
    @ApiModelProperty("更新时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime updateDate;
    @ApiModelProperty("更新人标记信息")
    private String updateBy;
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty("创建时间")
    private OffsetDateTime createDate;
    @ApiModelProperty("创建人")
    private String createBy;

    private String remarks;

    private String delFlag;

    public OffsetDateTime getReleDateStart() {
        return releDateStart;
    }

    public void setReleDateStart(OffsetDateTime releDateStart) {
        this.releDateStart = releDateStart;
    }

    public OffsetDateTime getReleDateEnd() {
        return releDateEnd;
    }

    public void setReleDateEnd(OffsetDateTime releDateEnd) {
        this.releDateEnd = releDateEnd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTabloid() {
        return tabloid;
    }

    public void setTabloid(String tabloid) {
        this.tabloid = tabloid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OffsetDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(OffsetDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public OffsetDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(OffsetDateTime createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
