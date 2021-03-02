package com.wisea.cultivar.common.po.tp.portal;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cultivar.common.vo.tp.portal.JszlListMageListVo;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 技术资料列表管理列表查詢PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年8月30日
 * @version 1.0
 */
@ApiModel("技术资料列表管理列表查詢PO")
public class JszlListMagePageListPo extends PagePo<JszlListMageListVo>{

	private static final long serialVersionUID = 1063838764986638232L;

	@ApiModelProperty(value = "标题或信息来源")
	private String searchKey;

    @ApiModelProperty(value = "所属分类")
    private Long jszlCatgId;

    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "发布时间-开始时间")
    private OffsetDateTime pubDateStart;

    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "发布时间-结束时间")
    private OffsetDateTime pubDateEnd;

    @ApiModelProperty(value="为空查询所有的信息，不为空查询推荐以外的信息",hidden=true)
    public String notAlreadyTj;

    @ApiModelProperty(value = "是否显示(if_requ 0:是1:否)",hidden=true)
    private String ifRequ;

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public Long getJszlCatgId() {
		return jszlCatgId;
	}

	public void setJszlCatgId(Long jszlCatgId) {
		this.jszlCatgId = jszlCatgId;
	}

	public OffsetDateTime getPubDateStart() {
		return pubDateStart;
	}

	public void setPubDateStart(OffsetDateTime pubDateStart) {
		this.pubDateStart = pubDateStart;
	}

	public OffsetDateTime getPubDateEnd() {
		return pubDateEnd;
	}

	public void setPubDateEnd(OffsetDateTime pubDateEnd) {
		this.pubDateEnd = pubDateEnd;
	}

	public String getNotAlreadyTj() {
		return notAlreadyTj;
	}

	public void setNotAlreadyTj(String notAlreadyTj) {
		this.notAlreadyTj = notAlreadyTj;
	}

	public String getIfRequ() {
		return ifRequ;
	}

	public void setIfRequ(String ifRequ) {
		this.ifRequ = ifRequ;
	}



}
