package com.wisea.transac.common.po.trade;

import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.trade.ApPayMagePageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页查询账期设置Po")
public class ApPayMagePageListPo extends PagePo<ApPayMagePageListVo> {
    @ApiModelProperty("搜索栏输入内容")
    private String query;
    @ApiModelProperty("查询类型：0 已设置、 1 已冻结、 2 未开通")
    @Check(test = "required", requiredMsg = "查询类型不能为空")
    private String queryFlag;
    @ApiModelProperty(value = "卖家ID", hidden = true)
    private Long sellerId;
    @ApiModelProperty(value = "会员ID", hidden = true)
    private Long membId;

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

    public String getQueryFlag() {
        return queryFlag;
    }

    public void setQueryFlag(String queryFlag) {
        this.queryFlag = queryFlag;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
}
