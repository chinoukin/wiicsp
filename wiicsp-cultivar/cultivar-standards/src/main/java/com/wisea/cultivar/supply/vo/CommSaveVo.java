package com.wisea.cultivar.supply.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * 商品保存
 * @author chengq
 * @date 2020/8/13 15:25
 */
public class CommSaveVo {

    /**
     * 商品id
     */
    @ApiModelProperty("商品id")
    private String commId;

    /**
     * 是否需要审核
     */
    @ApiModelProperty("是否需要审核 0-需要 1-不需要")
    private String check;


    public String getCommId() {
        return commId;
    }

    public void setCommId(String commId) {
        this.commId = commId;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public CommSaveVo(String commId, String check) {
        this.commId = commId;
        this.check = check;
    }

    public CommSaveVo() {
    }
}
