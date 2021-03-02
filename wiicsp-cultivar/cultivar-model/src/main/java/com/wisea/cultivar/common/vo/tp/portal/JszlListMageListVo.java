package com.wisea.cultivar.common.vo.tp.portal;

import java.io.Serializable;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 技术资料列表管理查询列表VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年8月30日
 * @version 1.0
 */
@ApiModel("技术资料列表管理查询列表VO")
public class JszlListMageListVo implements Serializable{

	private static final long serialVersionUID = -2954458576934474483L;

	/**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 技术资料分类名称
     */
    @ApiModelProperty(value = "技术资料分类名称")
    private String jszlCatgName;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "技术资料分类ID")
    private Long jszlCatgId;

    /**
     * 图片
     */
    @ApiModelProperty(value = "图片")
    private String url;

    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 摘要
     */
    @ApiModelProperty(value = "摘要")
    private String zy;

    /**
     * 信息来源
     */
    @ApiModelProperty(value = "信息来源")
    private String xxly;

    /**
     * 发布时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "发布时间")
    private OffsetDateTime pubDate;

    /**
     * 是否显示
     */
    @ApiModelProperty(value = "是否显示(if_requ 0:是1:否)")
    private String ifRequ;


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
     * 获取图片
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置图片
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

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
     * 获取摘要
     */
    public String getZy() {
        return zy;
    }

    /**
     * 设置摘要
     */
    public void setZy(String zy) {
        this.zy = zy == null ? null : zy.trim();
    }

    /**
     * 获取信息来源
     */
    public String getXxly() {
        return xxly;
    }

    /**
     * 设置信息来源
     */
    public void setXxly(String xxly) {
        this.xxly = xxly == null ? null : xxly.trim();
    }

    /**
     * 获取发布时间
     */
    public OffsetDateTime getPubDate() {
        return pubDate;
    }

    /**
     * 设置发布时间
     */
    public void setPubDate(OffsetDateTime pubDate) {
        this.pubDate = pubDate;
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

	public String getJszlCatgName() {
		return jszlCatgName;
	}

	public void setJszlCatgName(String jszlCatgName) {
		this.jszlCatgName = jszlCatgName;
	}

	public Long getJszlCatgId() {
		return jszlCatgId;
	}

	public void setJszlCatgId(Long jszlCatgId) {
		this.jszlCatgId = jszlCatgId;
	}
}
