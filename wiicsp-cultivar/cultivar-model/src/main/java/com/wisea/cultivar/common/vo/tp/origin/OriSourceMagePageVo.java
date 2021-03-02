package com.wisea.cultivar.common.vo.tp.origin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className OriYakSourceMagePageVo
 * @date 2019/3/26 10:07
 * @Description 分页查询牛源牧场列表
 */
@ApiModel("分页查询牛源牧场列表")
public class OriSourceMagePageVo {
    @ApiModelProperty("牛源牧场ID")
    private Long id;
    @ApiModelProperty("牧场名称")
    private String yakSourceName;
    @ApiModelProperty("logo")
    private String logoUrl;
    @ApiModelProperty("联系人姓名")
    private String contactName;
    @ApiModelProperty("电话")
    private String tel;
    @ApiModelProperty("联系地区省")
    private String areaProv;
    @ApiModelProperty("联系地区市")
    private String areaCity;
    @ApiModelProperty("联系地区区县")
    private String areaCou;
    @ApiModelProperty("详细地址")
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
