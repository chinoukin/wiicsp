package com.wisea.cultivar.plant.po.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * StagePictureInsertPo
 * 2019/05/27 13:59:47
 */
public class StagePictureInsertPo {
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "farmingStageId")
    private Long farmingStageId;

    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "url")
    private String url;

    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "sortIndex")
    private Integer sortIndex;

    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "remarks")
    private String remarks;

    public Long getFarmingStageId() {
        return farmingStageId;
    }

    public void setFarmingStageId(Long farmingStageId) {
        this.farmingStageId = farmingStageId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}
