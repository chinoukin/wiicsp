package com.wisea.cultivar.common.vo.bigdata;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className BaseVo
 * @date 2019/7/19 11:23
 * @Description 基地信息Vo
 */
@ApiModel("基地信息Vo")
public class BaseVo {
    @ApiModelProperty("基地会员ID")
    private Long id;
    @ApiModelProperty("基地名称")
    private String orgName;
    @ApiModelProperty("区域_省")
    private String areaCodeProv;
    @ApiModelProperty("区域_市")
    private String areaCodeCity;
    @ApiModelProperty("区域_区县")
    private String areaCodeCou;
    @ApiModelProperty("详细地址")
    private String address;
    @ApiModelProperty("基地经度")
    private String jd;
    @ApiModelProperty("基地纬度")
    private String wd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
