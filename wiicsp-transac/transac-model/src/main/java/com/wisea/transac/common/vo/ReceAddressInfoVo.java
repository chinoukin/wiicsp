package com.wisea.transac.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("ReceAddress详细信息Vo")
public class ReceAddressInfoVo {
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value="会员id")
    private Long membId;

    @ApiModelProperty(value="地址省")
    private String areaProv;

    @ApiModelProperty(value="地址省名字")
    private String areaProvName;

    @ApiModelProperty(value="地址市")
    private String areaCity;

    @ApiModelProperty(value="地址市名字")
    private String areaCityName;

    @ApiModelProperty(value="地址区县")
    private String areaCou;

    @ApiModelProperty(value="地址区县名字")
    private String areaCouName;
    @ApiModelProperty(value="详细地址")
    private String address;

    @ApiModelProperty(value="姓名")
    private String name;

    @ApiModelProperty(value="电话")
    private String tel;

    @ApiModelProperty(value="是否默认")
    private String defaultFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDefaultFlag() {
        return defaultFlag;
    }

    public void setDefaultFlag(String defaultFlag) {
        this.defaultFlag = defaultFlag;
    }

    public String getAreaProvName() {
        return areaProvName;
    }

    public void setAreaProvName(String areaProvName) {
        this.areaProvName = areaProvName;
    }

    public String getAreaCityName() {
        return areaCityName;
    }

    public void setAreaCityName(String areaCityName) {
        this.areaCityName = areaCityName;
    }

    public String getAreaCouName() {
        return areaCouName;
    }

    public void setAreaCouName(String areaCouName) {
        this.areaCouName = areaCouName;
    }
}
