package com.wisea.transac.common.po.product;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.product.CammSalesReleaseMageListVo;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description:
 * @author: wangs
 * @date :2020/4/30
 */
public class CommSalesReleasePagePo extends PagePo<CammSalesReleaseMageListVo> {

    @ApiModelProperty("查询框内容")
    private String query;
    @ApiModelProperty("有效状态")
    private String effeInvalState;
    @ApiModelProperty("销售分类id")
    private Long commSalesCatgId;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getEffeInvalState() {
        return effeInvalState;
    }

    public void setEffeInvalState(String effeInvalState) {
        this.effeInvalState = effeInvalState;
    }

    public Long getCommSalesCatgId() {
        return commSalesCatgId;
    }

    public void setCommSalesCatgId(Long commSalesCatgId) {
        this.commSalesCatgId = commSalesCatgId;
    }
}
