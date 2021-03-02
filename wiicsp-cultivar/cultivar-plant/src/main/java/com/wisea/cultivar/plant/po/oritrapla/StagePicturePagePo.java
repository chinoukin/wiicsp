package com.wisea.cultivar.plant.po.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.plant.vo.oritrapla.StagePictureListVo;
import io.swagger.annotations.ApiModelProperty;

/**
 * StagePicturePagePo
 * 2019/05/27 13:59:47
 */
public class StagePicturePagePo extends PagePo<StagePictureListVo> {
    private static final long serialVersionUID = 1L;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "farmingStageId")
    private Long farmingStageId;

    @ApiModelProperty(value = "url")
    private String url;

    @ApiModelProperty(value = "sortIndex")
    private Integer sortIndex;

    @ApiModelProperty(value = "remarks")
    private String remarks;

    @ApiModelProperty(value = "delFlag")
    private String delFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}
