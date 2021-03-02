package com.wisea.cultivar.common.po.tp.portal;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 技术资料列表管理新增的PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年8月30日
 * @version 1.0
 */
@ApiModel("技术资料列表管理新增的PO")
public class JszlListMageInsertPo {

	/**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id(新增时候为空，修改时候必须填写)")
    private Long id;
    /**
     * 技术资料分类id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength","required" }, length = 19)
    @ApiModelProperty(value = "技术资料分类id")
    private Long jszlCatgId;

    /**
     * 图片
     */
    @Check(test = { "maxLength","required" }, mixLength = 255)
    @ApiModelProperty(value = "图片")
    private String url;

    /**
     * 标题
     */
    @Check(test = { "maxLength","required"  }, mixLength = 255)
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 摘要
     */
    @Check(test = { "maxLength","required"}, mixLength = 400)
    @ApiModelProperty(value = "摘要")
    private String zy;

    /**
     * 信息来源
     */
    @Check(test = { "maxLength","required"}, mixLength = 255)
    @ApiModelProperty(value = "信息来源")
    private String xxly;

    /**
     * 是否显示
     */
    @Check(test = {"required", "liveable"}, liveable = {"0", "1"}, liveableMsg = "只能为0或者1")
    @ApiModelProperty(value = "是否显示(if_requ 0:是1:否)")
    private String ifRequ;

    /**
     * 详细内容
     */
    @Check(test = { "maxLength" }, mixLength = 16777215)
    @ApiModelProperty(value = "详细内容")
    private String content;

	public Long getJszlCatgId() {
		return jszlCatgId;
	}

	public void setJszlCatgId(Long jszlCatgId) {
		this.jszlCatgId = jszlCatgId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getZy() {
		return zy;
	}

	public void setZy(String zy) {
		this.zy = zy;
	}

	public String getXxly() {
		return xxly;
	}

	public void setXxly(String xxly) {
		this.xxly = xxly;
	}

	public String getIfRequ() {
		return ifRequ;
	}

	public void setIfRequ(String ifRequ) {
		this.ifRequ = ifRequ;
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


}
