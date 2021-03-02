package com.wisea.cultivar.common.po.tp.retro;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.tp.retro.RetrospCxRecordListVo;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @author jirg
 * @version 1.0
 * @className RetrospCxRecordListPo
 * @date 2019/12/21 12:41
 * @Description 查询追溯查询记录列表Po
 */
public class RetrospCxRecordListPo extends PagePo<RetrospCxRecordListVo> {
    @ApiModelProperty(value = "会员ID", hidden = true)
    private Long membId;
    @ApiModelProperty("查询框内容")
    private String query;
    @ApiModelProperty("查询方式类型")
    private String cxModeType;
    @ApiModelProperty("查询开始时间")
    private OffsetDateTime cxDateStart;
    @ApiModelProperty("查询结束时间")
    private OffsetDateTime cxDateEnd;

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

    public String getCxModeType() {
        return cxModeType;
    }

    public void setCxModeType(String cxModeType) {
        this.cxModeType = cxModeType;
    }

    public OffsetDateTime getCxDateStart() {
        return cxDateStart;
    }

    public void setCxDateStart(OffsetDateTime cxDateStart) {
        this.cxDateStart = cxDateStart;
    }

    public OffsetDateTime getCxDateEnd() {
        return cxDateEnd;
    }

    public void setCxDateEnd(OffsetDateTime cxDateEnd) {
        this.cxDateEnd = cxDateEnd;
    }
}
