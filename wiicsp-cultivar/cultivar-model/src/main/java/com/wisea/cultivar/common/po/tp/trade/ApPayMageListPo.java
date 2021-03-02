package com.wisea.cultivar.common.po.tp.trade;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.tp.trade.ApPayMageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className ApPayMageListPo
 * @date 2019/4/22 10:34
 * @Description 账期支付设置列表PO
 */
@ApiModel("账期支付设置列表PO")
public class ApPayMageListPo extends PagePo<ApPayMageListVo> {
    @ApiModelProperty(value = "当前会员ID", hidden = true)
    private Long membId;
    @ApiModelProperty("授信状态")
    private String creditType;
    @ApiModelProperty("输入框查询条件")
    private String query;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
