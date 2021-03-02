package com.wisea.cultivar.plant.entity.oritrapla;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * standard_info 表实体
 * 标准详情
 * 2019/05/27 13:59:47
 */
public class StandardInfo extends DataLongEntity<StandardInfo> {
    private static final long serialVersionUID = 1L;

    private Long standardSpecificationId;

    private String titleName;

    private String standardContent;

    public Long getStandardSpecificationId() {
        return standardSpecificationId;
    }

    public void setStandardSpecificationId(Long standardSpecificationId) {
        this.standardSpecificationId = standardSpecificationId;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName == null ? null : titleName.trim();
    }

    public String getStandardContent() {
        return standardContent;
    }

    public void setStandardContent(String standardContent) {
        this.standardContent = standardContent == null ? null : standardContent.trim();
    }
}
