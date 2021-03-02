package com.wisea.cultivar.common.po.tp.memb;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cultivar.common.vo.tp.memb.ShopCommSetupListVo;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 根据分类ID查询商品信息PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年12月13日
 * @version 1.0
 */
@ApiModel("根据分类ID查询商品信息PO")
public class ShopCommSetupPagePo extends PagePo<ShopCommSetupListVo> {
    private static final long serialVersionUID = 1L;


    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商品分类id")
    private Long commId;

    @ApiModelProperty(value = "商品名称")
    private String commName;

	public Long getCommId() {
		return commId;
	}

	public void setCommId(Long commId) {
		this.commId = commId;
	}

	public String getCommName() {
		return commName;
	}

	public void setCommName(String commName) {
		this.commName = commName;
	}
}
