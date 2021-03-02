package com.wisea.cultivar.common.po.tp.memb;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 商家管理查询树结构列表(商家端)PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月30日
 * @version 1.0
 */
@ApiModel("商家管理查询树结构列表(商家端)PO")
public class ShopCmTreeListByMembIdPo {

	@ApiModelProperty("店铺ID不能为空")
    @Check(test = "required")
	private Long membId;

	@ApiModelProperty("请输入分类名称")
	private String catgName;

	@ApiModelProperty(value  = "状态(0:有效1:无效)")
	private String effeInvalState; //商品状态:有效、无效

	public String getCatgName() {
		return catgName;
	}

	public void setCatgName(String catgName) {
		this.catgName = catgName;
	}

	public String getEffeInvalState() {
		return effeInvalState;
	}

	public void setEffeInvalState(String effeInvalState) {
		this.effeInvalState = effeInvalState;
	}

	public Long getMembId() {
		return membId;
	}

	public void setMembId(Long membId) {
		this.membId = membId;
	}

}
