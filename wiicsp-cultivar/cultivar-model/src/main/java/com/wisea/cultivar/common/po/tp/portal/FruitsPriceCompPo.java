package com.wisea.cultivar.common.po.tp.portal;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.tp.portal.FruitsPriceCompPageVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 水果价格比较查询PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年6月12日
 * @version 1.0
 */
@ApiModel("水果价格比较查询PO")
public class FruitsPriceCompPo extends PagePo<FruitsPriceCompPageVo>{

	private static final long serialVersionUID = -5720362742489951488L;

	@ApiModelProperty("品类id")
	@JsonSerialize(using = IdSerializer.class)
	private Long commId;

	@ApiModelProperty("品类Pid")
	@JsonSerialize(using = IdSerializer.class)
	private Long commPid;

	@ApiModelProperty("品种id")
	@JsonSerialize(using = IdSerializer.class)
	private Long commVarietId;

	@ApiModelProperty("地区编码")
	private String areaCode;

	@ApiModelProperty("开始时间")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	private OffsetDateTime startDate;

	@ApiModelProperty("结束时间")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	private OffsetDateTime endDate;

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
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

	public Long getCommId() {
		return commId;
	}

	public void setCommId(Long commId) {
		this.commId = commId;
	}

	public Long getCommVarietId() {
		return commVarietId;
	}

	public void setCommVarietId(Long commVarietId) {
		this.commVarietId = commVarietId;
	}

	public Long getCommPid() {
		return commPid;
	}

	public void setCommPid(Long commPid) {
		this.commPid = commPid;
	}

}
