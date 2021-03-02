package com.wisea.cultivar.common.po.tp.system;

import com.wisea.cultivar.common.vo.tp.system.YmsjwhQyxxListVo;
import com.wisea.cloud.model.po.PagePo;
import io.swagger.annotations.ApiModelProperty;

/**
 * ymsjwh_qyxx 表实体
 * 页面数据企业信息
 * 2019/08/29 17:45:19
 */
public class YmsjwhQyxxPagePo  extends PagePo<YmsjwhQyxxListVo> {
    private static final long serialVersionUID = 1L;

    /**
     * 企业所属分类
     */
    @ApiModelProperty("企业所属分类")
    private String qyssCatgType;

    /**
     * 企业名称
     */
    @ApiModelProperty("企业名称")
    private String entpName;

    /**
     * 所在地址
     */
    @ApiModelProperty("所在地址")
    private String assress;

    /**
     * 企业简介
     */
    @ApiModelProperty("企业简介")
    private String entpJs;

    /**
     * 图片
     */
    @ApiModelProperty("图片")
    private String url;

    /**
     * 显示顺序
     */
    @ApiModelProperty("显示顺序")
    private Integer sort;

    /**
     * 是否显示
     */
    @ApiModelProperty("是否显示")
    private String ifRequ;

    /**
     * 详细内容
     */
    @ApiModelProperty("详细内容")
    private String content;

    /**
     * 获取企业所属分类
     */
    public String getQyssCatgType() {
        return qyssCatgType;
    }

    /**
     * 设置企业所属分类
     */
    public void setQyssCatgType(String qyssCatgType) {
        this.qyssCatgType = qyssCatgType == null ? null : qyssCatgType.trim();
    }

    /**
     * 获取企业名称
     */
    public String getEntpName() {
        return entpName;
    }

    /**
     * 设置企业名称
     */
    public void setEntpName(String entpName) {
        this.entpName = entpName == null ? null : entpName.trim();
    }

    /**
     * 获取所在地址
     */
    public String getAssress() {
        return assress;
    }

    /**
     * 设置所在地址
     */
    public void setAssress(String assress) {
        this.assress = assress == null ? null : assress.trim();
    }

    /**
     * 获取企业简介
     */
    public String getEntpJs() {
        return entpJs;
    }

    /**
     * 设置企业简介
     */
    public void setEntpJs(String entpJs) {
        this.entpJs = entpJs == null ? null : entpJs.trim();
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

    /**
     * 获取详细内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置详细内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
