package com.wisea.cultivar.common.po.tp.portal;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cultivar.common.vo.tp.portal.VideoMageListVo;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 视频中心列表管理分页查询返回列表PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年8月30日
 * @version 1.0
 */
@ApiModel("视频中心列表管理分页查询返回列表PO")
public class VideoMagePagePo extends PagePo<VideoMageListVo> {

    private static final long serialVersionUID = 1L;

    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 发布时间 -开始时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "发布时间-开始时间")
    private OffsetDateTime pubDateStart;
    /**
     * 发布时间-结束时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "发布时间-结束时间")
    private OffsetDateTime pubDateEnd;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public OffsetDateTime getPubDateStart() {
		return pubDateStart;
	}
	public void setPubDateStart(OffsetDateTime pubDateStart) {
		this.pubDateStart = pubDateStart;
	}
	public OffsetDateTime getPubDateEnd() {
		return pubDateEnd;
	}
	public void setPubDateEnd(OffsetDateTime pubDateEnd) {
		this.pubDateEnd = pubDateEnd;
	}

}
