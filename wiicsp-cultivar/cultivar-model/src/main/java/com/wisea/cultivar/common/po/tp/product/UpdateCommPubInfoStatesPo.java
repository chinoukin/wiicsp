package com.wisea.cultivar.common.po.tp.product;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Author
 * 批量更新商家端商品列表
 */
public class UpdateCommPubInfoStatesPo {
    @ApiModelProperty("状态标识")
    @Check(test = "required")
    private String stateType;
    @ApiModelProperty("id集合")
    @Check(test = "required")
    private List<Long> ids;
    @ApiModelProperty("delFlag批量删除标识")
    private String delFlag;

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getStateType() {
        return stateType;
    }

    public void setStateType(String stateType) {
        this.stateType = stateType;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
