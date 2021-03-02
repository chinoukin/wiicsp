package com.wisea.cultivar.common.po.tp.portal;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.tp.portal.FruitsPriceInfoVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 水果价格分页列表查询条件PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月30日
 * @version 1.0
 */
@ApiModel("水果价格分页列表查询条件PO")
public class FruitsPricePageListPo extends PagePo<FruitsPriceInfoVo>{

	private static final long serialVersionUID = 5502298118605515420L;

	@ApiModelProperty(value = "商品品类")
	private String commId;

	@ApiModelProperty(value = "商品品类-父节点")
	private String commPid;

	@ApiModelProperty(value = "开始时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime startDate;

    @ApiModelProperty(value = "结束时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime endDate;

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

	public String getCommId() {
		return commId;
	}

	public void setCommId(String commId) {
		this.commId = commId;
	}

	public String getCommPid() {
		return commPid;
	}

	public void setCommPid(String commPid) {
		this.commPid = commPid;
	}
}
