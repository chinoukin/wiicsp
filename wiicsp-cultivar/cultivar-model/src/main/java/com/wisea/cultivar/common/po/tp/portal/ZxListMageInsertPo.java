package com.wisea.cultivar.common.po.tp.portal;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 资讯列表管理插入操作PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年8月31日
 * @version 1.0
 */
@ApiModel("资讯列表管理插入操作PO")
public class ZxListMageInsertPo {

	/**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id(新增时候为空，修改时候必须填写)")
    private Long id;
    /**
     * 图片
     */
    @Check(test = "required")
    @ApiModelProperty(value = "图片")
    private String url;

    /**
     * 标题
     */
    @Check(test = { "maxLength","required" }, mixLength = 255,lengthMsg="标题最大长度为255")
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 所属分类
     */
    @Check(test = {"required", "liveable"}, liveable = {"0", "1","2"}, liveableMsg = "只能为0、1、2")
    @ApiModelProperty(value = "所属分类(zx_catg_type 0:布依文化1:生态旅游2:糯米蕉产业资讯)")
    private String zxCatgType;

    /**
     * 摘要
     */
    @Check(test = { "maxLength","required" }, mixLength = 400,lengthMsg="摘要最大长度为400")
    @ApiModelProperty(value = "摘要")
    private String zy;

    /**
     * 信息来源
     */
    @Check(test = { "maxLength","required" }, mixLength = 255,lengthMsg="信息来源最大长度为255")
    @ApiModelProperty(value = "信息来源")
    private String xxly;

    /**
     * 是否显示
     */
    @Check(test = {"required", "liveable"}, liveable = {"0", "1"}, liveableMsg = "只能为0或者1")
    @ApiModelProperty(value = "是否显示(if_requ 0:是1:否)")
    private String ifRequ;

    /**
     * 内容
     */
    @ApiModelProperty(value = "内容")
    private String content;

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
     * 获取所属分类
     */
    public String getZxCatgType() {
        return zxCatgType;
    }

    /**
     * 设置所属分类
     */
    public void setZxCatgType(String zxCatgType) {
        this.zxCatgType = zxCatgType == null ? null : zxCatgType.trim();
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

    /**
     * 获取内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
