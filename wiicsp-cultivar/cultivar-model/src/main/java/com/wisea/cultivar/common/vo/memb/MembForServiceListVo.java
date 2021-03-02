package com.wisea.cultivar.common.vo.memb;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * 运营平台/市场运营 会员列表VO
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月20日
 * @version 1.0
 */
@ApiModel("运营平台/市场运营 会员列表VO")
public class MembForServiceListVo {

    @ApiModelProperty(value = "服务商id")
    private Long membId;

    @ApiModelProperty(value = "用户名")
    private String loginName;

    @ApiModelProperty(value = "注册手机号")
    private String registTel;

    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "注册时间")
    private OffsetDateTime registDate;

    @ApiModelProperty(value = "企业名称")
    private String entpName;


    @ApiModelProperty(value = "会员类型(memb_type 0:服务商1:会员)")
    private String membType;

    @ApiModelProperty(value = "认证类型(memb_type 0:企业1:个人)")
    private String authType;

    @ApiModelProperty(value = "审核状态(auth_state_type 0:待平台审核1:待银盛开户2:实名认证中3:审核通过4:审核未通过)")
    private String authStateType;

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getRegistTel() {
        return registTel;
    }

    public void setRegistTel(String registTel) {
        this.registTel = registTel;
    }

    public OffsetDateTime getRegistDate() {
        return registDate;
    }

    public void setRegistDate(OffsetDateTime registDate) {
        this.registDate = registDate;
    }

    public String getEntpName() {
        return entpName;
    }

    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }

    public String getMembType() {
        return membType;
    }

    public void setMembType(String membType) {
        this.membType = membType;
    }

    public String getAuthStateType() {
        return authStateType;
    }

    public void setAuthStateType(String authStateType) {
        this.authStateType = authStateType;
    }
}
