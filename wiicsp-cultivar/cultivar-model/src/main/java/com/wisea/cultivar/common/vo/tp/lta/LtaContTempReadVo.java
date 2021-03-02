package com.wisea.cultivar.common.vo.tp.lta;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 拟定长协合同模版初期化VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月24日
 * @version 1.0
 */
@ApiModel("拟定长协合同模版初期化VO")
public class LtaContTempReadVo {

	@ApiModelProperty(value="合同模版内容")
	private String tempContents;
	@ApiModelProperty(value="合同编号")
	private String ltaContNumb;

	public String getTempContents() {
		return tempContents;
	}

	public void setTempContents(String tempContents) {
		this.tempContents = tempContents;
	}

	public String getLtaContNumb() {
		return ltaContNumb;
	}

	public void setLtaContNumb(String ltaContNumb) {
		this.ltaContNumb = ltaContNumb;
	}
}
