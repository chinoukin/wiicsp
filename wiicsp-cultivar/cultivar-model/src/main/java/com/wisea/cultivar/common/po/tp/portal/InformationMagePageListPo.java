package com.wisea.cultivar.common.po.tp.portal;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.tp.portal.InformationMagePageListVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 后台分页查询资讯信息列表PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月28日
 * @version 1.0
 */
@ApiModel("后台分页查询资讯信息列表PO")
public class InformationMagePageListPo extends PagePo<InformationMagePageListVo> {

	private static final long serialVersionUID = -1123488932363798606L;

	@ApiModelProperty(value = "标题或关键词")
    private String key;

    @ApiModelProperty(value = "所属分类（0:平台公告1:行业资讯2果链动态3价格行情）空为全部")
    private String informationType;

    @ApiModelProperty(value = "发布时间-开始时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime startDate;

    @ApiModelProperty(value = "发布时间-结束时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime endDate;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getInformationType() {
		return informationType;
	}

	public void setInformationType(String informationType) {
		this.informationType = informationType;
	}

	public OffsetDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(OffsetDateTime startDate) {
		this.startDate = startDate;
	}

	public OffsetDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(OffsetDateTime endDate) {
		this.endDate = endDate;
	}
}
