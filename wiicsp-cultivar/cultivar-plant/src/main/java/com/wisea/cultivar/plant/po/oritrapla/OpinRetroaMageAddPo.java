package com.wisea.cultivar.plant.po.oritrapla;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("意见反馈添加po")
public class OpinRetroaMageAddPo {

	@ApiModelProperty(value="反馈内容")
	@Check(test = "required")
	private String retroaCont;

	public String getRetroaCont() {
		return retroaCont;
	}

	public void setRetroaCont(String retroaCont) {
		this.retroaCont = retroaCont;
	}

}
