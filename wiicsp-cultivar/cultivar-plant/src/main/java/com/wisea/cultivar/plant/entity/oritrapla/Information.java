package com.wisea.cultivar.plant.entity.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @Description: 消息信息
 * @author: wangs
 * @date :2018/6/5
 */
@ApiModel("平台消息信息")
public class Information extends DataLongEntity<Information> {

    /**
     * 会员id
     */
    @ApiModelProperty(value = "会员id")
    private Long membId;
    /**
     * 消息标题
     */
    @ApiModelProperty(value = "消息标题")
    private String infoTitle;
    /**
     * 是否已读
     * 0,是;1,否;
     */
    @ApiModelProperty(value = "消息是否已读")
    private String readFlag;
    /**
     * 推送时间
     */
    @ApiModelProperty(value = "推送时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime pushDateTime;
    /**
     * 消息内容
     */
    @ApiModelProperty(value = "消息内容")
    private String content;

    @ApiModelProperty(value = "消息type")
    private String archType;

    @ApiModelProperty(value = "主体名称")
    private String orgName;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getInfoTitle() {
        return infoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle;
    }

    public String getReadFlag() {
        return readFlag;
    }

    public void setReadFlag(String readFlag) {
        this.readFlag = readFlag;
    }

    public OffsetDateTime getPushDateTime() {
        return pushDateTime;
    }

    public void setPushDateTime(OffsetDateTime pushDateTime) {
        this.pushDateTime = pushDateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getArchType() {
        return archType;
    }

    public void setArchType(String archType) {
        this.archType = archType;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
}
