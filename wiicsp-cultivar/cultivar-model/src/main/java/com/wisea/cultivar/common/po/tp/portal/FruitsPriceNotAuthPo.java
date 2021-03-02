package com.wisea.cultivar.common.po.tp.portal;

import java.time.OffsetDateTime;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 首页水果价格的展示PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月30日
 * @version 1.0
 */
@ApiModel("首页水果价格的展示PO")
public class FruitsPriceNotAuthPo {

	@ApiModelProperty(value="品类ID")
	@Check(test = "required")
	private Long commPid;

	@ApiModelProperty(value="昨天日期",hidden=true)
	private OffsetDateTime yesterday;

	@ApiModelProperty(value="现在日期",hidden=true)
	private OffsetDateTime nowDate;

	public Long getCommPid() {
		return commPid;
	}

	public void setCommPid(Long commPid) {
		this.commPid = commPid;
	}

	public OffsetDateTime getYesterday() {
		return yesterday;
	}

	public void setYesterday(OffsetDateTime yesterday) {
		this.yesterday = yesterday;
	}

	public OffsetDateTime getNowDate() {
		return nowDate;
	}

	public void setNowDate(OffsetDateTime nowDate) {
		this.nowDate = nowDate;
	}
}
