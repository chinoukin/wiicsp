package com.wisea.cultivar.common.entity.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.cloud.model.annotation.IdSerializer;

/**
 * entp_cert_mage 表实体
 * 商家证书管理
 * 2018/10/09 16:37:34
 */
public class EntpCertMage extends DataLongEntity<EntpCertMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 会员id
     */
    @JsonSerialize(using = IdSerializer.class)
    private Long membId;

    /**
     * 会员标签id
     */
    @JsonSerialize(using = IdSerializer.class)
    private Long membLabelId;

    /**
     * 图片url
     */
    private String url;

    /**
     * 获取会员id
     */
    public Long getMembId() {
        return membId;
    }

    /**
     * 设置会员id
     */
    public void setMembId(Long membId) {
        this.membId = membId;
    }

    /**
     * 获取会员标签id
     */
    public Long getMembLabelId() {
        return membLabelId;
    }

    /**
     * 设置会员标签id
     */
    public void setMembLabelId(Long membLabelId) {
        this.membLabelId = membLabelId;
    }

    /**
     * 获取图片url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置图片url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}
