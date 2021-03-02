package com.wisea.cultivar.common.po.tp.portal;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 广告管理新增修改PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年6月1日
 * @version 1.0
 */
@ApiModel("广告管理新增修改PO")
public class AdverMageUpdatePo {

	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id(新增不填写、修改的情况为必填项目)")
    private Long id;

    @JsonSerialize(using = IdSerializer.class)
    @Check(test = {"required","maxLength"}, length = 19)
    @ApiModelProperty(value = "广告位id")
    private Long adverSpaceId;

    @Check(test = {"required","maxLength"}, mixLength = 200)
    @ApiModelProperty(value = "广告名称")
    private String adverName;

    @Check(test = {"required","maxLength"}, mixLength = 255)
    @ApiModelProperty(value = "广告图片")
    private String adverImage;

    @Check(test = {"required","maxLength"}, mixLength = 5)
    @ApiModelProperty(value = "链接类型(0:无操作1:链接地址2:具体商品)")
    private String linkType;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商品id")
    private Long commId;

    @ApiModelProperty(value = "商品名称")
    private String commName;

    @ApiModelProperty(value = "链接地址")
    private String linkAddress;

    @ApiModelProperty(value = "打开方式")
    private String openMode;

    @Check(test = {"required","maxLength"}, length = 10)
    @ApiModelProperty(value = "排序")
    private Integer sort;

    @Check(test = {"required","maxLength"}, mixLength = 5)
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
