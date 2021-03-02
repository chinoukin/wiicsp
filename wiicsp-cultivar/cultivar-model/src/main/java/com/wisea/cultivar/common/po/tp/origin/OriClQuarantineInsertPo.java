package com.wisea.cultivar.common.po.tp.origin;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author wangjiahao
 * @version 1.0
 * @className OriClQuarantineVo
 * @since 2019-03-25 11:28
 */
@ApiModel("出栏检疫报告插入PO")
public class OriClQuarantineInsertPo {

    @ApiModelProperty("出栏批次Id")
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = "required")
    private Long clBatchId;

    @ApiModelProperty("检疫报告URL列表")
    @Check(test = "required")
    private List<String> quarantineReportUrls;

    public Long getClBatchId() {
        return clBatchId;
    }

    public void setClBatchId(Long clBatchId) {
        this.clBatchId = clBatchId;
    }

    public List<String> getQuarantineReportUrls() {
        return quarantineReportUrls;
    }

    public void setQuarantineReportUrls(List<String> quarantineReportUrls) {
        this.quarantineReportUrls = quarantineReportUrls;
    }
}
