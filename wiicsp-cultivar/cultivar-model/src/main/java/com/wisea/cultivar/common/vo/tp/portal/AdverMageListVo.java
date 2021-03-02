package com.wisea.cultivar.common.vo.tp.portal;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 广告列表信息VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年6月1日
 * @version 1.0
 */
@ApiModel("广告列表信息VO")
public class AdverMageListVo implements Serializable{

	private static final long serialVersionUID = -5179850948601654053L;

	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "广告位id")
    private Long adverSpaceId;

    @ApiModelProperty(value = "广告位置名称")
    private String adverSpaceName;

    @ApiModelProperty(value = "广告名称")
    private String adverName;

    @ApiModelProperty(value = "广告图片")
    private String adverImage;

    @ApiModelProperty(value = "链接类型（0:无操作1:链接地址2：具体商品）")
    private String linkType;

    @ApiModelProperty(value = "链接地址")
    private String linkAddress;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商品id")
    private Long commId;

    @ApiModelProperty(value = "商品名称")
    private String commName;

    @ApiModelProperty(value = "打开方式(0:当前窗口1:新窗口/新标签)")
    private String openMode;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "状态（启用、停用）")
    private String enableFlag;

    @ApiModelProperty(value = "备注")
    private String remarks;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAdverSpaceId() {
		return adverSpaceId;
	}

	public void setAdverSpaceId(Long adverSpaceId) {
		this.adverSpaceId = adverSpaceId;
	}

	public String getAdverName() {
		return adverName;
	}

	public void setAdverName(String adverName) {
		this.adverName = adverName;
	}

	public String getAdverImage() {
		return adverImage;
	}

	public void setAdverImage(String adverImage) {
		this.adverImage = adverImage;
	}

	public String getLinkType() {
		return linkType;
	}

	public void setLinkType(String linkType) {
		this.linkType = linkType;
	}

	public Long getCommId() {
		return commId;
	}

	public void setCommId(Long commId) {
		this.commId = commId;
	}

	public String getCommName() {
		return commName;
	}

	public void setCommName(String commName) {
		this.commName = commName;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getEnableFlag() {
		return enableFlag;
	}

	public void setEnableFlag(String enableFlag) {
		this.enableFlag = enableFlag;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getAdverSpaceName() {
		return adverSpaceName;
	}

	public void setAdverSpaceName(String adverSpaceName) {
		this.adverSpaceName = adverSpaceName;
	}

	public String getLinkAddress() {
		return linkAddress;
	}

	public void setLinkAddress(String linkAddress) {
		this.linkAddress = linkAddress;
	}

	public String getOpenMode() {
		return openMode;
	}

	public void setOpenMode(String openMode) {
		this.openMode = openMode;
	}

}
