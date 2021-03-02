package com.wisea.cultivar.common.po.tp.statistics;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.tp.statistics.CommStaticsVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 商品销售情况po
 * @author yangtao
 *
 */
@ApiModel("商品销售情况po")
public class CommStatisTimePo extends PagePo<CommStaticsVo>{

	@ApiModelProperty("查询日期标识，0：最近7天；1：最近30天；2：最近90天。注意：该字段和开始/结束时间互斥")
    @Check(test = "logic", logic = "(#isNotEmpty(#timeStart) || #isNotEmpty(#timeEnd))?#isEmpty(#timeKey):true", logicMsg = "开始时间和结束时间不为空，近几天需要为空")
	private String timeKey;
	@ApiModelProperty(value = "开始时间")
	@Check(test = "logic", logic = "#isNotEmpty(#timeKey) ? #isEmpty(#timeStart) : true", logicMsg = "近几天不为空，开始时间和结束时间需要为空")
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime timeStart;
    @ApiModelProperty(value = "结束时间")
    @Check(test = "logic", logic = "#isNotEmpty(#timeKey) ? #isEmpty(#timeEnd) : true", logicMsg = "近几天不为空，开始时间和结束时间需要为空")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime timeEnd;
    @ApiModelProperty(value = "查询条件查询山系、树林的时候必填，其他时候不用传（山系：0，树龄：1）")
    private String seachkey;
    @ApiModelProperty(value = "查询条件查询热卖商品的时候必填，其他时候不用传（下单金额：0，下单量：1）",hidden = true)
    private String seleckey;
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "卖方ID")
    private Long sellerId;

	public String getTimeKey() {
		return timeKey;
	}
	public void setTimeKey(String timeKey) {
		this.timeKey = timeKey;
	}
	public OffsetDateTime getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(OffsetDateTime timeStart) {
		this.timeStart = timeStart;
	}
	public OffsetDateTime getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(OffsetDateTime timeEnd) {
		this.timeEnd = timeEnd;
	}
	public String getSeachkey() {
		return seachkey;
	}
	public void setSeachkey(String seachkey) {
		this.seachkey = seachkey;
	}
	public String getSeleckey() {
		return seleckey;
	}
	public void setSeleckey(String seleckey) {
		this.seleckey = seleckey;
	}
	public Long getSellerId() {
		return sellerId;
	}
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
}
