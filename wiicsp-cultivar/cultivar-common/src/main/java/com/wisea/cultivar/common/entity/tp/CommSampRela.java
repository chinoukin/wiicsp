package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * comm_samp_rela 表实体
 * 关系类型： 0检测关系 1品鉴关系
 * 2018/09/18 14:36:47
 */
public class CommSampRela extends DataLongEntity<CommSampRela> {
    private static final long serialVersionUID = 1L;

    /**
     * 商品发布id
     */
    private Long commPubId;

    /**
     * 样品id
     */
    private Long sampId;

    /**
     * 关系类型
     */
    private String relaType;

    /**
     * 会员标签id
     */
    private Long membLabelId;

    public Long getMembLabelId() {
        return membLabelId;
    }

    public void setMembLabelId(Long membLabelId) {
        this.membLabelId = membLabelId;
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
     * 获取样品id
     */
    public Long getSampId() {
        return sampId;
    }

    /**
     * 设置样品id
     */
    public void setSampId(Long sampId) {
        this.sampId = sampId;
    }

    /**
     * 获取关系类型
     */
    public String getRelaType() {
        return relaType;
    }

    /**
     * 设置关系类型
     */
    public void setRelaType(String relaType) {
        this.relaType = relaType == null ? null : relaType.trim();
    }
}
