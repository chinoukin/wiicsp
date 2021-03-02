package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * LabelLitInfoInsertPo
 * 2018/09/18 14:36:47
 */
public class LabelLitInfoInsertPo {
    /**
     * 商品发布id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "商品发布id")
    private Long commPubId;

    /**
     * 标签类型
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "标签类型")
    private String labelType;

    /**
     * 是否已点亮标识
     */
    @Check(test = { "maxLength" }, mixLength = 1)
    @ApiModelProperty(value = "是否已点亮标识")
    private String haveBeenLitFlag;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

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
}
