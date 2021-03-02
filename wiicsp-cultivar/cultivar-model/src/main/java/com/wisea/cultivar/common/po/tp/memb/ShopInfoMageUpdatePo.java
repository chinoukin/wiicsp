package com.wisea.cultivar.common.po.tp.memb;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 会员店铺信息保存PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年12月12日
 * @version 1.0
 */
@ApiModel("会员店铺信息保存PO")
public class ShopInfoMageUpdatePo {

    /**
     * 会员id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test="required",requiredMsg="会员ID不能为空")
    @ApiModelProperty(value = "会员id")
    private Long membId;

    /**
     * 店铺名称
     */
    @Check(test="required",requiredMsg="店铺名称不能为空")
    @ApiModelProperty(value = "店铺名称")
    private String shopName;

    /**
     * 店铺宣传栏
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "店铺宣传栏")
    private String shopXclUrl;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 获取会员id
     */
    public Long getMembId() {
        return membId;
    }

    /**
     * 设置会员id
     */
    public void setMembId(Long membId) {
        this.membId = membId;
    }

    /**
     * 获取店铺名称
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * 设置店铺名称
     */
    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    /**
     * 获取店铺宣传栏
     */
    public String getShopXclUrl() {
        return shopXclUrl;
    }

    /**
     * 设置店铺宣传栏
     */
    public void setShopXclUrl(String shopXclUrl) {
        this.shopXclUrl = shopXclUrl == null ? null : shopXclUrl.trim();
    }

    /**
     * 获取备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}
