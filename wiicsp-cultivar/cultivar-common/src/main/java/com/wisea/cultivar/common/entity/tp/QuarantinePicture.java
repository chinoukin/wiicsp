package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

public class QuarantinePicture extends DataLongEntity<QuarantinePicture> {
    private Long quarantineReportId; //检疫报告id
    private String quarantineUrl; //检疫证

    public Long getQuarantineReportId() {
        return quarantineReportId;
    }

    public void setQuarantineReportId(Long quarantineReportId) {
        this.quarantineReportId = quarantineReportId;
    }

    public String getQuarantineUrl() {
        return quarantineUrl;
    }

    public void setQuarantineUrl(String quarantineUrl) {
        this.quarantineUrl = quarantineUrl;
    }
}
