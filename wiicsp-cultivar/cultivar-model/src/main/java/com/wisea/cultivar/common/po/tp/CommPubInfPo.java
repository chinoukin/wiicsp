package com.wisea.cultivar.common.po.tp;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 商品上一步传入参数
 * @author: wangs
 * @date :2018/10/15
 */
@ApiModel("商品发布上一步入参")
public class CommPubInfPo {

    @ApiModelProperty("商品key值")
    @Check(test = "required", requiredMsg = "商品key不能为空")
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
