package com.wisea.transac.common.vo.seller;

import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;


@ApiModel("基地详情查询VO")
public class FindBaseInfoVo {
    @ApiModelProperty("基地ID")
    private Long id;
    @ApiModelProperty("基地详情")
    private String baseContent;
    @ApiModelProperty("经度")
    private String jd;
    @ApiModelProperty("纬度")
    private String wd;
    @ApiModelProperty("省")
    private String areaProv;
    @ApiModelProperty("市")
    private String areaCity;
    @ApiModelProperty("区县")
    private String areaCou;
    @ApiModelProperty("详细地址")
    private String address;
    @ApiModelProperty("证书信息")
    List<BaseCertMageVo> baseCertMageVo = Lists.newArrayList();
    @ApiModelProperty("推荐基地")
    List<RecBaseInfoVo> recBaseList = Lists.newArrayList();
    @ApiModelProperty("采购动态")
    List<ProcurDynamicVo> procurDynamicVo = Lists.newArrayList();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBaseContent() {
        return baseContent;
    }

    public void setBaseContent(String baseContent) {
        this.baseContent = baseContent;
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

    public List<BaseCertMageVo> getBaseCertMageVo() {
        return baseCertMageVo;
    }

    public void setBaseCertMageVo(List<BaseCertMageVo> baseCertMageVo) {
        this.baseCertMageVo = baseCertMageVo;
    }

    public List<RecBaseInfoVo> getRecBaseList() {
        return recBaseList;
    }

    public void setRecBaseList(List<RecBaseInfoVo> recBaseList) {
        this.recBaseList = recBaseList;
    }

    public List<ProcurDynamicVo> getProcurDynamicVo() {
        return procurDynamicVo;
    }

    public void setProcurDynamicVo(List<ProcurDynamicVo> procurDynamicVo) {
        this.procurDynamicVo = procurDynamicVo;
    }
}
