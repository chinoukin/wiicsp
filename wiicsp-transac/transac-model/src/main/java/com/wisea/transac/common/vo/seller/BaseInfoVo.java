package com.wisea.transac.common.vo.seller;

import com.wisea.transac.common.vo.FileVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className BaseInfoVo
 * @date 2020/6/30 11:04
 * @Description 基地基本信息VO
 */
@ApiModel("基地基本信息VO")
public class BaseInfoVo {
    @ApiModelProperty("基地ID")
    private Long id;
    @ApiModelProperty("会员id（商家）")
    private Long membId;
    @ApiModelProperty("基地名称")
    private String baseName;
    @ApiModelProperty("基地详情")
    private String baseContent;
    @ApiModelProperty("720VR地址")
    private String vrUrl;
    @ApiModelProperty("VR视频地址")
    private String vrVideoUrl;
    @ApiModelProperty("基地类型")
    private String baseType;
    @ApiModelProperty("省")
    private String areaProv;
    @ApiModelProperty("市")
    private String areaCity;
    @ApiModelProperty("区县")
    private String areaCou;
    @ApiModelProperty("省-中文")
    private String areaProvStr;
    @ApiModelProperty("市-中文")
    private String areaCityStr;
    @ApiModelProperty("区县-中文")
    private String areaCouStr;
    @ApiModelProperty("详细地址")
    private String address;
    @ApiModelProperty("经度")
    private String jd;
    @ApiModelProperty("纬度")
    private String wd;
    @ApiModelProperty("国外产地id")
    private Long abroadId;
    @ApiModelProperty("国外产地名称")
    private String abroadName;
    @ApiModelProperty("会员类型")
    private String membType;
    @ApiModelProperty("联系人电话")
    private String contTel;
    @ApiModelProperty("联系人")
    private String conter;
    @ApiModelProperty("基地图片/视频列表")
    private List<FileVo> files;
    @ApiModelProperty("备注-初始化基地名称，如果和baseName不相同说明已经修改过一次，不能再次修改")
    private String remarks;

    @ApiModelProperty("在线看捡，1有")
    private String factoy;
    @ApiModelProperty("在线逛园，1有")
    private String planting;
    @ApiModelProperty("在线监库，1有")
    private String store;
    @ApiModelProperty("优势单品名称")
    private String supPieceName;
    @ApiModelProperty("国外产地名称")
    private String placeOriginName;
    @ApiModelProperty("是否关注，1关注")
    private String follow;

    public String getFollow() {
        return follow;
    }

    public void setFollow(String follow) {
        this.follow = follow;
    }

    public String getPlaceOriginName() {
        return placeOriginName;
    }

    public void setPlaceOriginName(String placeOriginName) {
        this.placeOriginName = placeOriginName;
    }

    public String getSupPieceName() {
        return supPieceName;
    }

    public void setSupPieceName(String supPieceName) {
        this.supPieceName = supPieceName;
    }

    public String getFactoy() {
        return factoy;
    }

    public void setFactoy(String factoy) {
        this.factoy = factoy;
    }

    public String getPlanting() {
        return planting;
    }

    public void setPlanting(String planting) {
        this.planting = planting;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContTel() {
        return contTel;
    }

    public void setContTel(String contTel) {
        this.contTel = contTel;
    }

    public String getConter() {
        return conter;
    }

    public void setConter(String conter) {
        this.conter = conter;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public String getBaseContent() {
        return baseContent;
    }

    public void setBaseContent(String baseContent) {
        this.baseContent = baseContent;
    }

    public String getVrUrl() {
        return vrUrl;
    }

    public void setVrUrl(String vrUrl) {
        this.vrUrl = vrUrl;
    }

    public String getVrVideoUrl() {
        return vrVideoUrl;
    }

    public void setVrVideoUrl(String vrVideoUrl) {
        this.vrVideoUrl = vrVideoUrl;
    }

    public String getBaseType() {
        return baseType;
    }

    public void setBaseType(String baseType) {
        this.baseType = baseType;
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

    public String getAreaProvStr() {
        return areaProvStr;
    }

    public void setAreaProvStr(String areaProvStr) {
        this.areaProvStr = areaProvStr;
    }

    public String getAreaCityStr() {
        return areaCityStr;
    }

    public void setAreaCityStr(String areaCityStr) {
        this.areaCityStr = areaCityStr;
    }

    public String getAreaCouStr() {
        return areaCouStr;
    }

    public void setAreaCouStr(String areaCouStr) {
        this.areaCouStr = areaCouStr;
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

    public Long getAbroadId() {
        return abroadId;
    }

    public void setAbroadId(Long abroadId) {
        this.abroadId = abroadId;
    }

    public String getAbroadName() {
        return abroadName;
    }

    public void setAbroadName(String abroadName) {
        this.abroadName = abroadName;
    }

    public String getMembType() {
        return membType;
    }

    public void setMembType(String membType) {
        this.membType = membType;
    }

    public List<FileVo> getFiles() {
        return files;
    }

    public void setFiles(List<FileVo> files) {
        this.files = files;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
