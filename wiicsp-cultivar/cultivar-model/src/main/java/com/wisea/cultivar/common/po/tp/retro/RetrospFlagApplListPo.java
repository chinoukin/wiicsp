package com.wisea.cultivar.common.po.tp.retro;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.tp.retro.RetrospFlagApplListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @author jirg
 * @version 1.0
 * @className RetrospFlagApplListPo
 * @date 2019/12/20 10:17
 * @Description 追溯标签申请记录列表Po
 */
@ApiModel("追溯标签申请记录列表Po")
public class RetrospFlagApplListPo extends PagePo<RetrospFlagApplListVo> {
    @ApiModelProperty(value = "会员ID", hidden = true)
    private Long membId;
    @ApiModelProperty("查询框内容")
    private String query;
    @ApiModelProperty("申请类型")
    private String retroLabelType;
    @ApiModelProperty("申请方式类型")
    private String applModeType;
    @ApiModelProperty("申请状态")
    private String retroLabelState;
    @ApiModelProperty("申请开始时间")
    private OffsetDateTime applDateStart;
    @ApiModelProperty("申请结束时间")
    private OffsetDateTime applDateEnd;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getRetroLabelType() {
        return retroLabelType;
    }

    public void setRetroLabelType(String retroLabelType) {
        this.retroLabelType = retroLabelType;
    }

    public String getApplModeType() {
        return applModeType;
    }

    public void setApplModeType(String applModeType) {
        this.applModeType = applModeType;
    }

    public String getRetroLabelState() {
        return retroLabelState;
    }

    public void setRetroLabelState(String retroLabelState) {
        this.retroLabelState = retroLabelState;
    }

    public OffsetDateTime getApplDateStart() {
        return applDateStart;
    }

    public void setApplDateStart(OffsetDateTime applDateStart) {
        this.applDateStart = applDateStart;
    }

    public OffsetDateTime getApplDateEnd() {
        return applDateEnd;
    }

    public void setApplDateEnd(OffsetDateTime applDateEnd) {
        this.applDateEnd = applDateEnd;
    }
}
