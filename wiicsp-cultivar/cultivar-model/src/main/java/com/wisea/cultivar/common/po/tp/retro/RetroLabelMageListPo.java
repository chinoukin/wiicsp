package com.wisea.cultivar.common.po.tp.retro;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.tp.retro.RetroLabelMageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * 追溯标签申请列表PO
 * 2018/10/11 09:24:35
 */
@ApiModel("追溯标签申请列表PO")
public class RetroLabelMageListPo extends PagePo<RetroLabelMageListVo> {

    @ApiModelProperty(value = "申请日期开始时间")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime startApplDate;
    @ApiModelProperty(value = "申请日期结束时间")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime endApplDate;
    @ApiModelProperty(value = "追溯标签类型")
    private String retroLabelType;
    @ApiModelProperty(value = "追溯标签状态")
    private String retroLabelState;
    @ApiModelProperty(value = "查询输入框")
    private String query;
    @ApiModelProperty("卖家用户ID")
    private Long sellerId;

    public OffsetDateTime getStartApplDate() {
        return startApplDate;
    }

    public void setStartApplDate(OffsetDateTime startApplDate) {
        this.startApplDate = startApplDate;
    }

    public OffsetDateTime getEndApplDate() {
        return endApplDate;
    }

    public void setEndApplDate(OffsetDateTime endApplDate) {
        this.endApplDate = endApplDate;
    }

    public String getRetroLabelType() {
        return retroLabelType;
    }

    public void setRetroLabelType(String retroLabelType) {
        this.retroLabelType = retroLabelType;
    }

    public String getRetroLabelState() {
        return retroLabelState;
    }

    public void setRetroLabelState(String retroLabelState) {
        this.retroLabelState = retroLabelState;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
}
