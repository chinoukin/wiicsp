package com.wisea.transac.common.po;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.MembInfoPageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

@ApiModel("分页查询Po")
public class MembInfoPageListPo extends PagePo<MembInfoPageListVo> {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="logo_url")
    private String logoUrl;

    @ApiModelProperty(value="注册手机号")
    private String registTel;

    @ApiModelProperty(value="昵称")
    private String petName;

    @ApiModelProperty(value="姓名")
    private String contName;

    @ApiModelProperty(value="登陆用户名")
    private String loginName;

    @ApiModelProperty(value="职位")
    private String position;

    @ApiModelProperty(value="性别类型")
    private String sexType;

    @ApiModelProperty(value="个性签名")
    private String autograph;

    @ApiModelProperty(value="意见反馈")
    private String feedBack;

    @ApiModelProperty(value="绑定微信")
    private String bindWechat;

    @ApiModelProperty(value="介绍信息")
    private String signature;

    @ApiModelProperty(value="会员类型")
    private String membType;

    @ApiModelProperty(value="注册时间")
    private OffsetDateTime registDate;

    @ApiModelProperty(value="账户状态")
    private String acctState;

    @ApiModelProperty(value="是否商家")
    private String agentFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getRegistTel() {
        return registTel;
    }

    public void setRegistTel(String registTel) {
        this.registTel = registTel;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getContName() {
        return contName;
    }

    public void setContName(String contName) {
        this.contName = contName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSexType() {
        return sexType;
    }

    public void setSexType(String sexType) {
        this.sexType = sexType;
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public String getBindWechat() {
        return bindWechat;
    }

    public void setBindWechat(String bindWechat) {
        this.bindWechat = bindWechat;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getMembType() {
        return membType;
    }

    public void setMembType(String membType) {
        this.membType = membType;
    }

    public OffsetDateTime getRegistDate() {
        return registDate;
    }

    public void setRegistDate(OffsetDateTime registDate) {
        this.registDate = registDate;
    }

    public String getAcctState() {
        return acctState;
    }

    public void setAcctState(String acctState) {
        this.acctState = acctState;
    }

    public String getAgentFlag() {
        return agentFlag;
    }

    public void setAgentFlag(String agentFlag) {
        this.agentFlag = agentFlag;
    }
}
