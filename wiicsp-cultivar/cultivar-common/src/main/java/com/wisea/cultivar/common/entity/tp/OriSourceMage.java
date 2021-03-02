package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author jirg
 * @Date 2019/3/22 15:42
 * @Description 牛源牧场管理
 **/
public class OriSourceMage extends DataLongEntity<OriSourceMage> {
    @ApiModelProperty(value = "会员id", hidden = true)
    private Long membId;
    @ApiModelProperty("牧场名称")
    @Check(test = "required")
    private String yakSourceName;
    @ApiModelProperty("logo")
    private String logoUrl;
    @ApiModelProperty("联系人姓名")
    @Check(test = "required")
    private String contactName;
    @ApiModelProperty("电话")
    @Check(test = "required")
    private String tel;
    @ApiModelProperty("联系地区省")
    @Check(test = "required")
    private String areaProv;
    @ApiModelProperty("联系地区市")
    @Check(test = "required")
    private String areaCity;
    @ApiModelProperty("联系地区区县")
    @Check(test = "required")
    private String areaCou;
    @ApiModelProperty("详细地址")
    @Check(test = "required")
    private String address;
    @ApiModelProperty("简介")
    private String content;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getYakSourceName() {
        return yakSourceName;
    }

    public void setYakSourceName(String yakSourceName) {
        this.yakSourceName = yakSourceName;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
