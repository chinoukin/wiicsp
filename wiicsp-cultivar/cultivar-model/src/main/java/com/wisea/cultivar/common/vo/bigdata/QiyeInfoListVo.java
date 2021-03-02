package com.wisea.cultivar.common.vo.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 企业信息列表Vo
 * @author yangtao
 *
 */
@ApiModel("企业信息列表Vo")
public class QiyeInfoListVo {

    @ApiModelProperty("企业名称 ")
    private String orgName;
    @ApiModelProperty("区域_省")
    private String addressProvName;
    @ApiModelProperty("区域_市")
    private String addressCityName;
    @ApiModelProperty("区域_区县")
    private String addressCouName;
    @ApiModelProperty("地块数量")
    private Integer dkSl;
    @ApiModelProperty("环境监测设备数量")
    private Integer hjjcsbSl;
    @ApiModelProperty("视频摄像头数量")
    private Integer spsxtSl;
    @ApiModelProperty("档案数量")
    private Integer daSl;
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "会员ID")
    private Long membId;
    @ApiModelProperty(value = "精度")
    private Double jd;
    @ApiModelProperty(value = "维度")
    private Double wd;

    public Long getMembId() {
        return membId;
    }
    public void setMembId(Long membId) {
        this.membId = membId;
    }
    public Double getJd() {
        return jd;
    }
    public void setJd(Double jd) {
        this.jd = jd;
    }
    public Double getWd() {
        return wd;
    }
    public void setWd(Double wd) {
        this.wd = wd;
    }
    public String getOrgName() {
        return orgName;
    }
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
    public String getAddressProvName() {
        return addressProvName;
    }
    public void setAddressProvName(String addressProvName) {
        this.addressProvName = addressProvName;
    }
    public String getAddressCityName() {
        return addressCityName;
    }
    public void setAddressCityName(String addressCityName) {
        this.addressCityName = addressCityName;
    }
    public String getAddressCouName() {
        return addressCouName;
    }
    public void setAddressCouName(String addressCouName) {
        this.addressCouName = addressCouName;
    }
    public Integer getDkSl() {
        return dkSl;
    }
    public void setDkSl(Integer dkSl) {
        this.dkSl = dkSl;
    }
    public Integer getHjjcsbSl() {
        return hjjcsbSl;
    }
    public void setHjjcsbSl(Integer hjjcsbSl) {
        this.hjjcsbSl = hjjcsbSl;
    }
    public Integer getSpsxtSl() {
        return spsxtSl;
    }
    public void setSpsxtSl(Integer spsxtSl) {
        this.spsxtSl = spsxtSl;
    }
    public Integer getDaSl() {
        return daSl;
    }
    public void setDaSl(Integer daSl) {
        this.daSl = daSl;
    }
}
