package com.wisea.cultivar.plant.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页查询MembAttentionVo")
public class MembAttentionPageListVo {
    @ApiModelProperty(value="收藏id")
    private Long id;
    @ApiModelProperty(value="本人的会员id")
    private Long membId;
    @ApiModelProperty(value="需要跳转的shopid")
    private Long  shopId;
    @ApiModelProperty(value="关注类型 0 油茶圈 1 服务商")
    private String membAttentionType;

    @ApiModelProperty(value="被关注会员id")
    private Long membAttentionId;
    @ApiModelProperty(value="会员姓名")
    private String userName;

    @ApiModelProperty(value="头像")
    private String logoUrl;

    @ApiModelProperty(value="企业名称")
    private String entpName;


    @ApiModelProperty(value="农场或公司名称")
    private String orgName;
    @ApiModelProperty(value="失效标识 0 表示失效 1表示正常")
    private String status;

    @ApiModelProperty(value="省")
    private String areaProv;

    @ApiModelProperty(value="市")
    private String areaCity;

    @ApiModelProperty(value="区县")
    private String areaCou;

    @ApiModelProperty(value="详细地址")
    private String address;

    @ApiModelProperty(value="联系人")
    private String conter;
    @ApiModelProperty(value="联系人手机号")
    private String contTel;


    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAreaProv() {
        return areaProv;
    }

    public void setAreaProv(String areaProv) {
        this.areaProv = areaProv;
    }

    public String getAreaCity() {
        return areaCity;
    }

    public void setAreaCity(String areaCity) {
        this.areaCity = areaCity;
    }

    public String getAreaCou() {
        return areaCou;
    }

    public void setAreaCou(String areaCou) {
        this.areaCou = areaCou;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getConter() {
        return conter;
    }

    public void setConter(String conter) {
        this.conter = conter;
    }

    public String getContTel() {
        return contTel;
    }

    public void setContTel(String contTel) {
        this.contTel = contTel;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getMembAttentionType() {
        return membAttentionType;
    }

    public void setMembAttentionType(String membAttentionType) {
        this.membAttentionType = membAttentionType;
    }

    public Long getMembAttentionId() {
        return membAttentionId;
    }

    public void setMembAttentionId(Long membAttentionId) {
        this.membAttentionId = membAttentionId;
    }
}
