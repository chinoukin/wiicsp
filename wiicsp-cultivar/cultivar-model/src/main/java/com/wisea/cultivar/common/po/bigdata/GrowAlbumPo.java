package com.wisea.cultivar.common.po.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @author jirg
 * @version 1.0
 * @className GrowAlbumPo
 * @date 2019/7/19 18:13
 * @Description 实时监视PO
 */
@ApiModel("实时监视PO")
public class GrowAlbumPo {
    @ApiModelProperty("设备ID")
    @Check(test = "required")
    private Long equId;
    @ApiModelProperty("指定查询日期")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime queryDate;

    public Long getEquId() {
        return equId;
    }

    public void setEquId(Long equId) {
        this.equId = equId;
    }

    public OffsetDateTime getQueryDate() {
        return queryDate;
    }

    public void setQueryDate(OffsetDateTime queryDate) {
        this.queryDate = queryDate;
    }
}
