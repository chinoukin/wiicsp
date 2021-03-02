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
 * @className SortingFactoryPo
 * @date 2020/7/2 10:07
 * @Description 新增或修改分选工厂PO
 */
@ApiModel("新增或修改分选工厂PO")
public class SortingFactoryPo {
    @ApiModelProperty("数据ID，修改时非空")
    private Long id;
    @ApiModelProperty("基地id")
    @Check(test = {"required"})
    private Long baseId;
    @ApiModelProperty("分选工厂名称")
    @Check(test = {"required"})
    private String sortingFactoryName;
    @ApiModelProperty("工厂面积")
    @Check(test = {"required"})
    private Double sortingFactoryMj;
    @ApiModelProperty("详细地址")
    @Check(test = {"required"})
    private String address;
    @ApiModelProperty("联系人")
    private String conter;
    @ApiModelProperty("联系人手机号")
    private String contTel;
    @ApiModelProperty("分选工厂介绍")
    private String sortingFactoryContent;
    @ApiModelProperty("经度")
    @Check(test = {"required"})
    private String jd;
    @ApiModelProperty("纬度")
    @Check(test = {"required"})
    private String wd;
    @ApiModelProperty("定位名称")
    @Check(test = {"required"})
    private String oriName;
    @ApiModelProperty("分选工厂图片列表")
    @Check(test = { "required" }, cascade = true)
    private List<FilePo> files;
    @ApiModelProperty("分选工厂实时视频列表")
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
