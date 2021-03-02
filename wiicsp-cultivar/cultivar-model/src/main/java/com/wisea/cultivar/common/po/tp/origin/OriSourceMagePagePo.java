package com.wisea.cultivar.common.po.tp.origin;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.tp.origin.OriSourceMagePageVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className OriYakSourceMagePagePo
 * @date 2019/3/26 10:10
 * @Description
 */
@ApiModel("分页查询牛源牧场Po")
public class OriSourceMagePagePo extends PagePo<OriSourceMagePageVo> {
    @ApiModelProperty("输入框查询条件")
    private String query;
    @ApiModelProperty(value = "会员ID", hidden = true)
    private Long membId;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }
}
