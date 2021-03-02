package com.wisea.cultivar.plant.entity.oritrapla;

import com.wisea.cloud.common.entity.DataLongEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * 平台公告
 */
@ApiModel("平台公告信息")
public class PlatfNotice extends DataLongEntity<PlatfNotice> {

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
}
