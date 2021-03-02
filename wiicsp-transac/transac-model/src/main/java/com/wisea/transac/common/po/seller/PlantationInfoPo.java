package com.wisea.transac.common.po.seller;

import com.wisea.cloud.model.annotation.Check;
import com.wisea.transac.common.po.FilePo;
import com.wisea.transac.common.po.LiveVideoPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className PlantationInfoPo
 * @date 2020/7/2 17:26
 * @Description 新增或修种植园PO
 */
@ApiModel("新增或修种植园PO")
public class PlantationInfoPo {
    @ApiModelProperty("id，修改时非空")
    private Long id;
    @ApiModelProperty("基地id")
    @Check(test = {"required"})
    private Long baseId;
    @ApiModelProperty("种植园名称")
    @Check(test = {"required"})
    private String plantationName;
    @ApiModelProperty("种植产品")
    @Check(test = {"required"})
    private String plantationPrduct;
    @ApiModelProperty("种植面积")
    @Check(test = {"required"})
    private Double plantationMj;
    @ApiModelProperty("详细地址")
    @Check(test = {"required"})
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
    @Check(test = {"required"})
    private String jd;
    @ApiModelProperty("纬度")
    @Check(test = {"required"})
    private String wd;
    @ApiModelProperty("定位名称")
    @Check(test = {"required"})
    private String oriName;
    @ApiModelProperty("物联网设备")
    @Check(test = {}, cascade = true)
    private EquInfoPo equInfo;
    @ApiModelProperty("种植园图片列表")
    @Check(test = { "required" }, cascade = true)
    private List<FilePo> files;
    @ApiModelProperty("种植园实时视频列表")
    @Check(test = {}, cascade = true)
    private List<LiveVideoPo> liveVideos;

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

    public EquInfoPo getEquInfo() {
        return equInfo;
    }

    public void setEquInfo(EquInfoPo equInfo) {
        this.equInfo = equInfo;
    }

    public List<FilePo> getFiles() {
        return files;
    }

    public void setFiles(List<FilePo> files) {
        this.files = files;
    }

    public List<LiveVideoPo> getLiveVideos() {
        return liveVideos;
    }

    public void setLiveVideos(List<LiveVideoPo> liveVideos) {
        this.liveVideos = liveVideos;
    }
}
