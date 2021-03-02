package com.wisea.transac.common.vo.seller;

import com.wisea.transac.common.vo.FileVo;
import com.wisea.transac.common.vo.LiveVideoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className SortingFactoryVo
 * @date 2020/7/2 9:43
 * @Description 分选工厂详细信息VO
 */
@ApiModel("分选工厂详细信息VO")
public class SortingFactoryVo {
    private Long id;
    @ApiModelProperty("基地id")
    private Long baseId;
    @ApiModelProperty("分选工厂名称")
    private String sortingFactoryName;
    @ApiModelProperty("工厂面积")
    private Double sortingFactoryMj;
    @ApiModelProperty("详细地址")
    private String address;
    @ApiModelProperty("联系人")
    private String conter;
    @ApiModelProperty("联系人手机号")
    private String contTel;
    @ApiModelProperty("分选工厂介绍")
    private String sortingFactoryContent;
    @ApiModelProperty("经度")
    private String jd;
    @ApiModelProperty("纬度")
    private String wd;
    @ApiModelProperty("定位名称")
    private String oriName;
    @ApiModelProperty("分选工厂图片列表")
    private List<FileVo> files;
    @ApiModelProperty("分选工厂实时视频列表")
    private List<LiveVideoVo> liveVideos;
    @ApiModelProperty("工厂图片")
    private String imgUrl;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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

    public String getSortingFactoryName() {
        return sortingFactoryName;
    }

    public void setSortingFactoryName(String sortingFactoryName) {
        this.sortingFactoryName = sortingFactoryName;
    }

    public Double getSortingFactoryMj() {
        return sortingFactoryMj;
    }

    public void setSortingFactoryMj(Double sortingFactoryMj) {
        this.sortingFactoryMj = sortingFactoryMj;
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

    public String getSortingFactoryContent() {
        return sortingFactoryContent;
    }

    public void setSortingFactoryContent(String sortingFactoryContent) {
        this.sortingFactoryContent = sortingFactoryContent;
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
}
