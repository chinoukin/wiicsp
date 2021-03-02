package com.wisea.cultivar.plant.po.oritrapla;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 农事操作类型po
 *
 * @author yangtao
 *
 * @version 1.0
 */
@ApiModel("农事操作类型po")
public class FarmWorkDicPo {

	@Check(test = "logic", logic = "'1'.equals(#isOthType)?#isNotEmpty(#id):true")
    @ApiModelProperty("农事类型ID")
    private Long id;
    @ApiModelProperty("是否是“其他”标识（0是“其他”，1是农事类型，1的时候id必填）")
    @Check(test = "required", regexMsg = "是否是“其他”标识不能为空")
    private String isOthType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIsOthType() {
		return isOthType;
	}

	public void setIsOthType(String isOthType) {
		this.isOthType = isOthType;
	}

}
