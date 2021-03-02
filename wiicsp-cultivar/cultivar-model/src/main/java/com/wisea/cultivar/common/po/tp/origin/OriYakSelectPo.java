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
 * @className OriYakSelectPo
 * @since 2019-03-22 16:07
 */
@ApiModel("牦牛选择PO")
public class OriYakSelectPo {

    @ApiModelProperty("批次ID")
    @JsonSerialize(using = IdSerializer.class)
    private Long clBatchId;

    @ApiModelProperty(value = "用户ID",hidden = true)
    private Long membId;

    /**
     * yakIds
     */
    @ApiModelProperty(value = "id列表")
    private List<Long> yakIds;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public List<Long> getYakIds() {
        return yakIds;
    }

    public void setYakIds(List<Long> yakIds) {
        this.yakIds = yakIds;
    }

    public Long getClBatchId() {
        return clBatchId;
    }

    public void setClBatchId(Long clBatchId) {
        this.clBatchId = clBatchId;
    }
}
