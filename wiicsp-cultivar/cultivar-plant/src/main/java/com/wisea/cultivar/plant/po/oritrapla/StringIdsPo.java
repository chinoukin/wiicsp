package com.wisea.cultivar.plant.po.oritrapla;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 传入的id列表PO
 *
 * @author wangh(wisea)
 *
 * @date 2018年6月19日
 * @version 1.0
 */
@ApiModel("传入的id列表PO")
public class StringIdsPo {

	@ApiModelProperty("数据IDs")
    @Check(test = "required")
    private List<String> ids;

	/**
	 * @return the ids
	 */
	public List<String> getIds() {
		return ids;
	}

	/**
	 * @param ids the ids to set
	 */
	public void setIds(List<String> ids) {
		this.ids = ids;
	}
}
