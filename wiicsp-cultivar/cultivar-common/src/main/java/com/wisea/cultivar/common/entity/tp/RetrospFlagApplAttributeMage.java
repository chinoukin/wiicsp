package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

public class RetrospFlagApplAttributeMage extends DataLongEntity<RetrospFlagApplAttributeMage> {
    /**
     * 追溯标识申请id
     */
    private Long retrospFlagApplId;

    /**
     * 属性名称
     */
    private String attributeName;

    /**
     * 属性内容
     */
    private String attributeContent;

    /**
     * 排序
     */
    private Integer sort;

    public Long getRetrospFlagApplId() {
        return retrospFlagApplId;
    }

    public void setRetrospFlagApplId(Long retrospFlagApplId) {
        this.retrospFlagApplId = retrospFlagApplId;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeContent() {
        return attributeContent;
    }

    public void setAttributeContent(String attributeContent) {
        this.attributeContent = attributeContent;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
