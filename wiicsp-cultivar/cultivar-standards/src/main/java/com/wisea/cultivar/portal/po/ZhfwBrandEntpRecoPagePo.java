package com.wisea.cultivar.portal.po;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.portal.vo.ZhfwBrandEntpRecoListVo;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * ZhfwBrandEntpRecoPagePo
 * 2020/08/24 20:28:13
 */
public class ZhfwBrandEntpRecoPagePo extends PagePo<ZhfwBrandEntpRecoListVo> {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 企业名称
     */
    @ApiModelProperty(value = "企业名称")
    private String entpName;

    /**
     * 宣传视频图片
     */
    @ApiModelProperty(value = "宣传视频图片")
    private String url;

    /**
     * 企业logo
     */
    @ApiModelProperty(value = "企业logo")
    private String logoUrl;

    /**
     * 企业简介
     */
    @ApiModelProperty(value = "企业简介")
    private String entpIntro;

    /**
     * 企业平台店铺地址
     */
    @ApiModelProperty(value = "企业平台店铺地址")
    private String shopUrl;

    /**
     * 显示顺序
     */
    @ApiModelProperty(value = "显示顺序")
    private Integer sort;

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
     * 获取企业名称
     */
    public String getEntpName() {
        return entpName;
    }

    /**
     * 设置企业名称
     */
    public void setEntpName(String entpName) {
        this.entpName = entpName == null ? null : entpName.trim();
    }

    /**
     * 获取宣传视频图片
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置宣传视频图片
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取企业logo
     */
    public String getLogoUrl() {
        return logoUrl;
    }

    /**
     * 设置企业logo
     */
    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl == null ? null : logoUrl.trim();
    }

    /**
     * 获取企业简介
     */
    public String getEntpIntro() {
        return entpIntro;
    }

    /**
     * 设置企业简介
     */
    public void setEntpIntro(String entpIntro) {
        this.entpIntro = entpIntro == null ? null : entpIntro.trim();
    }

    /**
     * 获取企业平台店铺地址
     */
    public String getShopUrl() {
        return shopUrl;
    }

    /**
     * 设置企业平台店铺地址
     */
    public void setShopUrl(String shopUrl) {
        this.shopUrl = shopUrl == null ? null : shopUrl.trim();
    }

    /**
     * 获取显示顺序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置显示顺序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
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
