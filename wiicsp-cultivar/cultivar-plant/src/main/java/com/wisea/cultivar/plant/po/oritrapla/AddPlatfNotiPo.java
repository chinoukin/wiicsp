package com.wisea.cultivar.plant.po.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @Description: 新增系统公告Po
 * @author: wangs
 * @date :2018/6/5
 */
@ApiModel("新增系统公告Po")
public class AddPlatfNotiPo {

    /**
     * 平台公告id
     */
    @ApiModelProperty(value = "平台公告id更新时传递")
    private Long id;
    /**
     * 标题
     */
    @ApiModelProperty(value="标题")
    @Check(test = "required")
    private String title;
    /**
     * 摘要
     */
    @ApiModelProperty(value="摘要")
    @Check(test = "required")
    private String tabloid;
    /**
     * 内容
     */
    @ApiModelProperty(value="内容")
    @Check(test = "required")
    private String content;

    /**
     * 排他字段 更新时间
     */
    @ApiModelProperty(value="排他字段")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime updateDate;

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

    public OffsetDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(OffsetDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
