package com.wisea.cultivar.plant.vo;

import com.wisea.cultivar.plant.entity.EntpAuth;
import com.wisea.cultivar.plant.entity.RealPersonAuth;
import com.wisea.cultivar.common.entity.ZhfwExamRecd;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.List;

@ApiModel("ZhfwMembInfo详细信息Vo")
public class ZhfwMembInfoInfoVo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="pid")
    private Long pid;

    @ApiModelProperty(value="用户名")
    private String loginName;

    @ApiModelProperty(value="姓名")
    private String contName;

    @ApiModelProperty(value="头像")
    private String logoUrl;

    @ApiModelProperty(value="企业名称")
    private String entpName;

    @ApiModelProperty(value="注册手机号")
    private String registTel;

    @ApiModelProperty(value="注册时间")
    private OffsetDateTime registerDate;

    @ApiModelProperty(value="认证状态")
    private String entpAuthStateType;

    @ApiModelProperty(value="职位")
    private String position;

    @ApiModelProperty(value="账户状态")
    private String acctState;

    @ApiModelProperty(value="性别类型")
    private String sexType;

    @ApiModelProperty(value="会员类型")
    private String membType;

    @ApiModelProperty(value="个性签名")
    private String signature;

    @ApiModelProperty(value="农场或公司名称")
    private String orgName;

    @ApiModelProperty(value="区域_省")
    private String areaCodeProv;

    @ApiModelProperty(value="区域_省名称")
    private String areaCodeProvName;

    @ApiModelProperty(value="区域_市")
    private String areaCodeCity;

    @ApiModelProperty(value="区域_市名称")
    private String areaCodeCityName;

    @ApiModelProperty(value="区域_区县")
    private String areaCodeCou;

    @ApiModelProperty(value="区域_区县名称")
    private String areaCodeCouName;

    @ApiModelProperty(value="详细地址")
    private String address;

    @ApiModelProperty(value="联系人手机号")
    private String contTel;

    @ApiModelProperty(value="主体类型（企业，合作社，散户，经纪人）")
    private String subjectType;

    @ApiModelProperty(value="账号状态")
    private String acctStatus;

    @ApiModelProperty(value="账户类型")
    private String acctType;

    @ApiModelProperty(value="经度")
    private String jd;

    @ApiModelProperty(value="纬度")
    private String wd;

    @ApiModelProperty(value="认证类型")
    private String authType;

    @ApiModelProperty(value="圈子背景图")
    private String momentsBjtUrl;

    @ApiModelProperty(value="企业认证信息")
    private EntpAuth entpAuth;

    @ApiModelProperty(value="实人认证信息")
    private RealPersonAuth realPersonAuth;

    @ApiModelProperty(value="审核记录")
    private List<ZhfwExamRecd> zhfwExamRecdList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getContName() {
        return contName;
    }

    public void setContName(String contName) {
        this.contName = contName;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getEntpName() {
        return entpName;
    }

    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }

    public String getRegistTel() {
        return registTel;
    }

    public void setRegistTel(String registTel) {
        this.registTel = registTel;
    }

    public OffsetDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(OffsetDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public String getEntpAuthStateType() {
        return entpAuthStateType;
    }

    public void setEntpAuthStateType(String entpAuthStateType) {
        this.entpAuthStateType = entpAuthStateType;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAcctState() {
        return acctState;
    }

    public void setAcctState(String acctState) {
        this.acctState = acctState;
    }

    public String getSexType() {
        return sexType;
    }

    public void setSexType(String sexType) {
        this.sexType = sexType;
    }

    public String getMembType() {
        return membType;
    }

    public void setMembType(String membType) {
        this.membType = membType;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getAreaCodeProv() {
        return areaCodeProv;
    }

    public void setAreaCodeProv(String areaCodeProv) {
        this.areaCodeProv = areaCodeProv;
    }

    public String getAreaCodeCity() {
        return areaCodeCity;
    }

    public void setAreaCodeCity(String areaCodeCity) {
        this.areaCodeCity = areaCodeCity;
    }

    public String getAreaCodeCou() {
        return areaCodeCou;
    }

    public void setAreaCodeCou(String areaCodeCou) {
        this.areaCodeCou = areaCodeCou;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContTel() {
        return contTel;
    }

    public void setContTel(String contTel) {
        this.contTel = contTel;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    public String getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(String acctStatus) {
        this.acctStatus = acctStatus;
    }

    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }

    public String getJd() {
        return jd;
    }

    public void setJd(String jd) {
        this.jd = jd;
    }

    public String getWd() {
        return wd;
    }

    public void setWd(String wd) {
        this.wd = wd;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public String getMomentsBjtUrl() {
        return momentsBjtUrl;
    }

    public void setMomentsBjtUrl(String momentsBjtUrl) {
        this.momentsBjtUrl = momentsBjtUrl;
    }

    public EntpAuth getEntpAuth() {
        return entpAuth;
    }

    public void setEntpAuth(EntpAuth entpAuth) {
        this.entpAuth = entpAuth;
    }

    public RealPersonAuth getRealPersonAuth() {
        return realPersonAuth;
    }

    public void setRealPersonAuth(RealPersonAuth realPersonAuth) {
        this.realPersonAuth = realPersonAuth;
    }

    public String getAreaCodeProvName() {
        return areaCodeProvName;
    }

    public void setAreaCodeProvName(String areaCodeProvName) {
        this.areaCodeProvName = areaCodeProvName;
    }

    public String getAreaCodeCityName() {
        return areaCodeCityName;
    }

    public void setAreaCodeCityName(String areaCodeCityName) {
        this.areaCodeCityName = areaCodeCityName;
    }

    public String getAreaCodeCouName() {
        return areaCodeCouName;
    }

    public void setAreaCodeCouName(String areaCodeCouName) {
        this.areaCodeCouName = areaCodeCouName;
    }

    public List<ZhfwExamRecd> getZhfwExamRecdList() {
        return zhfwExamRecdList;
    }

    public void setZhfwExamRecdList(List<ZhfwExamRecd> zhfwExamRecdList) {
        this.zhfwExamRecdList = zhfwExamRecdList;
    }
}
