package com.wisea.cultivar.plant.po.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.plant.entity.oritrapla.PlatfNoticeVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @Description: 后台系统公告列表传入参数
 * @author: wangs
 * @date :2018/6/5
 */
@ApiModel("后台系统公告列表传入Po")
public class PlatfNoticPo extends PagePo<PlatfNoticeVo> {

    /**
     * 标题
     */
    @ApiModelProperty(value="标题")
    private String title;

    @ApiModelProperty("更新日期开始")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime releDateStart;

    @ApiModelProperty("更新日期结束")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime releDateEnd;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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
}
