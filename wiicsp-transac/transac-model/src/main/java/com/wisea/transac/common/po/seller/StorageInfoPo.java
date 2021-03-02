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
 * @className StorageInfoPo
 * @date 2020/7/2 14:21
 * @Description 新增或修改基地仓储PO
 */
@ApiModel("新增或修改基地仓储PO")
public class StorageInfoPo {
    @ApiModelProperty("数据ID，修改时非空")
    private Long id;
    @ApiModelProperty("基地id")
    @Check(test = {"required"})
    private Long baseId;
    @ApiModelProperty("仓库名称")
    @Check(test = {"required"})
    private String storageName;
    @ApiModelProperty("仓库面积")
    @Check(test = {"required"})
    private Double storageMj;
    @ApiModelProperty("仓库类型")
    @Check(test = {"required"})
    private String warehType;
    @ApiModelProperty("仓库介绍")
    private String storageContent;
    @ApiModelProperty("物联网设备")
    @Check(test = {}, cascade = true)
    private EquInfoPo equInfo;
    @ApiModelProperty("仓储图片列表")
    @Check(test = { "required" }, cascade = true)
    private List<FilePo> files;
    @ApiModelProperty("仓储实时视频列表")
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
