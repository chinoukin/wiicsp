package com.wisea.cultivar.portal.po;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.portal.vo.ZhfwAdverMageListVo;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * ZhfwAdverMagePagePo
 * 2020/08/24 20:28:13
 */
public class ZhfwAdverMagePagePo extends PagePo<ZhfwAdverMageListVo> {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 广告位id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "广告位id")
    private Long adverSpaceId;

    /**
     * 广告名称
     */
    @ApiModelProperty(value = "广告名称")
    private String adverName;

    /**
     * 广告图片
     */
    @ApiModelProperty(value = "广告图片")
    private String adverImage;

    /**
     * 链接类型
     */
    @ApiModelProperty(value = "链接类型")
    private String linkType;

    /**
     * 链接地址
     */
    @ApiModelProperty(value = "链接地址")
    private String linkAddress;

    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称")
    private String commName;

    /**
     * 打开方式
     */
    @ApiModelProperty(value = "打开方式")
    private String openMode;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sort;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private String enableFlag;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    @ApiModelProperty(value = "结束时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime endTime;

    @ApiModelProperty(value = "创建时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime startTime;

    public OffsetDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(OffsetDateTime endTime) {
        this.endTime = endTime;
    }

    public OffsetDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(OffsetDateTime startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取广告位id
     */
    public Long getAdverSpaceId() {
        return adverSpaceId;
    }

    /**
     * 设置广告位id
     */
    public void setAdverSpaceId(Long adverSpaceId) {
        this.adverSpaceId = adverSpaceId;
    }

    /**
     * 获取广告名称
     */
    public String getAdverName() {
        return adverName;
    }

    /**
     * 设置广告名称
     */
    public void setAdverName(String adverName) {
        this.adverName = adverName == null ? null : adverName.trim();
    }

    /**
     * 获取广告图片
     */
    public String getAdverImage() {
        return adverImage;
    }

    /**
     * 设置广告图片
     */
    public void setAdverImage(String adverImage) {
        this.adverImage = adverImage == null ? null : adverImage.trim();
    }

    /**
     * 获取链接类型
     */
    public String getLinkType() {
        return linkType;
    }

    /**
     * 设置链接类型
     */
    public void setLinkType(String linkType) {
        this.linkType = linkType == null ? null : linkType.trim();
    }

    /**
     * 获取链接地址
     */
    public String getLinkAddress() {
        return linkAddress;
    }

    /**
     * 设置链接地址
     */
    public void setLinkAddress(String linkAddress) {
        this.linkAddress = linkAddress == null ? null : linkAddress.trim();
    }

    /**
     * 获取商品名称
     */
    public String getCommName() {
        return commName;
    }

    /**
     * 设置商品名称
     */
    public void setCommName(String commName) {
        this.commName = commName == null ? null : commName.trim();
    }

    /**
     * 获取打开方式
     */
    public String getOpenMode() {
        return openMode;
    }

    /**
     * 设置打开方式
     */
    public void setOpenMode(String openMode) {
        this.openMode = openMode == null ? null : openMode.trim();
    }

    /**
     * 获取排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取状态
     */
    public String getEnableFlag() {
        return enableFlag;
    }

    /**
     * 设置状态
     */
    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag == null ? null : enableFlag.trim();
    }

    /**
     * 获取备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 获取删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}
