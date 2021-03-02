package com.wisea.cultivar.common.vo.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * LabelLitInfoGetVo
 * 2018/09/18 14:36:47
 */
public class LabelLitInfoGetVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 商品发布id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商品发布id")
    private Long commPubId;

    /**
     * 标签类型
     */
    @ApiModelProperty(value = "标签类型")
    private String labelType;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty("后台标签id")
    private Long membLabelId;

    /**
     * 是否已点亮标识
     */
    @ApiModelProperty(value = "是否已点亮标识")
    private String haveBeenLitFlag;

    @ApiModelProperty("上传图片的url")
    private String url;
    @ApiModelProperty("标签type")
    private String labelRelaType;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    @ApiModelProperty("标签名称")
    /**
     * 标签名称
     */
     private String labelName;

    @ApiModelProperty("标签url")
    /**
     * 标签url
     */
    private String actUrl;

    @ApiModelProperty("排序")
    private String sort;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getLabelRelaType() {
        return labelRelaType;
    }

    public void setLabelRelaType(String labelRelaType) {
        this.labelRelaType = labelRelaType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getActUrl() {
        return actUrl;
    }

    public void setActUrl(String actUrl) {
        this.actUrl = actUrl;
    }

    public Long getMembLabelId() {
        return membLabelId;
    }

    public void setMembLabelId(Long membLabelId) {
        this.membLabelId = membLabelId;
    }

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
     * 获取商品发布id
     */
    public Long getCommPubId() {
        return commPubId;
    }

    /**
     * 设置商品发布id
     */
    public void setCommPubId(Long commPubId) {
        this.commPubId = commPubId;
    }

    /**
     * 获取标签类型
     */
    public String getLabelType() {
        return labelType;
    }

    /**
     * 设置标签类型
     */
    public void setLabelType(String labelType) {
        this.labelType = labelType == null ? null : labelType.trim();
    }

    /**
     * 获取是否已点亮标识
     */
    public String getHaveBeenLitFlag() {
        return haveBeenLitFlag;
    }

    /**
     * 设置是否已点亮标识
     */
    public void setHaveBeenLitFlag(String haveBeenLitFlag) {
        this.haveBeenLitFlag = haveBeenLitFlag == null ? null : haveBeenLitFlag.trim();
    }

    /**
     * 获取备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 获取删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}
