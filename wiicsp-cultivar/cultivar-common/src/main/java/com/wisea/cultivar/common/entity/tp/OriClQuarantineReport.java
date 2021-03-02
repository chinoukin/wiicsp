package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * @Author jirg
 * @Date 2019/3/22 15:39
 * @Description 出栏检疫报告
 **/
public class OriClQuarantineReport extends DataLongEntity<OriClQuarantineReport> {
    /**
     * 销售出栏id
     */
    private Long saleClId;

    /**
     * 检疫报告url
     */
    private String quarantineReportUrl;

    public Long getSaleClId() {
        return saleClId;
    }

    public void setSaleClId(Long saleClId) {
        this.saleClId = saleClId;
    }

    public String getQuarantineReportUrl() {
        return quarantineReportUrl;
    }

    public void setQuarantineReportUrl(String quarantineReportUrl) {
        this.quarantineReportUrl = quarantineReportUrl;
    }
}
