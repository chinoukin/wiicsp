package com.wisea.cultivar.plant.po.oritrapla;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 意见反馈的PO
 *
 * @author wangh(wisea)
 *
 * @date 2018年6月11日
 * @version 1.0
 */
@ApiModel("意见反馈的PO")
public class OpinRetroaPo {

	@ApiModelProperty("返回内容")
	@Check(test = "required")
	private String retroaCont;

	/**
	 * @return the retroaCont
	 */
	public String getRetroaCont() {
		return retroaCont;
	}

	/**
	 * @param retroaCont the retroaCont to set
	 */
	public void setRetroaCont(String retroaCont) {
		this.retroaCont = retroaCont;
	}
}
