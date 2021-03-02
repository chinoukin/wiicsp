package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * label_lit_info 表实体
 * 标签点亮信息
 * 2018/09/18 14:36:47
 */
public class LabelLitInfo extends DataLongEntity<LabelLitInfo> {
    private static final long serialVersionUID = 1L;

    /**
     * 商品发布id
     */
    private Long commPubId;

    /**
     * 标签类型
     */
    private Long membLabelId;

    /**
     * 是否已点亮标识
     */
    private String haveBeenLitFlag;

    /**
     * 标签类型
     */
    private String labelRelaType;

    /**
     * 图片url
     */
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLabelRelaType() {
        return labelRelaType;
    }

    public void setLabelRelaType(String labelRelaType) {
        this.labelRelaType = labelRelaType;
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

    public Long getMembLabelId() {
        return membLabelId;
    }

    public void setMembLabelId(Long membLabelId) {
        this.membLabelId = membLabelId;
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
}
