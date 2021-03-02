package com.wisea.transac.common.vo.seller;

import com.wisea.transac.common.vo.CommPubInfoInfoVo;
import com.wisea.transac.common.vo.FileVo;
import com.wisea.transac.common.vo.LiveVideoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className PlantationInfoVo
 * @date 2020/7/2 17:03
 * @Description 种植园详细信息VO
 */
@ApiModel("种植园详细信息VO")
public class PlantationInfoVo {
    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("基地id")
    private Long baseId;
    @ApiModelProperty("种植园名称")
    private String plantationName;
    @ApiModelProperty("种植产品")
    private String plantationPrduct;
    @ApiModelProperty("种植面积")
    private Double plantationMj;
    @ApiModelProperty("详细地址")
    private String address;
    @ApiModelProperty("联系人")
    private String conter;
    @ApiModelProperty("联系人手机号")
    private String contTel;
    @ApiModelProperty("种植园介绍")
    private String plantationContent;
    @ApiModelProperty("720VR地址")
    private String vrUrl;
    @ApiModelProperty("经度")
    private String jd;
    @ApiModelProperty("纬度")
    private String wd;
    @ApiModelProperty("定位名称")
    private String oriName;
    @ApiModelProperty("物联网设备")
    private EquInfoVo equInfo;
    @ApiModelProperty("种植园图片列表")
    private List<FileVo> files;
    @ApiModelProperty("种植园实时视频列表")
    private List<LiveVideoVo> liveVideos;
    @ApiModelProperty("种植园在售货源")
    private List<CommPubInfoInfoVo> commPubInfos;
    @ApiModelProperty("在售货源数")
    private Integer saleCount;
    @ApiModelProperty("图片url")
    private String imgUrl;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBaseId() {
        return baseId;
    }

    public void setBaseId(Long baseId) {
        this.baseId = baseId;
    }

    public String getPlantationName() {
        return plantationName;
    }

    public void setPlantationName(String plantationName) {
        this.plantationName = plantationName;
    }

    public String getPlantationPrduct() {
        return plantationPrduct;
    }

    public void setPlantationPrduct(String plantationPrduct) {
        this.plantationPrduct = plantationPrduct;
    }

    public Double getPlantationMj() {
        return plantationMj;
    }

    public void setPlantationMj(Double plantationMj) {
        this.plantationMj = plantationMj;
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

    public String getPlantationContent() {
        return plantationContent;
    }

    public void setPlantationContent(String plantationContent) {
        this.plantationContent = plantationContent;
    }

    public String getVrUrl() {
        return vrUrl;
    }

    public void setVrUrl(String vrUrl) {
        this.vrUrl = vrUrl;
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

    public String getOriName() {
        return oriName;
    }

    public void setOriName(String oriName) {
        this.oriName = oriName;
    }

    public EquInfoVo getEquInfo() {
        return equInfo;
    }

    public void setEquInfo(EquInfoVo equInfo) {
        this.equInfo = equInfo;
    }

    public List<FileVo> getFiles() {
        return files;
    }

    public void setFiles(List<FileVo> files) {
        this.files = files;
    }

    public List<LiveVideoVo> getLiveVideos() {
        return liveVideos;
    }

    public void setLiveVideos(List<LiveVideoVo> liveVideos) {
        this.liveVideos = liveVideos;
    }

    public void setCommPubInfos(List<CommPubInfoInfoVo> commPubInfos) {
        this.commPubInfos = commPubInfos;
    }

    public List<CommPubInfoInfoVo> getCommPubInfos() {
        return commPubInfos;
    }
}
