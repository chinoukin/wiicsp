package com.wisea.cultivar.supply.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author chengq
 * @date 2020/8/15 18:45
 */
public class AttSetGetPo {

    @ApiModelProperty("商品id")
    @Check(test = {"required" }, requiredMsg = "商品id不能为空")
    private Long commId;

    @ApiModelProperty("用户商品id")
    private Long pubId;

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

    public Long getPubId() {
        return pubId;
    }

    public void setPubId(Long pubId) {
        this.pubId = pubId;
    }
}
