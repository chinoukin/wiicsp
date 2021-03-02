package com.wisea.cultivar.common.po.tp.product;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Author
 * 批量更新商家端商品列表
 */
public class UpdateCommPubInfoDelFlagPo {

    @ApiModelProperty("id集合")
    @Check(test = "required")
    private List<Long> ids;
    @ApiModelProperty("delFlag批量删除标识,传delFlag等于1")
    private String delFlag;

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
