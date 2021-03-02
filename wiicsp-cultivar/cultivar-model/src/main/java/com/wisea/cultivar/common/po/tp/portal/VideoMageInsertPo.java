package com.wisea.cultivar.common.po.tp.portal;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 视频中心列表管理插入操作PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年8月30日
 * @version 1.0
 */
@ApiModel("视频中心列表管理插入操作PO")
public class VideoMageInsertPo {

	/**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id(新增时候为空，修改时候必须填写)")
    private Long id;
    /**
     * 标题
     */
    @Check(test = { "maxLength","required"}, mixLength = 255)
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 视频来源类型
     */
    @Check(test = {"required", "liveable"}, liveable = {"0", "1"}, liveableMsg = "只能为0或者1")
    @ApiModelProperty(value = "视频来源类型(video_ly_type 0:本地视频1:外部链接)")
    private String videoLyType;

    /**
     * 视频url
     */
    @Check(test = { "maxLength","required"}, mixLength = 255)
    @ApiModelProperty(value = "视频url")
    private String url;

    /**
     * 显示顺序
     */
    @Check(test = { "maxLength","required" }, length = 10)
    @ApiModelProperty(value = "显示顺序")
    private Integer sort;

    /**
     * 是否显示
     */
    @Check(test = { "maxLength","required" }, mixLength = 1)
    @ApiModelProperty(value = "是否显示")
    private String ifRequ;

    /**
     * 获取标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取视频来源类型
     */
    public String getVideoLyType() {
        return videoLyType;
    }

    /**
     * 设置视频来源类型
     */
    public void setVideoLyType(String videoLyType) {
        this.videoLyType = videoLyType == null ? null : videoLyType.trim();
    }

    /**
     * 获取视频url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置视频url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取显示顺序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置显示顺序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取是否显示
     */
    public String getIfRequ() {
        return ifRequ;
    }

    /**
     * 设置是否显示
     */
    public void setIfRequ(String ifRequ) {
        this.ifRequ = ifRequ == null ? null : ifRequ.trim();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
