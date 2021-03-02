package com.wisea.cultivar.common.vo.tp.retro;


import com.wisea.cultivar.common.vo.tp.CommAttriListVo;
import com.wisea.cultivar.common.vo.tp.CommPictureListVo;
import com.wisea.cultivar.common.vo.tp.SampPictureListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 商品追溯详情Vo
 */
@ApiModel("商品追溯详情Vo")
public class RetroCommInfoVo {
    @ApiModelProperty("商品ID")
    private Long id;
    @ApiModelProperty("商品名称")
    private String commName;
    @ApiModelProperty("企业名称")
    private String compName;
    @ApiModelProperty("产地省")
    private String commLocalProv;
    @ApiModelProperty("产地市")
    private String commLocalCity;
    @ApiModelProperty("产地县")
    private String commLocalCou;
    @ApiModelProperty("生产批次")
    private String prdctBatch;
    @ApiModelProperty("生产许可")
    private String prdctLicense;
    @ApiModelProperty("商品描述")
    private String commDesc;
    @ApiModelProperty("商品图片列表")
    private List<CommPictureListVo> commPictures;
    @ApiModelProperty("商品属性列表")
    private List<CommAttriListVo> commAttris;
    @ApiModelProperty("检测信息列表")
    private List<SampPictureListVo> detections;
    @ApiModelProperty("评鉴信息列表")
    private List<SampPictureListVo> judges;
    @ApiModelProperty(value = "样品图片列表（检测/评鉴）", hidden = true)
    private List<SampPictureListVo> sampPictures;
    @ApiModelProperty("会员标签点亮列表")
    private List<String> labelLits;
    @ApiModelProperty("企业介绍")
    private String compIntro;
    @ApiModelProperty("企业图片列表")
    private List<String> entpPictures;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CommPictureListVo> getCommPictures() {
        return commPictures;
    }

    public void setCommPictures(List<CommPictureListVo> commPictures) {
        this.commPictures = commPictures;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getCommLocalProv() {
        return commLocalProv;
    }

    public void setCommLocalProv(String commLocalProv) {
        this.commLocalProv = commLocalProv;
    }

    public String getCommLocalCity() {
        return commLocalCity;
    }

    public void setCommLocalCity(String commLocalCity) {
        this.commLocalCity = commLocalCity;
    }

    public String getCommLocalCou() {
        return commLocalCou;
    }

    public void setCommLocalCou(String commLocalCou) {
        this.commLocalCou = commLocalCou;
    }

    public String getPrdctBatch() {
        return prdctBatch;
    }

    public void setPrdctBatch(String prdctBatch) {
        this.prdctBatch = prdctBatch;
    }

    public String getPrdctLicense() {
        return prdctLicense;
    }

    public void setPrdctLicense(String prdctLicense) {
        this.prdctLicense = prdctLicense;
    }

    public List<CommAttriListVo> getCommAttris() {
        return commAttris;
    }

    public void setCommAttris(List<CommAttriListVo> commAttris) {
        this.commAttris = commAttris;
    }

    public String getCommDesc() {
        return commDesc;
    }

    public void setCommDesc(String commDesc) {
        this.commDesc = commDesc;
    }

    public List<SampPictureListVo> getDetections() {
        return detections;
    }

    public void setDetections(List<SampPictureListVo> detections) {
        this.detections = detections;
    }

    public List<SampPictureListVo> getJudges() {
        return judges;
    }

    public void setJudges(List<SampPictureListVo> judges) {
        this.judges = judges;
    }

    public List<SampPictureListVo> getSampPictures() {
        return sampPictures;
    }

    public void setSampPictures(List<SampPictureListVo> sampPictures) {
        this.sampPictures = sampPictures;
    }

    public List<String> getLabelLits() {
        return labelLits;
    }

    public void setLabelLits(List<String> labelLits) {
        this.labelLits = labelLits;
    }

    public String getCompIntro() {
        return compIntro;
    }

    public void setCompIntro(String compIntro) {
        this.compIntro = compIntro;
    }

    public List<String> getEntpPictures() {
        return entpPictures;
    }

    public void setEntpPictures(List<String> entpPictures) {
        this.entpPictures = entpPictures;
    }
}
