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
 * @className StorageInfoVo
 * @date 2020/7/2 14:11
 * @Description 仓储详细信息VO
 */
@ApiModel("仓储详细信息VO")
public class StorageInfoVo {
    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("基地id")
    private Long baseId;
    @ApiModelProperty("仓库名称")
    private String storageName;
    @ApiModelProperty("仓库面积")
    private Double storageMj;
    @ApiModelProperty("仓库类型")
    private String warehType;
    @ApiModelProperty("仓库介绍")
    private String storageContent;
    @ApiModelProperty("物联网设备")
    private EquInfoVo equInfo;
    @ApiModelProperty("仓库图片列表")
    private List<FileVo> files;
    @ApiModelProperty("仓库实时视频列表")
    private List<LiveVideoVo> liveVideos;
    @ApiModelProperty("仓库在售货源")
    private List<CommPubInfoInfoVo> commPubInfos;

    public List<CommPubInfoInfoVo> getCommPubInfos() {
        return commPubInfos;
    }

    public void setCommPubInfos(List<CommPubInfoInfoVo> commPubInfos) {
        this.commPubInfos = commPubInfos;
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

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public Double getStorageMj() {
        return storageMj;
    }

    public void setStorageMj(Double storageMj) {
        this.storageMj = storageMj;
    }

    public String getWarehType() {
        return warehType;
    }

    public void setWarehType(String warehType) {
        this.warehType = warehType;
    }

    public String getStorageContent() {
        return storageContent;
    }

    public void setStorageContent(String storageContent) {
        this.storageContent = storageContent;
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
}
