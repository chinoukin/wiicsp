package com.wisea.cultivar.common.vo.tp.origin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author wangjiahao
 * @version 1.0
 * @className OriClQuarantineVo
 * @since 2019-03-25 11:28
 */
@ApiModel("出栏检疫报告")
public class OriClQuarantineVo {

    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("检疫报告URL")
    private String quarantineReportUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuarantineReportUrl() {
        return quarantineReportUrl;
    }

    public void setQuarantineReportUrl(String quarantineReportUrl) {
        this.quarantineReportUrl = quarantineReportUrl;
    }
}
