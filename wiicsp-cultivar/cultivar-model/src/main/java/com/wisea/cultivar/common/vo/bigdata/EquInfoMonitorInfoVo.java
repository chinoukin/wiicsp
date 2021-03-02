package com.wisea.cultivar.common.vo.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className EquInfoMonitorInfoVo
 * @date 2019/2/25 18:20
 * @Description 设备监控详细信息
 */
@ApiModel("设备监控详细信息Vo")
public class EquInfoMonitorInfoVo {
    @ApiModelProperty("设备ID")
    private Long id;
    @ApiModelProperty("当前日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime nowDate;
    @ApiModelProperty("最新设备数据点")
    private MonitrLive latestDate;
    @ApiModelProperty("设备数据点列表")
    private List<MonitrLive> monitrLives;
    @ApiModelProperty("生长相册列表")
    private List<GrowAlbum> growAlbums;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OffsetDateTime getNowDate() {
        return nowDate;
    }

    public void setNowDate(OffsetDateTime nowDate) {
        this.nowDate = nowDate;
    }

    public MonitrLive getLatestDate() {
        return latestDate;
    }

    public void setLatestDate(MonitrLive latestDate) {
        this.latestDate = latestDate;
    }

    public List<MonitrLive> getMonitrLives() {
        return monitrLives;
    }

    public void setMonitrLives(List<MonitrLive> monitrLives) {
        this.monitrLives = monitrLives;
    }

    public List<GrowAlbum> getGrowAlbums() {
        return growAlbums;
    }

    public void setGrowAlbums(List<GrowAlbum> growAlbums) {
        this.growAlbums = growAlbums;
    }
}

