package com.wisea.cultivar.common.po.tp.portal;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 图标显示的传入参数PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月29日
 * @version 1.0
 */
@ApiModel("图标显示的传入参数PO")
public class FruitsIndexEchartsPo {

	@ApiModelProperty(value="当前系统时间",hidden = true)
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	private OffsetDateTime nowDate;

	@ApiModelProperty(value="查询用的商品名称",hidden = true)
	private List<String> commNamelist;

	public OffsetDateTime getNowDate() {
		return nowDate;
	}

	public void setNowDate(OffsetDateTime nowDate) {
		this.nowDate = nowDate;
	}

	public List<String> getCommNamelist() {
		return commNamelist;
	}

	public void setCommNamelist(List<String> commNamelist) {
		this.commNamelist = commNamelist;
	}

}
