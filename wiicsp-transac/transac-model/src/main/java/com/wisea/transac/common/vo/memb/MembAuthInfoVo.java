package com.wisea.transac.common.vo.memb;

import com.wisea.cloud.model.po.LongIdPo;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className MembAuthInfoVo
 * @date 2020/5/14 14:17
 * @Description 会员认证信息
 */
public class MembAuthInfoVo extends LongIdPo {
    @ApiModelProperty("注册手机号")
    private String registTel;
    @ApiModelProperty("头像url")
    private String logoUrl;
    @ApiModelProperty("用户名")
    private String loginName;
    @ApiModelProperty(value="审核状态区分(0:无认证1:个人认证2:个体户认证3:企业认证)优先级顺序：企业>个体>个人")
    private String authType;
    @ApiModelProperty(value="审核名称(如果个人认证显示姓名,个体和企业显示企业名称)优先级顺序：企业>个体>个人")
    private String authName;

    public String getRegistTel() {
        return registTel;
    }

    public void setRegistTel(String registTel) {
        this.registTel = registTel;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }
}
