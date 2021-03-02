package com.wisea.cultivar.plant.po.oritrapla;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 枚举类型的传入PO
 *
 * @author wangh(wisea)
 *
 * @date 2018年6月5日
 * @version 1.0
 */
@ApiModel("枚举类型的传入PO")
public class EnumStrPo {

	@ApiModelProperty(value="[sex_type(0:男1:女)](必填)",required=true)
	@Check(test="liveable", liveable={"0","1"})
	private String flag;

	/**
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * @param flag the flag to set
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
}
