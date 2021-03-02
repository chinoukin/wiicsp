package com.wisea.cultivar.common.po.bigdata;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.bigdata.JyOrdMageListVo;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * JyOrdMagePagePo
 * 2019/12/02 11:02:14
 */
public class JyOrdMagePagePo extends PagePo<JyOrdMageListVo> {
    @ApiModelProperty(value = "单据日期")
    private OffsetDateTime djDate;
    @ApiModelProperty(value = "导入时间")
    private OffsetDateTime drDate;
    @ApiModelProperty(value = "查询框输入值")
    private String queryInput;

    public OffsetDateTime getDjDate() {
        return djDate;
    }

    public void setDjDate(OffsetDateTime djDate) {
        this.djDate = djDate;
    }

    public OffsetDateTime getDrDate() {
        return drDate;
    }

    public void setDrDate(OffsetDateTime drDate) {
        this.drDate = drDate;
    }

    public String getQueryInput() {
        return queryInput;
    }

    public void setQueryInput(String queryInput) {
        this.queryInput = queryInput;
    }
}
