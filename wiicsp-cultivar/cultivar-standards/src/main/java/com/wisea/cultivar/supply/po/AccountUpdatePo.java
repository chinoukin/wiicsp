package com.wisea.cultivar.supply.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * 账户信息修改
 * @author chengq
 * @date 2020/8/20 18:08
 */
public class AccountUpdatePo {

    /**
     * 头像url
     */
    @ApiModelProperty("头像url")
    @Check(test = "required", requiredMsg = "头像url不能为空")
    private String logoUrl;

    /**
     * 姓名
     */
    @ApiModelProperty("姓名")
    @Check(test = "required", requiredMsg = "姓名不能为空")
    private String contName;

    /**
     * 性别类型 0-男 1-女
     */
    @ApiModelProperty("性别类型 0-男 1-女")
    @Check(test = "required", requiredMsg = "性别类型不能为空")
    private String sexType;

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getContName() {
        return contName;
    }

    public void setContName(String contName) {
        this.contName = contName;
    }

    public String getSexType() {
        return sexType;
    }

    public void setSexType(String sexType) {
        this.sexType = sexType;
    }
}
