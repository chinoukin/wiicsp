package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cultivar.common.vo.tp.LabelLitInfoListVo;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;
import io.swagger.annotations.ApiModelProperty;

/**
 * LabelLitInfoPagePo
 * 2018/09/18 14:36:47
 */
public class LabelLitInfoPagePo extends PagePo<LabelLitInfoListVo> {
    private static final long serialVersionUID = 1L;

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

    /**
     * 是否已点亮标识
     */
    @ApiModelProperty(value = "是否已点亮标识")
    private String haveBeenLitFlag;

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
