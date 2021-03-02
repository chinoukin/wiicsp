package com.wisea.transac.common.po.memb;

import java.time.OffsetDateTime;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 市场会员增长情况统计PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月29日
 * @version 1.0
 */
@ApiModel("市场会员增长情况统计PO")
public class MarketMembAddTjPo {

	@ApiModelProperty(value="市场ID")
	@Check(test = "required")
	private Long marketId;

	@ApiModelProperty(value="统计区间(0:按月1:按年)默认按月统计")
	private String flag = "0";

	@ApiModelProperty(value = "查询日期（按月格式“2018—12”，按年格式“2018”）日期格式")
	@Check(test = "required", requiredMsg = "查询日期不能为空")
	private String querDate;

	@ApiModelProperty(value="选择的日期",hidden=true)
	private OffsetDateTime selDate;

	@ApiModelProperty(value="查询用-年",hidden=true)
	private Integer year;

	@ApiModelProperty(value="查询用-月",hidden=true)
	private Integer month;


	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public OffsetDateTime getSelDate() {
		return selDate;
	}

	public void setSelDate(OffsetDateTime selDate) {
		this.selDate = selDate;
	}

	public Long getMarketId() {
		return marketId;
	}

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public String getQuerDate() {
		return querDate;
	}

	public void setQuerDate(String querDate) {
		this.querDate = querDate;
	}
}
