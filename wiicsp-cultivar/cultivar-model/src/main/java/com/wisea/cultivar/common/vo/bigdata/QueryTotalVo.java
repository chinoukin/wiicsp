package com.wisea.cultivar.common.vo.bigdata;

import io.swagger.annotations.ApiModelProperty;

public class QueryTotalVo {

	@ApiModelProperty(value = "总计订单件数")
	private String ordTotal;
	@ApiModelProperty(value = "24小时达-预警时间轴条数")
	private String qtxsyjTotal;
	@ApiModelProperty(value = "物流监测-冷藏/冷冻车监测条数")
	private String pscarjcTotal;
	@ApiModelProperty(value = "在途车辆总数")
	private String ztclTotal;
	@ApiModelProperty(value = "预警事件条数")
	private String yjTotal;

	public String getOrdTotal() {
		return ordTotal;
	}

	public void setOrdTotal(String ordTotal) {
		this.ordTotal = ordTotal;
	}

	public String getQtxsyjTotal() {
		return qtxsyjTotal;
	}

	public void setQtxsyjTotal(String qtxsyjTotal) {
		this.qtxsyjTotal = qtxsyjTotal;
	}

	public String getPscarjcTotal() {
		return pscarjcTotal;
	}

	public void setPscarjcTotal(String pscarjcTotal) {
		this.pscarjcTotal = pscarjcTotal;
	}

	public String getZtclTotal() {
		return ztclTotal;
	}

	public void setZtclTotal(String ztclTotal) {
		this.ztclTotal = ztclTotal;
	}

	public String getYjTotal() {
		return yjTotal;
	}

	public void setYjTotal(String yjTotal) {
		this.yjTotal = yjTotal;
	}

}
